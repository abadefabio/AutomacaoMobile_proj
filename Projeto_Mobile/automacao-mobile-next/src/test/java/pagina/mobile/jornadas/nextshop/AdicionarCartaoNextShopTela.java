package pagina.mobile.jornadas.nextshop;

import base.mobile.nextShop.PaginaBaseBuscaNextShop;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AdicionarCartaoNextShopTela extends PaginaBaseBuscaNextShop {

    public AdicionarCartaoNextShopTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,'Número do cartão')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Número do cartão')]")
    private MobileElement inserirNumeroCartao;

    @AndroidFindBy(xpath = "//*[contains(@text,'Nome escrito no')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Nome escrito no')]")
    private MobileElement inserirNomeCartao;

    @AndroidFindBy(xpath = "//*[contains(@text,'Data de validade')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Data de validade')]")
    private MobileElement inserirDataExpiracao;

    @AndroidFindBy(xpath = "//*[contains(@text,'CPF do titular')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CPF do titular')]")
    private MobileElement inserirCpfTitularCartao;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"ADICIONAR\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ADICIONAR\"]")
    @iOSXCUITFindBy(accessibility = "ADICIONAR")
    private MobileElement botaoAdicionarCartao;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"CANCELAR\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CANCELAR\"]")
    private MobileElement botaoCancelar;

    @AndroidFindBy(className = "android.widget.RadioButton")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Fulano Beltrano Da')]")
    private MobileElement radioButtonEnderecoPadraoNext;

    @AndroidFindBy(accessibility = "USAR ESTE ENDEREÇO")
    @iOSXCUITFindBy(accessibility = "USAR ESTE ENDEREÇO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"USAR ESTE ENDEREÇO\"]")
    private MobileElement botaoUsarEsteEndereco;

    /**
     * Preencher campo Número do Cartão
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Número do Cartão\"")
    public AdicionarCartaoNextShopTela preencheNumeroCartao(String numeroCartao) throws Exception {
        tocarElemento(inserirNumeroCartao, "Não possível tocar no elemento" + inserirNumeroCartao);
        if (android){
            escreverTextoSemEsconderTeclado(inserirNumeroCartao, numeroCartao,"Não foi possível escrever o número do cartão");
        }
        else{
            escreverTexto(inserirNumeroCartao, numeroCartao,"Não foi possível escrever o número do cartão");
        }
        salvarEvidencia("Preencher campo 'Número do Cartão' com: " + numeroCartao);
        return this;
    }

    /**
     * Preencher campo Nome do Cartão
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Nome do Cartão\"")
    public AdicionarCartaoNextShopTela preencheNomeCartao(String nomeCartao) throws Exception {
        tocarElemento(inserirNomeCartao, "Não possível tocar no elemento" + inserirNomeCartao);
        if (android){
            escreverTextoBuscaNextShopAndroid(inserirNomeCartao, nomeCartao,"Não foi possível escrever no campo nome escrito no cartão");
        }
        else{
            escreverTexto(inserirNomeCartao, nomeCartao,"Não foi possível escrever no campo nome escrito no cartão");
            tocarBotaoENTERTeclado(inserirNomeCartao,"Não foi possível tocar o botão enter");
        }
        salvarEvidencia("Preencher campo 'Nome do Cartão' com: " + nomeCartao);
        return this;
    }

    /**
     * Preencher campo Data de Expiração
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Data de Expiração\"")
    public AdicionarCartaoNextShopTela preencheDataExpiracao(String dataExpiracao) throws Exception {
        tocarElemento(inserirDataExpiracao, "Não possível tocar no elemento" + inserirNomeCartao);
        if (android){
            escreverTextoSemEsconderTeclado(inserirDataExpiracao, dataExpiracao,"Não foi possível escrever a data de expiração");
        }
        else{
            escreverTexto(inserirDataExpiracao, dataExpiracao,"Não foi possível escrever a data de expiração");
        }
        salvarEvidencia("Preencher campo 'Data de Expiração' com: " + dataExpiracao);
        return this;
    }

    /**
     * Preencher campo CPF do Titular do Cartão
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"CPF do Titular do Cartão\"")
    public AdicionarCartaoNextShopTela preencheCpfTitularCartao(String cpfTitularCartao) throws Exception {
        tocarElemento(inserirCpfTitularCartao, "Não possível tocar no elemento" + inserirNomeCartao);
        if (android){
            escreverTextoSemEsconderTeclado(inserirCpfTitularCartao, cpfTitularCartao,"Não foi possível escrever o cpf");
        }
        else{
            escreverTexto(inserirCpfTitularCartao, cpfTitularCartao,"Não foi possível escrever o cpf");
        }
        salvarEvidencia("Preencher campo 'CPF do Titular do Cartão' com: " + cpfTitularCartao);
        return this;
    }

    /**
     * Realiza o toque no Adicionar Cartão.
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Adicionar Cartão\"")
    public AdicionarCartaoNextShopTela tocarBotaoAdicionarCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAdicionarCartao,"Não foi possível encontrar o botão adicionar");
        salvarEvidencia("Tocar no botão 'Adicionar Cartão'");
        tocarElemento(botaoAdicionarCartao, "Houve um erro ao executar a acao de tocar o elemento botao \"Adicionar Cartão\"");
        return this;
    }

    /**
     * Realiza o toque no botão cancelar.
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Cancelar\"")
    public AdicionarCartaoNextShopTela tocarBotaoCancelar() throws Exception {
        aguardarCarregamentoElemento(botaoCancelar);
        salvarEvidencia("Tocar no botão 'Cancelar' - Tela de Adicionar Cartão");
        tocarElemento(botaoCancelar, "Houve um erro ao executar a acao de tocar o elemento botao \"Cancelar\"");
        return this;
    }

    /**
     * Selecionar endereço padrão next
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Selecionar endereço padrão next")
    public AdicionarCartaoNextShopTela selecionarEnderecoPadrao() throws NextException {
        aguardarCarregamentoElemento(radioButtonEnderecoPadraoNext);
        salvarEvidencia("Selecionar endereço padrão next");
        tocarElemento(radioButtonEnderecoPadraoNext, "Houve um erro ao executar a acao de tocar o elemento" + radioButtonEnderecoPadraoNext);
        return this;
    }

    /**
     * Tocar o botão 'Usar Este Endereço
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Tocar o botão 'Usar Este Endereço'")
    public AdicionarCartaoNextShopTela tocarBotaoUsarEsteEndereco() throws Exception {
        rolarTelaAteFinal();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoUsarEsteEndereco, "Não foi possível encontrar o elemento" + botaoUsarEsteEndereco);
        tocarElemento(botaoUsarEsteEndereco, "Houve um erro ao executar a acao de tocar o elemento" + botaoUsarEsteEndereco);
        salvarEvidencia("Tocar botão 'Usar Este Endereço'");
        return this;
    }

}
