package pagina.mobile.jornadas.cartao.desbloqueio;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CartaoTela extends PaginaBase {

    // Título da tela de confirmação de recebimento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resourceId='br.com.bradesco.next:id/nl_title'")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"CARTÃO\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"CARTÃO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CARTÃO\"]")
    private MobileElement tituloTela;

    //Botão de confirmação de recebimento de cartão
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_go_to_desblock_card")
    @AndroidFindBy(xpath = "//android.widget.Button[@resourceId='br.com.bradesco.next:id/btn_go_to_desblock_card'")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"RECEBI O CARTÃO\"])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"RECEBI O CARTÃO\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"RECEBI O CARTÃO\"])[1]")
    private MobileElement botaoRecebiCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Informações básicas do meu cartão\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS \"Meu tipo\"")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"Meu tipo\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_flag")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/ctv_flag']")
    public MobileElement tipoCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avançar para solicitação de cartão de crédito")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton[`label == \"Avançar para solicitação de cartão de crédito\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avançar para solicitação de cartão de crédito\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'PEDIR CARTÃO DE CRÉDITO')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'PEDIR CARTÃO DE CRÉDITO')]")
    public MobileElement botaoPedirCartaoCredito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avançar para pagamentos digitais")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton[`label == \"Avançar para pagamentos digitais\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avançar para pagamentos digitais\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'PAGAMENTOS DIGITAIS')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'PAGAMENTOS DIGITAIS')]")
    public MobileElement botaoPagamentosDigitais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avançar para bloqueio do cartão")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton[`label == \"Avançar para bloqueio do cartão\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avançar para bloqueio do cartão\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'CANCELAR CARTÃO')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'CANCELAR CARTÃO')]")
    public MobileElement botaoCancelarCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avançar para serviços do cartão")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton[`label == \"Avançar para serviços do cartão\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avançar para serviços do cartão\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'SERVIÇOS DO CARTÃO')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'SERVIÇOS DO CARTÃO')]")
    public MobileElement botaoServicosCartao;

    //Configurações do cartão
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avançar para configurações do cartão")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Avançar para configurações do cartão\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avançar para configurações do cartão\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'CONFIGURAÇÕES DO CARTÃO')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'CONFIGURAÇÕES DO CARTÃO')]")
    private MobileElement botaoConfiguracoesCartao;

    //Não possui mapeamento iOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/visa_logo")
    private MobileElement logoVisa;

    public CartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao 'Recebi o cartão'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Tocar botão 'Recebi o cartão'")
    public CartaoTela tocarRecebiCartao() throws Exception {
        salvarEvidencia("Tocar no botao 'Recebi o cartão'");
        tocarElemento(botaoRecebiCartao, "Não foi possível tocar no botão 'Recebi o cartão'");
        return this;
    }

    /**
     * Validar tela "CARTÃO"
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar título da tela: 'CARTÃO'")
    public CartaoTela validarTituloTela() {
        validarCondicaoBooleana(
                aguardarCarregamentoElemento(tituloTela),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar o título da tela de confirmação de recebimento do cartão"
        );
        salvarEvidencia("Validado o título da tela de confirmação de recebimento de cartão");
        return this;
    }

    /**
     * Validar mensagens na tela de recebimento do cartão enviado ao cliente
     *
     * @param mensagens
     * @return CartaoTela
     */
    @Step("Validar página conter aviso de indisponibilidade do sistema")
    public CartaoTela validarMensagensTela(String... mensagens) {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(mensagens),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar todas as mensagens presentes na tela"
        );
        salvarEvidencia("Validadas as mensagens na tela de recebimento do cartão");
        return this;
    }

    /**
     * Validar que cartão é do tipo correto 'débito ou crédito'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar tipo do cartão 'Débito ou Crédito'")
    public CartaoTela validarTipoCartao(String... textosTipoCartao) throws Exception {
        if (android) {
            rolarTelaParaCimaAosPoucosAteEncontrarElemento(logoVisa, "Não foi possível localizar o elemento logo visa");
        }
        validarCondicaoBooleana(
                !aguardarPaginaConterQualquerTexto(textosTipoCartao).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar o tipo de cartão procurado"
        );
        salvarEvidencia("Validado tipo do cartão com texto na página");
        return this;
    }

    /**
     * Validar presença do botão 'PEDIR CARTÃO DE CRÉDITO'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar presença do botão 'PEDIR CARTÃO DE CRÉDITO'")
    public CartaoTela validarBotaoPedirCartaoCredito() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPedirCartaoCredito,
                "Botão 'PAGAMENTOS DIGITAIS' não encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoPedirCartaoCredito),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presença do botão 'PEDIR CARTÃO DE CRÉDITO'");
        return this;
    }

    /**
     * Validar presença do botão PAGAMENTOS DIGITAIS
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar presença do botão 'PAGAMENTOS DIGITAIS'")
    public CartaoTela validarPresencaBotaoPagamentosDigitais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagamentosDigitais,
                "Botão 'PAGAMENTOS DIGITAIS' não encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoPagamentosDigitais),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presença do botão 'PAGAMENTOS DIGITAIS'");
        return this;
    }


    /**
     * Validar presença do botão 'CANCELAR CARTÃO'
     */
    @Step("Validar presença do botão 'CANCELAR CARTÃO'")
    public CartaoTela validarPresencaBotaoCancelarCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCancelarCartao,
                "Botão 'CANCELAR CARTÃO' não encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoCancelarCartao),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presença do botão 'CANCELAR CARTÃO'");
        return this;
    }

    /**
     * Validar presença do botão 'PEDIR CARTÃO DE CRÉDITO'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar presença do botão 'SERVIÇOS DO CARTÃO'")
    public CartaoTela validarPresencaBotaoServicosCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoServicosCartao,
                "Botão 'SERVIÇOS DO CARTÃO' não encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoServicosCartao),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presença do botão 'SERVIÇOS DO CARTÃO'");
        return this;
    }

    /**
     * Validar presença do botão 'PEDIR CARTÃO DE CRÉDITO'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar presença do botão 'CONFIGURAÇÕES DO CARTÃO'")
    public CartaoTela validarPresencaBotaoConfiguracoesCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesCartao,
                "Botão 'CONFIGURAÇÕES DO CARTÃO' não encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoConfiguracoesCartao),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presença do botão 'CONFIGURAÇÕES DO CARTÃO'");
        return this;
    }

}
