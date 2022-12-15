package funcionalidade.massa.transferencia;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import funcionalidade.massa.MassaFunc;
import org.json.simple.JSONObject;

public class MassaQA22008 implements CasoDeTesteMassa {
    @Override
    public JSONObject criar() throws Exception {
        return new MassaFunc().lerArquivoJson("QA22008");
    }
}