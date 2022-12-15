package br.com.next.automacao.core.massa.portal.qualidade;

import br.com.next.automacao.core.massa.LeitorMassaDados;
import org.json.simple.JSONObject;

public interface CasoDeTesteMassa {

    JSONObject criar() throws Exception;

    default JSONObject dadosArquivoJson(String cenario){
        cenario = cenario.toUpperCase().replace("QA", "");
        LeitorMassaDados leitorMassaDados = new LeitorMassaDados(cenario);
        return leitorMassaDados.getMassaDados();
    }

}
