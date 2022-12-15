package pagina.mobile.jornadas.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.login.LoginApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class LoginTela extends PaginaBase {

    public static ThreadLocal<String> cpfLogin = null;

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

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_ok")
    private MobileElement botaoAvaliarAgora;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_no_thanks")
    private MobileElement botaoVerDepois;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_eyes")
    private MobileElement botaoVisualizarSenha;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nextTextView9")
    private MobileElement textoAvaliarCredito;

    @AndroidFindBy(accessibility = "SAIR")
    @iOSXCUITFindBy(id = "SAIR")
    private MobileElement botaoLogout;

    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFecharAtalhos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_forgot_password")
    @iOSXCUITFindBy(accessibility = "Esqueceu sua senha?")
    private MobileElement botaoEsqueceuSuaSenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Logar com outro CPF")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @AndroidFindBy(accessibility = "Voltar para a tela anterior")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Voltar para a tela anterior\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    private MobileElement setaVoltar;

    @iOSXCUITFindBy(accessibility = "CRIAR CONTA NEXTJOY")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_create_account")
    private MobileElement botaoCriarNextJoy;

    @iOSXCUITFindBy(accessibility = "subscription-confirmation-card-joy")
    @AndroidFindBy(id="br.com.bradesco.next:id/img_next_joy")
    private MobileElement cardNextJoy;

    @iOSXCUITFindBy(accessibility = "ACOMPANHE A ABERTURA DE CONTAS")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_create_account")
    private MobileElement botaoAcompanheAberturaConta;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    public LoginTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar Seta Voltar
     * @return LoginTela
     * @throws NextException
     */
    @Step("Tocar Seta Voltar")
    public LoginTela tocarBotaoVoltar() throws NextException {
        aguardarElementoHabilitado(setaVoltar);
        salvarEvidencia("Tocar botão Voltar");
        tocarElemento(setaVoltar, "Erro ao tocar no elemento seta voltar");
        return this;
    }

    /**
     * Armazena valor informado no objeto thread-safe cpfLogin
     *
     * @param cpfLogin
     */
    public static void setCpfLogin(String cpfLogin) {
        if (LoginTela.cpfLogin == null) {
            LoginTela.cpfLogin = new ThreadLocal<>();
        }
        LoginTela.cpfLogin.set(cpfLogin);
    }

    /**
     * retorna string com o valor de agência armazenado no objeto thread-safe cpfLogin
     *
     * @return agencia
     */
    public static String retornaCpfLogin() {
        return cpfLogin.get();
    }

    /**
     * Verificar primeiro elemento carregado em uma lista de elementos
     *
     * @return int
     */
    @Step("Decidir próxima ação de login")
    public boolean isResetCpfRequerido() throws Exception {
        if (aguardarPaginaConterQualquerTexto(LoginApp.PALAVRA_TELA_RESETCPF_VAMOSLA,
                LoginApp.PALAVRA_TELA_INICIAL_REAIS).equals(LoginApp.PALAVRA_TELA_RESETCPF_VAMOSLA)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validar Exibição Tela Login
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Informar Senha")
    public LoginTela validarExibicaoTelaLogin() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos("CPF", "Senha"),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível verificar a exibição dos elementos da tela de login");
        salvarEvidencia("Validar exibição da tela de Login");
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
        escreverTexto(campoCPF, cpf, "não foi possível escrever o cpf");
        //implementação para melhorar tempo captura evidência
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
        if(ios) aguardarOcultacaoElemento(botaoLogin);
        OperadorEvidencia.logarPasso("Senha inserida");
        return this;
    }

    /**
     * Tocar botão "Entrar"
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Tocar em \"Entrar\"")
    public LoginTela tocarEntrar() throws Exception {
        if (aguardarPaginaConterTodosTextos(LoginApp.PALAVRA_TELA_LOGIN_BOTAOENTRAR)) {
            if (aguardarVisibilidadeElemento(botaoLogin,4,500)) {
                salvarEvidencia("Visualizar botão Login na tela");
                tocarElemento(botaoLogin, "Não foi possível tocar no botão login");
            }
            aguardarPaginaOcultar(LoginApp.PALAVRA_TELA_LOGIN_CPF);
        }
        OperadorEvidencia.logarPasso("Botão Login Tocado - Indo para Menu Principal");
        return this;
    }

    /**
     * Tocar botão "sair"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em \"Sair\"")
    public LoginTela tocarSair() throws Exception {
        if (android) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoLogout, "não foi possível tocarElemento em Logout");
        }
        tocarElemento(botaoLogout, "não foi possível tocarElemento em Logout");
        salvarEvidencia("Tocar Botão Logout");
        return this;
    }

    /**
     * Recarregar app do Next
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Recarregar App Next")
    public LoginTela recarregarAppNext() throws Exception {
        ((AppiumDriver)driver).resetApp();
        return this;
    }

    /**
     * Tocar botão "Esqueceu sua Senha?"
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Tocar botão \"Esqueceu sua Senha?\"")
    public LoginTela tocarBotaoEsqueceuSuaSenha() throws NextException {
        salvarEvidencia("Tocar botão \"Esqueceu sua Senha?\"");
        tocarElemento(botaoEsqueceuSuaSenha, "não foi possível tocar botão \"Esqueceu sua Senha?\"");
        return this;
    }

    @Step("Validar se o reset de CPF foi efetuado")
    public LoginTela validarResetCpf(boolean resetOK) {
        validarCondicaoBooleana(resetOK, MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível efetuar o reset de CPF.");
        return this;
    }

    /**
     * Método valida se a tela de login ainda está ativa
     *
     * @return
     */
    public boolean validacaoLoginNaoEfetuado() {
        return aguardarPaginaConterTodosTextos("CPF", "Senha");
    }

    /**
     * Tocar botão 'botaoCriarNextJoy'
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Tocar botão 'botaoCriarNextJoy'")
    public LoginTela tocarBotaoCriarNextJoy() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCriarNextJoy,"Não foi possível encontrar o botao 'botaoCriarNextJoy'");
        salvarEvidencia("Tocar botão 'botaoCriarNextJoy'");
        tocarElemento(botaoCriarNextJoy, "Não foi possível tocar no botao 'botaoCriarNextJoy'");
        return this;
    }

    /** validar card 'NextJoy'
     * @return LoginTela
     */
    @Step("validar card 'NextJoy'")
    public LoginTela validarCardNextJoy() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCriarNextJoy,"Não foi possível encontrar o botao 'botaoCriarNextJoy'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos("CRIAR CONTA NEXTJOY"), MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar card 'NextJoy'");
        salvarEvidencia("Validar card 'NEXTJOY'");
        return this;
    }

    /**
     * Tocar botão 'Acompanhe Abertura de conta'
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Tocar botão 'Acompanhe Abertura de conta'")
    public LoginTela tocarBotaoAcompanheAberturaConta() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAcompanheAberturaConta,"Não foi possível encontrar o elemento");
        salvarEvidencia("Tocar botão 'Acompanhe Abertura de conta'");
        tocarElemento(botaoAcompanheAberturaConta, "Não foi possível encontrar o botão 'Acompanhe Abertura de conta'");
        return this;
    }

    /**
     * Tocar botão 'Fechar'
     *
     * @return LoginTela
     * @throws Exception
     */
    @Step("Tocar botão 'Fechar'")
    public LoginTela tocarBotaoFechar() throws Exception {
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(botaoFechar,"Não foi possível encontrar o elemento");
        salvarEvidencia("Tocar botão 'Fechar'");
        tocarElemento(botaoFechar, "Não foi possível tocar no botao 'Fechar'");
        return this;
    }

    /**
     * Validar Mensagem Senha Invalida
     *
     * @param texto
     * @return
     */
    @Step("Validar Mensagem Senha Invalida")
    public LoginTela validarMensagemSenhaInvalida(String texto) {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(texto), MetodoComparacaoBooleano.VERDADEIRO, "Texto Senha invalida não esta presente na tela");
        salvarEvidencia("Mensagem de senha invalida");
        return this;
    }



}
