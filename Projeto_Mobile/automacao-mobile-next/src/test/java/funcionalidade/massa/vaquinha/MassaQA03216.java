package funcionalidade.massa.vaquinha;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.portal.funcionalidades.PortalAdesaoNext;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA03216 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}
