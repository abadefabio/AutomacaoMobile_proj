package pagina.mobile.jornadas.transferencia.para.mim;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.transferencia.TipoDeInstituicaoFinanceira;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

public class NovaContaTela extends PaginaBase {

    private static ThreadLocal<TipoDeInstituicaoFinanceira> tipoInstituicao = null;
    private static ThreadLocal<String> situacaoSwitchTEDHabilitado = null;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "NOVA CONTA")
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"NOVA CONTA\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"NOVA CONTA\"`]")
    public MobileElement headerTituloNovaConta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Fechar, Bot�o")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Fechar, Bot�o\"]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    public MobileElement headerBotaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_logo_account")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"NOVA CONTA\"]/..//XCUIElementTypeOther/XCUIElementTypeImage")
    public MobileElement iconeTelaNovaConta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_bank")
    @AndroidFindBy(xpath = "//android.widget.RadioGroup[@content-desc=\"Tipo de Conta\"]/android.widget.RadioButton[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains \"Banco\"")
    private MobileElement seletorBanco;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_institutional")
    @AndroidFindBy(xpath = "//android.widget.RadioGroup[@content-desc=\"Tipo de Conta\"]/android.widget.RadioButton[2]")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains \"Institui��o de pagamento\"")
    private MobileElement seletorInstituicaoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/picker_button_bank")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_bank_or_instituional")
    @iOSXCUITFindBy(accessibility = "Selecionar banco")
    private MobileElement caixaSelecaoInstituicao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/../../../XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private MobileElement textoCaixaSelecaoInstituicao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    //@AndroidFindBy(accessibility = "Ag�ncia")
    //@AndroidFindBy(id = "br.com.bradesco.next:id/et_agency")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_agencie")
    //@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Ag�ncia\"]")
    @iOSXCUITFindBy(accessibility = "Ag�ncia sem d�gito")
    @iOSXCUITFindBy(accessibility = "Ag�ncia (opcional)")
    private MobileElement textoAgencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Conta e d�gito")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_account")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_account")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Conta e d�gito\"]")
    @iOSXCUITFindBy(accessibility = "Conta e d�gito sem h�fen")
    @iOSXCUITFindBy(accessibility = "Conta (opcional)")
    private MobileElement textoContaDigito;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_payment_account")
    @iOSXCUITFindBy(accessibility = "Conta Pagamento")
    private MobileElement textoContaPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_save")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SALVAR\"`][1]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoSalvar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/next_switch")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"TED\")]/ancestor::XCUIElementTypeCell")
    private MobileElement switchAutorizarTED;

    public NovaContaTela(AppiumDriver driver) {
        super(driver);
    }

    public static void setTipoInstituicao(TipoDeInstituicaoFinanceira tipo){
        if(tipoInstituicao == null){
            tipoInstituicao = new ThreadLocal<>();
        }
        tipoInstituicao.set(tipo);
    }

    public static TipoDeInstituicaoFinanceira retornaTipoInstituicao(){
        return tipoInstituicao.get();
    }

    public static void setSituacaoSwitchTEDHabilitado(boolean situacaoSwitchTEDHabilitado){
        if(NovaContaTela.situacaoSwitchTEDHabilitado == null){
            NovaContaTela.situacaoSwitchTEDHabilitado = new ThreadLocal<>();
        }
        NovaContaTela.situacaoSwitchTEDHabilitado.set(String.valueOf(situacaoSwitchTEDHabilitado));
    }

    public static boolean retornarSituacaoSwitchTEDHabilitado(){
        return Boolean.parseBoolean(situacaoSwitchTEDHabilitado.get());
    }

    /**
     *Selecionar radio-button "Institui��o de Pagamento"
     *
     * @return NovaContaTela
     * @throws Exception
     */
    @Step("Selecionar radio-button \"Institui��o de Pagamento\"")
    public NovaContaTela selecionarRadioInstituicaoDePagamento() throws Exception{
        String hash = recuperarHashElemento(seletorInstituicaoPagamento);
        aguardarCarregamentoElemento(seletorInstituicaoPagamento);
        tocarElemento(seletorInstituicaoPagamento, "Erro ao selecionar radio-button \"Institui��o de Pagamento\"");
        validarCondicaoBooleana(hash.equals(recuperarHashElemento(seletorInstituicaoPagamento)),MetodoComparacaoBooleano.FALSO,"Erro ao validar a sele��o do Radio: Intitui��o de Pagamento");
        salvarEvidencia("Selecionar radio-button \"Institui��o de Pagamento\"");
        return this;
    }

    /**
     * Tocar caixa de sele��o de institui��o de pagamento
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Tocar na caixa de selecao de instituicao de pagamento")
    public NovaContaTela tocarCaixaSelecaoInstituicao() throws Exception{
        aguardarCarregamentoElemento(caixaSelecaoInstituicao);
        tocarElemento(caixaSelecaoInstituicao , "Nao foi possivel tocar na caixa de selecao de instituicao de pagamento" );
        salvarEvidencia("Tocar caixa de sele��o de institui��o de pagamento");
        return this;
    }

    /**
     * Preencher campo ag�ncia com n�mero aleat�rio
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("informar agencia")
    public NovaContaTela informarAgencia() throws Exception{
        return this.preencherCampoAgencia(String.valueOf( numeroAleatorio(111111, 999999) ));
    }

    /**
     * Preencher campo ag�ncia com valor informado em String
     *
     * @param agencia
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("preencher campo Ag�ncicia")
    public NovaContaTela preencherCampoAgencia(String agencia) throws Exception{
        OperadorEvidencia.logarPasso("Preencher campo ag�ncia com : " + agencia);
        digitarTexto(textoAgencia, agencia);
        salvarEvidencia("Preencher campo ag�ncia com:" + agencia);
        if(ios){
            MinhasContasTela.setAgencia("Ag." + agencia);
        }else{
            MinhasContasTela.setAgencia("AG " + agencia);
        }
        return this;
    }

    /**
     * Preencher campo conta com n�mero aleat�rio
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Informar conta")
    public NovaContaTela informarConta() throws Exception{
        return this.preencherCampoConta( String.valueOf(numeroAleatorio(111111, 999999)));
    }

    /**
     * Preencher campo conta com valor informado em String
     *
     * @param conta
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Preenhcer campo conta")
    public NovaContaTela preencherCampoConta(String conta) throws Exception{
        OperadorEvidencia.logarPasso("Preencher campo conta com valor: " + conta);
        digitarTexto(textoContaDigito, conta);
        if(ios){
            MinhasContasTela.setConta( "CC." + conta);
        }else{
            MinhasContasTela.setConta( "CC " + conta);
        }
        esconderTeclado();
        salvarEvidencia("Preencher Informa��es Conta: " + MinhasContasTela.retornaInstituicao() + " " + MinhasContasTela.retornaAgencia() + " " + MinhasContasTela.retornaConta());
        return this;
    }

    /**
     * Tocar bot�o salvar
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Salvar novo contato")
    public NovaContaTela tocarBotaoSalvar() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSalvar, "Erro ao executar a a��o de rolar tela at� bot�o \"Salvar\" ");
        salvarEvidencia( "Visualizar bot�o \"Salvar\"" );
        tocarElemento( botaoSalvar, "Nao foi possivel tocar em Salvar" );
        salvarEvidencia( "Salvar dados contato" );
        return this;
    }

    /**
     * Preencher campo conta com n�mero aleat�rio
     *
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Preencher campo conta com n�mero aleat�rio")
    public NovaContaTela informarContaPagamento() throws Exception{
        return this.preencherContaPagamento(String.valueOf(numeroAleatorio(111111, 999999)));
    }

    /**
     * Preencher campo conta pagamento
     *
     * @param contaPagamento
     * @return NovoContatoTela
     * @throws Exception
     */
    @Step("Preencher campo Conta Pagamento")
    public NovaContaTela preencherContaPagamento(String contaPagamento) throws Exception{
        OperadorEvidencia.logarPasso("Preencher campo conta com valor: " + contaPagamento);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(textoContaPagamento,"N�o foi possivel encontrar o campo 'conta'");
        escreverTexto( textoContaPagamento, contaPagamento,"Nao foi poss�vel escrever a conta" );
        String conta = contaPagamento;
        if(contaPagamento.length() > 5) { // Tratamento para truncar o numero da conta que for superior a 5 casas decimais.
            conta = contaPagamento.substring(Math.abs(contaPagamento.length() - 5));
        }
        if(ios){
            MinhasContasTela.setAgencia("C Pagto");
            MinhasContasTela.setConta( "Final " + conta);
        }else{
            MinhasContasTela.setConta("C Pagto");
            MinhasContasTela.setAgencia("Final " + conta);

        }
        esconderTeclado();
        salvarEvidencia("Preencher Informa��es Conta: " + MinhasContasTela.retornaInstituicao() + " Conta: " + contaPagamento);
        return this;
    }

    /**
     * Selecionar tipo de institui��o da conta deletada/Editada
     *
     * @return NovaContaTela
     * @throws Exception
     */
    @Step("Selecionar tipo de institui��o da conta deletada/Editada")
    public NovaContaTela selecionarTipoDeInstituicaoConta() throws Exception{
        if(android && MinhasContasTela.retornaAgenciaInicial().contains("C Pagto")){
            this.selecionarRadioInstituicaoDePagamento();
            setTipoInstituicao(TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO);
        }else if(ios && MinhasContasTela.retornaContaInicial().contains("C Pagto")){
            this.selecionarRadioInstituicaoDePagamento();
            setTipoInstituicao(TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO);
        }else{
            setTipoInstituicao(TipoDeInstituicaoFinanceira.BANCO);
        }
        return this;
    }

    /**
     * Recadastrar ag�ncia de conta deletada/Editada
     *
     * @return NovaContaTela
     * @throws Exception
     */
    @Step("Recadastrar ag�ncia de conta deletada/Editada")
    public NovaContaTela recadastrarAgencia() throws Exception{
        switch (retornaTipoInstituicao()){
            case BANCO:
                if(android){
                    aguardarCarregamentoElemento(textoAgencia);
                    apagarCampoTexto(textoAgencia,"Erro ao apagar campo texto Ag�ncia");
                    return this.preencherCampoAgencia(MinhasContasTela.retornaAgenciaInicial().substring(MinhasContasTela.retornaAgenciaInicial().indexOf(" ") + 1));
                }else{
                    aguardarCarregamentoElemento(textoAgencia);
                    apagarCampoTexto(textoAgencia,MinhasContasTela.retornaAgencia().length(),"Erro ao apagar campo texto Ag�ncia");
                    return this.preencherCampoAgencia(MinhasContasTela.retornaAgenciaInicial().substring(MinhasContasTela.retornaAgenciaInicial().indexOf(".") + 1));
                }
            case INSTITUICAO_DE_PAGAMENTO:
                break;
        }
        return this;
    }

    /**
     * Recadastrar Conta deletada/Editada
     *
     * @return NovaContaTela
     * @throws Exception
     */
    @Step("Recadastrar Conta deletada/Editada")
    public NovaContaTela recadastrarConta() throws Exception{
        switch (retornaTipoInstituicao()){
            case BANCO:
                if(android){
                    aguardarCarregamentoElemento(textoContaDigito);
                    apagarCampoTexto(textoContaDigito,"Erro ao apagar campo texto Conta");
                    return this.preencherCampoConta(MinhasContasTela.retornaContaInicial().substring(MinhasContasTela.retornaContaInicial().indexOf(" ") + 1));
                }else{
                    aguardarCarregamentoElemento(textoContaDigito);
                    apagarCampoTexto(textoContaDigito,MinhasContasTela.retornaConta().length(),"Erro ao apagar campo texto Conta");
                    return this.preencherCampoConta(MinhasContasTela.retornaContaInicial().substring(MinhasContasTela.retornaContaInicial().indexOf(".") + 1));
                }
            case INSTITUICAO_DE_PAGAMENTO:
                if(android){
                    aguardarCarregamentoElemento(textoContaPagamento);
                    apagarCampoTexto(textoContaPagamento,"Erro ao apagar campo texto Conta");
                    return this.preencherContaPagamento("0" + MinhasContasTela.retornaAgenciaInicial().substring(MinhasContasTela.retornaAgenciaInicial().indexOf(" ") + 1));
                }else{
                    aguardarCarregamentoElemento(textoContaPagamento);
                    apagarCampoTexto(textoContaPagamento,"Erro ao apagar campo texto Conta");
                    return this.preencherContaPagamento("0" + MinhasContasTela.retornaContaInicial().substring(MinhasContasTela.retornaContaInicial().indexOf(" ") + 1));
                }
        }
        return this;
    }

    /**
     * Tocar switch "Autorizar TED"
     * @return NovaContaTela
     * @throws Exception
     */
    @Step("Tocar switch \"Autorizar TED\"")
    public NovaContaTela tocarSwitchTED() throws Exception{
        aguardarCarregamentoElemento(switchAutorizarTED);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(switchAutorizarTED,"Erro ao rolar tela ate o objeto Switch TED");
        if(android){
            setSituacaoSwitchTEDHabilitado(switchAutorizarTED.isEnabled());
            tocarElemento(switchAutorizarTED, "Erro ao tocar switch \"Autorizar TED\"");
        }else{
            tocarCoordenadaProporcional(switchAutorizarTED, 90,50);
        }
        salvarEvidencia("Tocar switch 'Autorizar TED'");
        return this;
    }

    /**
     *
     * @param instituicao - Enum ou String com o nome da institui��o de pagemento a ser verificada
     * @return objeto NovaContaTela
     * @throws Exception
     */
    public NovaContaTela validarInstituicaoPagamentoSelecionado(Enum instituicao) throws Exception{
        aguardarCarregamentoElemento(textoCaixaSelecaoInstituicao);
        compararElementoTexto(textoCaixaSelecaoInstituicao, instituicao, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar institui��o de pagemento selecionado(a): \"" + instituicao + "\"");
        return this;
    }

    /**
     * Validar condi��o esperada para altera��o do switch de acordo com o resultado esperado na condi��o do teste
     *
     * @param validarAlteracaoSwitch - Resultado booleano esperado para a altera��o do switch condi��o de teste
     * @return NovaContaTela
     * @throws Exception
     */
    public NovaContaTela validarAlteracaoSwitchTED(boolean validarAlteracaoSwitch) throws Exception{
        //Ainda n�o � poss�vel aplicar m�todo de valida��o para iOS, pois ainda n�o � poss�vel mapear o elemento espec�fico do switch
        if(android){
            if(validarAlteracaoSwitch){
                validarCondicaoBooleana(retornarSituacaoSwitchTEDHabilitado() == switchAutorizarTED.isEnabled(), MetodoComparacaoBooleano.FALSO,
                        "Valor esperado para a situa��o do switch habilitado era: " + !retornarSituacaoSwitchTEDHabilitado() + "\nValor obtido foi: " + switchAutorizarTED.isEnabled());
            }else{
                validarCondicaoBooleana(retornarSituacaoSwitchTEDHabilitado() == switchAutorizarTED.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,
                        "Valor esperado para a situa��o do switch habilitado era: " + retornarSituacaoSwitchTEDHabilitado() + "\nValor obtido foi: " + switchAutorizarTED.isEnabled());
            }
        }
        salvarEvidencia("Visualizar situa��o do switch \"Autorizar Pagamento TED\"");
        return this;
    }

    /**
     * Validar condi��o esperada do switch de acordo com o resultado esperado na condi��o do teste
     *
     * @return objeto NovaContaTela
     * @throws Exception
     */
    public NovaContaTela validarTedObrigatorio() throws Exception {
        //Solu��o temporaria de valida��o, pois no iOS n�o � poss�vel mapear o switch 'Autorizar TED'.
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(switchAutorizarTED, "N�o foi poss�vel rolar at� o elemento 'Autorizado TED'");
        String hashEstadoInicial = recuperarHashElemento(switchAutorizarTED);
        tocarSwitchTED();
        String hashEstadoFinal = recuperarHashElemento(switchAutorizarTED);
        if (android){
            validarAtributoBooleano(switchAutorizarTED, "enabled", "true","Valor esperado para a situa��o do switch habilitado era: true\nValor obtido foi: false");
        } else {
            validarCondicaoBooleana(hashEstadoInicial.equals(hashEstadoFinal), MetodoComparacaoBooleano.VERDADEIRO, "Foi poss�vel alterar o estado do switch 'Autorizado TED' no iOS.");
        }
        salvarEvidencia("Validado switch TED permanesse ativo ap�s tocar no mesmo");
        return  this;
    }

    /**
     * Validar condi��o esperada do switch de acordo com o resultado esperado na condi��o do teste
     *
     * @return objeto NovaContaTela
     * @throws Exception
     */
    public NovaContaTela validarAutorizadoTED() throws Exception{
        aguardarCarregamentoElemento(switchAutorizarTED);
        if(android){
            validarAtributoBooleano(switchAutorizarTED, "enabled", "true",
                        "Valor esperado para a situa��o do switch habilitado era: true\nValor obtido foi: false");
        }
        else {
            validarCondicaoBooleana("90F167E78933B7C84AB98D6CE35E6F9C".equals(recuperarHashElemento(switchAutorizarTED)),
                    MetodoComparacaoBooleano.VERDADEIRO,"Valor esperado para a situa��o do switch habilitado era: true\nValor obtido foi: false");
        }
        salvarEvidencia("Visualizar situa��o do switch \"Autorizar Pagamento TED\"");
        return this;
    }
}
