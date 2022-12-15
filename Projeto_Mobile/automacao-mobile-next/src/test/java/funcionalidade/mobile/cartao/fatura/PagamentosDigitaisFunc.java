package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.PagamentosDigitaisTela;
import pagina.mobile.jornadas.cartao.servicos.CartaoVirtualTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class PagamentosDigitaisFunc extends FuncionalidadeBase {

    /**
     * Método para validar texto cartão virtual
     *
     * @throws Exception
     */
    public void validarTextoCartaoVirtual(String... textos) throws Exception {
        new CartaoTela(getDriver())
                .tocarBotaoPagamentosDigitais();
        new PagamentosDigitaisTela(getDriver())
                .tocarBotaoCartaoVirtual();
        new CartaoVirtualTela(getDriver())
                .tocarBotaoVerComoFunciona();
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(textos);
        new CartaoVirtualTela(getDriver())
                .tocarBotaoOkEntendi();
    }
}
