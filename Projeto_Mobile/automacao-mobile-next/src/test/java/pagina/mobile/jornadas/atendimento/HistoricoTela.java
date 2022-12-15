package pagina.mobile.jornadas.atendimento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class HistoricoTela extends PaginaBase {


    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"HIST�RICO\"]")
    private MobileElement tituloTelaHistorico;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=Voltar, Bot�o]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_phone")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=Consultar telefones e e-mail]")
    @iOSXCUITFindBy(accessibility = "Consultar telefones e e-mail")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Consultar telefones e e-mail\"]")
    private MobileElement botaoTelefone;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//me.next.uikit.NextLabel[contains(@text,'N�o encontrei nenhum')]")
    @iOSXCUITFindBy(accessibility = "Lista vazia")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"Lista vazia\"]")
    private MobileElement textoSemHistoricoChat;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_start_chat")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='INICIAR CHAT']")
    @iOSXCUITFindBy(accessibility = "INICIAR CHAT")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"INICIAR CHAT\"]")
    private MobileElement botaoIniciarChat;

    public HistoricoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Historico Tela'
     *
     * @return HistoricoTela
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Historico'")
    public HistoricoTela validarPresencaHistoricoTela() {
        validarCondicaoBooleana(verificarPresencaElemento(tituloTelaHistorico),MetodoComparacaoBooleano.VERDADEIRO,"N�o foi possivel validar presen�a na tela hist�rico");
        salvarEvidencia("Validada presen�a da tela 'Historico'");
        return this;
    }

    /**
     * Tocar bot�o "Voltar"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public HistoricoTela tocarBotaoVoltar() throws Exception {
        tocarElemento(botaoVoltar, "N�o foi possivel tocar no bot�o 'Voltar'");
        salvarEvidencia("Tocar bot�o 'Voltar'");
        return this;
    }

    /**
     * Validar presen�a texto sem historico de chat
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a texto sem historico de chat")
    public HistoricoTela validarTextoSemHistoricoChat() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(textoSemHistoricoChat), MetodoComparacaoBooleano.VERDADEIRO, "Texto n�o presente na tela");
        salvarEvidencia("Texto para chat sem historio validado com sucesso");
        return this;
    }

}


