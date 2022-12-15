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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGURO CRÉDITO\"]")
    private MobileElement headerTituloTelaMeusDocumentos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarMeusDocumentos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_documents_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Meus documentos\"]")
    private MobileElement textoMeusDocumentosCredito;

    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_insurance_policy")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Termo de condições super protegido cartão de crédito\"]")
    private MobileElement botaoTermoDeCondicoes;

    /**
     * Validar Tela 'Meus Documentos' - Crédito
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela 'Meus Documentos' - Crédito")
    public MeusDocumentosCreditoTela validaTelaMeusDocumentos() {
        aguardarCarregamentoElemento(headerTituloTelaMeusDocumentos);
        validarCondicaoBooleana(verificarPresencaElemento(textoMeusDocumentosCredito), MetodoComparacaoBooleano.VERDADEIRO,"Texto SEGURO CARTÃO DE CRÉDITO não carregado");
        validarCondicaoBooleana(verificarPresencaElemento(botaoTermoDeCondicoes), MetodoComparacaoBooleano.VERDADEIRO,"Texto NOME DO PLANO não carregado");
        salvarEvidencia("Validou Tela 'Meus Documentos' - Crédito");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     * @return MeusDocumentosCreditoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public MeusDocumentosCreditoTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarMeusDocumentos);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarMeusDocumentos, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }

    /**
     * Método para Tocar no Botão 'Termos De Condições'
     * @return MeusDocumentosCreditoTela
     * @throws Exception
     */
    @Step("Tocar no Botão 'Termos De Condições'")
    public MeusDocumentosCreditoTela tocarBotaoTermosDeCondicoes() throws Exception {
        aguardarCarregamentoElemento(botaoTermoDeCondicoes);
        salvarEvidencia("Tocar no Botão 'Termos De Condições'");
        tocarElemento(botaoTermoDeCondicoes, "Não foi possível tocar no Botão 'Termos De Condições'");
        return this;
    }
}
