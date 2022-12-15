package br.com.next.automacao.core.massa.conta;

import br.com.next.automacao.core.massa.portabilidade.ModeloPortabilidade;
import br.com.next.automacao.core.tools.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Reporter;

import static br.com.next.automacao.core.tools.geradores.TokenCrs.getCrsToken;
import static br.com.next.automacao.core.tools.geradores.TokenCrs.logoutTokenCrs;
import static io.restassured.RestAssured.given;

/**
 * Configura a requisição de consulta conta
 *
 * @author Rodrigo Benedetti
 * @since 04/2022
 */
public class RequisicaoConta {
    private static ThreadLocal<ModeloConta> modeloConta = null;

    protected static ModeloConta getModeloConta() {
        return modeloConta.get();
    }

    private static void setModeloConta() {
        if (modeloConta == null) {
            modeloConta = new ThreadLocal<ModeloConta>();
        }
        modeloConta.set(new ModeloConta());
    }

    protected static void consultaDadosConta(String cpf) throws Exception {
        try {
            Response response = given()
                    .header("access-token", "wFvPZv4unKWJ")
                    .header("Content-Type", "application/json")
                    .param("cpf", cpf)
                    .expect()
                    .statusCode(200)
                    .and()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ReadProperties.getCoreBankingUrl() + "/v2/cadastros/contas")
                    .then()
                    .extract()
                    .response();
            definirModeloConta(response);


        } catch (AssertionError | Exception e) {
            Reporter.log("Erro na consulta dos Dados da Conta, tente novamente: " + e.getMessage(), true);
        }
    }

    protected static void definirModeloConta(Response response) {
        setModeloConta();
        getModeloConta().setClub(response.jsonPath().getString("contas.club").replaceAll("[^0-9]",""));
        getModeloConta().setDataAbertura(response.jsonPath().getString("contas.dataAbertura").replaceAll("[^0-9]",""));
        getModeloConta().setIndicadorEncerramento(response.jsonPath().getString("contas.indicadorEncerramento").replaceAll("[^0-9]",""));
        getModeloConta().setAgencia(response.jsonPath().getString("contas.agencia").replaceAll("[^0-9]",""));
        getModeloConta().setDigitoAgencia(response.jsonPath().getString("contas.digitoAgencia").replaceAll("[^0-9]",""));
        getModeloConta().setConta(response.jsonPath().getString("contas.conta").replaceAll("[^0-9]",""));
        getModeloConta().setDigitoConta(response.jsonPath().getString("contas.digitoConta").replaceAll("[^0-9]",""));
        getModeloConta().setRazaoSgrp(response.jsonPath().getString("contas.razaoSGRP").replaceAll("[^0-9]",""));
        getModeloConta().setRazaoCgrp(response.jsonPath().getString("contas.razaoCGRP").replaceAll("[^0-9]",""));
    }
}
