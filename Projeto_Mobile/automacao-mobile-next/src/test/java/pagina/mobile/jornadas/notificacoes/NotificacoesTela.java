package pagina.mobile.jornadas.notificacoes;

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
import org.openqa.selenium.By;

import java.util.Objects;

public class NotificacoesTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @AndroidFindBy(id ="br.com.bradesco.next:id/animated_view")
    private MobileElement botaoMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "NOTIFICA��ES")
    @AndroidFindBy(id ="br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Notifica��es\"]")
    @iOSXCUITFindBy(accessibility = "Notifica��es")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NOTIFICA��ES\"]")
    private MobileElement textoTituloTela;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Ver mais\")]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"VER MAIS\"])[1]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nt_know_more_nt")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"VER MAIS\"]")
    private MobileElement botaoNoCardVerMais;

    public NotificacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'NOTIFICA��ES'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Notifica��es'")
    public NotificacoesTela validarPresencaNotificacoesTela() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoTituloTela) ||
                        !Objects.equals(aguardarPaginaConterQualquerTexto("Notifica��es", "NOTIFICA��ES"), ""),
                MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar a tela 'Notifica��es'");
        salvarEvidencia("Validou a tela 'Notifica��es'");
        return this;
    }

    /** Tocar botao 'Menu'
     * @return
     * @throws NextException
     */
    @Step("Tocar botao 'Menu'")
    public NotificacoesTela voltarMenu() throws NextException {
        salvarEvidencia("Tocar botao 'Menu'");
        tocarElemento(botaoMenu,"Nao foi possivel tocar no elemento 'Menu'");
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
     * Validar a mensagem no card de Notifica��es
     * @param textoMensagem
     * @return
     * @throws Exception
     */
    @Step("Validar a mensagem no card de Notifica��es")
    public NotificacoesTela validarTextoDoCard(String textoMensagem) throws Exception {

        validarCondicaoBooleana((ios ?
                verificarPresencaElemento(By.xpath("//XCUIElementTypeButton[contains(@text,\"" + textoMensagem + "\")]")) :
                verificarPresencaElemento(By.xpath("//android.widget.Button[contains(@content-desc,\"" + textoMensagem + "\")]"))),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao localizar a mensagem: '" + textoMensagem + "' no card");
        salvarEvidencia("Validou a mensagem: '" + textoMensagem + "' no Card de Notifica��es.");

        return this;
    }

}


