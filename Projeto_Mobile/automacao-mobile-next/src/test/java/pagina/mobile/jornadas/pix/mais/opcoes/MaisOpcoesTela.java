package pagina.mobile.jornadas.pix.mais.opcoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;

import constantes.pix.Pix;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MaisOpcoesTela extends PaginaBase {
    public MaisOpcoesTela(AppiumDriver driver) {
        super(driver);
    }

    //Botao Menu Meus Limites Pix
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath= "//*[@text=\"Meus Limites Pix\"]")
    @iOSXCUITFindBy(accessibility = "Meus Limites Pix")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Meus Limites Pix\"]/..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Meus Limites Pix\"]/..")
    private MobileElement botaoMenuMeusLimitesPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[contains(@label, 'Ajuda Pix')]/../following-sibling::XCUIElementTypeButton")
    @iOSXCUITFindBy(accessibility = "Ajuda Pix")
    @AndroidFindBy(id = "br.com.bradesco.next:id/v_pix_menu_help")
    private MobileElement botaoAjudaPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[contains(@label, 'Sugest�es ou reclama��es Pix')]/../following-sibling::XCUIElementTypeButton")
    @iOSXCUITFindBy(accessibility = "Sugest�es ou reclama��es Pix")
    @AndroidFindBy(id = "br.com.bradesco.next:id/v_pix_menu_complaint")
    private MobileElement botaoSugestoesOuReclamacoesPix;

    /**
     * Tocar bot�o 'Meus Limites Pix'
     *
     * @return MaisOpcoesTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Meus Limites Pix\"")
    public MaisOpcoesTela tocarBotaoMeusLimitesPix() throws Exception {
        aguardarPaginaConterQualquerTexto(Pix.TITULO_MAIS_OPCOES);
        salvarEvidencia("Tocar no bot�o 'Meus Limites Pix'");
        tocarElemento(botaoMenuMeusLimitesPix, "N�o foi poss�vel Tocar no bot�o Meus Limites Pix");
        return this;
    }

    /**
     * Tocar bot�o 'Ajuda Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ajuda Pix'")
    public MaisOpcoesTela tocarBotaoAjudaPix() throws Exception {
        aguardarPaginaConterQualquerTexto("MAIS OP��ES");
        salvarEvidencia("Tocar no bot�o 'Ajuda Pix'");
        tocarElemento(botaoAjudaPix, "N�o foi poss�vel Tocar no bot�o 'Ajuda Pix'");
        return this;
    }

    /**
     * Tocar bot�o 'Sugest�es ou reclama��es Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Sugest�es ou reclama��es Pix'")
    public MaisOpcoesTela tocarSugestoesOuReclamacoesPix() throws Exception {
        aguardarPaginaConterQualquerTexto("MAIS OP��ES");
        salvarEvidencia("Tocar bot�o 'Sugest�es ou reclama��es Pix'");
        tocarElemento(botaoSugestoesOuReclamacoesPix, "Tocar bot�o 'Sugest�es ou reclama��es Pix'");
        return this;
    }
}
