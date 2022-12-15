package pagina.mobile.jornadas.ajuda;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.ajuda.EsqueciMinhaSenha;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EsqueciMinhaSenhaTela extends PaginaBase {


    // Tela 'Esqueci Minha Senha'
    @AndroidFindBy(xpath = "//*[contains(@text, 'Digite seu CPF para mudar a senha')]")
    @iOSXCUITFindBy(accessibility = "Digite seu CPF para mudar a senha")
    private MobileElement mensagemDigiteSeuCPF;

    // Campo: 'CPF'
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='CPF']")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private MobileElement campoCPFRecuperaSenha;

    // Tocar: bot�o 'Continuar'
    @AndroidFindBy(xpath = "//*[contains(@text,'CONTINUAR')]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    // Texto: A gente mandou um c�digo pro e-mail que voc� cadastrou aqui no next. Copia e cola ele aqui.
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_security_code")
    @iOSXCUITFindBy(accessibility = "A gente mandou um c�digo pro e-mail que voc� cadastrou aqui no next. Copia e cola ele aqui.")
    private MobileElement mensagemAposBotaoContinuar;

    // Tocar: bot�o 'Reenviar C�digo'
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_resend")
    @iOSXCUITFindBy(accessibility = "REENVIAR C�DIGO")
    private MobileElement botaoReenviarCodigo;

    // Campo: C�digo de Seguran�a
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_code")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private MobileElement campoCodigodeSeguranca;

    // Campo: Nova Senha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_password")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField")
    private MobileElement campoNovaSenha;

    // Campo: Confirmar Senha
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_confirm_password")
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField")
    private MobileElement campoConfirmarSenha;

    // Tocar: Bot�o Proximo
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_next")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PR�XIMO\"]")
    private MobileElement botaoProximo;

    // Texto: Sua senha nova j� t� valendo!
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sua senha nova j� est� valendo!\"]")
    @iOSXCUITFindBy(accessibility = "Sua senha nova j� t� valendo.")
    private MobileElement mensagemTudoDeuCerto;

    // Tocar: Botao Login
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_login")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"LOGIN\"]")
    private MobileElement botaoLogin;

    public EsqueciMinhaSenhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar texto "Digite seu CPF pra mudar sua senha"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Validar texto \"Digite seu CPF pra mudar sua senha\"")
    public EsqueciMinhaSenhaTela validarMensagemDigiteSeuCPF() throws Exception {
        aguardarCarregamentoElemento(mensagemDigiteSeuCPF);
        if (ios){
            aguardarCarregamentoElemento(mensagemDigiteSeuCPF);
            validarAtributoTexto(mensagemDigiteSeuCPF, EsqueciMinhaSenha.DIGITE_SEU_CPF_IOS.toString(), "Erro ao validar texto \"Digite seu CPF pra mudar sua senha\"");
            salvarEvidencia("Validar texto \"Digite seu CPF pra mudar sua senha\"");
        }
        if (android){
            aguardarCarregamentoElemento(mensagemDigiteSeuCPF);
            validarAtributoTexto(mensagemDigiteSeuCPF, EsqueciMinhaSenha.DIGITE_SEU_CPF_ANDROID.toString(), "Erro ao validar texto \"Digita seu CPF pra mudar sua senha\"");
            salvarEvidencia("Validar texto \"Digita seu CPF pra mudar sua senha\"");
        }
        return this;
    }

    /**
     * Preencher o campo "CPF"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Preencher o campo \"CPF\"")
    public EsqueciMinhaSenhaTela preencherCampoCPFRecuperaSenha(String cpf) throws Exception {
        if (ios) {
            escreverTexto(campoCPFRecuperaSenha, cpf, "N�o foi possivel preencher \"CPF\"");
            tocarElemento(campoCPFRecuperaSenha, "N�o foi possivel tocar no Campo CPF");
            salvarEvidencia("Preencher o campo \"CPF\"");
            return this;
        }
        if (android){
            escreverTexto(campoCPFRecuperaSenha, cpf, "N�o foi possivel preencher \"CPF\"");
            salvarEvidencia("Preencher o campo \"CPF\"");
            return this;
        }
        return this;
    }

    /**
     * Tocar bot�o "Continuar"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public EsqueciMinhaSenhaTela tocarBotaoContinuar() throws Exception {
        tocarElemento(botaoContinuar, "N�o foi possivel tocar no bot�o \"Continuar\"");
        salvarEvidencia("Tocar bot�o \"Continuar\"");
        return this;
    }

    /**
     * Validar texto "A gente mandou um c�digo pro e-mail que voc� cadastrou aqui no next. Copia e cola ele aqui."
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Validar texto \"A gente mandou um c�digo pro e-mail que voc� cadastrou aqui no next. Copia e cola ele aqui.\"")
    public EsqueciMinhaSenhaTela validarMensagemAposBotaoContinuar() throws Exception {
        if (ios){
            validarCondicaoBooleana(
                    aguardarPaginaConterTodosTextos(EsqueciMinhaSenha.ENVIO_DE_CODIGO_IOS.toString()),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    "Mensagem 'Um c�digo de verifica��o foi enviado para t***e@teste.com' n�o est� presente!");
            salvarEvidencia("Mensagem 'Um c�digo de verifica��o foi enviado para t***e@teste.com' presente na tela!");
            return this;
        }
        else{
            validarCondicaoBooleana(
                    aguardarPaginaConterTodosTextos(EsqueciMinhaSenha.ENVIO_DE_CODIGO_ANDROID.toString()),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    "Mensagem 'Um e-mail com o c�digo de verifica��o foi enviado para t***e@teste.com' n�o est� presente!");
            salvarEvidencia("Mensagem 'Um e-mail com o c�digo de verifica��o foi enviado para t***e@teste.com' presente na tela!");
            return this;
        }
    }

    /**
     * Tocar bot�o "Reenviar C�digo"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Reenviar C�digo\"")
    public EsqueciMinhaSenhaTela tocarBotaoReenviarCodigo() throws Exception {
        tocarElemento(botaoReenviarCodigo, "N�o foi possivel tocar no bot�o \"Reenviar C�digo\"");
        salvarEvidencia("Tocar bot�o \"Reenviar C�digo\"");
        return this;
    }

    /**
     * Preencher campo "C�digo de Seguran�a"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Preencher campo \"C�digo de Seguran�a\"")
    public EsqueciMinhaSenhaTela preencherCampoCodigodeSeguranca(String codigo) throws Exception {
        escreverTexto(campoCodigodeSeguranca, codigo,"N�o foi possivel copiar o c�digo de Seguran�a");
        salvarEvidencia("Preencher campo \"C�digo de Seguran�a\"");
        return this;
    }

    /**
     * Preencher campo "Nova Senha"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Preencher campo \"Nova Senha\"")
    public EsqueciMinhaSenhaTela preencherCampoNovaSenha(String novaSenha) throws Exception {
        if (ios){
            escreverTexto(campoNovaSenha, novaSenha, "N�o foi possivel preencher o campo \"Nova Senha\"");
            salvarEvidencia("Preencher campo \"Nova Senha\"");
            return this;
        }if (android){
            escreverTexto(campoNovaSenha, novaSenha, "N�o foi possivel preencher o campo \"Nova Senha\"");
            salvarEvidencia("Preencher campo \"Nova Senha\"");
            return this;
        }
        return this;
    }

    /**
     * Preencher campo "Confirmar Senha"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Preencher campo \"Confirmar Senha\"")
    public EsqueciMinhaSenhaTela preencherCampoConfirmarSenha(String novaSenha) throws Exception {
        escreverTexto(campoConfirmarSenha, novaSenha, "N�o foi possivel preencher o campo \"Confirmar Senha\"");
        salvarEvidencia("Preencher campo \"Confirmar Senha\"");
        return this;
    }

    /**
     * Tocar bot�o "Proximo" para Android
     * Tocar bot�o "Continuar" para iOS
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Proximo/Continuar\"")
    public EsqueciMinhaSenhaTela tocarBotaoProximoOUContinuar() throws Exception {
        if (ios){
            tocarElemento(campoConfirmarSenha, "N�o foi possivel tocar em \"Confirmar a Senha\"");
            tocarElemento(botaoContinuar, "N�o foi possivel tocar no bot�o \"Proximo/Continuar\"");
            salvarEvidencia("Tocar bot�o \"Proximo/Continuar\"");
            return this;
        }if (android){
            tocarElemento(botaoProximo, "N�o foi possivel tocar no bot�o \"Proximo\"");
            salvarEvidencia("Tocar bot�o \"Proximo\"");
            return this;
        }
        return this;
    }

    /**
     * Validar mensagem do PopUp "Sua senha nova j� t� valendo!"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Validar mensagem do PopUp \"Sua senha nova j� t� valendo!\"")
    public EsqueciMinhaSenhaTela validarMensagemTelaTudoCerto() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(mensagemTudoDeuCerto);
            validarAtributoTexto(mensagemTudoDeuCerto, EsqueciMinhaSenha.TUDO_DEU_CERTO_IOS.toString(), "Erro ao validar mensagem do PopUp \"C�digo enviado novamente.\"");
            salvarEvidencia("Validar mensagem do PopUp \"C�digo enviado novamente.\"");
            return this;
        }
        if (android) {
            aguardarCarregamentoElemento(mensagemTudoDeuCerto);
            validarAtributoTexto(mensagemTudoDeuCerto, EsqueciMinhaSenha.TUDO_DEU_CERTO_ANDROID.toString(), "Erro ao validar mensagem do PopUp \"C�digo enviado novamente.\"");
            salvarEvidencia("Validar mensagem do PopUp \"C�digo enviado novamente.\"");
            return this;
        }
        return this;
    }

    /**
     * Tocar bot�o "Login"
     *
     * @return EsqueciMinhaSenhaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Login\"")
    public EsqueciMinhaSenhaTela tocarBotaoLogin() throws Exception {
        tocarElemento(botaoLogin, "N�o foi possivel tocar no bot�o \"Login\"");
        salvarEvidencia("Tocar bot�o \"Login\"");
        return this;
    }
}


