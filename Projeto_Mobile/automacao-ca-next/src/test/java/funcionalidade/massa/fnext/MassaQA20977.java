package funcionalidade.massa.fnext;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import dados.portal.IntegracaoDeDadosJoyMultibancoFunc;
import org.json.simple.JSONObject;


public class MassaQA20977 extends BaseQAFunc implements CasoDeTesteMassa{

    @Override
    public JSONObject criar() throws Exception {

        return new IntegracaoDeDadosJoyMultibancoFunc()
                .preparaMassaCriarListaMultibancoPersonalizadaJoy(lerArquivoJson(recuperarClasseDeTeste()));
    }
}
