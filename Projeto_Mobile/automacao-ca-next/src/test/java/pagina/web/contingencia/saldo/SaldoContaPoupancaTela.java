package pagina.web.contingencia.saldo;


import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.tools.Utilitarios;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaldoContaPoupancaTela extends PaginaBaseWeb {

    public SaldoContaPoupancaTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Saldo e Extrato']")
    private WebElement menuSaldoEExtrato;

    @FindBy(xpath = "(//button[@id='iconShowBalance'])[2]")
    private WebElement iconeMostrarSaldo;

    @FindBy(id = "buttonOnlyEntries")
    private WebElement botaoFiltrarPoupanca;

    @FindBy(xpath = "(//span[@id='currentBalanceLabel'])[2]")
    private WebElement valorSaldoContaPoupanca;

    /**
     * Clicar Botao Mostrar Saldo;
     *
     * @throws Exception
     */
    @Step("Clicar Botao Mostrar Saldo")
    public SaldoContaPoupancaTela clicaMenuSaldoEExtrato() throws Exception {
        clicarElemento(menuSaldoEExtrato, "Não foi possível clicar na icone Mostrar Saldo");
        salvarEvidencia("Clicar no menu Saldo e Extrato!");
        return this;
    }

    /**
     * Clicar Botao Mostrar Saldo;
     *
     * @throws Exception
     */
    @Step("Clicar Botao Mostrar Saldo")
    public SaldoContaPoupancaTela clicarBotaoMostrarSaldo() throws Exception {
        aguardarCarregamentoElemento(iconeMostrarSaldo);
        clicarElemento(iconeMostrarSaldo, "Não foi possível clicar na icone Mostrar Saldo");
        return this;
    }

    /**
     * Clicar botão filtrar conta poupança;
     *
     * @throws Exception
     */
    @Step("Clicar botão filtrar conta poupança")
    public SaldoContaPoupancaTela clicarBotaoFiltraContaPouponca() throws Exception {
        clicarElemento(botaoFiltrarPoupanca, "Não foi possível clicar na icone Mostrar Saldo");
        salvarEvidencia("Clicar em filtrar transferência conta poupança");
        return this;
    }

    /**
     * Espera valor saldo conta corrente a ser exibo;
     *
     * @throws Exception
     */
    @Step("Retornar valor saldo conta poupança")
    public void verificarValorSaldoContaPoupanca() throws Exception {
        aguardarCarregamentoElemento(valorSaldoContaPoupanca);
        String valorContaPoupanca = retornarTexto(valorSaldoContaPoupanca, "Não foi possível obter o valor do saldo atual");
        salvarEvidencia("Clicado botao mostrar saldo inicial conta poupanca: " + valorContaPoupanca);
    }

    /**
     * Retornar valor 'Saldo Conta Poupança' atual;
     *
     * @throws Exception
     */
    @Step("Retorna valor saldo conta poupança")
    public String retornarValorSaldoAtual() throws Exception {
        return retornarTexto(valorSaldoContaPoupanca, "Não foi possível obter o valor do saldo atual");
    }

    /**
     * Retornar valor atual calculado incluso o valor da tarifa apos a transferência;
     *
     * @param valorTransferencia
     * @param valorInicial
     * @return
     */
    private Integer calcularValorAtualContaPoupanca(String valorTarifa, String valorTransferencia, String valorInicial) {
        valorInicial = Utilitarios.normalizaStringNumero(valorInicial);
        valorTransferencia = Utilitarios.normalizaStringNumero(valorTransferencia);
        valorTarifa = Utilitarios.normalizaStringNumero(valorTarifa);
        Integer valorAtualCalculadoComTarifa = (Integer.parseInt(valorInicial) - Integer.parseInt(valorTransferencia)) - Integer.parseInt(valorTarifa);
        return valorAtualCalculadoComTarifa;
    }

    /**
     * Clicar no botão mostrar saldo da conta poupança com tarifa calculada;
     *
     * @return mostrarSaldoExtrato
     * @throws Exception
     */
    @Step("Clicando no botão saldo e extrato sensibilizado da conta")
    public SaldoContaPoupancaTela validarValorSaldoContaPoupancaAposTransferencia(String valorTarifa, String valorTransferencia, String valorInicial) throws Exception {
        aguardarCarregamentoElemento(valorSaldoContaPoupanca);
        String valorContaPoupancaAtual = calcularValorAtualContaPoupanca(valorTarifa, valorTransferencia, valorInicial).toString();
        validarAtributoTexto(valorSaldoContaPoupanca, "R$: " + Utilitarios.normalizaStringNumero(valorContaPoupancaAtual), "Nenhum valor foi debitado da conta");
        salvarEvidencia("Clicado botao mostrar saldo sensibilizado R$: " + valorContaPoupancaAtual);
        return this;
    }
}
