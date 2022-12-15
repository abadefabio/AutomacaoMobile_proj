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


    @AndroidFindBy(accessibility = "voltar Botão")
    @iOSXCUITFindBy(accessibility = "voltar Botão")
    private MobileElement botaoVoltarHeader;

    @AndroidFindBy(accessibility = "Meu endereço no next\\nRua George Eastman, 234, any_complement\\nVila Tramontano, São Paulo ABC, SP\\n05690-000")
    @iOSXCUITFindBy(accessibility = "Meu endereço no next\\nRua George Eastman, 234, any_complement\\nVila Tramontano, São Paulo ABC, SP\\n05690-000")
    private MobileElement cardEnderecoNext;

    @AndroidFindBy(accessibility = "systemControlCircleInformation\\nsystemControlCircleInformation")
    @iOSXCUITFindBy(accessibility = "systemControlCircleInformation\\nsystemControlCircleInformation")
    private MobileElement informacoesEnderecoNext;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name,'Jorge Capitao')]")
    private MobileElement radioButtonEnderecoPadraoNext;

    @AndroidFindBy(accessibility = "adicionar endereço Botão")
    @iOSXCUITFindBy(accessibility = "adicionar endereço Botão")
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
     * Realiza o toque no botão de voltar no header da tela do Carrinho do Marketplace
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public EnderecoNextShopTela tocarBotaoVoltarHeader() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarHeader);
        salvarEvidencia("Tocar no botão 'Voltar' - Tela de Endereço");
        tocarElemento(botaoVoltarHeader, "Houve um erro ao executar a acao de tocar o elemento botao \"Voltar\"");
        return this;
    }

    /**
     * Realiza o toque no card do endereço next
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar card \"Endereço Next\"")
    public EnderecoNextShopTela tocarCardEnderecoNext() throws Exception {
        aguardarCarregamentoElemento(cardEnderecoNext);
        salvarEvidencia("Tocar no card 'Endereço Next'");
        tocarElemento(cardEnderecoNext, "Houve um erro ao executar a acao de tocar o elemento card \"Endereço Next\"");
        return this;
    }

    /**
     * Realiza o toque no botão informações do endereço next
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"informações do endereço next\"")
    public EnderecoNextShopTela tocarInformacoesEnderecoNext() throws Exception {
        aguardarCarregamentoElemento(informacoesEnderecoNext);
        salvarEvidencia("Tocar no botão 'informações do endereço next'");
        tocarElemento(informacoesEnderecoNext, "Houve um erro ao executar a acao de tocar o elemento botao \"informações do endereço next\"");
        return this;
    }

    /**
     * Selecionar endereço padrão next
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Selecionar endereço padrão next")
    public EnderecoNextShopTela selecionarEnderecoPadrao() throws NextException {
        aguardarCarregamentoElemento(radioButtonEnderecoPadraoNext);
        salvarEvidencia("Selecionar endereço padrão next");
        tocarElemento(radioButtonEnderecoPadraoNext, "Houve um erro ao executar a acao de tocar o elemento" + radioButtonEnderecoPadraoNext);
        return this;
    }

    /**
     * Realiza o toque no botão Adicionar endereço.
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Adicionar endereço\"")
    public EnderecoNextShopTela tocarBotaoAdicionarEndereco() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAdicionarEndereco, "Não foi possível encontrar o botão Adicionar Novo Endereço.");
        aguardarElementoHabilitado(botaoAdicionarEndereco);
        salvarEvidencia("Tocar no botão 'Adicionar endereço'");
        tocarElemento(botaoAdicionarEndereco, "Houve um erro ao executar a acao de tocar o elemento botao \"Adicionar endereço\"");
        return this;
    }

    /**
     * Realiza o toque no botão continuar.
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public EnderecoNextShopTela tocarBotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no botao 'Continuar' - Tela de Endereço");
        tocarElemento(botaoContinuar, "Houve um erro ao executar a acao de tocar o elemento botao \"Continuar\"");
        return this;
    }

    /**
     * Realiza o toque no botão Editar endereço adicional.
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Editar endereço adicional\"")
    public EnderecoNextShopTela tocaBotaoEdicaoDeEndereco() throws Exception {
        aguardarCarregamentoElemento(botaoEdicaoDeEndereco);
        salvarEvidencia("Tocar no botão 'Editar Endereço'");
        tocarElemento(botaoEdicaoDeEndereco, "Houve um erro ao executar a acao de tocar o elemento" + botaoEdicaoDeEndereco);
        return this;
    }

    /**
     * Realiza o toque no excluir endereço adicional.
     *
     * @return EnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Excluir endereço adicional\"")
    public EnderecoNextShopTela tocaBotaoExcluirEndereco() throws Exception {
        aguardarCarregamentoElemento(botaoExcluirEndereco);
        salvarEvidencia("Tocar no botão 'Editar Endereço'");
        tocarElemento(botaoExcluirEndereco, "Houve um erro ao executar a acao de tocar o elemento" + botaoExcluirEndereco);
        return this;
    }

    /**
     *
     * Validar tela endereço de entrega
     * @throws Exception
     */
    @Step("Validar tela Endereço de Entrega")
    public EnderecoNextShopTela validarTelaEnderecoEntrega() throws Exception{
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(TituloTela.ENDERECO_ENTREGA),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar a tela Endereço de Entrega");
        salvarEvidencia("Validada tela Endereço de Entrega");
        return this;
    }
}
