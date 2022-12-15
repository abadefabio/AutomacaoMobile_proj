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
    // Título da tela VISÃO GERAL RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"VISÃO GERAL\"]")
    private MobileElement headerTituloVisaoGeralResidencial;

    // botão SAIBA MAIS no bloco COBERTURA
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_insurance_full_protection_know_more")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Saiba Mais\"]")
    private MobileElement btnSaibaMaisCoberturas;

    // ícone (i) INFORMAÇÕES referente a CONDIÇÕES GERAIS
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, 'Li e aceito as condições gerais do seguro.')]/following::*[@resource-id='br.com.bradesco.next:id/si_suffix_icon']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='termsCheckbox']//preceding-sibling::XCUIElementTypeOther[1]")
    private MobileElement botaoInfoCondicoesGerais;

    // botão SAIBA MAIS no bloco de informações do parceiro
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_know_more")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@label='SAIBA MAIS'])[3]")
    private MobileElement btnSaibaMaisInfoParceiro;

    // checkbox de aceite das condições gerais
    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'termsCheckbox')]")
    private MobileElement checkboxAceiteCondicoesGerais;

    // botão CONTRATAR produto RESIDENCIAL
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_hire_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'hireButton')]")
    private MobileElement btnConcluirContratacaoResidencial;

    // botão /  ícone (lápis) edição
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"editIcon\"]")
    private MobileElement btnLapisEdicao;

    // botão Visão Geral
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Visão geral\"]")
    private MobileElement botaoVisaoGeral;

    // botão Telefones Úteis
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Telefones úteis\"]")
    private MobileElement botaoTelefonesUteis;

    // botão Acionar Seguradora
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ACIONAR SEGURADORA\"]")
    private MobileElement botaoAcionarSeguradora;

    // botão Info
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_edit_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Informações\"]")
    private MobileElement botaoInfo;

    // Botão CANCELAR SEGURO "<"!
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_cancel_insurance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CANCELAR SEGURO\"]")
    private MobileElement botaoCancelarSeguro;

    /**
     * Método para Validar tela VISÃO GERAL RESIDENCIAL
     *
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Valida tela VISÃO GERAL RESIDENCIAL")
    public VisaoGeralResidencialTela validaTelaVisaoGeralResidencial() throws Exception {
        aguardarCarregamentoElemento(headerTituloVisaoGeralResidencial);
        compararElementoTexto(headerTituloVisaoGeralResidencial, SegurosResidencial.TITULO_TELA_VISAO_GERAL, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela VISÃO GERAL RESIDENCIAL");
        return this;
    }

    /**
     * Método para Tocar caixa verde com o texto "Saiba mais" no bloco DETALHES DA COBERTURA
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DA COBERTURA")
    public VisaoGeralResidencialTela tocarBtnSaibaMaisDetalhesCoberturas() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnSaibaMaisCoberturas)){
                salvarEvidencia("Clicar caixa verde com o texto \"Saiba mais\" no bloco DETALHES DA COBERTURA.");
                tocarElemento(btnSaibaMaisCoberturas, "Não foi possível clicar no botão \"Saiba mais\" no bloco DETALHES DA COBERTURA.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
    /**
     * Método para Tocar no ícone (i) informações das condições
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no ícone (i) informações das condições")
    public VisaoGeralResidencialTela tocarbotaoInfoCondicoesGerais() throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInfoCondicoesGerais, "Não foi possível encontrar o ícone '(i) infomações gerais'!");
        salvarEvidencia("Tocar no ícone (i) informações das condições");
        tocarElemento(botaoInfoCondicoesGerais, "Não foi possível tocar no ícone (i) informações das condições");
        return this;
    }
    /**
     * Método para Tocar no botão <SAIBA MAIS> na seção de informações do parceiro
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no botão <SAIBA MAIS> na seção de informações do parceiro")
    public VisaoGeralResidencialTela tocarBtnSaibaMaisInfoParceiro() throws Exception {
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
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no checkbox de aceite das condições gerais")
    public VisaoGeralResidencialTela tocarCheckboxAceiteCondicoesGerais() throws Exception {
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
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no botão <CONTRATAR>")
    public VisaoGeralResidencialTela tocarBtnContratar() throws Exception {
        for (int i = 0; i < 10; i++){
            if(verificarPresencaElemento(btnConcluirContratacaoResidencial)){
                salvarEvidencia("Tocar no botão <CONTRATAR>");
                tocarElemento(btnConcluirContratacaoResidencial, "Não foi possível tocar no botão <CONTRATAR>.");
                break;
            }
            rolarTela(0.5D, 0.1D);
        }
        return this;
    }
    /**
     * Método para Tocar no ícone (lápis) editar endereço
     * @throws Exception
     * @return VisaoGeralResidencialTela
     */
    @Step("Tocar no ícone (lápis) editar endereço")
    public VisaoGeralResidencialTela tocarBtnLapisEdicaoEndereco() throws Exception {

        esconderTeclado();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(btnLapisEdicao, "Não foi possível encontrar o ícone (lápis) para edição!");
        salvarEvidencia("Tocar no ícone (lápis) editar endereço.");
        tocarElemento(btnLapisEdicao, "Não foi possível clicar no ícone (lápis) editar endereço.");
        return this;
    }

    /**
     * Método para tocar botão 'Cancelar Seguro'
     *
     * @return VisaoGeralResidencialTela
     * @throws Exception
     */
    @Step("Tocar Botão 'Cancelar Seguro'")
    public VisaoGeralResidencialTela tocarBotaoCancelarSeguro() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCancelarSeguro,"Botão 'CANCELAR SEGURO' não encontrado");
        aguardarCarregamentoElemento(botaoCancelarSeguro);
        salvarEvidencia("Tocar no botão 'Cancelar Seguro'");
        tocarElemento(botaoCancelarSeguro, "Não foi possível tocar no botão 'Cancelar Seguro'");
        return this;
    }

}
