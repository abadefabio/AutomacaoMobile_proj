package pagina.mobile.jornadas.seguros.debito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.seguros.SegurosDebito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutoDebitoTela extends PaginaBase {

    public ProdutoDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela PRODUTO D�BITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSeguroDebito;

    // �cone (i) INFORMA��ES referente as CONDI��ES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/si_suffix_icon")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='termsCheckbox']/preceding-sibling::XCUIElementTypeOther)[2]")
    private MobileElement btnInfoCondicoesGerais;

    // bot�o SAIBA MAIS no bloco de informa��es do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@label='SAIBA MAIS'])[3]")
    private MobileElement btnSaibaMaisInfoParceiro;

    // checkbox de aceite dos termos e condi��es
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'termsCheckbox')]")
    private MobileElement checkboxAceiteCondicoesGerais;

    // bot�o CONTRATAR produto DEBITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'hireButton')]")
    private MobileElement btnConcluirContratacaoDebito;

    // bot�o VIS�O GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_overview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonOverview\"]/XCUIElementTypeOther")
    private MobileElement botaoVisaoGeral;

    // bot�o TELEFONES �TEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_useful_telephones")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonContactPhone\"]/XCUIElementTypeOther")
    private MobileElement botaoTelefonesUteis;

    // bot�o ACIONAR SEGURADORA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_footer_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"footerButton\"]")
    private MobileElement botaoAcionarSeguradora;

    /**
     * M�todo para validar tela do Produto D�bito
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Valida tela PRODUTO D�BITO")
    public ProdutoDebitoTela validaTelaProdutoDebito() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroDebito);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(SegurosDebito.TITULO_TELA_PRODUTO_DEBITO.toString()), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar a presen�a do T�tulo 'SEGURO D�BITO'!");
        salvarEvidencia("Tela PRODUTO D�BITO");
        return this;
    }

    /**
     * M�todo para Tocar no �cone (i) informa��es das condi��es
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (i) informa��es das condi��es")
    public ProdutoDebitoTela tocarBtnInfoTermosCondicoes() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnInfoCondicoesGerais)){
                salvarEvidencia("Tocar no �cone (i) informa��es das condi��es");
                tocarElemento(btnInfoCondicoesGerais, "N�o foi poss�vel tocar no �cone (i) informa��es das condi��es");
                break;
            }
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnInfoCondicoesGerais, "N�o foi poss�vel encontrar o �cone (i) informa��es das condi��es");
        }
        return this;
    }

    /**
     * M�todo para Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro")
    public ProdutoDebitoTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
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
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no checkbox de aceite das condi��es gerais")
    public ProdutoDebitoTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
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
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o <CONTRATAR>")
    public ProdutoDebitoTela tocarBtnContratar() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnConcluirContratacaoDebito)){
                salvarEvidencia("Tocar no bot�o <CONTRATAR>");
                tocarElemento(btnConcluirContratacaoDebito, "N�o foi poss�vel tocar no bot�o <CONTRATAR>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para tocar no bot�o TELEFONES �TEIS
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o TELEFONES �TEIS")
    public ProdutoDebitoTela tocarBotaoTelefonesUteis() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(botaoTelefonesUteis)){
                salvarEvidencia("Tocar no bot�o TELEFONES �TEIS");
                tocarElemento(botaoTelefonesUteis, "N�o foi poss�vel tocar no bot�o TELEFONES �TEIS.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para tocar no bot�o VIS�O GERAL
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o VIS�O GERAL")
    public ProdutoDebitoTela tocarBotaoVisaoGeral() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(botaoVisaoGeral)){
                salvarEvidencia("Tocar no bot�o VIS�O GERAL");
                tocarElemento(botaoVisaoGeral, "N�o foi poss�vel tocar no bot�o VIS�O GERAL.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para tocar no bot�o ACIONAR SEGURADORA
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o VIS�O GERAL")
    public ProdutoDebitoTela tocarBotaoAcionarSeguradora() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(botaoAcionarSeguradora)){
                salvarEvidencia("Tocar no bot�o ACIONAR SEGURADORA");
                tocarElemento(botaoAcionarSeguradora, "N�o foi poss�vel tocar no bot�o ACIONAR SEGURADORA.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
}
