package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusDocumentosCreditoTela extends PaginaBase {

    public MeusDocumentosCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO CR�DITO\"]")
    private MobileElement headerTituloTelaMeusDocumentos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarMeusDocumentos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_documents_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Meus documentos\"]")
    private MobileElement textoMeusDocumentosCredito;

    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_insurance_policy")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Termo de condi��es super protegido cart�o de cr�dito\"]")
    private MobileElement botaoTermoDeCondicoes;

    /**
     * Validar Tela 'Meus Documentos' - Cr�dito
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela 'Meus Documentos' - Cr�dito")
    public MeusDocumentosCreditoTela validaTelaMeusDocumentos() {
        aguardarCarregamentoElemento(headerTituloTelaMeusDocumentos);
        validarCondicaoBooleana(verificarPresencaElemento(textoMeusDocumentosCredito), MetodoComparacaoBooleano.VERDADEIRO,"Texto SEGURO CART�O DE CR�DITO n�o carregado");
        validarCondicaoBooleana(verificarPresencaElemento(botaoTermoDeCondicoes), MetodoComparacaoBooleano.VERDADEIRO,"Texto NOME DO PLANO n�o carregado");
        salvarEvidencia("Validou Tela 'Meus Documentos' - Cr�dito");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (<) voltar
     * @return MeusDocumentosCreditoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (<) voltar")
    public MeusDocumentosCreditoTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarMeusDocumentos);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarMeusDocumentos, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }

    /**
     * M�todo para Tocar no Bot�o 'Termos De Condi��es'
     * @return MeusDocumentosCreditoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o 'Termos De Condi��es'")
    public MeusDocumentosCreditoTela tocarBotaoTermosDeCondicoes() throws Exception {
        aguardarCarregamentoElemento(botaoTermoDeCondicoes);
        salvarEvidencia("Tocar no Bot�o 'Termos De Condi��es'");
        tocarElemento(botaoTermoDeCondicoes, "N�o foi poss�vel tocar no Bot�o 'Termos De Condi��es'");
        return this;
    }
}
