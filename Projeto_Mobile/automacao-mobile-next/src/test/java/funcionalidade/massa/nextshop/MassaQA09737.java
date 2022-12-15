package funcionalidade.massa.nextshop;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import dados.portal.funcionalidades.PortalAdesaoNext;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA09737 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json, arquivoJson = obterJsonTesteAtual();

        if (arquivoJson.get("criarMassaAgora").equals(false)) {
            return arquivoJson;
        }

        json = new PortalAdesaoNext().criacaoAdesaoAtivadoComTutorial(arquivoJson, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);

        OperadorEvidencia.logarPasso("Aguardar tempo liberacao massa");
        Thread.sleep(240000);
        OperadorEvidencia.logarPasso("Finalizado tempo liberacao massa");

        return json;
    }
}
