package funcionalidade.massa.seguros;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA22697 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}