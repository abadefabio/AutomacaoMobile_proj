package funcionalidade.transferencia;

import br.com.next.automacao.core.api.token.crs.TokenCrsApi;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import io.restassured.http.Header;

import static api.base.LoginApiCorporativa.abrirSessaoApiCorporativa;
import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserId;

public class ListarContatoAtributos {

    /**
     * Retornar o header para requisi��o dos testes de Listar Contatos de Transfer�ncias
     *
     * @param token
     * @return
     */
    protected static Header[] obterHeaderRequisicao(String token) {
        return new Header[]{
                new Header("Content-Type", "application/json"),
                new Header("Accept", "application/json;charset=UTF-8"),
                new Header("X-Next-AuthToken", token)
        };
    }

    /**
     * Retornar o header para requisi��o dos testes de Listar Contatos de Transfer�ncias via Api Corporativa
     *
     * @param token
     * @param cpf
     * @return
     * @throws Exception
     */
    protected Header[] obterHeaderRequisicaoApiCorporativa(String token, String cpf) throws Exception {
        return new Header[]{
                new Header("Content-Type", "application/json"),
                new Header("Accept", "application/json;charset=UTF-8"),
                new Header("X-Next-AuthToken", token),
                new Header("idSessao", abrirSessaoApiCorporativa(cpf, 0)),
                new Header("ticket", abrirSessaoApiCorporativa(cpf, 1)),
                new Header("user", cpf)
        };
    }

    /**
     * Realizar o login configurado no 'tokenCrsApi' retornando o token gerado em caso de sucesso
     *
     * @param tokenCrsApi
     * @return
     * @throws Exception
     */
    protected String loginCliente(TokenCrsApi tokenCrsApi) throws Exception {
        logarPasso(String.format("Realizando login cliente: %s", getCsrUserId()));
        RespostaBase respostaToken = tokenCrsApi.gerarTokenCliente();
        String token = respostaToken.obterJsonPath().get("token");

        if (token != null) {
            logarPasso(String.format("Login realizado com sucesso, token gerado: %s", token));
        } else {
            throw new Exception("Falha ao realizar login. Retorno Requisi��o:\n" + respostaToken.getResponse().statusCode()
                    + "\n" + respostaToken.getResponse().asPrettyString());
        }

        return token;
    }

    /**
     * Realizar o logoff do cliente logado via token
     *
     * @param tokenCrsApi
     * @param token
     * @throws NextException
     */
    protected void logoffCliente(TokenCrsApi tokenCrsApi, String token) throws NextException {
        if (tokenCrsApi != null && token != null) {
            logarPasso(String.format("Realizando logoff cliente... C�digo Retorno: %s",
                    tokenCrsApi.logoffTokenCliente(token).getResponse().getStatusCode()));
        }
    }

    /**
     * Logar passo padr�o para um respota de requisi��o dada
     *
     * @param resposta
     */
    protected void logarPassoResposta(RespostaBase resposta) {
        logarPasso(String.format("C�digo Retorno: %s\nResposta:\n%s",
                resposta.getResponse().statusCode(),
                resposta.getResponse().asPrettyString()));
    }
}

