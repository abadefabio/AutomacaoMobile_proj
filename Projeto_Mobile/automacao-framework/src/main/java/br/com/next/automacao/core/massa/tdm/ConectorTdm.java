package br.com.next.automacao.core.massa.tdm;

import br.com.next.automacao.core.tools.ReadProperties;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Reporter;

import static io.restassured.RestAssured.given;

public class ConectorTdm {

    private static String tokenTdm;

    private static String login() {
        try {
            return given()
                    .relaxedHTTPSValidation()
                    .auth()
                    .preemptive()
                    .basic(ReadProperties.getFuncionalUser(), ReadProperties.getFuncionalPass())
                    .when()
                    .post(ReadProperties.getTdmUrl() + "/TestDataManager/user/login")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .jsonPath()
                    .getString("token");
        } catch (AssertionError e) {
            Reporter.log("Erro ao pegar token de login TDM: " + e.getMessage(), true);
        }
        return null;
    }

    private static void logout() {
        try {
            JSONObject resquestBody = new JSONObject();
            resquestBody.put("tokenTobeInvalidated", tokenTdm);
            given()
                    .relaxedHTTPSValidation()
                    .accept(ContentType.JSON)
                    .auth()
                    .preemptive()
                    .basic(ReadProperties.getFuncionalUser(), ReadProperties.getFuncionalPass())
                    .body(resquestBody)
                    .when()
                    .put(ReadProperties.getTdmUrl() + "/TestDataManager/user/logout")
                    .then()
                    .statusCode(200);
        } catch (AssertionError e) {
            Reporter.log("Erro ao realizar logou TDM: " + e.getMessage(), true);
        }
    }

    public static String getTokenTdm() {
        if (tokenTdm == null) {
            tokenTdm = login();
        }
        return tokenTdm;
    }

    public static void invalidarTdmToken() {
        if (tokenTdm != null) {
            logout();
        }
    }
}
