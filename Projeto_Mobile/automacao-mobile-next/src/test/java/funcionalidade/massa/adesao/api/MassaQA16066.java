package funcionalidade.massa.adesao.api;

import dados.portal.funcionalidades.PortalAdesaoJoyMultibank;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA16066 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject criar() throws Exception {
        var arquivoJson = obterJsonTesteAtual();

        return new PortalAdesaoJoyMultibank().criarAdesaoJoyMultibankVariasTentativas(arquivoJson, (String) arquivoJson.get("minDependentesAtuais"), (String) arquivoJson.get("maxDependentesAtuais"));
    }
}
