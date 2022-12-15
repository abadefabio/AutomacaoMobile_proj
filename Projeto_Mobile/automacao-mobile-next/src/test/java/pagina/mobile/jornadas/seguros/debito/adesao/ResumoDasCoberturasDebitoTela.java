package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.seguros.SegurosDebito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ResumoDasCoberturasDebitoTela extends PaginaBase {

    public ResumoDasCoberturasDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela RESUMO DAS COBERTURAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDIÇÕES GERAIS\"]")
    private MobileElement headerTituloTelaResumoDasCoberturas;

    // botão VOLTAR da tela RESUMO DAS COBERTURAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarResumoDasCoberturas;

    /**
     * Método para validar Tela RESUMO DAS COBERTURAS - Débito
     * @return ResumoDasCoberturasDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela RESUMO DAS COBERTURAS - DÉBITO")
    public ResumoDasCoberturasDebitoTela validaTelaResumoDasCoberturas() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaResumoDasCoberturas);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(SegurosDebito.TITULO_TELA_RESUMO_DAS_COBERTURAS)), MetodoComparacaoBooleano.VERDADEIRO,"Não Carregou a pagina Resumo das coberturas");
        salvarEvidencia("Tela RESUMO DAS COBERTURAS - DÉBITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     * @return ResumoDasCoberturasDebitoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public ResumoDasCoberturasDebitoTela tocarBotaoVoltarTelaResumoDasCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarResumoDasCoberturas);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarResumoDasCoberturas, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
