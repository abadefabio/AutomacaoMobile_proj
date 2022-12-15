package dados.portal;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.CreateCustomOnboardingJoyRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateCustomOnboardingJoySegregatedRequest;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import dados.base.PortalMassasClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import static dados.base.PortalMassasClient.getCoreIP;
import static dados.base.PortalMassasClient.getCsrUserId;
import static dados.base.PortalMassasClient.getCsrUserPassword;
import static dados.base.PortalMassasClient.getEsteira;
import static dados.utils.PortalMassasUtil.alterPropertiesJsonObject;
import static dados.utils.PortalMassasUtil.convertResponseJsonObject;

public class IntegracaoDeDadosJoyFunc {

    /**
     * Método responsável por preencher as informações do body da request do onboarding joy
     *
     * @param requestJson Objeto do tipo json que contêm as informações necessárias para preenchimento do body da request
     * @return JSONObject
     */
    private CreateCustomOnboardingJoyRequest criarAdesaoPersonalizadaJoyRequest(JSONObject requestJson) {
        var customOnboardingRequest = new CreateCustomOnboardingJoyRequest();

        customOnboardingRequest.setAddressAdditionalInfo((String)requestJson.get("addressAdditionalInfo"));
        customOnboardingRequest.setAreaCode(String.valueOf(requestJson.get("areaCode")));
        customOnboardingRequest.setBirthPlace((String)requestJson.get("birthPlace"));
        customOnboardingRequest.setBirthdate((String)requestJson.get("birthdate"));
        customOnboardingRequest.setCityId(String.valueOf(requestJson.get("cityId")));
        customOnboardingRequest.setCityOfBirthId(String.valueOf(requestJson.get("cityOfBirthId")));
        customOnboardingRequest.setCompleteTutorial((Boolean) requestJson.get("completeTutorial"));
        customOnboardingRequest.setCompleteTutorialJoy((Boolean) requestJson.get("completeTutorialJoy"));
        customOnboardingRequest.setCountryOfBirth(String.valueOf(requestJson.get("countryOfBirth")));
        customOnboardingRequest.setCustomerName((String)requestJson.get("customerName"));
        customOnboardingRequest.setDocumentIssueDate((String)requestJson.get("documentIssueDate"));
        customOnboardingRequest.setDocumentIssuerDepartment((String)requestJson.get("documentIssuerDepartment"));
        customOnboardingRequest.setDocumentIssuerStateId(String.valueOf(requestJson.get("documentIssuerStateId")));
        customOnboardingRequest.setEduCompletionDt((String)requestJson.get("eduCompletionDt"));
        customOnboardingRequest.setEduCurrentSemester(String.valueOf(requestJson.get("eduCurrentSemester")));
        customOnboardingRequest.setEduInstitutionName((String)requestJson.get("eduInstitutionName"));
        customOnboardingRequest.setEduInstitutionStateCd((String)requestJson.get("eduInstitutionStateCd"));
        customOnboardingRequest.setEducationInstitutionStateId((String)requestJson.get("educationInstitutionStateId"));
        customOnboardingRequest.setEmail((String)requestJson.get("email"));
        customOnboardingRequest.setFatherName((String)requestJson.get("fatherName"));
        customOnboardingRequest.setGender((String)requestJson.get("gender"));
        customOnboardingRequest.setJoinDocumentType(CreateCustomOnboardingJoyRequest.JoinDocumentTypeEnum.RG);
        customOnboardingRequest.setMotherName((String)requestJson.get("motherName"));
        customOnboardingRequest.setNeighbourhood((String)requestJson.get("neighbourhood"));
        customOnboardingRequest.setNickname((String)requestJson.get("nickname"));
        customOnboardingRequest.setOnboardingApplicationStatus(Math.toIntExact((Long) requestJson.get("onboardingApplicationStatus")));
        customOnboardingRequest.setOnboardingApplicationStatusJoy(Math.toIntExact((Long) requestJson.get("onboardingApplicationStatusJoy")));
        customOnboardingRequest.setPhoneNumber(String.valueOf(requestJson.get("phoneNumber")));
        customOnboardingRequest.setPostalCode(String.valueOf(requestJson.get("postalCode")));
        customOnboardingRequest.setReferencePersonName((String)requestJson.get("referencePersonName"));
        customOnboardingRequest.setRelationshipDegreeId(String.valueOf(requestJson.get("relationshipDegreeId")));
        customOnboardingRequest.setRgId(String.valueOf(requestJson.get("rgId")));
        customOnboardingRequest.setShouldActivate((Boolean) requestJson.get("shouldActivate"));
        customOnboardingRequest.setShouldActivateJoy((Boolean) requestJson.get("shouldActivateJoy"));
        customOnboardingRequest.setStateCd((String)requestJson.get("stateCd"));
        customOnboardingRequest.setStateOfBirth(String.valueOf(requestJson.get("stateOfBirth")));
        customOnboardingRequest.setStreetName((String)requestJson.get("streetName"));
        customOnboardingRequest.setStreetNumber(String.valueOf(requestJson.get("streetNumber")));

        return customOnboardingRequest;
    }

