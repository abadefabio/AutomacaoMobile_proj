package dados.portal;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.AddInvalidCpfRequest;
import br.com.bradesco.next.test.data.provider.client.model.AddInvalidCpfResponse;
import br.com.bradesco.next.test.data.provider.client.model.AvailableCustomerOnboardingJoyMultibankResponse;
import br.com.bradesco.next.test.data.provider.client.model.CreateCustomOnboardingJoyMultibankRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingJoyMultibankRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingJoyMultibankResponse;
import br.com.bradesco.next.test.data.provider.client.model.GetAvailableCustomerOnboardingJoyMultibankRequest;
import br.com.bradesco.next.test.data.provider.client.model.GetAvailableCustomerOnboardingJoyMultibankResponse;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import dados.base.PortalMassasClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.util.Collections;
import java.util.List;

import static dados.base.PortalMassasClient.*;
import static dados.utils.PortalMassasUtil.alterPropertiesJsonObject;
import static dados.utils.PortalMassasUtil.convertResponseJsonObject;
import static java.util.Objects.isNull;

public class IntegracaoDeDadosJoyMultibancoFunc {

    /**
     * Create Custom Onboarding Joy Multibank Request
     * @param requestJson
     * @return CreateCustomOnboardingJoyMultibankRequest
     */
    private static CreateCustomOnboardingJoyMultibankRequest createCustomOnboardingJoyMultibankRequest(JSONObject requestJson) {
        var customOnboardingRequest = new CreateCustomOnboardingJoyMultibankRequest();

        customOnboardingRequest.setAddressAdditionalInfo("addressAdditionalInfo");
        customOnboardingRequest.setBirthDate((String)requestJson.get("birthdate"));
        customOnboardingRequest.setBirthPlace((String)requestJson.get("birthPlace"));
        customOnboardingRequest.setCityId(String.valueOf(requestJson.get("cityId")));
        customOnboardingRequest.setCityOfBirthId(String.valueOf(requestJson.get("cityOfBirthId")));
        customOnboardingRequest.setCountryOfBirthId(String.valueOf(requestJson.get("countryOfBirthId")));
        customOnboardingRequest.setCustomerName((String)requestJson.get("customerName"));
        customOnboardingRequest.setDeviceId((String)requestJson.get("deviceId"));
        customOnboardingRequest.setDocument(String.valueOf(requestJson.get("document")));
        customOnboardingRequest.setEmail((String)requestJson.get("email"));
        customOnboardingRequest.setHashId((String)requestJson.get("hashId"));
        customOnboardingRequest.setMobileAreaCode(String.valueOf(requestJson.get("mobileAreaCode")));
        customOnboardingRequest.setMobilePhoneNumber(String.valueOf(requestJson.get("mobilePhoneNumber")));
        customOnboardingRequest.setNeighbourhood((String)requestJson.get("neighbourhood"));
        customOnboardingRequest.setPostalCode(String.valueOf(requestJson.get("postalCode")));
        customOnboardingRequest.setRelationshipDegreeId(String.valueOf(requestJson.get("relationshipDegreeId")));
        customOnboardingRequest.setRgId(String.valueOf(requestJson.get("rgId")));
        customOnboardingRequest.setStateCd((String)requestJson.get("stateCd"));
        customOnboardingRequest.setStateOfBirth(String.valueOf(requestJson.get("stateOfBirth")));
        customOnboardingRequest.setStreetName((String)requestJson.get("streetName"));
        customOnboardingRequest.setStreetNumber(String.valueOf(requestJson.get("streetNumber")));

        return customOnboardingRequest;
    }

    /**
     * M�todo para realizar uma ades�o multibanco padr�o.
     * Se houver erro e for relacionado � qualidade da massa, esta ser� marcada como inv�lida
     * e n�o ser� retornada mais nas pesquisas de CPF de respons�vel: encontrarCpfsMultibancoAdesaoJoy()
     * @param customer
     * @param arquivoJson
     * @return JSONObject
     */
    public JSONObject createOnboardingJoyMultibank(AvailableCustomerOnboardingJoyMultibankResponse customer, JSONObject arquivoJson) {

        String cpf = customer.getCpf();
        int digitos = cpf.length();
        int size = 11;

        if(digitos < size){
            cpf = String.format("%011d",Integer.parseInt(cpf));
        }

        CreateOnboardingJoyMultibankRequest body = new CreateOnboardingJoyMultibankRequest();
        body.setDeviceId(customer.getCustomerIdResponsavel());
        body.setDocument(cpf);
        body.setHashId(customer.getIdCustomerResponsavel());

        CreateOnboardingJoyMultibankResponse response = null;
        try {
          response = new PortalMassasClient()
                    .testDataOnboardingJoyMultibankControllerApi()
                    .createOnboardingJoyMultibank(getCoreIP(),
                            getEsteira(),
                            getCsrUserId(),
                            getCsrUserPassword(),
                            body);
        }
        catch (Exception e) {
            return null;
        }

        OperadorEvidencia.logarPasso(String.format("[PORTAL DE MASSA]: Massa adesao response: %s", response));

        JSONObject onboardingResponseJson = null;
        try {
            onboardingResponseJson = convertResponseJsonObject(response);
        }
        catch (JsonProcessingException | ParseException e) {
            return null;
        }
        return alterPropertiesJsonObject(onboardingResponseJson, arquivoJson);
    }

