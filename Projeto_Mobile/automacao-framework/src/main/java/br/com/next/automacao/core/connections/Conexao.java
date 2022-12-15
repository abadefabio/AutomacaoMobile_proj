package br.com.next.automacao.core.connections;

import br.com.next.automacao.core.connections.mobileCenter.CredentialMobileCenter;
import br.com.next.automacao.core.tools.configuracao.jpanel.ConfigurationPanel;
import com.google.gson.Gson;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.net.MalformedURLException;
import java.util.Map;

import static br.com.next.automacao.core.tools.ReadProperties.getMcUrl;
import static io.restassured.RestAssured.given;


/**
 * A class conexão contem:
 * Login mobile center
 * Login do Jira
 * Exclusão token AUTOMACAO E2E
 * Busca de credenciais do mobile center
 * Geração de um novo token do mobile center
 * Validação do token do mobile center
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */

public class Conexao {

    public static Response login(String requestBody, String uriBase) {

        return given()
                .config(RestAssuredConfig.newConfig().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(uriBase)
                .then().statusCode(200)
                .extract()
                .response();
    }

    public static Response geraTokenMobileCenter(Map<String, String> headers, Cookies cookies) {

        var credentialMobileCenter = new CredentialMobileCenter("AUTOMACAO E2E", "AUTOMACAO E2E", "EXECUTION");
        var bodyCredentials = new Gson().toJson(credentialMobileCenter);

        Response result = null;
        result = given()
                .config(RestAssuredConfig.newConfig()
                        .sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON)
                .headers(headers)
                .cookies(cookies)
                .body(bodyCredentials)
                .post(getMcUrl() + "/rest/oauth2/credentials")
                .then().statusCode(200)
                .extract()
                .response();


        ConfigurationPanel.popupTextArea(result.getBody().print().replace(",", "\n"), "Token");

        return result;
    }

    public static Response buscaCredentialsMobileCenter(Map<String, String> headers, Cookies cookies) {

        return given()
                .config(RestAssuredConfig.newConfig()
                        .sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON)
                .headers(headers)
                .cookies(cookies)
                .get(getMcUrl() + "/rest/oauth2/credentials")
                .then().statusCode(200)
                .extract()
                .response();

    }

    public static Response validaTokenMobileCenter(Map<String, String> headers, Cookies cookies, String requestBody) {

        Response result = null;
        result = given()
                .config(RestAssuredConfig.newConfig()
                        .sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON)
                .headers(headers)
                .cookies(cookies)
                .body(requestBody)
                .post(getMcUrl() + "/rest/oauth2/token")
                .then().statusCode(200)
                .extract()
                .response();

        ConfigurationPanel.popupInformation("Token validado com sucesso, JSESSIONID:  \n" +
                result.getDetailedCookies().get("JSESSIONID"), "", 7000);

        return result;
    }

    public static void deleteTokenMobileCenter(Map<String, String> headers, Cookies cookies, String clientId) {

        given()
                .config(RestAssuredConfig.newConfig()
                        .sslConfig(new SSLConfig().relaxedHTTPSValidation()))
                .contentType(ContentType.JSON)
                .headers(headers)
                .cookies(cookies)
                .delete(getMcUrl() + "/rest/oauth2/credentials/" + clientId)
                .then().statusCode(204)
                .extract()
                .response();
    }
}