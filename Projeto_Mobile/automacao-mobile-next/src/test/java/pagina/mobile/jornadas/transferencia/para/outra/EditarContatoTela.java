package pagina.mobile.jornadas.transferencia.para.outra;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.testng.Assert;

import static br.com.next.automacao.core.tools.Utilitarios.*;
import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.retornaNomeContato;
import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.setNomeContato;

public class EditarContatoTela extends PaginaBase {

    private static ThreadLocal<String> valorAgencia = null;
    private static ThreadLocal<String> valorConta = null;
    private static ThreadLocal<String> valorCpf = null;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "EDITAR CONTATO")
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"EDITAR CONTATO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"EDITAR CONTATO\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"EDITAR CONTATO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"EDITAR CONTATO\"]")
    private MobileElement headerTituloEditarContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_name")
    @AndroidFindBy(xpath = "//android.widget.EditText[resource-id='br.com.bradesco.next:id/et_name']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Nome' AND visible == 1`]")
    @AndroidFindBy(accessibility = "Nome")
    private MobileElement textoNome;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_cnpj")
    @AndroidFindBy(accessibility = "CPF/CNPJ")
    @AndroidFindBy(xpath = "//*[@content-desc='CPF/CNPJ']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"CPF/CNPJ\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'CPF/CNPJ' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "CPF/CNPJ")
    private MobileElement textoCpf;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_bank")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Opção selecionável, Banco, ' AND visible == 1`]")
    private MobileElement radioBanco;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_institutional")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Opção selecionável, Instituição de pagamento, ' AND visible == 1`]")
    private MobileElement radioInstituicaoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Banco ou Instituição\"]/android.widget.RelativeLayout")
    @AndroidFindBy(xpath = "//*[id = 'br.com.bradesco.next:id/ll_container'][1]")
    @iOSXCUITFindBy(accessibility = "Selecionar banco")
    private MobileElement caixaSelecaoInstituicao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_agency")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/et_agency']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Agência\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Agência sem dígito' AND visible == 1`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Agência (opcional)' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Agência sem dígito")
    @iOSXCUITFindBy(accessibility = "Agência (opcional)")
    private MobileElement textoAgencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_account") // Conta e Digito
    @AndroidFindBy(accessibility = "Conta de Pagamento") // Conta Pagamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_payment_account")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Conta de Pagamento\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Conta e dígito sem hífen' AND visible == 1`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Conta Pagamento' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Conta e dígito sem hífen")
    @iOSXCUITFindBy(accessibility = "Conta Pagamento")
    private MobileElement textoContaDigito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"- Remover\"`][1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"- Remover\"]")
    @AndroidFindBy(accessibility = "REMOVER")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_add_remove")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"REMOVER\"]")
    private MobileElement removerConta; // (-Remover)

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"+ Adicionar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"+ Adicionar\"]")
    @AndroidFindBy(accessibility = "ADICIONAR")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ADICIONAR\"]")
    private MobileElement adicionarConta;// (+Adicionar)

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @iOSXCUITFindBy(accessibility = "Salvar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Salvar'`]")
    private MobileElement botaoSalvar;

    public EditarContatoTela(AppiumDriver driver) {
        super(driver);
    }

    /* === METODOS GET/SET ======================================================= */

    /**
     * Armazena valor informado no objeto thread-safe valorAgencia
     *
     * @param agencia
     */
    public static void setAgenciaContato(String agencia) {
        if (valorAgencia == null)
            valorAgencia = new ThreadLocal<>();
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
        if (valorConta == null)
            valorConta = new ThreadLocal<>();
        valorConta.set(conta);
    }

    /**
     * Armazena valor informado no objeto thread-safe valorCpf
     *
     * @param cpf
     */
    public static void setValorCpf(String cpf) {
        if (valorCpf == null)
            valorCpf = new ThreadLocal<>();
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

    /* === METODOS STEP´S ======================================================= */

    /**
     * Validar a tela 'Editar Contato'
     *
     * @return EditarContatoTela
     * @throws Exception
     */
    @Step("Validação da Tela Editar Contato")
    public EditarContatoTela validarTelaEditarContato() throws Exception {
        aguardarCarregamentoElemento(headerTituloEditarContato);
        Assert.assertTrue(verificarPresencaElemento(headerTituloEditarContato), "Não foi possivel validar a tela 'Editar Contato'");
        salvarEvidencia("Validou apresentação da tela 'Editar Contato'");
        return this;
    }

    /**
     * Tocar em '-Remover' na tela Editar Contato
     *
     * @return EditarContatoTela
     * @throws Exception
     */
    @Step("Tocar em -Remover (Conta)")
    public EditarContatoTela tocarRemoverConta() throws Exception {
        tocarElemento(removerConta, "Não foi possivel tocar no botão: \"-Remover\" (Conta)");
        salvarEvidencia("Tocou em \"-Remover\" (Conta)");
        return this;
    }

    /**
     * Tocar em '-Alterar' na tela Editar Contato
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar em +Adicionar (Conta)")
    public EditarContatoTela tocarAdicionarConta() throws Exception {
        tocarElemento(adicionarConta, "Não foi possivel tocar no botão: \"+Adicionar\" (Conta)");
        salvarEvidencia("Tocou em \"+Adicionar\" (Conta)");
        return this;
    }

    /**
     * Tocar botão salvar
     *
     * @return EditarContatoTela
     * @throws Exception
     */
    @Step("Salvar novo contato")
    public EditarContatoTela tocarSalvar() throws Exception {
        rolaTelaBaixo();
        salvarEvidencia("Salvar contato editado");
        tocarElemento(botaoSalvar, "Nao foi possivel tocar em Salvar");
        return this;
    }

    /**
     * Tocar caixa de seleção de instituição de pagamento
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar na caixa de selecao de instituicao de pagamento")
    public EditarContatoTela tocarSelecioneBanco() throws Exception {
        tocarElemento(caixaSelecaoInstituicao, "Nao foi possivel tocar na caixa de selecao de instituicao de pagamento");
        salvarEvidencia("Tocar caixa de seleção de instituição de pagamento");
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
    public EditarContatoTela preencherCampoAgencia(String agencia) throws Exception {
        setAgenciaContato(agencia);
        if (ios) {
            apagarCampoTexto(textoAgencia, agencia.length() * 2, "Nao foi possível apagar a Agência");
        } else {
            apagarCampoTexto(textoAgencia, "Nao foi possível apagar a Agência");
        }
        escreverTexto(textoAgencia, retornaAgenciaContato(), "Nao foi possível escrever agencia ");
        salvarEvidencia("Preencher campo agência com:" + retornaAgenciaContato());
        return this;
    }

    /**
     * Tocar radio-button "Instituição Pagamento"
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Instituição Pagamento\"")
    public EditarContatoTela tocarRadioButtonInstituicaoPagamento() throws Exception {
        aguardarCarregamentoElemento(radioInstituicaoPagamento);
        tocarElemento(radioInstituicaoPagamento, "Erro ao executar a ação de tocar radio-button");
        salvarEvidencia("Tocar radio-button \"Instituição Pagamento\"");
        return this;
    }

    /**
     * Preencher campo conta com valor informado em json
     *
     * @param conta
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Preenhcer campo conta")
    public EditarContatoTela preencherCampoConta(String conta) throws Exception {
        setContaContato(conta);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaDigito, "Erro ao rolar até o campo Conta e Dígito/Pagamento");
        if (ios) {
            apagarCampoTexto(textoContaDigito, conta.length() * 2, "Nao foi possível apagar a Conta e Digito/Pagamento");
        } else {
            apagarCampoTexto(textoContaDigito, "Nao foi possível apagar a Conta e Digito/Pagamento");
        }
        escreverTexto(textoContaDigito, retornaContaContato(), "Nao foi possível escrever a Conta e Dígito/Pagamento");
        esconderTeclado();
        salvarEvidencia("Preencher campo conta com:" + retornaContaContato());
        return this;
    }

    /**
     * Preencher campo Nome com valor aleatório
     *
     * @return
     * @throws Exception
     */
    @Step("Preenche campo Nome com valor aleatório")
    public EditarContatoTela informarNomeAleatorio() throws Exception {
        setNomeContato(geradorNomeCompleto(6, 6));
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(textoNome, "Erro ao rolar tela para baixo até encontrar o campo Nome");
        if (ios) {
            apagarCampoTexto(textoNome, retornaNomeContato().length() * 2, "Não foi possível apagar o campo Nome");
        } else {
            apagarCampoTexto(textoNome, "Não foi possível apagar o campo Nome");
        }
        escreverTexto(textoNome, retornaNomeContato(), "Nao foi possível escrever o nome :" + retornaNomeContato());
        if (ios) {
            tocarBotaoENTERTeclado(textoNome, "Erro ao tocar botão ENTER do teclado");
        }
        salvarEvidencia("Preenchido campo nome com: " + retornaNomeContato());
        return this;
    }

    /**
     * Preencher campo CPF com valor aleatório
     *
     * @return
     * @throws Exception
     */
    @Step("Preenche campo CPF com valor aleatório")
    public EditarContatoTela informarCpf() throws Exception {
        setValorCpf(gerarCpf());
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(textoCpf, "Erro ao rolar tela até o campo CPF");
        if (ios) {
            apagarCampoTexto(textoCpf, retornaCpf().length() * 2, "Não foi possível apagar o campo CPF");
        } else {
            apagarCampoTexto(textoCpf, "Não foi possível apagar o campo CPF");
        }
        escreverTexto(textoCpf, retornaCpf(), "Nao foi possível escrever o CPF: " + retornaCpf());
        salvarEvidencia("Preenchido campo CPF com: " + retornaCpf());
        return this;
    }

    /**
     * Preencher campo agência com valor aleatório
     *
     * @return
     * @throws Exception
     */
    @Step("Preenche campo agência com valor aleatório")
    public EditarContatoTela informarAgencia() throws Exception {
        setAgenciaContato(String.valueOf(numeroAleatorio(1111, 9999)));
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoAgencia, "Não foi possível encontrar o campo Agência");
        if (ios) {
            apagarCampoTexto(textoAgencia, retornaAgenciaContato().length() * 2, "Não foi possível apagar o campo Agência");
        } else {
            apagarCampoTexto(textoAgencia, "Não foi possível apagar o campo Agência");
        }
        escreverTexto(textoAgencia, retornaAgenciaContato(), "Nao foi possível escrever a Agência: " + retornaAgenciaContato());
        salvarEvidencia("Preenchido campo Agência com: " + retornaAgenciaContato());
        return this;
    }

    /**
     * Preencher campo conta com valor aleatório
     *
     * @return
     * @throws Exception
     */
    @Step("Preenche campo agência com valor aleatório")
    public EditarContatoTela informarConta() throws Exception {
        setContaContato(String.valueOf(numeroAleatorio(111111, 999999)));
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaDigito, "Não foi possível rolar até o campo da conta");
        if (ios) {
            apagarCampoTexto(textoContaDigito, retornaContaContato().length() * 2, "Não foi possível apagar o campo Conta");
        } else {
            apagarCampoTexto(textoContaDigito, "Não foi possível apagar o campo Conta");
        }
        escreverTexto(textoContaDigito, retornaContaContato(), "Nao foi possível escrever a conta: " + retornaContaContato());
        esconderTeclado();
        salvarEvidencia("Preenchido campo conta com: " + retornaContaContato());
        return this;
    }

}
