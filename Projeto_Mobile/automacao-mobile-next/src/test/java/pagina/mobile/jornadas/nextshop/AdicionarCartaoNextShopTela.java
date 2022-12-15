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

    @AndroidFindBy(xpath = "//*[contains(@text,'N�mero do cart�o')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'N�mero do cart�o')]")
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

    @AndroidFindBy(accessibility = "USAR ESTE ENDERE�O")
    @iOSXCUITFindBy(accessibility = "USAR ESTE ENDERE�O")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"USAR ESTE ENDERE�O\"]")
    private MobileElement botaoUsarEsteEndereco;

    /**
     * Preencher campo N�mero do Cart�o
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"N�mero do Cart�o\"")
    public AdicionarCartaoNextShopTela preencheNumeroCartao(String numeroCartao) throws Exception {
        tocarElemento(inserirNumeroCartao, "N�o poss�vel tocar no elemento" + inserirNumeroCartao);
        if (android){
            escreverTextoSemEsconderTeclado(inserirNumeroCartao, numeroCartao,"N�o foi poss�vel escrever o n�mero do cart�o");
        }
        else{
            escreverTexto(inserirNumeroCartao, numeroCartao,"N�o foi poss�vel escrever o n�mero do cart�o");
        }
        salvarEvidencia("Preencher campo 'N�mero do Cart�o' com: " + numeroCartao);
        return this;
    }

    /**
     * Preencher campo Nome do Cart�o
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Nome do Cart�o\"")
    public AdicionarCartaoNextShopTela preencheNomeCartao(String nomeCartao) throws Exception {
        tocarElemento(inserirNomeCartao, "N�o poss�vel tocar no elemento" + inserirNomeCartao);
        if (android){
            escreverTextoBuscaNextShopAndroid(inserirNomeCartao, nomeCartao,"N�o foi poss�vel escrever no campo nome escrito no cart�o");
        }
        else{
            escreverTexto(inserirNomeCartao, nomeCartao,"N�o foi poss�vel escrever no campo nome escrito no cart�o");
            tocarBotaoENTERTeclado(inserirNomeCartao,"N�o foi poss�vel tocar o bot�o enter");
        }
        salvarEvidencia("Preencher campo 'Nome do Cart�o' com: " + nomeCartao);
        return this;
    }

    /**
     * Preencher campo Data de Expira��o
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Data de Expira��o\"")
    public AdicionarCartaoNextShopTela preencheDataExpiracao(String dataExpiracao) throws Exception {
        tocarElemento(inserirDataExpiracao, "N�o poss�vel tocar no elemento" + inserirNomeCartao);
        if (android){
            escreverTextoSemEsconderTeclado(inserirDataExpiracao, dataExpiracao,"N�o foi poss�vel escrever a data de expira��o");
        }
        else{
            escreverTexto(inserirDataExpiracao, dataExpiracao,"N�o foi poss�vel escrever a data de expira��o");
        }
        salvarEvidencia("Preencher campo 'Data de Expira��o' com: " + dataExpiracao);
        return this;
    }

    /**
     * Preencher campo CPF do Titular do Cart�o
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"CPF do Titular do Cart�o\"")
    public AdicionarCartaoNextShopTela preencheCpfTitularCartao(String cpfTitularCartao) throws Exception {
        tocarElemento(inserirCpfTitularCartao, "N�o poss�vel tocar no elemento" + inserirNomeCartao);
        if (android){
            escreverTextoSemEsconderTeclado(inserirCpfTitularCartao, cpfTitularCartao,"N�o foi poss�vel escrever o cpf");
        }
        else{
            escreverTexto(inserirCpfTitularCartao, cpfTitularCartao,"N�o foi poss�vel escrever o cpf");
        }
        salvarEvidencia("Preencher campo 'CPF do Titular do Cart�o' com: " + cpfTitularCartao);
        return this;
    }

    /**
     * Realiza o toque no Adicionar Cart�o.
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Adicionar Cart�o\"")
    public AdicionarCartaoNextShopTela tocarBotaoAdicionarCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAdicionarCartao,"N�o foi poss�vel encontrar o bot�o adicionar");
        salvarEvidencia("Tocar no bot�o 'Adicionar Cart�o'");
        tocarElemento(botaoAdicionarCartao, "Houve um erro ao executar a acao de tocar o elemento botao \"Adicionar Cart�o\"");
        return this;
    }

    /**
     * Realiza o toque no bot�o cancelar.
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Tocar bot�o \"Cancelar\"")
    public AdicionarCartaoNextShopTela tocarBotaoCancelar() throws Exception {
        aguardarCarregamentoElemento(botaoCancelar);
        salvarEvidencia("Tocar no bot�o 'Cancelar' - Tela de Adicionar Cart�o");
        tocarElemento(botaoCancelar, "Houve um erro ao executar a acao de tocar o elemento botao \"Cancelar\"");
        return this;
    }

    /**
     * Selecionar endere�o padr�o next
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Selecionar endere�o padr�o next")
    public AdicionarCartaoNextShopTela selecionarEnderecoPadrao() throws NextException {
        aguardarCarregamentoElemento(radioButtonEnderecoPadraoNext);
        salvarEvidencia("Selecionar endere�o padr�o next");
        tocarElemento(radioButtonEnderecoPadraoNext, "Houve um erro ao executar a acao de tocar o elemento" + radioButtonEnderecoPadraoNext);
        return this;
    }

    /**
     * Tocar o bot�o 'Usar Este Endere�o
     *
     * @return AdicionarCartaoMarketplace
     * @throws Exception
     */
    @Step("Tocar o bot�o 'Usar Este Endere�o'")
    public AdicionarCartaoNextShopTela tocarBotaoUsarEsteEndereco() throws Exception {
        rolarTelaAteFinal();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoUsarEsteEndereco, "N�o foi poss�vel encontrar o elemento" + botaoUsarEsteEndereco);
        tocarElemento(botaoUsarEsteEndereco, "Houve um erro ao executar a acao de tocar o elemento" + botaoUsarEsteEndereco);
        salvarEvidencia("Tocar bot�o 'Usar Este Endere�o'");
        return this;
    }

}
