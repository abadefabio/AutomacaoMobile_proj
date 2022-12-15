package pagina.mobile.jornadas.objetivos.cancelamento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.objetivos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class ConfirmarCancelamentoTela extends PaginaBase {

    // botao Confirmar Cancelamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_confirm_contribution")
    @iOSXCUITFindBy(accessibility = "Confirmar cancelamento")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar cancelamento\"]")
    private MobileElement botaoConfirmarCancelamento;

    // botao Voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Titulo da tela
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"CONFIRMAR CANCELAMENTO\"]")
    private MobileElement textoTituloTela;

    // mensagem conferir cancelamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Confere se\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Confere se tá tudo certo com seu cancelamento\"]")
    private MobileElement mensagemConferirCancelamento;

    // nome do Objetivo - cancelamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_goal_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"fr\"]")
    private MobileElement nomeObjetivo;

    // valor do Objetivo - cancelamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"R$ 0,00\"]")
    private MobileElement valorObjetivo;

    // data resgate - cancelamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"04/08/2021\"]")
    private MobileElement dataResgate;

    // nome do produto - cancelamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_product_name")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeStaticText[@name=\"next Simples\"]")
    private MobileElement produto;

    public ConfirmarCancelamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no botão Confirmar Cancelamento
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Confirmar Cancelamento\"")
    public ConfirmarCancelamentoTela tocarBotaoConfirmarCancelamento() throws Exception {
        salvarEvidencia("Tocar no botão 'botão Confirmar Cancelamento'");
        tocarElemento(botaoConfirmarCancelamento, "Não foi possível tocar no botão Confirmar Cancelamento");
        return this;
    }

    /**
     * Tocar no botão voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public ConfirmarCancelamentoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar no botão 'botão Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão Voltar");
        return this;
    }

    /**
     * validar "Titulo Tela" - Confirmar Cancelamento
     *
     * @return
     * @throws Exception
     */
    @Step("validar  \"Titulo Tela\"")
    public ConfirmarCancelamentoTela validarTituloTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CONFIRMAR_CANCELAMENTO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Objetivos' não está presente na tela!");
        salvarEvidencia("'validar Titulo Tela - Confirmar Cancelamento");
        return this;
    }

    /**
     * validar "Mensagem Conferir Cancelamento"
     *
     * @return
     * @throws Exception
     */
    @Step("validar  \"Mensagem Conferir Cancelamento\"")
    public ConfirmarCancelamentoTela validarMensagemConferirCancelamento() throws Exception {
        validarCondicaoBooleana( verificarPresencaElemento(mensagemConferirCancelamento), MetodoComparacaoBooleano.VERDADEIRO, "erro ao validar Mensagem Conferir Cancelamento");
        salvarEvidencia("'validar Mensagem Conferir Cancelamento");
        return this;
    }


}
