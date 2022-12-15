package pagina.mobile.jornadas.objetivos.aporte;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class AplicacaoCanceladaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]/following-sibling::XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement tituloTelaAplicacaoCancelada;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_contribution_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/../following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[contains(@value, 'R$')]")
    private MobileElement campoValor;

    @AndroidFindBy(id = "br.com.bradesco.next:id/view_goals")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Ver Objetivo\"])[1]")
    private MobileElement botaoVerObjetivos;

    public AplicacaoCanceladaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar titulo 'APLICAÇÃO CANCELADA'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar titulo 'APLICAÇÃO CANCELADA'")
    public AplicacaoCanceladaTela validarTituloTelaAplicacaoCancelada(String tituloTela) throws Exception {
        salvarEvidencia("Validado título tela de aplicação cancelada igual a: " + tituloTela);
        validarAtributoTexto(tituloTelaAplicacaoCancelada, tituloTela, "Não foi possível validar o título da tela de aplicação cancelada!");
        return this;
    }

    /**
     * Validar valor aporte
     *
     * @return
     * @throws Exception
     */
    @Step("Validar valor aporte")
    public AplicacaoCanceladaTela validarValorAporte(String valor) throws Exception {
        salvarEvidencia("Validado valor aporte igual a: " + valor);
        validarAtributoTexto(campoValor, valor, "Não foi possível validar o campo valor!.");
        return this;
    }

    /**
     * Tocar no botão Ver Objetivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Ver Objetivos")
    public AplicacaoCanceladaTela tocarBotaoVerObjetivos() throws Exception {
        salvarEvidencia("Tocar no botão 'Ver Objetivos'");
        tocarElemento(botaoVerObjetivos,"Não foi possível tocar no botão 'Ver Objetivos'");
        return this;
    }
}
