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
    // Título da tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PLANO DENTAL\"]")
    private MobileElement headerTituloTelaSaibaMaisParceiro;

    // botão VOLTAR da tela TERMOS E CONDIÇÕES
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaSaibaMaisInfoParceiro;
    /*     *************************     */

    /*
    Método para Valida tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO
     */
    @Step("Valida tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO")
    public InformacoesParceiroDentalTela validaTelaInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        compararElementoTexto(btnVoltarTelaSaibaMaisInfoParceiro, SegurosDental.TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SAIBA MAIS INFORMAÇÕES DO PARCEIRO");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar
     */
    @Step("Tocar no ícone (<) voltar")
    public InformacoesParceiroDentalTela tocarBtnVoltarTelaInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(btnVoltarTelaSaibaMaisInfoParceiro, "Não foi possível tocar no ícone (<) voltar.");
        return this;
    }
}
