package br.com.next.automacao.core.massa.contato;

import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.Utilitarios;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;

import static br.com.next.automacao.core.tools.geradores.TokenCrs.getCrsToken;
import static br.com.next.automacao.core.tools.geradores.TokenCrs.logoutTokenCrs;
import static io.restassured.RestAssured.given;

/**
 * Criar contatos para funcionalidade transferencia e vaquinha*
 *
 * @author Rodrigo Benedetti
 * @since 2021-04
 */

public class RequisicaoContato {
    private static ThreadLocal<ModeloContato> modeloContato = null;

    protected static ModeloContato getModeloContato() {
        return modeloContato.get();
    }

    private static void setModeloContato() {
        if (modeloContato == null) {
            modeloContato = new ThreadLocal<ModeloContato>();
        }
        modeloContato.set(new ModeloContato());
    }

    protected static String[] requestCriarContato(String cpf, int banco, String agencia, String conta, String email) throws Exception {

        JSONArray listaInstitutionalAccounts = new JSONArray();
        JSONArray listaAccounts = new JSONArray();
        JSONObject corpoAccounts = new JSONObject();

        corpoAccounts.put("bank", banco);
        corpoAccounts.put("branch", agencia);
        corpoAccounts.put("fullLegalName", Utilitarios.geradorNomeCompleto(10, 10));
        corpoAccounts.put("accountNumber", conta);
        corpoAccounts.put("isRegistered", true);
        corpoAccounts.put("uniqueID", 0);
        listaAccounts.add(corpoAccounts);

        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "AUTOMACAO");
        requestBody.put("surname", Utilitarios.gerarNomeAleatorio());
        requestBody.put("email", email);
        requestBody.put("phoneNumber", Utilitarios.gerarNumeroCelular());
        requestBody.put("areaCode", 11);
        requestBody.put("countryCode", 55);
        requestBody.put("accounts", listaAccounts);
        requestBody.put("institutionalAccounts", listaInstitutionalAccounts);
        requestBody.put("cpfCnpj", Utilitarios.gerarCpf());
        requestBody.put("cpfCnpjType", "F");
        try {
            Response response =
                    given().
                            relaxedHTTPSValidation().
                            header("X-Next-AuthToken", getCrsToken(cpf)).
                            header("Content-Type", "application/json").
                            header("cache-control", "no-cache").
                            body(requestBody.toJSONString()).
                            expect().
                            statusCode(201).
                            and().
                            contentType(ContentType.JSON).
                            when().
                            post(ReadProperties.getCaUrl() + "/v1/contacts")
                            .then()
                            .extract()
                            .response();
            logoutTokenCrs(cpf);
            definirModeloContato(response);
        } catch (AssertionError error) {

            Assert.fail("Erro na criação do contato", error);
        }
        return null;
    }

    private static void definirModeloContato(Response response) {
        setModeloContato();
        getModeloContato().setNomeContato(response.jsonPath().getString("contact.name"));
        getModeloContato().setSobrenomeContato(response.jsonPath().getString("contact.surname"));
        getModeloContato().setCpfContato(response.jsonPath().getString("contact.cpfCnpj"));
        getModeloContato().setDddCelularContato(response.jsonPath().getString("contact.countryCode"));
        getModeloContato().setNumeroCelularContato(response.jsonPath().getString("contact.phoneNumber"));
        getModeloContato().setCodigoBancoContato(response.jsonPath().getString("contact.accounts.bank"));
        getModeloContato().setAgenciaBancoContato(response.jsonPath().getString("contact.accounts.branch"));
        getModeloContato().setContaBancoContato(response.jsonPath().getString("contact.accounts.accountNumber"));
    }


}