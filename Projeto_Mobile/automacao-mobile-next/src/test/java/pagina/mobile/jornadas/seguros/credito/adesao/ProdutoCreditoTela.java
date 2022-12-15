package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosCredito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ProdutoCreditoTela extends PaginaBase {

    public ProdutoCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SEGUROS']")
    private MobileElement headerTituloSeguroCredito;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SEGURO CRÉDITO']")
    private MobileElement headerTituloSeguroCreditoMeusSeguros;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, 'Li e aceito as condições gerais do seguro.')]/following::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement botaoInfoCondicoesGerais;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//*[contains(@value,'SAIBA MAIS')])[3]")
    private MobileElement botaoSaibaMaisInfoParceiro;

    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'termsCheckbox')]")
    private MobileElement checkboxAceiteTermosCondicoes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'hireButton')]")
    private MobileElement botaoConcluirContratacaoCredito;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_footer_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonContactPhone\"]/XCUIElementTypeOther")
    private MobileElement botaoAcionarSeguradora;

    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_overview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonOverview\"]/XCUIElementTypeOther")
    private MobileElement botaoVisaoGeral;

    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_useful_telephones")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"buttonContactPhone\"]/XCUIElementTypeOther")
    private MobileElement botaoTelefonesUteis;

    /**
     * Valida Tela 'Produto Crédito'
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Valida Tela 'Produto Crédito'")
    public ProdutoCreditoTela validaTelaProdutoCredito() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroCredito);
        compararElementoTexto(headerTituloSeguroCredito, SegurosCredito.TITULO_TELA_PRODUTO_CREDITO, MetodoComparacao.IGUAL);
        salvarEvidencia("Validou Tela 'Produto Crédito'");
        return this;
    }

    /**
     * Valida Tela 'Produto Crédito' Meus Seguros
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Valida Tela 'Produto Crédito' Meus Seguros")
    public ProdutoCreditoTela validaTelaProdutoCreditoMeusSeguros() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroCreditoMeusSeguros);
        compararElementoTexto(headerTituloSeguroCreditoMeusSeguros, SegurosCredito.TITULO_TELA_PRODUTO_CREDITO_MEUS_SEGUROS, MetodoComparacao.IGUAL);
        salvarEvidencia("Validou Tela 'Produto Crédito'");
        return this;
    }

    /**
     * Tocar no ícone (i) informações das condições
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no ícone (i) informações das condições")
    public ProdutoCreditoTela tocarBotaoInfoCondicoesGerais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInfoCondicoesGerais, "Não foi possível tocar no ícone (i) informações das condições");
        salvarEvidencia("Tocar no ícone (i) informações das condições");
        tocarElemento(botaoInfoCondicoesGerais, "Não foi possível tocar no ícone (i) informações das condições");
        return this;
    }

    /**
     * Tocar no botão 'Saiba Mais' na seção de informações do parceiro
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Saiba Mais' na seção de informações do parceiro")
    public ProdutoCreditoTela tocarBotaoSaibaMaisInfoParceiro() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSaibaMaisInfoParceiro, "Não foi possível encontrar o botão <SAIBA MAIS> na seção de informações do parceiro.");
        salvarEvidencia("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro");
        tocarElemento(botaoSaibaMaisInfoParceiro, "Não foi possível tocar no botão <SAIBA MAIS> na seção de informações do parceiro.");
        return this;
    }

    /**
     * Tocar no checkbox de 'Aceite das condições gerais'
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no checkbox de 'Aceite das condições gerais'")
    public ProdutoCreditoTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkboxAceiteTermosCondicoes, "Não foi possível encontrar o checkbox de aceite das condições gerais.");
        salvarEvidencia("Tocar no checkbox de aceite das condições gerais");
        tocarElemento(checkboxAceiteTermosCondicoes, "Não foi possível tocar no checkbox de aceite das condições gerais.");

        return this;
    }

    /**
     * Tocar no botão 'Contratar'
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Contratar'")
    public ProdutoCreditoTela tocarBotaoContratar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConcluirContratacaoCredito, "Não foi possível encontrar no botão <CONTRATAR>.");
        salvarEvidencia("Tocar no botão <CONTRATAR>");
        tocarElemento(botaoConcluirContratacaoCredito, "Não foi possível tocar no botão <CONTRATAR>.");

        return this;
    }

    /**
     * Método para tocar no botão VISÃO GERAL
     *
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no botão VISÃO GERAL")
    public ProdutoCreditoTela tocarBotaoVisaoGeral() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVisaoGeral, "Não foi possível econtrar o botão VISÃO GERAL.");
        salvarEvidencia("Tocar no botão VISÃO GERAL");
        tocarElemento(botaoVisaoGeral, "Não foi possível tocar no botão VISÃO GERAL.");
        return this;
    }

    /**
     * Método para tocar no botão ACIONAR SEGURADORA
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no no botão TELEFONES ÚTEIS")
    public ProdutoCreditoTela tocarBotaoAcionarSeguradora() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAcionarSeguradora, "Não foi possível encontrar no botão ACIONAR SEGURADORA");
        salvarEvidencia("Tocar no no botão ACIONAR SEGURADORA");
        tocarElemento(botaoAcionarSeguradora, "Não foi possível tocar no botão ACIONAR SEGURADORA");
        return this;
    }

    /**
     * Método para tocar no botão TELEFONES ÚTEIS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no no botão TELEFONES ÚTEIS")
    public ProdutoCreditoTela tocarBotaoTelefonesUteis() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTelefonesUteis, "Não foi possível encontrar no botão TELEFONES ÚTEIS");
        salvarEvidencia("Tocar no no botão TELEFONES ÚTEIS");
        tocarElemento(botaoTelefonesUteis, "Não foi possível tocar no no botão TELEFONES ÚTEIS");
        return this;
    }

}
