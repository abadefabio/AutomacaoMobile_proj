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
    @AndroidFindBy(accessibility = "Menu, Bot�o")
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
    @AndroidFindBy(xpath = "//*[contains(@text, \"D�bitos de ve�culos\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"D�bito de ve�culos\")]")
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
     * Tocar bot�o "Debito Veiculos SP"
     *
     * @return PagamentosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Debito Veiculos SP\"")
    public PagamentosTela tocarCelulaDebitoDeVeiculos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(celulaDebitoDeVeiculos,"N�o foi possivel tocar bot�o \"D�bito de ve�culos\"");
        tocarElemento(celulaDebitoDeVeiculos, "N�o foi possivel tocar bot�o \"Debito Veiculos\"");
        salvarEvidencia("Tocar bot�o \"Debito Veiculos\"");
        return this;
    }

    /**
     * Validar presen�a da tela 'Pagamentos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Pagamentos'")
    public PagamentosTela validarPresencaTelaPagamentos() throws Exception {
        esperarCarregando();
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.PAGAMENTOS), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Pagamentos' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'Pagamentos'");
        return this;
    }

    /**
     * Validar carregamento do t�tulo da tela "PAGAMENTOS"
     *
     * @return
     */
    @Step("Validar carregamento do t�tulo da tela \"PAGAMENTOS\"")
    public PagamentosTela validarExibicaoTextoPagamantos() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoPagamentos), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o carregamento do t�tulo da tela Pagamentos");
        salvarEvidencia("Validar carregamento do t�tulo da tela Pagamentos");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public PagamentosTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Tocar 'Pagar com c�digo de barras'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Pagar com c�digo de barras'")
    public PagamentosTela tocarPagarComCodigoDeBarras() throws Exception {

        aguardarCarregamentoElemento(botaoPagarComCodigoDeBarras);
        salvarEvidencia("Tocar bot�o 'Pagar com c�digo de barras'");
        aguardarElementoHabilitado(botaoPagarComCodigoDeBarras);
        tocarElemento(botaoPagarComCodigoDeBarras, "N�o foi poss�vel tocar no Bot�o 'Pagar com c�digo de barras'");
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

        pagamento = retornarElemento(locator, "N�o foi poss�vel localizar o pagamento!");

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(pagamento, "N�o foi poss�vel encontrar o pagamento: " + tituloPagamento);

        tocarElemento(pagamento, "N�o foi poss�vel tocar no pagamento: " + tituloPagamento);

        salvarEvidencia("Tocado pagamento: " + tituloPagamento);

        return this;
    }

    /**
     * Tocar bot�o 'Comprovantes'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Comprovantes'")
    public PagamentosTela tocarBotaoComprovante() throws Exception {
        salvarEvidencia("Tocar no bot�o comprovantes");
        tocarElemento(botaoComprovante, "N�o foi poss�vel clicar no bot�o 'Comprovantes'");
        return this;
    }

}
