package funcionalidade.massa.credito;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA16981 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        var arquivoJson = obterJsonTesteAtual();
        return arquivoJson;
    }
}
