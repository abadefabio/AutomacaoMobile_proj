package dados.portal;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.CreateCustomOnboardingRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import dados.base.BasePortalFunc;
import dados.base.PortalMassasClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import static dados.base.PortalMassasClient.getCoreIP;
import static dados.base.PortalMassasClient.getCsrUserId;
import static dados.base.PortalMassasClient.getCsrUserPassword;
import static dados.base.PortalMassasClient.getEsteira;
import static dados.utils.PortalMassasUtil.alterPropertiesJsonObject;
import static dados.utils.PortalMassasUtil.convertResponseJsonObject;


public class IntegracaoDeDadosFunc extends BasePortalFunc {

    /**
     * Criação de adesão pelo portal de massas passando pela tela de tutorial
     *
     * @param arquivoJson
     * @param statusAdesao
     * @return
     * @throws Exception
     */
    public JSONObject criacaoAdesaoAtivadoComTutorial(JSONObject arquivoJson, StatusAdesaoOnboarding statusAdesao) throws Exception {
        return criacaoAdesaoPortalMassas(arquivoJson, statusAdesao, false, true, Utilitarios.geradorDeEmail());
    }

    /**
     * Criação de adesão pelo portal de massas passando pela tela de tutorial passando email
     *
     * @param arquivoJson
     * @param statusAdesao
     * @param email
     * @return
     * @throws Exception
     */
    public JSONObject criacaoAdesaoAtivadoComTutorialComEmail(JSONObject arquivoJson, StatusAdesaoOnboarding statusAdesao, String email) throws Exception {
        return criacaoAdesaoPortalMassas(arquivoJson, statusAdesao, false, true, email);
    }

    /**
     * Criação de adesão pelo portal de massas sem passar pela tela de tutorial
     *
     * @param arquivoJson
     * @param statusAdesao
     * @return
     * @throws Exception
     */
    public JSONObject criacaoAdesaoAtivadoSemTutorial(JSONObject arquivoJson, StatusAdesaoOnboarding statusAdesao) throws Exception {
        return criacaoAdesaoPortalMassas(arquivoJson, statusAdesao, true, true, Utilitarios.geradorDeEmail());
    }

    /**
     * Criação de adesão pelo portal de massas sem passar pela tela de tutorial
     *
     * @param arquivoJson
     * @param statusAdesao
     * @return
     * @throws Exception
     */
    public JSONObject criacaoAdesaoAtivadoSemTutorialComEmail(JSONObject arquivoJson, StatusAdesaoOnboarding statusAdesao, String email) throws Exception {
        return criacaoAdesaoPortalMassas(arquivoJson, statusAdesao, true, true, email);
    }

    /**
     * Criação de adesão pelo portal de massas passando pela tela de tutorial
     *
     * @param arquivoJson
     * @param statusAdesao
     * @return
     * @throws Exception
     */
    public JSONObject criacaoAdesaoNaoAtivadoComTutorial(JSONObject arquivoJson, StatusAdesaoOnboarding statusAdesao) throws Exception {
        return criacaoAdesaoPortalMassas(arquivoJson, statusAdesao, false, false, Utilitarios.geradorDeEmail());
    }

    /**
     * Criação de adesão pelo portal de massas
     *
     * @param arquivoJson
     * @param statusAdesao
     * @param completeTutorial
     * @param email
     * @return
     * @throws Exception
     */
    public JSONObject criacaoAdesaoPortalMassas(JSONObject arquivoJson, StatusAdesaoOnboarding statusAdesao, boolean completeTutorial, boolean ativado, String email) throws Exception {
        var response = executarPortal("Criação Adesão Next",
                new JSONObject() {{
                    put("Status", statusAdesao.name());
                    put("Pular Tutorial", completeTutorial);
                    put("Email", email);
                }},
                () -> {
                    CreateOnboardingRequest body = new CreateOnboardingRequest();
                    body.setShouldActivate(ativado);
                    body.setCompleteTutorial(completeTutorial);
                    body.setEmail(email);
                    body.setOnboardingApplicationStatus(statusAdesao.getCodigoOnboarding());
                    body.setJoinDocumentType(CreateOnboardingRequest.JoinDocumentTypeEnum.RG);

                    return new PortalMassasClient()
                            .testDataOnboardingControllerApi()
                            .createOnboarding(
                                    getCoreIP(),
                                    getEsteira(),
                                    getCsrUserId(),
                                    getCsrUserPassword(),
                                    body);
                });

        if (response == null) {
            return arquivoJson;
        }

        var onboardingResponseJson = convertResponseJsonObject(response);
        return alterPropertiesJsonObject(onboardingResponseJson, arquivoJson);
    }

