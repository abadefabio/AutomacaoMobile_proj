package br.com.next.automacao.core.tools.geradores;

import br.com.next.automacao.core.tools.ReadProperties;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class TokenCrs {

    private static String token;
    private static JSONObject corpoRequisicao;
    private static final String URL = ReadProperties.getCaUrl();

    /**
     * Realiza a captura do token para o reset
     *
     * @param corpoRequisicao Corpo JSON para requisicao
     */
    private static String gerarTokenCliente(JSONObject corpoRequisicao) {
        try {
            return given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.TEXT)
                    .header("channel", "MNCC")
                    .body(corpoRequisicao.toJSONString())
                    .expect()
                    .statusCode(200)
                    .when()
                    .post(URL + "/v1/login/csr")
                    .then()
                    .extract().response()
                    .jsonPath()
                    .getString("token");
        } catch (Exception e) {
            Assert.fail("*********Verificar usuario, senha e URL da Moldura (moldura.pass)**********", e);
        }
        return null;
    }

    /**
     * Faz logoff no token gerado
     *
     * @param corpoRequisicao Corpo JSON da requisicao de logoff
     */
    private static void logoffTokenCliente(JSONObject corpoRequisicao) {
        try {
            given()
                    .relaxedHTTPSValidation()
                    .header("Authorization", "Basic ZGV2OmNhcGNv")
                    .header("X-Next-AuthToken", token)
                    .contentType("application/json")
                    .body(corpoRequisicao.toJSONString())
                    .when()
                    .post(URL + "/v1/logoff/csr");
        } catch (Exception e) {
            Assert.fail("*********Verificar usuario, senha e URL da Moldura (moldura.pass)**********", e);
        }
    }

    private static JSONObject montarCorpoRequisicao(String cpf) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("agentId", ReadProperties.getEmuladorUser());
        requestBody.put("cpf", cpf);
        requestBody.put("password", ReadProperties.getEmuladorPass());
        requestBody.put("csrUserId", ReadProperties.getEmuladorUser());
        requestBody.put("host", "D4253E0227");
        requestBody.put("ticketId", "1235656");

        return requestBody;
    }

    public static String getCrsToken(String cpf) {
        if (token == null) {
            if (corpoRequisicao == null) {
                corpoRequisicao = montarCorpoRequisicao(cpf);
            }
            return token = gerarTokenCliente(corpoRequisicao);
        } else {
            return token;
        }
    }

    public static void logoutTokenCrs(String cpf) {
        if (token != null) {
            if (corpoRequisicao == null) {
                corpoRequisicao = montarCorpoRequisicao(cpf);
            }
            logoffTokenCliente(corpoRequisicao);
        }
    }
}
