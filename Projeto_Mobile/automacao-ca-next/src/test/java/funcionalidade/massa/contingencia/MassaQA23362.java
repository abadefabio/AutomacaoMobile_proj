package funcionalidade.massa.contingencia;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import org.json.simple.JSONObject;

import static dados.portal.DadosContaFunc.adicionarSaldo;
import static dados.portal.DadosContatoFunc.criarContatoBancoParaOutraPessoa;


public class MassaQA23362 extends BaseQAFunc implements CasoDeTesteMassa {
    @Override
    public JSONObject criar() throws Exception {

        JSONObject massa = lerArquivoJson(recuperarClasseDeTeste());

        criarContatoBancoParaOutraPessoa(massa);

        adicionarSaldo(massa, AddBalanceRequest.AccountTypeEnum.POUPANCA);

        return massa;
    }
}
