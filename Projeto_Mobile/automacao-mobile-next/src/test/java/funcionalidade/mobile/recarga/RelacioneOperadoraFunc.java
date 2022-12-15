package funcionalidade.mobile.recarga;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.constantes.recarga.FormaPagamento;
import constantes.recarga.Recarga;
import constantes.recarga.ValorRecarga;
import pagina.mobile.comum.next.ValidaMensagensTela;
import pagina.mobile.jornadas.recarga.resumo.EscolhaValorTela;
import pagina.mobile.jornadas.recarga.resumo.ResumoTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class RelacioneOperadoraFunc extends FuncionalidadeBase {

    /**
     * Método para realizar uma Recarga
     *
     * @param formaPagamento - forma de pagamento da recarga
     * @throws Exception
     */
    public void realizarRecarga(FormaPagamento formaPagamento, ValorRecarga valorRecarga) throws Exception {
        new EscolhaValorTela(getDriver())
                .selecionarValorRecarga(valorRecarga);
        switch (formaPagamento) {
            case CONTA_CORRENTE:
                new ResumoTela (getDriver())
                        .selecionaContaCorrente();
                break;
            case CONTA_POUPANÇA:
                new ResumoTela (getDriver())
                        .selecionaContaPoupanca();
                break;
        }
        new ResumoTela (getDriver())
                .tocarBotaoConfirmar();
    }

    /**
     * Validar mensagem de exceção de limite máximo de recargas
     *
     * @throws Exception
     */
    public void validarMensagemLimiteRecarga() throws Exception {
        new ValidaMensagensTela(getDriver())
                .validarTodasAsMensagens(Recarga.MENSAGEM_LIMITE_RECARGAS.toString());

    }
}