    /**
     * Cria 1 �nica ades�o multibanco a partir de uma lista de CPFs de respons�vel.
     * Se n�o conseguir criar a ades�o, retorna null, que ser� tratado pelo m�todo chamador.
     * Antes, por�m, avalia o erro e marca a massa como inv�lida se o problema for com a qualidade da massa original multibanco.
     * @param customers
     * @param arquivoJson
     * @return JSONObject
     */
    public JSONObject createOnboardingJoyMultibankList(List<AvailableCustomerOnboardingJoyMultibankResponse> customers, JSONObject arquivoJson) {
        Collections.shuffle(customers); // embaralhar para termos um CPF aleat�rio.
        boolean sucessoCpfResponsavelValido = false;
        while (!sucessoCpfResponsavelValido) {
            for (AvailableCustomerOnboardingJoyMultibankResponse responseCpf : customers) {
                arquivoJson = createOnboardingJoyMultibank(responseCpf, arquivoJson);
                if (!isNull(arquivoJson)) {
                    sucessoCpfResponsavelValido = true;
                    break;
                }
            }
        }
        return arquivoJson;
    }


    /**
     * M�todo que retorna uma lista de respostas com CPFs de respons�vel Bradesco.
     * Uso t�pico: desta lista, escolhe-se 1 CPF para utilizar como respons�vel numa ades�o multibanco do dependente.
     * @param minDependentesAtuais
     * @param maxDependentesAtuais
     * @param maxCpfsResponsaveis
     * @return List<AvailableCustomerOnboardingJoyMultibankResponse>
     */
    public List<AvailableCustomerOnboardingJoyMultibankResponse> encontrarCpfsMultibancoAdesaoJoy(int minDependentesAtuais, int maxDependentesAtuais, int maxCpfsResponsaveis) {
        var body = new GetAvailableCustomerOnboardingJoyMultibankRequest();
        body.setMaxDependent(maxDependentesAtuais);
        body.setMinDependent(minDependentesAtuais);
        body.setTotalCustomers(maxCpfsResponsaveis);
        GetAvailableCustomerOnboardingJoyMultibankResponse response = null;
        try {
           response = new PortalMassasClient()
                    .testDataOnboardingJoyMultibankControllerApi()
                    .findAvailableCustomerJoyMultibank(getCoreIP(),
                            getEsteira(),
                            body);
        }
        catch (Exception ignored) {
            return null;
        }
        return response.getCustomers();
    }

    /**
     * Marcar Massa Invalida Cpf Responsavel Multibanco
     * @param cpf
     * @param apie
     */
    private void marcarMassaInvalidaCpfResponsavelMultibanco(String cpf, ApiException apie) {
        boolean marcarMassaInvalida = false;
        String cause = null;
        String responseBody = apie.getResponseBody();
        if (responseBody.contains("NEXT-PROFILE_ERROR_103") && responseBody.contains("situa��o inv�lida")) {
            marcarMassaInvalida = true;
            cause = "NEXT-PROFILE_ERROR_103\n" + responseBody;
        } else if (responseBody.contains("TEST-DATA-PROVIDER_ERROR_02") && responseBody.contains("dados n�o atendem")) {
            marcarMassaInvalida = true;
            cause = "TEST-DATA-PROVIDER_ERROR_02\n" + responseBody;
        }
        if (!marcarMassaInvalida) {
            System.out.println("*** UMA SITUA��O DE MASSA INV�LIDA N�O PREVISTA ACONTECEU \n" +
                    "OU OUTRO ERRO NA GERA��O DE MASSA (AMBIENTE). POR FAVOR, REPASSE O LOG COM A RESPOSTA DA REQUISI��O\n" +
                    "PARA O QA CHAPTERS OU OS MANTENEDORES DO SCRIPT PARA INCLUS�O DA VERIFICA��O DESTA CONDI��O \n" +
                    "SE ACREDITA QUE ESTE ERRO N�O � DE AMBIENTE, MAS SIM, DA CONDI��O DA MASSA.\n");
            System.out.println(responseBody);
        }

        if (marcarMassaInvalida) {
            // chamar fun��o do portal para marcar massa Bradesco multibanco como inv�lida
            // usando o cpf recebido por par�metro.
            var body = new AddInvalidCpfRequest();
            body.setDocument(cpf);
            body.cause(cause);

            AddInvalidCpfResponse response = null;
            try {
                response = new PortalMassasClient()
                        .testDataOnboardingJoyMultibankControllerApi()
                        .addInvalidCpf(getCoreIP(),
                                getEsteira(),
                                body);
            } catch (ApiException ignored) {

            }
        }
    }

    public JSONObject preparaMassaCriarListaMultibancoPersonalizadaJoy(JSONObject arquivoJson) throws Exception {

        List<AvailableCustomerOnboardingJoyMultibankResponse> listaCpfsResponsaveis;
        try {
            int minDependentesAtuais = Integer.parseInt((String) arquivoJson.get("minDependentesAtuais"));
            int maxDependentesAtuais = Integer.parseInt((String) arquivoJson.get("maxDependentesAtuais"));
            listaCpfsResponsaveis = encontrarCpfsMultibancoAdesaoJoy(minDependentesAtuais, maxDependentesAtuais, 9999);
        }
        catch (Exception e){
            OperadorEvidencia.logarPasso("N�o foi poss�vel obter uma lista de CPFs de respons�vel Bradesco.");
            throw new Exception(e.getMessage());
        }
        return createOnboardingJoyMultibankList(listaCpfsResponsaveis, arquivoJson);
    }

}
