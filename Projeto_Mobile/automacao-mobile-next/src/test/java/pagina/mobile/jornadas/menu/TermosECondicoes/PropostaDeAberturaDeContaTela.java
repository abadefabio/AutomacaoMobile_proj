package pagina.mobile.jornadas.menu.TermosECondicoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;


public class PropostaDeAberturaDeContaTela extends PaginaBase {

    public PropostaDeAberturaDeContaTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"fechar\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fechar\"`]")
    private MobileElement botaoFechar;

    /**
     * Tocar botão 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Fechar'")
    public PropostaDeAberturaDeContaTela tocarFechar() throws Exception {
        tocarElemento(botaoFechar, "Erro ao tentar tocar no botao 'Fechar'");
        salvarEvidencia("Botão 'Fechar' tocado");
        return this;
    }
}
