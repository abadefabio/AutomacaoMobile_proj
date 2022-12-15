package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class TransferenciaAgendamentoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_view_receipt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\" Visualizar\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Visualizar\")]")
    @iOSXCUITFindBy(accessibility = "Visualizar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \" Visualizar\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "'label == \" Visualizar\" AND value == \" Visualizar\"'")
    private MobileElement botaoVisualizar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_container")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"Fechar\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Fechar\")]")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_category")
    @iOSXCUITFindBy(accessibility = "icon-transfer-home")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-transfer-home\"]")
    private MobileElement logoComprovante;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"AGENDAMENTO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"AGENDAMENTO\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"AGENDAMENTO\"")
    private MobileElement tituloTelaComprovanteAgendamento;

    public TransferenciaAgendamentoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botão "Visualizar"
     *
     * @return TransferenciaComprovanteTela
     * @throws Exception
     */
    @Step("Tocar botão \"Visualizar\"")
    public TransferenciaAgendamentoTela tocarBotaoVisualizar() throws Exception {
        salvarEvidencia("Tocar botão \"Visualizar\"");
        tocarElemento(botaoVisualizar, "Não foi possível tocar no botão 'Visualizar'");
        return this;
    }

    /**
     * Tocar botão "Fechar (X)"
     *
     * @return TransferenciaComprovanteTela
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public TransferenciaAgendamentoTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("Tocar botão \"Fechar\"");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar'");
        return this;
    }

    /**
     * validar que esta na tela de comprovante agendamento - Logo
     *
     * @return TransferenciaComprovanteTela
     * @throws Exception
     */
    @Step("validar comprovante agendamento \"Logo\"")
    public TransferenciaAgendamentoTela validarComprovanteLogo() throws Exception {
        aguardarCarregamentoElemento(logoComprovante);
        salvarEvidencia("Validação do Comprovante de agendamento.");
        if (android) {
            validarCondicaoBooleana(verificarPresencaElemento(logoComprovante), MetodoComparacaoBooleano.VERDADEIRO, "Nao foi possivel encontrar Logo no comprovante: ");
        }
        return this;
    }

    /**
     * validar Titulo Tela Comprovante - Agendamento
     *
     * @return TransferenciaComprovanteTela
     * @throws Exception
     */
    @Step("validar comprovante \"Titulo tela\"")
    public TransferenciaAgendamentoTela validarTituloTelaComprovanteAgendamento() throws Exception {
        aguardarCarregamentoElemento(tituloTelaComprovanteAgendamento);
        salvarEvidencia("Validação do Comprovante de agendamento.");
        validarCondicaoBooleana(verificarPresencaElemento(tituloTelaComprovanteAgendamento), MetodoComparacaoBooleano.VERDADEIRO, "Nao foi possivel encontrar Logo no comprovante: ");
        return this;
    }
}
