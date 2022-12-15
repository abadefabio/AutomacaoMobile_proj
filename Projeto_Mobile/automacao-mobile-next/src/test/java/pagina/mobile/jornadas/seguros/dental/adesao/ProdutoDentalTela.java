package pagina.mobile.jornadas.seguros.dental.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosDental;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutoDentalTela extends PaginaBase {

    public ProdutoDentalTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela PRODUTO DENTAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PLANO DENTAL\"]")
    private MobileElement headerSeguroDental;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SEGUROS']")
    private MobileElement headerSeguros;

    // bot�o SAIBA MAIS no bloco de detalhes do plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_know_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@value= 'Saiba mais']")
    private MobileElement botaoSaibaMaisDetalhesPlano;

    // �cone (i) INFORMA��ES referente a CONDI��ES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/si_suffix_icon")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement botaoInfoCondicoesGerais;

    // bot�o SAIBA MAIS no bloco de informa��es do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='detailsButton'])[3]")
    private MobileElement botaoSaibaMaisInfoParceiro;

    // bot�o TELEFONES UTEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_useful_telephones")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonContactPhone\"]/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement botaoTelefonesUteis;

    // checkbox de aceite dos termos e condi��es
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'termsCheckbox')]")
    private MobileElement checkboxAceiteCondicoesGerais;

    // bot�o CONTRATAR produto dental
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'hireButton')]")
    private MobileElement botaoConcluirContratacaoDental;

    // bot�o VISAO GERAL produto dental
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_overview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonOverview\"]/XCUIElementTypeOther")
    private MobileElement botaoVisaoGeral;

    /**
     * M�todo para Validar tela PRODUTO DENTAL
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Valida tela PRODUTO DENTAL")
    public ProdutoDentalTela validaTelaProdutoDental() throws Exception {
        aguardarCarregamentoElemento(headerSeguroDental);
        compararElementoTexto(headerSeguroDental, SegurosDental.TITULO_TELA_PRODUTO_DENTAL, MetodoComparacao.IGUAL);
        salvarEvidencia("Validar tela Produto Dental");
        return this;
    }

    /**
     * M�todo para Validar tela SEGUROS
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Valida tela SEGUROS")
    public ProdutoDentalTela validaTelaSeguros() throws Exception {
        aguardarCarregamentoElemento(headerSeguros);
        compararElementoTexto(headerSeguros, SegurosDental.TITULO_TELA_SEGUROS, MetodoComparacao.IGUAL);
        salvarEvidencia("Validar tela Seguros");
        return this;
    }

    /**
     * M�todo para Tocar caixa verde com o texto "Saiba mais" no bloco DETALHES DO PLANO.
     * @return ProdutoDentalTela
     * @throws Exception
     **/
    @Step("Tocar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DO PLANO.")
    public ProdutoDentalTela tocarBtnSaibaMaisDetalhesPlano() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoSaibaMaisDetalhesPlano)) {
                salvarEvidencia("Tocar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DO PLANO.");
                tocarElemento(botaoSaibaMaisDetalhesPlano, "N�o foi poss�vel tocar no bot�o \"Saiba mais\" no bloco DETALHES DO PLANO.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para Tocar no �cone (i) informa��es das condi��es
     * @return ProdutoDentalTela
     * @throws Exception
     **/
    @Step("Tocar no �cone (i) informa��es das condi��es")
    public ProdutoDentalTela tocarBtnInfoCondicoesGerais() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoInfoCondicoesGerais)) {
                salvarEvidencia("Tocar no �cone (i) informa��es das condi��es");
                tocarElemento(botaoInfoCondicoesGerais, "N�o foi poss�vel tocar no �cone (i) informa��es das condi��es");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro")
    public ProdutoDentalTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoSaibaMaisInfoParceiro)) {
                salvarEvidencia("Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro");
                tocarElemento(botaoSaibaMaisInfoParceiro, "N�o foi poss�vel tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para Tocar no checkbox de aceite das condi��es gerais
     * @return ProdutoDentalTela
     * @throws Exception
     **/
    @Step("Tocar no checkbox de aceite das condi��es gerais")
    public ProdutoDentalTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
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
     * @return ProdutoDentalTela
     * @throws Exception
     **/
    @Step("Tocar no bot�o <CONTRATAR>")
    public ProdutoDentalTela tocarBtnContratar() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoConcluirContratacaoDental)) {
                salvarEvidencia("Tocar no bot�o <CONTRATAR>");
                tocarElemento(botaoConcluirContratacaoDental, "N�o foi poss�vel tocar no bot�o <CONTRATAR>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para Tocar no bot�o <TELEFONES UTEIS>
     * @return TelefonesUteisDentalTela
     * @throws Exception
     */
    @Step("Tocar no bot�o '<TELEFONES UTEIS>'")
    public ProdutoDentalTela tocarBotaoTelefonesUteisDental() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoTelefonesUteis)) {
                salvarEvidencia("Tocar no bot�o <TELEFONES UTEIS DENTAL>");
                tocarElemento(botaoTelefonesUteis, "N�o foi poss�vel tocar no bot�o '<TELEFONES UTEIS>'");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * M�todo para Tocar no bot�o <VISAO GERAL>
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Tocar no bot�o <VISAO GERAL>")
    public ProdutoDentalTela tocarBotaoVisaoGeral() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoVisaoGeral)) {
                salvarEvidencia("Tocar no bot�o VISAO GERAL");
                tocarElemento(botaoVisaoGeral, "N�o foi poss�vel tocar no bot�o VISAO GERAL");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
}
