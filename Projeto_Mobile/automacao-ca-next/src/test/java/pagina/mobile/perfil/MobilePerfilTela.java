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
    @Step ("Tocar botão 'Sair do App'")
    public MobilePerfilTela tocarBotaoSairApp() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSairApp, "Não foi possível encontrar o botão 'Sair do App'");
        salvarEvidencia("Tocar botão 'Sair do App'");
        tocarElemento(botaoSairApp, "Não foi possível tocar o botão 'Sair do App'" );
        return this;
    }

}
