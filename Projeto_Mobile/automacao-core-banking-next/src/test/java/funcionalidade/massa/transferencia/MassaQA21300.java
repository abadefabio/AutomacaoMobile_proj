package funcionalidade.massa.transferencia;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import funcionalidade.massa.MassaFunc;
import org.json.simple.JSONObject;

public class MassaQA21300 implements CasoDeTesteMassa {

    public JSONObject criar() throws Exception {
        return new MassaFunc().lerArquivoJson("QA21300");
    }

}
