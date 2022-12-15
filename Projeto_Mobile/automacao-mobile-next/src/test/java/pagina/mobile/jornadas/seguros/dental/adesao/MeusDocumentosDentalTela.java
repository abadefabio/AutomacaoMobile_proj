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
    // T�tulo da tela MEUS DOCUMENTOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_documents_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelTitle\"])[1]")
    private MobileElement headerTituloMeusDocumentos;

    // Bot�o Voltar "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // Bot�o Contrato
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_insurance_policy")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Contrato de plano odontol�gico\"]")
    private MobileElement botaoContrato;

    /**
     * M�todo para Valida tela VISAO GERAL
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
     * M�todo para tocar bot�o Voltar "<"
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Tocar Bot�o Voltar")
    public MeusDocumentosDentalTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("TOCAR BOT�O VOLTAR");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o Voltar");
        return this;
    }

    /**
     * M�todo para tocar bot�o Meus Documentos
     * @return
     * @throws Exception
     */
    @Step("Tocar Bot�o Botao Contrato")
    public MeusDocumentosDentalTela tocarBotaoContrato() throws Exception {
        aguardarCarregamentoElemento(botaoContrato);
        salvarEvidencia("TOCAR BOT�O CONTRATO");
        tocarElemento(botaoContrato, "N�o foi poss�vel tocar no bot�o Contrato");
        return this;
    }
}
