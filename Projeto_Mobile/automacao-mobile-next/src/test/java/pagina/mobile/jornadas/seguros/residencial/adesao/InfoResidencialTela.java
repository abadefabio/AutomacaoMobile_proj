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
    // Título da tela INFO RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VISÃO GERAL\"]")
    private MobileElement headerTituloVisaoGeralResidencial;

    // botão FECHAR (X)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    // botão EXPANDIR COBERTURAS
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Expandir\"]")
    private MobileElement botaoExpandirCoberturas;

    // botão COLAPSAR COBERTURAS
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Colapsar\"]")
    private MobileElement botaoColapsarCoberturas;

    // botão EXPANDIR ASSISTÊNCIAS
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Assistências Expandir\"]")
    private MobileElement botaoExpandirAssistencias;

    // botão COLAPSAR ASSISTÊNCIAS
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Assistências Colapsar\"]")
    private MobileElement botaoColapsarAssistencias;

    // botão EXPANDIR DADOS DO PARCEIRO
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Expandir\"]")
    private MobileElement botaoExpandirDadosDoParceiro;

    // botão COLAPSAR DADOS DO PARCEIRO
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Colapsar\"]")
    private MobileElement botaoColapsarDadosDoParceiro;

    // botão EXPANDIR CANCELAMENTO
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Expandir\"]")
    private MobileElement botaoExpandirCancelamento;

    // botão COLAPSAR CANCELAMENTO
    @AndroidFindBy(id = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement botaoColapsarCancelamento;
    /*     *************************     */

    /**
     * Método para tocar no botão FECHAR "X" da tela INFO RESIDENCIAL
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no ícone (X) fechar")
    public InfoResidencialTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoFechar, "Não foi possível tocar no ícone (X) fechar");
        return this;
    }

    /**
     * Método para tocar no botão EXPANDIR COBERTURAS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Expandir Coberturas")
    public InfoResidencialTela tocarBotaoExpandirCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirCoberturas);
        salvarEvidencia("Tocar no botão Expandir Coberturas");
        tocarElemento(botaoExpandirCoberturas, "Não foi possível tocar no botão Expandir Coberturas");
        return this;
    }

    /**
     * Método para tocar no botão COLAPSAR COBERTURAS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Colapsar Coberturas")
    public InfoResidencialTela tocarBotaoColapsarCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarCoberturas);
        salvarEvidencia("Tocar no botão Colapsar Coberturas");
        tocarElemento(botaoColapsarCoberturas, "Não foi possível tocar no botão Colapsar Coberturas");
        return this;
    }

    /**
     * Método para tocar no botão EXPANDIR ASSISTÊNCIAS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Expandir Assistências")
    public InfoResidencialTela tocarBotaoExpandirAssistencias() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirAssistencias);
        salvarEvidencia("Tocar no botão Expandir Assistências");
        tocarElemento(botaoExpandirAssistencias, "Não foi possível tocar no botão Expandir Assistências");
        return this;
    }

    /**
     * Método para tocar no botão COLAPSAR ASSISTÊNCIAS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Colapsar Assistências")
    public InfoResidencialTela tocarBotaoColapsarAssistencias() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarAssistencias);
        salvarEvidencia("Tocar no botão Colapsar Assistências");
        tocarElemento(botaoColapsarAssistencias, "Não foi possível tocar no botão Colapsar Assistências");
        return this;
    }

    /**
     * Método para tocar no botão EXPANDIR DADOS DO PARCEIRO
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Expandir Dados do parceiro")
    public InfoResidencialTela tocarBotaoExpandirDadosDoParceiro() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirDadosDoParceiro);
        salvarEvidencia("Tocar no botão Expandir Dados do parceiro");
        tocarElemento(botaoExpandirDadosDoParceiro, "Não foi possível tocar no botão Expandir Dados do parceiro");
        return this;
    }

    /**
     * Método para tocar no botão COLAPSAR DADOS DO PARCEIRO
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Colapsar Dados do parceiro")
    public InfoResidencialTela tocarBotaoColapsarDadosDoParceiro() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarDadosDoParceiro);
        salvarEvidencia("Tocar no botão Colapsar Dados do parceiro");
        tocarElemento(botaoColapsarDadosDoParceiro, "Não foi possível tocar no botão Colapsar Dados do parceiro");
        return this;
    }

    /**
     * Método para tocar no botão EXPANDIR CANCELAMENTO
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Expandir Cancelamento")
    public InfoResidencialTela tocarBotaoExpandirCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirCancelamento);
        salvarEvidencia("Tocar no botão Expandir Cancelamento");
        tocarElemento(botaoExpandirCancelamento, "Não foi possível tocar no botão Expandir Cancelamento");
        return this;
    }

    /**
     * Método para tocar no botão COLAPSAR CANCELAMENTO
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão Colapsar Cancelamento")
    public InfoResidencialTela tocarBotaoColapsarCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarCancelamento);
        salvarEvidencia("Tocar no botão Colapsar Cancelamento");
        tocarElemento(botaoColapsarCancelamento, "Não foi possível tocar no botão Colapsar Cancelamento");
        return this;
    }
}
