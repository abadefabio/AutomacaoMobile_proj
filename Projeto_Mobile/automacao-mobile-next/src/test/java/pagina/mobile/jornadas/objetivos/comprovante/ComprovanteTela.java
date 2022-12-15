package pagina.mobile.jornadas.objetivos.comprovante;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ComprovanteTela extends PaginaBase {

    //titulo da tela
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"COMPROVANTE\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"COMPROVANTE\"]")
    @AndroidFindBy(accessibility = "COMPROVANTE")
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"COMPROVANTE\"]")
    private MobileElement textoTituloTela;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @AndroidFindBy(accessibility = "Enviar por e-mail")
    @iOSXCUITFindBy(accessibility = "Compartilhar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Compartilhar\"`]")
    private MobileElement botaoCompartilhar;

    //arquivo pdf
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name,\"Comprovante de Aplicac?a?o Fundos\")])[4]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name,\"Se na?o ficar satisfeito com a soluc?a?o apresentada, contate a ouvidoria\")])[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name,\"Central de Relacionamento Next\")])[3]")
    @AndroidFindBy(accessibility = "N�o � poss�vel acessar o comprovante.")
    @AndroidFindBy(id = "br.com.bradesco.next:id/pdfView")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"N�o � poss�vel acessar o comprovante.\"]")
    private MobileElement textoArquivoPDF;

    //botao voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    @AndroidFindBy(accessibility = "bot�o fechar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_container")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"bot�o fechar\"]")
    private MobileElement botaoVoltar;

    //botao ver resultado
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver resultado\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ver resultado\"]")
    @AndroidFindBy(id="br.com.bradesco.next:id/bt_result")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Ver resultado\")]")
    private MobileElement botaoVerResultado;

    public ComprovanteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a do t�tulo 'COMPROVANTE'
     * @return
     * @throws NextException
     */
    @Step("Validar presen�a do t�tulo 'COMPROVANTE'")
    public ComprovanteTela validarPresencaTituloComprovante() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoTituloTela), MetodoComparacaoBooleano.VERDADEIRO, "O t�tulo 'COMPROVANTE', n�o est� na tela");
        salvarEvidencia("Validado t�tulo 'COMPROVANTE' est� presente na tela");
        return this;
    }

    /**
     * Tocar bot�o 'Compartilhar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Compartilhar'")
    public ComprovanteTela tocarBotaoCompartilhar() throws Exception {
        tocarElemento(botaoCompartilhar, "N�o foi poss�vel tocar no bot�o 'Compartilhar'");
        salvarEvidencia("Tocado bot�o 'Compartilhar'");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public ComprovanteTela tocarBotaoVoltarComprovante() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }
}
