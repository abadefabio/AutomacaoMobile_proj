package pagina.mobile.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.login.LoginApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class LoginTela extends PaginaBase {

    public static ThreadLocal<String> cpfLogin = null;

    public LoginTela(AppiumDriver<MobileElement> driver) {
        super(driver);

    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_username")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField)[1]")
    @iOSXCUITFindBy(id = "CPF")
    private MobileElement campoCPF;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_password")
    @iOSXCUITFindBy(iOSNsPredicate = "type =\"XCUIElementTypeSecureTextField\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[contains(@name,'Senha')]")
    @iOSXCUITFindBy(id = "Senha")
    private MobileElement campoPassword;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_login")
    @iOSXCUITFindBy(id = "Entrar")
    @iOSXCUITFindBy(accessibility = "Entrar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Entrar\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Entrar\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Entrar\"]")
    private MobileElement botaoLogin;

    @AndroidFindBy(accessibility = "SAIR")
    @iOSXCUITFindBy(id = "SAIR")
    private MobileElement botaoLogout;

    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFecharAtalhos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_forgot_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Esqueceu sua senha?\"]")
    private MobileElement botaoEsqueceuSuaSenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Logar com outro CPF")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @AndroidFindBy(accessibility = "Voltar, Bot�o")
    private MobileElement setaVoltar;


    /**
     * Tocar Seta Voltar
     * @return LoginTela
     * @throws NextException
     */
    @Step("Tocar Seta Voltar")
    public LoginTela tocarBotaoVoltar() throws NextException {
        aguardarElementoHabilitado(setaVoltar);
        salvarEvidencia("Tocar bot�o Voltar");
        tocarElemento(setaVoltar, "Erro ao tocar no elemento seta voltar");
        return this;
    }

    /**
     * Armazena valor informado no objeto thread-safe cpfLogin
     * @param cpfLogin
     */
    public static void setCpfLogin(String cpfLogin){
        if(LoginTela.cpfLogin == null){
            LoginTela.cpfLogin = new ThreadLocal<>();
        }
        LoginTela.cpfLogin.set(cpfLogin);
    }

    /**
     * retorna string com o valor de ag�ncia armazenado no objeto thread-safe cpfLogin
     * @return agencia
     */
    public static String retornaCpfLogin(){
        return  cpfLogin.get();
    }


    /**
     * Verificar primeiro elemento carregado em uma lista de elementos
     *
     * @return int
     */
    @Step("Aguardar oculta��o da tela de login")
    public boolean aguardarOcultacaoTela() throws Exception {
        /*
        Oculta��o manual
         */
        long inicio = System.currentTimeMillis();
        boolean elementoOculto = verificarPresencaElemento(campoPassword);
        while(!elementoOculto) {
            if (System.currentTimeMillis() - inicio > 15*1000)
                break;
            elementoOculto = verificarPresencaElemento(campoPassword);
        }
        return elementoOculto;
    }

    /**
     * Verificar primeiro elemento carregado em uma lista de elementos
     *
     * @return int
     */
    @Step("Decidir pr�xima a��o de login")
    public boolean isResetCpfRequerido() throws Exception {
        if (aguardarPaginaConterQualquerTexto(LoginApp.PALAVRA_TELA_RESETCPF_VAMOSLA,
                LoginApp.PALAVRA_TELA_INICIAL_REAIS).equals(LoginApp.PALAVRA_TELA_RESETCPF_VAMOSLA)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validar Exibi��o Tela Login
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Informar Senha")
    public LoginTela validarExibicaoTelaLogin() {
        for(int i = 0; i < 3; i++) if(aguardarPaginaConterTodosTextos("CPF", "Senha")) break;
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos("CPF", "Senha"),
                MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel verificar a exibi��o dos elementos da tela de login");
        salvarEvidencia("Validar exibi��o da tela de Login");
        return this;
    }



    /**
     * Preencher campo CPF
     *
     * @param cpf
     * @return LoginTela
     * @throws Exception
     */
    @Step("Informar CPF")
    public LoginTela informarCPF(String cpf) throws Exception {
        setCpfLogin(cpf);
        escreverTexto(campoCPF, cpf, "n�o foi poss�vel escrever o cpf");
        //implementa��o para melhorar tempo captura evid�ncia
        salvarEvidencia("Inserir CPF: " + cpf);
        return this;
    }

    /**
     * Preencher campo senha
     *
     * @param senha
     * @return LoginTela
     * @throws Exception
     */
    @Step("Informar Senha")
    public LoginTela informarSenha(String senha) throws Exception {
        escreverTexto(campoPassword, senha, "nao foi possivel digitar a senha");
        if (ios && verificarPresencaElemento(new By.ByXPath("//*[@name=\"OK\"]")))
            tocarElemento(new By.ByXPath("//*[@name=\"OK\"]"), "");
        OperadorEvidencia.logarPasso("Senha inserida");
        return this;
    }

    /**
     * Tocar bot�o "Entrar"
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Tocar em \"Entrar\"")
    public LoginTela tocarEntrar() throws Exception {

        if (verificarPresencaElemento(botaoLogin)) {
                salvarEvidencia("Visualizar bot�o Login na tela");
                tocarElemento(botaoLogin, "N�o foi poss�vel tocar no bot�o login");
        }
        OperadorEvidencia.logarPasso("Bot�o Login Tocado - Indo para Menu Principal");
        return this;
    }

    /**
     * Tocar bot�o "sair"
     * @return
     * @throws Exception
     */
    @Step("Tocar em \"Sair\"")
    public LoginTela tocarSair() throws Exception {
        tocarElemento(botaoLogout, "n�o foi poss�vel tocarElemento em Logout");
        salvarEvidencia("Tocar Bot�o Logout");
        return this;
    }

    /**
     * Recarregar app do Next
     * @return LoginTela
     * @throws Exception
     */
    @Step("Recarregar App Next")
    public LoginTela recarregarAppNext() throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            getDriver().launchApp();
        } else {
            getDriver().resetApp();
            if (aguardarCarregamentoElemento(botaoFecharAtalhos)) {
                tocarElemento(botaoFecharAtalhos, "N�o Foi poss�vel tocar elemento fechar");
            }
        }
        return this;
    }

    /**
     *Tocar bot�o "Esqueceu sua Senha?"
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Esqueceu sua Senha?\"")
    public LoginTela tocarBotaoEsqueceuSuaSenha() throws NextException {
        tocarElemento(botaoEsqueceuSuaSenha, "n�o foi poss�vel tocar bot�o \"Esqueceu sua Senha?\"");
        salvarEvidencia("Tocar bot�o \"Esqueceu sua Senha?\"");
        return this;
    }

    @Step("Validar se o reset de CPF foi efetuado")
    public LoginTela validarResetCpf(boolean resetOK) {
        validarCondicaoBooleana(resetOK, MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel efetuar o reset de CPF.");
        return this;
    }

}
