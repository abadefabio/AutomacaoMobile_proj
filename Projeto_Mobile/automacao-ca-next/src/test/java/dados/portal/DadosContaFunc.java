package dados.portal;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.base.BaseQAFunc;
import dados.base.PortalMassasClient;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;


import java.util.HashMap;

import static dados.base.PortalMassasClient.getCoreIP;
import static io.restassured.RestAssured.given;


public class DadosContaFunc {


    public static void adicionarSaldo(JSONObject arquivoJsonMassa, AddBalanceRequest.AccountTypeEnum tipoConta){
        AddBalanceRequest request = new AddBalanceRequest();
        request.document(arquivoJsonMassa.get("cpf").toString());
        request.setValue("2000.00");
        request.setAccountType(tipoConta);

        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Iniciando criacao de contato");

        try {
            new PortalMassasClient().testDataAccountControllerApi().addBalance(getCoreIP(), request);
        }
        catch (ApiException e) {
            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Não foi possível adicionar saldo na conta: " + tipoConta.getValue() + ", Erro: " + e.getResponseBody());
        }
        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Response criação de adição de saldo: OK");

    }

    public static HashMap<String, String> retornarAgenciaConta(String cpf) {
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

            var retorno = new HashMap<String, String>();
            retorno.put("agencia", BaseQAFunc.replace(jsonPath, "contas.agencia"));
            retorno.put("conta", BaseQAFunc.replace(jsonPath, "contas.conta"));
            retorno.put("digitoConta", BaseQAFunc.replace(jsonPath, "contas.digitoConta"));
            OperadorEvidencia.logarPasso("Recuperado: Agência:[" + retorno.get("agencia") + "] Conta:["
                    + retorno.get("conta") + "-" +  retorno.get("digitoConta") + "] do CPF:[" + cpf +"]");
            return retorno;

        } catch (AssertionError var3) {
            Assert.fail("cpf não é correntista", var3);
            return null;
        }
    }

}
