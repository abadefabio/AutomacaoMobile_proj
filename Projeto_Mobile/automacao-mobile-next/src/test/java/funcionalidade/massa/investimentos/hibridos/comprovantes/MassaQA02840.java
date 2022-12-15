package funcionalidade.massa.investimentos.hibridos.comprovantes;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.bradesco.next.test.data.provider.client.model.ChangeInvestorProfileRequest;
import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;
import dados.portal.funcionalidades.PortalAdesaoNext;
import dados.portal.funcionalidades.PortalConta;
import dados.portal.funcionalidades.PortalInvestimento;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;

public class MassaQA02840 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject json, arquivoJson = obterJsonTesteAtual();

        json = new PortalAdesaoNext().criacaoAdesaoAtivadoSemTutorial(arquivoJson, StatusAdesaoOnboarding.APROVADA_FINALIZADA);
        new PortalInvestimento().alterarPerfilInvestidor(json, ChangeInvestorProfileRequest.InvestorProfileTypeEnum.DINAMICO);
        new PortalConta().adicionarSaldo(json, AddBalanceRequest.AccountTypeEnum.CORRENTE, 2999.99);
        new PortalInvestimento().realizarInvestimento(json, 1, 600.00, LocalDateTime.now());

        return arquivoJson;
    }
}
