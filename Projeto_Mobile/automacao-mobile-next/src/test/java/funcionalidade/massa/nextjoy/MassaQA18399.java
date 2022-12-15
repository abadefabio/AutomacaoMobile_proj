package funcionalidade.massa.nextjoy;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.tools.Utilitarios;
import dados.portal.funcionalidades.PortalAdesaoNext;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA18399 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        JSONObject json = obterJsonTesteAtual();

        /*
        Cria��o Respons�vel 01 - NEXT
         */
        JSONObject responseResp1 = new PortalAdesaoNext().criacaoAdesaoNaoAtivadoComTutorial(null, StatusAdesaoOnboarding.APROVADA_FINALIZADA);
        if (responseResp1 == null) {
            return json;
        }

        /*
        Cria��o Respons�vel 02  - NEXT
        */
        JSONObject responseResp2 = new PortalAdesaoNext().criacaoAdesaoNaoAtivadoComTutorial(null, StatusAdesaoOnboarding.APROVADA_FINALIZADA);
        if (responseResp2 == null) {
            return json;
        }

        /*
        Gerar cpf aleat�rio para dependente
        */

        String cpfDependente = Utilitarios.gerarCpf();
        /*
        Atualiza o json de massa e retorna
        */
        json.replace("cpfResponsavel1", responseResp1.get("document")); // cpf do respons�vel 1 (next)
        json.replace("cpfResponsavel2", responseResp2.get("document")); // cpf do respons�vel 2 (next)
        json.replace("cpfDependente", cpfDependente); // cpf do respons�vel 2 (next)
        return json;
    }
}
