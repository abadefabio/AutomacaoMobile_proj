package funcionalidade.massa.web.termos;

import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA07128 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}