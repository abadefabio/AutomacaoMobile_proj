package pagina.mobile.jornadas.investimentos.aplicacao;

import org.openqa.selenium.By;
import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.exception.NextException;
import constantes.investimentos.Produto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutosTela extends PaginaBase {

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nb_invest_product']")
    @iOSXCUITFindBy(xpath = "//*[@name='investButtonId']")
    private MobileElement botaoInvestir;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nb_detail_product']")
    @iOSXCUITFindBy(xpath = "//*[@name='seeMoreButtonId']")
    private MobileElement botaoDetalhes;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nb_invest_product']/preceding::*[@resource-id='br.com.bradesco.next:id/nl_product_name_showcase']")
    @iOSXCUITFindBy(xpath = "//*[@name='investButtonId']/following::*[@name='categoryProductNameLabelId']")
    private MobileElement labelProduto;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_bt_filter']")
    @iOSXCUITFindBy(accessibility = "searchLabelId")
    private MobileElement botaoBuscar;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/cl_text_field']/*[@resource-id='br.com.bradesco.next:id/et_input_text']")
    @iOSXCUITFindBy(accessibility = "searchBarId")
    private MobileElement campoBuscar;

    public ProdutosTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Investir' do primeiro produto
     *
     * @param produto Par�metro a ser preenchido com o nome do produto
     * @return ProdutosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Investir' do primeiro produto")
    public ProdutosTela tocarBotaoInvestirPrimeiroProduto(ThreadLocal<String> produto) throws Exception {
        aguardarCarregamentoElemento(botaoInvestir);
        produto.set(retornarTexto(labelProduto, "Erro ao recuperar o atributo texto do produto"));
        salvarEvidencia("Tocar no bot�o 'Investir' do produto " + produto.get());
        tocarElemento(botaoInvestir, "N�o foi poss�vel tocar no bot�o 'Investir' do produto " + produto.get());
        return this;
    }

    /**
     * Tocar no bot�o 'Detalhes' do primeiro produto
     *
     * @param produto Par�metro a ser preenchido com o nome do produto
     * @return ProdutosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Detalhes' do primeiro produto")
    public ProdutosTela tocarBotaoDetalhesPrimeiroProduto(ThreadLocal<String> produto) throws Exception {
        aguardarCarregamentoElemento(botaoDetalhes);
        produto.set(retornarTexto(labelProduto, "Erro ao recuperar o atributo texto do produto"));
        salvarEvidencia("Tocar no bot�o 'Detalhes' do produto " + produto.get());
        tocarElemento(botaoDetalhes, "N�o foi poss�vel tocar no bot�o 'Detalhes' do produto " + produto.get());
        return this;
    }

    /**
     * Tocar no bot�o 'Investir' do produto
     *
     * @param produto Produto a ser selecionado (CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @return ProdutosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Investir' do produto")
    public ProdutosTela tocarBotaoInvestir(String produto) throws Exception {
        By botaoInvestir;
        if(android) {
            botaoInvestir = By.xpath("//*[@text='"+produto+"']/following::*[@resource-id='br.com.bradesco.next:id/nb_invest_product']");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestir, "N�o foi poss�vel encontrar o bot�o 'Investir' do produto " + produto, 15);
        } else {
            botaoInvestir = By.xpath("//*[@label='"+produto+"']/preceding-sibling::*[@name='investButtonId']");
            // Valida��o necess�ria para o produto Poupan�a em iOS, pois h� casos em que o bot�o investir
            // n�o fica vis�vel em tela, sendo necess�rio descer a tela para encontr�-lo.
            // A valida��o � feita em cima do label do primeiro produto encontrado, pois a tela de produto
            // � dividida em 2 partes e o deslizar somente funciona na segunda parte da tela onde consta o bot�o 'Investir'
            if (produto.equals(Produto.NEXT_POUPANCA) && !aguardarElementoHabilitado(botaoInvestir)) {
                deslizar(labelProduto, Direcao.ABAIXO, 60,80);
            } else {
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestir, "N�o foi poss�vel encontrar o bot�o 'Investir' do produto " + produto, 15);
            }
        }
        salvarEvidencia("Tocar no bot�o 'Investir' do produto " +produto);
        tocarElemento(botaoInvestir, "N�o foi poss�vel tocar no bot�o 'Investir' do produto " +produto);
        return this;
    }

    /**
     * Tocar no bot�o 'Detalhes' do produto
     * @param produto Produto a ser selecionado (CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @return ProdutosTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Detalhes' do produto")
    public ProdutosTela tocarBotaoDetalhes(String produto) throws NextException {
        By botaoDetalhes;
        if(android) {
            botaoDetalhes = By.xpath("//*[@text='"+produto+"']/following::*[@resource-id='br.com.bradesco.next:id/nb_detail_product']");
        } else {
            botaoDetalhes = By.xpath("//*[@label='"+produto+"']/following-sibling::*[@name='seeMoreButtonId']");
        }
        salvarEvidencia("Tocar no bot�o 'Detalhes' do produto " + produto);
        tocarElemento(botaoDetalhes, "N�o foi poss�vel tocar no bot�o 'Detalhes' do produto " + produto);
        return this;
    }

    /**
     * Tocar no bot�o 'Buscar'
     *
     * @return ProdutosTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Buscar'")
    public ProdutosTela tocarBotaoBuscar() throws NextException {
        aguardarCarregamentoElemento(botaoBuscar);
        salvarEvidencia("Tocar no bot�o 'Buscar'");
        tocarElemento(botaoBuscar, "N�o foi poss�vel tocar no bot�o 'Buscar'");
        return this;
    }

    /**
     * Preencher o nome do produto no campo de busca
     *
     * @param produto Produto a ser preenchido (CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @return ProdutosTela
     * @throws NextException
     */
    @Step("Escrever o nome do produto no campo de busca")
    public ProdutosTela escreverNomeProduto(Produto produto) throws NextException {
        escreverTexto(campoBuscar, produto.toString(), true, "N�o foi poss�vel escrever o nome do produto " + produto + " no campo de busca");
        salvarEvidencia("Preenchido o campo de busca com o produto " + produto);
        return this;
    }
}
