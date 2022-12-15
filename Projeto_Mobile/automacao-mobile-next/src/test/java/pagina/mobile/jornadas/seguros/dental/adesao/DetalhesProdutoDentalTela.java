package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DetalhesProdutoDentalTela extends PaginaBase {

    public DetalhesProdutoDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela DETALHES DO PRODUTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ATIVAÇÃO E CARÊNCIA\"]")
    private MobileElement headerTituloDetalhesProduto;

    // botão VOLTAR da tela DETALHES DO PRODUTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaDetalhesPlano;
    /*     *************************     */

    /*
    Método para Valida tela DETALHES DO PRODUTO
     */
    @Step("Valida tela DETALHES DO PRODUTO")
    public DetalhesProdutoDentalTela validaTelaDetalhesPlano() throws Exception {
        aguardarCarregamentoElemento(headerTituloDetalhesProduto);
        compararElementoTexto(headerTituloDetalhesProduto, SegurosDental.TITULO_TELA_DETALHES_PRODUTO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela DETALHES DO PRODUTO");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar
     */
    @Step("Tocar no ícone (<) voltar")
    public DetalhesProdutoDentalTela tocarBtnVoltarTelaDetalhesPlano() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaDetalhesPlano);
        salvarEvidencia("Tocar no ícone (<) voltar.");
        tocarElemento(btnVoltarTelaDetalhesPlano, "Não foi possível tocar no ícone (<) voltar da tela DETALHES DO PRODUTO.");
        return this;
    }
}