    /**
     * Método responsável por preencher as informações do body da request do onboarding joy segregada
     *
     * @param requestJson Objeto do tipo json que contêm as informações necessárias para preenchimento do body da request
     * @return JSONObject
     */
    private CreateCustomOnboardingJoySegregatedRequest criarAdesaoPersonalizadaJoySegregadoRequest(JSONObject requestJson) {
        var customOnboardingRequest = new CreateCustomOnboardingJoySegregatedRequest();

        customOnboardingRequest.setAddressAdditionalInfoDependente((String) requestJson.get("addressAdditionalInfoDependente"));
        customOnboardingRequest.setAreaCodeDependente((String) requestJson.get("areaCodeDependente"));
        customOnboardingRequest.setBirthdayDependente((String) requestJson.get("birthdayDependente"));
        customOnboardingRequest.setCityIdDependente(String.valueOf(requestJson.get("cityIdDependente")));
        customOnboardingRequest.setCityOfBirthId(String.valueOf(requestJson.get("cityOfBirthId")));
        customOnboardingRequest.setCityOfBirthIdDependente(String.valueOf(requestJson.get("cityOfBirthIdDependente")));
        customOnboardingRequest.setCnhId(String.valueOf(requestJson.get("cnhId")));
        customOnboardingRequest.setCountryCodeDependente(String.valueOf(requestJson.get("countryCodeDependente")));
        customOnboardingRequest.setCountryOfBirthId(String.valueOf(requestJson.get("countryOfBirthId")));
        customOnboardingRequest.setCountryOfBirthIdDependente(String.valueOf(requestJson.get("countryOfBirthIdDependente")));
        customOnboardingRequest.setDocumentIssueDate((String)requestJson.get("documentIssueDate"));
        customOnboardingRequest.setDocumentIssuerDepartmentDependente((String) requestJson.get("documentIssuerDepartmentDependente"));
        customOnboardingRequest.setDocumentIssuerStateIdDependente(String.valueOf(requestJson.get("documentIssuerStateIdDependente")));
        customOnboardingRequest.setEduCompletionDtDependente((String) requestJson.get("eduCompletionDtDependente"));
        customOnboardingRequest.setEduCurrentSemesterDependente(String.valueOf(requestJson.get("eduCurrentSemesterDependente")));
        customOnboardingRequest.setEduInstitutionNameDependente((String) requestJson.get("eduInstitutionNameDependente"));
        customOnboardingRequest.setEduInstitutionStateCdDependente((String) requestJson.get("eduInstitutionStateCdDependente"));
        customOnboardingRequest.setEducationInstitutionStateIdDependente((String) requestJson.get("educationInstitutionStateIdDependente"));
        customOnboardingRequest.setEmail((String) requestJson.get("email"));
        customOnboardingRequest.setJoinDocumentType(CreateCustomOnboardingJoySegregatedRequest.JoinDocumentTypeEnum.RG);
        customOnboardingRequest.setEmailDependente((String) requestJson.get("emailDependente"));
        customOnboardingRequest.setFatherNameDependente((String) requestJson.get("fatherNameDependente"));
        customOnboardingRequest.setGenderDependente((String) requestJson.get("genderDependente"));
        customOnboardingRequest.setMobileAreaCode(String.valueOf(requestJson.get("mobileAreaCode")));
        customOnboardingRequest.setMobileCountryCode(String.valueOf(requestJson.get("mobileCountryCode")));
        customOnboardingRequest.setMobilePhoneNumber(String.valueOf(requestJson.get("mobilePhoneNumber")));
        customOnboardingRequest.setMotherNameDependente((String) requestJson.get("motherNameDependente"));
        customOnboardingRequest.setName((String) requestJson.get("name"));
        customOnboardingRequest.setNameDependente((String) requestJson.get("nameDependente"));
        customOnboardingRequest.setNeighbourhoodDependente((String) requestJson.get("neighbourhoodDependente"));
        customOnboardingRequest.setNicknameDependente((String) requestJson.get("nicknameDependente"));
        customOnboardingRequest.setPhoneNumberDependente(String.valueOf(requestJson.get("phoneNumberDependente")));
        customOnboardingRequest.setPostalCodeDependente(String.valueOf(requestJson.get("postalCodeDependente")));
        customOnboardingRequest.setReferencePersonNameDependente((String) requestJson.get("referencePersonNameDependente"));
        customOnboardingRequest.setRelationshipDegreeId((String) requestJson.get("relationshipDegreeId"));
        customOnboardingRequest.setRgId((String) requestJson.get("rgId"));
        customOnboardingRequest.setRgIdDependente((String) requestJson.get("rgIdDependente"));
        customOnboardingRequest.setStateCdDependente((String) requestJson.get("stateCdDependente"));
        customOnboardingRequest.setStateOfBirthId((String) requestJson.get("stateOfBirthId"));
        customOnboardingRequest.setStateOfBirthIdDependente((String) requestJson.get("stateOfBirthIdDependente"));
        customOnboardingRequest.setStreetNameDependente((String) requestJson.get("streetNameDependente"));
        customOnboardingRequest.setStreetNumberDependente(String.valueOf(requestJson.get("streetNumberDependente")));

        return customOnboardingRequest;
    }

