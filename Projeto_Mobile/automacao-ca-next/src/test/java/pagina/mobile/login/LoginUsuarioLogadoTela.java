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
    Bot�o Atalhos de quando o usu�rio est� registrado no dispositivo
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='br.com.bradesco.next:id/ntv_shortcuts']")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'ATALHOS')]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"bot�o atalhos\"]/android.widget.ImageView")
    @AndroidFindBy(xpath = "//*[contains(@text,'atalhos')]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_shortcuts")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Atalhos\"`]")
    @iOSXCUITFindBy(accessibility = "Atalhos")
    private MobileElement botaoAtalhos;

    /*
    Bot�o Atalhos de quando o usu�rio ainda n�o efetuou login (n�o est� registrado no dispositivo)
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
     * Tocar bot�o 'Atalhos'
     * @throws Exception
     */
    public LoginUsuarioLogadoTela tocarBotaoAtalhos() throws Exception {
        salvarEvidencia("Tocar bot�o 'Atalhos'");
        tocarElemento(botaoAtalhos, "N�o foi poss�vel tocar o bot�o 'Atalhos'");
        return this;
    }

    /**
     * Tocar bot�o 'Atalhos'
     * @throws Exception
     */
    public LoginUsuarioLogadoTela tocarBotaoAtalhosClienteNaoRegistrado() throws Exception {
        aguardarCarregamentoElemento(botaoAtalhosSemLogar);
        salvarEvidencia("Tocar bot�o 'Atalhos'");
        tocarElemento(botaoAtalhosSemLogar, "N�o foi poss�vel tocar o bot�o 'Atalhos'");
        return this;
    }

    /**
     * M�todo para deslogar do usu�rio atual para logar com novo CPF
     * @return LoginUsuarioLogadoTela
     * @throws Exception
     */
    @Step("M�todo para deslogar do usu�rio atual para logar com novo CPF")
    public LoginUsuarioLogadoTela logarNovoCPF() throws Exception {
        salvarEvidencia("Tocar bot�o Logoff");
        tocarElemento(botaoLogarComOutroCPF, "Erro ao tocar bot�o \"Logoff\"");
        modalTrocaUsuario.tocarBotaoSim();
        return this;
    }

    /**
     * M�todo utilizado para verificar se est� na tela Login Ja Logado
     * @return
     */
    public boolean verificarTelaLoginJaLogado(){
        return !aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_ICONES_TELA_LOGIN_JA_LOGADO).isEmpty();
    }

    /**
     * Classe criada para definir o modal que � exibido na tela de login ao tentar logar com outro cpf
     */
    private class ModalTrocaUsuario extends PaginaBase {

        ModalTrocaUsuario(AppiumDriver driver){
            super(driver);
        }

        @AndroidFindBy(id = "br.com.bradesco.next:id/bt_right")
        @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeButton\"  and name = \"Sim\"")
        private MobileElement botaoSim;

        /**
         * M�todo para tocar bot�o sim do modal
         * @return
         * @throws Exception
         */
        private ModalTrocaUsuario tocarBotaoSim() throws Exception {
            aguardarElementoHabilitado(botaoSim);
            salvarEvidencia("Tocar bot�o \"Sim\"");
            tocarElemento(botaoSim, "Erro ao tocar bot�o \"Sim\"");
            return this;
        }
    }

}
