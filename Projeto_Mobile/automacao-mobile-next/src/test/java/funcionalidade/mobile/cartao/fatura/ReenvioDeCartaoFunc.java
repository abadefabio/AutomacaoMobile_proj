package funcionalidade.mobile.cartao.fatura;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.mobile.jornadas.cartao.fatura.CartaoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class ReenvioDeCartaoFunc extends FuncionalidadeBase {


    /**
     * Validar presença do texto 'Reenvio do Cartão Solicitado'
     *
     * @throws Exception
     */
    public void validarTextoReenviodoCartao() throws Exception {
        new CartaoTela(getDriver())
                .validarTextoReenviodoCartaoSolicitado();
    }
}
