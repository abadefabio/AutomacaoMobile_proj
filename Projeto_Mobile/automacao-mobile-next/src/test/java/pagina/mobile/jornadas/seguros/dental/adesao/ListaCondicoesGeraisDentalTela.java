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
    // T�tulo da tela LISTA CONDI��ES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TERMOS E CONDI��ES\"]")
    private MobileElement headerTituloListaCondicoesGerais;

    // bot�o VIZUALIZAR CONDICAO
    @AndroidFindBy(id = "br.com.bradesco.next:id/protection_item_term_iv_arrow")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
    private MobileElement btnVisializarCondicoesGerais;

    // bot�o FECHAR da tela LISTA CONDI��ES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement btnFecharTelaListaCondicoesGerais;
    /*     *************************     */

    /*
    M�todo para Valida tela LISTA CONDI��ES GERAIS
     */
    @Step("Valida tela LISTA CONDI��ES GERAIS")
    public ListaCondicoesGeraisDentalTela validaTelaListaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(headerTituloListaCondicoesGerais);
        compararElementoTexto(headerTituloListaCondicoesGerais, SegurosDental.TITULO_TELA_LISTA_CONDICOES_GERAIS, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela LISTA CONDI��ES GERAIS");
        return this;
    }
    /*
    M�todo para Tocar no �cone (>) na condi��o de prefer�ncia
     */
    @Step("Tocar no �cone (>) na condi��o de prefer�ncia")
    public ListaCondicoesGeraisDentalTela visualizarCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(btnVisializarCondicoesGerais);
        salvarEvidencia("Tocar no �cone (>) na CONDI��O de prefer�ncia");
        tocarElemento(btnVisializarCondicoesGerais, "N�o foi poss�vel tocar no �cone (>) na CONDI��O de prefer�ncia");
        return this;
    }
    /*
    M�todo para Tocar no �cone (X) fechar
     */
    @Step("Tocar no �cone (X) fechar")
    public ListaCondicoesGeraisDentalTela tocarBtnFecharTelaListaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(btnFecharTelaListaCondicoesGerais);
        salvarEvidencia("Tocar no �cone (X) fechar");
        tocarElemento(btnFecharTelaListaCondicoesGerais, "N�o foi poss�vel tocar no �cone (X) fechar");
        return this;
    }
}
