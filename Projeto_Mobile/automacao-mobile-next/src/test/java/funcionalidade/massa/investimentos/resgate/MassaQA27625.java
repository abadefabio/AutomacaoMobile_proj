package funcionalidade.massa.investimentos.resgate;

import org.json.simple.JSONObject;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;

import funcionalidade.massa.MassaQABase;

public class MassaQA27625 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}
