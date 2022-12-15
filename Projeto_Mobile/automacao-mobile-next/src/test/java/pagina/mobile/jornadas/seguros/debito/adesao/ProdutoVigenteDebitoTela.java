package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDebito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutoVigenteDebitoTela extends PaginaBase {

    public ProdutoVigenteDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela PRODUTO VIGENTE
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloTelaProdutoVigente;

    // botão VOLTAR da tela PRODUTO VIGENTE
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaProdutoVigente;
    /*     *************************     */

    /*
    Método para Valida tela PRODUTO VIGENTE
    */
    @Step("Valida tela PRODUTO VIGENTE")
    public ProdutoVigenteDebitoTela validaTelaProdutoVigente() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaProdutoVigente);
        compararElementoTexto(headerTituloTelaProdutoVigente, SegurosDebito.TITULO_PRODUTO_VIGENTE, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela PRODUTO VIGENTE");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar da telas PRODUTO VIGENTE
    */
    @Step("Tocar no ícone (<) voltar da telas PRODUTO VIGENTE")
    public ProdutoVigenteDebitoTela tocarBtnVoltarTelaProdutoVigente() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaProdutoVigente);
        salvarEvidencia("Tocar no ícone (<) voltar da telas PRODUTO VIGENTE");
        tocarElemento(btnVoltarTelaProdutoVigente, "Não foi possível tocar no ícone (<) voltar da telas PRODUTO VIGENTE.");
        return this;
    }
}
