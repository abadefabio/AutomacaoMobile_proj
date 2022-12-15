package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CondicoesGeraisDentalTela extends PaginaBase {

    public CondicoesGeraisDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDIÇÕES GERAIS\"]")
    private MobileElement headerTituloTelaCondicoesGerais;

    // botão VOLTAR da tela CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarTelaCondicoesGerais;

    /**
     * Método para Valida tela CONDIÇÕES GERAIS
     * @return CondicoesGeraisDentalTela
     * @throws Exception
     */
    @Step("Validar tela CONDIÇÕES GERAIS")
    public CondicoesGeraisDentalTela validaTelaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaCondicoesGerais);
        compararElementoTexto(headerTituloTelaCondicoesGerais, SegurosDental.TITULO_TELA_CONDICOES_GERAIS, MetodoComparacao.IGUAL);
        salvarEvidencia("validar Tela CONDIÇÕES GERAIS");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     * @return
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public CondicoesGeraisDentalTela tocarBotaoVoltarTelaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarTelaCondicoesGerais);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarTelaCondicoesGerais, "Não foi possível clicar no ícone (<) voltar");
        return this;
    }
}
