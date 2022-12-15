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
    // Título da tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO CRÉDITO\"]")
    private MobileElement headerTituloTelaSaibaMaisInfoParceiro;

    // botão VOLTAR da tela TERMOS E CONDIÇÕES
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Voltar']")
    private MobileElement btnVoltarTelaSaibaMaisInfoParceiro;
    /*     *************************     */

    /*
    Método para Valida tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO
    */
    @Step("Valida tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO")
    public InformacoesParceiroCreditoTela validaTelaSaibaMaisInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaSaibaMaisInfoParceiro);
        compararElementoTexto(headerTituloTelaSaibaMaisInfoParceiro, SegurosCredito.TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar da tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO
    */
    @Step("Tocar no ícone (<) voltar da tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO")
    public InformacoesParceiroCreditoTela tocarBtnVoltarTelaInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        salvarEvidencia("Tocar no ícone (<) voltar da tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO");
        tocarElemento(btnVoltarTelaSaibaMaisInfoParceiro, "Não foi possível tocar no ícone (<) voltar da tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO.");
        return this;
    }
}
