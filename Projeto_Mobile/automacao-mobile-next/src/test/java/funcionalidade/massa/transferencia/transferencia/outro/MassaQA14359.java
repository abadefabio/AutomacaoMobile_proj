package funcionalidade.massa.transferencia.transferencia.outro;

import br.com.next.automacao.core.constantes.tools.geradores.agencia.BancoInstituicao;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.geradores.agencia.AgenciaConta;
import dados.portal.funcionalidades.PortalContato;
import funcionalidade.massa.MassaQABase;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import org.json.simple.JSONObject;

public class MassaQA14359 extends MassaQABase implements CasoDeTesteMassa {

    @Override
    public JSONObject criar() throws Exception {
        JSONObject dadosParaContato = obterJsonTesteAtual();

        AgenciaConta dadosContato = Utilitarios.retornaAgenciaContaAleatoria(BancoInstituicao.ITAU);
        new PortalContato().criarContatoOutraTitularidadeOutrosBancos(dadosParaContato, "341", dadosContato.getAgencia(), dadosContato.getConta());

        return dadosParaContato;
    }
}
