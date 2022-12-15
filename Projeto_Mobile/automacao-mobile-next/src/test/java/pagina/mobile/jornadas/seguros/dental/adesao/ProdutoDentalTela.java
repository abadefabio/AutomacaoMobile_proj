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
    // Título da tela PRODUTO DENTAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PLANO DENTAL\"]")
    private MobileElement headerSeguroDental;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SEGUROS']")
    private MobileElement headerSeguros;

    // botão SAIBA MAIS no bloco de detalhes do plano
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_know_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@value= 'Saiba mais']")
    private MobileElement botaoSaibaMaisDetalhesPlano;

    // ícone (i) INFORMAÇÕES referente a CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/si_suffix_icon")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement botaoInfoCondicoesGerais;

    // botão SAIBA MAIS no bloco de informações do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='detailsButton'])[3]")
    private MobileElement botaoSaibaMaisInfoParceiro;

    // botão TELEFONES UTEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_useful_telephones")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonContactPhone\"]/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement botaoTelefonesUteis;

    // checkbox de aceite dos termos e condições
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'termsCheckbox')]")
    private MobileElement checkboxAceiteCondicoesGerais;

    // botão CONTRATAR produto dental
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'hireButton')]")
    private MobileElement botaoConcluirContratacaoDental;

    // botão VISAO GERAL produto dental
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_overview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonOverview\"]/XCUIElementTypeOther")
    private MobileElement botaoVisaoGeral;

    /**
     * Método para Validar tela PRODUTO DENTAL
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
     * Método para Validar tela SEGUROS
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
     * Método para Tocar caixa verde com o texto "Saiba mais" no bloco DETALHES DO PLANO.
     * @return ProdutoDentalTela
     * @throws Exception
     **/
    @Step("Tocar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DO PLANO.")
    public ProdutoDentalTela tocarBtnSaibaMaisDetalhesPlano() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoSaibaMaisDetalhesPlano)) {
                salvarEvidencia("Tocar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DO PLANO.");
                tocarElemento(botaoSaibaMaisDetalhesPlano, "Não foi possível tocar no botão \"Saiba mais\" no bloco DETALHES DO PLANO.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para Tocar no ícone (i) informações das condições
     * @return ProdutoDentalTela
     * @throws Exception
     **/
    @Step("Tocar no ícone (i) informações das condições")
    public ProdutoDentalTela tocarBtnInfoCondicoesGerais() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoInfoCondicoesGerais)) {
                salvarEvidencia("Tocar no ícone (i) informações das condições");
                tocarElemento(botaoInfoCondicoesGerais, "Não foi possível tocar no ícone (i) informações das condições");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para Tocar no botão <SAIBA MAIS> na seção de informações do parceiro
     * @return ProdutoDentalTela
     * @throws Exception
     */
    @Step("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro")
    public ProdutoDentalTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoSaibaMaisInfoParceiro)) {
                salvarEvidencia("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro");
                tocarElemento(botaoSaibaMaisInfoParceiro, "Não foi possível tocar no botão <SAIBA MAIS> na seção de informações do parceiro.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para Tocar no checkbox de aceite das condições gerais
     * @return ProdutoDentalTela
     * @throws Exception
     **/
    @Step("Tocar no checkbox de aceite das condições gerais")
    public ProdutoDentalTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
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
     * @return ProdutoDentalTela
     * @throws Exception
     **/
    @Step("Tocar no botão <CONTRATAR>")
    public ProdutoDentalTela tocarBtnContratar() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoConcluirContratacaoDental)) {
                salvarEvidencia("Tocar no botão <CONTRATAR>");
                tocarElemento(botaoConcluirContratacaoDental, "Não foi possível tocar no botão <CONTRATAR>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para Tocar no botão <TELEFONES UTEIS>
     * @return TelefonesUteisDentalTela
     * @throws Exception
     */
    @Step("Tocar no botão '<TELEFONES UTEIS>'")
    public ProdutoDentalTela tocarBotaoTelefonesUteisDental() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoTelefonesUteis)) {
                salvarEvidencia("Tocar no botão <TELEFONES UTEIS DENTAL>");
                tocarElemento(botaoTelefonesUteis, "Não foi possível tocar no botão '<TELEFONES UTEIS>'");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para Tocar no botão <VISAO GERAL>
     * @return VisaoGeralDentalTela
     * @throws Exception
     */
    @Step("Tocar no botão <VISAO GERAL>")
    public ProdutoDentalTela tocarBotaoVisaoGeral() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (verificarPresencaElemento(botaoVisaoGeral)) {
                salvarEvidencia("Tocar no botão VISAO GERAL");
                tocarElemento(botaoVisaoGeral, "Não foi possível tocar no botão VISAO GERAL");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
}
