package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ListaCondicoesGeraisResidencialTela extends PaginaBase {

    public ListaCondicoesGeraisResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela LISTA DE CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDIÇÕES GERAIS\"]")
    private MobileElement headerTituloListaCondicoesGerais;

    // botão FECHAR da tela LISTA DE CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement btnFecharTelaListaCondicoesGerais;

    // botão VIZUALIZAR CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_item_term_iv_arrow")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    private MobileElement btnVisualizarCondicoesGerais;
    /*     *************************     */

    /*
    Método para Valida tela LISTA DE CONDIÇÕES GERAIS
     */
    @Step("Valida tela LISTA DE CONDIÇÕES GERAIS")
    public ListaCondicoesGeraisResidencialTela validaTelaListaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(headerTituloListaCondicoesGerais);
        compararElementoTexto(headerTituloListaCondicoesGerais, SegurosResidencial.TITULO_TELA_LISTA_CONDICOES_GERAIS, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela LISTA DE CONDIÇÕES GERAIS");
        return this;
    }
    /*
    Método para Tocar no ícone (>) na condição de preferência
     */
    @Step("Tocar no ícone (>) na condição de preferência")
    public ListaCondicoesGeraisResidencialTela visualizarCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(btnVisualizarCondicoesGerais);
        salvarEvidencia("Tocar no ícone (>) na condição de preferência");
        tocarElemento(btnVisualizarCondicoesGerais, "Não foi possível tocar no ícone (>) na condição de preferência");
        return this;
    }
    /*
    Método para Tocar no ícone (X) fechar
     */
    @Step("Tocar no ícone (X) fechar")
    public ListaCondicoesGeraisResidencialTela tocarBtnFecharTelaListaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(btnFecharTelaListaCondicoesGerais);
        salvarEvidencia("Tocar no ícone (X) fechar");
        tocarElemento(btnFecharTelaListaCondicoesGerais, "Não foi possível tocar no ícone (X) fechar");
        return this;
    }
}
