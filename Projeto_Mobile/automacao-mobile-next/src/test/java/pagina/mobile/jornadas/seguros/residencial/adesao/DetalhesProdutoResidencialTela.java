package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DetalhesProdutoResidencialTela extends PaginaBase {

    public DetalhesProdutoResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // T�tulo da tela DETALHES COBERTURAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ENTENDA AS COBERTURAS\"]")
    private MobileElement headerTituloDetalhesCoberturas;

    // T�tulo da aba DETALHES DE COBERTURAS
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'DETALHES DE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"DETALHES DE\")]")
    private MobileElement abaTituloDetalhesCoberturas;

    // T�tulo da aba VALORES DE FRANQUIAS
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Valores')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'VALORES DE')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Valores de')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'VALORES DE')]")
    private MobileElement abaTituloValoresFranquias;

    // bot�o VISUALIZAR FRANQUIA PLANO
    @AndroidFindBy(xpath = "(//*[@resource-id='br.com.bradesco.next:id/cl_main'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Plano 8\"]")
    private MobileElement btnVisualizarFranquiaPlano;

    // bot�o VOLTAR da tela DETALHES DO PRODUTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"ENTENDA AS COBERTURAS\"]/XCUIElementTypeButton")
    private MobileElement btnVoltarTelaDetalhesCobertura;
    /*     *************************     */

    /*
    M�todo para Valida tela DETALHES COBERTURAS
     */
    @Step("Valida tela DETALHES COBERTURAS")
    public DetalhesProdutoResidencialTela validaTelaDetalhesCoberturas() throws Exception {
        aguardarCarregamentoElemento(headerTituloDetalhesCoberturas);
        compararElementoTexto(headerTituloDetalhesCoberturas, SegurosResidencial.TITULO_TELA_DETALHES_COBERTURA, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela DETALHES COBERTURAS");
        return this;
    }
    /*
    M�todo para Tocar na aba VALORES DE FRANQUIAS
     */
    @Step("Tocar na aba VALORES DE FRANQUIAS")
    public DetalhesProdutoResidencialTela tocarAbaValoresFranquiasCobertura() throws Exception {
        aguardarCarregamentoElemento(abaTituloValoresFranquias);
        salvarEvidencia("Tocar na aba VALORES DE FRANQUIAS");
        tocarElemento(abaTituloValoresFranquias, "N�o foi poss�vel tocar na aba VALORES DE FRANQUIAS");
        return this;
    }
    /*
    M�todo para Tocar no �cone de seta da cobertura de prefer�ncia
     */
    @Step("Tocar no �cone de seta da cobertura de prefer�ncia")
    public DetalhesProdutoResidencialTela visualizarFranquiaCoberturaDescolapsada() throws Exception {
        aguardarCarregamentoElemento(btnVisualizarFranquiaPlano);
        salvarEvidencia("Tocar no �cone de seta da cobertura de prefer�ncia");
        tocarElemento(btnVisualizarFranquiaPlano, "N�o foi poss�vel tocar no �cone de seta da cobertura de prefer�ncia");
        return this;
    }
    /*
    M�todo para Tocar no �cone (<) voltar
     */
    @Step("Tocar no �cone (<) voltar")
    public DetalhesProdutoResidencialTela tocarBtnVoltarTelaDetalhesCobertura() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaDetalhesCobertura);
        salvarEvidencia("Tocar no �cone (<) voltar");
        tocarElemento(btnVoltarTelaDetalhesCobertura, "N�o foi poss�vel tocar no �cone (<) voltar");
        return this;
    }
}
