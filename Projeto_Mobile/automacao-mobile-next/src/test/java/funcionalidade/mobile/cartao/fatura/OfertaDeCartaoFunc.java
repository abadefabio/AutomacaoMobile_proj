package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;

import pagina.mobile.jornadas.cartao.fatura.CartaoTela;
import pagina.mobile.jornadas.cartao.fatura.OfertaDeCartaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class OfertaDeCartaoFunc extends FuncionalidadeBase {

    /**
     * Método para validar a tela "Oferta de Cartão"
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
