package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDebito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CondicoesGeraisDebitoTela extends PaginaBase {

    public CondicoesGeraisDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDIÇÕES GERAIS\"]")
    private MobileElement headerTituloTelaCondicoesGerais;

    // botão VOLTAR da tela CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement btnVoltarTelaCondicoesGerais;
    /*     *************************     */

    /*
    Método para Valida tela CONDIÇÕES GERAIS
    */
    @Step("Valida tela CONDIÇÕES GERAIS")
    public CondicoesGeraisDebitoTela validaTelaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaCondicoesGerais);
        compararElementoTexto(headerTituloTelaCondicoesGerais, SegurosDebito.TITULO_TELA_CONDICOES_GERAIS, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela CONDIÇÕES GERAIS");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar
    */
    @Step("Tocar no ícone (<) voltar")
    public CondicoesGeraisDebitoTela tocarBtnVoltarTelaTermoCondicoes() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaCondicoesGerais);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(btnVoltarTelaCondicoesGerais, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
