package funcionalidade.massa.investimentos.aplicacao;

import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import funcionalidade.massa.MassaQABase;
import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA21014 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json, arquivoJson = obterJsonTesteAtual();

        json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJson, StatusAdesaoOnboarding.APROVADA_NAO_FINALIZADA);

        return new PortalConta().adicionarSaldo(json, AddBalanceRequest.AccountTypeEnum.CORRENTE, 50000.00) ?
                json : arquivoJson;
    }
}
