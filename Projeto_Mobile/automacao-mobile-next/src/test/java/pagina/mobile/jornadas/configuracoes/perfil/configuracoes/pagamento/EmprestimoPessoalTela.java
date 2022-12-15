package pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EmprestimoPessoalTela extends PaginaBase {

    //private static ThreadLocal<TipoDeInstituicaoFinanceira> checkDedito = null;
    private static ThreadLocal<String> situacaoCheckDebitoHabilitado = null;

    //checkbox repetir tentativas debito automatico
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ncbl_option1")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Repetir tentativas de d�bito\") and @accessible=\"true\"]")
    private MobileElement checkRepetirTentativasDebitoAutomatico;


    //botao Salvar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_save")
    @iOSXCUITFindBy(accessibility = "SALVAR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SALVAR\"`]")
    private MobileElement botaoSalvar;

    //radio button Por debito
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/radio2")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Por d�bito autom�tico\")]")
    private MobileElement radioPorDebitoAutomatico;

    //radio button Por boleto
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/radio1")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_radio")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Por boleto\")]")
    private MobileElement radioPorBoleto;

    //botao voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    //texto confirura��o de pagamento atualizado.
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@value, \"Configura��es de pagamento atualizadas!\")]")
    private MobileElement textoConfiguracaoPagamentoAtualizado;

    //botao ok
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private MobileElement botaoOk;

    // check Usar Grana De Emergencia
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id=\"br.com.bradesco.next:id/ncbl_option2\"]//android.widget.CheckBox")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Usar grana de\") and @accessible=\"true\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Usar grana de emerg�ncia para pagamento de empr�stimo. Selecionado\"`]")
    private MobileElement checkUsarGranaDeEmergencia;

    public EmprestimoPessoalTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar checkbox repetir tentativas debito automatico
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar \"checkbox repetir tentativas debito automatico\"")
    public EmprestimoPessoalTela tocarCheckRepetirTentativasDebitoAutomatico() throws Exception {
        salvarEvidencia("Tocar no checkbox repetir tentativas debito automatico");
        validaCheckSelecionado(checkRepetirTentativasDebitoAutomatico);
        tocarElemento(checkRepetirTentativasDebitoAutomatico, "N�o foi poss�vel Tocar no checkbox repetir tentativas debito automatico");
        salvarEvidencia("Checkbox 'repetir tentativas debito automatico' desmarcado.");
        return this;
    }

    /**
     * Tocar checkbox repetir tentativas debito automatico sem estar selecionado, desmarcado.
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar \"checkbox repetir tentativas debito automatico sem selecao\"")
    public EmprestimoPessoalTela tocarCheckRepetirTentativasDebitoAutomaticoSemSelecao() throws Exception {
        salvarEvidencia("Tocar no checkbox repetir tentativas debito automatico");
        validaCheckNaoSelecionado(checkRepetirTentativasDebitoAutomatico);
        tocarElemento(checkRepetirTentativasDebitoAutomatico, "N�o foi poss�vel Tocar no checkbox repetir tentativas debito automatico");
        salvarEvidencia("Checkbox 'repetir tentativas debito automatico' marcado.");
        return this;
    }

    /**
     * Tocar checkbox Usar Grana Emergencia
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar \"checkbox Usar Grana Emergencia\"")
    public EmprestimoPessoalTela tocarCheckUsarGranaEmergencia() throws Exception {
        salvarEvidencia("Tocar no checkbox Usar Grana Emergencia");
        validaCheckNaoSelecionado(checkUsarGranaDeEmergencia);
        tocarElemento(checkUsarGranaDeEmergencia, "N�o foi poss�vel Tocar no checkbox Usar Grana Emergencia");
        salvarEvidencia("Checkbox 'Usar Grana Emergencia' selecionado.");
        return this;
    }

    /**
     * Metodo para verificar se checkbox esta selecionado
     *
     * fr
     * @throws Exception
     */
    private void validaCheckSelecionado(MobileElement element) throws Exception{
        if(android) validarAtributoBooleano(element, "checked", "true","Valor esperado para a situa��o do Checkbox repetir tentativas � habilitado era: true\nValor obtido foi: false");
        else validarCondicaoBooleana(element.getAttribute("value").contains("Selecionado"),MetodoComparacaoBooleano.VERDADEIRO,"N�o foi possivel validar que check esta selecionado.");
    }

    /**
     * Metodo para verificar se checkbox n�o esta selecionado
     *
     * fr
     * @throws Exception
     */
    private void validaCheckNaoSelecionado(MobileElement element) throws Exception{
        if(android) validarAtributoBooleano(element, "checked", "false","Valor esperado para a situa��o do Checkbox repetir tentativas � desabilitado era: false\nValor obtido foi: true");
        else validarCondicaoBooleana(element.getAttribute("value").contains("Selecionar"), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi possivel validar que check esta deselecionado.");
    }

    /**
     * Tocar bot�o Salvar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Salvar\"")
    public EmprestimoPessoalTela tocarBotaoSalvar() throws Exception {
        salvarEvidencia("Tocar no no botao Salvar");
        tocarElemento(botaoSalvar, "N�o foi poss�vel Tocar no botao Salvar");
        return this;
    }

    /**
     * Tocar bot�o Voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public EmprestimoPessoalTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botao Voltar");
        tocarElemento(botaoVoltar, "N�o foi poss�vel Tocar no botao Voltar");
        return this;
    }

    /**
     * Validar que esta na tela de Emprestimo Pessoal
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Emprestimo Pessoal\"")
    public EmprestimoPessoalTela validarTelaEmprestimoPessoal() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EMPR�STIMO_PESSOAL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Emprestimo Pessoal' n�o est� presente na tela!");
        salvarEvidencia("validar que esta na tela de 'Emprestimo Pessoal'");
        return this;
    }

    /**
     * Validar texto Configura��es de pagamento atualizadas!
     * @param textoEsperado
     * @return
     * @throws Exception
     */
    @Step("Validar Mensagem Configura��es de pagamento atualizadas!")
    public EmprestimoPessoalTela validarMensagemAlteracao(String textoEsperado) throws Exception {
        aguardarCarregamentoElemento(textoConfiguracaoPagamentoAtualizado);
        salvarEvidencia("Validar exibi��o do modal com o texto: " + textoEsperado.toString());
        compararElementoTexto(textoConfiguracaoPagamentoAtualizado, textoEsperado, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Tocar bot�o OK
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK\"")
    public EmprestimoPessoalTela tocarBotaoOK() throws Exception {
        salvarEvidencia("Tocar no no botao Ok");
        tocarElemento(botaoOk, "N�o foi poss�vel Tocar no botao OK");
        return this;
    }

    /**
     * selecionar forma de pagamento Por boleto
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar  \"RadioButton Por Boleto\"")
    public EmprestimoPessoalTela selecionarFormaPagamentoPorBoleto() throws Exception {
        salvarEvidencia("Tocar no radio: Por Boleto");
        tocarElemento(radioPorBoleto, "N�o foi poss�vel Tocar no radio 'Por boleto'");
        return this;
    }

    /**
     * selecionar forma de pagamento Debito Automatico.
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar  \"RadioButton Por Boleto\"")
    public EmprestimoPessoalTela selecionarFormaPagamentoDebitoAuto() throws Exception {
        salvarEvidencia("Tocar no radio: Por Boleto");
        tocarElemento(radioPorBoleto, "N�o foi poss�vel Tocar no radio 'Por boleto'");
        return this;
    }
}
