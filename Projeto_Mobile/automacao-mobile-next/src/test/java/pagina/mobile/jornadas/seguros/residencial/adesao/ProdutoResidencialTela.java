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
    // T�tulo da tela PRODUTO RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSeguroResidencial;

    // bot�o SAIBA MAIS no bloco COBERTURA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_full_protection_know_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@value='Saiba Mais']")
    private MobileElement btnSaibaMaisCoberturas;

    // �cone (i) INFORMA��ES referente a CONDI��ES GERAIS
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, 'Li e aceito as condi��es gerais do seguro.')]/following::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement btnInfoCondicoesGerais;

    // bot�o SAIBA MAIS no bloco de informa��es do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@label='SAIBA MAIS'])[3]")
    private MobileElement btnSaibaMaisInfoParceiro;

    // checkbox de aceite das condi��es gerais
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'termsCheckbox')]")
    private MobileElement checkboxAceiteCondicoesGerais;

    // bot�o CONTRATAR produto RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'hireButton')]")
    private MobileElement btnConcluirContratacaoResidencial;

    // bot�o INFO "i"
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_option")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Informa��es\"]")
    private MobileElement botaoInfo;

    // bot�o VOLTAR "<"
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoVoltar;

    // bot�o VIS�O GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_overview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vis�o geral\"]")
    private MobileElement botaoVisaoGeral;

    // bot�o TELEFONES �TEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_useful_telephones")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Telefones �teis\"]")
    private MobileElement botaoTelefonesUteis;

    // bot�o ACIONAR SEGURADORA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_footer_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ACIONAR SEGURADORA\"]")
    private MobileElement botaoAcionarSeguradora;

    // bot�o VER TODOS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_residential_insurance_see_all")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ver Mais\"]")
    private MobileElement botaoVerTodos;

    // bot�o Lapis "edi��o"
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(accessibility = "editIcon")
    private MobileElement botaoLapisEdicao;
    /*     *************************     */

    /*
    M�todo para Valida tela PRODUTO RESIDENCIAL
     */
    @Step("Valida tela PRODUTO RESIDENCIAL")
    public ProdutoResidencialTela validaTelaProdutoResidencial() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroResidencial);
        compararElementoTexto(headerTituloSeguroResidencial, SegurosResidencial.TITULO_TELA_PRODUTO_RESIDENCIAL, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela \"PRODUTO RESIDENCIAL\"");
        return this;
    }

    /**
     * M�todo para Tocar caixa verde com o texto "Saiba mais" no bloco DETALHES DA COBERTURA
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DA COBERTURA")
    public ProdutoResidencialTela tocarBtnSaibaMaisDetalhesCoberturas() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(btnSaibaMaisCoberturas)) {
                salvarEvidencia("Clicar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DA COBERTURA.");
                tocarElemento(btnSaibaMaisCoberturas, "N�o foi poss�vel clicar no bot�o \"Saiba mais\" no bloco DETALHES DA COBERTURA.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para tocar no icone (i) informa��es das condi��es
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no �cone (i) informa��es das condi��es")
    public ProdutoResidencialTela tocarBtnInfoCondicoesGerais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnInfoCondicoesGerais, "N�o foi poss�vel encontrar o �cone '(i) infoma��es gerais'!");
        salvarEvidencia("Tocar no �cone (i) informa��es das condi��es");
        tocarElemento(btnInfoCondicoesGerais, "N�o foi poss�vel tocar no �cone (i) informa��es das condi��es");
        return this;
    }

    /**
     * M�todo para Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro")
    public ProdutoResidencialTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(btnSaibaMaisInfoParceiro)) {
                salvarEvidencia("Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro");
                tocarElemento(btnSaibaMaisInfoParceiro, "N�o foi poss�vel tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para Tocar no checkbox de aceite das condi��es gerais
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no checkbox de aceite das condi��es gerais")
    public ProdutoResidencialTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(checkboxAceiteCondicoesGerais)) {
                salvarEvidencia("Tocar no checkbox de aceite das condi��es gerais");
                tocarElemento(checkboxAceiteCondicoesGerais, "N�o foi poss�vel tocar no checkbox de aceite das condi��es gerais.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para Tocar no bot�o <CONTRATAR>
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o <CONTRATAR>")
    public ProdutoResidencialTela tocarBtnContratar() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(btnConcluirContratacaoResidencial)) {
                salvarEvidencia("Tocar no bot�o <CONTRATAR>");
                tocarElemento(btnConcluirContratacaoResidencial, "N�o foi poss�vel tocar no bot�o <CONTRATAR>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para Tocar no �cone (l�pis) editar endere�o
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no �cone (l�pis) editar endere�o")
    public ProdutoResidencialTela tocarBtnLapisEdicaoEndereco() throws Exception {

        esconderTeclado();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoLapisEdicao, "N�o foi poss�vel encontrar o �cone (l�pis) para edi��o!");
        salvarEvidencia("Tocar no �cone (l�pis) editar endere�o.");
        tocarElemento(botaoLapisEdicao, "N�o foi poss�vel clicar no �cone (l�pis) editar endere�o.");
        return this;
    }

    /**
     * M�todo para tocar no bot�o INFO
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o <INFO>")
    public ProdutoResidencialTela tocarBotaoInfo() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoInfo)) {
                salvarEvidencia("Tocar no bot�o <INFO>");
                tocarElemento(botaoInfo, "N�o foi poss�vel tocar no bot�o <INFO>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para tocar no bot�o TELEFONES �TEIS
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o TELEFONES �TEIS")
    public ProdutoResidencialTela tocarBotaoTelefonesUteis() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoTelefonesUteis)) {
                salvarEvidencia("Tocar no bot�o TELEFONES �TEIS");
                tocarElemento(botaoTelefonesUteis, "N�o foi poss�vel tocar no bot�o TELEFONES �TEIS");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para tocar no bot�o ACIONAR SEGURADORA
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o ACIONAR SEGURADORA")
    public ProdutoResidencialTela tocarBotaoAcionarSeguradora() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoAcionarSeguradora)) {
                salvarEvidencia("Tocar no bot�o ACIONAR SEGURADORA");
                tocarElemento(botaoAcionarSeguradora, "N�o foi poss�vel tocar no bot�o ACIONAR SEGURADORA");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para tocar no bot�o 'VIS�O GERAL'
     *
     * @return ProdutoResidencialTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'VIS�O GERAL'")
    public ProdutoResidencialTela tocarBotaoVisaoGeral() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoVisaoGeral)) {
                salvarEvidencia("Tocar no bot�o 'VIS�O GERAL'");
                tocarElemento(botaoVisaoGeral, "N�o foi poss�vel tocar no bot�o 'VIS�O GERAL'");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
}