    /**
     * Método responsável por realizar o onboarding Joy segregada
     *
     * @param requestJson Objeto do tipo json que contêm as informações necessárias para preenchimento do body da request
     * @return JSONObject
     */
    public JSONObject criarAdesaoPersonalizadaJoySegregado(JSONObject requestJson) throws ApiException, ParseException, JsonProcessingException {
        OperadorEvidencia.logarPasso("Gerando massa NextJoySegregado...");
        JSONObject ret;

        try {
            ret = convertResponseJsonObject(new PortalMassasClient()
                    .testDataOnboardingJoyControllerApi()
                    .createCustomOnboardingJoySegregated(
                            getCoreIP(),
                            getEsteira(),
                            getCsrUserId(),
                            getCsrUserPassword(),
                            criarAdesaoPersonalizadaJoySegregadoRequest(requestJson)));
        } catch (Exception e) {

            OperadorEvidencia.logarPasso("Erro na criação da massa NextJoySegregado."+e);
            throw e;
        }
        OperadorEvidencia.logarPasso("Massa automática NextJoySegregado criada.");
        OperadorEvidencia.logarPasso(ret.toJSONString());
        return ret;
    }

    /**
     * Método responsável por realizar o onboarding Joy
     *
     * @param requestJson Objeto do tipo json que contêm as informações necessárias para preenchimento do body da request
     * @return JSONObject
     */
    public JSONObject criarAdesaoPersonalizadaJoy(JSONObject requestJson) throws ApiException, ParseException, JsonProcessingException {
        OperadorEvidencia.logarPasso("Gerando massa NextJoy...");
        JSONObject ret;

        try {
            ret = convertResponseJsonObject(new PortalMassasClient()
                    .testDataOnboardingJoyControllerApi()
                    .createCustomOnboardingJoy(
                            getCoreIP(),
                            getEsteira(),
                            getCsrUserId(),
                            getCsrUserPassword(),
                            criarAdesaoPersonalizadaJoyRequest(requestJson)));
        } catch (Exception e) {

            OperadorEvidencia.logarPasso("Erro na criação da massa NextJoy.");
            throw e;
        }
        OperadorEvidencia.logarPasso("Massa automática NextJoy criada.");
        OperadorEvidencia.logarPasso(ret.toJSONString());
        return ret;
    }

    /**
     *
     * @param arquivoJson
     * @return
     * @throws Exception
     */
    public JSONObject prepararMassaAdesaoPersonalizadaNextJoy(JSONObject arquivoJson) throws Exception {

        IntegracaoDeDadosJoyFunc integracaoDeDadosJoyFunc = new IntegracaoDeDadosJoyFunc();

        try {
            var responseJson = integracaoDeDadosJoyFunc
                    .criarAdesaoPersonalizadaJoy((JSONObject) arquivoJson.get("requestAdesaoNextJoy"));

            arquivoJson = alterPropertiesJsonObject(responseJson, arquivoJson);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return arquivoJson;
    }

    /**
     *
     * @param arquivoJson
     * @return JSONObject
     * @throws Exception
     */
    public JSONObject prepararMassaAdesaoPersonalizadaJoySegregado(JSONObject arquivoJson) throws Exception {
        IntegracaoDeDadosJoyFunc integracaoDeDadosJoyFunc = new IntegracaoDeDadosJoyFunc();
        OperadorEvidencia.logarPasso("Iniciando criação da massa!");
        try {
            var responseJson = integracaoDeDadosJoyFunc
                    .criarAdesaoPersonalizadaJoySegregado((JSONObject) arquivoJson.get("requestAdesaoNextJoySegregado"));

            arquivoJson = alterPropertiesJsonObject(responseJson, arquivoJson);

        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return arquivoJson;
    }
}
