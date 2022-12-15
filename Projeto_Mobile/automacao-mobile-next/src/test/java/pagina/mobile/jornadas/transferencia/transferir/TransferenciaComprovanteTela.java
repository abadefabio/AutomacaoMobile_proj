package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;


public class TransferenciaComprovanteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Compartilhar\")]")
    @iOSXCUITFindBy(id = "Compartilhar")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Compartilhar\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Compartilhar\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/item_share']")
    @AndroidFindBy(xpath = "//*[contains(@text,'Enviar')]")
    @AndroidFindBy(accessibility = "Enviar por e-mail") // embora não signifique necessariamente enviar por e-mail
    private MobileElement botaoCompartilhar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "android:id/resolver_list")
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/resolver_list']")
    private MobileElement painelConteudo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_container")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Voltar\")]")
    private MobileElement botaoVoltarFechar;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\" and @visible='true']")
    @iOSXCUITFindBy(accessibility = "Cancelar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancelar\"]")
    private MobileElement botaoCancelarFecharIos;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "ActivityListView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"ActivityListView\"]")
    private MobileElement activityListView;

    public TransferenciaComprovanteTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botão "Voltar <"
     *
     * @return TransferenciaComprovanteTela
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public TransferenciaComprovanteTela tocarBotaoVoltarFechar() throws Exception {
        salvarEvidencia("Tocar botão \"Voltar\"");
        tocarElemento(botaoVoltarFechar, "Não foi possível tocar o botão 'Fechar'");
        return this;
    }

    /**
     * Tocar botão "Compartilhar [->]"
     *
     * @return TransferenciaComprovanteTela
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public TransferenciaComprovanteTela tocarBotaoCompartilhar() throws Exception {
        salvarEvidencia("Tocar botão \"Compartilhar\"");
        tocarElemento(botaoCompartilhar, "Não foi possível tocar o botão \"Compartilhar\"");
        return this;
    }

    /**
     * Voltar a qualquer tela anterior utilizando métodos de Voltar do sistema operacional
     *
     * @return
     * @throws Exception
     */
    @Step("confirmar Compartilhamento")
    public TransferenciaComprovanteTela voltarAoComprovante() throws Exception {

        class Tentativas {
            int tentativas = 0;
            Tentativas(int tentativas) {
                this.tentativas = tentativas;
            }
            boolean estaoEsgotadas() {
                tentativas--;
                if (tentativas <= 0)
                    return false;
                else
                    return true;
            }
        }

        if (android) {
            aguardarOcultacaoElemento(botaoVoltarFechar);
            Tentativas tentativas = new Tentativas(4);
            while (!verificarPresencaElemento(botaoVoltarFechar) || !tentativas.estaoEsgotadas()) {
                salvarEvidencia("Voltando à tela do comprovante...");
                voltarTelaAnterior();
            }
        } else {
            aguardarCarregamentoElemento(activityListView);
            salvarEvidencia("Voltando à tela do comprovante...");
            tocarElemento(botaoCancelarFecharIos, "Não foi possível tocar o botão \"Cancelar/Fechar\"");
        }
        return this;
    }
}
