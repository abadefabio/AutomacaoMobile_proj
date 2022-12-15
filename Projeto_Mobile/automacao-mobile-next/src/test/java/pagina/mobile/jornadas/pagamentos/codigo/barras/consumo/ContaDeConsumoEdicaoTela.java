package pagina.mobile.jornadas.pagamentos.codigo.barras.consumo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import framework.AcoesGerais;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.constantes.MetodoComparacaoBooleano.VERDADEIRO;
import static constantes.pagamentos.TituloTela.CONTA_DE_CONSUMO;

public class ContaDeConsumoEdicaoTela extends PaginaBase {

    public ContaDeConsumoEdicaoTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_description")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='br.com.bradesco.next:id/et_description']")
    @iOSXCUITFindBy(accessibility = "Descri��o")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Descri��o\"`]")
    private MobileElement textoDescricaoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Agendar pagamento")
    @AndroidFindBy(id = "br.com.bradesco.next:id/sw_schedule")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icon expansible cell' and @visible='true']/..") //estrat�gia para localizar o elemento pai e realizar toque proporcional
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icon expansible cell'/..") //estrat�gia para localizar o elemento pai e realizar toque proporcional
    private MobileElement switchAgendarPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Agendar Agora\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Agendar')]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'Agendar')]")
    private MobileElement botaoAgendarAgora;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_current_account")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc,\"Conta Corrente\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Conta corrente\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@label,\"Conta corrente\")]")
    private MobileElement radioButtonContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_savings_account")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc,\"Conta Poupan�a\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Conta poupan�a\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@label,\"Conta poupan�a\")]")
    private MobileElement radioButtonContaPoupanca;

    /**
     * Validar a presen�a do t�tulo conta de consumo na tela
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Validar a presen�a do t�tulo conta de consumo na tela")
    public ContaDeConsumoEdicaoTela validarTextoTituloContaConsumo() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(CONTA_DE_CONSUMO), VERDADEIRO, "Titulo '" + CONTA_DE_CONSUMO + "' nao esta presente na tela");
        salvarEvidencia("Validado titulo '" + CONTA_DE_CONSUMO + "' presente na tela");
        return this;
    }

    /**
     * Validar o codigo de barras e valor da conta de consumo
     *
     * @param codigoDeBarras
     * @param valor
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Validar o c�digo de barras e valor da conta de consumo")
    public ContaDeConsumoEdicaoTela validarInformacoesContaConsumo(String codigoDeBarras, String valor) {
        if (!aguardarPaginaConterTodosTextos(codigoDeBarras)) {
            rolarTelaAteInicio(1);
        }
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(codigoDeBarras, valor), VERDADEIRO, "Erro ao localizar o c�digo de barras '" + codigoDeBarras + "' e o valor '" + valor);
        salvarEvidencia("Validado o c�digo de barras '" + codigoDeBarras + "' e o valor '" + valor + "' informados da conta de consumo");
        return this;
    }

    /**
     * Preencher o campo 'Descri��o' do pagamento
     *
     * @param descricaoPagamento
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Preencher o campo 'Descri��o' do pagamento")
    public ContaDeConsumoEdicaoTela preencherDescricaoPagamento(String descricaoPagamento) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoDescricaoPagamento, "N�o foi poss�vel localizar o campo de descri��o de pagamento");
        escreverTexto(textoDescricaoPagamento, descricaoPagamento, "Nao foi possivel escrever a descricao do pagamento ");
        salvarEvidencia("Preenchido campo 'Descri��o' com " + descricaoPagamento);
        return this;
    }

    /**
     * Tocar no switch 'Agendar Pagamento'
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Tocar no switch 'Agendar Pagamento'")
    public ContaDeConsumoEdicaoTela tocarSwitchAgendarPagamento() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar no switch 'Agendar Pagamento'");
        if (android)
            tocarElemento(switchAgendarPagamento, "Nao foi poss�vel tocar no switch 'Agendar Pagamento'");
        else
            new AcoesGerais((AppiumDriver) driver)
                    .tocarCoordenadaProporcional(switchAgendarPagamento, 85, 50);
        return this;
    }

    /**
     * Tocar no bot�o 'Agendar Agora'
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Agendar Agora'")
    public ContaDeConsumoEdicaoTela tocarBotaoAgendarAgora() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar no bot�o 'Agendar Agora'");
        tocarElemento(botaoAgendarAgora, "Nao foi poss�vel tocar no bot�o 'Agendar Agora'");
        return this;
    }

    /**
     * Tocar no bot�o conta corrente
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Conta Corrente'")
    public ContaDeConsumoEdicaoTela tocarBotaoContaCorrente() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Conta Corrente'");
        tocarElemento(radioButtonContaCorrente, "Nao foi poss�vel tocar no bot�o 'Conta Corrente'");
        return this;
    }

    /**
     * Tocar no bot�o conta poupanca
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Conta Poupan�a'")
    public ContaDeConsumoEdicaoTela tocarBotaoContaPoupanca() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Conta Poupan�a'");
        tocarElemento(radioButtonContaPoupanca, "Tocar no bot�o 'Conta Poupan�a'");
        return this;
    }
}
