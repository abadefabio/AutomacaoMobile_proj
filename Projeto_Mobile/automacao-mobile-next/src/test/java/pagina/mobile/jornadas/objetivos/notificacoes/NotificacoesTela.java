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

    @AndroidFindBy(accessibility = "NOTIFICA��ES")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NOTIFICA��ES\"]")
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
     * Validar a tela 'Notifica��o'
     * @return
     */
    @Step("Validar a tela 'Notifica��o'")
    public NotificacoesTela validarTelaNotificacao(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloNotificacao),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar a tela 'Notifica��o'");
        salvarEvidencia("Validou a tela 'Notifica��o'");
        return this;
    }

    /**
     * Tocar no bot�o: 'Ver Mais'
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o: 'Ver Mais'")
    public NotificacoesTela tocarBotaoVerMais() throws NextException {
        salvarEvidencia("Tocar no bot�o: 'Ver Mais'");
        tocarElemento(botaoNoCardVerMais,"Erro ao tocar no bot�o 'Ver Mais'.");
        return this;
    }

    /**
     * Tocar no bot�o: 'Editar valor'
     * fr
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o: 'Editar valor'")
    public NotificacoesTela tocarBotaoEditarValor() throws NextException {
        salvarEvidencia("Tocar no bot�o: 'Editar valor'");
        tocarElemento(botaoEditarValor,"Erro ao tocar no bot�o 'Editar valor'.");
        return this;
    }

    /**
     * Tocar no bot�o: 'Resgatar'
     * fr
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o: 'Resgatar'")
    public NotificacoesTela tocarBotaoResgatar() throws NextException {
        salvarEvidencia("Tocar no bot�o: 'Resgatar'");
        tocarElemento(botaoResgatar,"Erro ao tocar no bot�o 'Resgatar'.");
        return this;
    }
}
