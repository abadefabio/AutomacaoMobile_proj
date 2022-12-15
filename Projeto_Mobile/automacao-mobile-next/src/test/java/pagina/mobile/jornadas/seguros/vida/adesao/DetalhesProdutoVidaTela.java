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
    // T�tulo da tela DETALHES INDENIZA��O
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO DE VIDA\"]")
    private MobileElement headerTituloDetalhesIndenizacao;

    // �cone (<) voltar
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaDetalhesIndenizacao;
    /*     *************************     */

    /*
    M�todo para Valida tela DETALHES INDENIZA��O
     */
    @Step("Valida tela DETALHES INDENIZA��O")
    public DetalhesProdutoVidaTela validaTelaDetalhesIndenizacao() throws Exception {
        aguardarCarregamentoElemento(headerTituloDetalhesIndenizacao);
        compararElementoTexto(headerTituloDetalhesIndenizacao, SegurosVida.TITULO_TELA_DETALHES_INDENIZACAO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela DETALHES INDENIZA��O");
        return this;
    }
    /*
    M�todo para Tocar no �cone (<) voltar
     */
    @Step("Tocar no �cone (<) voltar")
    public DetalhesProdutoVidaTela tocarBtnVoltarTelaDetalhesIndenizacao() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaDetalhesIndenizacao);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(btnVoltarTelaDetalhesIndenizacao, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }
}
