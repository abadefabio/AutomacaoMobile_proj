package pagina.mobile.jornadas.pix.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pix.DadosPIX;
import constantes.pix.Pix;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EmailTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='E-mail do destinat�rio']/../android.widget.EditText")
    @AndroidFindBy(id ="br.com.bradesco.next:id/ntf_pix_email")
    @iOSXCUITFindBy(accessibility = "E-mail do destinat�rio")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'E-mail')]")
    private MobileElement campoEmail;

    //Somente para Android
    @AndroidFindBy(xpath = "//*[@text='E-mail do destinat�rio']")
    private MobileElement labelEmail;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_advance")
    @AndroidFindBy(xpath = "//*[@text='AVAN�AR']")
    @iOSXCUITFindBy(accessibility = "AVAN�AR")
    @iOSXCUITFindBy(xpath = "//*[@name='AVAN�AR']")
    private MobileElement botaoAvancar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nfbt_continue_keyboard")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOK;

    public EmailTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela 'E-mail'
     */
    @Step("Validar tela 'E-mail'")
    public EmailTela validarEmailTela() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.EMAIL_TELA), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar a tela 'E-mail'");
        salvarEvidencia("Validada a tela 'E-mail'");
        return this;
    }

    /**
     * Preencher campo E-mail do destinat�rio
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo E-mail do destinat�rio")
    public EmailTela preencherCampoEmail() throws Exception {
        if (ios){
            escreverTexto(campoEmail, DadosPIX.E_MAIL, true,"Erro ao inserir dados no campo E-mail do destinat�rio");
        } else {
            digitarTexto(campoEmail,DadosPIX.E_MAIL);
        }
        salvarEvidencia("Campo E-mail do destinat�rio preenchido");
        return this;
    }

    /**
     * Tocar no bot�o 'OK'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'OK'")
    public EmailTela tocarBotaoOK() throws Exception {
        salvarEvidencia("Tocar bot�o 'OK'");
        tocarElemento(botaoOK, "N�o foi poss�vel tocar no bot�o 'OK'");
        return this;
    }

    /**
     * Tocar no bot�o 'Avan�ar'
     *
     * @return EmailTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Avan�ar'")
    public EmailTela tocarBotaoAvancar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Avan�ar'");
        tocarElemento(botaoAvancar, "N�o foi poss�vel tocar no bot�o 'Avan�ar'");
        return this;
    }
}