    public static JSONObject criacaoAdesaoPortalMassas(CreateOnboardingRequest body, JSONObject arquivoJsonMassa) throws Exception {

        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Iniciando criacao de massa da adesao");

        try {
            var response = new PortalMassasClient()
                    .testDataOnboardingControllerApi()
                    .createOnboarding(getCoreIP(),
                            getEsteira(),
                            ReadProperties.getEmuladorUser(),
                            ReadProperties.getEmuladorPass(),
                            body);

            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Massa adesao response " + response);

            var onboardingResponseJson = convertResponseJsonObject(response);
            return alterPropertiesJsonObject(onboardingResponseJson, arquivoJsonMassa);
        }catch (Exception e){
            OperadorEvidencia.logarPasso("[Portal Massas]: Não foi possível gerar a massa.");
            return arquivoJsonMassa;
        }
    }

    private CreateCustomOnboardingRequest criarAdesaoPersonalizadaRequest(JSONObject requestJson) {
        var customOnboardingRequest = new CreateCustomOnboardingRequest();

        customOnboardingRequest.setAddressAdditionalInfo((String)requestJson.get("addressAdditionalInfo"));
        customOnboardingRequest.setAreaCode(String.valueOf(requestJson.get("areaCode")));
        customOnboardingRequest.setBirthPlace((String)requestJson.get("birthPlace"));
        customOnboardingRequest.setBirthdate((String)requestJson.get("birthdate"));
        customOnboardingRequest.setCityId(String.valueOf(requestJson.get("cityId")));
        customOnboardingRequest.setCityOfBirthId(String.valueOf(requestJson.get("cityOfBirthId")));
        customOnboardingRequest.setCnhId(String.valueOf(requestJson.get("cnhId")));
        customOnboardingRequest.setCompleteTutorial((Boolean) requestJson.get("completeTutorial"));
        customOnboardingRequest.setCountryOfBirthId(String.valueOf(requestJson.get("countryOfBirthId")));
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
        customOnboardingRequest.setJoinDocumentType(CreateCustomOnboardingRequest.JoinDocumentTypeEnum.RG);
        customOnboardingRequest.setMotherName((String)requestJson.get("motherName"));
        customOnboardingRequest.setNeighbourhood((String)requestJson.get("neighbourhood"));
        customOnboardingRequest.setNickname((String)requestJson.get("nickname"));
        customOnboardingRequest.setOnboardingApplicationStatus(Math.toIntExact((Long) requestJson.get("onboardingApplicationStatus")));
        customOnboardingRequest.setPhoneNumber(String.valueOf(requestJson.get("phoneNumber")));
        customOnboardingRequest.setPostalCode(String.valueOf(requestJson.get("postalCode")));
        customOnboardingRequest.setReferencePersonName((String)requestJson.get("referencePersonName"));
        customOnboardingRequest.setRgId((String)requestJson.get("rgId"));
        customOnboardingRequest.setShouldActivate((Boolean) requestJson.get("shouldActivate"));
        customOnboardingRequest.setStateCd((String)requestJson.get("stateCd"));
        customOnboardingRequest.setStateOfBirth(String.valueOf(requestJson.get("stateOfBirth")));
        customOnboardingRequest.setStreetName((String)requestJson.get("streetName"));
        customOnboardingRequest.setStreetNumber(String.valueOf(requestJson.get("streetNumber")));

        return customOnboardingRequest;
    }

    public JSONObject criarAdesaoPersonalizada(JSONObject requestJson) throws ApiException, ParseException, JsonProcessingException {

        OperadorEvidencia.logarPasso("Gerando massa Next...");
        JSONObject ret = null;
        try {
            ret = convertResponseJsonObject(new PortalMassasClient()
                    .testDataOnboardingControllerApi()
                    .createCustomOnboarding(
                            getCoreIP(),
                            getEsteira(),
                            getCsrUserId(),
                            getCsrUserPassword(),
                            criarAdesaoPersonalizadaRequest(requestJson)));
        } catch (Exception e) {
            OperadorEvidencia.logarPasso("Erro na criação da massa Next. Erro: " + e);
            throw e;
        }

        OperadorEvidencia.logarPasso("Massa automática Next criada.");
        OperadorEvidencia.logarPasso(ret.toJSONString());

        return ret;
    }

    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public JSONObject prepararMassaAdesaoPersonalizadaNext(JSONObject arquivoJson) throws Exception {
        IntegracaoDeDadosFunc integracaoDeDadosFunc = new IntegracaoDeDadosFunc();
        try {
            var responseJson = integracaoDeDadosFunc
                    .criarAdesaoPersonalizada((JSONObject) arquivoJson.get("requestAdesaoNext"));
            arquivoJson = alterPropertiesJsonObject(responseJson, arquivoJson);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return arquivoJson;
    }

}
