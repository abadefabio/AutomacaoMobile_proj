package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDebito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacoesParceiroDebitoTela extends PaginaBase {

    public InformacoesParceiroDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela SAIBA MAIS INFORMA��ES PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO D�BITO\"]")
    private MobileElement headerTituloTelaSaibaMaisInfoParceiro;

    // bot�o VOLTAR da tela SAIBA MAIS INFORMA��ES PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "\t//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaSaibaMaisInfoParceiro;
    /*     *************************     */

    /*
    M�todo para Valida tela SAIBA MAIS INFORMA��ES PARCEIRO
    */
    @Step("Valida tela SAIBA MAIS INFORMA��ES PARCEIRO")
    public InformacoesParceiroDebitoTela validaTelaSaibaMaisInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaSaibaMaisInfoParceiro);
        compararElementoTexto(headerTituloTelaSaibaMaisInfoParceiro, SegurosDebito.TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SAIBA MAIS INFORMA��ES PARCEIRO");
        return this;
    }
    /*
    M�todo para Tocar no �cone (<) voltar
    */
    @Step("Tocar no �cone (<) voltar")
    public InformacoesParceiroDebitoTela tocarBtnVoltarTelaInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(btnVoltarTelaSaibaMaisInfoParceiro, "N�o foi poss�vel tocar no �cone (<) voltar.");
        return this;
    }
}
