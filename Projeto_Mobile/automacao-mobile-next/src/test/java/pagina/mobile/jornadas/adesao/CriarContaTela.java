package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

public class CriarContaTela extends PaginaBase {

    public CriarContaTela(AppiumDriver driver){
        super(driver);
    }

    //botao voltar <
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;


    //campo nome completo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_name")
    @iOSXCUITFindBy(accessibility = "Nome completo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Nome completo\"]")
    private MobileElement campoNomeCompleto;

    //Campo CPF
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_cpf")
    @iOSXCUITFindBy(accessibility = "CPF")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"CPF\"]")
    private MobileElement campoCpf;

    //campo Data Nascimento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_birthday")
    @iOSXCUITFindBy(accessibility = "Data de nascimento")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Data de nascimento\")]")
    private MobileElement campoDataNascimento;

    //campo Email
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_email")
    @iOSXCUITFindBy(accessibility = "E-mail")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"E-mail\")]")
    private MobileElement campoEmail;

    //campo Confirmar Email
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_email_confirmation")
    @iOSXCUITFindBy(accessibility = "Confirmar e-mail")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Confirmar e-mail\")]")
    private MobileElement campoConfirmarEmail;

    //campo Celular
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_mobile_phone")
    @iOSXCUITFindBy(accessibility = "Celular")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Celular\")]")
    private MobileElement campoCelular;

    //switch SMS
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/sw_switch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Ativado\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Desativado\"]")
    private MobileElement switchSMS;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_label_text")
    private MobileElement textoReceberInfos;


    //botao continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue")
    @AndroidFindBy(xpath = "//*[contains(@text,\"CONTINUAR\")]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"CONTINUAR\")]")
    private MobileElement botaoContinuar;


    /**
     * Tocar botao Voltar ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Voltar <\"")
    public CriarContaTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("'Tocar botao Voltar'");
        tocarElemento(botaoVoltar, "Erro ao Tocar botao Voltar");
        return this;
    }

    /**
     * validar titulo da tela 'Criar Conta'
     * fr
     * @return
     * @throws Exception
     */
    @Step("validar tela  \"Criar Conta\"")
    public CriarContaTela validarTituloCriarConta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CRIAR_CONTA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Criar Conta' não está presente na tela!");
        salvarEvidencia("validar que esta na tela de 'Criar Conta'");
        rolarTelaAteFinal();
        return this;
    }

    /**
     * preencher nome completo
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Nome Completo\"")
    public CriarContaTela preencherNomeCompleto(String nome) throws Exception {
        if (ios){
            escreverTexto(campoNomeCompleto,nome, "Erro ao preencher campo nome completo");
        }else {
            digitarTexto(campoNomeCompleto,nome);
        }
        esconderTeclado();
        salvarEvidencia("'Preencher campo nome completo'");
        return this;
    }

    /**
     * preencher CPF
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"CPF\"")
    public CriarContaTela preencherCPF(String cpf) throws Exception {
        if (ios){
            escreverTexto(campoCpf,cpf, "Erro ao preencher campo cpf");
        }else {
            digitarTexto(campoCpf,cpf);
        }
        esconderTeclado();
        salvarEvidencia("'Preencher campo CPF'");
        return this;
    }

    /**
     * preencher Data Nascimento
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Data Nascimento\"")
    public CriarContaTela preencherDataNascimento(String dataNascimento) throws Exception {
        if (ios){
            escreverTexto(campoDataNascimento,dataNascimento, "Erro ao preencher campo Data Nascimento");
        }else {
            digitarTexto(campoDataNascimento,dataNascimento);
        }
        esconderTeclado(campoDataNascimento);
        salvarEvidencia("'Preencher campo Data Nascimento'");
        return this;
    }

    /**
     * preencher campo Email
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Email\"")
    public CriarContaTela preencherEmail(String email) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoEmail, "Não foi possível localizar o campo 'E-mail'");
        if (ios){
            escreverTexto(campoEmail,email, "Erro ao preencher campo Email");
        }else {
            digitarTexto(campoEmail,email);
        }
        esconderTeclado(campoEmail);
        salvarEvidencia("'Preencher campo Email'");
        return this;
    }

    /**
     * preencher Confirmar Email
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Confirmar Email\"")
    public CriarContaTela preencherConfirmarEmail(String confirmarEmail) throws Exception {
        rolarTelaAteFinal();
        /*rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoConfirmarEmail, "Não foi possível localizar o campo 'Confirmar E-mail'");*/
        if (ios){
            escreverTexto(campoConfirmarEmail,confirmarEmail, "Erro ao preencher campo Confirmar Email");
        }else {
            digitarTexto(campoConfirmarEmail,confirmarEmail);
        }
        esconderTeclado(campoConfirmarEmail);
        salvarEvidencia("'Preencher campo Confirmar Email'");
        return this;
    }

    /**
     * preencher Celular
     * FR
     * @return
     * @throws Exception
     */
    @Step("Preencher \"Celular\"")
    public CriarContaTela preencherCelular(String celular) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoCelular, "Não foi possível localizar o campo 'Celular'");
        if (ios){
            escreverTexto(campoCelular,celular, "Erro ao preencher campo Celular");
        }else {
            digitarTexto(campoCelular,celular + Keys.ENTER);
        }
        esconderTeclado();
        salvarEvidencia("'Preencher campo Celular'");
        return this;
    }

    /**
     * Tocar Switch SMS
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Switch SMS\"")
    public CriarContaTela tocarSwitchSMS() throws Exception {
        salvarEvidencia("'Tocar Switch SMS'");
        tocarElemento(switchSMS, "Erro ao Tocar Switch SMS");
        return this;
    }

    /**
     * Validar que está na tela Criar Conta
     *
     * @return
     * @throws Exception
     */
    @Step("Validar que está na tela 'Criar Conta'")
    public CriarContaTela validarPresencaTelaCriarConta() throws Exception {
        aguardarPaginaConterTodosTextos(TituloTela.CRIAR_CONTA.toString());
        salvarEvidencia("'Tocar Switch SMS'");
        return this;
    }

    /**
     * Tocar Texto Receber Infos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar texto Receber Infos")
    public CriarContaTela tocarTextoReceberInfos() throws Exception {
        tocarElemento(textoReceberInfos, "Não foi possível tocar no texto Receber Infos");
        salvarEvidencia("Tocar texto Receber Infos");

        return this;
    }

    /**
     * Tocar no botão Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'Continuar'")
    public CriarContaTela tocarBotaoContinuar() throws Exception {
        if (ios){
            tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar' do teclado");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "Não foi possível localizar o botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        salvarEvidencia("'Tocar no botão Continuar'");

        return this;
    }

}
