package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosCredito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CondicoesGeraisCreditoTela extends PaginaBase {

    public CondicoesGeraisCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela CONDI��ES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDI��ES GERAIS\"]")
    private MobileElement headerTituloTelaCondicoesGerais;

    // bot�o VOLTAR da tela CONDI��ES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarTelaCondicoesGerais;
    /*     *************************     */

    /*
    M�todo para Valida tela CONDI��ES GERAIS
    */
    @Step("Valida tela CONDI��ES GERAIS")
    public CondicoesGeraisCreditoTela validaTelaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaCondicoesGerais);
        compararElementoTexto(headerTituloTelaCondicoesGerais, SegurosCredito.TITULO_TELA_CONDICOES_GERAIS, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela CONDI�OES GERAIS");
        return this;
    }
    /*
    M�todo para Tocar no �cone (<) voltar
    */
    @Step("Tocar no �cone (<) voltar")
    public CondicoesGeraisCreditoTela tocarBotaoVoltarTelaTermoCondicoes() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarTelaCondicoesGerais);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarTelaCondicoesGerais, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }
}
