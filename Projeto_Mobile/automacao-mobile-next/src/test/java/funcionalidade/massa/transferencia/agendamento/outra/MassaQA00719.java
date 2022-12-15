package funcionalidade.massa.transferencia.agendamento.outra;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA00719 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject arquivoJson = obterJsonTesteAtual();

        new PortalConta().adicionarSaldo(arquivoJson, AddBalanceRequest.AccountTypeEnum.CORRENTE, 2999.99);

        return arquivoJson;
    }
}
