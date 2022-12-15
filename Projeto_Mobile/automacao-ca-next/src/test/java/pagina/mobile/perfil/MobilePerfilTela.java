package pagina.mobile.perfil;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.drivers.OperadorDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class MobilePerfilTela extends PaginaBase {

    public MobilePerfilTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"br.com.bradesco.next:id/nb_logout\"));")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_logout")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"br.com.bradesco.next:id/nb_logout\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'SAIR DO APP')]")
    @iOSXCUITFindBy(accessibility = "SAIR DO APP")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"SAIR DO APP\"`]")
    private MobileElement botaoSairApp;

    /**
     * Tocar a foto do cliente
     * @throws Exception
     */
    @Step ("Tocar bot�o 'Sair do App'")
    public MobilePerfilTela tocarBotaoSairApp() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSairApp, "N�o foi poss�vel encontrar o bot�o 'Sair do App'");
        salvarEvidencia("Tocar bot�o 'Sair do App'");
        tocarElemento(botaoSairApp, "N�o foi poss�vel tocar o bot�o 'Sair do App'" );
        return this;
    }

}
