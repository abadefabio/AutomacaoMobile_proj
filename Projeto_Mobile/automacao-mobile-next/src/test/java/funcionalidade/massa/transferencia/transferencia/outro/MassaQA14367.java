package funcionalidade.massa.transferencia.transferencia.outro;

import dados.portal.funcionalidades.PortalContato;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA14367 extends MassaQABase implements CasoDeTesteMassa {

    public JSONObject criar() throws Exception {
        JSONObject dadosParaContato = obterJsonTesteAtual();

        new PortalContato().criarContatoIntituicaoPagamento(
                dadosParaContato,
                "33",
                "BANCO SANTANDER (BRASIL) S.A.",
                "90400888",
                "3565",
                "450881247");

        return dadosParaContato;
    }
}
