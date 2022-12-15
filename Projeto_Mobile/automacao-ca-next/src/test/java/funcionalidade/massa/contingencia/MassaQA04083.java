package funcionalidade.massa.contingencia;

import br.com.bradesco.next.test.data.provider.client.model.AddBalanceRequest;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import org.json.simple.JSONObject;
import static dados.portal.DadosContaFunc.adicionarSaldo;
import static dados.portal.DadosContatoFunc.criarContatoBancoParaMim;

@SuppressWarnings("unused")
public class MassaQA04083 extends BaseQAFunc implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        JSONObject massa = lerArquivoJson(recuperarClasseDeTeste());

        criarContatoBancoParaMim(massa);

        adicionarSaldo(massa, AddBalanceRequest.AccountTypeEnum.CORRENTE);

        return massa;
    }
}
