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
    // T�tulo da tela VIS�O GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VIS�O GERAL\"]")
    private MobileElement headerTituloTelaVisaoGeral;

    // bot�o VOLTAR da tela VIS�O GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltarVisaoGeral;

    // Texto SEGURO CART�O DE CR�DITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title_super_protected_award")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Seguro cart�o de cr�dito']")
    private MobileElement textoSeguroCartaoDeCredito;

    // Texto NOME DO PLANO
    @AndroidFindBy(id = "br.com.bradesco.next:id/label")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"labelLeft\"]")
    private MobileElement textoNomeDoPlano;

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

    /**
     * M�todo para validar Tela Vis�o Geral - D�bito
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Validar Tela Vis�o Geral - CR�DITO")
    public VisaoGeralCreditoTela validaTelaVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaVisaoGeral);
        validarCondicaoBooleana(aguardarExistenciaElemento(textoSeguroCartaoDeCredito), MetodoComparacaoBooleano.VERDADEIRO,"Texto SEGURO CART�O DE CR�DITO n�o esta presente na tela");
        validarCondicaoBooleana(aguardarExistenciaElemento(textoNomeDoPlano), MetodoComparacaoBooleano.VERDADEIRO,"Texto NOME DO PLANO n�o esta presente na tela");
        salvarEvidencia("Tela VIS�O GERAL - CR�DITO");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (<) voltar
     *
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (<) voltar")
    public VisaoGeralCreditoTela tocarBotaoVoltarVisaoGeral() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarVisaoGeral);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoVoltarVisaoGeral, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }

    /**
     * M�todo para Tocar no Bot�o Meus Documentos
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o Meus Documentos")
    public VisaoGeralCreditoTela tocarBotaoMeusDocumentos() throws Exception {
        aguardarCarregamentoElemento(botaoMeusDocumentos);
        salvarEvidencia("Tocar no Bot�o Meus Documentos");
        tocarElemento(botaoMeusDocumentos, "N�o foi poss�vel tocar no Bot�o Meus Documentos");
        return this;
    }

    /**
     * M�todo para Tocar no Bot�o Preciso De Ajuda
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o Preciso De Ajuda")
    public VisaoGeralCreditoTela tocarBotaoPrecisoDeAjuda() throws Exception {
        aguardarCarregamentoElemento(botaoPrecisoDeAjuda);
        salvarEvidencia("Tocar no Bot�o Preciso De Ajuda");
        tocarElemento(botaoPrecisoDeAjuda, "N�o foi poss�vel tocar no Bot�o Preciso De Ajuda");
        return this;
    }

    /**
     * M�todo para Tocar no Cancelar Seguro
     * @return VisaoGeralCreditoTela
     * @throws Exception
     */
    @Step("Tocar no Bot�o Cancelar Seguro")
    public VisaoGeralCreditoTela tocarBotaoCancelarSeguro() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarSeguro);
        salvarEvidencia("Tocar no Cancelar Seguro");
        tocarElemento(botaoCancelarSeguro, "N�o foi poss�vel tocar no Cancelar Seguro");
        return this;
    }
}
