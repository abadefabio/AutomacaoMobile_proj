package pagina.mobile.jornadas.seguros.vida.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosVida;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutoVidaTela extends PaginaBase {

    public ProdutoVidaTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela PRODUTO VIDA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSeguroVida;

    // bot�o SAIBA MAIS no bloco INDENIZA��O
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_life_insurance_know_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Saiba Mais\"]")
    private MobileElement btnSaibaMaisCoberturas;

    // �cone (i) INFORMA��ES referente a CONDI��ES GERAIS
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, 'Li e aceito as condi��es gerais do seguro')]/following::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement btnInfoCondicoesGerais;

    // bot�o SAIBA MAIS no bloco de informa��es do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'detailsButton')])[last()]")
    private MobileElement btnSaibaMaisInfoParceiro;

    // campo "Selecionar Ocupa��o"
    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_choose")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"occupationLabel\"]")
    private MobileElement campoSelecionarOcupacao;

    // checkbox de aceite das condi��es gerais
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"termsCheckbox\"]/XCUIElementTypeOther")
    private MobileElement checkboxAceiteCondicoesGerais;

    // bot�o CONTRATAR produto VIDA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"hireButton\"]")
    private MobileElement btnConcluirContratacaoResidencial;
    /*     *************************     */

    /*
    M�todo para Valida tela PRODUTO VIDA
     */
    @Step("Valida tela PRODUTO VIDA")
    public ProdutoVidaTela validaTelaProdutoVida() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroVida);
        compararElementoTexto(headerTituloSeguroVida, SegurosVida.TITULO_TELA_PRODUTO_VIDA, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela PRODUTO VIDA");
        return this;
    }

    /*
    M�todo para Tocar caixa verde com o texto "Saiba mais" no bloco INDENIZA��O
     */
    @Step("Tocar caixa verde com o texto \"Saiba mais\" no bloco INDENIZA��O")
    public ProdutoVidaTela tocarBtnSaibaMaisIndenizacao() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnSaibaMaisCoberturas)){
                salvarEvidencia("Tocar caixa verde com o texto \"Saiba mais\" no bloco INDENIZA��O.");
                tocarElemento(btnSaibaMaisCoberturas, "N�o foi poss�vel tocar no bot�o \"Saiba mais\" no bloco INDENIZA��O.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /*
    M�todo para Tocar no �cone (i) informa��es das condi��es
     */
    @Step("Tocar no �cone (i) informa��es das condi��es")
    public ProdutoVidaTela tocarBtnInfoCondicoesGerais() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnInfoCondicoesGerais)){
                salvarEvidencia("Tocar no �cone (i) informa��es das condi��es");
                tocarElemento(btnInfoCondicoesGerais, "N�o foi poss�vel tocar no �cone (i) informa��es das condi��es");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /*
    M�todo para Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro
     */
    @Step("Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro")
    public ProdutoVidaTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
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
}
