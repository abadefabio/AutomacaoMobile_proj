package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class VisaoGeralCreditoTela extends PaginaBase {

    public VisaoGeralCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela VISÃO GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VISÃO GERAL\"]")
    private MobileElement headerTituloTelaVisaoGeral;

    // botão VOLTAR da tela VISÃO GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarVisaoGeral;

    // Texto SEGURO CARTÃO DE CRÉDITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title_super_protected_award")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Seguro cartão de crédito']")
    private MobileElement textoSeguroCartaoDeCredito;

    // Texto NOME DO PLANO
    @AndroidFindBy(id = "br.com.bradesco.next:id/label")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"labelLeft\"]")
    private MobileElement textoNomeDoPlano;

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

    /**
     * Método para validar Tela Visão Geral - Débito
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Validar Tela Visão Geral - CRÉDITO")
    public VisaoGeralCreditoTela validaTelaVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaVisaoGeral);
        validarCondicaoBooleana(aguardarExistenciaElemento(textoSeguroCartaoDeCredito), MetodoComparacaoBooleano.VERDADEIRO,"Texto SEGURO CARTÃO DE CRÉDITO não esta presente na tela");
        validarCondicaoBooleana(aguardarExistenciaElemento(textoNomeDoPlano), MetodoComparacaoBooleano.VERDADEIRO,"Texto NOME DO PLANO não esta presente na tela");
        salvarEvidencia("Tela VISÃO GERAL - CRÉDITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (<) voltar
     *
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (<) voltar")
    public VisaoGeralCreditoTela tocarBotaoVoltarVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarVisaoGeral);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoVoltarVisaoGeral, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }

    /**
     * Método para Tocar no Botão Meus Documentos
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Tocar no Botão Meus Documentos")
    public VisaoGeralCreditoTela tocarBotaoMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(botaoMeusDocumentos);
        salvarEvidencia("Tocar no Botão Meus Documentos");
        tocarElemento(botaoMeusDocumentos, "Não foi possível tocar no Botão Meus Documentos");
        return this;
    }

    /**
     * Método para Tocar no Botão Preciso De Ajuda
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Tocar no Botão Preciso De Ajuda")
    public VisaoGeralCreditoTela tocarBotaoPrecisoDeAjuda() throws Exception {
        aguardarCarregamentoElemento(botaoPrecisoDeAjuda);
        salvarEvidencia("Tocar no Botão Preciso De Ajuda");
        tocarElemento(botaoPrecisoDeAjuda, "Não foi possível tocar no Botão Preciso De Ajuda");
        return this;
    }

    /**
     * Método para Tocar no Cancelar Seguro
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Tocar no Botão Cancelar Seguro")
    public VisaoGeralCreditoTela tocarBotaoCancelarSeguro() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarSeguro);
        salvarEvidencia("Tocar no Cancelar Seguro");
        tocarElemento(botaoCancelarSeguro, "Não foi possível tocar no Cancelar Seguro");
        return this;
    }
}
