package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosCredito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ListaCondicoesGeraisCreditoTela extends PaginaBase {

    public ListaCondicoesGeraisCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela LISTA DE CONDI��ES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDI��ES GERAIS\"]")
    private MobileElement headerTituloListaCondicoesGerais;

    // bot�o FECHAR da tela LISTA DE CONDI��ES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Fechar']")
    private MobileElement btnFecharTelaListaCondicoesGerais;

    // bot�o VIZUALIZAR TERMO
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    private MobileElement btnVisualizarCondicoesGerais;
    /*     *************************     */

    /*
    M�todo para Valida tela LISTA DE CONDI��ES GERAIS
    */
    @Step("Valida tela LISTA DE CONDI��ES GERAIS")
    public ListaCondicoesGeraisCreditoTela validaTelaListaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(headerTituloListaCondicoesGerais);
        compararElementoTexto(headerTituloListaCondicoesGerais, SegurosCredito.TITULO_TELA_LISTA_CONDICOES_GERAIS, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela LISTA DE CONDI��ES GERAIS");
        return this;
    }
    /*
    M�todo para Tocar no �cone (>) na Condi��o Geral de prefer�ncia
    */
    @Step("Tocar no �cone (>) na Condi��o Geral de prefer�ncia")
    public ListaCondicoesGeraisCreditoTela visualizarCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(btnVisualizarCondicoesGerais);
        salvarEvidencia("Tocar no �cone (>) na Condi��o Geral de prefer�ncia");
        tocarElemento(btnVisualizarCondicoesGerais, "N�o foi poss�vel tocar no �cone (>) na Condi��o Geral de prefer�ncia");
        return this;
    }
    /*
    M�todo para Tocar no �cone (X) fechar
    */
    @Step("Tocar no �cone (X) fechar")
    public ListaCondicoesGeraisCreditoTela tocarBtnFecharTelaListaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(btnFecharTelaListaCondicoesGerais);
        salvarEvidencia("Tocar no �cone (X) fechar");
        tocarElemento(btnFecharTelaListaCondicoesGerais, "N�o foi poss�vel tocar no �cone (X) fechar");
        return this;
    }
}
