package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ExposicaoPoliticaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id ="br.com.bradesco.next:id/rb_radio")
    @iOSXCUITFindBy(accessibility = "Sim")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Sim\"`]")
    private MobileElement radioSim;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id ="br.com.bradesco.next:id/rbl_no")
    @iOSXCUITFindBy(accessibility = "N�o")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"N�o\"`]")
    private MobileElement radioNao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUAR']")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    private MobileElement botaoContinuar;

    public ExposicaoPoliticaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar radio button sim
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar radio button sim")
    public ExposicaoPoliticaTela tocarRadioButtonSim() throws Exception {
        salvarEvidencia("Tocar radio button sim");
        tocarElemento(radioSim, "N�o foi poss�vel tocar radio button sim");
        return this;
    }

    /**
     * Tocar radio button 'N�o'
     *
     * @return ExposicaoPoliticaTela
     * @throws Exception
     */
    @Step("Tocar radio button 'N�o'")
    public ExposicaoPoliticaTela tocarRadioButtonNao() throws Exception {
        salvarEvidencia("Tocar radio button 'N�o'");
        tocarElemento(radioNao, "N�o foi poss�vel tocar no radio button 'N�o'");
        return this;
    }

    /**
     * Tocar bot�o 'Continuar'
     *
     * @return ExposicaoPoliticaTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Continuar'")
    public ExposicaoPoliticaTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
