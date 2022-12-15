package funcionalidade.massa.seguros;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA12936 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json, arquivoJsonMassa = obterJsonTesteAtual();

        json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJsonMassa, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
        new PortalConta().adicionarSaldo(json, AddBalanceRequest.AccountTypeEnum.POUPANCA, 10000.00);

        return json;
    }
}
