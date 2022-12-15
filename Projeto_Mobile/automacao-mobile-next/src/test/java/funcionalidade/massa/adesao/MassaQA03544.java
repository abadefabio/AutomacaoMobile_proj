package funcionalidade.massa.adesao;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.portal.funcionalidades.PortalAdesaoNext;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA03544 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        var jsonAtual = obterJsonTesteAtual();

        return new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(jsonAtual, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
    }

}
