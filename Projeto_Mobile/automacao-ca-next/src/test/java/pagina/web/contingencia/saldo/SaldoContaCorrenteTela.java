package pagina.web.contingencia.saldo;


import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.tools.Utilitarios;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaldoContaCorrenteTela extends PaginaBaseWeb {

    public SaldoContaCorrenteTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//span[@id='currentBalanceLabel'])[1]")
    private WebElement campoSaldo;

    @FindBy(xpath = "(//button[@id='iconShowBalance'])[1]")
    private WebElement iconeMostrarSaldo;

    @FindBy(id = "Saldo_id")
    private WebElement saldoTitulo;

    @FindBy(xpath = "(//span[@id='currentBalanceLabel'])[1]")
    private WebElement valorSaldoContaCorrente;

    @FindBy(id = "buttonAllContent")
    private WebElement botaoVisualizarGridSaldo;


    /**
     * Clicar Botao Mostrar Saldo
     *
     * @throws Exception
     */
    @Step("Clicar Botao Mostrar Saldo")
    public SaldoContaCorrenteTela clicarBotaoMostrarSaldo() throws Exception {
        aguardarCarregamentoElemento(iconeMostrarSaldo);
        clicarElemento(iconeMostrarSaldo, "Não foi possível clicar na icone Mostrar Saldo");
        return this;
    }

    /**
     * Validar se o título "Saldo" aparece na página de saldo da contingência web.
     *
     * @throws Exception
     */
    @Step("Validar o titulo da página de Saldo")
    public SaldoContaCorrenteTela validarTituloSaldo() throws Exception {
        aguardarCarregamentoElemento(saldoTitulo);
        salvarEvidencia("Validado tela de Saldo");
        validarAtributoTexto(saldoTitulo, "Saldo", "Não foi possível validar a tela Saldo");
        return this;
    }

    /**
     * Espera valor saldo conta corrente a ser exibo;
     *
     * @throws Exception
     */
    @Step("Retornar valor saldo conta corrente")
    public void verificarValorSaldoContaCorrente() throws Exception {
        aguardarCarregamentoElemento(valorSaldoContaCorrente);
        String valorContaCorrente = retornarTexto(valorSaldoContaCorrente, "Não foi possível obter o valor do saldo atual");
        salvarEvidencia("Clicado botão mostrar saldo inicial conta corrente: " + valorContaCorrente);
    }

    /**
     * Retornar valor 'Saldo Conta Corrente' atual;
     *
     * @throws Exception
     */
    @Step("Retorna valor saldo conta corrente'")
    public String retornarValorSaldoAtual() throws Exception {
        return retornarTexto(valorSaldoContaCorrente, "Não foi possível obter o valor do saldo atual");
    }

    /**
     * Retornar valor atual calculado incluso o valor da tarifa apos a transferência;
     *
     * @param valorTransferencia
     * @param valorInicial
     * @return
     */
    private Integer calcularValorAtualContaCorrente(String valorTarifa, String valorTransferencia, String valorInicial) {
        valorInicial = Utilitarios.normalizaStringNumero(valorInicial);
        valorTransferencia = Utilitarios.normalizaStringNumero(valorTransferencia);
        valorTarifa = Utilitarios.normalizaStringNumero(valorTarifa);
        Integer valorAtualCalculadoComTarifa = (Integer.parseInt(valorInicial) - Integer.parseInt(valorTransferencia)) - Integer.parseInt(valorTarifa);
        return valorAtualCalculadoComTarifa;
    }

    /**
     * Clicar no botão mostrar saldo da conta corrente com tarifa calculada;
     *
     * @return mostrarSaldoExtrato
     * @throws Exception
     */
    @Step("Clicando no botão saldo e extrato sensibilizado da conta")
    public SaldoContaCorrenteTela validarValorSaldoContaCorrenteAposTransferencia(String valorTarifa, String valorTransferencia, String valorInicial) throws Exception {
        aguardarCarregamentoElemento(valorSaldoContaCorrente);
        String valorContaCorrenteAtual = calcularValorAtualContaCorrente(valorTarifa, valorTransferencia, valorInicial).toString();
        compararElementoTexto(valorSaldoContaCorrente, "R$: " + Utilitarios.normalizaStringNumero(valorContaCorrenteAtual), MetodoComparacao.IGUAL);
        salvarEvidencia("Clicado botao mostrar saldo sensibilizado R$: " + valorContaCorrenteAtual);
        return this;
    }

    /**
     * Mostrar Saldo Extrato da conta corrente ao clicar no botão 'Corrente' ;
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botão mostrar extrato transferência")
    public SaldoContaCorrenteTela mostrarExtratoContaCorrente() throws Exception {
        aguardarCarregamentoElemento(valorSaldoContaCorrente);
        clicarElemento(botaoVisualizarGridSaldo, "Não foi possível clicar no botão mostrar extrato transferência");
        salvarEvidencia("Clicado botão mostrar extrato transferência" );
        return this;
    }


}
