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
    // Título da tela PRODUTO DÉBITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloSeguroDebito;

    // ícone (i) INFORMAÇÕES referente as CONDIÇÕES GERAIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/si_suffix_icon")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='termsCheckbox']/preceding-sibling::XCUIElementTypeOther)[2]")
    private MobileElement btnInfoCondicoesGerais;

    // botão SAIBA MAIS no bloco de informações do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@label='SAIBA MAIS'])[3]")
    private MobileElement btnSaibaMaisInfoParceiro;

    // checkbox de aceite dos termos e condições
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'termsCheckbox')]")
    private MobileElement checkboxAceiteCondicoesGerais;

    // botão CONTRATAR produto DEBITO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'hireButton')]")
    private MobileElement btnConcluirContratacaoDebito;

    // botão VISÃO GERAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_overview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonOverview\"]/XCUIElementTypeOther")
    private MobileElement botaoVisaoGeral;

    // botão TELEFONES ÚTEIS
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_useful_telephones")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonContactPhone\"]/XCUIElementTypeOther")
    private MobileElement botaoTelefonesUteis;

    // botão ACIONAR SEGURADORA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_footer_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"footerButton\"]")
    private MobileElement botaoAcionarSeguradora;

    /**
     * Método para validar tela do Produto Débito
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Valida tela PRODUTO DÉBITO")
    public ProdutoDebitoTela validaTelaProdutoDebito() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroDebito);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(SegurosDebito.TITULO_TELA_PRODUTO_DEBITO.toString()), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar a presença do Título 'SEGURO DÉBITO'!");
        salvarEvidencia("Tela PRODUTO DÉBITO");
        return this;
    }

    /**
     * Método para Tocar no ícone (i) informações das condições
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (i) informações das condições")
    public ProdutoDebitoTela tocarBtnInfoTermosCondicoes() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnInfoCondicoesGerais)){
                salvarEvidencia("Tocar no ícone (i) informações das condições");
                tocarElemento(btnInfoCondicoesGerais, "Não foi possível tocar no ícone (i) informações das condições");
                break;
            }
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnInfoCondicoesGerais, "Não foi possível encontrar o ícone (i) informações das condições");
        }
        return this;
    }

    /**
     * Método para Tocar no botão <SAIBA MAIS> na seção de informações do parceiro
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro")
    public ProdutoDebitoTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
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

    /**
     * Método para Tocar no checkbox de aceite das condições gerais
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no checkbox de aceite das condições gerais")
    public ProdutoDebitoTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(checkboxAceiteCondicoesGerais)){
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
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no botão <CONTRATAR>")
    public ProdutoDebitoTela tocarBtnContratar() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnConcluirContratacaoDebito)){
                salvarEvidencia("Tocar no botão <CONTRATAR>");
                tocarElemento(btnConcluirContratacaoDebito, "Não foi possível tocar no botão <CONTRATAR>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para tocar no botão TELEFONES ÚTEIS
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no botão TELEFONES ÚTEIS")
    public ProdutoDebitoTela tocarBotaoTelefonesUteis() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(botaoTelefonesUteis)){
                salvarEvidencia("Tocar no botão TELEFONES ÚTEIS");
                tocarElemento(botaoTelefonesUteis, "Não foi possível tocar no botão TELEFONES ÚTEIS.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para tocar no botão VISÃO GERAL
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no botão VISÃO GERAL")
    public ProdutoDebitoTela tocarBotaoVisaoGeral() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(botaoVisaoGeral)){
                salvarEvidencia("Tocar no botão VISÃO GERAL");
                tocarElemento(botaoVisaoGeral, "Não foi possível tocar no botão VISÃO GERAL.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }

    /**
     * Método para tocar no botão ACIONAR SEGURADORA
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no botão VISÃO GERAL")
    public ProdutoDebitoTela tocarBotaoAcionarSeguradora() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(botaoAcionarSeguradora)){
                salvarEvidencia("Tocar no botão ACIONAR SEGURADORA");
                tocarElemento(botaoAcionarSeguradora, "Não foi possível tocar no botão ACIONAR SEGURADORA.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
}
