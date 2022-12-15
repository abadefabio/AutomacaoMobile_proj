package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class VisaoGeralDebitoTela extends PaginaBase {

    //Elementos
    // Título da tela VISÃO GERAL
    @AndroidFindBy(xpath = "//me.next.uikit.NextLabel[@content-desc=\"VISÃO GERAL, titulo\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VISÃO GERAL\"]")
    private MobileElement headerTituloTelaVisaoGeral;

    // botão VOLTAR da tela VISÃO GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarVisaoGeral;

    // Texto SEGURO CARTÃO DE DÉBITO
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/me.next.uikit.NextLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Seguro cartão de débito']")
    private MobileElement textoSeguroCartaoDeDebito;

    // Texto VIGÊNCIA
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[1]/me.next.uikit.NextLabel[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Vigência']")
    private MobileElement textoVigencia;

    // Texto VENCIMENTO
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/me.next.uikit.NextLabel[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Vencimento das parcelas']")
    private MobileElement textoVencimento;

    // Botão MEUS DOCUMENTOS
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonMyDocuments\"]")
    private MobileElement botaoMeusDocumentos;

    // Botão PRECISO DE AJUDA
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonWantHelp\"]")
    private MobileElement botaoPrecisoDeAjuda;

    // Botão CANCELAR SEGURO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_cancel_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoCancelarSeguro;

    public VisaoGeralDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Método para validar Tela Visão Geral - Débito
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela Visão Geral - DÉBITO")
    public VisaoGeralDebitoTela validaTelaVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaVisaoGeral);
        validarCondicaoBooleana(aguardarExistenciaElemento(textoSeguroCartaoDeDebito), MetodoComparacaoBooleano.VERDADEIRO,"Texto SEGURO CARTÃO DE DÉBITO não esta presente na tela");
        validarCondicaoBooleana(aguardarExistenciaElemento(textoVigencia), MetodoComparacaoBooleano.VERDADEIRO,"Texto VIGÊNCIA não esta presente na tela");
        validarCondicaoBooleana(aguardarExistenciaElemento(textoVencimento), MetodoComparacaoBooleano.VERDADEIRO,"Texto VENCIMENTO não esta presente na tela");
        salvarEvidencia("Tela VISÃO GERAL - DÉBITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     *
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public VisaoGeralDebitoTela tocarBotaoVoltarVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarVisaoGeral);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarVisaoGeral, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }

    /**
     * Método para Tocar no Botão Meus Documentos
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Botão Meus Documentos")
    public VisaoGeralDebitoTela tocarBotaoMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(botaoMeusDocumentos);
        salvarEvidencia("Tocar no Botão Meus Documentos");
        tocarElemento(botaoMeusDocumentos, "Não foi possível tocar no Botão Meus Documentos");
        return this;
    }

    /**
     * Método para Tocar no Botão Preciso De Ajuda
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Botão Preciso De Ajuda")
    public VisaoGeralDebitoTela tocarBotaoPrecisoDeAjuda() throws Exception {
        aguardarCarregamentoElemento(botaoPrecisoDeAjuda);
        salvarEvidencia("Tocar no Botão Preciso De Ajuda");
        tocarElemento(botaoPrecisoDeAjuda, "Não foi possível tocar no Botão Preciso De Ajuda");
        return this;
    }

    /**
     * Método para Tocar no Cancelar Seguro
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Botão Cancelar Seguro")
    public VisaoGeralDebitoTela tocarBotaoCancelarSeguro() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarSeguro);
        salvarEvidencia("Tocar no Cancelar Seguro");
        tocarElemento(botaoCancelarSeguro, "Não foi possível tocar no Cancelar Seguro");
        return this;
    }
}
