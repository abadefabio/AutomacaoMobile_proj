package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutoResidencialTela extends PaginaBase {

    public ProdutoResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela PRODUTO RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSeguroResidencial;

    // botão SAIBA MAIS no bloco COBERTURA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_full_protection_know_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@value='Saiba Mais']")
    private MobileElement btnSaibaMaisCoberturas;

    // ícone (i) INFORMAÇÕES referente a CONDIÇÕES GERAIS
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, 'Li e aceito as condições gerais do seguro.')]/following::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement btnInfoCondicoesGerais;

    // botão SAIBA MAIS no bloco de informações do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@label='SAIBA MAIS'])[3]")
    private MobileElement btnSaibaMaisInfoParceiro;

    // checkbox de aceite das condições gerais
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'termsCheckbox')]")
    private MobileElement checkboxAceiteCondicoesGerais;

    // botão CONTRATAR produto RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'hireButton')]")
    private MobileElement btnConcluirContratacaoResidencial;

    // botão INFO "i"
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_option")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Informações\"]")
    private MobileElement botaoInfo;

    // botão VOLTAR "<"
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // botão VISÃO GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_overview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Visão geral\"]")
    private MobileElement botaoVisaoGeral;

    // botão TELEFONES ÚTEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_useful_telephones")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Telefones úteis\"]")
    private MobileElement botaoTelefonesUteis;

    // botão ACIONAR SEGURADORA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_footer_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ACIONAR SEGURADORA\"]")
    private MobileElement botaoAcionarSeguradora;

    // botão VER TODOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_residential_insurance_see_all")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ver Mais\"]")
    private MobileElement botaoVerTodos;

    // botão Lapis "edição"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(accessibility = "editIcon")
    private MobileElement botaoLapisEdicao;
    /*     *************************     */

    /*
    Método para Valida tela PRODUTO RESIDENCIAL
     */
    @Step("Valida tela PRODUTO RESIDENCIAL")
    public ProdutoResidencialTela validaTelaProdutoResidencial() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroResidencial);
        compararElementoTexto(headerTituloSeguroResidencial, SegurosResidencial.TITULO_TELA_PRODUTO_RESIDENCIAL, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela \"PRODUTO RESIDENCIAL\"");
        return this;
    }

    /**
     * Método para Tocar caixa verde com o texto "Saiba mais" no bloco DETALHES DA COBERTURA
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DA COBERTURA")
    public ProdutoResidencialTela tocarBtnSaibaMaisDetalhesCoberturas() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(btnSaibaMaisCoberturas)) {
                salvarEvidencia("Clicar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DA COBERTURA.");
                tocarElemento(btnSaibaMaisCoberturas, "Não foi possível clicar no botão \"Saiba mais\" no bloco DETALHES DA COBERTURA.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para tocar no icone (i) informações das condições
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no ícone (i) informações das condições")
    public ProdutoResidencialTela tocarBtnInfoCondicoesGerais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnInfoCondicoesGerais, "Não foi possível encontrar o ícone '(i) infomações gerais'!");
        salvarEvidencia("Tocar no ícone (i) informações das condições");
        tocarElemento(btnInfoCondicoesGerais, "Não foi possível tocar no ícone (i) informações das condições");
        return this;
    }

    /**
     * Método para Tocar no botão <SAIBA MAIS> na seção de informações do parceiro
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro")
    public ProdutoResidencialTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(btnSaibaMaisInfoParceiro)) {
                salvarEvidencia("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro");
                tocarElemento(btnSaibaMaisInfoParceiro, "Não foi possível tocar no botão <SAIBA MAIS> na seção de informações do parceiro.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para Tocar no checkbox de aceite das condições gerais
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no checkbox de aceite das condições gerais")
    public ProdutoResidencialTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(checkboxAceiteCondicoesGerais)) {
                salvarEvidencia("Tocar no checkbox de aceite das condições gerais");
                tocarElemento(checkboxAceiteCondicoesGerais, "Não foi possível tocar no checkbox de aceite das condições gerais.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para Tocar no botão <CONTRATAR>
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão <CONTRATAR>")
    public ProdutoResidencialTela tocarBtnContratar() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(btnConcluirContratacaoResidencial)) {
                salvarEvidencia("Tocar no botão <CONTRATAR>");
                tocarElemento(btnConcluirContratacaoResidencial, "Não foi possível tocar no botão <CONTRATAR>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para Tocar no ícone (lápis) editar endereço
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no ícone (lápis) editar endereço")
    public ProdutoResidencialTela tocarBtnLapisEdicaoEndereco() throws Exception {

        esconderTeclado();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoLapisEdicao, "Não foi possível encontrar o ícone (lápis) para edição!");
        salvarEvidencia("Tocar no ícone (lápis) editar endereço.");
        tocarElemento(botaoLapisEdicao, "Não foi possível clicar no ícone (lápis) editar endereço.");
        return this;
    }

    /**
     * Método para tocar no botão INFO
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão <INFO>")
    public ProdutoResidencialTela tocarBotaoInfo() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoInfo)) {
                salvarEvidencia("Tocar no botão <INFO>");
                tocarElemento(botaoInfo, "Não foi possível tocar no botão <INFO>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para tocar no botão TELEFONES ÚTEIS
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão TELEFONES ÚTEIS")
    public ProdutoResidencialTela tocarBotaoTelefonesUteis() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoTelefonesUteis)) {
                salvarEvidencia("Tocar no botão TELEFONES ÚTEIS");
                tocarElemento(botaoTelefonesUteis, "Não foi possível tocar no botão TELEFONES ÚTEIS");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para tocar no botão ACIONAR SEGURADORA
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão ACIONAR SEGURADORA")
    public ProdutoResidencialTela tocarBotaoAcionarSeguradora() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoAcionarSeguradora)) {
                salvarEvidencia("Tocar no botão ACIONAR SEGURADORA");
                tocarElemento(botaoAcionarSeguradora, "Não foi possível tocar no botão ACIONAR SEGURADORA");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para tocar no botão 'VISÃO GERAL'
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no botão 'VISÃO GERAL'")
    public ProdutoResidencialTela tocarBotaoVisaoGeral() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoVisaoGeral)) {
                salvarEvidencia("Tocar no botão 'VISÃO GERAL'");
                tocarElemento(botaoVisaoGeral, "Não foi possível tocar no botão 'VISÃO GERAL'");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
}

