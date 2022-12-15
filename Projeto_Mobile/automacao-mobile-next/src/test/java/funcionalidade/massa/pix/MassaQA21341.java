package funcionalidade.massa.pix;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest.AccountTypeEnum;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA21341 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        var adesaoJsonPlataforma = obterJsonTesteAtual();

        new PortalConta().adicionarSaldo(adesaoJsonPlataforma, AccountTypeEnum.CORRENTE, 2999.99);

        return adesaoJsonPlataforma;
    }
}
