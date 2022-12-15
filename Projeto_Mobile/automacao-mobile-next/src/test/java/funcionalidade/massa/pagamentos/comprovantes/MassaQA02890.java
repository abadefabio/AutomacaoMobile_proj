package funcionalidade.massa.pagamentos.comprovantes;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;
import teste.mobile.regressivo.pagamentos.comprovante.QA02890;

public class MassaQA02890 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return obterJsonTesteAtual();
    }
}
