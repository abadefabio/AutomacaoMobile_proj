package funcionalidade.massa.depositos;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.client.portal.massas.PortalMassasClient;
import funcionalidade.massa.MassaFunc;
import org.json.simple.JSONObject;

import static dados.client.portal.massas.PortalMassasClient.*;
import static dados.client.portal.massas.utils.PortalMassasUtil.alterPropertiesJsonObject;
import static dados.client.portal.massas.utils.PortalMassasUtil.convertResponseJsonObject;

public class MassaQA17734 implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        JSONObject json;
        var arquivoJSON = (JSONObject) new MassaFunc().lerArquivoJson("QA17734");

        try {
            json = criacaoAdesaoPortalMassas(arquivoJSON);
            OperadorEvidencia.logarPasso("Aguardar tempo liberacao massa");

            Thread.sleep(240000);
            OperadorEvidencia.logarPasso("Finalizado tempo liberacao massa");
        } catch (ApiException e) {
            var message = e.getResponseBody() != null ? e.getResponseBody() : e.getMessage();
            OperadorEvidencia.logarPasso(String.format("[PORTAL DE MASSA]: ERRO AO CRIAR MASSA DO PORTAL - %s", message));
            json = arquivoJSON;
        } catch (Exception e2) {
            OperadorEvidencia.logarPasso(String.format("Erro ao montar request para o portal de massa - %s", e2.getMessage()));
            json = arquivoJSON;
        }

        return json;
    }

    public static JSONObject criacaoAdesaoPortalMassas(JSONObject arquivoJsonMassa) throws Exception {

        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Iniciando criacao de massa da adesao");

        CreateOnboardingRequest body = new CreateOnboardingRequest();
        body.setShouldActivate(true);
        body.setCompleteTutorial(true);
        body.setEmail(Utilitarios.geradorDeEmail());
        body.setOnboardingApplicationStatus(StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA.getCodigoOnboarding());
        body.setJoinDocumentType(CreateOnboardingRequest.JoinDocumentTypeEnum.RG);
        var response = new PortalMassasClient()
                .testDataOnboardingControllerApi()
                .createOnboarding(getCoreIP(),
                        getEsteira(),
                        getCsrUserId(),
                        getCsrUserPassword(),
                        body);

        OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Massa adesao response " + response);

        var onboardingResponseJson = convertResponseJsonObject(response);
        return alterPropertiesJsonObject(onboardingResponseJson, arquivoJsonMassa);
    }
}

