package funcionalidade.massa.fnext;

import br.com.bradesco.next.test.data.provider.client.model.AvailableCustomerOnboardingJoyMultibankResponse;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import org.json.simple.JSONObject;

@SuppressWarnings("unused")
public class MassaQA21702 extends BaseQAFunc implements CasoDeTesteMassa {


    @Override
    public JSONObject criar() throws Exception {

        return lerArquivoJson(recuperarClasseDeTeste());

    }
}
