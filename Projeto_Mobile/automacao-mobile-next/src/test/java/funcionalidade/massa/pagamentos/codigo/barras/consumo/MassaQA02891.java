package funcionalidade.massa.pagamentos.codigo.barras.consumo;

import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA02891 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}
