package pagina.mobile.contingencia;

import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.exception.NextException;

import base.mobile.contingencia.PaginaBaseEgContingencia;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class MobileContingenciaTela extends PaginaBaseEgContingencia {

    public MobileContingenciaTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_contingency_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/ntv_contingency_title']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='LER QR CODE']/../XCUIElementTypeStaticText[contains(@name,'indisponível')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='LER QR CODE']/../XCUIElementTypeStaticText[contains(@name,'indisponível')]")
    private MobileElement mensagemAlertaAppIndisponivel;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_read_qr_code")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/nbt_read_qr_code']")
    @AndroidFindBy(xpath = "//android.widget.Button[@contains(@text,'LER QR CODE')]")
    @AndroidFindBy(xpath = "//*[@contains(@text,'LER QR CODE')]")
    @iOSXCUITFindBy(accessibility = "LER QR CODE")
    private MobileElement botaoLerQrCode;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_session_key")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='br.com.bradesco.next:id/et_session_key']")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/et_session_key']")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField'][2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LOGIN\"]/preceding-sibling::XCUIElementTypeTextField[1]")
    private MobileElement campoSessionKey;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_login")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/nbt_login']")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nbt_login']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"LOGIN\"`]")
    @iOSXCUITFindBy(accessibility = "LOGIN")
    private MobileElement botaoLogin;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='br.com.bradesco.next:id/et_contingency_password']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_contingency_password")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/et_contingency_password']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeSecureTextField\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    private MobileElement campoSenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_contingency_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/nb_contingency_continue']")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nb_contingency_continue']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(accessibility = "PAGAR")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_tid")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"TID\"`]")
    @iOSXCUITFindBy(accessibility = "TID")
    private MobileElement campoTID;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_next")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[2])[4]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"TRANSAÇÃO\"`]")
    @iOSXCUITFindBy(accessibility = "TRANSAÇÃO")
    private MobileElement botaoAvancar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_contingency_transfer")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/nb_contingency_transfer']")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nb_contingency_transfer']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"TRANSFERIR\"`]")
    @iOSXCUITFindBy(accessibility = "TRANSFERIR")
    private MobileElement botaoTransferir;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Return")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"retorno\"`]")
    private MobileElement botaoRetorno;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'OK')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@value='OK']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@text,'OK')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private MobileElement botaoOk;

    //Utilizado apenas no iOS para validacao
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"EG - Contigência\"]")
    private MobileElement tituloEgContingencia;

    @AndroidFindBy(xpath = "//*[@text='CONTINUAR']")
    @iOSXCUITFindBy(xpath = "//*[@name='CONFIRMAR']")
    private MobileElement botaoConfirmar;

    /**
     * Validar mensagem de app temporariamente indisponível
     *
     * @param mensagem
     * @throws Exception
     */
    @Step("Validar mensagem de app temporariamente indisponível")
    public MobileContingenciaTela validarAppTemporariamenteIndisponivel(String mensagem) throws Exception {
        aguardarCarregamentoElemento(mensagemAlertaAppIndisponivel);
        compararElementoTexto(mensagemAlertaAppIndisponivel, mensagem, MetodoComparacao.IGUAL);
        salvarEvidencia("Validar mensagem de app temporariamente indisponível presente na tela.");
        return this;
    }

    /**
     * Manter pressionado o botão 'LER QR CODE'
     */
    @Step("Manter pressionado o botão 'LER QR CODE'")
    public MobileContingenciaTela manterPressionadoBotaoLerQrCode() {
        aguardarElementoHabilitado(botaoLerQrCode);
        salvarEvidencia("Manter pressionado o botão 'LER QR CODE'");
        try {
            //TODO: Foi incluído essa validação no Android pois em versões abaixo da v10 está apresentando erro ao manter pressionado o botão.
            if (android) {
                if (Integer.parseInt(((AndroidDriver<?>) driver).getCapabilities().getCapability("platformVersion").toString()) <= 10) {
                    TouchAction touch = new TouchAction((PerformsTouchActions) driver);
                    touch.longPress(longPressOptions().withElement(element(botaoLerQrCode)).withDuration(Duration.ofMillis(3000))).release().perform();
                } else {
                    manterPressionado(botaoLerQrCode, 3000, "Não foi possível manter pressionado o botão 'LER QR CODE'");
                }
            } else {
                manterPressionado(botaoLerQrCode, 3000, "Não foi possível manter pressionado o botão 'LER QR CODE'");
            }
        } catch (Throwable e) {
            OperadorEvidencia.logarPasso("Falha ao pressionar botao Ler QR Code\n");
        }
        return this;
    }

    /**
     * Informar código do QR Code na tela do app
     *
     * @param sessionKey
     * @return MobileContingenciaTela
     */
    @Step("Informar código Session Key do QR Code na tela do app")
    public MobileContingenciaTela informarSessionKey(String sessionKey) {
        //Alterado o método para utilizar diretamente o sendKeys para evitar que o QRCode expire durante o login
        campoSessionKey.sendKeys(sessionKey);
        return this;
    }

    /**
     * Informar código do QR Code na tela do app
     *
     * @return boolean
     */
    @Step("Informar código Session Key do QR Code na tela do app")
    public boolean validarPresencaSessionKey() {
        return aguardarCarregamentoElemento(campoSessionKey);
    }

    /**
     * Tocar no botão login no app
     *
     * @return MobileContingenciaTela
     */
    @Step("Tocar botão 'Login'")
    public MobileContingenciaTela tocarBotaoLogin() {
        //Alterado o método para utilizar diretamente o click para evitar que o QRCode expire durante o login
        botaoLogin.click();
        return this;
    }

    /**
     * Informar código no campo TID na tela do app
     *
     * @param TID
     * @throws Exception
     */
    @Step("Informar código no campo TID")
    public MobileContingenciaTela informarTID(String TID) throws Exception {
        salvarEvidencia("Informado código no campo TID");
        escreverTexto(campoTID, TID, true, "Não foi possível informar o campo TID");
        return this;
    }

    /**
     * Informar a senha de login do app
     *
     * @param senha
     * @return MobileContingenciaTela
     */
    @Step("Informar senha de login no app")
    public MobileContingenciaTela informarSenhaLogin(String senha) {
        //Alterado o método para utilizar diretamente o sendKeys para evitar que o QRCode expire durante o login
        campoSenha.sendKeys(senha);
        return this;
    }

    /**
     * Validar presenca título EG - CONTINGÊNCIA
     *
     * @return boolean
     */
    @Step("Validar presenca título EG - CONTINGÊNCIA")
    public boolean validarPresencaTituloEgContigencia() {
        return aguardarCarregamentoElemento(tituloEgContingencia);
    }

    /**
     * Tocar no botão continuar na tela do app.
     *
     * @return MobileContingenciaTela
     */
    @Step("Tocar botão 'Continuar'")
    public MobileContingenciaTela tocarBotaoContinuar() {
        //Alterado o método para utilizar diretamente o click para evitar que o QRCode expire durante o login
        botaoContinuar.click();
        return this;
    }

    /**
     * Tocar no botão 'Avançar' para confirmar pagamento dentro do aplicativo.
     *
     * @return MobileContingenciaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Avançar'")
    public MobileContingenciaTela tocarBotaoAvancar() throws Exception {
        aguardarCarregamentoElemento(botaoAvancar);
        salvarEvidencia("Tocar botão 'Avancar");
        tocarElemento(botaoAvancar, "Não foi possível tocar o botão 'Avançar'");
        return this;
    }

    /**
     * Apagar o texto do campo Session Key presente na contingência mobile.
     *
     * @return MobileContingenciaTela
     * @throws Exception
     */
    @Step("Apagar o texto do campo Session Key")
    public MobileContingenciaTela apagarTextoCampoSessionKey() throws Exception {
        salvarEvidencia("Apagar campo Session Key");
        apagarCampoTexto(campoSessionKey, "Não foi possível apagar o texto do campo Session Key.");
        esconderTeclado();
        return this;
    }

    /**
     * Rolar até encotrar o botão transferir na tela do app.
     *
     * @return MobileContingenciaTela
     */
    @Step("Rolar até o botão 'Transferir'")
    public MobileContingenciaTela rolarAteBotaoTransferir() {
        esperarCarregando();
        rolarTelaAteFinal();
        salvarEvidencia("Rolar até botão 'Transferir'");
        return this;
    }

    /**
     * Tocar no botão tranferir na tela do app.
     *
     * @return MobileContingenciaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Transferir'")
    public MobileContingenciaTela tocarBotaoTransferir() throws Exception {
        aguardarCarregamentoElemento(botaoTransferir);
        rolarTelaAteFinal();
        salvarEvidencia("Tocado botão 'Transferir'");
        tocarElemento(botaoTransferir, "Não foi possível tocar o botão 'Transferir'");
        return this;
    }

    /**
     * Tocar no botão OK na tela do app.
     *
     * @return MobileContingenciaTela
     * @throws Exception
     */
    @Step("Tocar botão OK")
    public MobileContingenciaTela tocarBotaoOk() throws Exception {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocado botão OK");
        tocarElemento(botaoOk, "NÃ£o foi possível tocar no botão OK");
        return this;
    }

    /**
     * Tocar no botão 'Confirmar'
     *
     * @return MobileContingenciaTela
     * @throws NextException
     */
    @Step("Tocar botão 'Confirmar'")
    public MobileContingenciaTela tocarBotaoConfirmar() throws NextException {
        salvarEvidencia("Tocar botão 'Confirmar'");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        return this;
    }
}
