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
    // Título da tela CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDIÇÕES GERAIS\"]")
    private MobileElement headerTituloTelaCondicoesGerais;

    // botão VOLTAR da tela CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarTelaCondicoesGerais;
    /*     *************************     */

    /*
    Método para Valida tela CONDIÇÕES GERAIS
    */
    @Step("Valida tela CONDIÇÕES GERAIS")
    public CondicoesGeraisCreditoTela validaTelaCondicoesGerais() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaCondicoesGerais);
        compararElementoTexto(headerTituloTelaCondicoesGerais, SegurosCredito.TITULO_TELA_CONDICOES_GERAIS, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela CONDIÇOES GERAIS");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar
    */
    @Step("Tocar no ícone (<) voltar")
    public CondicoesGeraisCreditoTela tocarBotaoVoltarTelaTermoCondicoes() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarTelaCondicoesGerais);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarTelaCondicoesGerais, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
