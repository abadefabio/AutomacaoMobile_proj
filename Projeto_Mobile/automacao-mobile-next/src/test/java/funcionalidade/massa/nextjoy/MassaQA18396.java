package funcionalidade.massa.nextjoy;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.portal.funcionalidades.PortalAdesaoNext;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA18396 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        JSONObject json = obterJsonTesteAtual();

        try {
            /*
            Criação Responsável 01 - NEXT
             */
            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Iniciando criacao do Responsável 01 - NEXT");
            CreateOnboardingRequest body = new CreateOnboardingRequest();
            body.setCompleteTutorial(true);
            body.setEmail(Utilitarios.geradorDeEmail());
            body.setJoinDocumentType(CreateOnboardingRequest.JoinDocumentTypeEnum.RG);
            body.setOnboardingApplicationStatus(StatusAdesaoOnboarding.APROVADA_FINALIZADA.getCodigoOnboarding());
            body.setShouldActivate(true);


            JSONObject responseResp1 = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(new JSONObject(), StatusAdesaoOnboarding.APROVADA_FINALIZADA);

            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Response da criacao do Responsável 01 - NEXT" + responseResp1);

            /*
            Criação Responsável 02  - NEXT
            */
            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Iniciando criacao do Responsável 02 - NEXT");

            JSONObject responseResp2 = new PortalAdesaoNext().criacaoAdesaoNaoAtivadoComTutorial(new JSONObject(), StatusAdesaoOnboarding.APROVADA_FINALIZADA);

            OperadorEvidencia.logarPasso("[PORTAL DE MASSA]: Response da criacao do Responsável 02 - NEXT" + responseResp2);

            /*
            Gerar cpf aleatório para dependente
            */

            String cpfDependente = Utilitarios.gerarCpf();
            /*
            Atualiza o json de massa e retorna
            */
            json.replace("cpfResponsavel01", responseResp1.get("document")); // cpf do responsável 1 (next)
            json.replace("cpfResponsavel02", responseResp2.get("document")); // cpf do responsável 2 (next)
            json.replace("cpfDependente", cpfDependente); // cpf do responsável 2 (next)
            return json;
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }
}
