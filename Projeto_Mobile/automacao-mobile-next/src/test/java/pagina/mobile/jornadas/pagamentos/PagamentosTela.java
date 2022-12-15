package pagina.mobile.jornadas.pagamentos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pagamentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PagamentosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Menu, Botão")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(accessibility = "PAGAMENTOS")
    @iOSXCUITFindBy(accessibility = "PAGAMENTOS")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[lower-case(@name) = \"pagamentos\"]")
    private MobileElement textoPagamentos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text, \"Débitos de veículos\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"Débito de veículos\")]")
    private MobileElement celulaDebitoDeVeiculos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text, \"Boleto\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Boleto')]")
    private MobileElement botaoPagarComCodigoDeBarras;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_receipt")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Comprovante']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Comprovante\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Comprovante\"]")
    private MobileElement botaoComprovante;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PAGAMENTOS\"]")
    private MobileElement tituloPagamentos;

    public PagamentosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela "PAGAMENTOS"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Validar tela \"PAGAMENTOS\"")
    public PagamentosTela validarTelaPagamentos() throws Exception {
        aguardarCarregamentoElemento(textoPagamentos);
        validarAtributoTexto(textoPagamentos, TituloTela.PAGAMENTOS, "Erro ao validar tela \"PAGAMENTOS\"");
        salvarEvidencia("Validar tela \"PAGAMENTOS\"");
        return this;
    }

    /**
     * Tocar botão "Debito Veiculos SP"
     *
     * @return PagamentosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Debito Veiculos SP\"")
    public PagamentosTela tocarCelulaDebitoDeVeiculos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(celulaDebitoDeVeiculos,"Não foi possivel tocar botão \"Débito de veículos\"");
        tocarElemento(celulaDebitoDeVeiculos, "Não foi possivel tocar botão \"Debito Veiculos\"");
        salvarEvidencia("Tocar botão \"Debito Veiculos\"");
        return this;
    }

    /**
     * Validar presença da tela 'Pagamentos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Pagamentos'")
    public PagamentosTela validarPresencaTelaPagamentos() throws Exception {
        esperarCarregando();
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.PAGAMENTOS), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Pagamentos' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'Pagamentos'");
        return this;
    }

    /**
     * Validar carregamento do título da tela "PAGAMENTOS"
     *
     * @return
     */
    @Step("Validar carregamento do título da tela \"PAGAMENTOS\"")
    public PagamentosTela validarExibicaoTextoPagamantos() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoPagamentos), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o carregamento do título da tela Pagamentos");
        salvarEvidencia("Validar carregamento do título da tela Pagamentos");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public PagamentosTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Tocar 'Pagar com código de barras'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Pagar com código de barras'")
    public PagamentosTela tocarPagarComCodigoDeBarras() throws Exception {

        aguardarCarregamentoElemento(botaoPagarComCodigoDeBarras);
        salvarEvidencia("Tocar botão 'Pagar com código de barras'");
        aguardarElementoHabilitado(botaoPagarComCodigoDeBarras);
        tocarElemento(botaoPagarComCodigoDeBarras, "Não foi possível tocar no Botão 'Pagar com código de barras'");
        return this;
    }

    /**
     * Tocar pagamento realizado / Agendado
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar pagamento realizado / Agendado")
    public PagamentosTela tocarPagamentoRealizado(String tituloPagamento) throws Exception {
        MobileElement pagamento = null;
        By locator;
        if (ios) {
            locator = By.xpath("(//XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name, '" + tituloPagamento + "')])[1]");

        } else {
            locator = By.xpath("//android.widget.LinearLayout/android.widget.RelativeLayout//android.widget.TextView[contains(@text, '" + tituloPagamento + "')]");
        }

        pagamento = retornarElemento(locator, "Não foi possível localizar o pagamento!");

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(pagamento, "Não foi possível encontrar o pagamento: " + tituloPagamento);

        tocarElemento(pagamento, "Não foi possível tocar no pagamento: " + tituloPagamento);

        salvarEvidencia("Tocado pagamento: " + tituloPagamento);

        return this;
    }

    /**
     * Tocar botão 'Comprovantes'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Comprovantes'")
    public PagamentosTela tocarBotaoComprovante() throws Exception {
        salvarEvidencia("Tocar no botão comprovantes");
        tocarElemento(botaoComprovante, "Não foi possível clicar no botão 'Comprovantes'");
        return this;
    }

}
