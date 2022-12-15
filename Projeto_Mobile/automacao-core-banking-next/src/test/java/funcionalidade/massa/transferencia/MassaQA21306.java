package funcionalidade.massa.transferencia;

import org.json.simple.JSONObject;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;

import funcionalidade.massa.MassaFunc;

public class MassaQA21306 implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        return new MassaFunc().lerArquivoJson("QA21306");
    }
}
