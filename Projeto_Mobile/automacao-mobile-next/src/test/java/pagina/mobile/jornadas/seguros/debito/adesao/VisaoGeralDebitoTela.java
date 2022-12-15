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
    // T�tulo da tela VIS�O GERAL
    @AndroidFindBy(xpath = "//me.next.uikit.NextLabel[@content-desc=\"VIS�O GERAL, titulo\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VIS�O GERAL\"]")
    private MobileElement headerTituloTelaVisaoGeral;

    // bot�o VOLTAR da tela VIS�O GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarVisaoGeral;

    // Texto SEGURO CART�O DE D�BITO
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/me.next.uikit.NextLabel")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Seguro cart�o de d�bito']")
    private MobileElement textoSeguroCartaoDeDebito;

    // Texto VIG�NCIA
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[1]/me.next.uikit.NextLabel[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Vig�ncia']")
    private MobileElement textoVigencia;

    // Texto VENCIMENTO
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup[2]/me.next.uikit.NextLabel[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Vencimento das parcelas']")
    private MobileElement textoVencimento;

    // Bot�o MEUS DOCUMENTOS
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonMyDocuments\"]")
    private MobileElement botaoMeusDocumentos;

    // Bot�o PRECISO DE AJUDA
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonWantHelp\"]")
    private MobileElement botaoPrecisoDeAjuda;

    // Bot�o CANCELAR SEGURO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_cancel_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonCancelInsurance\"]")
    private MobileElement botaoCancelarSeguro;

    public VisaoGeralDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * M�todo para validar Tela Vis�o Geral - D�bito
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Validar Tela Vis�o Geral - D�BITO")
    public VisaoGeralDebitoTela validaTelaVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaVisaoGeral);
        validarCondicaoBooleana(aguardarExistenciaElemento(textoSeguroCartaoDeDebito), MetodoComparacaoBooleano.VERDADEIRO,"Texto SEGURO CART�O DE D�BITO n�o esta presente na tela");
        validarCondicaoBooleana(aguardarExistenciaElemento(textoVigencia), MetodoComparacaoBooleano.VERDADEIRO,"Texto VIG�NCIA n�o esta presente na tela");
        validarCondicaoBooleana(aguardarExistenciaElemento(textoVencimento), MetodoComparacaoBooleano.VERDADEIRO,"Texto VENCIMENTO n�o esta presente na tela");
        salvarEvidencia("Tela VIS�O GERAL - D�BITO");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (<) voltar
     *
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (<) voltar")
    public VisaoGeralDebitoTela tocarBotaoVoltarVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarVisaoGeral);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarVisaoGeral, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }

    /**
     * M�todo para Tocar no Bot�o Meus Documentos
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o Meus Documentos")
    public VisaoGeralDebitoTela tocarBotaoMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(botaoMeusDocumentos);
        salvarEvidencia("Tocar no Bot�o Meus Documentos");
        tocarElemento(botaoMeusDocumentos, "N�o foi poss�vel tocar no Bot�o Meus Documentos");
        return this;
    }

    /**
     * M�todo para Tocar no Bot�o Preciso De Ajuda
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o Preciso De Ajuda")
    public VisaoGeralDebitoTela tocarBotaoPrecisoDeAjuda() throws Exception {
        aguardarCarregamentoElemento(botaoPrecisoDeAjuda);
        salvarEvidencia("Tocar no Bot�o Preciso De Ajuda");
        tocarElemento(botaoPrecisoDeAjuda, "N�o foi poss�vel tocar no Bot�o Preciso De Ajuda");
        return this;
    }

    /**
     * M�todo para Tocar no Cancelar Seguro
     * @return VisaoGeralDebitoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o Cancelar Seguro")
    public VisaoGeralDebitoTela tocarBotaoCancelarSeguro() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarSeguro);
        salvarEvidencia("Tocar no Cancelar Seguro");
        tocarElemento(botaoCancelarSeguro, "N�o foi poss�vel tocar no Cancelar Seguro");
        return this;
    }
}
