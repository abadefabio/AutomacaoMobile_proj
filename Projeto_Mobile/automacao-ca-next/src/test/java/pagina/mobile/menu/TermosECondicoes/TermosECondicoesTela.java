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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"TERMOS E CONDIÇÕES\"`]")
    private MobileElement menuToolBar;

    /**
     * Tocar no botão "Retornar ao Menu"
     *
     * @throws Exception
     */
    @Step ("Tocar botão \"Retornar ao Menu\"")
    public TermosECondicoesTela tocarBotaoRetornarMenu() throws Exception {
        aguardarCarregamentoElemento(botaoRetornarMenu);
        tocarElemento(botaoRetornarMenu, "Não foi possível clicar no botão 'Retornar Menu'" );
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia( "Tocar no botão 'Retornar Menu'" );
        }else{
            throw new AssertionError("Resultado da ação é diferente do resultado esperado");
        }
        return this;
    }

    /**
     * Validar carregamento da tela pela exibição do menu da tela
     *
     */
    @Step ("Validar carregamento da tela")
    public TermosECondicoesTela validarCarregamentoTela() throws Exception {
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia("Não foi possível validar o carregamento da tela 'TERMOS E CONDIÇÕES'");
            throw new AssertionError("Não foi possível validar o carregamento da tela 'TERMOS E CONDIÇÕES'");
        }else{
            salvarEvidencia("Validar Carregamento tela 'TERMOS E CONDIÇÕES'");
        }
        return this;
    }


}
