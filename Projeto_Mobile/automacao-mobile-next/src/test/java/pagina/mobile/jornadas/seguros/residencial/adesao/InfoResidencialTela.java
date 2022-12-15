package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InfoResidencialTela extends PaginaBase {

    public InfoResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela INFO RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VIS�O GERAL\"]")
    private MobileElement headerTituloVisaoGeralResidencial;

    // bot�o FECHAR (X)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    // bot�o EXPANDIR COBERTURAS
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Expandir\"]")
    private MobileElement botaoExpandirCoberturas;

    // bot�o COLAPSAR COBERTURAS
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Colapsar\"]")
    private MobileElement botaoColapsarCoberturas;

    // bot�o EXPANDIR ASSIST�NCIAS
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[2]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Assist�ncias Expandir\"]")
    private MobileElement botaoExpandirAssistencias;

    // bot�o COLAPSAR ASSIST�NCIAS
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[2]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Assist�ncias Colapsar\"]")
    private MobileElement botaoColapsarAssistencias;

    // bot�o EXPANDIR DADOS DO PARCEIRO
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Expandir\"]")
    private MobileElement botaoExpandirDadosDoParceiro;

    // bot�o COLAPSAR DADOS DO PARCEIRO
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Colapsar\"]")
    private MobileElement botaoColapsarDadosDoParceiro;

    // bot�o EXPANDIR CANCELAMENTO
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Expandir\"]")
    private MobileElement botaoExpandirCancelamento;

    // bot�o COLAPSAR CANCELAMENTO
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement botaoColapsarCancelamento;
    /*     *************************     */

    /**
     * M�todo para tocar no bot�o FECHAR "X" da tela INFO RESIDENCIAL
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no �cone (X) fechar")
    public InfoResidencialTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no �cone (X) fechar");
        return this;
    }

    /**
     * M�todo para tocar no bot�o EXPANDIR COBERTURAS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o Expandir Coberturas")
    public InfoResidencialTela tocarBotaoExpandirCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirCoberturas);
        salvarEvidencia("Tocar no bot�o Expandir Coberturas");
        tocarElemento(botaoExpandirCoberturas, "N�o foi poss�vel tocar no bot�o Expandir Coberturas");
        return this;
    }

    /**
     * M�todo para tocar no bot�o COLAPSAR COBERTURAS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o Colapsar Coberturas")
    public InfoResidencialTela tocarBotaoColapsarCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarCoberturas);
        salvarEvidencia("Tocar no bot�o Colapsar Coberturas");
        tocarElemento(botaoColapsarCoberturas, "N�o foi poss�vel tocar no bot�o Colapsar Coberturas");
        return this;
    }

    /**
     * M�todo para tocar no bot�o EXPANDIR ASSIST�NCIAS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o Expandir Assist�ncias")
    public InfoResidencialTela tocarBotaoExpandirAssistencias() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirAssistencias);
        salvarEvidencia("Tocar no bot�o Expandir Assist�ncias");
        tocarElemento(botaoExpandirAssistencias, "N�o foi poss�vel tocar no bot�o Expandir Assist�ncias");
        return this;
    }

    /**
     * M�todo para tocar no bot�o COLAPSAR ASSIST�NCIAS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o Colapsar Assist�ncias")
    public InfoResidencialTela tocarBotaoColapsarAssistencias() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarAssistencias);
        salvarEvidencia("Tocar no bot�o Colapsar Assist�ncias");
        tocarElemento(botaoColapsarAssistencias, "N�o foi poss�vel tocar no bot�o Colapsar Assist�ncias");
        return this;
    }

    /**
     * M�todo para tocar no bot�o EXPANDIR DADOS DO PARCEIRO
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o Expandir Dados do parceiro")
    public InfoResidencialTela tocarBotaoExpandirDadosDoParceiro() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirDadosDoParceiro);
        salvarEvidencia("Tocar no bot�o Expandir Dados do parceiro");
        tocarElemento(botaoExpandirDadosDoParceiro, "N�o foi poss�vel tocar no bot�o Expandir Dados do parceiro");
        return this;
    }

    /**
     * M�todo para tocar no bot�o COLAPSAR DADOS DO PARCEIRO
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o Colapsar Dados do parceiro")
    public InfoResidencialTela tocarBotaoColapsarDadosDoParceiro() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarDadosDoParceiro);
        salvarEvidencia("Tocar no bot�o Colapsar Dados do parceiro");
        tocarElemento(botaoColapsarDadosDoParceiro, "N�o foi poss�vel tocar no bot�o Colapsar Dados do parceiro");
        return this;
    }

    /**
     * M�todo para tocar no bot�o EXPANDIR CANCELAMENTO
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o Expandir Cancelamento")
    public InfoResidencialTela tocarBotaoExpandirCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirCancelamento);
        salvarEvidencia("Tocar no bot�o Expandir Cancelamento");
        tocarElemento(botaoExpandirCancelamento, "N�o foi poss�vel tocar no bot�o Expandir Cancelamento");
        return this;
    }

    /**
     * M�todo para tocar no bot�o COLAPSAR CANCELAMENTO
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o Colapsar Cancelamento")
    public InfoResidencialTela tocarBotaoColapsarCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarCancelamento);
        salvarEvidencia("Tocar no bot�o Colapsar Cancelamento");
        tocarElemento(botaoColapsarCancelamento, "N�o foi poss�vel tocar no bot�o Colapsar Cancelamento");
        return this;
    }
}
