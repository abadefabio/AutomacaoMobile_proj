package funcionalidade.massa.fnext;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import dados.portal.IntegracaoDeDadosFunc;
import org.json.simple.JSONObject;

@SuppressWarnings("unused")
public class MassaQA16117 extends BaseQAFunc implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        return new IntegracaoDeDadosFunc()
                .prepararMassaAdesaoPersonalizadaNext(lerArquivoJson(recuperarClasseDeTeste()));

    }
}
