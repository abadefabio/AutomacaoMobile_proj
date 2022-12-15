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
    // Título da tela MEUS DOCUMENTOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"labelTitle\"])[1]")
    private MobileElement headerTituloTelaMeusDocumentos;

    // botão VOLTAR da tela MEUS DOCUMENTOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarMeusDocumentos;

    // Botão RESUMO DAS COBERTURAS da tela MEUS DOCUMENTOS
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Seguro Cartão de Débito - Resumo das coberturas\"]")
    private MobileElement botaoResumoDasCoberturas;

    // Botão SEGURO COLETIVO DE PESSOAS da tela MEUS DOCUMENTOS
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Seguro Cartão de Débito - Seguro coletivo de pessoas\"]")
    private MobileElement botaoSeguroColetivoDePessoas;

    /**
     * Método para validar Tela Visão Geral - Débito
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela Meus Documentos - DÉBITO")
    public MeusDocumentosDebitoTela validaTelaMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaMeusDocumentos);
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoSeguroColetivoDePessoas), MetodoComparacaoBooleano.VERDADEIRO,"Não carregou o botão seguro coletivo de pessoas");
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoResumoDasCoberturas), MetodoComparacaoBooleano.VERDADEIRO,"Não carregou o botão resumo das coberturas");
        salvarEvidencia("Tela MEUS DOCUMENTOS - DÉBITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     * @return MeusDocumentosDebitoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public MeusDocumentosDebitoTela tocarBotaoVoltarTelaMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarMeusDocumentos);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarMeusDocumentos, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }

    /**
     * Método para Tocar no Botão RESUMO DAS COBERTURAS
     * @return MeusDocumentosDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Botão RESUMO DAS COBERTURAS")
    public MeusDocumentosDebitoTela tocarBotaoResumoDasCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoResumoDasCoberturas);
        salvarEvidencia("Tocar no Botão RESUMO DAS COBERTURAS");
        tocarElemento(botaoResumoDasCoberturas, "Não foi possível tocar no Botão RESUMO DAS COBERTURAS");
        return this;
    }

    /**
     * Método para Tocar no Botão SEGURO COLETIVO DE PESSOAS
     * @return MeusDocumentosDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Botão SEGURO COLETIVO DE PESSOAS")
    public MeusDocumentosDebitoTela tocarBotaoSeguroColetivoDePessoas() throws Exception {
        aguardarCarregamentoElemento(botaoSeguroColetivoDePessoas);
        salvarEvidencia("Tocar no Botão SEGURO COLETIVO DE PESSOAS");
        tocarElemento(botaoSeguroColetivoDePessoas, "Não foi possível tocar no Botão SEGURO COLETIVO DE PESSOAS");
        return this;
    }
}
