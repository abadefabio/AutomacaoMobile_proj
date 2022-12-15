package pagina.mobile.menu.TermosECondicoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;


public class TermosECondicoesTela extends PaginaBase {

    public TermosECondicoesTela(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar para o Menu\"`]")
    private MobileElement botaoRetornarMenu;

    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"TERMOS E CONDI��ES\"`]")
    private MobileElement menuToolBar;

    /**
     * Tocar no bot�o "Retornar ao Menu"
     *
     * @throws Exception
     */
    @Step ("Tocar bot�o \"Retornar ao Menu\"")
    public TermosECondicoesTela tocarBotaoRetornarMenu() throws Exception {
        aguardarCarregamentoElemento(botaoRetornarMenu);
        tocarElemento(botaoRetornarMenu, "N�o foi poss�vel clicar no bot�o 'Retornar Menu'" );
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia( "Tocar no bot�o 'Retornar Menu'" );
        }else{
            throw new AssertionError("Resultado da a��o � diferente do resultado esperado");
        }
        return this;
    }

    /**
     * Validar carregamento da tela pela exibi��o do menu da tela
     *
     */
    @Step ("Validar carregamento da tela")
    public TermosECondicoesTela validarCarregamentoTela() throws Exception {
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia("N�o foi poss�vel validar o carregamento da tela 'TERMOS E CONDI��ES'");
            throw new AssertionError("N�o foi poss�vel validar o carregamento da tela 'TERMOS E CONDI��ES'");
        }else{
            salvarEvidencia("Validar Carregamento tela 'TERMOS E CONDI��ES'");
        }
        return this;
    }


}
