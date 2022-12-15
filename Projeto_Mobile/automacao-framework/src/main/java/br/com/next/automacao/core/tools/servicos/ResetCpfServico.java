package br.com.next.automacao.core.tools.servicos;

import br.com.next.automacao.core.api.reset.cpf.ResetCpfApi;
import br.com.next.automacao.core.api.token.crs.TokenCrsApi;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import javax.annotation.Nonnull;
import java.util.Map;
import static java.util.Objects.isNull;

public class ResetCpfServico {

    private String cpf;
    private String uri;
    private String esteira;
    private ResetCpfApi resetCpfApi;
    private TokenCrsApi tokenCrs;
    private String token;

    public ResetCpfServico(@Nonnull String cpf,
                           @Nonnull String uri,
                           @Nonnull String esteira) {
        this.cpf = cpf;
        this.uri = uri;
        this.esteira = esteira;
        this.resetCpfApi = new ResetCpfApi(cpf, uri, esteira);
    }

    /**
     * Gera token do cliente e verifica resposta
     * @return token
     * @throws NextException
     */
    private String gerarTokenCrs(String user, String password) throws NextException {
        logoffTokenCliente();
        this.tokenCrs = new TokenCrsApi(cpf, uri, user, password);
        RespostaBase resposta = tokenCrs.gerarTokenCliente();
        int statusCode = resposta.getResponse().statusCode();
        if (statusCode != 200) {
            OperadorEvidencia.logarPasso(statusCode + "/Token/" + user + ": " +
                    resposta.getResponse().jsonPath().getMap("system").get("code") + " -> " +
                    resposta.getResponse().jsonPath().getMap("system").get("messages"));
            return null;
        }

        return resposta.obterJsonPath().getString("token");
    }

    /**
     * Efetua logoff do token do cliente
     * @throws NextException
     */
    private void logoffTokenCliente() throws NextException {
        if (isNull(token))
            return;
        RespostaBase resposta = tokenCrs.logoffTokenCliente(token);
        token = null;
        int statusCode = resposta.getResponse().statusCode();
        if (statusCode != 200) {
            OperadorEvidencia.logarPasso(statusCode + "/Logoff token: " +
                    resposta.getResponse().jsonPath().getMap("system").get("code") + " -> " +
                    resposta.getResponse().jsonPath().getMap("system").get("messages"));
        }
    }

    /**
     * Efetua o reset do CPF se um token estiver disponível
     * @return boolean (efetuou ou não o reset).
     * @throws NextException
     */
    protected boolean redefinirCpf(String user, String password) throws NextException {

        if (!isNull(token))
            logoffTokenCliente();

        token = gerarTokenCrs(user, password);
        if (isNull(token))
            return false;

        RespostaBase resposta = resetCpfApi.redefinirCpf(token);
        logoffTokenCliente();

        int statusCode = resposta.getResponse().statusCode();
        if (statusCode != 200) {
            OperadorEvidencia.logarPasso(statusCode + "/" + user + "/Erro reset: " +
                    resposta.getResponse().jsonPath().getMap("system").get("messages").toString());
            return false;
        }
        OperadorEvidencia.logarPasso(user + "/Reset OK: " +
                resposta.getResponse().jsonPath().getMap("system").get("messages").toString());
        return true;
    }

    /**
     * Efetua o reset do CPF utilizando os usuários disponíveis até que efetue o reset
     * @return boolean (efetuou ou não o reset com algum dos usuários disponíveis).
     * @throws NextException
     */
    protected boolean redefinirCpfPersistente(Map<String, String> credenciais) throws NextException {

        for (String user : credenciais.keySet()) {
            String password = credenciais.get(user);
            OperadorEvidencia.logarPasso(user + "...");
            if (redefinirCpf(user, password)) {
                return true;
            }
        }
        return false;
    }
}
