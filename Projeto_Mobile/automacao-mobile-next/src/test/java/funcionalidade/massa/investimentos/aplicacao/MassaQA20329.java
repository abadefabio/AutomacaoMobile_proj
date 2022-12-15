package funcionalidade.massa.investimentos.aplicacao;

import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA20329 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}