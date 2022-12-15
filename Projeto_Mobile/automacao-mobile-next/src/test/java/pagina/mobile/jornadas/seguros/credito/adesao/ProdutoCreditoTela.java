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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SEGURO CR�DITO']")
    private MobileElement headerTituloSeguroCreditoMeusSeguros;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, 'Li e aceito as condi��es gerais do seguro.')]/following::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']")
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
     * Valida Tela 'Produto Cr�dito'
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Valida Tela 'Produto Cr�dito'")
    public ProdutoCreditoTela validaTelaProdutoCredito() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroCredito);
        compararElementoTexto(headerTituloSeguroCredito, SegurosCredito.TITULO_TELA_PRODUTO_CREDITO, MetodoComparacao.IGUAL);
        salvarEvidencia("Validou Tela 'Produto Cr�dito'");
        return this;
    }

    /**
     * Valida Tela 'Produto Cr�dito' Meus Seguros
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Valida Tela 'Produto Cr�dito' Meus Seguros")
    public ProdutoCreditoTela validaTelaProdutoCreditoMeusSeguros() throws Exception {
        aguardarCarregamentoElemento(headerTituloSeguroCreditoMeusSeguros);
        compararElementoTexto(headerTituloSeguroCreditoMeusSeguros, SegurosCredito.TITULO_TELA_PRODUTO_CREDITO_MEUS_SEGUROS, MetodoComparacao.IGUAL);
        salvarEvidencia("Validou Tela 'Produto Cr�dito'");
        return this;
    }

    /**
     * Tocar no �cone (i) informa��es das condi��es
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no �cone (i) informa��es das condi��es")
    public ProdutoCreditoTela tocarBotaoInfoCondicoesGerais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInfoCondicoesGerais, "N�o foi poss�vel tocar no �cone (i) informa��es das condi��es");
        salvarEvidencia("Tocar no �cone (i) informa��es das condi��es");
        tocarElemento(botaoInfoCondicoesGerais, "N�o foi poss�vel tocar no �cone (i) informa��es das condi��es");
        return this;
    }

    /**
     * Tocar no bot�o 'Saiba Mais' na se��o de informa��es do parceiro
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Saiba Mais' na se��o de informa��es do parceiro")
    public ProdutoCreditoTela tocarBotaoSaibaMaisInfoParceiro() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSaibaMaisInfoParceiro, "N�o foi poss�vel encontrar o bot�o <SAIBA MAIS> na se��o de informa��es do parceiro.");
        salvarEvidencia("Tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro");
        tocarElemento(botaoSaibaMaisInfoParceiro, "N�o foi poss�vel tocar no bot�o <SAIBA MAIS> na se��o de informa��es do parceiro.");
        return this;
    }

    /**
     * Tocar no checkbox de 'Aceite das condi��es gerais'
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no checkbox de 'Aceite das condi��es gerais'")
    public ProdutoCreditoTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkboxAceiteTermosCondicoes, "N�o foi poss�vel encontrar o checkbox de aceite das condi��es gerais.");
        salvarEvidencia("Tocar no checkbox de aceite das condi��es gerais");
        tocarElemento(checkboxAceiteTermosCondicoes, "N�o foi poss�vel tocar no checkbox de aceite das condi��es gerais.");

        return this;
    }

    /**
     * Tocar no bot�o 'Contratar'
     * @return ProdutoCreditoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Contratar'")
    public ProdutoCreditoTela tocarBotaoContratar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConcluirContratacaoCredito, "N�o foi poss�vel encontrar no bot�o <CONTRATAR>.");
        salvarEvidencia("Tocar no bot�o <CONTRATAR>");
        tocarElemento(botaoConcluirContratacaoCredito, "N�o foi poss�vel tocar no bot�o <CONTRATAR>.");

        return this;
    }

    /**
     * M�todo para tocar no bot�o VIS�O GERAL
     *
     * @return ProdutoDebitoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o VIS�O GERAL")
    public ProdutoCreditoTela tocarBotaoVisaoGeral() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVisaoGeral, "N�o foi poss�vel econtrar o bot�o VIS�O GERAL.");
        salvarEvidencia("Tocar no bot�o VIS�O GERAL");
        tocarElemento(botaoVisaoGeral, "N�o foi poss�vel tocar no bot�o VIS�O GERAL.");
        return this;
    }

    /**
     * M�todo para tocar no bot�o ACIONAR SEGURADORA
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no no bot�o TELEFONES �TEIS")
    public ProdutoCreditoTela tocarBotaoAcionarSeguradora() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAcionarSeguradora, "N�o foi poss�vel encontrar no bot�o ACIONAR SEGURADORA");
        salvarEvidencia("Tocar no no bot�o ACIONAR SEGURADORA");
        tocarElemento(botaoAcionarSeguradora, "N�o foi poss�vel tocar no bot�o ACIONAR SEGURADORA");
        return this;
    }

    /**
     * M�todo para tocar no bot�o TELEFONES �TEIS
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no no bot�o TELEFONES �TEIS")
    public ProdutoCreditoTela tocarBotaoTelefonesUteis() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTelefonesUteis, "N�o foi poss�vel encontrar no bot�o TELEFONES �TEIS");
        salvarEvidencia("Tocar no no bot�o TELEFONES �TEIS");
        tocarElemento(botaoTelefonesUteis, "N�o foi poss�vel tocar no no bot�o TELEFONES �TEIS");
        return this;
    }

}
