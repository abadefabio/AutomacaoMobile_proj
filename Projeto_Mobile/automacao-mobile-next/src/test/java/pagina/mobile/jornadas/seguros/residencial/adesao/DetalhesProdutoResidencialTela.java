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
    // Título da tela DETALHES COBERTURAS
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ENTENDA AS COBERTURAS\"]")
    private MobileElement headerTituloDetalhesCoberturas;

    // Título da aba DETALHES DE COBERTURAS
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'DETALHES DE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"DETALHES DE\")]")
    private MobileElement abaTituloDetalhesCoberturas;

    // Título da aba VALORES DE FRANQUIAS
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Valores')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'VALORES DE')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Valores de')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'VALORES DE')]")
    private MobileElement abaTituloValoresFranquias;

    // botão VISUALIZAR FRANQUIA PLANO
    @AndroidFindBy(xpath = "(//*[@resource-id='br.com.bradesco.next:id/cl_main'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Plano 8\"]")
    private MobileElement btnVisualizarFranquiaPlano;

    // botão VOLTAR da tela DETALHES DO PRODUTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"ENTENDA AS COBERTURAS\"]/XCUIElementTypeButton")
    private MobileElement btnVoltarTelaDetalhesCobertura;
    /*     *************************     */

    /*
    Método para Valida tela DETALHES COBERTURAS
     */
    @Step("Valida tela DETALHES COBERTURAS")
    public DetalhesProdutoResidencialTela validaTelaDetalhesCoberturas() throws Exception {
        aguardarCarregamentoElemento(headerTituloDetalhesCoberturas);
        compararElementoTexto(headerTituloDetalhesCoberturas, SegurosResidencial.TITULO_TELA_DETALHES_COBERTURA, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela DETALHES COBERTURAS");
        return this;
    }
    /*
    Método para Tocar na aba VALORES DE FRANQUIAS
     */
    @Step("Tocar na aba VALORES DE FRANQUIAS")
    public DetalhesProdutoResidencialTela tocarAbaValoresFranquiasCobertura() throws Exception {
        aguardarCarregamentoElemento(abaTituloValoresFranquias);
        salvarEvidencia("Tocar na aba VALORES DE FRANQUIAS");
        tocarElemento(abaTituloValoresFranquias, "Não foi possível tocar na aba VALORES DE FRANQUIAS");
        return this;
    }
    /*
    Método para Tocar no ícone de seta da cobertura de preferência
     */
    @Step("Tocar no ícone de seta da cobertura de preferência")
    public DetalhesProdutoResidencialTela visualizarFranquiaCoberturaDescolapsada() throws Exception {
        aguardarCarregamentoElemento(btnVisualizarFranquiaPlano);
        salvarEvidencia("Tocar no ícone de seta da cobertura de preferência");
        tocarElemento(btnVisualizarFranquiaPlano, "Não foi possível tocar no ícone de seta da cobertura de preferência");
        return this;
    }
    /*
    Método para Tocar no ícone (<) voltar
     */
    @Step("Tocar no ícone (<) voltar")
    public DetalhesProdutoResidencialTela tocarBtnVoltarTelaDetalhesCobertura() throws Exception {
        aguardarCarregamentoElemento(btnVoltarTelaDetalhesCobertura);
        salvarEvidencia("Tocar no ícone (<) voltar");
        tocarElemento(btnVoltarTelaDetalhesCobertura, "Não foi possível tocar no ícone (<) voltar");
        return this;
    }
}
