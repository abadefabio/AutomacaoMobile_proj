package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusDocumentosDentalTela extends PaginaBase {

    public MeusDocumentosDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela MEUS DOCUMENTOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_documents_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelTitle\"])[1]")
    private MobileElement headerTituloMeusDocumentos;

    // Botão Voltar "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Botão Contrato
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_insurance_policy")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Contrato de plano odontológico\"]")
    private MobileElement botaoContrato;

    /**
     * Método para Valida tela VISAO GERAL
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Validar tela Meus Documentos")
    public MeusDocumentosDentalTela validaTelaMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(headerTituloMeusDocumentos);
        compararElementoTexto(headerTituloMeusDocumentos, SegurosDental.TITULO_TELA_MEUS_DOCUMENTOS, MetodoComparacao.IGUAL);
        salvarEvidencia("Validada a tela Meus Documentos");
        return this;
    }

    /**
     * Método para tocar botão Voltar "<"
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Tocar Botão Voltar")
    public MeusDocumentosDentalTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("TOCAR BOTÃO VOLTAR");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão Voltar");
        return this;
    }

    /**
     * Método para tocar botão Meus Documentos
     * @return
     * @throws Exception
     */
    @Step("Tocar Botão Botao Contrato")
    public MeusDocumentosDentalTela tocarBotaoContrato() throws Exception {
        aguardarCarregamentoElemento(botaoContrato);
        salvarEvidencia("TOCAR BOTÃO CONTRATO");
        tocarElemento(botaoContrato, "Não foi possível tocar no botão Contrato");
        return this;
    }
}
