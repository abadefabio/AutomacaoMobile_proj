package pagina.mobile.contingencia;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class MobileContingenciaPopupFalhaTela extends PaginaBase {

    public MobileContingenciaPopupFalhaTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/ntv_title']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_title")
    @AndroidFindBy(xpath = "//android.widget.ImageView/../android.widget.TextView")
    private MobileElement mensagemFalha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/nb_confirm']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirm")
    @AndroidFindBy(xpath = "//android.widget.Button[@contains(@text,'OK')]")
    @AndroidFindBy(xpath = "//*[@contains(@text,'OK')]")
    private MobileElement botaoOK;

    /**
     * Tocar botão 'OK'
     *
     */
    @Step ("Tocar botão 'OK'")
    public MobileContingenciaPopupFalhaTela tocarBotaoOK() throws Exception {
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
    public MobileContingenciaPopupFalhaTela validarMensagemFalha(String mensagem) throws Exception {
        aguardarCarregamentoElemento(mensagemFalha);
        salvarEvidencia("Validar mensagem: " + mensagem);
        validarAtributoTexto(mensagemFalha, mensagem, "Não foi possível validar a mensagem de falha no popup");
        return this;
    }

}
