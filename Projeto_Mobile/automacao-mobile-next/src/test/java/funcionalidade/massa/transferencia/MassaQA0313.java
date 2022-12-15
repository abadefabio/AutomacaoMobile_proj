package funcionalidade.massa.transferencia;

import br.com.next.automacao.core.tools.Utilitarios;
import dados.portal.funcionalidades.PortalContato;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA0313 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject arquivoJson = obterJsonTesteAtual();

        return new PortalContato().criarContatoMesmaTitularidadeRetornandoContato(
                arquivoJson,
                "33",
                Utilitarios.geradorAgencia(),
                Utilitarios.geradorConta());
    }
}
