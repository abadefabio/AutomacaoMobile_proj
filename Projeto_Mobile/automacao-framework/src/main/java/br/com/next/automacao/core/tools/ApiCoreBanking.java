package br.com.next.automacao.core.tools;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class ApiCoreBanking {

    /**
     * Retorna um Array com Agencia e Conta do Cliente
     *
     * @param cpf
     * @author Rodrigo Benedetti
     * @since 2020-11
     * M�todo ser� descontinuado, utilizar a nova requisi��o da classe ConsultaConta
     */
    @Deprecated
    public static String[] retornarAgenciaConta(String cpf) {
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
                            .get(ReadProperties.getCoreBankingUrl() + "/v2/cadastros/contas")
                            .andReturn()
                            .jsonPath();

            String retorno[] = new String[2];

            retorno[0] = jsonPath.getString("contas.agencia").replace("[", "").replace("]", "");
            retorno[1] = jsonPath.getString("contas.conta").replace("[", "").replace("]", "");

            return retorno;
        } catch (AssertionError error) {
            Assert.fail("cpf n�o � correntista", error);
        }
        return null;
    }

    /**
     * Retorna o n�mero do cart�o de d�bito e data de validade do cliente
     *
     * @param agencia
     * @param conta
     * @author Rodrigo Benedetti
     * @since 2020-11
     */

    public static String[] retornaDadosDoCartaoDebito(String agencia, String conta) {
        try {
            JsonPath jsonPath = given()
                    .header("access-token", "wFvPZv4unKWJ")
                    .param("agencia", agencia)
                    .param("conta", conta)
                    .param("tipoConta", "00")
                    .expect()
                    .statusCode(200)
                    .and()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ReadProperties.getCoreBankingUrl() + "/v2/cartoes/debito/detalhes")
                    .andReturn()
                    .jsonPath();

            String retorno[] = new String[2];

            retorno[0] = jsonPath.getString("cartoes.numeroCartao").replace("[", "").replace("]", "");
            retorno[1] = jsonPath.getString("cartoes.validadeCartao").replace("[", "").replace("]", "");

            return retorno;
        } catch (AssertionError error) {
            Assert.fail("N�o foi poss�vel capturar os dados do cart�o de debito", error);
        }
        return null;
    }

    /**
     * Faz o desbloqueio do cart�o de debito do cliente diretamente na API
     *
     * @param agencia
     * @param conta
     * @author Rodrigo Benedetti
     * @since 2020-11
     */
    public static String[] desbloquearCartaoDebito(String agencia, String conta, String numeroCartao, String validadeCartao) {
        JSONObject requestBody = new JSONObject();

        requestBody.put("agencia", agencia);
        requestBody.put("conta", conta);
        requestBody.put("tipoConta", "00");
        requestBody.put("numeroCartao", numeroCartao);
        requestBody.put("viaCartao", "1");
        requestBody.put("validadeCartao", validadeCartao);
        requestBody.put("midia", "515");
        requestBody.put("usuario", "0");
        try {
            Response response = given().
                    header("access-token", "wFvPZv4unKWJ").
                    header("Content-Type", "application/json").
                    header("cache-control", "no-cache").
                    body(requestBody.toJSONString()).
                    expect().
                    statusCode(200).
                    and().
                    statusCode(422).
                    and().
                    contentType(ContentType.JSON).
                    when().
                    put(ReadProperties.getCoreBankingUrl() + "/v2/cartoes/debito/desbloqueio");

        } catch (AssertionError error) {
            Assert.fail("Dados do cart�o invalido", error);
        }
        return null;
    }

    /**
     * Faz o desbloqueio do cart�o de credito do cliente diretamente na API
     *
     * @param agencia
     * @param conta
     * @author Rodrigo Benedetti
     * @since 2020-11
     */
    public static String[] desbloquearCartaoCredito(String agencia, String conta, String numeroCartao, String validadeCartao) {
        JSONObject requestBody = new JSONObject();

        requestBody.put("agencia", agencia);
        requestBody.put("conta", conta);
        requestBody.put("tipoConta", "00");
        requestBody.put("numeroCartao", numeroCartao);
        requestBody.put("viaCartao", "1");
        requestBody.put("validadeCartao", validadeCartao);
        requestBody.put("midia", "515");
        requestBody.put("usuario", "0");
        try {
            Response response = given().
                    header("access-token", "wFvPZv4unKWJ").
                    header("Content-Type", "application/json").
                    header("cache-control", "no-cache").
                    body(requestBody.toJSONString()).
                    expect().
                    statusCode(200).
                    and().
                    statusCode(422).
                    and().
                    contentType(ContentType.JSON).
                    when().
                    put(ReadProperties.getCoreBankingUrl() + "/v2/cartoes/credito/desbloqueio");

        } catch (AssertionError error) {
            Assert.fail("Dados do cart�o invalido", error);
        }
        return null;
    }
}