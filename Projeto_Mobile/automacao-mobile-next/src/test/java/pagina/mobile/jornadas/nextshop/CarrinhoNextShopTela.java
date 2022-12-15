package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.nextShop.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CarrinhoNextShopTela extends PaginaBase {

    public CarrinhoNextShopTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'voltar Bot�o')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'voltar Bot�o')]")
    private MobileElement botaoVoltarHeader;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"systemInterfaceDelete\"]")
    @iOSXCUITFindBy(accessibility = "systemInterfaceDelete\\nsystemInterfaceDelete")
    private MobileElement botaoRemoverItem;

    @AndroidFindBy(accessibility = "systemControlCircleRemoveSmall\\nsystemControlCircleRemoveSmall")
    @AndroidFindBy(accessibility = "systemControlCircleRemoveSmall\\nsystemControlCircleRemoveSmall")
    private MobileElement botaoDiminuirQuantidadeItem;

    @AndroidFindBy(accessibility = "systemControlCircleAddSmall\\nsystemControlCircleAddSmall")
    @iOSXCUITFindBy(accessibility = "systemControlCircleAddSmall\\nsystemControlCircleAddSmall")
    private MobileElement botaoAumentarQuantidadeItem;

    @AndroidFindBy(accessibility = "Produto de Teste Companhia Brasileira de Tecnologia para e-commerce R$ 1,50 R$ 0,15 de cashback 1")
    @iOSXCUITFindBy(accessibility = "Produto de Teste Companhia Brasileira de Tecnologia para e-commerce R$ 1,50 R$ 0,15 de cashback 1")
    private MobileElement cardProdutoCarrinho;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"CONTINUAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;

    /**
     * Realiza o toque no bot�o de voltar no header da tela do Carrinho do Marketplace
     *
     * @return CarrinhoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public CarrinhoNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarHeader);
        salvarEvidencia("Tocar no bot�o 'Voltar' - Tela de Carrinho");
        tocarElemento(botaoVoltarHeader, "Houve um erro ao executar a acao de tocar o elemento botao \"Voltar\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o de remover um item do carrinho
     *
     * @return CarrinhoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Remover do carrinho\"")
    public CarrinhoNextShopTela tocarBotaoRemoverItemCarrinho() throws Exception {
        aguardarCarregamentoElemento(botaoRemoverItem);
        salvarEvidencia("Tocar no bot�o 'Remover do carrinho'");
        tocarElemento(botaoRemoverItem, "Houve um erro ao executar a acao de tocar o elemento botao \"Remover do carrinho\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o de diminuir a quantidade de um item.
     *
     * @return CarrinhoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Diminuir quantidade\"")
    public CarrinhoNextShopTela tocarBotaoDiminuirQuantidadeItem() throws Exception {
        aguardarCarregamentoElemento(botaoDiminuirQuantidadeItem);
        salvarEvidencia("Tocar no bot�o 'Diminuir quantidade'");
        tocarElemento(botaoDiminuirQuantidadeItem, "Houve um erro ao executar a acao de tocar o elemento botao \"Diminuir quantidade\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o de aumentar a quantidade de um item.
     *
     * @return CarrinhoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Aumentar quantidade\"")
    public CarrinhoNextShopTela tocarBotaoAumentarQuantidadeItem() throws Exception {
        aguardarCarregamentoElemento(botaoAumentarQuantidadeItem);
        salvarEvidencia("Tocar no bot�o 'Aumentar quantidade'");
        tocarElemento(botaoAumentarQuantidadeItem, "Houve um erro ao executar a acao de tocar o elemento botao \"Aumentar quantidade\"");
        return this;
    }

    /**
     * Realiza o toque no card do produto no carrinho.
     *
     * @return CarrinhoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Card produto\"")
    public CarrinhoNextShopTela tocarCardProdutoCarrinho() throws Exception {
        aguardarCarregamentoElemento(cardProdutoCarrinho);
        salvarEvidencia("Tocar no card produto'");
        tocarElemento(cardProdutoCarrinho, "Houve um erro ao executar a acao de tocar o elemento botao \"Card produto\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o continuar.
     *
     * @return CarrinhoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public CarrinhoNextShopTela tocarBotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no bot�o 'Continuar' - Tela de Carrinho");
        tocarElemento(botaoContinuar, "Houve um erro ao executar a acao de tocar o elemento botao \"Continuar\"");
        return this;
    }

    /**
     * Validar tela Carrinho
     *
     * @throws Exception
     */
    @Step("Validar tela Carrinho")
    public CarrinhoNextShopTela validarTelaCarrinho() throws Exception{
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CARRINHO),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar a tela Carrinho");
        salvarEvidencia("Validar tela Carrinho");
        return this;
    }
}
