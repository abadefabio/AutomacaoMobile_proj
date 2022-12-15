package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.qameta.allure.Step;

public class PopUpSalvar extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id ="br.com.bradesco.next:id/nl_message_title")
    @AndroidFindBy(xpath = "//me.next.uikit.NextLabel[contains(@text,'Quer salvar')]")
    private MobileElement mensagemPopUp;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id ="br.com.bradesco.next:id/nb_primary_button")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='SIM']")
    private MobileElement radioSim;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_secondary_button")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='NÃO']")
    private MobileElement radioNao;

    public PopUpSalvar(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar radio button sim
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar radio button sim")
    public PopUpSalvar tocarRadioButtonSim() throws Exception {
        salvarEvidencia("Tocar radio button sim");
        tocarElemento(radioSim, "Não foi possível tocar radio button sim");
        return this;
    }

    /**
     * Tocar radio button não
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar radio button não")
    public PopUpSalvar tocarRadioButtonNao() throws Exception {
        salvarEvidencia("Tocar radio button não");
        tocarElemento(radioNao, "Não foi possível tocar radio button não");
        return this;
    }
}
