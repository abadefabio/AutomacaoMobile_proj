package pagina.mobile.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import constantes.login.LoginApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;


public class LoginUsuarioLogadoTela extends PaginaBase {

    private ModalTrocaUsuario modalTrocaUsuario;
    public LoginUsuarioLogadoTela(AppiumDriver<MobileElement> driver) {
        super(driver);
        modalTrocaUsuario = new ModalTrocaUsuario(driver);
    }

    /*
    Botão Atalhos de quando o usuário está registrado no dispositivo
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='br.com.bradesco.next:id/ntv_shortcuts']")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'ATALHOS')]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"botão atalhos\"]/android.widget.ImageView")
    @AndroidFindBy(xpath = "//*[contains(@text,'atalhos')]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_shortcuts")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Atalhos\"`]")
    @iOSXCUITFindBy(accessibility = "Atalhos")
    private MobileElement botaoAtalhos;

    /*
    Botão Atalhos de quando o usuário ainda não efetuou login (não está registrado no dispositivo)
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_shortcuts")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/ctv_shortcuts']")
    @AndroidFindBy(xpath = "//*[contains(@text,'ATALHOS')]")
    @iOSXCUITFindBy(accessibility = "ATALHOS")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ATALHOS\"`]")
    private MobileElement botaoAtalhosSemLogar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Logar com outro CPF\"]")
    @iOSXCUITFindBy(accessibility = "Logar com outro CPF")
    @AndroidFindBy(accessibility = "SAIR")
    private MobileElement botaoLogarComOutroCPF;

    @iOSXCUITFindBy(accessibility = "next")
    @AndroidFindBy(id = "br.com.bradesco.next:id/action_bar_root")
    private MobileElement identificadorAppNext;

    /**
     * Tocar botão 'Atalhos'
     * @throws Exception
     */
    public LoginUsuarioLogadoTela tocarBotaoAtalhos() throws Exception {
        salvarEvidencia("Tocar botão 'Atalhos'");
        tocarElemento(botaoAtalhos, "Não foi possível tocar o botão 'Atalhos'");
        return this;
    }

    /**
     * Tocar botão 'Atalhos'
     * @throws Exception
     */
    public LoginUsuarioLogadoTela tocarBotaoAtalhosClienteNaoRegistrado() throws Exception {
        aguardarCarregamentoElemento(botaoAtalhosSemLogar);
        salvarEvidencia("Tocar botão 'Atalhos'");
        tocarElemento(botaoAtalhosSemLogar, "Não foi possível tocar o botão 'Atalhos'");
        return this;
    }

    /**
     * Método para deslogar do usuário atual para logar com novo CPF
     * @return LoginUsuarioLogadoTela
     * @throws Exception
     */
    @Step("Método para deslogar do usuário atual para logar com novo CPF")
    public LoginUsuarioLogadoTela logarNovoCPF() throws Exception {
        salvarEvidencia("Tocar botão Logoff");
        tocarElemento(botaoLogarComOutroCPF, "Erro ao tocar botão \"Logoff\"");
        modalTrocaUsuario.tocarBotaoSim();
        return this;
    }

    /**
     * Método utilizado para verificar se está na tela Login Ja Logado
     * @return
     */
    public boolean verificarTelaLoginJaLogado(){
        return !aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_ICONES_TELA_LOGIN_JA_LOGADO).isEmpty();
    }

    /**
     * Classe criada para definir o modal que é exibido na tela de login ao tentar logar com outro cpf
     */
    private class ModalTrocaUsuario extends PaginaBase {

        ModalTrocaUsuario(AppiumDriver driver){
            super(driver);
        }

        @AndroidFindBy(id = "br.com.bradesco.next:id/bt_right")
        @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeButton\"  and name = \"Sim\"")
        private MobileElement botaoSim;

        /**
         * Método para tocar botão sim do modal
         * @return
         * @throws Exception
         */
        private ModalTrocaUsuario tocarBotaoSim() throws Exception {
            aguardarElementoHabilitado(botaoSim);
            salvarEvidencia("Tocar botão \"Sim\"");
            tocarElemento(botaoSim, "Erro ao tocar botão \"Sim\"");
            return this;
        }
    }

}
