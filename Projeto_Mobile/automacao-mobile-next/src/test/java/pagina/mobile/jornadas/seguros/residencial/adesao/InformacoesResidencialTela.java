package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacoesResidencialTela extends PaginaBase {

    public InformacoesResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // bot�o FECHAR (X)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    // bot�o EXPANDIR COBERTURAS
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[1]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Expandir\"]")
    private MobileElement botaoExpandirCoberturas;

    // bot�o COLAPSAR COBERTURAS
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[1]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Colapsar\"]")
    private MobileElement botaoColapsarCoberturas;

    // bot�o EXPANDIR ASSIST�NCIAS
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[2]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Assist�ncias Expandir\"]")
    private MobileElement botaoExpandirAssistencias;

    // bot�o COLAPSAR ASSIST�NCIAS
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[2]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Assist�ncias Colapsar\"]")
    private MobileElement botaoColapsarAssistencias;

    // bot�o EXPANDIR DADOS DO PARCEIRO
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Expandir\"]")
    private MobileElement botaoExpandirDadosDoParceiro;

    // bot�o COLAPSAR DADOS DO PARCEIRO
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Colapsar\"]")
    private MobileElement botaoColapsarDadosDoParceiro;

    // bot�o EXPANDIR CANCELAMENTO
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Expandir\"]")
    private MobileElement botaoExpandirCancelamento;

    // bot�o COLAPSAR CANCELAMENTO
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement botaoColapsarCancelamento;

    // texto Coberturas
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement textoBotaoCoberturas;

    // texto Assist�ncias
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement textoBotaoAssistencias;

    // texto Dados do Parceiro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement textoBotaoDadosDoParceiro;

    // texto Cancelamento
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, bot�o\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement textoBotaoCancelamento;

    /**
     * M�todo para tocar no bot�o FECHAR "X" da tela INFO RESIDENCIAL
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no �cone (X) fechar")
    public InformacoesResidencialTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no �cone (X) fechar");
        return this;
    }

    /**
     * M�todo para tocar no bot�o EXPANDIR COBERTURAS
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Expandir Coberturas")
    public InformacoesResidencialTela tocarBotaoExpandirCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirCoberturas);
        salvarEvidencia("Tocar no bot�o Expandir Coberturas");
        tocarElemento(botaoExpandirCoberturas, "N�o foi poss�vel tocar no bot�o Expandir Coberturas");
        return this;
    }

    /**
     * M�todo para tocar no bot�o COLAPSAR COBERTURAS
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Colapsar Coberturas")
    public InformacoesResidencialTela tocarBotaoColapsarCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarCoberturas);
        salvarEvidencia("Tocar no bot�o Colapsar Coberturas");
        tocarElemento(botaoColapsarCoberturas, "N�o foi poss�vel tocar no bot�o Colapsar Coberturas");
        return this;
    }

    /**
     * M�todo para tocar no bot�o EXPANDIR ASSIST�NCIAS
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Expandir Assist�ncias")
    public InformacoesResidencialTela tocarBotaoExpandirAssistencias() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirAssistencias);
        salvarEvidencia("Tocar no bot�o Expandir Assist�ncias");
        tocarElemento(botaoExpandirAssistencias, "N�o foi poss�vel tocar no bot�o Expandir Assist�ncias");
        return this;
    }

    /**
     * M�todo para tocar no bot�o COLAPSAR ASSIST�NCIAS
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Colapsar Assist�ncias")
    public InformacoesResidencialTela tocarBotaoColapsarAssistencias() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarAssistencias);
        salvarEvidencia("Tocar no bot�o Colapsar Assist�ncias");
        tocarElemento(botaoColapsarAssistencias, "N�o foi poss�vel tocar no bot�o Colapsar Assist�ncias");
        return this;
    }

    /**
     * M�todo para tocar no bot�o EXPANDIR DADOS DO PARCEIRO
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Expandir Dados do parceiro")
    public InformacoesResidencialTela tocarBotaoExpandirDadosDoParceiro() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirDadosDoParceiro);
        salvarEvidencia("Tocar no bot�o Expandir Dados do parceiro");
        tocarElemento(botaoExpandirDadosDoParceiro, "N�o foi poss�vel tocar no bot�o Expandir Dados do parceiro");
        return this;
    }

    /**
     * M�todo para tocar no bot�o COLAPSAR DADOS DO PARCEIRO
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Colapsar Dados do parceiro")
    public InformacoesResidencialTela tocarBotaoColapsarDadosDoParceiro() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarDadosDoParceiro);
        salvarEvidencia("Tocar no bot�o Colapsar Dados do parceiro");
        tocarElemento(botaoColapsarDadosDoParceiro, "N�o foi poss�vel tocar no bot�o Colapsar Dados do parceiro");
        return this;
    }

    /**
     * M�todo para tocar no bot�o EXPANDIR CANCELAMENTO
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Expandir Cancelamento")
    public InformacoesResidencialTela tocarBotaoExpandirCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirCancelamento);
        salvarEvidencia("Tocar no bot�o Expandir Cancelamento");
        tocarElemento(botaoExpandirCancelamento, "N�o foi poss�vel tocar no bot�o Expandir Cancelamento");
        return this;
    }

    /**
     * M�todo para tocar no bot�o COLAPSAR CANCELAMENTO
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o Colapsar Cancelamento")
    public InformacoesResidencialTela tocarBotaoColapsarCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarCancelamento);
        salvarEvidencia("Tocar no bot�o Colapsar Cancelamento");
        tocarElemento(botaoColapsarCancelamento, "N�o foi poss�vel tocar no bot�o Colapsar Cancelamento");
        return this;
    }

    /**
     * M�todo para validar Tela de Informa��es Residencial
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Tela de Informa��es - RESIDENCIAL")
    public InformacoesResidencialTela validarTelaInfomacoesResidencial() throws Exception {
        aguardarPaginaConterTodosTextos("Coberturas", "Assist�ncias", "Dados do parceiro", "Cancelamento");
        salvarEvidencia("Validar Tela de Informa��es - RESIDENCIAL");
        return this;
    }

    /**
     * M�todo para validar Coberturas
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Coberturas - RESIDENCIAL")
    public InformacoesResidencialTela validarCoberturas() throws Exception {
        aguardarPaginaConterTodosTextos("Inc�ndio", "Perda e pagamento de aluguel", "Vendaval at� fuma�a", "Responsabilidade civil familiar");
        salvarEvidencia("Validar Coberturas - RESIDENCIAL");
        return this;
    }

    /**
     * M�todo para validar Assist�ncias
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Assist�ncias - RESIDENCIAL")
    public InformacoesResidencialTela validarAssistencias() throws Exception {
        aguardarPaginaConterTodosTextos("Chaveiro", "Encanador", "Eletricista", "Vidraceiro");
        salvarEvidencia("Validar Assist�ncias - RESIDENCIAL");
        return this;
    }

    /**
     * M�todo para validar Dados do Parceiro
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Dados do Parceiro - RESIDENCIAL")
    public InformacoesResidencialTela validarDadosDoParceiro() throws Exception {
        aguardarPaginaConterTodosTextos("Seguradora", "Seguros", "Corretor");
        salvarEvidencia("Validar Dados do Parceiro - RESIDENCIAL");
        return this;
    }

    /**
     * M�todo para validar Cancelamento
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Cancelamento - RESIDENCIAL")
    public InformacoesResidencialTela validarCancelamento() throws Exception {
        aguardarPaginaConterTodosTextos("Voc� pode cancelar seu contrato quando quiser");
        salvarEvidencia("Validar Cancelamento - RESIDENCIAL");
        return this;
    }
}
