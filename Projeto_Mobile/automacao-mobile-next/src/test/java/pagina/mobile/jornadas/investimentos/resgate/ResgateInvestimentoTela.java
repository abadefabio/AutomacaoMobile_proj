package pagina.mobile.jornadas.investimentos.resgate;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ResgateInvestimentoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Fechar, Bot�o")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Fechar'`]")
    private MobileElement botaoFechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/view_investments")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver meu investimento\"`]")
    private MobileElement botaoVerMeuInvestimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_receipt")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Ver comprovante')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Ver comprovante')]")
    private MobileElement botaoVerComprovante;

    public ResgateInvestimentoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Fechar' (x)
     *
     * @return ResgateInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Fechar' (x)")
    public ResgateInvestimentoTela tocarBotaoFechar() throws Exception {
        aguardarElementoHabilitado(botaoFechar);
        salvarEvidencia("Tocar no bot�o 'Fechar' (x)");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no bot�o 'Fechar' (x)");
        return this;
    }

    /**
     * Tocar no bot�o 'Ver meu investimento'
     *
     * @return ResgateInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Ver meu investimento'")
    public ResgateInvestimentoTela tocarBotaoVerMeuInvestimento() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Ver meu investimento'");
        tocarElemento(botaoVerMeuInvestimento, "N�o foi poss�vel tocar no bot�o 'Ver meu investimento'");
        return this;
    }

    /**
     * Tocar no bot�o 'Ver Comprovante'
     *
     * @return ResgateInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Ver Comprovante'")
    public ResgateInvestimentoTela tocarBotaoVerComprovante() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerComprovante, "N�o foi poss�vel encontrar o bot�o 'Ver Comprovante'");
        salvarEvidencia("Tocar no bot�o 'Ver comprovante'");
        tocarElemento(botaoVerComprovante, "N�o foi poss�vel tocar no bot�o 'Ver Comprovante'");
        return this;
    }
}
