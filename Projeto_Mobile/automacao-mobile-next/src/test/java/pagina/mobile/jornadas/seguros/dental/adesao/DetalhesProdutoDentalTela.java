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
    // T�tulo da tela DETALHES DO PRODUTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ATIVA��O E CAR�NCIA\"]")
    private MobileElement headerTituloDetalhesProduto;

    // bot�o VOLTAR da tela DETALHES DO PRODUTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaDetalhesPlano;
    /*     *************************     */

    /*
    M�todo para Valida tela DETALHES DO PRODUTO
     */
    @Step("Valida tela DETALHES DO PRODUTO")
    public DetalhesProdutoDentalTela validaTelaDetalhesPlano() throws Exception {
        aguardarCarregamentoElemento(headerTituloDetalhesProduto);
        compararElementoTexto(headerTituloDetalhesProduto, SegurosDental.TITULO_TELA_DETALHES_PRODUTO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela DETALHES DO PRODUTO");
        return this;
    }
    /*
    M�todo para Tocar no �cone (<) voltar
     */
    @Step("Tocar no �cone (<) voltar")
    public DetalhesProdutoDentalTela tocarBtnVoltarTelaDetalhesPlano() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaDetalhesPlano);
        salvarEvidencia("Tocar no �cone (<) voltar.");
        tocarElemento(btnVoltarTelaDetalhesPlano, "N�o foi poss�vel tocar no �cone (<) voltar da tela DETALHES DO PRODUTO.");
        return this;
    }
}
