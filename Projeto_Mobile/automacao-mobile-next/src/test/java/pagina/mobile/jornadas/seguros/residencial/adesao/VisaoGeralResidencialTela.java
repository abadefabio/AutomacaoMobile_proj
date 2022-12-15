package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class VisaoGeralResidencialTela extends PaginaBase {

    public VisaoGeralResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela VIS�O GERAL RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VIS�O GERAL\"]")
    private MobileElement headerTituloVisaoGeralResidencial;

    // bot�o SAIBA MAIS no bloco COBERTURA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_full_protection_know_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Saiba Mais\"]")
    private MobileElement btnSaibaMaisCoberturas;

    // �cone (i) INFORMA��ES referente a CONDI��ES GERAIS
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, 'Li e aceito as condi��es gerais do seguro.')]/following::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement botaoInfoCondicoesGerais;

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

    // bot�o /  �cone (l�pis) edi��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"editIcon\"]")
    private MobileElement btnLapisEdicao;

    // bot�o Vis�o Geral
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vis�o geral\"]")
    private MobileElement botaoVisaoGeral;

    // bot�o Telefones �teis
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Telefones �teis\"]")
    private MobileElement botaoTelefonesUteis;

    // bot�o Acionar Seguradora
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ACIONAR SEGURADORA\"]")
    private MobileElement botaoAcionarSeguradora;

    // bot�o Info
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Informa��es\"]")
    private MobileElement botaoInfo;

    // Bot�o CANCELAR SEGURO "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_cancel_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CANCELAR SEGURO\"]")
    private MobileElement botaoCancelarSeguro;

    /**
     * M�todo para Validar tela VIS�O GERAL RESIDENCIAL
     *
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Valida tela VIS�O GERAL RESIDENCIAL")
    public VisaoGeralResidencialTela validaTelaVisaoGeralResidencial() throws Exception {
        aguardarCarregamentoElemento(headerTituloVisaoGeralResidencial);
        compararElementoTexto(headerTituloVisaoGeralResidencial, SegurosResidencial.TITULO_TELA_VISAO_GERAL, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela VIS�O GERAL RESIDENCIAL");
        return this;
    }

    /**
     * M�todo para Tocar caixa verde com o texto "Saiba mais" no bloco DETALHES DA COBERTURA
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DA COBERTURA")
    public VisaoGeralResidencialTela tocarBtnSaibaMaisDetalhesCoberturas() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnSaibaMaisCoberturas)){
                salvarEvidencia("Clicar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DA COBERTURA.");
                tocarElemento(btnSaibaMaisCoberturas, "N�o foi poss�vel clicar no bot�o \"Saiba mais\" no bloco DETALHES DA COBERTURA.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
    /**
     * M�todo para Tocar no �cone (i) informa��es das condi��es
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no �cone (i) informa��es das condi��es")
    public VisaoGeralResidencialTela tocarbotaoInfoCondicoesGerais() throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInfoCondicoesGerais, "N�o foi poss�vel encontrar o �cone '(i) infoma��es gerais'!");
        salvarEvidencia("Tocar no �cone (i) informa��es das condi��es");
        tocarElemento(botaoInfoCondicoesGerais, "N�o foi poss�vel tocar no �cone (i) informa��es das condi��es");
        return this;
    }
    /**
     * M�todo para Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro")
    public VisaoGeralResidencialTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnSaibaMaisInfoParceiro)){
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
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no checkbox de aceite das condi��es gerais")
    public VisaoGeralResidencialTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(checkboxAceiteCondicoesGerais)){
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
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no bot�o <CONTRATAR>")
    public VisaoGeralResidencialTela tocarBtnContratar() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnConcluirContratacaoResidencial)){
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
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no �cone (l�pis) editar endere�o")
    public VisaoGeralResidencialTela tocarBtnLapisEdicaoEndereco() throws Exception {

        esconderTeclado();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnLapisEdicao, "N�o foi poss�vel encontrar o �cone (l�pis) para edi��o!");
        salvarEvidencia("Tocar no �cone (l�pis) editar endere�o.");
        tocarElemento(btnLapisEdicao, "N�o foi poss�vel clicar no �cone (l�pis) editar endere�o.");
        return this;
    }

    /**
     * M�todo para tocar bot�o 'Cancelar Seguro'
     *
     * @return VisaoGeralResidencialTela
     * @throws Exception
     */
    @Step("Tocar Bot�o 'Cancelar Seguro'")
    public VisaoGeralResidencialTela tocarBotaoCancelarSeguro() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCancelarSeguro,"Bot�o 'CANCELAR SEGURO' n�o encontrado");
        aguardarCarregamentoElemento(botaoCancelarSeguro);
        salvarEvidencia("Tocar no bot�o 'Cancelar Seguro'");
        tocarElemento(botaoCancelarSeguro, "N�o foi poss�vel tocar no bot�o 'Cancelar Seguro'");
        return this;
    }

}
