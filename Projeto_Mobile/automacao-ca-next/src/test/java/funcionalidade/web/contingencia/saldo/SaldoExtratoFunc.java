package funcionalidade.web.contingencia.saldo;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.contingencia.saldo.SaldoContaCorrenteTela;
import pagina.web.contingencia.saldo.SaldoContaPoupancaTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class SaldoExtratoFunc extends FuncionalidadeBase {

    /**
     * M�todo para clicar no menu Saldo e Extrato;
     *
     * @return
     * @throws Exception
     */
    public void acessarMenuPoupanca() throws Exception {
        new SaldoContaPoupancaTela(getWebDriver()).clicaMenuSaldoEExtrato();
    }

    /**
     * M�todo para retornar valor da vari�vel 'saldo extrato';
     *
     * @return
     * @throws Exception
     */
    public String verificarEArmazenarSaldoExtratoContaPoupanca() throws Exception {
        acessarMenuPoupanca();
        SaldoContaPoupancaTela saldoExtrato = new SaldoContaPoupancaTela(getWebDriver());
        saldoExtrato.clicarBotaoMostrarSaldo();
        saldoExtrato.verificarValorSaldoContaPoupanca();
        return saldoExtrato.retornarValorSaldoAtual();
    }

    /**
     * M�todo para retornar valor da vari�vel 'saldo extrato' ;
     *
     * @return
     * @throws Exception
     */
    public String verificarEArmazenarSaldoExtratoContaCorrente() throws Exception {
        acessarMenuPoupanca();
        SaldoContaCorrenteTela saldoExtrato = new SaldoContaCorrenteTela(getWebDriver());
        saldoExtrato.clicarBotaoMostrarSaldo();
        saldoExtrato.verificarValorSaldoContaCorrente();
        return saldoExtrato.retornarValorSaldoAtual();
    }

    /**
     * M�todo para mostrar saldo sensibilizado da conta poupan�a;
     *
     * @throws Exception
     */
    public void verificarSaldoAposTransferenciaContaPoupanca(String valorTarifa, String valorTransferencia, String valorInicial) throws Exception {
        new SaldoContaPoupancaTela(getWebDriver())
                .clicarBotaoMostrarSaldo()
                .clicarBotaoFiltraContaPouponca()
                .validarValorSaldoContaPoupancaAposTransferencia
                        (valorInicial, valorTransferencia, valorTarifa);
    }

    /**
     * M�todo para mostrar saldo sensibilizado da conta corrente;
     *
     * @throws Exception
     */
    public void verificarSaldoAposTransferenciaContaCorrente(String valorTarifa, String valorTransferencia, String valorInicial) throws Exception {
        new SaldoContaCorrenteTela(getWebDriver())
                .clicarBotaoMostrarSaldo()
                .validarValorSaldoContaCorrenteAposTransferencia
                        (valorInicial, valorTransferencia, valorTarifa);
    }
}
