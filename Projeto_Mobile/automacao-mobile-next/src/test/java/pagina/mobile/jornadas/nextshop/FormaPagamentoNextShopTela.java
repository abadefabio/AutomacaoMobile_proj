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
     * Necess�rio validar a possibilidade de fazer um find do elemento com contais no accessibility.
     */
    @AndroidFindBy(accessibility = "(Cr�dito) ****0701\\n10/2029")
    @iOSXCUITFindBy(accessibility = "(Cr�dito) ****0701\\n10/2029")
    private MobileElement cardCartaoSalvo;
    @AndroidFindBy(accessibility = "Escolher parcelas Bot�o")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Escolher parcelas Bot�o')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Escolher parcelas Bot�o\"]")
    private MobileElement selecionaParcelasPagamento;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"ADICIONAR CART�O DE CR�DITO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ADICIONAR CART�O DE CR�DITO\"]")
    private MobileElement botaoAdicionarNovoCartao;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"CONTINUAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;

    /**
    * Necess�rio validar a possibilidade de fazer um find do elemento com contais no accessibility.
    */
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'1x sem juros')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'1x sem juros')]")
    private MobileElement radioButtonParcelaUnica;

    @AndroidFindBy(accessibility = "CANCELAR")
    @iOSXCUITFindBy(accessibility = "CANCELAR")
    private MobileElement botaoCancelar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Boleto')]")
    @iOSXCUITFindBy(accessibility = "Boleto\nFique atento � data de vencimento do boleto. A data de entrega e dep�sito do cashback dependem do processamento do pagamento.")
    private MobileElement botaoPagamentoBoleto;

    /**
     * Realiza o toque no card de cart�o salvo
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar  \"Card de Cart�o Salvo\"")
    public FormaPagamentoNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(cardCartaoSalvo);
        tocarElemento(cardCartaoSalvo, "Houve um erro ao executar a acao de tocar o elemento  \"Card de Cart�o Salvo\"");
        salvarEvidencia("Tocar no 'Cart�o Salvo'");
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
     * Realiza o toque no bot�o Adicionar novo cart�o
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar  \"Adicionar novo cart�o\"")
    public FormaPagamentoNextShopTela tocarBotaoAdicionarNovoCartao() throws Exception {
        rolarTelaAteFinal();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAdicionarNovoCartao, "N�o foi poss�vel encontrar o elemento" + botaoAdicionarNovoCartao);
        salvarEvidencia("Tocar no bot�o 'Adicionar novo cart�o'");
        tocarElemento(botaoAdicionarNovoCartao, "Houve um erro ao executar a acao de tocar o elemento  \"Adicionar novo cart�o\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o continuar
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public FormaPagamentoNextShopTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no bot�o 'Continuar' - Tela de M�todos de Pagamento");
        tocarElemento(botaoContinuar, "Houve um erro ao executar a acao de tocar o elemento bot�o \"Continuar\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o cancelar
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Cancelar\"")
    public FormaPagamentoNextShopTela tocarBotaoCancelar() throws Exception {
        aguardarCarregamentoElemento(botaoCancelar);
        salvarEvidencia("Tocar no bot�o 'Cancelar' - Tela de Forma de Pagamento");
        tocarElemento(botaoCancelar, "Houve um erro ao executar a acao de tocar o elemento bot�o \"Cancelar\"");
        return this;
    }

    /**
     * Realiza o toque na op��o de parcelamento em 1x
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Parcelamento em 1x\"")
    public FormaPagamentoNextShopTela tocarRadioButtonParcelaUnica() throws Exception {
        salvarEvidencia("Selecionar o parcelamento em 1x'");
        tocarElemento(radioButtonParcelaUnica, "Houve um erro ao executar a acao de tocar o elemento bot�o \"Parcelamento em 1x\"");
        return this;
    }

    /**
     * Realiza o toque na de pagamento com boleto
     *
     * @return FormaPagamentoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Pagamento com boleto\"")
    public FormaPagamentoNextShopTela selecionaPagamentoBoleto() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Seleciona op��o de pagamento com boleto");
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
                "N�o foi poss�vel validar a tela Forma de Pagamento");
        salvarEvidencia("Validada tela Forma de Pagamento");
        return this;
    }
}
