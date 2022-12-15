package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacoesParceiroDentalTela extends PaginaBase {

    public InformacoesParceiroDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela SAIBA MAIS INFORMA��ES DO PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PLANO DENTAL\"]")
    private MobileElement headerTituloTelaSaibaMaisParceiro;

    // bot�o VOLTAR da tela TERMOS E CONDI��ES
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaSaibaMaisInfoParceiro;
    /*     *************************     */

    /*
    M�todo para Valida tela SAIBA MAIS INFORMA��ES DO PARCEIRO
     */
    @Step("Valida tela SAIBA MAIS INFORMA��ES DO PARCEIRO")
    public InformacoesParceiroDentalTela validaTelaInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        compararElementoTexto(btnVoltarTelaSaibaMaisInfoParceiro, SegurosDental.TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SAIBA MAIS INFORMA��ES DO PARCEIRO");
        return this;
    }
    /*
    M�todo para Tocar no �cone (<) voltar
     */
    @Step("Tocar no �cone (<) voltar")
    public InformacoesParceiroDentalTela tocarBtnVoltarTelaInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(btnVoltarTelaSaibaMaisInfoParceiro, "N�o foi poss�vel tocar no �cone (<) voltar.");
        return this;
    }
}
