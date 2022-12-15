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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Op��o selecion�vel, Banco, ' AND visible == 1`]")
    private MobileElement radioBanco;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_institutional")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Op��o selecion�vel, Institui��o de pagamento, ' AND visible == 1`]")
    private MobileElement radioInstituicaoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Banco ou Institui��o\"]/android.widget.RelativeLayout")
    @AndroidFindBy(xpath = "//*[id = 'br.com.bradesco.next:id/ll_container'][1]")
    @iOSXCUITFindBy(accessibility = "Selecionar banco")
    private MobileElement caixaSelecaoInstituicao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_agency")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/et_agency']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Ag�ncia\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Ag�ncia sem d�gito' AND visible == 1`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Ag�ncia (opcional)' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Ag�ncia sem d�gito")
    @iOSXCUITFindBy(accessibility = "Ag�ncia (opcional)")
    private MobileElement textoAgencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_account") // Conta e Digito
    @AndroidFindBy(accessibility = "Conta de Pagamento") // Conta Pagamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_payment_account")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Conta de Pagamento\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Conta e d�gito sem h�fen' AND visible == 1`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'Conta Pagamento' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Conta e d�gito sem h�fen")
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
     * retorna string com o valor de ag�ncia armazenado no objeto thread-safe valorAgencia
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

    /* === METODOS STEP�S ======================================================= */

    /**
     * Validar a tela 'Editar Contato'
     *
     * @return EditarContatoTela
     * @throws Exception
     */
    @Step("Valida��o da Tela Editar Contato")
    public EditarContatoTela validarTelaEditarContato() throws Exception {
        aguardarCarregamentoElemento(headerTituloEditarContato);
        Assert.assertTrue(verificarPresencaElemento(headerTituloEditarContato), "N�o foi possivel validar a tela 'Editar Contato'");
        salvarEvidencia("Validou apresenta��o da tela 'Editar Contato'");
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
        tocarElemento(removerConta, "N�o foi possivel tocar no bot�o: \"-Remover\" (Conta)");
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
        tocarElemento(adicionarConta, "N�o foi possivel tocar no bot�o: \"+Adicionar\" (Conta)");
        salvarEvidencia("Tocou em \"+Adicionar\" (Conta)");
        return this;
    }

    /**
     * Tocar bot�o salvar
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
     * Tocar caixa de sele��o de institui��o de pagamento
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar na caixa de selecao de instituicao de pagamento")
    public EditarContatoTela tocarSelecioneBanco() throws Exception {
        tocarElemento(caixaSelecaoInstituicao, "Nao foi possivel tocar na caixa de selecao de instituicao de pagamento");
        salvarEvidencia("Tocar caixa de sele��o de institui��o de pagamento");
        return this;
    }

    /**
     * Preencher campo ag�ncia com valor informado em json
     *
     * @param agencia
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("preencher campo Ag�ncia")
    public EditarContatoTela preencherCampoAgencia(String agencia) throws Exception {
        setAgenciaContato(agencia);
        if (ios) {
            apagarCampoTexto(textoAgencia, agencia.length() * 2, "Nao foi poss�vel apagar a Ag�ncia");
        } else {
            apagarCampoTexto(textoAgencia, "Nao foi poss�vel apagar a Ag�ncia");
        }
        escreverTexto(textoAgencia, retornaAgenciaContato(), "Nao foi poss�vel escrever agencia ");
        salvarEvidencia("Preencher campo ag�ncia com:" + retornaAgenciaContato());
        return this;
    }

    /**
     * Tocar radio-button "Institui��o Pagamento"
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Institui��o Pagamento\"")
    public EditarContatoTela tocarRadioButtonInstituicaoPagamento() throws Exception {
        aguardarCarregamentoElemento(radioInstituicaoPagamento);
        tocarElemento(radioInstituicaoPagamento, "Erro ao executar a a��o de tocar radio-button");
        salvarEvidencia("Tocar radio-button \"Institui��o Pagamento\"");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaDigito, "Erro ao rolar at� o campo Conta e D�gito/Pagamento");
        if (ios) {
            apagarCampoTexto(textoContaDigito, conta.length() * 2, "Nao foi poss�vel apagar a Conta e Digito/Pagamento");
        } else {
            apagarCampoTexto(textoContaDigito, "Nao foi poss�vel apagar a Conta e Digito/Pagamento");
        }
        escreverTexto(textoContaDigito, retornaContaContato(), "Nao foi poss�vel escrever a Conta e D�gito/Pagamento");
        esconderTeclado();
        salvarEvidencia("Preencher campo conta com:" + retornaContaContato());
        return this;
    }

    /**
     * Preencher campo Nome com valor aleat�rio
     *
     * @return
     * @throws Exception
     */
    @Step("Preenche campo Nome com valor aleat�rio")
    public EditarContatoTela informarNomeAleatorio() throws Exception {
        setNomeContato(geradorNomeCompleto(6, 6));
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(textoNome, "Erro ao rolar tela para baixo at� encontrar o campo Nome");
        if (ios) {
            apagarCampoTexto(textoNome, retornaNomeContato().length() * 2, "N�o foi poss�vel apagar o campo Nome");
        } else {
            apagarCampoTexto(textoNome, "N�o foi poss�vel apagar o campo Nome");
        }
        escreverTexto(textoNome, retornaNomeContato(), "Nao foi poss�vel escrever o nome :" + retornaNomeContato());
        if (ios) {
            tocarBotaoENTERTeclado(textoNome, "Erro ao tocar bot�o ENTER do teclado");
        }
        salvarEvidencia("Preenchido campo nome com: " + retornaNomeContato());
        return this;
    }

    /**
     * Preencher campo CPF com valor aleat�rio
     *
     * @return
     * @throws Exception
     */
    @Step("Preenche campo CPF com valor aleat�rio")
    public EditarContatoTela informarCpf() throws Exception {
        setValorCpf(gerarCpf());
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(textoCpf, "Erro ao rolar tela at� o campo CPF");
        if (ios) {
            apagarCampoTexto(textoCpf, retornaCpf().length() * 2, "N�o foi poss�vel apagar o campo CPF");
        } else {
            apagarCampoTexto(textoCpf, "N�o foi poss�vel apagar o campo CPF");
        }
        escreverTexto(textoCpf, retornaCpf(), "Nao foi poss�vel escrever o CPF: " + retornaCpf());
        salvarEvidencia("Preenchido campo CPF com: " + retornaCpf());
        return this;
    }

    /**
     * Preencher campo ag�ncia com valor aleat�rio
     *
     * @return
     * @throws Exception
     */
    @Step("Preenche campo ag�ncia com valor aleat�rio")
    public EditarContatoTela informarAgencia() throws Exception {
        setAgenciaContato(String.valueOf(numeroAleatorio(1111, 9999)));
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoAgencia, "N�o foi poss�vel encontrar o campo Ag�ncia");
        if (ios) {
            apagarCampoTexto(textoAgencia, retornaAgenciaContato().length() * 2, "N�o foi poss�vel apagar o campo Ag�ncia");
        } else {
            apagarCampoTexto(textoAgencia, "N�o foi poss�vel apagar o campo Ag�ncia");
        }
        escreverTexto(textoAgencia, retornaAgenciaContato(), "Nao foi poss�vel escrever a Ag�ncia: " + retornaAgenciaContato());
        salvarEvidencia("Preenchido campo Ag�ncia com: " + retornaAgenciaContato());
        return this;
    }

    /**
     * Preencher campo conta com valor aleat�rio
     *
     * @return
     * @throws Exception
     */
    @Step("Preenche campo ag�ncia com valor aleat�rio")
    public EditarContatoTela informarConta() throws Exception {
        setContaContato(String.valueOf(numeroAleatorio(111111, 999999)));
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaDigito, "N�o foi poss�vel rolar at� o campo da conta");
        if (ios) {
            apagarCampoTexto(textoContaDigito, retornaContaContato().length() * 2, "N�o foi poss�vel apagar o campo Conta");
        } else {
            apagarCampoTexto(textoContaDigito, "N�o foi poss�vel apagar o campo Conta");
        }
        escreverTexto(textoContaDigito, retornaContaContato(), "Nao foi poss�vel escrever a conta: " + retornaContaContato());
        esconderTeclado();
        salvarEvidencia("Preenchido campo conta com: " + retornaContaContato());
        return this;
    }

}
