package funcionalidade.massa.pagamentos.codigo.barras.tributos;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA02904 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json, arquivoJson = obterJsonTesteAtual();

        json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJson, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);
        var valorAdicionarSaldo = json.get("valor").toString().replace(",", ".");
        boolean saldoAdicionado = new PortalConta().adicionarSaldo(json, AddBalanceRequest.AccountTypeEnum.CORRENTE, Double.parseDouble(valorAdicionarSaldo));

        if (saldoAdicionado) {
            return json;
        } else {
            return arquivoJson;
        }
    }
}
