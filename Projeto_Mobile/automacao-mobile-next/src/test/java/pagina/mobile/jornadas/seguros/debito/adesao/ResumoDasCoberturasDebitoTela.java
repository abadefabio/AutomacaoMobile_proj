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
    // T�tulo da tela RESUMO DAS COBERTURAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONDI��ES GERAIS\"]")
    private MobileElement headerTituloTelaResumoDasCoberturas;

    // bot�o VOLTAR da tela RESUMO DAS COBERTURAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarResumoDasCoberturas;

    /**
     * M�todo para validar Tela RESUMO DAS COBERTURAS - D�bito
     * @return ResumoDasCoberturasDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela RESUMO DAS COBERTURAS - D�BITO")
    public ResumoDasCoberturasDebitoTela validaTelaResumoDasCoberturas() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaResumoDasCoberturas);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(SegurosDebito.TITULO_TELA_RESUMO_DAS_COBERTURAS)), MetodoComparacaoBooleano.VERDADEIRO,"N�o Carregou a pagina Resumo das coberturas");
        salvarEvidencia("Tela RESUMO DAS COBERTURAS - D�BITO");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (<) voltar
     * @return ResumoDasCoberturasDebitoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (<) voltar")
    public ResumoDasCoberturasDebitoTela tocarBotaoVoltarTelaResumoDasCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarResumoDasCoberturas);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarResumoDasCoberturas, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }
}
