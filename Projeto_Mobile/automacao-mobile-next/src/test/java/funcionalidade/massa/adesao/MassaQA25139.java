package funcionalidade.massa.adesao;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.portal.funcionalidades.PortalAdesaoNext;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA25139 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject arquivoJsonMassa = obterJsonTesteAtual();

        return new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJsonMassa, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
    }
}
