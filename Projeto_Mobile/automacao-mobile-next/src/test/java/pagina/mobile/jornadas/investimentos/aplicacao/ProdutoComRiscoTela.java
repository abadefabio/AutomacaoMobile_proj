package pagina.mobile.jornadas.investimentos.aplicacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutoComRiscoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_discover_profile")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Descobrir perfil'`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Descobrir perfil']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Descobrir')]")
    private MobileElement botaoDescobrirPerfil;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_investment")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Continuar Investimento']")
    private MobileElement botaoContinuarInvestimento;

    public ProdutoComRiscoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Descobrir Perfil'
     *
     * @return PerfilInvestidorTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Descobrir Perfil'")
    public ProdutoComRiscoTela tocarBotaoDescobrirPerfil() throws Exception {
        aguardarCarregamentoElemento(botaoDescobrirPerfil);
        salvarEvidencia( "Tocar no bot�o 'Descobrir Perfil'");
        tocarElemento(botaoDescobrirPerfil, "N�o foi poss�vel tocar no bot�o 'Descobrir Perfil'");
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar Investimento' (Para continuar com o investimento de risco sem ter um perfil de investidor)
     *
     * @return PerfilInvestidorTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Continuar Investimento'")
    public ProdutoComRiscoTela tocarBotaoContinuarInvestimento() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarInvestimento);
        salvarEvidencia( "Tocar no bot�o 'Continuar Investimento'");
        tocarElemento(botaoContinuarInvestimento, "N�o foi poss�vel tocar no bot�o 'Continuar Investimento'");
        return this;
    }
}
