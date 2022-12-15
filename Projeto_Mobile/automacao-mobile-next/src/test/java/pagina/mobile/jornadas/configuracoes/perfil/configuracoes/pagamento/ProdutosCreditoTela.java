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
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Por débito automático' AND value == 'Não Selecionado'")
    private MobileElement opcaoPorDebitoAutomatico;

    @AndroidFindBy(xpath = "//*[@resource-id=\"br.com.bradesco.next:id/nl_label_text\" and @text=\"Repetir tentativas de débito automático\"]")
    @iOSXCUITFindBy(accessibility = "Repetir tentativas de débito automático")
    private MobileElement opcaoRepetirTentativas;

    @AndroidFindBy(xpath = "//*[@resource-id=\"br.com.bradesco.next:id/nl_label_text\" and @text=\"Usar grana de emergência para pagamento de fatura\"]")
    @iOSXCUITFindBy(accessibility = "Usar grana de emergência para pagamento de fatura")
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
     * Tocar botão Voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public ProdutosCreditoTela tocarBotaoVoltar() throws Exception{
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar,"Não foi possível tocar botão voltar");
        return this;
    }

    /**
     * Tocar opção Por Boleto
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar opção \"Por Boleto\"")
    public ProdutosCreditoTela tocarOpcaoBoleto() throws Exception{
        salvarEvidencia("Tocar na opção 'Por Boleto'");
        tocarElemento(opcaoPorBoleto,"Não foi possível tocar opção 'Por Boleto'");
        return this;
    }

    /**
     * Tocar opção Por débito automático
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar opção \"Por debito automatico\"")
    public ProdutosCreditoTela tocarOpcaoPorDebitoAutomatico() throws Exception{
        aguardarElementoHabilitado(opcaoPorDebitoAutomatico);
        salvarEvidencia("Tocar na opção 'Por debito automatico'");
        tocarElemento(opcaoPorDebitoAutomatico,"Não foi possível tocar opção 'Por debito automatico'");
        return this;
    }

    /**
     * Tocar opcao Repetir tentativas
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar opção \"Repetir tentativas\"")
    public ProdutosCreditoTela tocarOpcaoRepetirTentativas()throws Exception{
        salvarEvidencia("Tocar na opção 'Repetir tentativas'");
        tocarElemento(opcaoRepetirTentativas,"Não foi possível tocar opção 'Repetir tentativas'");
        return this;
    }

    /**
     * Tocar opcao Usar grana de emergência
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar opção \"Usar grana de emergência\"")
    public ProdutosCreditoTela tocarOpcaoUsarGranaEmergencia() throws Exception{
        salvarEvidencia("Tocar opção 'Usar grana de emergência'");
        tocarElemento(opcaoUsarGranaDeEmergencia,"Não foi possível tocar opção 'Usar grana de emergência'");
        return this;
    }

    /**
     * Tocar botão Salvar
     *
     * @return ProdutosCreditoTela
     * @throws Exception
     */
    @Step("Tocar botão \"Salvar\"")
    public ProdutosCreditoTela tocarBotaoSalvar() throws Exception{
        salvarEvidencia("Tocar botão 'Salvar'");
        aguardarElementoHabilitado(botaoSalvar);
        tocarElemento(botaoSalvar,"Não foi possível tocar no botão 'Salvar'");
        return this;
    }

    /**
     * Tocar botão Fechar
     *
     * @return ProdutosCreditoTela
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public ProdutosCreditoTela tocarBotaoFechar() throws Exception{
        salvarEvidencia("Tocar botão 'Fechar'");
        tocarElemento(botaoFechar,"Não foi possível tocar no botão 'Fechar'");
        return this;
    }

    /**
     * Validar Forma de pagamento atualizada
     *
     * @return ProdutosCreditoTela
     */
    @Step("Validar 'Forma de pagamento atualizada'")
    public ProdutosCreditoTela validarFormaDePagamentoAtualizada() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.FORMA_DE_PAGAMENTO_ATUALIZADA), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar 'Forma de pagamento atualizada'");
        salvarEvidencia("Validar 'Forma de pagamento atualizada'");
        return this;
    }

    /**
     * Tocar botão Ok
     *
     * @return ProdutosCreditoTela
     * @throws Exception
     */
    @Step("Tocar botão \"Ok\"")
    public ProdutosCreditoTela tocarBotaoOk() throws Exception{
        salvarEvidencia("Tocar botão 'Ok'");
        tocarElemento(botaoOk,"Não foi possível tocar no botão 'Ok'");
        return this;
    }

    /**
     * Verifica se o tipo de pagamento 'Por boleto' está selecionado
     *
     * @return boolean   retorna se o elemento está com checkbox selecionado
     * @throws Exception
     */
    @Step("Verifica se o tipo de pagamento 'Por boleto' está selecionado")
    public boolean tipoDePagamentoSelecionado() throws Exception{
        aguardarCarregamentoElemento(checkboxTipoPagamento);
        salvarEvidencia("Verificado se o checkbox 'Por boleto' está selecionado");
          return verificarPresencaElemento(checkboxTipoPagamento);
    }
}
