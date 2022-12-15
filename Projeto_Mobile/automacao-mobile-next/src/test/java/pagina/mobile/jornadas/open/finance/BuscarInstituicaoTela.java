package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class BuscarInstituicaoTela extends PaginaBase {

    public BuscarInstituicaoTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/rl_card_details\"])/following::*[contains(@text,\"next\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"next\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"next\"]")
    private MobileElement botaoBancoNext;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/rl_card_details\"])/following::*[contains(@text,\"next\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Escolher instituição\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Escolher instituição\"")
    private MobileElement campoLupaEscolherInstituicao;

    /**
     * Tocar botão "NEXT"
     * fr
     * @return TutorialOpenFinanceTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public BuscarInstituicaoTela tocarBotaoBancoNext() throws Exception {
        salvarEvidencia("Tocar botão \"Next\"");
        if (android) esconderTeclado();
        tocarElemento(botaoBancoNext, "Não foi possivel tocar botão \"Next\"");
        return this;
    }


}
