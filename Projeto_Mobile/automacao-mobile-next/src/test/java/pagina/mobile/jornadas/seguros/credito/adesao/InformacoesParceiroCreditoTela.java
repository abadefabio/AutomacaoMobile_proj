package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosCredito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacoesParceiroCreditoTela extends PaginaBase {

    public InformacoesParceiroCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela SAIBA MAIS INFORMA��ES DO PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO CR�DITO\"]")
    private MobileElement headerTituloTelaSaibaMaisInfoParceiro;

    // bot�o VOLTAR da tela TERMOS E CONDI��ES
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Voltar']")
    private MobileElement btnVoltarTelaSaibaMaisInfoParceiro;
    /*     *************************     */

    /*
    M�todo para Valida tela SAIBA MAIS INFORMA��ES DO PARCEIRO
    */
    @Step("Valida tela SAIBA MAIS INFORMA��ES DO PARCEIRO")
    public InformacoesParceiroCreditoTela validaTelaSaibaMaisInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaSaibaMaisInfoParceiro);
        compararElementoTexto(headerTituloTelaSaibaMaisInfoParceiro, SegurosCredito.TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SAIBA MAIS INFORMA��ES DO PARCEIRO");
        return this;
    }
    /*
    M�todo para Tocar no �cone (<) voltar da tela SAIBA MAIS INFORMA��ES DO PARCEIRO
    */
    @Step("Tocar no �cone (<) voltar da tela SAIBA MAIS INFORMA��ES DO PARCEIRO")
    public InformacoesParceiroCreditoTela tocarBtnVoltarTelaInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        salvarEvidencia("Tocar no �cone (<) voltar da tela SAIBA MAIS INFORMA��ES DO PARCEIRO");
        tocarElemento(btnVoltarTelaSaibaMaisInfoParceiro, "N�o foi poss�vel tocar no �cone (<) voltar da tela SAIBA MAIS INFORMA��ES DO PARCEIRO.");
        return this;
    }
}
