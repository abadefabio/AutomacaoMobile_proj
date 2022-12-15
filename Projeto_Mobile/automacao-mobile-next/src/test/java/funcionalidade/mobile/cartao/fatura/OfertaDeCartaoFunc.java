package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.OfertaDeCartaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class OfertaDeCartaoFunc extends FuncionalidadeBase {

    /**
     * M�todo para validar a tela "Oferta de Cart�o"
     *
     * @throws Exception
     */
    public void validarTelaOfertaDeCartao() throws Exception {
        new CartaoTela(getDriver())
                .validarTelaCartao()
                .tocarPedirCartaoCredito();
        new OfertaDeCartaoTela(getDriver())
                .validarTelaOfertaDeCartao();
    }
}
