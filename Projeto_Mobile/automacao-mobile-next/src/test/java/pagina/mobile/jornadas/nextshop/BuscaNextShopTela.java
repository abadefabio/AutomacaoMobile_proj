package pagina.mobile.jornadas.nextshop;

import base.mobile.nextShop.PaginaBaseBuscaNextShop;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class BuscaNextShopTela extends PaginaBaseBuscaNextShop {

    public BuscaNextShopTela(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement barraDePesquisa;

    @AndroidFindBy(accessibility = "BUSCAR")
    @iOSXCUITFindBy(accessibility = "BUSCAR")
    private MobileElement botaoBuscar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'voltar')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'voltar Bot�o')]")
    private MobileElement botaoVoltarHeader;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Camiseta')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Camiseta')]")
    private MobileElement cardProduto;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Hub')]")
    private MobileElement cardProdutoMarketplaceHub;

    /**
     * Preenche o nome do produto recebido no campo de Busca.
     *
     * @return BuscaMarketplace
     * @throws Exception
     */
    public BuscaNextShopTela preencheCampoDePesquisa(String nomeProduto) throws Exception {
        aguardarCarregamentoElemento(barraDePesquisa);
        if (android) {
            escreverTexto(barraDePesquisa, nomeProduto, "N�o foi poss�vel preencher o nome do produto");
            tocarElemento(barraDePesquisa,"N�o foi poss�vel tocar na barra de pesquisa");
        } else {
            escreverTexto(barraDePesquisa, nomeProduto, "N�o foi poss�vel preencher o nome do produto");
        }
        salvarEvidencia("Preencher o campo de busca com:" +nomeProduto);
        return this;
    }

    /**
     * Toca no card do produto pesquisado.
     *
     * @return BuscaMarketplace
     * @throws Exception
     */
    public BuscaNextShopTela tocarCardProduto() throws Exception {
        salvarEvidencia("Tocar o card do produto pesquisado.");
        tocarElemento(cardProduto, "Houve um erro ao executar a acao de tocar o elemento \"Card do Produto Pesquisado\"");
        return this;
    }
    /**
     * Toca no card do produto pesquisado.
     *
     * @return BuscaMarketplace
     * @throws Exception
     */
    public BuscaNextShopTela tocarCardProdutoMarketplaceHub() throws NextException {
        aguardarCarregamentoElemento(cardProdutoMarketplaceHub);
        salvarEvidencia("Tocar o card do produto pesquisado.");
        tocarElemento(cardProdutoMarketplaceHub, "Houve um erro ao executar a acao de tocar o elemento" + cardProdutoMarketplaceHub);
        return this;
    }

    /**
     * Apaga o conte�do no campo de busca.
     *
     * @return BuscaMarketplace
     * @throws Exception
     */
    public BuscaNextShopTela limparCampoDeBusca() throws Exception {
        aguardarCarregamentoElemento(barraDePesquisa);
        apagarCampoTexto(barraDePesquisa,"N�o foi poss�vel apagar o conte�do do campo" + barraDePesquisa);
        salvarEvidencia("Conte�do do campo" + barraDePesquisa + "removido com sucesso.");
        return this;
    }

    /**
     * Realiza o toque no bot�o de voltar no header da tela do Carrinho do Marketplace
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public BuscaNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarHeader);
        salvarEvidencia("Tocar o bot�o 'Voltar' - Tela de Busca");
        tocarElemento(botaoVoltarHeader, "Houve um erro ao executar a acao de tocar o elemento botao \"Voltar\"");
        return this;
    }
}
