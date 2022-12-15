package funcionalidade.massa.cockpit;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.Utilitarios;
import dados.base.BaseQAFunc;
import dados.portal.IntegracaoDeDadosFunc;
import org.json.simple.JSONObject;

public class MassaQA11653 extends BaseQAFunc implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        return new IntegracaoDeDadosFunc()
                .criacaoAdesaoNaoAtivadoComTutorial(
                        lerArquivoJson(recuperarClasseDeTeste()),
                        StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
    }

}
