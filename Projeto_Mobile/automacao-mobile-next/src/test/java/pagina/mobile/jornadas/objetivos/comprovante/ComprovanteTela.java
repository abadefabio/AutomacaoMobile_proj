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
    @AndroidFindBy(accessibility = "Não é possível acessar o comprovante.")
    @AndroidFindBy(id = "br.com.bradesco.next:id/pdfView")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc=\"Não é possível acessar o comprovante.\"]")
    private MobileElement textoArquivoPDF;

    //botao voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    @AndroidFindBy(accessibility = "botão fechar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_container")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"botão fechar\"]")
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
     * Validar presença do título 'COMPROVANTE'
     * @return
     * @throws NextException
     */
    @Step("Validar presença do título 'COMPROVANTE'")
    public ComprovanteTela validarPresencaTituloComprovante() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoTituloTela), MetodoComparacaoBooleano.VERDADEIRO, "O título 'COMPROVANTE', não está na tela");
        salvarEvidencia("Validado título 'COMPROVANTE' está presente na tela");
        return this;
    }

    /**
     * Tocar botão 'Compartilhar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Compartilhar'")
    public ComprovanteTela tocarBotaoCompartilhar() throws Exception {
        tocarElemento(botaoCompartilhar, "Não foi possível tocar no botão 'Compartilhar'");
        salvarEvidencia("Tocado botão 'Compartilhar'");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public ComprovanteTela tocarBotaoVoltarComprovante() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }
}
