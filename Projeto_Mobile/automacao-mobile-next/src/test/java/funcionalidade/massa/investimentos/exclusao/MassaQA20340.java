package funcionalidade.massa.investimentos.exclusao;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;
import funcionalidade.massa.MassaQABase;

public class MassaQA20340 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}
