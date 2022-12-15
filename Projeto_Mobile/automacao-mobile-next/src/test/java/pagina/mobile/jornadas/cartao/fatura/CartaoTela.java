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
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Pedir cart�o de cr�dito\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_banner")
    @iOSXCUITFindBy(xpath = "//*[@name='request_credit_card_banner']/ancestor::XCUIElementTypeCell")
    private MobileElement tocarPedirCartaoCredito;

    //Cancelar Cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avan�ar para bloqueio do cart�o")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='2� via e cancelamento']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Cancelar cart�o\"]")
    private MobileElement tocarCancelarCartao;

    //Cancelar Cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='2� via e cancelamento']")
    @AndroidFindBy(xpath = "//*[contains(upper-case(@text), \"VIA E CANCELAMENTO\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Avan�ar para bloqueio do cart�o\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avan�ar para bloqueio do cart�o\"]")
    private MobileElement botaoSegundaViaCancelamento;

    // servicos do cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avan�ar para servi�os do cart�o")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text, 'SERVI�OS DO CART�O')]")
    private MobileElement tocarServicosCartao;

    // configura��es do cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Configura��es do cart�o\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Avan�ar para configura��es do cart�o\"`]")
    @iOSXCUITFindBy(accessibility = "Avan�ar para configura��es do cart�o")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avan�ar para configura��es do cart�o\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Configura��es do cart�o']")
    private MobileElement tocarConfiguracoesCartao;

    //Ver fatura
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_view_invoice")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"ver fatura, bot�o\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"VER FATURA\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"VER FATURA\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"VER FATURA\"])[1]")
    private MobileElement botaoVerFatura;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Informa��es b�sicas do meu cart�o']")
    private MobileElement cardInformacoesCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CART�O']")
    @AndroidFindBy(xpath = "//*[@text = 'CART�O']")
    @iOSXCUITFindBy(accessibility = "CART�O")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"CART�O\"`]")
    private MobileElement tituloTelaCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avan�ar para pagamentos digitais")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Pagamentos Digitais']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Pagamentos Digitais\"]")
    private MobileElement botaoPagamentosDigitais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_status_title")
    @AndroidFindBy(xpath = "//*[@text = 'Reenvio do cart�o solicitado']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Reenvio do cart�o solicitado\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Reenvio do cart�o solicitado\"])[1]")
    private MobileElement mensagemReenvioDeCartaoSolicitado;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Ativar cart�o de cr�dito\"]")
    @iOSXCUITFindBy(accessibility = "Ativar cart�o de cr�dito")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ativar cart�o de cr�dito\"`]")
    private MobileElement tocarAtivarCartaodeCredito;

    @iOSXCUITFindBy(xpath = "//*[@name='Informa��es b�sicas do meu cart�o']")
    private MobileElement blocoInformacoesBasicaCartao;

    public CartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao "2� VIA E CANCELAMENTO"
     *
     * @throws Exception
     */
    @Step("Tocar botao '2� VIA E CANCELAMENTO'")
    public CartaoTela tocarCancelarCartao() throws Exception {
        rolarTelaAteFinal();
        tocarElemento(tocarBotaoSegundaViaCancelamento(), "N�o foi poss�vel tocar no botao '2� VIA E CANCELAMENTO'");
        salvarEvidencia("Tocar no botao '2� VIA E CANCELAMENTO'");
        return this;
    }

    /**
     * Tocar botao '2� VIA E CANCELAMENTO'
     *
     * @throws Exception
     */
    @Step("Tocar botao '2� VIA E CANCELAMENTO'")
    public CartaoTela tocarBotaoSegundaViaCancelamento() throws Exception {
        aguardarElementoHabilitado(tituloTelaCartao);
        if (android) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSegundaViaCancelamento,
                    "Nao foi possivel encontrar o botao '2� VIA E CANCELAMENTO'");
        } else {
            aguardarElementoHabilitado(botaoSegundaViaCancelamento);
            rolarTelaAteFinal(2);
        }
        salvarEvidencia("Tocar no botao '2� VIA E CANCELAMENTO'");
        tocarElemento(botaoSegundaViaCancelamento, "N�o foi poss�vel tocar no botao '2� VIA E CANCELAMENTO'");
        return this;
    }

    /**
     * Tocar �cone "Pedir Cartao Credito"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Pedir Cartao Credito\"")
    public CartaoTela tocarPedirCartaoCredito() throws Exception {
        tocarElemento(tocarPedirCartaoCredito, "N�o foi poss�vel tocar no botao \"Pedir Cartao Credito\"");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(tocarServicosCartao, "\"N�o foi poss�vel Encontrar o botao \"servicos do Cartao\"");
        salvarEvidencia("Tocar no botao \"servicos do Cartao\"");
        tocarElemento(tocarServicosCartao, "N�o foi poss�vel tocar no botao \"servicos do Cartao\"");
        return this;
    }

    /**
     * Tocar botao "Configuracoes do Cartao"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Configuracoes do Cartao\"")
    public CartaoTela tocarConfiguracoesCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(tocarConfiguracoesCartao, "N�o foi poss�vel encontrar 'Configuracoes do Cartao' ");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagamentosDigitais, "N�o foi poss�vel encontrar 'Pagamentos Digitais' ");
        salvarEvidencia("Tocar no botao \"Pagamentos Digitais\"");
        tocarElemento(botaoPagamentosDigitais, "Nao foi possivel tocar no botao Pagamentos Digitais");
        return this;
    }

    /**
     * Tocar bot�o "Ver Fatura"
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Tocar botao 'Ver Fatura'")
    public CartaoTela tocarVerFatura() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Ver Fatura'");
        if (android) {
            tocarElemento(botaoVerFatura, "N�o foi poss�vel tocar no bot�o 'Ver Fatura'");
        } else {
            tocarCoordenadaProporcional(cardInformacoesCartao, 10, 90);
        }
        return this;
    }

    /**
     * Validar presen�a da tela 'Cart�o'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'CART�O'")
    public CartaoTela validarTelaCartao() throws Exception {

        /*validarCondicaoBooleana(
                Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto(
                Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto(
                        TituloTela.CARTAO_IOS.toString(),
                        TituloTela.CARTAO_ANDROID.toString())),
                MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'CART�O' n�o est� presente na tela!");*/
        aguardarPaginaConterQualquerTexto(TituloTela.CARTAO_IOS.toString(), TituloTela.CARTAO_ANDROID.toString());
        salvarEvidencia("Validada presen�a da tela 'Cart�o'");
        return this;
    }

    /**
     * Tocar botao 'Ativar Cart�o de Cr�dito'
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Ativar Cart�o de Cr�dito'")
    public CartaoTela tocarAtivarCartaodeCredito() throws Exception {
        salvarEvidencia("Tocar no botao 'Ativar Cart�o de Cr�dito'");
        tocarElemento(tocarAtivarCartaodeCredito, "N�o foi poss�vel tocar no botao 'Ativar Cart�o de Cr�dito'");
        return this;
    }

    /**
     * Validar presen�a do texto 'Reenvio do Cart�o Solicitado'
     *
     * @throws Exception
     */
    @Step("Validar presen�a do texto 'Reenvio do Cart�o Solicitado'")
    public CartaoTela validarTextoReenviodoCartaoSolicitado() throws Exception {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(Mensagens.REENVIO_DO_CARTAO_SOLICITADO),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Texto 'Reenvio do Cart�o Solicitado' n�o encontrado!");
        salvarEvidencia("Validada presen�a do texto 'Reenvio do Cart�o Solicitado'");
        return this;
    }

    /**
     * Validar presen�a do texto 'Seu cart�o j� est� sendo produzido!'
     */
    @Step("Validar presen�a do texto 'Seu cart�o j� est� sendo produzido!'")
    public CartaoTela validarTextoSeuCartaoJaEstaSendoProduzido() {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.SEU_CARTAO_JA_ESTA_SENDO_PRODUZIDO), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Seu cart�o j� est� sendo produzido!' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a do texto 'Seu cart�o j� est� sendo produzido!'");
        return this;
    }

    /**
     * Validar mensagens de cancelamento do cart�o
     */
    @Step("Validar mensagens de cancelamento do cart�o")
    public CartaoTela validarCartaoCancelado() throws Exception {
        deslizar(Direcao.ESQUERDA, 10, 80);
        validarCondicaoBooleana(
                !aguardarPaginaConterQualquerTexto(Mensagens.MENSAGENS_CANCELAMENTO).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Texto 'Cart�o cancelado' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a do texto 'Cart�o cancelado'");
        return this;
    }

    /**
     * Validar aviso de cart�o danificado
     */
    @Step("Validar aviso de cart�o danificado")
    public CartaoTela validarCartaoDanificado() throws Exception {
        deslizar(Direcao.ESQUERDA, 10, 80);
        if(android) {
            validarCondicaoBooleana(
                    aguardarPaginaConterTodosTextos(Mensagens.CARTAO_DANIFICADO),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    "Texto 'Cart�o danificado' n�o est� presente na tela!");
            salvarEvidencia("Validada presen�a do texto 'Cart�o danificado'");
        } else {
            //Mensagem de 'Cartao danificado 'nao consegue ser validada no iOS por nao aparecer no PageSource
            //A mensagem tambem nao e mapeavel

            validarCondicaoBooleana(verificarPresencaElemento(blocoInformacoesBasicaCartao),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    "O Bloco de Informacoes Basicas do Cartao n�o est� presente na tela!");
            salvarEvidencia("Validada presen�a do Bloco de Informacoes Basicas do Cartao");
        }


        return this;
    }

    /**
     * Validar presen�a da tela 'Oferta Cart�o'
     *
     * @throws Exception
     */
    @Step("Validar presen�a do bot�o \"Oferta Cart�o\"")
    public CartaoTela validarTituloOfertaCartao() throws Exception {
        if (ios) {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.OFERTA_DE_CARTAO)), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Oferta Cart�o' n�o est� presente na tela!");
            salvarEvidencia("Validada presen�a da tela 'Oferta Cart�o'");
        } else {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.OFERTA_DE_CARTAO)), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Oferta Cart�o' n�o est� presente na tela!");
            salvarEvidencia("Validada presen�a da tela 'Oferta Cart�o'");
        }
        return this;
    }

    /**
     * Validar presen�a do bot�o 'VER FATURA'
     *
     * @throws Exception
     */
    @Step("Validar presen�a do bot�o 'VER FATURA'")
    public CartaoTela validarPresencaBotaoVerFatura() throws Exception {
        aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.VER_FATURA));
        salvarEvidencia("Validada presen�a do bot�o 'VER FATURA'");
        return this;
    }

    /**
     * Validar presen�a do texto 'CART�O'
     *
     * @return CartaoTela
     */
    @Step("Validar presen�a do texto 'CART�O'")
    public CartaoTela validarTextoCartao() {
        aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.CARTAO));
        salvarEvidencia("Validada presen�a do texto 'CART�O'");
        return this;
    }
}
