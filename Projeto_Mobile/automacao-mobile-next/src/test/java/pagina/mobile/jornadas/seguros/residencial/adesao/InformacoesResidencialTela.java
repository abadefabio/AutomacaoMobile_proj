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
    // botão FECHAR (X)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    // botão EXPANDIR COBERTURAS
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Expandir\"]")
    private MobileElement botaoExpandirCoberturas;

    // botão COLAPSAR COBERTURAS
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[1]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Coberturas Colapsar\"]")
    private MobileElement botaoColapsarCoberturas;

    // botão EXPANDIR ASSISTÊNCIAS
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Assistências Expandir\"]")
    private MobileElement botaoExpandirAssistencias;

    // botão COLAPSAR ASSISTÊNCIAS
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[2]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Assistências Colapsar\"]")
    private MobileElement botaoColapsarAssistencias;

    // botão EXPANDIR DADOS DO PARCEIRO
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Expandir\"]")
    private MobileElement botaoExpandirDadosDoParceiro;

    // botão COLAPSAR DADOS DO PARCEIRO
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[3]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Dados do parceiro Colapsar\"]")
    private MobileElement botaoColapsarDadosDoParceiro;

    // botão EXPANDIR CANCELAMENTO
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Expandir\"]")
    private MobileElement botaoExpandirCancelamento;

    // botão COLAPSAR CANCELAMENTO
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement botaoColapsarCancelamento;

    // texto Coberturas
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement textoBotaoCoberturas;

    // texto Assistências
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement textoBotaoAssistencias;

    // texto Dados do Parceiro
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement textoBotaoDadosDoParceiro;

    // texto Cancelamento
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@content-desc=\"Expandir, botão\"])[4]/android.widget.LinearLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Cancelamento Colapsar\"]")
    private MobileElement textoBotaoCancelamento;

    /**
     * Método para tocar no botão FECHAR "X" da tela INFO RESIDENCIAL
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no ícone (X) fechar")
    public InformacoesResidencialTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(botaoFechar, "Não foi possível tocar no ícone (X) fechar");
        return this;
    }

    /**
     * Método para tocar no botão EXPANDIR COBERTURAS
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão Expandir Coberturas")
    public InformacoesResidencialTela tocarBotaoExpandirCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirCoberturas);
        salvarEvidencia("Tocar no botão Expandir Coberturas");
        tocarElemento(botaoExpandirCoberturas, "Não foi possível tocar no botão Expandir Coberturas");
        return this;
    }

    /**
     * Método para tocar no botão COLAPSAR COBERTURAS
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão Colapsar Coberturas")
    public InformacoesResidencialTela tocarBotaoColapsarCoberturas() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarCoberturas);
        salvarEvidencia("Tocar no botão Colapsar Coberturas");
        tocarElemento(botaoColapsarCoberturas, "Não foi possível tocar no botão Colapsar Coberturas");
        return this;
    }

    /**
     * Método para tocar no botão EXPANDIR ASSISTÊNCIAS
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão Expandir Assistências")
    public InformacoesResidencialTela tocarBotaoExpandirAssistencias() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirAssistencias);
        salvarEvidencia("Tocar no botão Expandir Assistências");
        tocarElemento(botaoExpandirAssistencias, "Não foi possível tocar no botão Expandir Assistências");
        return this;
    }

    /**
     * Método para tocar no botão COLAPSAR ASSISTÊNCIAS
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão Colapsar Assistências")
    public InformacoesResidencialTela tocarBotaoColapsarAssistencias() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarAssistencias);
        salvarEvidencia("Tocar no botão Colapsar Assistências");
        tocarElemento(botaoColapsarAssistencias, "Não foi possível tocar no botão Colapsar Assistências");
        return this;
    }

    /**
     * Método para tocar no botão EXPANDIR DADOS DO PARCEIRO
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão Expandir Dados do parceiro")
    public InformacoesResidencialTela tocarBotaoExpandirDadosDoParceiro() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirDadosDoParceiro);
        salvarEvidencia("Tocar no botão Expandir Dados do parceiro");
        tocarElemento(botaoExpandirDadosDoParceiro, "Não foi possível tocar no botão Expandir Dados do parceiro");
        return this;
    }

    /**
     * Método para tocar no botão COLAPSAR DADOS DO PARCEIRO
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão Colapsar Dados do parceiro")
    public InformacoesResidencialTela tocarBotaoColapsarDadosDoParceiro() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarDadosDoParceiro);
        salvarEvidencia("Tocar no botão Colapsar Dados do parceiro");
        tocarElemento(botaoColapsarDadosDoParceiro, "Não foi possível tocar no botão Colapsar Dados do parceiro");
        return this;
    }

    /**
     * Método para tocar no botão EXPANDIR CANCELAMENTO
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão Expandir Cancelamento")
    public InformacoesResidencialTela tocarBotaoExpandirCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoExpandirCancelamento);
        salvarEvidencia("Tocar no botão Expandir Cancelamento");
        tocarElemento(botaoExpandirCancelamento, "Não foi possível tocar no botão Expandir Cancelamento");
        return this;
    }

    /**
     * Método para tocar no botão COLAPSAR CANCELAMENTO
     *
     * @return InformacoesResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão Colapsar Cancelamento")
    public InformacoesResidencialTela tocarBotaoColapsarCancelamento() throws Exception {
        aguardarCarregamentoElemento(botaoColapsarCancelamento);
        salvarEvidencia("Tocar no botão Colapsar Cancelamento");
        tocarElemento(botaoColapsarCancelamento, "Não foi possível tocar no botão Colapsar Cancelamento");
        return this;
    }

    /**
     * Método para validar Tela de Informações Residencial
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Tela de Informações - RESIDENCIAL")
    public InformacoesResidencialTela validarTelaInfomacoesResidencial() throws Exception {
        aguardarPaginaConterTodosTextos("Coberturas", "Assistências", "Dados do parceiro", "Cancelamento");
        salvarEvidencia("Validar Tela de Informações - RESIDENCIAL");
        return this;
    }

    /**
     * Método para validar Coberturas
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Coberturas - RESIDENCIAL")
    public InformacoesResidencialTela validarCoberturas() throws Exception {
        aguardarPaginaConterTodosTextos("Incêndio", "Perda e pagamento de aluguel", "Vendaval até fumaça", "Responsabilidade civil familiar");
        salvarEvidencia("Validar Coberturas - RESIDENCIAL");
        return this;
    }

    /**
     * Método para validar Assistências
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Assistências - RESIDENCIAL")
    public InformacoesResidencialTela validarAssistencias() throws Exception {
        aguardarPaginaConterTodosTextos("Chaveiro", "Encanador", "Eletricista", "Vidraceiro");
        salvarEvidencia("Validar Assistências - RESIDENCIAL");
        return this;
    }

    /**
     * Método para validar Dados do Parceiro
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
     * Método para validar Cancelamento
     * @throws Exception
     * @return InformacoesResidencialTela
     */
    @Step("Validar Cancelamento - RESIDENCIAL")
    public InformacoesResidencialTela validarCancelamento() throws Exception {
        aguardarPaginaConterTodosTextos("Você pode cancelar seu contrato quando quiser");
        salvarEvidencia("Validar Cancelamento - RESIDENCIAL");
        return this;
    }
}
