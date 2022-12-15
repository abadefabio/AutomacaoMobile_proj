package funcionalidade.web.contingencia.login.massa;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import org.json.simple.JSONObject;

@SuppressWarnings("unused")
public class MassaQA00286 extends BaseQAFunc implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        return lerArquivoJson(recuperarClasseDeTeste());

    }
}
