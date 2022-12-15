package pagina.mobile.jornadas.nextjoy;

import base.mobile.nextJoy.PaginaBaseNextJoy;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.Normaliza;
import br.com.next.automacao.core.exception.NextException;
import constantes.nextJoy.MensagemEsperadas;
import constantes.nextJoy.TituloTela;
import constantes.nextJoy.Vinculo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

public class NextJoyTela extends PaginaBaseNextJoy {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue")
    @iOSXCUITFindBy(accessibility = "CRIAR CONTA NEXTJOY")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CRIAR CONTA NEXTJOY\"`]")
    private MobileElement botaoCriarContaNextJoy;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_name")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Nome completo do dependente']")
    @iOSXCUITFindBy(accessibility = "Nome completo do dependente")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Nome completo do dependente\"`]")
    private MobileElement campoNomeCompleto;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_cpf")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='CPF']")
    @iOSXCUITFindBy(accessibility = "CPF")
    @iOSXCUITFindBy(accessibility = "CPF do dependente")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"CPF do dependente\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"CPF\"`]")
    private MobileElement campoCpf;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_birthday")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Data de nascimento']")
    @iOSXCUITFindBy(accessibility = "Data de nascimento")
    @iOSXCUITFindBy(accessibility = "Campo obrigat�rio. Lembre-se de preencher :)")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Data de nascimento\"`]")
    private MobileElement campoDataDeNascimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/npb_family_bond")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Selecione o v�nculo\"]")
    @iOSXCUITFindBy(accessibility = "Selecione o v�nculo")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Selecione o v�nculo\"`]")
    private MobileElement campoVinculo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sou pai']")
    @iOSXCUITFindBy(accessibility = "Sou pai")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Sou pai\"`]")
    private MobileElement vinculoSouPai;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sou m�e']")
    @iOSXCUITFindBy(accessibility = "Sou m�e")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Sou m�e\"`]")
    private MobileElement vinculoSouMae;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sou tutor(a)']")
    @iOSXCUITFindBy(accessibility = "Sou tutor (a)")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Sou tutor (a)\"`]")
    private MobileElement vinculoSouTutor;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='CONTINUAR']")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='SIM, USAR MEUS DADOS']")
    @iOSXCUITFindBy(accessibility = "SIM, USAR MEUS DADOS")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SIM, USAR MEUS DADOS\"`]")
    private MobileElement botaoSimUsarMeusDados;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_edit_data")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='N�O, USAR OUTROS DADOS']")
    @iOSXCUITFindBy(accessibility = "N�O, USAR OUTROS DADOS")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"N�O, USAR OUTROS DADOS\"`]")
    private MobileElement botaoNaoUsarOutrosDados;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_password")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Senha, Informe a senha do dependente\"]")
    @iOSXCUITFindBy(accessibility = "Senha")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`label == \"Senha\"`]")
    private MobileElement campoSenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_password_confirmation")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Confirme a senha, Confirme a senha\"]")
    @iOSXCUITFindBy(accessibility = "Confirme a senha")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`label == \"Confirme a senha\"`]")
    private MobileElement campoConfirmeSenha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_email")
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,\"E-mail do dependente\")]")
    @iOSXCUITFindBy(accessibility = "E-mail do dependente")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"E-mail do dependente\"`]")
    private MobileElement campoEmailDependente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_email_confirmation")
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,\"Confirme o e-mail do dependente\")]")
    @iOSXCUITFindBy(accessibility = "Confirme o e-mail do dependente")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Confirme o e-mail do dependente\"`]")
    private MobileElement campoConfirmeEmailDependente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_cellphone")
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,\"celular do dependente\")]")
    @iOSXCUITFindBy(accessibility = "N�mero do celular do dependente")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"N�mero do celular do dependente\"`]")
    private MobileElement campoCelularDependente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_finish_later")
    @iOSXCUITFindBy(accessibility = "TERMINAR MAIS TARDE")
    private MobileElement botaoTerminarMaisTarde;

    @iOSXCUITFindBy(accessibility = "SIM")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    private MobileElement botaoSim;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "OK, OBRIGADO!")
    private MobileElement botaoOkObrigado;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    private MobileElement botaoVoltarMenu;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id="br.com.bradesco.next:id/nb_primary_button")
    private MobileElement botaoOK;

    @iOSXCUITFindBy(accessibility = "ACOMPANHE A ABERTURA DE CONTAS")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_create_account")
    private MobileElement botaoAcompanheAberturaConta;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_teen_goto_menu")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'ADICIONAR DEPENDENTE')]")
    private MobileElement botaoMaisAdicionarDependente;


    public NextJoyTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela criar conta NextJoy
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Validar tela criar conta NextJoy")
    public NextJoyTela validarPresencaTelaCriarContaNextJoy() throws NextException {
        if (verificarPresencaElemento(botaoCriarContaNextJoy)) {
            tocarElemento(botaoCriarContaNextJoy, "N�o foi possivel tocar no bot�o NextJoy");
            salvarEvidencia("Tocado no bot�o NextJoy");
        }
        return this;
    }


    /**
     * Preencher Nome completo
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Preencher Nome completo")
    public NextJoyTela preencherNomeCompleto(String nome) throws Exception {
        if (ios) {
            escreverTexto(campoNomeCompleto, nome, "N�o foi possivel preencher o campo Nome do depedente");
        }else {
            digitarTexto(campoNomeCompleto, nome);
        }
        salvarEvidencia("Preencheu 'Nome Completo' do Dependente: " + nome);
        return this;
    }

    /**
     * Preencher Campo CPF
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Preencher Campo CPF")
    public NextJoyTela preencherCampoCpf(String cpf) throws Exception {
        if (ios) {
            escreverTexto(campoCpf, cpf, "N�o foi possivel preencher o campo CPF");
            clicarContinuarTecladoNextJoyIos();
        }else {
            digitarTexto(campoCpf, cpf);
        }
        salvarEvidencia("Preencheu CPF do Dependente: " + cpf);
        return this;
    }

    /**
     * Preencher Campo Data de Nascimento do dependente
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Preencher Campo Data de Nascimento do dependente")
    public NextJoyTela preencherCampoDataDeNascimento(String data) throws Exception {
        if (ios) {
            escreverTexto(campoDataDeNascimento, data, "N�o foi possivel preencher a Data de Nascimento do dependente");
        } else {
            tocarElemento(campoDataDeNascimento,"Erro ao tocar em Data de Nascimento");
            enviarTexto(data.replaceAll("[^0-9]",""));
        }
        salvarEvidencia("Preencheu 'Data de Nascimento' do Dependente: " + data);
        return this;
    }

    /**
     * Tocar selecionar vinculo
     *
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Tocar selecionar vinculo")
    public NextJoyTela tocaSelecionarVinculo() throws Exception {
        rolarTela(0.4,0.1);
        salvarEvidencia("Tocar selecionar v�nculo");
        tocarElemento(campoVinculo, "N�o foi poss�vel tocar em selecionar v�nculo");
        return this;
    }

    /**
     * Tocar selecionar vinculo
     *
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Tocar selecionar vinculo")
    public NextJoyTela selecionarVinculo(Vinculo vinculo) throws Exception {
        switch (vinculo) {
            case PAI:
                tocarElemento(vinculoSouPai, "N�o foi poss�vel selecionar v�nculo 'Sou Pai'");
                break;
            case MAE:
                tocarElemento(vinculoSouMae, "N�o foi poss�vel selecionar v�nculo 'Sou M�e'");
                break;
            case TUTOR:
                tocarElemento(vinculoSouTutor, "N�o foi poss�vel selecionar v�nculo 'Sou tutor'");
                break;
        }
        salvarEvidencia("Selecionar v�nculo 'Sou " + vinculo + "'");
        return this;
    }

    /**
     * Tocar bot�o continuar
     *
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Tocar bot�o continuar")
    public NextJoyTela tocarBotaoContinuar() throws Exception{
        rolarTela(0.4,0.1);
        salvarEvidencia("Tocar bot�o continuar");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o continuar");
        return this;
    }

    /**
     * Validar titulo tela
     *
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Validar titulo tela")
    public NextJoyTela validarTituloTela() throws Exception {
        salvarEvidencia("Valida tela 'Criar Conta NextJoy'");
        validarCondicaoBooleana(aguardarCarregamentoElemento(TituloTela.CRIAR_CONTA_NEXTJOY),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao verificar titulo da tela");
        return this;
    }

    /**
     * Tocar bot�o 'Sim, usar meus dados'
     *
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Sim, usar meus dados'")
    public NextJoyTela tocarBotaoSimUsarMeusDados() throws Exception {
        salvarEvidencia("Tocar bot�o 'Sim, usar meus dados'");
        tocarElemento(botaoSimUsarMeusDados, "N�o foi poss�vel tocar o bot�o 'Sim, usar meus dados'");
        return this;
    }

    /**
     * Tocar bot�o 'N�o, usar outros dados'
     *
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'N�o, usar outros dados'")
    public NextJoyTela tocarBotaoNaoUsarOutrosDados() throws Exception {
        salvarEvidencia("Tocar bot�o 'N�o, usar outros dados'");
        tocarElemento(botaoNaoUsarOutrosDados, "N�o foi poss�vel tocar o bot�o 'N�o, usar outros dados'");
        return this;
    }

    /**
     * Preencher campo 'Criar senha'
     *
     * @param senha Senha a ser informada para logar no app
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Preencher campo 'Senha'")
    public NextJoyTela preencherCampoSenha(String senha) throws Exception {
        if (ios) {
            escreverTexto(campoSenha, senha, "N�o foi poss�vel preencher campo 'Criar senha'");
        }else {
            digitarTexto(campoSenha, senha);
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo 'Criar senha'");
        return this;
    }

    /**
     * Preencher campo 'Confirmar senha'
     *
     * @param senha Confirma��o da senha para logar no app
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Confirmar senha")
    public NextJoyTela preencherCampoConfirmarSenha(String senha) throws Exception {
        if (ios) {
            escreverTexto(campoConfirmeSenha, senha, "N�o foi poss�vel preencher campo 'Confirmar senha");
        }else {
            digitarTexto(campoConfirmeSenha, senha);
        }
        salvarEvidencia("Preencher campo 'Confirmar senha'");
        return this;
    }

    /**
     * Informar e-mail do dependente
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Informar e-mail do dependente")
    public NextJoyTela informarEmailDependente(String email) throws Exception {
        escreverTexto(campoEmailDependente, email, "N�o foi poss�vel informar o campo email");
        salvarEvidencia("Informar e-mail dependente");
        return this;
    }

    /**
     * Confirmar e-mail do dependente
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Confirmar e-mail do dependente")
    public NextJoyTela confirmarEmailDependente(String email) throws Exception {
        escreverTexto(campoConfirmeEmailDependente, email, "N�o foi poss�vel confirmar o campo email");
        salvarEvidencia("Confirmar e-mail dependente");
        return this;
    }

    /**
     * Informar numero celular do dependente
     *
     * @return  NextJoyTela
     * @throws NextException
     */
    @Step("Informar numero celular do dependente")
    public NextJoyTela informarNumeroCelularDependente(String celular) throws Exception {
        escreverTexto(campoCelularDependente, celular, "N�o foi poss�vel informar o n�mero do celular");
        salvarEvidencia("Informando n�mero celular do dependente");
        return this;

    }

    /**
     * Tocar Botao 'Criar Conta NextJoy'
     *
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Tocar Botao 'Criar Conta NextJoy'")
    public NextJoyTela tocarBotaoCriarContaNextJoy() throws Exception {
        salvarEvidencia("Tocar Botao 'Criar Conta NextJoy'");
        tocarElemento(botaoCriarContaNextJoy, "N�o foi poss�vel Tocar Botao 'Criar Conta NextJoy'");
        return this;

    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Tocar bot�o 'Voltar'")
    public NextJoyTela tocarBotaoVoltar() throws NextException {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        aguardarElementoHabilitado(botaoVoltar);
        if (ios) {
            tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        }else {
            voltarTelaAnterior();
        }
        return this;
    }


    /**
     * Tocar bot�o 'Menu'
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Tocar bot�o 'Menu'")
    public NextJoyTela tocarBotaoMenu() throws NextException {
        salvarEvidencia("Tocar bot�o 'Menu'");
        tocarElemento(botaoVoltarMenu,"N�o foi poss�vel tocar no bot�o 'Menu'");
        return this;
    }

    /**
     * Validar mensagem cadastro j� existe
     *
     * @return NextJoyTela
     */
    @Step("Validar mensagem cadastro j� existe")
    public NextJoyTela validarMensagemCadastroExiste() {

        salvarEvidencia("Validar mensagem cadastro j� existe");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(MensagemEsperadas.CADASTRO_JA_EXISTE),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao verificar mensagem cadastro j� existe");
        return this;
    }

    /**
     * Tocar bot�o 'OK'
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Tocar bot�o 'OK'")
    public NextJoyTela tocarBotaoOk() throws NextException {

        tocarElemento(botaoOK,"N�o foi poss�vel tocar no bot�o 'OK'");
        salvarEvidencia("Tocar bot�o 'OK'");
        return this;
    }

    /** Validar Tela Senha e tocar em continuar
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Validar Tela Senha e tocar em continuar")
    public NextJoyTela validarTelaSenha() throws NextException {
        boolean telaSenha = aguardarPaginaConterTodosTextos(MensagemEsperadas.TELA_SENHA);
        if (telaSenha && ios) {
            tocarElemento(botaoContinuar, "N�o foi poss�vel tocar Elemento 'botaoContinuar' ");
        }
        salvarEvidencia("Validar Tela Senha e tocar em continuar");
        return this;
    }

    /** Validar Tela Senha e tocar em continuar
     *
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Validar Tela Senha e tocar em continuar")
    public NextJoyTela validarTelaDadosETocarContinuar() throws NextException {
        if(android) esperarCarregando();
        if (verificarPresencaElemento(campoVinculo) && ios){
            tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o continuar");
            salvarEvidencia("Validar Tela de Dados e tocar em continuar");
        }
        return this;
    }

    /** Tocar Botao 'Terminar Mais Tarde'
     * @return
     * @throws NextException
     */
    @Step("Tocar Botao 'Terminar Mais Tarde'")
    public NextJoyTela tocarBotaoTerminarMaisTarde() throws Exception {
        salvarEvidencia("Tocar Botao 'Terminar Mais Tarde'");
        tocarElemento(botaoTerminarMaisTarde, "N�o foi poss�vel Tocar Botao 'Terminar Mais Tarde'");
        return this;
    }

    /** Validar texto 'Quer Salvar Dados que preencheu at� aqui?'
     * @return
     * @throws NextException
     */
    @Step("Validar texto 'Quer Salvar Dados que preencheu at� aqui?'")
    public NextJoyTela validarTextoQuerSalvarDados(String texto) throws Exception {
        salvarEvidencia("Validar Texto 'Quer Salvar Dados que preencheu at� aqui?'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(texto),MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel encontrar os textos na p�gina: "+ texto);
        return this;
    }

    /** Tocar Botao 'SIM'
     * @return
     * @throws NextException
     */
    @Step("Tocar Botao 'SIM'")
    public NextJoyTela tocarBotaoSimPopUp() throws Exception {
        salvarEvidencia("Tocar Botao 'SIM'");
        tocarElemento(botaoSim, "N�o foi poss�vel Tocar Botao 'SIM'");
        return this;
    }

    /** Validar texto na p�gina
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Validar texto na pagina")
    public NextJoyTela validarPresencaTextoNaPaginda(String texto) throws Exception {
        salvarEvidencia("Validar Texto \"" + texto + "\"");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(texto),MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel encontrar os textos na p�gina: "+ texto);
        return this;
    }

    /** Tocar Botao 'Ok, Obrigado'
     * @return
     * @throws NextException
     */
    @Step("Tocar Botao 'Ok, Obrigado'")
    public NextJoyTela tocarBotaoOkObrigado() throws Exception {
        salvarEvidencia("Tocar Botao 'Ok, Obrigado'");
        tocarElemento(botaoOkObrigado, "N�o foi poss�vel Tocar Botao 'Ok, Obrigado'");
        return this;
    }

    /**
     * Tocar bot�o 'Acompanhe Abertura de conta'
     *
     * @return NextJoyTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Acompanhe Abertura de conta'")
    public NextJoyTela tocarBotaoAcompanheAberturaConta() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAcompanheAberturaConta,"N�o foi poss�vel encontrar o botao 'Acompanhe Abertura de conta'");
        salvarEvidencia("Tocar bot�o 'Acompanhe Abertura de conta'");
        tocarElemento(botaoAcompanheAberturaConta, "N�o foi poss�vel tocar no botao 'Acompanhe Abertura de conta'");
        return this;
    }

    /**
     *
     * @return
     */
    @Step("Verifica Label: 'Selecione Uma Conta Para Gerenciar'")
    public Boolean verificaLabelSelecioneUmaContaParaGerenciar(){
        Boolean verificar = aguardarPaginaConterTodosTextos(Normaliza.String,"Selecione uma conta para gerenciar");
        salvarEvidencia(verificar ?
                "Verificou Label: 'Selecione Uma Conta Para Gerenciar'" :
                "N�o apresentou Label: 'Selecione Uma Conta Para Gerenciar'");
        return verificar;
    }

    /**
     * Tocar Bot�o '+ Adicionar Dependente'
     * @return NextJoyTela
     * @throws NextException
     */
    @Step("Tocar Bot�o '+ Adicionar Dependente'")
    public NextJoyTela tocarBotaoMaisAdicionarDependente() throws Exception {
        salvarEvidencia("Tocar bot�o '+ Adicionar Dependente'");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMaisAdicionarDependente,"Erro ao rolar at� o bot�o '+ Adicionar Dependente'");
        tocarElemento(botaoMaisAdicionarDependente,"Erro ao tocar bot�o '+ Adicionar Dependente'");
        return this;
    }

    /**
     * Enviar Texto
     * @param texto
     */
    private void enviarTexto(String texto){
        try { new Actions(this.driver).sendKeys(texto).perform(); } catch (Exception e){}
    }

}
