package pagina.mobile.perfil;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MobilePerfilPopupTela extends PaginaBase {

    public MobilePerfilPopupTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_positive")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"br.com.bradesco.next:id/nb_positive\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'SIM')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SIM\"`]")
    @iOSXCUITFindBy(accessibility = "SIM")
    private MobileElement botaoSim;

    /**
     * Tocar bot�o 'SIM'
     * @throws Exception
     */
    @Step ("Tocar bot�o 'Sair do App'")
    public MobilePerfilPopupTela tocarBotaoSim() throws Exception {
        salvarEvidencia("Tocar bot�o 'Sim'");
        tocarElemento(botaoSim, "N�o foi poss�vel tocar o bot�o 'Sim' no popup");
        return this;
    }

}
