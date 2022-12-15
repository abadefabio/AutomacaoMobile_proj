package funcionalidade.massa.adesao;

import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import funcionalidade.massa.MassaQABase;
import org.json.simple.JSONObject;

import static br.com.next.automacao.core.tools.Utilitarios.gerarCpf;

public class MassaQA24952 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {

        JSONObject arquivoJson = obterJsonTesteAtual();
        arquivoJson.put("cpf",  gerarCpf());

        return arquivoJson;
    }

}
