package funcionalidade.massa.pix;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA02478 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        var retornoCpfJson = obterJsonTesteAtual();

        new PortalConta().adicionarSaldo(retornoCpfJson, AddBalanceRequest.AccountTypeEnum.CORRENTE, 2999.99);

        return retornoCpfJson;
    }
}
