package pagina.mobile.jornadas.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
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

    @iOSXCUITFindBy(accessibility = "next")
    @AndroidFindBy(id = "br.com.bradesco.next:id/action_bar_root")
    private MobileElement identificadorAppNext;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Logar com outro CPF\"]")
    @AndroidFindBy(accessibility = "SAIR")
    private MobileElement botaoLogarComOutroCPF;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pix\"]")
    @iOSXCUITFindBy(accessibility = "Pix")
    @AndroidFindBy(accessibility = "Botão Entrar em PIX")
    private MobileElement botaoPix;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_shortcuts")
    @iOSXCUITFindBy(accessibility = "Atalhos")
    private MobileElement botaoAtalhos;

    public LoginUsuarioLogadoTela(AppiumDriver driver) {
        super(driver);
        modalTrocaUsuario = new ModalTrocaUsuario(driver);
    }

    /**
     * Método para deslogar do usuário atual para logar com novo CPF
     *
     * @return LoginUsuarioLogadoTela
     * @throws Exception
     */
    @Step("Método para deslogar do usuário atual para logar com novo CPF")
    public LoginUsuarioLogadoTela logarNovoCPF() throws Exception {
        salvarEvidencia("Tocar botão Logoff");
        aguardarElementoHabilitado(botaoLogarComOutroCPF);
        tocarElemento(botaoLogarComOutroCPF, "Erro ao tocar botão \"Logoff\"");
        modalTrocaUsuario.tocarBotaoSim();
        return this;
    }

    /**
     * Método utilizado para verificar se está na tela Login Ja Logado
     *
     * @return
     */
    public boolean verificarTelaLoginJaLogado() {
        //passo incluído, pois app estava quebrando em iOS
        verificarPresencaElemento(identificadorAppNext);
        return !aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_ICONES_TELA_LOGIN_JA_LOGADO).isEmpty();
    }

    /**
     * Método utilizado para verificar se está na tela Login Ja Logado
     *
     * @return
     */
    public boolean verificarTelaLogin() {
        //passo incluído, pois app estava quebrando em iOS
        return !aguardarPaginaConterQualquerTexto(LoginApp.PALAVRA_TELA_LOGIN_BOTAOENTRAR).isEmpty();
    }

    /**
     * Classe criada para definir o modal que é exibido na tela de login ao tentar logar com outro cpf
     */
    private class ModalTrocaUsuario extends PaginaBase {

        @AndroidFindBy(id = "br.com.bradesco.next:id/bt_right")
        @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeButton\"  and name = \"Sim\"")
        private MobileElement botaoSim;

        public ModalTrocaUsuario(AppiumDriver driver) {
            super(driver);
        }

        /**
         * Método para tocar botão sim do modal
         *
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

    /**
     * Método que realiza o acesso ao Pix na área de Login Recorrente
     *
     * @return LoginUsuarioLogadoTela
     * @throws NextException
     */
    public LoginUsuarioLogadoTela tocarBotaoPix() throws NextException {
        aguardarCarregamentoElemento(botaoPix);
        salvarEvidencia("Tocar no botao 'Pix'");
        tocarElemento(botaoPix, "Não foi possível tocar no botão 'Pix'!");
        return this;
    }

    /**
     * Método para tocar no botão Atalhos
     *
     * @return LoginUsuarioLogadoTela
     * @throws Exception
     */
    @Step("Método para tocar no botão Atalhos")
    public LoginUsuarioLogadoTela tocarBotaoAtalhos() throws Exception {
        aguardarCarregamentoElemento(botaoAtalhos);
        salvarEvidencia("Tocar no botao 'Atalhos'");
        tocarElemento(botaoAtalhos, "Não foi possível tocar no botão 'Atalhos'!");
        return this;
    }
}
