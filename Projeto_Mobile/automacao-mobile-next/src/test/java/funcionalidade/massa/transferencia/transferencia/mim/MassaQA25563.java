package funcionalidade.massa.transferencia.transferencia.mim;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA25563 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json = obterJsonTesteAtual();

       new PortalConta().adicionarSaldo(json, AddBalanceRequest.AccountTypeEnum.POUPANCA, 2999.99);


        return json;
    }
}
