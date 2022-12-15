package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class NovoContatoVaquinhaTela extends PaginaBase {

    //nome contato vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Nome\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name=\"Nome\"])[2]")
    private MobileElement nomeContato;

    //email contato vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"E-mail\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name=\"E-mail\"])[2]")
    private MobileElement emailContato;

    //celular contato vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_phone")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Informe o celular com DDD.\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name=\"Informe o celular com DDD.\"])[2]")
    private MobileElement celularContato;

    //CPF contato vaquinha
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_cpf")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"CPF/CNPJ\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name=\"CPF/CNPJ\"])[2]")
    private MobileElement cpfContato;

    //botao Adicionar conta
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_create_vaquinha")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"+ Adicionar\"])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"+ Adicionar\"])[3]")
    private MobileElement botaoAdicionarConta;

    //botao Banco
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_create_vaquinha")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, Banco,")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Selecionar banco\"]")
    private MobileElement botaoBanco;

    //botao Agencia
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_agency")
    @iOSXCUITFindBy(accessibility = "Agência sem dígito")
    @AndroidFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Agência sem dígito\"]")
    private MobileElement botaoAgencia;

    //botao conta
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_account")
    @iOSXCUITFindBy(accessibility = "Conta e dígito sem hífen")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Conta e dígito sem hífen\"]")
    private MobileElement conta;

    //botao fechar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_create_vaquinha")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement fechar;

    //botao continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Continuar\"])[2]")
    private MobileElement continuar;

    public NovoContatoVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Preencher Nome Contato
     * @param nome
     * @return NovoContatoVaquinhaTela
     * @throws Exception
     */
    @Step("Preencher nome do contato")
    public NovoContatoVaquinhaTela preencherNomeContato(String nome) throws Exception {
        aguardarCarregamentoElemento(nomeContato);
        escreverTexto(nomeContato,nome,"Não foi possível preencher nome do contato: [" + nome + "].");
        salvarEvidencia("Preencher nome do contato: " + nome);
        return this;
    }

    /**
     * Preencher Email Contato
     * @param email
     * @return NovoContatoVaquinhaTela
     * @throws Exception
     */
    @Step("Preencher email do contato")
    public NovoContatoVaquinhaTela preencherEmailContato(String email) throws Exception {
        aguardarCarregamentoElemento(emailContato);
        escreverTexto(emailContato,email,"Não foi possível preencher email do contato: [" + email + "].");
        salvarEvidencia("Preencheu email do contato: " + email);
        return this;
    }

    /**
     * Preencher Celular Contato
     * @param telefone
     * @return NovoContatoVaquinhaTela
     * @throws NextException
     */
    @Step("Preencher celular do contato")
    public NovoContatoVaquinhaTela preencherCelularContato(String telefone) throws NextException {
        aguardarCarregamentoElemento(celularContato);
        escreverTexto(celularContato,telefone,"Não foi possível preencher celular do contato: [" + telefone + "].");
        salvarEvidencia("Preencheu o celular do contato: " + telefone);
        return this;
    }

    /**
     * Preencher CPF do contato
     * @param cpf
     * @return NovoContatoVaquinhaTela
     * @throws Exception
     */
    @Step("Preencher CPF do contato")
    public NovoContatoVaquinhaTela preencherCPFContato(String cpf) throws Exception {
        aguardarCarregamentoElemento(cpfContato);
        if(android)
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(cpfContato, "Não foi possível clicar no campo CPF");
        escreverTexto(cpfContato,cpf,"Não foi possível preencher CPF do contato: [" + cpf + "].");
        salvarEvidencia("Preencheu o CPF do contato: " + cpf);
        return this;
    }

    /**
     * Tocar no botão adicionar banco
     *
     * @return NovoContatoVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao adicionar conta")
    public NovoContatoVaquinhaTela tocarBotaoAdicionarConta() throws NextException {
        aguardarCarregamentoElemento(botaoAdicionarConta);
        tocarElemento(botaoAdicionarConta, "Não foi possível clicar no botão adicionar");
        salvarEvidencia("Tocar botao adicionar conta");
        return this;
    }

    /**
     * Clicar no campo banco
     *
     * @return NovoContatoVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao Banco conta")
    public NovoContatoVaquinhaTela tocarBotaoBancoConta() throws Exception {
        if (verificarPresencaElemento(botaoBanco)){
            aguardarCarregamentoElemento(botaoBanco);
            tocarElemento(botaoBanco, "Não foi possível clicar no botão Banco");
            salvarEvidencia("Tocar botao Banco");
        }
        tocarElemento(botaoBanco, "Não foi possível clicar no botão Banco");
        salvarEvidencia("Tocar botao Banco");
        return this;
    }


    /**
     * Preencher Agência
     * @param agencia
     * @return NovoContatoVaquinhaTela
     * @throws Exception
     */
    @Step("Preencher Agencia")
    public NovoContatoVaquinhaTela preencherAgencia(String agencia) throws Exception{
        aguardarCarregamentoElemento(botaoAgencia);
        escreverTexto(botaoAgencia,agencia,"Não foi possível preencher CPF do contato: [" + agencia + "].");
        salvarEvidencia("Digitou no campo Agencia: " + agencia);
        return this;
    }

    /**
     * Preencher Conta Sem Dígito
     * @param contaP
     * @return NovoContatoVaquinhaTela
     * @throws Exception
     */
    @Step("Preencher conta")
    public NovoContatoVaquinhaTela preencherContaSemDigito(String contaP) throws Exception{
        aguardarCarregamentoElemento(conta);
        escreverTexto(conta,contaP,"Não foi possível preencher a conta: [" + contaP+ "].");
        salvarEvidencia("Preencheu a conta: " + contaP);
        return this;
    }

    /**
     * Clicar no campo selecionar banco
     *
     * @return NovoContatoVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botao continuar")
    public NovoContatoVaquinhaTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(continuar);
        if(android)
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(continuar, "Não foi possível clicar no botão continuar");
        salvarEvidencia("Tocar botao continuar");
        tocarElemento(continuar, "Não foi possível clicar no botão continuar");
        return this;
    }

    /**
     * Clicar no campo Fechar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao Fechar")
    public NovoContatoVaquinhaTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(fechar);
        salvarEvidencia("Tocar botao fechar");
        tocarElemento(fechar, "Não foi possível clicar no botão fechar");
        return this;
    }

}
