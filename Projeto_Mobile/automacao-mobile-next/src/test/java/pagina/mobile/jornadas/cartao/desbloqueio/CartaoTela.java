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

    // T�tulo da tela de confirma��o de recebimento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resourceId='br.com.bradesco.next:id/nl_title'")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"CART�O\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"CART�O\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CART�O\"]")
    private MobileElement tituloTela;

    //Bot�o de confirma��o de recebimento de cart�o
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_go_to_desblock_card")
    @AndroidFindBy(xpath = "//android.widget.Button[@resourceId='br.com.bradesco.next:id/btn_go_to_desblock_card'")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"RECEBI O CART�O\"])[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"RECEBI O CART�O\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"RECEBI O CART�O\"])[1]")
    private MobileElement botaoRecebiCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Informa��es b�sicas do meu cart�o\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS \"Meu tipo\"")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"Meu tipo\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_flag")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/ctv_flag']")
    public MobileElement tipoCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avan�ar para solicita��o de cart�o de cr�dito")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton[`label == \"Avan�ar para solicita��o de cart�o de cr�dito\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avan�ar para solicita��o de cart�o de cr�dito\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'PEDIR CART�O DE CR�DITO')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'PEDIR CART�O DE CR�DITO')]")
    public MobileElement botaoPedirCartaoCredito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avan�ar para pagamentos digitais")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton[`label == \"Avan�ar para pagamentos digitais\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avan�ar para pagamentos digitais\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'PAGAMENTOS DIGITAIS')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'PAGAMENTOS DIGITAIS')]")
    public MobileElement botaoPagamentosDigitais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avan�ar para bloqueio do cart�o")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton[`label == \"Avan�ar para bloqueio do cart�o\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avan�ar para bloqueio do cart�o\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'CANCELAR CART�O')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'CANCELAR CART�O')]")
    public MobileElement botaoCancelarCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avan�ar para servi�os do cart�o")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton[`label == \"Avan�ar para servi�os do cart�o\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avan�ar para servi�os do cart�o\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'SERVI�OS DO CART�O')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'SERVI�OS DO CART�O')]")
    public MobileElement botaoServicosCartao;

    //Configura��es do cart�o
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Avan�ar para configura��es do cart�o")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Avan�ar para configura��es do cart�o\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Avan�ar para configura��es do cart�o\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_title' and contains(@text,'CONFIGURA��ES DO CART�O')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'CONFIGURA��ES DO CART�O')]")
    private MobileElement botaoConfiguracoesCartao;

    //N�o possui mapeamento iOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/visa_logo")
    private MobileElement logoVisa;

    public CartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao 'Recebi o cart�o'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Recebi o cart�o'")
    public CartaoTela tocarRecebiCartao() throws Exception {
        salvarEvidencia("Tocar no botao 'Recebi o cart�o'");
        tocarElemento(botaoRecebiCartao, "N�o foi poss�vel tocar no bot�o 'Recebi o cart�o'");
        return this;
    }

    /**
     * Validar tela "CART�O"
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar t�tulo da tela: 'CART�O'")
    public CartaoTela validarTituloTela() {
        validarCondicaoBooleana(
                aguardarCarregamentoElemento(tituloTela),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar o t�tulo da tela de confirma��o de recebimento do cart�o"
        );
        salvarEvidencia("Validado o t�tulo da tela de confirma��o de recebimento de cart�o");
        return this;
    }

    /**
     * Validar mensagens na tela de recebimento do cart�o enviado ao cliente
     *
     * @param mensagens
     * @return CartaoTela
     */
    @Step("Validar p�gina conter aviso de indisponibilidade do sistema")
    public CartaoTela validarMensagensTela(String... mensagens) {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(mensagens),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar todas as mensagens presentes na tela"
        );
        salvarEvidencia("Validadas as mensagens na tela de recebimento do cart�o");
        return this;
    }

    /**
     * Validar que cart�o � do tipo correto 'd�bito ou cr�dito'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar tipo do cart�o 'D�bito ou Cr�dito'")
    public CartaoTela validarTipoCartao(String... textosTipoCartao) throws Exception {
        if (android) {
            rolarTelaParaCimaAosPoucosAteEncontrarElemento(logoVisa, "N�o foi poss�vel localizar o elemento logo visa");
        }
        validarCondicaoBooleana(
                !aguardarPaginaConterQualquerTexto(textosTipoCartao).isEmpty(),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar o tipo de cart�o procurado"
        );
        salvarEvidencia("Validado tipo do cart�o com texto na p�gina");
        return this;
    }

    /**
     * Validar presen�a do bot�o 'PEDIR CART�O DE CR�DITO'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar presen�a do bot�o 'PEDIR CART�O DE CR�DITO'")
    public CartaoTela validarBotaoPedirCartaoCredito() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPedirCartaoCredito,
                "Bot�o 'PAGAMENTOS DIGITAIS' n�o encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoPedirCartaoCredito),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presen�a do bot�o 'PEDIR CART�O DE CR�DITO'");
        return this;
    }

    /**
     * Validar presen�a do bot�o PAGAMENTOS DIGITAIS
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar presen�a do bot�o 'PAGAMENTOS DIGITAIS'")
    public CartaoTela validarPresencaBotaoPagamentosDigitais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagamentosDigitais,
                "Bot�o 'PAGAMENTOS DIGITAIS' n�o encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoPagamentosDigitais),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presen�a do bot�o 'PAGAMENTOS DIGITAIS'");
        return this;
    }


    /**
     * Validar presen�a do bot�o 'CANCELAR CART�O'
     */
    @Step("Validar presen�a do bot�o 'CANCELAR CART�O'")
    public CartaoTela validarPresencaBotaoCancelarCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCancelarCartao,
                "Bot�o 'CANCELAR CART�O' n�o encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoCancelarCartao),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presen�a do bot�o 'CANCELAR CART�O'");
        return this;
    }

    /**
     * Validar presen�a do bot�o 'PEDIR CART�O DE CR�DITO'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar presen�a do bot�o 'SERVI�OS DO CART�O'")
    public CartaoTela validarPresencaBotaoServicosCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoServicosCartao,
                "Bot�o 'SERVI�OS DO CART�O' n�o encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoServicosCartao),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presen�a do bot�o 'SERVI�OS DO CART�O'");
        return this;
    }

    /**
     * Validar presen�a do bot�o 'PEDIR CART�O DE CR�DITO'
     *
     * @return CartaoTela
     * @throws Exception
     */
    @Step("Validar presen�a do bot�o 'CONFIGURA��ES DO CART�O'")
    public CartaoTela validarPresencaBotaoConfiguracoesCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesCartao,
                "Bot�o 'CONFIGURA��ES DO CART�O' n�o encontrado.");
        validarCondicaoBooleana(
                verificarPresencaElemento(botaoConfiguracoesCartao),
                MetodoComparacaoBooleano.VERDADEIRO,
                ""
        );
        salvarEvidencia("Validada a presen�a do bot�o 'CONFIGURA��ES DO CART�O'");
        return this;
    }

}
