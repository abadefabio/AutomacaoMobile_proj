package dados.portal.funcionalidades;

import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingRequest;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.tools.Utilitarios;
import dados.portal.base.BasePortalFunc;
import dados.portal.base.PortalMassasClient;
import dados.portal.utils.PortalMassasEnum;
import org.json.simple.JSONObject;

import static dados.portal.base.PortalMassasClient.getCoreIP;
import static dados.portal.base.PortalMassasClient.getCsrUserId;
import static dados.portal.base.PortalMassasClient.getCsrUserPassword;
import static dados.portal.base.PortalMassasClient.getEsteira;
import static dados.portal.utils.PortalMassasUtil.convertResponseJsonObject;

public class PortalAdesaoNext extends BasePortalFunc {

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
    private JSONObject criacaoAdesaoPortalMassas(JSONObject arquivoJson, StatusAdesaoOnboarding statusAdesao, boolean completeTutorial, boolean ativado, String email) throws Exception {

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
        arquivoJson.replace(JSON.CPF.getValue(), onboardingResponseJson.get(PortalMassasEnum.DOCUMENT.getValue()));
        return arquivoJson;
    }


}
