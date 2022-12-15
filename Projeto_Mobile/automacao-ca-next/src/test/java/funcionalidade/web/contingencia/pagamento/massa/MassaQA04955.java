package funcionalidade.web.contingencia.pagamento.massa;


import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import dados.base.BaseQAFunc;
import org.json.simple.JSONObject;

@SuppressWarnings("unused")
public class MassaQA04955 extends BaseQAFunc implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        return lerArquivoJson(recuperarClasseDeTeste());
    }
}
