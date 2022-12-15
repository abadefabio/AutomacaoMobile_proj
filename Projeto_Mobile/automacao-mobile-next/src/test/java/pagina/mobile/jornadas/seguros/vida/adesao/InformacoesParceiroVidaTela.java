package pagina.mobile.jornadas.seguros.vida.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacoesParceiroVidaTela extends PaginaBase {

    public InformacoesParceiroVidaTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela SAIBA MAIS INFO PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO DE VIDA\"]")
    private MobileElement headerTituloTelaSaibaMaisInfoParceiro;

    // botão VOLTAR da tela SAIBA MAIS INFO PARCEIRO
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaSaibaMaisInfoParceiro;
    /*     *************************     */

    /*
    Método para Valida tela SAIBA MAIS INFO PARCEIRO
     */
    @Step("Valida tela SAIBA MAIS INFO PARCEIRO")
    public InformacoesParceiroVidaTela validaTelaSaibaMaisInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaSaibaMaisInfoParceiro);
        compararElementoTexto(headerTituloTelaSaibaMaisInfoParceiro, SegurosResidencial.TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SAIBA MAIS INFO PARCEIRO");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar
     */
    @Step("Tocar no ícone (<) voltar")
    public InformacoesParceiroVidaTela tocarBtnVoltarTelaSaibaMaisInfoParceiro() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaSaibaMaisInfoParceiro);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(btnVoltarTelaSaibaMaisInfoParceiro, "Não foi possível tocar no ícone (<) voltar.");
        return this;
    }
}
