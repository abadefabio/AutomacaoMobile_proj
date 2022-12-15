package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PaginaDoProdutoNextShopTela extends PaginaBase {

    public PaginaDoProdutoNextShopTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'voltar')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'voltar Bot�o')]")
    private MobileElement botaoVoltarHeader;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'comprar agora Bot�o')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'comprar agora')]")
    private MobileElement botaoComprarAgora;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'adicionar ao carrinho Bot�o')]")
    @AndroidFindBy(accessibility = "adicionar ao carrinho Bot�o")
    @iOSXCUITFindBy(accessibility = "ADICIONAR AO CARRINHO BOT�O")
    private MobileElement botaoAdicionarCarrinho;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'ESVAZIAR E SEGUIR')]")
    @iOSXCUITFindBy(accessibility = "ESVAZIAR E SEGUIR")
    private MobileElement botaoEsvaziereSeguir;

    /**
     * Realiza o toque no bot�o de voltar no header da tela do Carrinho do Marketplace
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public PaginaDoProdutoNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarHeader);
        salvarEvidencia("Tocar o bot�o 'Voltar' - Tela do Produto");
        tocarElemento(botaoVoltarHeader, "Houve um erro ao executar a acao de tocar o elemento botao \"Voltar\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o Comprar Agora.
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Comprar Agora\"")
    public PaginaDoProdutoNextShopTela tocarBotaoComprarAgora() throws Exception {
        aguardarExistenciaElemento(botaoComprarAgora);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComprarAgora, "N�o foi poss�vel encontrar o elemento");
        salvarEvidencia("Tocar o bot�o 'COMPRAR AGORA'");
        tocarElemento(botaoComprarAgora, "Houve um erro ao executar a acao de tocar o elemento botao \"Comprar Agora\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o Adicionar ao Carrinho.
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Adicionar ao Carrinho\"")
    public PaginaDoProdutoNextShopTela tocarBotaoAdicionarCarrinho() throws Exception {
        aguardarCarregamentoElemento(botaoAdicionarCarrinho);
        salvarEvidencia("Tocar o bot�o 'Adicionar ao Carrinho'");
        tocarElemento(botaoAdicionarCarrinho, "Houve um erro ao executar a acao de tocar o elemento botao \"Adicionar ao Carrinho\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o Esvaziar e Seguir.
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Esvaziar e Seguir\"")
    public PaginaDoProdutoNextShopTela selecionarEsvaziareSeguir() throws NextException {
        aguardarCarregamentoElemento(botaoEsvaziereSeguir);
        salvarEvidencia("Tocar bot�o 'Esvaziar e Seguir'");
        tocarElemento(botaoEsvaziereSeguir, "Houve um erro ao executar a acao de tocar o elemento botao \"Esvaziar e Seguir\"");
        return this;
    }
}
