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
    // Título da tela PRODUTO VIDA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSeguroVida;

    // botão SAIBA MAIS no bloco INDENIZAÇÃO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_life_insurance_know_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Saiba Mais\"]")
    private MobileElement btnSaibaMaisCoberturas;

    // ícone (i) INFORMAÇÕES referente a CONDIÇÕES GERAIS
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, 'Li e aceito as condições gerais do seguro')]/following::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement btnInfoCondicoesGerais;

    // botão SAIBA MAIS no bloco de informações do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'detailsButton')])[last()]")
    private MobileElement btnSaibaMaisInfoParceiro;

    // campo "Selecionar Ocupação"
    @AndroidFindBy(id = "br.com.bradesco.next:id/icon_choose")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"occupationLabel\"]")
    private MobileElement campoSelecionarOcupacao;

    // checkbox de aceite das condições gerais
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"termsCheckbox\"]/XCUIElementTypeOther")
    private MobileElement checkboxAceiteCondicoesGerais;

    // botão CONTRATAR produto VIDA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"hireButton\"]")
    private MobileElement btnConcluirContratacaoResidencial;
    /*     *************************     */

    /*
    Método para Valida tela PRODUTO VIDA
     */
    @Step("Valida tela PRODUTO VIDA")
    public ProdutoVidaTela validaTelaProdutoVida() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroVida);
        compararElementoTexto(headerTituloSeguroVida, SegurosVida.TITULO_TELA_PRODUTO_VIDA, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela PRODUTO VIDA");
        return this;
    }

    /*
    Método para Tocar caixa verde com o texto "Saiba mais" no bloco INDENIZAÇÃO
     */
    @Step("Tocar caixa verde com o texto \"Saiba mais\" no bloco INDENIZAÇÃO")
    public ProdutoVidaTela tocarBtnSaibaMaisIndenizacao() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnSaibaMaisCoberturas)){
                salvarEvidencia("Tocar caixa verde com o texto \"Saiba mais\" no bloco INDENIZAÇÃO.");
                tocarElemento(btnSaibaMaisCoberturas, "Não foi possível tocar no botão \"Saiba mais\" no bloco INDENIZAÇÃO.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /*
    Método para Tocar no ícone (i) informações das condições
     */
    @Step("Tocar no ícone (i) informações das condições")
    public ProdutoVidaTela tocarBtnInfoCondicoesGerais() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnInfoCondicoesGerais)){
                salvarEvidencia("Tocar no ícone (i) informações das condições");
                tocarElemento(btnInfoCondicoesGerais, "Não foi possível tocar no ícone (i) informações das condições");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /*
    Método para Tocar no botão <SAIBA MAIS> na seção de informações do parceiro
     */
    @Step("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro")
    public ProdutoVidaTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnSaibaMaisInfoParceiro)){
                salvarEvidencia("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro");
                tocarElemento(btnSaibaMaisInfoParceiro, "Não foi possível tocar no botão <SAIBA MAIS> na seção de informações do parceiro.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
}
