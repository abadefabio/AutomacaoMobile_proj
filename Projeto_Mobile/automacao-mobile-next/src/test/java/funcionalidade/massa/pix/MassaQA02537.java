package funcionalidade.massa.pix;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest.AccountTypeEnum;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA02537 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        var adesaoJsonPlataforma = obterJsonTesteAtual();

        new PortalConta().adicionarSaldo(adesaoJsonPlataforma, AccountTypeEnum.POUPANCA, 2999.99);

        return adesaoJsonPlataforma;
    }
}
