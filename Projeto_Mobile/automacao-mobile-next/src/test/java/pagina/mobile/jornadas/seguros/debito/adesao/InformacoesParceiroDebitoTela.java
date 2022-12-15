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
    // Título da tela SAIBA MAIS INFORMAÇÕES PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO DÉBITO\"]")
    private MobileElement headerTituloTelaSaibaMaisInfoParceiro;

    // botão VOLTAR da tela SAIBA MAIS INFORMAÇÕES PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "\t//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaSaibaMaisInfoParceiro;
    /*     *************************     */

    /*
    Método para Valida tela SAIBA MAIS INFORMAÇÕES PARCEIRO
    */
    @Step("Valida tela SAIBA MAIS INFORMAÇÕES PARCEIRO")
    public InformacoesParceiroDebitoTela validaTelaSaibaMaisInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaSaibaMaisInfoParceiro);
        compararElementoTexto(headerTituloTelaSaibaMaisInfoParceiro, SegurosDebito.TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SAIBA MAIS INFORMAÇÕES PARCEIRO");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar
    */
    @Step("Tocar no ícone (<) voltar")
    public InformacoesParceiroDebitoTela tocarBtnVoltarTelaInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(btnVoltarTelaSaibaMaisInfoParceiro, "Não foi possível tocar no ícone (<) voltar.");
        return this;
    }
}
