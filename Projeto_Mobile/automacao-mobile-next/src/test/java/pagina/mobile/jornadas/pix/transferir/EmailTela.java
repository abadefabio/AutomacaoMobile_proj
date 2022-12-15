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
    @AndroidFindBy(xpath = "//*[@text='E-mail do destinatário']/../android.widget.EditText")
    @AndroidFindBy(id ="br.com.bradesco.next:id/ntf_pix_email")
    @iOSXCUITFindBy(accessibility = "E-mail do destinatário")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'E-mail')]")
    private MobileElement campoEmail;

    //Somente para Android
    @AndroidFindBy(xpath = "//*[@text='E-mail do destinatário']")
    private MobileElement labelEmail;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_advance")
    @AndroidFindBy(xpath = "//*[@text='AVANÇAR']")
    @iOSXCUITFindBy(accessibility = "AVANÇAR")
    @iOSXCUITFindBy(xpath = "//*[@name='AVANÇAR']")
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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.EMAIL_TELA), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar a tela 'E-mail'");
        salvarEvidencia("Validada a tela 'E-mail'");
        return this;
    }

    /**
     * Preencher campo E-mail do destinatário
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo E-mail do destinatário")
    public EmailTela preencherCampoEmail() throws Exception {
        if (ios){
            escreverTexto(campoEmail, DadosPIX.E_MAIL, true,"Erro ao inserir dados no campo E-mail do destinatário");
        } else {
            digitarTexto(campoEmail,DadosPIX.E_MAIL);
        }
        salvarEvidencia("Campo E-mail do destinatário preenchido");
        return this;
    }

    /**
     * Tocar no botão 'OK'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'OK'")
    public EmailTela tocarBotaoOK() throws Exception {
        salvarEvidencia("Tocar botão 'OK'");
        tocarElemento(botaoOK, "Não foi possível tocar no botão 'OK'");
        return this;
    }

    /**
     * Tocar no botão 'Avançar'
     *
     * @return EmailTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Avançar'")
    public EmailTela tocarBotaoAvancar() throws Exception {
        salvarEvidencia("Tocar botão 'Avançar'");
        tocarElemento(botaoAvancar, "Não foi possível tocar no botão 'Avançar'");
        return this;
    }
}
