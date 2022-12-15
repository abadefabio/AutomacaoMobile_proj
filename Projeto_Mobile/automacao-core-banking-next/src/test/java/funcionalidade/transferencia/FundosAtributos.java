package funcionalidade.transferencia;

import br.com.next.automacao.core.api.token.crs.TokenCrsApi;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import io.restassured.http.Header;

import static br.com.next.automacao.core.tools.evidencia.OperadorEvidencia.logarPasso;
import static dados.client.portal.massas.PortalMassasClient.getCsrUserId;

public class FundosAtributos {

    /**
     * Retornar o header para requisição dos testes de Validar cliente com fundos suficientes para uma transferência
     *
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
     * Logar passo padrão para um respota de requisição dada
     *
     * @param resposta
     */
    protected void logarPassoResposta(RespostaBase resposta) {
        logarPasso(String.format("Código Retorno: %s\nResposta:\n%s",
                resposta.getResponse().statusCode(),
                resposta.getResponse().asPrettyString()));
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
            throw new Exception("Falha ao realizar login. Retorno Requisição:\n" + respostaToken.getResponse().statusCode()
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
            logarPasso(String.format("Realizando logoff cliente... Código Retorno: %s",
                    tokenCrsApi.logoffTokenCliente(token).getResponse().getStatusCode()));
        }
    }
}
