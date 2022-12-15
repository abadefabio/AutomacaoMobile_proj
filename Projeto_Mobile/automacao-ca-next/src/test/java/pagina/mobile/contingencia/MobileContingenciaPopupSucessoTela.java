package pagina.mobile.contingencia;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class MobileContingenciaPopupSucessoTela extends PaginaBase {

    public MobileContingenciaPopupSucessoTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/ntv_title']")
    @AndroidFindBy(xpath = "//android.widget.ImageView/../android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage//following-sibling::XCUIElementTypeStaticText")
    private MobileElement mensagemSucesso;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirm")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/nb_confirm']")
    @AndroidFindBy(xpath = "//android.widget.Button[@contains(@text,'OK')]")
    @AndroidFindBy(xpath = "//*[@contains(@text,'OK')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOK;

    /**
     * Tocar botão 'OK'
     *
     */
    @Step ("Tocar botão 'OK'")
    public MobileContingenciaPopupSucessoTela tocarBotaoOK() throws Exception {
        aguardarCarregamentoElemento(botaoOK);
        salvarEvidencia("Tocar botão 'OK'");
        tocarElemento(botaoOK, "Não foi possível tocar o botão 'OK'");
        return this;
    }

    /**
     * Validar mensagem de falha de autenticação contingência no app
     *
     */
    @Step ("Tocar botão 'OK'")
    public MobileContingenciaPopupSucessoTela validarMensagemSucesso(String mensagem) throws Exception {
        aguardarCarregamentoElemento(mensagemSucesso);
        salvarEvidencia("Validar mensagem: " + mensagem);
        validarAtributoTexto(mensagemSucesso, mensagem, "Não foi possível validar a mensagem de sucesso no popup");
        return this;
    }
}
