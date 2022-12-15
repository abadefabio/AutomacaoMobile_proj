package funcionalidade.massa.recarga;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA03167 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json, arquivoJson = obterJsonTesteAtual();

        json = new PortalAdesaoNext().criacaoAdesaoAtivadoComTutorialComEmail(arquivoJson, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA, "fuladociclado43458@next.com");
        new PortalConta().adicionarSaldo(json, AddBalanceRequest.AccountTypeEnum.CORRENTE, 2999.99);

        return json;
    }
}
