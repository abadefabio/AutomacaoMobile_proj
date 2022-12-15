package pagina.mobile.jornadas.objetivos.cancelamento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.objetivos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class ObjetivoCanceladoTela extends PaginaBase {

    // Titulo da tela
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"OBJETIVO CANCELADO\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"OBJETIVO CANCELADO\"]")
    private MobileElement textoTituloTela;

    // botao fechar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Fechar, Botão")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    // mensagem resgate feito em tal data
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_contribution_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Seu resgate foi feito em\")]")
    private MobileElement mensagemResgateFeitoEm;

    // botao ver meus objetivos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/view_goals")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver meus objetivos\"`][2]")
    private MobileElement botaoVerMeusObjetivos;

    // valor resgate
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_contribution_value")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Valor \"]")
    private MobileElement valorResgate;

    // texto sobre resgate
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_confirmation_type_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Sobre o resgate\"]")
    private MobileElement textoSobreResgate;

    // texto Ele só acontece em dias úteis, das 8h as 17h.
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_hour_info")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Ele só acontece em dias úteis, das 8h as 21h.\"])[2]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ele só acontece em dias úteis, das 8h as 17h.\"]")
    private MobileElement textoSoAconteceDiasUteis;

    public ObjetivoCanceladoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar no botão Fechar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public ObjetivoCanceladoTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("Tocar no botão 'botão Fechar'");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão Fechar");
        return this;
    }

    /**
     * Tocar no botão Ver Meus Objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Ver Meus Objetivos\"")
    public ObjetivoCanceladoTela tocarBotaoVerMeusObjetivos() throws Exception {
        salvarEvidencia("Tocar no botão 'botão Ver Meus Objetivos'");
        tocarElemento(botaoVerMeusObjetivos, "Não foi possível tocar no botão Ver Meus Objetivos");
        return this;
    }

    /**
     * validar "Titulo Tela" - Confirmar Cancelamento
     *
     * @return
     * @throws Exception
     */
    @Step("validar  \"Titulo Tela\"")
    public ObjetivoCanceladoTela validarTituloTela() throws Exception {
        aguardarCarregamentoElemento(textoTituloTela);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.OBJETIVO_CANCELADO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Objetivo Cancelado' não está presente na tela!");
        salvarEvidencia("'validar Titulo Tela - Objetivo Cancelado");
        return this;
    }

    /**
     * validar "Mensagem Resgate Feito Em"
     *
     * @return
     * @throws Exception
     */
    @Step("validar  \"Mensagem Resgate Feito Em\"")
    public ObjetivoCanceladoTela validarMensagemResgateFeitoEm() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.RESGATE_FEITO_EM.toString()), MetodoComparacaoBooleano.VERDADEIRO, "validar Mensagem Conferir Cancelamento - não está presente na tela!");
        salvarEvidencia("'validar Mensagem - Resgate feito em ..");
        return this;
    }

    /**
     * validar "texto Sobre Resgate"
     *
     * @return
     * @throws Exception
     */
    @Step("validar  \"Mensagem Sobre Resgate\"")
    public ObjetivoCanceladoTela validartextoSobreResgate() throws Exception {
        rolarTelaAteFinal();
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SOBRE_RESGATE.toString()), MetodoComparacaoBooleano.VERDADEIRO, "erro ao validar texto sobre o resgate");
        salvarEvidencia("'validar texto em tela 'Sobre o Resgate");
        return this;
    }

    /**
     * validar "texto So Acontece Dias Uteis"
     *
     * @return
     * @throws Exception
     */
    @Step("validar  \"Texto So Acontece Dias Uteis\"")
    public ObjetivoCanceladoTela validartextoSoAconteceDiasUteis(String textoDiasUteis) throws Exception {
        salvarEvidencia("'validar texto em tela - 'So Acontece Dias Uteis'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(textoDiasUteis),MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível encontrar o texto 'So Acontece Dias Uteis' na tela");
        return this;
    }


}
