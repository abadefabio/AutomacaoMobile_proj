package funcionalidade.massa.contingencia;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import org.json.simple.JSONObject;
import static dados.portal.DadosContaFunc.adicionarSaldo;
import static dados.portal.DadosContatoFunc.criarContatoInstituicaoPagamentoParaOutraPessoa;

@SuppressWarnings("unused")
public class MassaQA05412 extends BaseQAFunc implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        JSONObject massa = lerArquivoJson(recuperarClasseDeTeste());

        criarContatoInstituicaoPagamentoParaOutraPessoa(massa);

        adicionarSaldo(massa, AddBalanceRequest.AccountTypeEnum.POUPANCA);

        return massa;
    }
}
