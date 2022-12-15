package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.nextShop.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EnderecoNextShopTela extends PaginaBase {

    public EnderecoNextShopTela(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(accessibility = "voltar Bot�o")
    @iOSXCUITFindBy(accessibility = "voltar Bot�o")
    private MobileElement botaoVoltarHeader;

    @AndroidFindBy(accessibility = "Meu endere�o no next\\nRua George Eastman, 234, any_complement\\nVila Tramontano, S�o Paulo ABC, SP\\n05690-000")
    @iOSXCUITFindBy(accessibility = "Meu endere�o no next\\nRua George Eastman, 234, any_complement\\nVila Tramontano, S�o Paulo ABC, SP\\n05690-000")
    private MobileElement cardEnderecoNext;

    @AndroidFindBy(accessibility = "systemControlCircleInformation\\nsystemControlCircleInformation")
    @iOSXCUITFindBy(accessibility = "systemControlCircleInformation\\nsystemControlCircleInformation")
    private MobileElement informacoesEnderecoNext;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name,'Jorge Capitao')]")
    private MobileElement radioButtonEnderecoPadraoNext;

    @AndroidFindBy(accessibility = "adicionar endere�o Bot�o")
    @iOSXCUITFindBy(accessibility = "adicionar endere�o Bot�o")
    private MobileElement botaoAdicionarEndereco;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"CONTINUAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;

    @AndroidFindBy(accessibility = "editar Bot\u00e3o")
    @iOSXCUITFindBy(accessibility = "editar Bot\u00e3o")
    private MobileElement botaoEdicaoDeEndereco;

    @AndroidFindBy(accessibility = "EXCLUIR")
    @iOSXCUITFindBy(accessibility = "EXCLUIR")
    private MobileElement botaoExcluirEndereco;

    /**
     * Realiza o toque no bot�o de voltar no header da tela do Carrinho do Marketplace
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public EnderecoNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarHeader);
        salvarEvidencia("Tocar no bot�o 'Voltar' - Tela de Endere�o");
        tocarElemento(botaoVoltarHeader, "Houve um erro ao executar a acao de tocar o elemento botao \"Voltar\"");
        return this;
    }

    /**
     * Realiza o toque no card do endere�o next
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar card \"Endere�o Next\"")
    public EnderecoNextShopTela tocarCardEnderecoNext() throws Exception {
        aguardarCarregamentoElemento(cardEnderecoNext);
        salvarEvidencia("Tocar no card 'Endere�o Next'");
        tocarElemento(cardEnderecoNext, "Houve um erro ao executar a acao de tocar o elemento card \"Endere�o Next\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o informa��es do endere�o next
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"informa��es do endere�o next\"")
    public EnderecoNextShopTela tocarInformacoesEnderecoNext() throws Exception {
        aguardarCarregamentoElemento(informacoesEnderecoNext);
        salvarEvidencia("Tocar no bot�o 'informa��es do endere�o next'");
        tocarElemento(informacoesEnderecoNext, "Houve um erro ao executar a acao de tocar o elemento botao \"informa��es do endere�o next\"");
        return this;
    }

    /**
     * Selecionar endere�o padr�o next
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Selecionar endere�o padr�o next")
    public EnderecoNextShopTela selecionarEnderecoPadrao() throws NextException {
        aguardarCarregamentoElemento(radioButtonEnderecoPadraoNext);
        salvarEvidencia("Selecionar endere�o padr�o next");
        tocarElemento(radioButtonEnderecoPadraoNext, "Houve um erro ao executar a acao de tocar o elemento" + radioButtonEnderecoPadraoNext);
        return this;
    }

    /**
     * Realiza o toque no bot�o Adicionar endere�o.
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Adicionar endere�o\"")
    public EnderecoNextShopTela tocarBotaoAdicionarEndereco() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAdicionarEndereco, "N�o foi poss�vel encontrar o bot�o Adicionar Novo Endere�o.");
        aguardarElementoHabilitado(botaoAdicionarEndereco);
        salvarEvidencia("Tocar no bot�o 'Adicionar endere�o'");
        tocarElemento(botaoAdicionarEndereco, "Houve um erro ao executar a acao de tocar o elemento botao \"Adicionar endere�o\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o continuar.
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public EnderecoNextShopTela tocarBotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no botao 'Continuar' - Tela de Endere�o");
        tocarElemento(botaoContinuar, "Houve um erro ao executar a acao de tocar o elemento botao \"Continuar\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o Editar endere�o adicional.
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Editar endere�o adicional\"")
    public EnderecoNextShopTela tocaBotaoEdicaoDeEndereco() throws Exception {
        aguardarCarregamentoElemento(botaoEdicaoDeEndereco);
        salvarEvidencia("Tocar no bot�o 'Editar Endere�o'");
        tocarElemento(botaoEdicaoDeEndereco, "Houve um erro ao executar a acao de tocar o elemento" + botaoEdicaoDeEndereco);
        return this;
    }

    /**
     * Realiza o toque no excluir endere�o adicional.
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Excluir endere�o adicional\"")
    public EnderecoNextShopTela tocaBotaoExcluirEndereco() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirEndereco);
        salvarEvidencia("Tocar no bot�o 'Editar Endere�o'");
        tocarElemento(botaoExcluirEndereco, "Houve um erro ao executar a acao de tocar o elemento" + botaoExcluirEndereco);
        return this;
    }

    /**
     *
     * Validar tela endere�o de entrega
     * @throws Exception
     */
    @Step("Validar tela Endere�o de Entrega")
    public EnderecoNextShopTela validarTelaEnderecoEntrega() throws Exception{
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(TituloTela.ENDERECO_ENTREGA),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar a tela Endere�o de Entrega");
        salvarEvidencia("Validada tela Endere�o de Entrega");
        return this;
    }
}
