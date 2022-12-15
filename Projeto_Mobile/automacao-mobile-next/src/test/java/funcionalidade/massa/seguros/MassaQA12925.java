package funcionalidade.massa.seguros;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA12925 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}
