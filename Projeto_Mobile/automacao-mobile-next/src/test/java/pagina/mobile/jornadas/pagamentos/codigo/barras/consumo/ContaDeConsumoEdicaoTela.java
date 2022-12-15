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
    @iOSXCUITFindBy(accessibility = "Descrição")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Descrição\"`]")
    private MobileElement textoDescricaoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Agendar pagamento")
    @AndroidFindBy(id = "br.com.bradesco.next:id/sw_schedule")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icon expansible cell' and @visible='true']/..") //estratégia para localizar o elemento pai e realizar toque proporcional
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icon expansible cell'/..") //estratégia para localizar o elemento pai e realizar toque proporcional
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
    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc,\"Conta Poupança\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Conta poupança\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@label,\"Conta poupança\")]")
    private MobileElement radioButtonContaPoupanca;

    /**
     * Validar a presença do título conta de consumo na tela
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Validar a presença do título conta de consumo na tela")
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
    @Step("Validar o código de barras e valor da conta de consumo")
    public ContaDeConsumoEdicaoTela validarInformacoesContaConsumo(String codigoDeBarras, String valor) {
        if (!aguardarPaginaConterTodosTextos(codigoDeBarras)) {
            rolarTelaAteInicio(1);
        }
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(codigoDeBarras, valor), VERDADEIRO, "Erro ao localizar o código de barras '" + codigoDeBarras + "' e o valor '" + valor);
        salvarEvidencia("Validado o código de barras '" + codigoDeBarras + "' e o valor '" + valor + "' informados da conta de consumo");
        return this;
    }

    /**
     * Preencher o campo 'Descrição' do pagamento
     *
     * @param descricaoPagamento
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Preencher o campo 'Descrição' do pagamento")
    public ContaDeConsumoEdicaoTela preencherDescricaoPagamento(String descricaoPagamento) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoDescricaoPagamento, "Não foi possível localizar o campo de descrição de pagamento");
        escreverTexto(textoDescricaoPagamento, descricaoPagamento, "Nao foi possivel escrever a descricao do pagamento ");
        salvarEvidencia("Preenchido campo 'Descrição' com " + descricaoPagamento);
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
            tocarElemento(switchAgendarPagamento, "Nao foi possível tocar no switch 'Agendar Pagamento'");
        else
            new AcoesGerais((AppiumDriver) driver)
                    .tocarCoordenadaProporcional(switchAgendarPagamento, 85, 50);
        return this;
    }

    /**
     * Tocar no botão 'Agendar Agora'
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Agendar Agora'")
    public ContaDeConsumoEdicaoTela tocarBotaoAgendarAgora() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar no botão 'Agendar Agora'");
        tocarElemento(botaoAgendarAgora, "Nao foi possível tocar no botão 'Agendar Agora'");
        return this;
    }

    /**
     * Tocar no botão conta corrente
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Conta Corrente'")
    public ContaDeConsumoEdicaoTela tocarBotaoContaCorrente() throws Exception {
        salvarEvidencia("Tocar no botão 'Conta Corrente'");
        tocarElemento(radioButtonContaCorrente, "Nao foi possível tocar no botão 'Conta Corrente'");
        return this;
    }

    /**
     * Tocar no botão conta poupanca
     *
     * @return ContaDeConsumoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Conta Poupança'")
    public ContaDeConsumoEdicaoTela tocarBotaoContaPoupanca() throws Exception {
        salvarEvidencia("Tocar no botão 'Conta Poupança'");
        tocarElemento(radioButtonContaPoupanca, "Tocar no botão 'Conta Poupança'");
        return this;
    }
}
