package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.testng.Reporter;

import static br.com.next.automacao.core.base.TesteNext.recuperarMassa;

public class ProdutosTela extends PaginaBase {

    //botao voltar <
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    //botao selecionar card simples      - obs: Para este em especifico teve que ficar 3 Locators IOS
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"SELECIONAR\")]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[6]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SELECIONAR\"`][1]")
    @iOSXCUITFindBy(iOSNsPredicate = "(//XCUIElementTypeButton[@name=\"SELECIONAR\"])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"SELECIONAR\"])[1]")
    private MobileElement botaoSelecionarCardSimples;

    //botao selecionar card multi indices      - obs: Para este em especifico teve que ficar 3 Locators IOS
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"next Multi-Índices\"]/../*[@text=\"SELECIONAR\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NEXT MULTI-ÍNDICES\"]/../XCUIElementTypeButton[@name=\"SELECIONAR\"]")
    private MobileElement botaoSelecionarMultiIndices;

    //texto do card de produto simples
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"Continuar criação\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continuar criação\"]")
    @iOSXCUITFindBy(accessibility = "Continuar criação")
    private MobileElement botaoContinuarCriacao;

    //texto do card de produto simples
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"next Simples\")]")
    @iOSXCUITFindBy(accessibility = "NEXT SIMPLES")
    private MobileElement textoCardProdutoSimples;

    //texto do card de produto Multi Indices
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"next Multi-Índices\")]")
    @iOSXCUITFindBy(accessibility = "NEXT MULTI-ÍNDICES")
    private MobileElement textoCardProdutoMultiIndices;

    //BOTAO SAIMA MAIS silples         - obs: Para este em especifico teve que ficar 3 Locators Android
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,\"SAIBA MAIS\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_know_more")
    @AndroidFindBy(xpath = "//*[@text=\"SAIBA MAIS\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SAIBA MAIS\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"SAIBA MAIS\"])[1]")
    private MobileElement botaoSaibaMaisSimples;

    //BOTAO SAIMA MAIS Multi-Indices          - obs: Para este em especifico teve que ficar 3 Locators Android
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"next Multi-Índices\"]/../*[@text=\"SAIBA MAIS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NEXT MULTI-ÍNDICES\"]/../XCUIElementTypeButton[@name=\"SAIBA MAIS\"]")
    private MobileElement botaoSaibaMaisMultiIndices;

    //botao Baixar documentos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/lbl_listheader")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Baixar documentos\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Baixar documentos\"]")
    private MobileElement botaoBaixarDocumentos;

    //botao demostracao de desempenho
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Demonstração de Desempenho\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Demonstração de Desempenho\"]")
    @iOSXCUITFindBy(accessibility = "Demonstração de Desempenho")
    private MobileElement botaoDemonstracaoDesempenho;

    //card Desempenho
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/pdfView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeWebView/XCUIElementTypeOther[1])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeWebView/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement cardDemonstracaoDesempenho;

    //botao fechar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    //botao compartilhar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @iOSXCUITFindBy(accessibility = "Compartilhar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Compartilhar\"]")
    private MobileElement botaoCompartilhar;

    //botao selecionar Next Multimercado
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Multimercado')]/..//android.widget.TextView[@text='SELECIONAR']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"NEXT MULTIMERCADO\"]/..//*[@name='SELECIONAR'][1])")
    private MobileElement botaoSelecionarCardMultimercado;

    //CARD Next Multimercado
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Multimercado')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NEXT MULTIMERCADO\"]")
    private MobileElement cardMultimercado;

    public ProdutosTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botao Voltar ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Voltar <\"")
    public ProdutosTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("'Tocar botao Voltar'");
        tocarElemento(botaoVoltar, "Erro ao Tocar botao Voltar");
        return this;
    }

    /**
     * Tocar botao selecionar no card de produto simples ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Selecionar\"")
    public ProdutosTela tocarSelecionarProdutoSimples() throws Exception {
        aguardarCarregamentoElemento(botaoSelecionarCardSimples);
        salvarEvidencia("'tocar botao Selecionar'");
        tocarElemento(botaoSelecionarCardSimples, "Erro ao tocar botao Selecionar");
        return this;
    }

    /**
     * Tocar botao selecionar no card de produto ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Selecionar\"")
    public ProdutosTela tocarSelecionarProduto() throws Exception {
        String produto=recuperarMassa(JSON.OBJETIVO);
        if (produto.isEmpty()) {
            Reporter.log("Objetivo não informado no jeson", true);
        }
        switch (produto) {
            case "simples":
                aguardarCarregamentoElemento(botaoSelecionarCardSimples);
                salvarEvidencia("'tocar botao Selecionar'");
                tocarElemento(botaoSelecionarCardSimples, "Erro ao tocar botao Selecionar");
                break;
            case "multi-indices":
                aguardarCarregamentoElemento(botaoSelecionarMultiIndices);
                salvarEvidencia("'tocar botao Selecionar'");
                tocarElemento(botaoSelecionarMultiIndices, "Erro ao tocar botao Selecionar");
                break;
            default:
                return this;
        }
        return this;
    }

    /**
     * Tocar botao "Continuar Criação"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Selecionar\"")
    public ProdutosTela tocarContinuarCriacao() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarCriacao);
        salvarEvidencia("'tocar botao Continuar Criação'");
        tocarElemento(botaoContinuarCriacao, "Erro ao tocar Continuar Criação");
        return this;
    }

    /**
     * validar texto do card de produto simples ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("validar card \"Produto Simples\"")
    public ProdutosTela validarProdutoSimples() throws Exception {
        aguardarCarregamentoElemento(textoCardProdutoSimples);
        verificarPresencaElemento(textoCardProdutoSimples);
        salvarEvidencia("'Validar presenca do card produto simples em tela.'");
        return this;
    }

    /**
     * validar texto do card de produto ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("validar card \"Produto \"")
    public ProdutosTela validarProduto() throws Exception {
        String produto=recuperarMassa(JSON.OBJETIVO);
        if (produto.isEmpty()) {
            Reporter.log("Objetivo não informado no jeson", true);
        }
        switch (produto) {
            case "simples":
                aguardarCarregamentoElemento(textoCardProdutoSimples);
                verificarPresencaElemento(textoCardProdutoSimples);
                break;
            case "multi-indices":
                aguardarCarregamentoElemento(textoCardProdutoMultiIndices);
                verificarPresencaElemento(textoCardProdutoMultiIndices);
                break;
            default:
                return this;
        }
        salvarEvidencia("'Validar presenca do card produto simples em tela.'");
        return this;
    }

    /**
     * validar texto do card de produto Multi-índices ' < '
     *
     * @return
     * @throws Exception
     */
    @Step("validar card \"Produto Multi-Indices\"")
    public ProdutosTela validarProdutoMultiIndices() throws Exception {
        aguardarCarregamentoElemento(textoCardProdutoMultiIndices);
        salvarEvidencia("'Validar presenca do card produto simples em tela.'");
        verificarPresencaElemento(textoCardProdutoSimples);
        return this;
    }

    /**
     * Tocar botao Saiba Mais
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Saiba Mais\"")
    public ProdutosTela tocarBotaoSaibaMais() throws Exception {

        String produto=recuperarMassa(JSON.OBJETIVO);
        if (produto.isEmpty()) {
            Reporter.log("Objetivo não informado no jeson", true);
        }
        switch (produto) {
            case "simples":
                aguardarCarregamentoElemento(botaoSaibaMaisSimples);
                salvarEvidencia("'Tocar botao Saiba Mais'");
                tocarElemento(botaoSaibaMaisSimples, "Erro ao tocar botao Saiba Mais");
                break;
            case "multi-indices":
                aguardarCarregamentoElemento(botaoSaibaMaisMultiIndices);
                salvarEvidencia("'Tocar botao Saiba Mais'");
                tocarElemento(botaoSaibaMaisMultiIndices, "Erro ao tocar botao Saiba Mais");
                break;
            default:
                return this;
        }
        return this;
    }

    /**
     * validar tela saiba mais produto next simples
     * fr
     * @return
     * @throws Exception
     */
    @Step("validar tela  \"Sobre O Produto\"")
    public ProdutosTela validarSobreOProduto() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SOBRE_O_PRODUTO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Sobre o Produto' não está presente na tela!");
        salvarEvidencia("validar que esta na tela de 'Sobre o produto'");
        rolarTelaAteFinal();
        return this;
    }

    /**
     * Tocar botao Demonstracao de desempenho
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Demonstracao de desempenho\"")
    public ProdutosTela tocarBotaoDemonstracaoDesempenho() throws Exception {
        salvarEvidencia("'Tocar botao Demonstracao de desempenho'");
        tocarElemento(botaoDemonstracaoDesempenho, "Erro ao tocar botao Demonstracao de desempenho");
        return this;
    }

    /**
     * validar tela Demonstração de Desempenho
     * fr
     * @return
     * @throws Exception
     */
    @Step("validar tela  \"Demostracao Desempenho\"")
    public ProdutosTela validarTelaDemonstracaoDesempenho() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.DEMONSTRACAO_DESEMPENHO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'DEMONSTRACAO DESEMPENHO' não está presente na tela!");
        salvarEvidencia("validar tela de 'Demonstração de Desempenho'");
        return this;
    }

    /**
     * validar Card Desempenho
     * fr
     * @return
     * @throws Exception
     */
    @Step("validar card  \"Desempenho\"")
    public ProdutosTela validarCardDesempenho() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(cardDemonstracaoDesempenho), MetodoComparacaoBooleano.VERDADEIRO, "erro ao verificar o card de desempenho.");
        salvarEvidencia("validar Card 'Demonstração de Desempenho'");
        return this;
    }

    /**
     * validar botao compartilhar
     * fr
     * @return
     * @throws Exception
     */
    @Step("validar botao \"Compartilhar\"")
    public ProdutosTela validarBotaoCompartilhar() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(botaoCompartilhar), MetodoComparacaoBooleano.VERDADEIRO, "erro ao verificar presenca do botao compartilhar.");
        salvarEvidencia("validar presenca do botao compartilhar.");
        return this;
    }

    /**
     * Tocar botao fechar
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Fechar\"")
    public ProdutosTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("'Tocar botao fechar'");
        tocarElemento(botaoFechar, "Erro ao tocar botao fechar");
        return this;
    }

    /**
     * Tocar botao baixar documentos
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Baixar Documentos\"")
    public ProdutosTela tocarBotaoBaixarDocumentos() throws Exception {
        salvarEvidencia("'Tocar botao Baixar Documentos'");
        tocarElemento(botaoBaixarDocumentos, "Erro ao tocar botao Baixar Documentos");
        return this;
    }

    /**
     * Tocar botao selecionar no card produto Next Multimercado
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Selecionar' produto Next Multimercado")
    public ProdutosTela tocarSelecionarProdutoNextMultimercado() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSelecionarCardMultimercado, "Não foi possivel achar o botão 'Selecionar' do produto 'Next Multimercado'");
        salvarEvidencia("Tocar botao 'Selecionar'");
        tocarElemento(botaoSelecionarCardMultimercado, "Erro ao tocar botao 'Selecionar'");
        return this;
    }
}
