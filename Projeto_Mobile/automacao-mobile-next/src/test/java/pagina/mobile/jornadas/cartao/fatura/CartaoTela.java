package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.Mensagem;
import constantes.cartao.Mensagens;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CartaoTela extends PaginaBase {

    //Pedir cartao credito
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Pedir cartão de crédito\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_banner")
    @iOSXCUITFindBy(xpath = "//*[@name='request_credit_card_banner']/ancestor::XCUIElementTypeCell")
    private MobileElement tocarPedirCartaoCredito;

    //Cancelar Cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avançar para bloqueio do cartão")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='2ª via e cancelamento']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Cancelar cartão\"]")
    private MobileElement tocarCancelarCartao;

    //Cancelar Cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='2ª via e cancelamento']")
    @AndroidFindBy(xpath = "//*[contains(upper-case(@text), \"VIA E CANCELAMENTO\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Avançar para bloqueio do cartão\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avançar para bloqueio do cartão\"]")
    private MobileElement botaoSegundaViaCancelamento;

    // servicos do cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avançar para serviços do cartão")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text, 'SERVIÇOS DO CARTÃO')]")
    private MobileElement tocarServicosCartao;

    // configurações do cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Configurações do cartão\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Avançar para configurações do cartão\"`]")
    @iOSXCUITFindBy(accessibility = "Avançar para configurações do cartão")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avançar para configurações do cartão\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Configurações do cartão']")
    private MobileElement tocarConfiguracoesCartao;

    //Ver fatura
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_view_invoice")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ver fatura, botão\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"VER FATURA\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"VER FATURA\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"VER FATURA\"])[1]")
    private MobileElement botaoVerFatura;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Informações básicas do meu cartão']")
    private MobileElement cardInformacoesCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CARTÃO']")
    @AndroidFindBy(xpath = "//*[@text = 'CARTÃO']")
    @iOSXCUITFindBy(accessibility = "CARTÃO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"CARTÃO\"`]")
    private MobileElement tituloTelaCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avançar para pagamentos digitais")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Pagamentos Digitais']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Pagamentos Digitais\"]")
    private MobileElement botaoPagamentosDigitais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_status_title")
    @AndroidFindBy(xpath = "//*[@text = 'Reenvio do cartão solicitado']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reenvio do cartão solicitado\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Reenvio do cartão solicitado\"])[1]")
    private MobileElement mensagemReenvioDeCartaoSolicitado;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Ativar cartão de crédito\"]")
    @iOSXCUITFindBy(accessibility = "Ativar cartão de crédito")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ativar cartão de crédito\"`]")
    private MobileElement tocarAtivarCartaodeCredito;

    @iOSXCUITFindBy(xpath = "//*[@name='Informações básicas do meu cartão']")
    private MobileElement blocoInformacoesBasicaCartao;

    public CartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao "2ª VIA E CANCELAMENTO"
     *
     * @throws Exception
     */
    @Step("Tocar botao '2ª VIA E CANCELAMENTO'")
    public CartaoTela tocarCancelarCartao() throws Exception {
        rolarTelaAteFinal();
        tocarElemento(tocarBotaoSegundaViaCancelamento(), "Não foi possível tocar no botao '2ª VIA E CANCELAMENTO'");
        salvarEvidencia("Tocar no botao '2ª VIA E CANCELAMENTO'");
        return this;
    }

    /**
     * Tocar botao '2ª VIA E CANCELAMENTO'
     *
     * @throws Exception
     */
    @Step("Tocar botao '2ª VIA E CANCELAMENTO'")
    public CartaoTela tocarBotaoSegundaViaCancelamento() throws Exception {
        aguardarElementoHabilitado(tituloTelaCartao);
        if (android) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSegundaViaCancelamento,
                    "Nao foi possivel encontrar o botao '2ª VIA E CANCELAMENTO'");
        } else {
            aguardarElementoHabilitado(botaoSegundaViaCancelamento);
            rolarTelaAteFinal(2);
        }
        salvarEvidencia("Tocar no botao '2ª VIA E CANCELAMENTO'");
        tocarElemento(botaoSegundaViaCancelamento, "Não foi possível tocar no botao '2ª VIA E CANCELAMENTO'");
        return this;
    }

    /**
     * Tocar ícone "Pedir Cartao Credito"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Pedir Cartao Credito\"")
    public CartaoTela tocarPedirCartaoCredito() throws Exception {
        tocarElemento(tocarPedirCartaoCredito, "Não foi possível tocar no botao \"Pedir Cartao Credito\"");
        salvarEvidencia("Tocar no botao \"Pedir Cartao Credito\"");
        return this;
    }

    /**
     * Tocar botao "Servicos do Cartao"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"servicos do Cartao\"")
    public CartaoTela tocarServicosCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(tocarServicosCartao, "\"Não foi possível Encontrar o botao \"servicos do Cartao\"");
        salvarEvidencia("Tocar no botao \"servicos do Cartao\"");
        tocarElemento(tocarServicosCartao, "Não foi possível tocar no botao \"servicos do Cartao\"");
        return this;
    }

    /**
     * Tocar botao "Configuracoes do Cartao"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Configuracoes do Cartao\"")
    public CartaoTela tocarConfiguracoesCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(tocarConfiguracoesCartao, "Não foi possível encontrar 'Configuracoes do Cartao' ");
        salvarEvidencia("Tocar no botao \"Configuracoes do Cartao\"");
        tocarElemento(tocarConfiguracoesCartao, "Nao foi possivel tocar no botao configuracoes do cartao");
        return this;
    }

    /**
     * Tocar botao "Pagamentos Digitais"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Pagamentos Digitais\"")
    public CartaoTela tocarBotaoPagamentosDigitais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagamentosDigitais, "Não foi possível encontrar 'Pagamentos Digitais' ");
        salvarEvidencia("Tocar no botao \"Pagamentos Digitais\"");
        tocarElemento(botaoPagamentosDigitais, "Nao foi possivel tocar no botao Pagamentos Digitais");
        return this;
    }

    /**
     * Tocar botão "Ver Fatura"
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Tocar botao 'Ver Fatura'")
    public CartaoTela tocarVerFatura() throws Exception {
        salvarEvidencia("Tocar no botão 'Ver Fatura'");
        if (android) {
            tocarElemento(botaoVerFatura, "Não foi possível tocar no botão 'Ver Fatura'");
        } else {
            tocarCoordenadaProporcional(cardInformacoesCartao, 10, 90);
        }
        return this;
    }

    /**
     * Validar presença da tela 'Cartão'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela 'CARTÃO'")
    public CartaoTela validarTelaCartao() throws Exception {

        /*validarCondicaoBooleana(
                Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto(
                Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto(
                        TituloTela.CARTAO_IOS.toString(),
                        TituloTela.CARTAO_ANDROID.toString())),
                MetodoComparacaoBooleano.VERDADEIRO, "Título 'CARTÃO' não está presente na tela!");*/
        aguardarPaginaConterQualquerTexto(TituloTela.CARTAO_IOS.toString(), TituloTela.CARTAO_ANDROID.toString());
        salvarEvidencia("Validada presença da tela 'Cartão'");
        return this;
    }

    /**
     * Tocar botao 'Ativar Cartão de Crédito'
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Ativar Cartão de Crédito'")
    public CartaoTela tocarAtivarCartaodeCredito() throws Exception {
        salvarEvidencia("Tocar no botao 'Ativar Cartão de Crédito'");
        tocarElemento(tocarAtivarCartaodeCredito, "Não foi possível tocar no botao 'Ativar Cartão de Crédito'");
        return this;
    }

    /**
     * Validar presença do texto 'Reenvio do Cartão Solicitado'
     *
     * @throws Exception
     */
    @Step("Validar presença do texto 'Reenvio do Cartão Solicitado'")
    public CartaoTela validarTextoReenviodoCartaoSolicitado() throws Exception {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(Mensagens.REENVIO_DO_CARTAO_SOLICITADO),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Texto 'Reenvio do Cartão Solicitado' não encontrado!");
        salvarEvidencia("Validada presença do texto 'Reenvio do Cartão Solicitado'");
        return this;
    }

    /**
     * Validar presença do texto 'Seu cartão já está sendo produzido!'
     */
    @Step("Validar presença do texto 'Seu cartão já está sendo produzido!'")
    public CartaoTela validarTextoSeuCartaoJaEstaSendoProduzido() {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.SEU_CARTAO_JA_ESTA_SENDO_PRODUZIDO), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Seu cartão já está sendo produzido!' não está presente na tela!");
        salvarEvidencia("Validada presença do texto 'Seu cartão já está sendo produzido!'");
        return this;
    }

    /**
     * Validar mensagens de cancelamento do cartão
     */
    @Step("Validar mensagens de cancelamento do cartão")
    public CartaoTela validarCartaoCancelado() throws Exception {
        deslizar(Direcao.ESQUERDA, 10, 80);
        validarCondicaoBooleana(
                !aguardarPaginaConterQualquerTexto(Mensagens.MENSAGENS_CANCELAMENTO).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Texto 'Cartão cancelado' não está presente na tela!");
        salvarEvidencia("Validada presença do texto 'Cartão cancelado'");
        return this;
    }

    /**
     * Validar aviso de cartão danificado
     */
    @Step("Validar aviso de cartão danificado")
    public CartaoTela validarCartaoDanificado() throws Exception {
        deslizar(Direcao.ESQUERDA, 10, 80);
        if(android) {
            validarCondicaoBooleana(
                    aguardarPaginaConterTodosTextos(Mensagens.CARTAO_DANIFICADO),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    "Texto 'Cartão danificado' não está presente na tela!");
            salvarEvidencia("Validada presença do texto 'Cartão danificado'");
        } else {
            //Mensagem de 'Cartao danificado 'nao consegue ser validada no iOS por nao aparecer no PageSource
            //A mensagem tambem nao e mapeavel

            validarCondicaoBooleana(verificarPresencaElemento(blocoInformacoesBasicaCartao),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    "O Bloco de Informacoes Basicas do Cartao não está presente na tela!");
            salvarEvidencia("Validada presença do Bloco de Informacoes Basicas do Cartao");
        }


        return this;
    }

    /**
     * Validar presença da tela 'Oferta Cartão'
     *
     * @throws Exception
     */
    @Step("Validar presença do botão \"Oferta Cartão\"")
    public CartaoTela validarTituloOfertaCartao() throws Exception {
        if (ios) {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.OFERTA_DE_CARTAO)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Oferta Cartão' não está presente na tela!");
            salvarEvidencia("Validada presença da tela 'Oferta Cartão'");
        } else {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.OFERTA_DE_CARTAO)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Oferta Cartão' não está presente na tela!");
            salvarEvidencia("Validada presença da tela 'Oferta Cartão'");
        }
        return this;
    }

    /**
     * Validar presença do botão 'VER FATURA'
     *
     * @throws Exception
     */
    @Step("Validar presença do botão 'VER FATURA'")
    public CartaoTela validarPresencaBotaoVerFatura() throws Exception {
        aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.VER_FATURA));
        salvarEvidencia("Validada presença do botão 'VER FATURA'");
        return this;
    }

    /**
     * Validar presença do texto 'CARTÃO'
     *
     * @return CartaoTela
     */
    @Step("Validar presença do texto 'CARTÃO'")
    public CartaoTela validarTextoCartao() {
        aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.CARTAO));
        salvarEvidencia("Validada presença do texto 'CARTÃO'");
        return this;
    }
}
