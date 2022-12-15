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
     * Tocar no botão 'OK,Entendi'
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"OK,Entendi\"")
    public ReorganizarMenuTela tocarBotaoOKEntendi() throws Exception {
        aguardarCarregamentoElemento(botaoOKEntendi);
        tocarElemento(botaoOKEntendi, "Não foi possível clicar no botão 'OK, Entendi'" );
        salvarEvidencia( "Clicar no botão 'OK, Entendi'" );
        return this;
    }

    /**
     * Tocar no botão "Salvar"
     *
     * @throws Exception
     */
    @Step ("Tocar botão \"Salvar\"")
    public ReorganizarMenuTela tocarBotaoSalvar() throws Exception {
        aguardarCarregamentoElemento(botaoSalvar);
        tocarElemento(botaoSalvar, "Não foi possível clicar no botão 'Salvar'" );
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia( "Tocar no botão 'Salvar'" );
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
    public ReorganizarMenuTela validarCarregamentoTela() throws Exception {
        if(!aguardarCarregamentoElemento(menuToolBar)){
            salvarEvidencia("Não foi possível validar o carregamento da tela 'REORGANIZAR MENU'");
            throw new AssertionError("Não foi possível validar o carregamento da tela 'REORGANIZAR MENU'");
        }else{
            salvarEvidencia("Validar Carregamento tela 'REORGANIZAR MENU'");
        }
        return this;
    }


}
