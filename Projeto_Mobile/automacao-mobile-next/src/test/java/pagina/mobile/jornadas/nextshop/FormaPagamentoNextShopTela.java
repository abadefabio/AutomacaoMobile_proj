package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.nextShop.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class FormaPagamentoNextShopTela extends PaginaBase {

    public FormaPagamentoNextShopTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Necessário validar a possibilidade de fazer um find do elemento com contais no accessibility.
     */
    @AndroidFindBy(accessibility = "(Crédito) ****0701\\n10/2029")
    @iOSXCUITFindBy(accessibility = "(Crédito) ****0701\\n10/2029")
    private MobileElement cardCartaoSalvo;
    @AndroidFindBy(accessibility = "Escolher parcelas Botão")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Escolher parcelas Botão')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Escolher parcelas Botão\"]")
    private MobileElement selecionaParcelasPagamento;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"ADICIONAR CARTÃO DE CRÉDITO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ADICIONAR CARTÃO DE CRÉDITO\"]")
    private MobileElement botaoAdicionarNovoCartao;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"CONTINUAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;

    /**
    * Necessário validar a possibilidade de fazer um find do elemento com contais no accessibility.
    */
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'1x sem juros')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'1x sem juros')]")
    private MobileElement radioButtonParcelaUnica;

    @AndroidFindBy(accessibility = "CANCELAR")
    @iOSXCUITFindBy(accessibility = "CANCELAR")
    private MobileElement botaoCancelar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Boleto')]")
    @iOSXCUITFindBy(accessibility = "Boleto\nFique atento à data de vencimento do boleto. A data de entrega e depósito do cashback dependem do processamento do pagamento.")
    private MobileElement botaoPagamentoBoleto;

    /**
     * Realiza o toque no card de cartão salvo
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar  \"Card de Cartão Salvo\"")
    public FormaPagamentoNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(cardCartaoSalvo);
        tocarElemento(cardCartaoSalvo, "Houve um erro ao executar a acao de tocar o elemento  \"Card de Cartão Salvo\"");
        salvarEvidencia("Tocar no 'Cartão Salvo'");
        return this;
    }

    /**
     * Realiza o toque no seletor de parcelas
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar  \"Seletor de quantidade de parcelas\"")
    public FormaPagamentoNextShopTela tocarSelecionaParcelasPagamento() throws Exception {
        aguardarElementoHabilitado(selecionaParcelasPagamento);
        salvarEvidencia("Tocar no seletor de quantidade de parcelas'");
        tocarElemento(selecionaParcelasPagamento, "Houve um erro ao executar a acao de tocar o elemento  \"Seletor de quantidade de parcelas\"");
        return this;
    }

    /**
     * Realiza o toque no botão Adicionar novo cartão
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar  \"Adicionar novo cartão\"")
    public FormaPagamentoNextShopTela tocarBotaoAdicionarNovoCartao() throws Exception {
        rolarTelaAteFinal();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAdicionarNovoCartao, "Não foi possível encontrar o elemento" + botaoAdicionarNovoCartao);
        salvarEvidencia("Tocar no botão 'Adicionar novo cartão'");
        tocarElemento(botaoAdicionarNovoCartao, "Houve um erro ao executar a acao de tocar o elemento  \"Adicionar novo cartão\"");
        return this;
    }

    /**
     * Realiza o toque no botão continuar
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public FormaPagamentoNextShopTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no botão 'Continuar' - Tela de Métodos de Pagamento");
        tocarElemento(botaoContinuar, "Houve um erro ao executar a acao de tocar o elemento botão \"Continuar\"");
        return this;
    }

    /**
     * Realiza o toque no botão cancelar
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Cancelar\"")
    public FormaPagamentoNextShopTela tocarBotaoCancelar() throws Exception {
        aguardarCarregamentoElemento(botaoCancelar);
        salvarEvidencia("Tocar no botão 'Cancelar' - Tela de Forma de Pagamento");
        tocarElemento(botaoCancelar, "Houve um erro ao executar a acao de tocar o elemento botão \"Cancelar\"");
        return this;
    }

    /**
     * Realiza o toque na opção de parcelamento em 1x
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Parcelamento em 1x\"")
    public FormaPagamentoNextShopTela tocarRadioButtonParcelaUnica() throws Exception {
        salvarEvidencia("Selecionar o parcelamento em 1x'");
        tocarElemento(radioButtonParcelaUnica, "Houve um erro ao executar a acao de tocar o elemento botão \"Parcelamento em 1x\"");
        return this;
    }

    /**
     * Realiza o toque na de pagamento com boleto
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Pagamento com boleto\"")
    public FormaPagamentoNextShopTela selecionaPagamentoBoleto() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Seleciona opção de pagamento com boleto");
        tocarElemento(botaoPagamentoBoleto, "Houve um erro ao executar a acao de tocar o elemento  \"Selecionar Pagamento com Boleto\"");
        return this;
    }

    /**
     *
     * Validar tela pagamento
     * @throws Exception
     */
    @Step("Validar tela Pagamento")
    public FormaPagamentoNextShopTela validarTelaPagamento() throws Exception{
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(TituloTela.FORMA_DE_PAGAMENTO),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar a tela Forma de Pagamento");
        salvarEvidencia("Validada tela Forma de Pagamento");
        return this;
    }
}
