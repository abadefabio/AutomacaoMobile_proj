package pagina.mobile.jornadas.objetivos.notificacoes;

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

public class NotificacoesTela  extends PaginaBase {

    @AndroidFindBy(accessibility = "NOTIFICAÇÕES")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NOTIFICAÇÕES\"]")
    private MobileElement tituloNotificacao;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Ver mais\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nt_know_more_nt")
    private MobileElement botaoNoCardVerMais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @AndroidFindBy(xpath = "//*[@text='Editar valor']")
    @iOSXCUITFindBy(iOSClassChain = "//XCUIElementTypeButton[@name=\"Resgatar\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Editar valor\"]")
    private MobileElement botaoEditarValor;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_cancel")
    @AndroidFindBy(xpath = "//*[@text='Resgatar']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Resgatar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Resgatar\"]")
    private MobileElement botaoResgatar;

    public NotificacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar a tela 'Notificação'
     * @return
     */
    @Step("Validar a tela 'Notificação'")
    public NotificacoesTela validarTelaNotificacao(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloNotificacao),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar a tela 'Notificação'");
        salvarEvidencia("Validou a tela 'Notificação'");
        return this;
    }

    /**
     * Tocar no botão: 'Ver Mais'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão: 'Ver Mais'")
    public NotificacoesTela tocarBotaoVerMais() throws NextException {
        salvarEvidencia("Tocar no botão: 'Ver Mais'");
        tocarElemento(botaoNoCardVerMais,"Erro ao tocar no botão 'Ver Mais'.");
        return this;
    }

    /**
     * Tocar no botão: 'Editar valor'
     * fr
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão: 'Editar valor'")
    public NotificacoesTela tocarBotaoEditarValor() throws NextException {
        salvarEvidencia("Tocar no botão: 'Editar valor'");
        tocarElemento(botaoEditarValor,"Erro ao tocar no botão 'Editar valor'.");
        return this;
    }

    /**
     * Tocar no botão: 'Resgatar'
     * fr
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão: 'Resgatar'")
    public NotificacoesTela tocarBotaoResgatar() throws NextException {
        salvarEvidencia("Tocar no botão: 'Resgatar'");
        tocarElemento(botaoResgatar,"Erro ao tocar no botão 'Resgatar'.");
        return this;
    }
}
