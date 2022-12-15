package funcionalidade.massa.seguros;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.portal.funcionalidades.PortalAdesaoNext;
import org.json.simple.JSONObject;

public class MassaQA12933 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject arquivoJsonMassa = obterJsonTesteAtual();

        return new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJsonMassa, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
    }
}
