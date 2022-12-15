package pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.configuracoes.perfil.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutosCreditoTela extends PaginaBase{

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nrb_boleto")
    @iOSXCUITFindBy(accessibility = "Por Boleto")
    private MobileElement opcaoPorBoleto;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nrb_debito")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Por d�bito autom�tico' AND value == 'N�o Selecionado'")
    private MobileElement opcaoPorDebitoAutomatico;

    @AndroidFindBy(xpath = "//*[@resource-id=\"br.com.bradesco.next:id/nl_label_text\" and @text=\"Repetir tentativas de d�bito autom�tico\"]")
    @iOSXCUITFindBy(accessibility = "Repetir tentativas de d�bito autom�tico")
    private MobileElement opcaoRepetirTentativas;

    @AndroidFindBy(xpath = "//*[@resource-id=\"br.com.bradesco.next:id/nl_label_text\" and @text=\"Usar grana de emerg�ncia para pagamento de fatura\"]")
    @iOSXCUITFindBy(accessibility = "Usar grana de emerg�ncia para pagamento de fatura")
    private MobileElement opcaoUsarGranaDeEmergencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_save")
    @iOSXCUITFindBy(accessibility = "SALVAR")
    private MobileElement botaoSalvar;

    @AndroidFindBy(id="br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_title")
    @iOSXCUITFindBy(id = "Forma de pagamento atualizada!")
    private MobileElement formaDePagamentoAtualizada;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOk;

    @AndroidFindBy(xpath = "//*[@text='Por boleto']/preceding::android.widget.RadioButton[@selected='true']")
    @iOSXCUITFindBy(xpath = "//*[@value='Selecionado' and @name='Por Boleto']")
    private MobileElement checkboxTipoPagamento;

    public ProdutosCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o Voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public ProdutosCreditoTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar,"N�o foi poss�vel tocar bot�o voltar");
        return this;
    }

    /**
     * Tocar op��o Por Boleto
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar op��o \"Por Boleto\"")
    public ProdutosCreditoTela tocarOpcaoBoleto() throws Exception{
        salvarEvidencia("Tocar na op��o 'Por Boleto'");
        tocarElemento(opcaoPorBoleto,"N�o foi poss�vel tocar op��o 'Por Boleto'");
        return this;
    }

    /**
     * Tocar op��o Por d�bito autom�tico
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar op��o \"Por debito automatico\"")
    public ProdutosCreditoTela tocarOpcaoPorDebitoAutomatico() throws Exception{
        aguardarElementoHabilitado(opcaoPorDebitoAutomatico);
        salvarEvidencia("Tocar na op��o 'Por debito automatico'");
        tocarElemento(opcaoPorDebitoAutomatico,"N�o foi poss�vel tocar op��o 'Por debito automatico'");
        return this;
    }

    /**
     * Tocar opcao Repetir tentativas
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar op��o \"Repetir tentativas\"")
    public ProdutosCreditoTela tocarOpcaoRepetirTentativas()throws Exception{
        salvarEvidencia("Tocar na op��o 'Repetir tentativas'");
        tocarElemento(opcaoRepetirTentativas,"N�o foi poss�vel tocar op��o 'Repetir tentativas'");
        return this;
    }

    /**
     * Tocar opcao Usar grana de emerg�ncia
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar op��o \"Usar grana de emerg�ncia\"")
    public ProdutosCreditoTela tocarOpcaoUsarGranaEmergencia() throws Exception{
        salvarEvidencia("Tocar op��o 'Usar grana de emerg�ncia'");
        tocarElemento(opcaoUsarGranaDeEmergencia,"N�o foi poss�vel tocar op��o 'Usar grana de emerg�ncia'");
        return this;
    }

    /**
     * Tocar bot�o Salvar
     *
     * @return ProdutosCreditoTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Salvar\"")
    public ProdutosCreditoTela tocarBotaoSalvar() throws Exception{
        salvarEvidencia("Tocar bot�o 'Salvar'");
        aguardarElementoHabilitado(botaoSalvar);
        tocarElemento(botaoSalvar,"N�o foi poss�vel tocar no bot�o 'Salvar'");
        return this;
    }

    /**
     * Tocar bot�o Fechar
     *
     * @return ProdutosCreditoTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\"")
    public ProdutosCreditoTela tocarBotaoFechar() throws Exception{
        salvarEvidencia("Tocar bot�o 'Fechar'");
        tocarElemento(botaoFechar,"N�o foi poss�vel tocar no bot�o 'Fechar'");
        return this;
    }

    /**
     * Validar Forma de pagamento atualizada
     *
     * @return ProdutosCreditoTela
     */
    @Step("Validar 'Forma de pagamento atualizada'")
    public ProdutosCreditoTela validarFormaDePagamentoAtualizada() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.FORMA_DE_PAGAMENTO_ATUALIZADA), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar 'Forma de pagamento atualizada'");
        salvarEvidencia("Validar 'Forma de pagamento atualizada'");
        return this;
    }

    /**
     * Tocar bot�o Ok
     *
     * @return ProdutosCreditoTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Ok\"")
    public ProdutosCreditoTela tocarBotaoOk() throws Exception{
        salvarEvidencia("Tocar bot�o 'Ok'");
        tocarElemento(botaoOk,"N�o foi poss�vel tocar no bot�o 'Ok'");
        return this;
    }

    /**
     * Verifica se o tipo de pagamento 'Por boleto' est� selecionado
     *
     * @return boolean   retorna se o elemento est� com checkbox selecionado
     * @throws Exception
     */
    @Step("Verifica se o tipo de pagamento 'Por boleto' est� selecionado")
    public boolean tipoDePagamentoSelecionado() throws Exception{
        aguardarCarregamentoElemento(checkboxTipoPagamento);
        salvarEvidencia("Verificado se o checkbox 'Por boleto' est� selecionado");
          return verificarPresencaElemento(checkboxTipoPagamento);
    }
}
