package dados.base;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.concurrent.Callable;

import static io.restassured.RestAssured.given;

public class BasePortalFunc {

    /**
     * Padroniza a execução de cada requisição para o portal de massa
     *
     * @param nomeRequisicao       objetivo da requisição que será mostrado no log
     * @param parametrosRequisicao parâmetros principais da requisição que serão mostrados  no log
     * @param func                 funcao de requisição retornando o response
     * @return
     */
    protected Object executarPortal(String nomeRequisicao, JSONObject parametrosRequisicao, Callable<Object> func) {
        Object response = null;

        try {
            OperadorEvidencia.logarPasso(String.format("[PORTAL DE MASSA]: Iniciando requisição [%s]%s", nomeRequisicao, parametrosRequisicao.isEmpty() ? "" : " " + parametrosRequisicao));
            response = func.call();
            OperadorEvidencia.logarPasso(String.format("[PORTAL DE MASSA]: Requisição com sucesso! Resposta [%s] - %s", nomeRequisicao, response));
        } catch (ApiException e) {
            var message = e.getResponseBody() != null ? e.getResponseBody() : e.getMessage();
            OperadorEvidencia.logarPasso(String.format("[PORTAL DE MASSA]: Erro ao realizar requisição - %s", message));
        } catch (Exception e2) {
            OperadorEvidencia.logarPasso(String.format("[PORTAL DE MASSA]: Erro ao montar requisição - %s", e2.getMessage()));
        }

        return response;
    }

    /**
     * Retorna a gencia e conta dado o cpf do cliente
     *
     * @param cpf
     * @return
     */
    protected HashMap<String, String> retornarAgenciaConta(String cpf) {
        try {
            JsonPath jsonPath =
                    given()
                            .header("access-token", "wFvPZv4unKWJ")
                            .param("cpf", cpf)
                            .expect()
                            .statusCode(200)
                            .and()
                            .contentType(ContentType.JSON)
                            .when()
                            .get(
                                    ReadProperties.getCoreBankingUrl() + "/v2/cadastros/contas")
                            .andReturn()
                            .jsonPath();

            var retorno = new HashMap<String, String>();

            retorno.put("agencia", obterValorDoAtributo(jsonPath, "contas.agencia"));
            retorno.put("conta", obterValorDoAtributo(jsonPath, "contas.conta"));
            retorno.put("digitoConta", obterValorDoAtributo(jsonPath, "contas.digitoConta"));

            return retorno;
        } catch (AssertionError var3) {
            Assert.fail("cpf nao e correntista", var3);
            return null;
        }
    }

    /**
     * Retorna o valor do atributo dado o jsonPath e o path do atributo
     *
     * @param jsonPath
     * @param path
     * @return
     */
    protected String obterValorDoAtributo(JsonPath jsonPath, String path) {
        return jsonPath.getString(path).replace("[", "").replace("]", "");
    }
}
