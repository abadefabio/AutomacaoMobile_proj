package pagina.mobile.jornadas.transferencia.para.outra;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static br.com.next.automacao.core.tools.Utilitarios.geradorNomeCompleto;
import static br.com.next.automacao.core.tools.Utilitarios.gerarCpf;
import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;
import static br.com.next.automacao.core.tools.Utilitarios.pegarDataAtualEpoch;
import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.retornaNomeContato;
import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.setNomeContato;

public class NovoContatoTela extends PaginaBase {

    private static ThreadLocal<String> valorAgencia = null;
    private static ThreadLocal<String> valorConta = null;
    private static ThreadLocal<String> valorCpf = null;
    String celular;

    /*variável utilizada para definir o tipo de instituição (Banco ou Instituição Financeira)
    e quais elementos deverão ser utilizados, pois os campos mudam de acordo com esta seleção.
    OBS: o valor da variável é true por default, mas será false caso a automação toque no elemento radioInstituicaoPagamento*/
    public boolean banco = true;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_tab_autorized")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/tv_tab_autorized']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Aba Novo Contato, Botão\"]")
    @iOSXCUITFindBy(accessibility = "NOVO CONTATO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Opção selecionável, NOVO CONTATO\"]/XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NOVO CONTATO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"NOVO\")]")
    private MobileElement retanguloSuperiorNovoContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"br.com.bradesco.next:id/rb_type_bank\"));")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_bank")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, Banco,")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Opção selecionável, Banco, ' AND visible == 1`]")
    private MobileElement radioBanco;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_institutional")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Opção selecionável, Instituição de pagamento, ' AND visible == 1`]")
    private MobileElement radioInstituicaoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name")
    @AndroidFindBy(xpath = "//android.widget.EditText[resource-id='br.com.bradesco.next:id/et_name']")
    @iOSXCUITFindBy(accessibility = "Nome completo")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Nome completo' AND visible == 1`]")
    private MobileElement textoNome;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_email")
    private MobileElement textoEmail;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_phone")
    private MobileElement textoCelular;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/tv_error']")
    private MobileElement erroGenericoCampoAndroid;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_cnpj")
    @AndroidFindBy(accessibility = "CPF/CNPJ")
    @AndroidFindBy(xpath = "//*[@content-desc='CPF/CNPJ']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"CPF/CNPJ\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'CPF/CNPJ' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "CPF/CNPJ")
    private MobileElement textoCpf;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_add_remove")
    private MobileElement botaoAdicionarConta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"br.com.bradesco.next:id/tv_value\"));")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Banco ou Instituição\"]/android.widget.RelativeLayout")
    @AndroidFindBy(xpath = "//*[id = 'br.com.bradesco.next:id/ll_container'][1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Selecionar banco' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Selecionar banco")
    private MobileElement caixaSelecaoInstituicao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_agencie")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/et_agency']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Agência\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_agencie")
    @AndroidFindBy(xpath = "//*[@text=\"Agência (opcional)\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Agência' AND visible == 1`][2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Agência' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Agência")
    @iOSXCUITFindBy(accessibility = "Agência (opcional)")
    private MobileElement textoAgencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_agency")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/et_agency']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Agência\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_agencie")
    @AndroidFindBy(xpath = "//*[@text=\"Agência (opcional)\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Agência (opcional)' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Agência (opcional)")
    private MobileElement textoAgenciaOpcional;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_account") // Conta e Digit
    @AndroidFindBy(accessibility = "Conta de Pagamento") // Conta Pagamento
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Conta de Pagamento\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Conta de pagamento\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Conta e dígito\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Conta e dígito\"]")
    @iOSXCUITFindBy(accessibility = "Conta e dígito")
    @iOSXCUITFindBy(accessibility = "Conta Pagamento")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Conta e dígito' AND visible == 1`]")
    private MobileElement textoContaDigito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Conta Pagamento")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Conta de Pagamento']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Conta Pagamento' AND visible == 1`][2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Conta Pagamento' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Conta Pagamento")
    private MobileElement textoContaPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_switch")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/next_switch']")
    @AndroidFindBy(xpath = "//android.widget.Switch[@content-desc=\"Salvar contatodesativado\"]")
    private MobileElement switchContaAutorizada;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @AndroidFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CONTINUAR\"])[1]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUAR\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_save")
    @iOSXCUITFindBy(xpath = "//*[@value='Continuar' or @value='CONTINUAR']")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_payment_account")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Salvar' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Salvar")
    private MobileElement botaoSalvar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText")
    private MobileElement mensagemConfirmacaoCadastro;

    //Utilizado xpath, pois tem o mesmo iD do switch Autorizar Conta para TED, e accessibility id muda dependendo do estado do switch
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/next_switch\" and contains(@content-desc, \"Salvar\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[$type='XCUIElementTypeStaticText' AND name BEGINSWITH 'Salvar' AND visible == 1$]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Salvar contato' and @visible='true']/ancestor::XCUIElementTypeCell")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Salvar') and @visible='true']/ancestor::XCUIElementTypeCell")
    private MobileElement switchSalvar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_switch")
    @AndroidFindBy(accessibility = "Conta autorizadaativado")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/next_switch\" and contains(@content-desc, \"TED\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"TED\")]/ancestor::XCUIElementTypeCell")
    private MobileElement switchAutorizarTED;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Fechar\")]")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fechar, Botão\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_container")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Sim'`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Sim']")
    private MobileElement botaoSimMensagem;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Não'`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Não']")
    private MobileElement botaoNaoMensagem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoHeaderVoltar;

    public NovoContatoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Armazena valor informado no objeto thread-safe valorAgencia
     *
     * @param agencia
     */
    public static void setAgenciaContato(String agencia) {
        if (valorAgencia == null) {
            valorAgencia = new ThreadLocal<>();
        }
        valorAgencia.set(agencia);
    }

    /**
     * retorna string com o valor de agência armazenado no objeto thread-safe valorAgencia
     *
     * @return agencia
     */
    public static String retornaAgenciaContato() {
        return valorAgencia.get();
    }

    /**
     * Armazena valor informado no objeto thread-safe valorConta
     *
     * @param conta
     */
    public static void setContaContato(String conta) {
        if (valorConta == null) {
            valorConta = new ThreadLocal<>();
        }
        valorConta.set(conta);
    }

    /**
     * Armazena valor informado no objeto thread-safe valorCpf
     *
     * @param cpf
     */
    public static void setValorCpf(String cpf) {
        if (valorCpf == null) {
            valorCpf = new ThreadLocal<>();
        }
        valorCpf.set(cpf);
    }

    /**
     * retorna string com o valor de conta armazenado no objeto thread-safe valorConta
     *
     * @return agencia
     */
    public static String retornaContaContato() {
        return valorConta.get();
    }

    /**
     * Retorna string com valor informado no objeto thread-safe valorCpf
     *
     * @return
     */
    public static String retornaCpf() {
        return valorCpf.get();
    }

    /**
     * Retorna o elemento contendo a mensagem de erro esperada na validação do campo
     *
     * @return MobileElement
     * @throws Exception
     */
    private MobileElement erroCampoAndroid(String descricaoErro) throws Exception {
        aguardarCarregamentoElemento(erroGenericoCampoAndroid);
        By locator = By.xpath("//*[@resource-id='br.com.bradesco.next:id/tv_error' and contains(@text,'" + descricaoErro + "')]");
        return retornarElemento(locator, "Não foi possível encontrar o elemento de erro com a descrição: " + descricaoErro);
    }

    /**
     * Preenche campo nome com texto Nome + Data atual
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Escreve o nome do novo contato")
    public NovoContatoTela informarNome() throws Exception {
        setNomeContato("NOME" + pegarDataAtualEpoch());
        aguardarCarregamentoElemento(textoNome);
        escreverTexto(textoNome, retornaNomeContato() + " Sobrenome", "Nao foi possível escrever o nome");
        return this;
    }

    /**
     * Preenche campo nome
     *
     * @param nomeInformado
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Escreve o nome do novo contato")
    public NovoContatoTela informarNome(String nomeInformado) throws Exception {
        setNomeContato(nomeInformado);
        aguardarCarregamentoElemento(textoNome);
        escreverTexto(textoNome, retornaNomeContato(), "Erro ao preencher campo nome");
        salvarEvidencia("Preencher campo nome com: \"" + retornaNomeContato() + "\"");
        return this;
    }

    @Step("Escreve o nome do novo contato")
    public NovoContatoTela informarNomeAleatorio() throws Exception {
        /*
        Em aparelhos com resolução baixa, o rolar aos poucos não funciona
        porque o elemento é encontrado, e depois disto, porém, não edita o campo.
        Uma pequena rolagem para baixo é necessária.
         */
        rolarTela(0.1, 0.8);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoNome, "Erro ao rolar tela para baixo até encontrar campo \"Nome\"");
        setNomeContato(geradorNomeCompleto(6, 6));
        OperadorEvidencia.logarPasso("Preencher campo nome com: \"" + retornaNomeContato() + "\"");
        if (ios) {
            apagarCampoTexto(textoNome, retornaNomeContato().length() * 2, "Não foi possível apagar o campo 'Nome'");
        } else {
            apagarCampoTexto(textoNome, "Não foi possível apagar o campo 'Nome'");
        }
        escreverTexto(textoNome, retornaNomeContato(), "Nao foi possível escrever o nome");
        if (ios) {
            tocarBotaoENTERTeclado(textoNome, "Erro ao tocar botão \"ENTER\" do teclado");
        }
        return this;
    }

    /**
     * Preenche campo e-mail com valor padrão
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Escreve o e-mail do contato")
    public NovoContatoTela informarEmail() throws Exception {
        aguardarCarregamentoElemento(textoEmail);
        escreverTexto(textoEmail, retornaNomeContato() + "@next.com.br", "Não foi possível escrever o e-mail");
        return this;
    }

    /**
     * Preenche campo telefone com valor aleatório
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Escreve o telefone celuar do contato")
    public NovoContatoTela informarCelular() throws Exception {
        celular = String.valueOf(numeroAleatorio(11111111, 99999999));
        aguardarCarregamentoElemento(textoCelular);
        escreverTexto(textoCelular, "119" + celular, "Nao foi possível escrever o numero de celular");
        esconderTeclado();
        return this;
    }

    /**
     * Preenche campo CPF com valor aleatório
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Escreve o CPF do contato")
    public NovoContatoTela informarCpf() throws Exception {
        String cpf = gerarCpf();
        OperadorEvidencia.logarPasso("Preencher campo CPF '" + cpf + "'");
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(textoCpf, "Erro ao rolar tela até CPF");
        aguardarCarregamentoElemento(textoCpf);
        escreverTexto(textoCpf, cpf, "Nao foi possível escrever o CPF");
        esconderTeclado();
        salvarEvidencia("Cadastro de contato");
        NovoContatoTela.setValorCpf(cpf);
        return this;
    }

    /**
     * Preenche campo CPF com valor aleatório
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Escreve o CPF do contato")
    public NovoContatoTela informarCpfNovoContato() throws Exception {
        String cpf = gerarCpf();
        OperadorEvidencia.logarPasso("Preencher campo CPF '" + cpf + "'");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoCpf, "Erro ao rolar tela até CPF");
        aguardarCarregamentoElemento(textoCpf);
        escreverTexto(textoCpf, cpf, "Nao foi possível escrever o CPF");
        esconderTeclado();
        salvarEvidencia("Cadastro de contato");
        NovoContatoTela.setValorCpf(cpf);
        return this;
    }

    /**
     * Preenche campo CPF
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Escreve o CPF do contato")
    public NovoContatoTela informarCpf(String cpf) throws Exception {
        NovoContatoTela.setValorCpf(cpf);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoCpf, "Erro ao rolar tela até CPF");
        if (ios) {
            apagarCampoTexto(textoCpf, retornaCpf().length() * 2, "Não foi possível apagar o campo CPF/CNPJ");
        } else {
            apagarCampoTexto(textoCpf, "Não foi possível apagar o campo CPF/CNPJ");
        }
        escreverTexto(textoCpf, retornaCpf(), "Nâo foi possível escrever o CPF/CNPJ");
        salvarEvidencia("Preenchido campo CPF/CNPJ com: " + retornaCpf());
        return this;
    }

    /**
     * Validar mensagem de CPF inválido
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Validar mensagem de CPF inválido")
    public NovoContatoTela validarMensagemCpfInvalido(String mensagem) throws Exception {

        /*
        Este método específico para validação de CPF inválido foi criado
        porque, para validar que está inválido, precisamos tentar salvar
        as informações clicando em Salvar (pelo menos no Android).
        A validação não é feita apenas por entrar com o valor incorreto
        e tampouco desfocando (ou focando em outros elementos).
        No iOS, basta desfocar (ou focar em outro campo).
         */


        if (android) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "Não foi possível rolar até o botão \"Continuar\"");
            tocarElemento(botaoContinuar, "Erro ao tocar no botão: continuar");
            validarAtributoTexto(erroCampoAndroid(mensagem), mensagem, "Não foi possível validar o erro de CPF inválido");
        } else {
            // validação para iOS, devido a inviabilidade para validar o CPF/CNPJ inválido, valida apenas
            // se após digitar cpf inválido ainda permanece na tela após tocar em salvar
            rolaTelaBaixo();
            tocarElemento(botaoContinuar, "Não foi possível tocar o botão \"Salvar\" para validar o CPF");
            validarCondicaoBooleana(botaoContinuar.isEnabled(),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    "Não foi possível validar o erro de CPF inválido");
        }
        salvarEvidencia("Mensagem de erro esperada: '" + mensagem + "'");
        return this;
    }

    /**
     * Validar CPF/CNPJ
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Validar CPF/CNPJ")
    public NovoContatoTela validarCpfCnpj(String cpfCnpj) throws Exception {
        cpfCnpj = cpfCnpj.length() == 11 ? cpfCnpj.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})", "$1.$2.$3-$4") : cpfCnpj.replaceAll(
                "([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})",
                "$1.$2.$3/$4-$5");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoCpf, "Erro ao rolar tela até CPF/CNPJ");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(cpfCnpj), MetodoComparacaoBooleano.VERDADEIRO, "CPF/CNPJ: " + cpfCnpj + " não está presente na tela!");
        salvarEvidencia("Validado CPF/CNPJ: '" + cpfCnpj + "'");
        return this;
    }

    /**
     * Validar CPF/CNPJ
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public NovoContatoTela tocarBotaoVoltar() throws Exception {
        if (android) {
            if (verificarPresencaElemento(botaoFechar)) {
                tocarElemento(botaoFechar, "Não foi possível tocar o botão Fechar");
            } else {
                executarVoltarAndroid();
            }
        } else {
            tocarElemento(botaoHeaderVoltar, "Erro ao tocar no botão Voltar (<)");
            salvarEvidencia("Tocar no botão Voltar (<)");
        }
        return this;
    }

    /**
     * Tocar ícone Adicionar conta
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar em adicionar conta")
    public NovoContatoTela tocarAdicionarConta() throws Exception {
        tocarElemento(botaoAdicionarConta, "falha ao tocar em adicionar conta");
        return this;
    }

    /**
     * Tocar caixa de seleção de instituição de pagamento
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar na caixa de selecao de instituicao de pagamento")
    public NovoContatoTela tocarSelecioneBanco() throws Exception {
        rolaTelaCima();
        salvarEvidencia("Tocar caixa de seleção de instituição");
        tocarElemento(caixaSelecaoInstituicao, "Nao foi possivel tocar na caixa de selecao de instituicao de pagamento");
        return this;
    }

    /**
     * Tocar o radio button Banco
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar na opção Banco")
    public NovoContatoTela tocarRadioButtonBanco() throws Exception {
        tocarElemento(radioBanco, "Nao foi possivel tocar a opção \"Banco\"");
        salvarEvidencia("Tocar opção \"Banco\"");
        banco = true;
        return this;
    }

    /**
     * Rolar até o início da tela (rolagem personalizada especial para esta tela)
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Selecionar Banco ou Instituição de Pagamento")
    public NovoContatoTela rolarAteInicio() throws Exception {
        /*
        A rolagem normal para cima ou para baixo, sem especificar coordenadas, pode falhar
        porque o ponto y selecionável para o swipe nesta tela em particular está abaixo do elemento retangular NOVO CONTATO
        no topo da tela. Tal elemento aparece somente ao transferir e quando não há nenhum contato.
        Esse elemento bloqueia o swipe (não é possível fazer swipe que utiliza um y dentro do retângulo do elemento).
        Por isso, o deslizar será calculado para pegarmos o ponto y inferior (y + margem de segurança) da base do elemento.
         */

        if (verificarPresencaElemento(retanguloSuperiorNovoContato)) {
            double yInicial = retanguloSuperiorNovoContato.getRect().y + retanguloSuperiorNovoContato.getSize().height + 30;
            rolarTela(yInicial / retornaDimensaoTela().height, 0.9);
        } else {
            /*
            Ao editar, não existe mais o retângulo NOVO CONTATO
             */
            rolarTelaAteInicio();
        }
        return this;
    }

    /**
     * Preencher campo agência com a agencia da conta selecionada
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("informar agencia")
    public NovoContatoTela informarAgencia() throws Exception {
        OperadorEvidencia.logarPasso("Preencher campo agência");
        setAgenciaContato(String.valueOf(numeroAleatorio(1111, 9999)));
        if (banco == false) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoAgenciaOpcional, "Não foi possível encontrar o campo 'Agência'");
            escreverTexto(textoAgenciaOpcional, retornaAgenciaContato(), "Nao foi possível escrever agencia ");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoAgencia, "Não foi possível encontrar o campo 'Agência'");
            escreverTexto(textoAgencia, retornaAgenciaContato(), "Nao foi possível escrever agencia ");
        }
        return this;
    }

    /**
     * Preencher campo agência com número aleatório
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("informar agencia")
    public NovoContatoTela informarAgencia(Enum agencia) throws Exception {
        OperadorEvidencia.logarPasso("Preencher campo agência");
        aguardarCarregamentoElemento(textoAgencia);
        escreverTexto(textoAgencia, agencia.toString(), "Nao foi possível escrever agencia ");
        esconderTeclado();
        return this;
    }

    /**
     * Preencher campo agência com a ageência da conta selecionada
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("informar agencia")
    public NovoContatoTela informarAgencia(String agencia) throws Exception {
        OperadorEvidencia.logarPasso("Preencher campo agência: " + agencia);
        setAgenciaContato(agencia);
        if (!banco) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoAgenciaOpcional, "Não foi possível rolar até a agência");
            escreverTexto(textoAgenciaOpcional, agencia, "Nao foi possível escrever agencia ");
        }
        else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoAgencia, "Não foi possível rolar até a agência");
            digitarTexto(textoAgencia, agencia);
        }
        salvarEvidencia("Informar agência");
        return this;
    }

    /**
     * Preencher campo conta com número aleatório
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Informar conta")
    public NovoContatoTela informarConta() throws Exception {
        OperadorEvidencia.logarPasso("Preencher campo conta com dígito");
        setContaContato(String.valueOf(numeroAleatorio(111111, 999999)));
        if (banco == false) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaPagamento, "Não foi possível rolar até o campo da conta");
            if (ios) {
                apagarCampoTexto(textoContaPagamento, retornaContaContato().length() * 2, "Nao foi possível apagar o campo conta para edição");

            } else {
                apagarCampoTexto(textoContaPagamento, "Nao foi possível apagar o campo conta para edição");
            }
            escreverTexto(textoContaPagamento, retornaContaContato(), "Nao foi possível escrever a conta");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaDigito, "Não foi possível rolar até o campo da conta");
            if (ios) {
                apagarCampoTexto(textoContaDigito, retornaContaContato().length() * 2, "Nao foi possível apagar o campo conta para edição");

            } else {
                apagarCampoTexto(textoContaDigito, "Nao foi possível apagar o campo conta para edição");
            }
            escreverTexto(textoContaDigito, retornaContaContato(), "Nao foi possível escrever a conta");
        }
        esconderTeclado();
        return this;
    }

    /**
     * Preencher campo conta com número aleatório
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Informar conta")
    public NovoContatoTela informarContaPagamento() throws Exception {
        OperadorEvidencia.logarPasso("Preencher campo conta com dígito");
        setContaContato(String.valueOf(numeroAleatorio(111111, 999999)));
        aguardarCarregamentoElemento(textoContaPagamento);
        escreverTexto(textoContaPagamento, retornaContaContato(), "Nao foi possível escrever a conta");
        return this;
    }

    /**
     * Preencher campo conta com a conta especificada
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Informar conta")
    public NovoContatoTela informarConta(String conta) throws Exception {
        OperadorEvidencia.logarPasso("Preencher campo conta com dígito");
        setContaContato(conta);
        if (banco == false) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaPagamento, "Não foi possível rolar até o campo da conta");
            if (ios) {
                apagarCampoTexto(textoContaPagamento, retornaContaContato().length() * 2, "Nao foi possível apagar o campo conta para edição");
            } else {
                apagarCampoTexto(textoContaPagamento, "Nao foi possível apagar o campo conta para edição");
            }
            escreverTexto(textoContaPagamento, retornaContaContato(), "Nao foi possível escrever a conta");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaDigito, "Não foi possível rolar até o campo da conta");
            if (ios) {
                apagarCampoTexto(textoContaDigito, retornaContaContato().length() * 2, "Nao foi possível apagar o campo conta para edição");
            } else {
                apagarCampoTexto(textoContaDigito, "Nao foi possível apagar o campo conta para edição");
            }
            digitarTexto(textoContaDigito, retornaContaContato());
            esconderTeclado();
        }
        salvarEvidencia("Informar conta");
        return this;
    }

    /**
     * Tocar botão salvar
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Salvar novo contato")
    public NovoContatoTela tocarSalvar() throws Exception {
        rolaTelaBaixo();
        salvarEvidencia("Visualizar botão \"Salvar\"");
        tocarElemento(botaoSalvar, "Nao foi possivel tocar em Salvar");
        salvarEvidencia("Salvar novo contato");
        return this;
    }

    /**
     * Tocar botão Continuar
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Cadastrar novo contato")
    public NovoContatoTela tocarContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "Erro ao rolar tela para baixo até encontrar botão \"Continuar\"");
        salvarEvidencia("Visualizar botão \"Continuar\"");
        tocarElemento(botaoContinuar, "Nao foi possivel tocar em botão \"Continuar\"");
        esperarCarregando();
        salvarEvidencia("Cadastra novo contato");
        return this;
    }

    /**
     * Preencher campo agência com valor informado em json
     *
     * @param agencia
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("preencher campo Agência")
    public NovoContatoTela preencherCampoAgencia(String agencia) throws Exception {
        setAgenciaContato(agencia);
        if (banco == false) {
            escreverTexto(textoAgenciaOpcional, retornaAgenciaContato(), "Nao foi possível escrever agencia ");
        } else {
            escreverTexto(textoAgencia, retornaAgenciaContato(), "Nao foi possível escrever agencia ");
        }
        salvarEvidencia("Preencher campo agência com:" + retornaAgenciaContato());
        return this;
    }

    /**
     * Preencher campo conta com valor informado em json
     *
     * @param conta
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Preencher campo conta")
    public NovoContatoTela preencherCampoConta(String conta) throws Exception {
        setContaContato(conta);
        if (banco == false) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaPagamento, "Não foi possível rolar até o campo da conta");
            if (ios) {
                apagarCampoTexto(textoContaPagamento, retornaContaContato().length() * 2, "Nao foi possível apagar o campo conta para edição");
            } else {
                apagarCampoTexto(textoContaPagamento, "Nao foi possível apagar o campo conta para edição");
            }
            escreverTexto(textoContaPagamento, retornaContaContato(), "Nao foi possível escrever a conta");
        } else {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaDigito, "Não foi possível rolar até o campo da conta");
            if (ios) {
                apagarCampoTexto(textoContaDigito, retornaContaContato().length() * 2, "Nao foi possível apagar o campo conta para edição");
            } else {
                apagarCampoTexto(textoContaDigito, "Nao foi possível apagar o campo conta para edição");
            }
            escreverTexto(textoContaDigito, retornaContaContato(), "Nao foi possível escrever a conta");
        }
        esconderTeclado();
        salvarEvidencia("Preencher campo conta com:" + retornaContaContato());
        return this;
    }

    /**
     * Tocar no switch "Salvar"
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar no switch \"Salvar\"")
    public NovoContatoTela tocarSwitchSalvar() throws Exception {
        if (android) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(switchSalvar, "Erro ao rolar tela até switch \"Salvar\" ");
            tocarElemento(switchSalvar, "Nao foi possivel tocar no switch \"Salvar\"");
        } else {
            rolaTelaBaixo();
            if (aguardarCarregamentoElemento(switchSalvar)) {
                tocarCoordenadaProporcional(switchSalvar, 90, 20);
            } else {
                tocarCoordenadaProporcional(319, 470);
            }
        }
        salvarEvidencia("Tocado no switch 'Salvar'");
        return this;
    }

    /**
     * Tocar no switch "Autorizar TED"
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar no switch \"Autorizar TED\"")
    public NovoContatoTela tocarSwitchTED() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(switchAutorizarTED, "Erro ao rolar tela até switch \"Autorizar TED\" ");
        if (android) {
            tocarElemento(switchAutorizarTED, "Nao foi possivel tocar no switch \"Autorizar TED\"");
        } else {
            tocarCoordenadaProporcional(switchAutorizarTED, 90, 50);
        }
        salvarEvidencia("Tocar no switch \"Autorizar TED\"");
        return this;
    }

    /**
     * Tocar radio-button "Instituição Pagamento"
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Instituição Pagamento\"")
    public NovoContatoTela tocarRadioButtonInstituicaoPagamento() throws Exception {
        rolaTelaCima();
        tocarElemento(radioInstituicaoPagamento, "Nao foi possivel tocar a opção \"Banco\"");
        salvarEvidencia("Tocar radio-button \"Instituição de Pagamento\"");
        banco = false;
        return this;
    }

    /**
     * Preencher campo conta com valor informado em json e fechar o teclado apos digitação
     *
     * @param conta
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Preenhcer campo conta")
    public NovoContatoTela preencherCampoContaFechandoTeclado(String conta) throws Exception {
        setContaContato(conta);
        if (ios) {
            aguardarCarregamentoElemento(textoContaDigito);
            escreverTexto(textoContaDigito, retornaContaContato(), "Nao foi possível escrever a conta");
            esconderTeclado();
            salvarEvidencia("Preencher campo conta com:" + retornaContaContato());
        } else {
            aguardarCarregamentoElemento(textoContaDigito);
            OperadorEvidencia.logarPasso("Preencher conta: " + retornaContaContato());
            escreverTexto(textoContaDigito, retornaContaContato(), "Nao foi possível escrever a conta");
            salvarEvidencia("Preencher campo conta com:" + retornaContaContato());
        }
        return this;
    }

    /**
     * Valida tela de Novo Contato
     *
     * @return boolean
     * @throws Exception
     */
    @Step("Validar esta tela \"Novo Contato\"")
    public NovoContatoTela validarTela() throws Exception {
        aguardarCarregamentoElemento(retanguloSuperiorNovoContato);
        salvarEvidencia("Validar que tela \"Novo Contato\" está presente.");
        validarCondicaoBooleana(verificarPresencaElemento(retanguloSuperiorNovoContato),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar que o applicativo está na tela de \"Novo Contato\"");
        return this;
    }

    /**
     * Retorna se estamos na tela de Novo Contato
     *
     * @return boolean
     * @throws Exception
     */
    @Step("Validar esta tela \"Novo Contato\"")
    public boolean verificarPresencaTela() throws Exception {
        aguardarCarregamentoElemento(retanguloSuperiorNovoContato);
        return verificarPresencaElemento(retanguloSuperiorNovoContato);
    }

    /**
     * Preencher Campo 'Conta Pagamento'
     *
     * @param conta
     * @return
     * @throws Exception
     */
    @Step("Preencher Campo 'Conta Pagamento'")
    public NovoContatoTela preencherCampoContaPagamento(String conta) throws Exception {
        setContaContato(conta);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaPagamento, "Erro ao rolar até o campo Conta e Dígito/Pagamento");
        if (ios) {
            apagarCampoTexto(textoContaPagamento, retornaContaContato().length() * 2, "Nao foi possível apagar o campo conta para edição");
        } else {
            apagarCampoTexto(textoContaPagamento, "Nao foi possível apagar o campo conta para edição");
        }
        escreverTexto(textoContaPagamento, retornaContaContato(), "Nao foi possível escrever a Conta e Dígito/Pagamento");
        salvarEvidencia("Preencher campo conta com:" + retornaContaContato());
        return this;
    }

    /**
     * Tocar Botão (Header) Fechar
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar Botão (Header) Fechar")
    public NovoContatoTela tocarBotaoHeaderFechar() throws NextException {
        tocarElemento(botaoFechar,"Erro ao tocar no botão fechar");
        salvarEvidencia("Tocar no botão fechar");
        return this;
    }

    /**
     * Tocar Botão (Header) Fechar Somente no IOS
     *
     * @return
     * @throws NextException
     */
    @Step("Tocar Botão (Header) Fechar")
    public NovoContatoTela tocarBotaoHeaderFecharSomenteIos() throws NextException {
        if(android) return this;
        salvarEvidencia("Tocar no botão fechar");
        tocarElemento(botaoFechar,"Erro ao tocar no botão fechar");
        esperarCarregando();
        return this;
    }

    /**
     * Tocar no botão Voltar (<)
     *
     * @return
     * @throws NextException
     */
    public NovoContatoTela tocarBotaoHeaderVoltar() throws NextException {
        tocarElemento(botaoHeaderVoltar, "Erro ao tocar no botão Voltar (<)");
        salvarEvidencia("Tocar no botão Voltar (<)");
        return this;
    }

}

