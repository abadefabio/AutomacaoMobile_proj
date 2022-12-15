package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusDocumentosDebitoTela extends PaginaBase {

    public MeusDocumentosDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela MEUS DOCUMENTOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelTitle\"])[1]")
    private MobileElement headerTituloTelaMeusDocumentos;

    // bot�o VOLTAR da tela MEUS DOCUMENTOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarMeusDocumentos;

    // Bot�o RESUMO DAS COBERTURAS da tela MEUS DOCUMENTOS
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Seguro Cart�o de D�bito - Resumo das coberturas\"]")
    private MobileElement botaoResumoDasCoberturas;

    // Bot�o SEGURO COLETIVO DE PESSOAS da tela MEUS DOCUMENTOS
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Seguro Cart�o de D�bito - Seguro coletivo de pessoas\"]")
    private MobileElement botaoSeguroColetivoDePessoas;

    /**
     * M�todo para validar Tela Vis�o Geral - D�bito
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela Meus Documentos - D�BITO")
    public MeusDocumentosDebitoTela validaTelaMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaMeusDocumentos);
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoSeguroColetivoDePessoas), MetodoComparacaoBooleano.VERDADEIRO,"N�o carregou o bot�o seguro coletivo de pessoas");
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoResumoDasCoberturas), MetodoComparacaoBooleano.VERDADEIRO,"N�o carregou o bot�o resumo das coberturas");
        salvarEvidencia("Tela MEUS DOCUMENTOS - D�BITO");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (<) voltar
     * @return MeusDocumentosDebitoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (<) voltar")
    public MeusDocumentosDebitoTela tocarBotaoVoltarTelaMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarMeusDocumentos);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarMeusDocumentos, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }

    /**
     * M�todo para Tocar no Bot�o RESUMO DAS COBERTURAS
     * @return MeusDocumentosDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o RESUMO DAS COBERTURAS")
    public MeusDocumentosDebitoTela tocarBotaoResumoDasCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoResumoDasCoberturas);
        salvarEvidencia("Tocar no Bot�o RESUMO DAS COBERTURAS");
        tocarElemento(botaoResumoDasCoberturas, "N�o foi poss�vel tocar no Bot�o RESUMO DAS COBERTURAS");
        return this;
    }

    /**
     * M�todo para Tocar no Bot�o SEGURO COLETIVO DE PESSOAS
     * @return MeusDocumentosDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o SEGURO COLETIVO DE PESSOAS")
    public MeusDocumentosDebitoTela tocarBotaoSeguroColetivoDePessoas() throws Exception {
        aguardarCarregamentoElemento(botaoSeguroColetivoDePessoas);
        salvarEvidencia("Tocar no Bot�o SEGURO COLETIVO DE PESSOAS");
        tocarElemento(botaoSeguroColetivoDePessoas, "N�o foi poss�vel tocar no Bot�o SEGURO COLETIVO DE PESSOAS");
        return this;
    }
}
