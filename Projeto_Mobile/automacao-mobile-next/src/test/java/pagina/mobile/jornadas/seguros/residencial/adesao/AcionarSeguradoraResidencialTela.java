package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AcionarSeguradoraResidencialTela extends PaginaBase {

    public AcionarSeguradoraResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela ACIONAR SEGURADORA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO RESIDENCIAL\"]")
    private MobileElement headerTituloTelaAcionarSeguradora;

    // botão VOLTAR da tela ACIONAR SEGURADORA
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]\n")
    private MobileElement botaoVoltarAcionarSeguradora;

    /**
     * Método para validar a tela ACIONAR SEGURADORA do produto RESIDENCIAL
     * @return AcionarSeguradoraResidencialTela
     * @throws Exception
     */
    @Step("Valida tela ACIONAR SEGURADORA")
    public AcionarSeguradoraResidencialTela validarTelaAcionarSeguradora() throws Exception {
        aguardarPaginaConterTodosTextos("11 3003 1022", "4004 2757", "0800 701 2757", "0800 727 9966");
        salvarEvidencia("Validar Tela Acionar Seguradora - RESIDENCIAL");
        return this;
    }
    /**
     * Método para Tocar no ícone (<) voltar
     * @throws Exception
     * @return AcionarSeguradoraResidencialTela
     */
    @Step("Tocar no ícone (<) voltar")
    public AcionarSeguradoraResidencialTela tocarBotaoVoltarTelaAcionarSeguradora() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarAcionarSeguradora);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarAcionarSeguradora, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
