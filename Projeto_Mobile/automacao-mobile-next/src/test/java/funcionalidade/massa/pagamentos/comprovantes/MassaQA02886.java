package funcionalidade.massa.pagamentos.comprovantes;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

public class MassaQA02886 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception{
        return lerArquivoJson("QA02886");
    }
}
