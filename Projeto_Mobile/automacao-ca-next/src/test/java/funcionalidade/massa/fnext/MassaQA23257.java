package funcionalidade.massa.fnext;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import org.json.simple.JSONObject;

public class MassaQA23257 extends BaseQAFunc implements CasoDeTesteMassa{

    @Override
    public JSONObject criar() throws Exception {
        return lerArquivoJson(recuperarClasseDeTeste());
    }
}
