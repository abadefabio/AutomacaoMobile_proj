package pagina.mobile.menu.ReorganizarMenu;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class ReorganizarMenuTela extends PaginaBase {

    public ReorganizarMenuTela(AppiumDriver driver){
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbtMenuReorganizeSave")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SALVAR\"`]" )
    private MobileElement botaoSalvar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntbReorganizeMenuToolbar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"REORGANIZAR MENU\"`]")
    private MobileElement menuToolBar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbtGoToReorganizeMenu")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK, ENTENDI!\"`]")
    private MobileElement botaoOKEntendi;


    /**
     * Tocar no bot�o 'OK,Entendi'
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK,Entendi\"")
    public ReorganizarMenuTela tocarBotaoOKEntendi() throws Exception {
        aguardarCarregamentoElemento(botaoOKEntendi);
        tocarElemento(botaoOKEntendi, "N�o foi poss�vel clicar no bot�o 'OK, Entendi'" );
        salvarEvidencia( "Clicar no bot�o 'OK, Entendi'" );
        return this;
    }

    /**
     * Tocar no bot�o "Salvar"
     *
     * @throws Exception
     */
    @Step ("Tocar bot�o \"Salvar\"")
    public ReorganizarMenuTela tocarBotaoSalvar() throws Exception {
        aguardarCarregamentoElemento(botaoSalvar);
        tocarElemento(botaoSalvar, "N�o foi poss�vel clicar no bot�o 'Salvar'" );
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia( "Tocar no bot�o 'Salvar'" );
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
    public ReorganizarMenuTela validarCarregamentoTela() throws Exception {
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia("N�o foi poss�vel validar o carregamento da tela 'REORGANIZAR MENU'");
            throw new AssertionError("N�o foi poss�vel validar o carregamento da tela 'REORGANIZAR MENU'");
        }else{
            salvarEvidencia("Validar Carregamento tela 'REORGANIZAR MENU'");
        }
        return this;
    }


}
