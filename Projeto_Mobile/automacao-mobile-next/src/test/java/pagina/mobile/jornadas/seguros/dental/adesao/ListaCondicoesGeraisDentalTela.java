package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ListaCondicoesGeraisDentalTela extends PaginaBase {

    public ListaCondicoesGeraisDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela LISTA CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TERMOS E CONDIÇÕES\"]")
    private MobileElement headerTituloListaCondicoesGerais;

    // botão VIZUALIZAR CONDICAO
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_item_term_iv_arrow")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
    private MobileElement btnVisializarCondicoesGerais;

    // botão FECHAR da tela LISTA CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement btnFecharTelaListaCondicoesGerais;
    /*     *************************     */

    /*
    Método para Valida tela LISTA CONDIÇÕES GERAIS
     */
    @Step("Valida tela LISTA CONDIÇÕES GERAIS")
    public ListaCondicoesGeraisDentalTela validaTelaListaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(headerTituloListaCondicoesGerais);
        compararElementoTexto(headerTituloListaCondicoesGerais, SegurosDental.TITULO_TELA_LISTA_CONDICOES_GERAIS, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela LISTA CONDIÇÕES GERAIS");
        return this;
    }
    /*
    Método para Tocar no ícone (>) na condição de preferência
     */
    @Step("Tocar no ícone (>) na condição de preferência")
    public ListaCondicoesGeraisDentalTela visualizarCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(btnVisializarCondicoesGerais);
        salvarEvidencia("Tocar no ícone (>) na CONDIÇÃO de preferência");
        tocarElemento(btnVisializarCondicoesGerais, "Não foi possível tocar no ícone (>) na CONDIÇÃO de preferência");
        return this;
    }
    /*
    Método para Tocar no ícone (X) fechar
     */
    @Step("Tocar no ícone (X) fechar")
    public ListaCondicoesGeraisDentalTela tocarBtnFecharTelaListaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(btnFecharTelaListaCondicoesGerais);
        salvarEvidencia("Tocar no ícone (X) fechar");
        tocarElemento(btnFecharTelaListaCondicoesGerais, "Não foi possível tocar no ícone (X) fechar");
        return this;
    }
}
