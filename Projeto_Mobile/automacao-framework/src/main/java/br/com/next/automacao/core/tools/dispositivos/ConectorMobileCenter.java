package br.com.next.automacao.core.tools.dispositivos;

import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.dispositivos.modelo.Dispositivo;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.testng.Assert;

import java.net.MalformedURLException;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static io.restassured.RestAssured.given;

/**
 * Classe responsável por realizar a chamada ao endpoint do Mobile Center e
 * localizar um dispositivo livre para teste
 *
 * @author Lucas Santos
 * @version 1.1
 * @since 2020-01
 */

public class ConectorMobileCenter {

    private static Dispositivo dispositivo;
    private String uriBase = ReadProperties.getMcUrl();

    /**
     * Retorna o dispositivo livre para execução de teste
     *
     * @return Dispositivo
     */
    public Dispositivo getDispositivo() {
        return dispositivo = selecionarDispositivoLivre(
                getCasoTeste().getParametrosTeste().get("plataforma")
        );
    }

    /**
     * Realiza o login no Mobile Center e retorna o coockie de sessão
     *
     * @return Cookies de sessão logada
     *
     Adequação de segurança inclusão de autenticação via token
     * @author Rodrigo Benedetti
     * @version 4.0.1
     * @Since 2021-12
     * @param "oauthClientId" Token ID Mobile Center
     * @param "oauthClientSecret" Token Pass Mobile Center
     */
    private Cookies login() {
        String requestBody = "{" +
                "\"oauthClientId\": \"" + ReadProperties.getAuthUserId() + "\", " +
                "\"oauthClientSecret\": \"" + ReadProperties.getAuthUserPass() + "\"" +
                "\"tenantId\": \"999999999\"" +
                "}";

        try {
            return given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post(uriBase + "/rest/client/login")
                    .then().statusCode(200)
                    .extract()
                    .response()
                    .getDetailedCookies();
        } catch (AssertionError e) {
            Assert.fail("Não foi possível realizar login no Mobile Center!", e);
        }
        return null;
    }

    /**
     * Faz a chamada o Mobile Center pedindo a lista de dispositivos e
     * retorna a resposta
     *
     * @return Response: objeto de resposta do RestAssured
     */
    private Response capturarRespostaDispositivos() {

        return given()
                .cookies(login())
                .contentType(ContentType.JSON)
                .when()
                .get(uriBase + "/rest/deviceContent");
    }

    /**
     * Realiza a busca por um dispositivo livre dentro da resposta do Mobile Center,
     * obedecendo a plataforma definida no xml de execução do TestNG para o teste
     *
     * @param plataforma iOS/Android
     * @return Dispositivo selecionado para uso
     */
    private Dispositivo selecionarDispositivoLivre(String plataforma) {

        Response response = capturarRespostaDispositivos();
        boolean statusDispositivo = false;
        int i = 0;
        Dispositivo dispositivo = new Dispositivo();

        try {
            do {
                String statusRecuperado = response.jsonPath().getString("currentReservation[" + i + "].status").toLowerCase();
                String plataformaRecuperada = response.jsonPath().getString("platformName[" + i + "]").toLowerCase();
                String conectoraRecuperada = response.jsonPath().getString("connectorName[" + i + "]").toLowerCase();

                if (statusRecuperado.equals("free") && plataformaRecuperada.equals(plataforma) && (conectoraRecuperada.equals("d4255s283e718") || conectoraRecuperada.equals("d4255s283e368") || conectoraRecuperada.equals("d4253s001e011"))) {


                    dispositivo.setPlatformName(response.jsonPath().getString("platformName[" + i + "]"));
                    dispositivo.setDeviceName(response.jsonPath().getString("deviceName[" + i + "]"));
                    dispositivo.setUdid(response.jsonPath().getString("udid[" + i + "]"));


                    statusDispositivo = true;

                } else {
                    i++;
                    statusDispositivo = false;
                }
            } while (!statusDispositivo);
        } catch (NullPointerException e) {
            Assert.fail("NENHUM DISPOSITIVO ENCONTRADO!");
            e.getMessage();
        }
        return dispositivo;
    }
}