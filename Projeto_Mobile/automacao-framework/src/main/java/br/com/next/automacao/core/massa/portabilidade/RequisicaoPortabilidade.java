package br.com.next.automacao.core.massa.portabilidade;

import br.com.next.automacao.core.tools.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Reporter;

import static br.com.next.automacao.core.tools.geradores.TokenCrs.getCrsToken;
import static br.com.next.automacao.core.tools.geradores.TokenCrs.logoutTokenCrs;
import static io.restassured.RestAssured.given;

/**
 * Configura a requisição de portabilidade TDM
 *
 * @author Lucas Santos
 * @since 03-2021
 */
public class RequisicaoPortabilidade {
    private static ThreadLocal<ModeloPortabilidade> modeloPortabilidade = null;

    protected static ModeloPortabilidade getModeloPortabilidade() {
        return modeloPortabilidade.get();
    }

    private static void setModeloPortabilidade() {
        if (modeloPortabilidade == null) {
            modeloPortabilidade = new ThreadLocal<ModeloPortabilidade>();
        }
        modeloPortabilidade.set(new ModeloPortabilidade());
    }

    protected static void criarPortabilidade(String cpf, String cnpjPortabilidade, String cpfPortabilidade, int codigoBanco) throws Exception {
        JSONObject requestBody = new JSONObject();
        requestBody.put("payingCompanyCNPJ", cnpjPortabilidade);
        requestBody.put("paymentSourceCPF", cpfPortabilidade);
        requestBody.put("bankCode", codigoBanco);
        requestBody.put("hasUserAcceptedTermsAndConditions", true);

        try {
            Response response = given()
                    .relaxedHTTPSValidation()
                    .header("X-Next-AuthToken", getCrsToken(cpf))
                    .header("Content-Type", "application/json")
                    .body(requestBody.toJSONString())
                    .expect()
                    .statusCode(200)
                    .and()
                    .contentType(ContentType.JSON)
                    .when()
                    .post(ReadProperties.getCaUrl() + "/v1/accounts/salaryAccountPortability")
                    .then()
                    .extract()
                    .response();
            logoutTokenCrs(cpf);
            definirModeloPortabilidade(response);


        } catch (AssertionError | Exception e) {
            Reporter.log("Erro na Criacao da Portabilidade, tente novamente: " + e.getMessage(), true);
        }
    }

    private static void definirModeloPortabilidade(Response response) {
        setModeloPortabilidade();
        getModeloPortabilidade().setDataCriacaoPortabilidade(response.jsonPath().getString("operationDate"));
        getModeloPortabilidade().setCpfPortabilidade(response.jsonPath().getString("employerCpf"));
        getModeloPortabilidade().setCodigoBancoPortabilidade(response.jsonPath().getString("bankCode"));
        getModeloPortabilidade().setNomeBancoPortabilidade(response.jsonPath().getString("bankName"));
        getModeloPortabilidade().setCnpjPortabilidade(response.jsonPath().getString("employerCnpj"));
    }
}
