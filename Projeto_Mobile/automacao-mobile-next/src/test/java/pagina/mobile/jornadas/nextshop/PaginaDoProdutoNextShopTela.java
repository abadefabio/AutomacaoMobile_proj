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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'voltar Botão')]")
    private MobileElement botaoVoltarHeader;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'comprar agora Botão')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'comprar agora')]")
    private MobileElement botaoComprarAgora;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'adicionar ao carrinho Botão')]")
    @AndroidFindBy(accessibility = "adicionar ao carrinho Botão")
    @iOSXCUITFindBy(accessibility = "ADICIONAR AO CARRINHO BOTÃO")
    private MobileElement botaoAdicionarCarrinho;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'ESVAZIAR E SEGUIR')]")
    @iOSXCUITFindBy(accessibility = "ESVAZIAR E SEGUIR")
    private MobileElement botaoEsvaziereSeguir;

    /**
     * Realiza o toque no botão de voltar no header da tela do Carrinho do Marketplace
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public PaginaDoProdutoNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarHeader);
        salvarEvidencia("Tocar o botão 'Voltar' - Tela do Produto");
        tocarElemento(botaoVoltarHeader, "Houve um erro ao executar a acao de tocar o elemento botao \"Voltar\"");
        return this;
    }

    /**
     * Realiza o toque no botão Comprar Agora.
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Comprar Agora\"")
    public PaginaDoProdutoNextShopTela tocarBotaoComprarAgora() throws Exception {
        aguardarExistenciaElemento(botaoComprarAgora);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComprarAgora, "Não foi possível encontrar o elemento");
        salvarEvidencia("Tocar o botão 'COMPRAR AGORA'");
        tocarElemento(botaoComprarAgora, "Houve um erro ao executar a acao de tocar o elemento botao \"Comprar Agora\"");
        return this;
    }

    /**
     * Realiza o toque no botão Adicionar ao Carrinho.
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Adicionar ao Carrinho\"")
    public PaginaDoProdutoNextShopTela tocarBotaoAdicionarCarrinho() throws Exception {
        aguardarCarregamentoElemento(botaoAdicionarCarrinho);
        salvarEvidencia("Tocar o botão 'Adicionar ao Carrinho'");
        tocarElemento(botaoAdicionarCarrinho, "Houve um erro ao executar a acao de tocar o elemento botao \"Adicionar ao Carrinho\"");
        return this;
    }

    /**
     * Realiza o toque no botão Esvaziar e Seguir.
     *
     * @return PaginaDoProdutoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Esvaziar e Seguir\"")
    public PaginaDoProdutoNextShopTela selecionarEsvaziareSeguir() throws NextException {
        aguardarCarregamentoElemento(botaoEsvaziereSeguir);
        salvarEvidencia("Tocar botão 'Esvaziar e Seguir'");
        tocarElemento(botaoEsvaziereSeguir, "Houve um erro ao executar a acao de tocar o elemento botao \"Esvaziar e Seguir\"");
        return this;
    }
}
