package pagina.mobile.jornadas.objetivos.aporte;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class EditarAplicacaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]/following-sibling::XCUIElementTypeStaticText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]/following-sibling::XCUIElementTypeOther")
    private MobileElement tituloTela;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_amount")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement campoValor;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_remove")
    @iOSXCUITFindBy(accessibility = "Remover")
    private MobileElement botaoLixeira;

    public EditarAplicacaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar titulo tela edição aporte
     *
     * @return
     * @throws Exception
     */
    @Step("Validar titulo tela edição aporte")
    public EditarAplicacaoTela validarTituloTelaEdicaoAporte(String tituloObjetivo) throws Exception {
        salvarEvidencia("Validado título tela de edição igual a: " + tituloObjetivo);
        validarAtributoTexto(tituloTela, tituloObjetivo, "Não foi possível validar o título da tela de edição de aporte!");
        return this;
    }

    /**
     * Validar valor aporte
     *
     * @return
     * @throws Exception
     */
    @Step("Validar valor aporte")
    public EditarAplicacaoTela validarValorAporte(String valor) throws Exception {
        salvarEvidencia("Validado valor aporte igual a: " + valor);
        validarAtributoTexto(campoValor, valor, "Não foi possível validar o campo valor!.");
        return this;
    }

    /**
     * Tocar no botão excluir, lixeira
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão excluir, lixeira")
    public EditarAplicacaoTela tocarBotaoLixeira() throws Exception {
        salvarEvidencia("Tocar no botão excluir, lixeira");
        tocarElemento(botaoLixeira,"Não foi possível tocar no botão excluir, lixeira");
        return this;
    }
}
