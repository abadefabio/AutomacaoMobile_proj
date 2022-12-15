package funcionalidade.mobile.cartao.servicos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import pagina.mobile.jornadas.cartao.servicos.AvisoViagemTela;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.ServicosCartaoTela;

public class AvisoViagemFunc extends FuncionalidadeBase {
    /**
     * Método para exclusão de AvisoViagem
     *
     * @throws Exception
     * */
    public void excluirAvisoViagem() throws Exception {
        new CartaoTela(getDriver())
                .validarTextoCartao()
                .tocarServicosCartao();
        new ServicosCartaoTela(getDriver())
                .tocarBotaoAvisoViagem();
        new AvisoViagemTela(getDriver())
                .validarTextoFaltamDoAvisoViagem()
                .tocarNosTresPontinhosNoCantoSuperiorDireito()
                .tocarBotaoExcluirAvisoViagem()
                .validarTelaExcluirAvisoViagem()
                .tocarBotaoSimExcluir()
                .validarTelaAvisoViagemCancelado()
                .tocarBotaoOk();
    }
}
