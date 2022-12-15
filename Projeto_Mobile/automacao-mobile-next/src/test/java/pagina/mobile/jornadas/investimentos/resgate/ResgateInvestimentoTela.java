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
    @AndroidFindBy(accessibility = "Fechar, Botão")
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
     * Tocar no botão 'Fechar' (x)
     *
     * @return ResgateInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Fechar' (x)")
    public ResgateInvestimentoTela tocarBotaoFechar() throws Exception {
        aguardarElementoHabilitado(botaoFechar);
        salvarEvidencia("Tocar no botão 'Fechar' (x)");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar' (x)");
        return this;
    }

    /**
     * Tocar no botão 'Ver meu investimento'
     *
     * @return ResgateInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Ver meu investimento'")
    public ResgateInvestimentoTela tocarBotaoVerMeuInvestimento() throws Exception {
        salvarEvidencia("Tocar no botão 'Ver meu investimento'");
        tocarElemento(botaoVerMeuInvestimento, "Não foi possível tocar no botão 'Ver meu investimento'");
        return this;
    }

    /**
     * Tocar no botão 'Ver Comprovante'
     *
     * @return ResgateInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Ver Comprovante'")
    public ResgateInvestimentoTela tocarBotaoVerComprovante() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerComprovante, "Não foi possível encontrar o botão 'Ver Comprovante'");
        salvarEvidencia("Tocar no botão 'Ver comprovante'");
        tocarElemento(botaoVerComprovante, "Não foi possível tocar no botão 'Ver Comprovante'");
        return this;
    }
}
