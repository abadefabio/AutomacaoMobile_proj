package pagina.mobile.jornadas.seguros.vida.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosVida;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DetalhesProdutoVidaTela extends PaginaBase {

    public DetalhesProdutoVidaTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela DETALHES INDENIZAÇÃO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO DE VIDA\"]")
    private MobileElement headerTituloDetalhesIndenizacao;

    // ícone (<) voltar
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaDetalhesIndenizacao;
    /*     *************************     */

    /*
    Método para Valida tela DETALHES INDENIZAÇÃO
     */
    @Step("Valida tela DETALHES INDENIZAÇÃO")
    public DetalhesProdutoVidaTela validaTelaDetalhesIndenizacao() throws Exception {
        aguardarCarregamentoElemento(headerTituloDetalhesIndenizacao);
        compararElementoTexto(headerTituloDetalhesIndenizacao, SegurosVida.TITULO_TELA_DETALHES_INDENIZACAO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela DETALHES INDENIZAÇÃO");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar
     */
    @Step("Tocar no ícone (<) voltar")
    public DetalhesProdutoVidaTela tocarBtnVoltarTelaDetalhesIndenizacao() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaDetalhesIndenizacao);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(btnVoltarTelaDetalhesIndenizacao, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
