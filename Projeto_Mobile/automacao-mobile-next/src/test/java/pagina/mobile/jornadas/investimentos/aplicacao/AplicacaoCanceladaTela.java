package pagina.mobile.jornadas.investimentos.aplicacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AplicacaoCanceladaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id="br.com.bradesco.next:id/view_investments")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver investimento\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ver investimento\"]")
    private MobileElement botaoVerInvestimento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    public AplicacaoCanceladaTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no botão 'Ver investimento'
     *
     * @return AplicacaoCanceladaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Ver investimento'")
    public AplicacaoCanceladaTela tocarBotaoVerInvestimento() throws Exception {
        salvarEvidencia( "Tocar no botão 'Ver investimento'");
        tocarElemento(botaoVerInvestimento, "Não foi possível tocar no botão 'Ver investimento'");
        return this;
    }

    /**
     * Tocar no botão 'Fechar' (X)
     *
     * @return AplicacaoCanceladaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Fechar' (X)")
    public AplicacaoCanceladaTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no botão 'Fechar' (X)");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar' (X)");
        return this;
    }
}
