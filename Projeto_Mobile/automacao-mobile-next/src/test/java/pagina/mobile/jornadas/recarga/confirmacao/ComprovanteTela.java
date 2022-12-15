package pagina.mobile.jornadas.recarga.confirmacao;

import constantes.comprovantes.TituloTela;
import org.testng.Assert;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ComprovanteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Comprovante'])")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"COMPROVANTE\"]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Comprovante\"])[2]")
    private MobileElement tituloComprovante;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_eye")
    @iOSXCUITFindBy(accessibility = "Visualizar")
    private MobileElement botaoVisualizar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"COMPROVANTE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"COMPROVANTE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]")
    private MobileElement comprovantePdf;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Fechar, Botão")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @AndroidFindBy(accessibility = "COMPARTILHAR COMPROVANTE")
    @iOSXCUITFindBy(accessibility = "COMPARTILHAR COMPROVANTE")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"COMPARTILHAR COMPROVANTE\"]")
    private MobileElement botaoCompartilhar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_right")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sim\"]")
    private MobileElement botaoSim;

    public ComprovanteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar botão 'Visualizar'  - Comprovante de Recarga
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Visualizar\"")
    public ComprovanteTela tocarBotaoVisualizar() throws Exception {
        aguardarCarregamentoElemento(botaoVisualizar);
        salvarEvidencia("Clicar no botão 'Visualizar'");
        tocarElemento(botaoVisualizar, "Não foi possível clicar no botão Visualizar");
        return this;
    }

    /**
     * Validar Título do Comprovante da Recarga
     *
     * @return
     * @throws Exception
     */
    @Step("Validar  PDF")
    public ComprovanteTela validarPdf() throws Exception {
        aguardarCarregamentoElemento(comprovantePdf);
        salvarEvidencia("Validar Comprovante Pdf");
        try {
            Assert.assertTrue(comprovantePdf.isDisplayed());
            OperadorEvidencia.logarPasso("Comprovante Validado");
        } catch (Exception e) {
            throw new NextException("Comprovante não encontrado!", e);
        }
        return this;
    }

    /**
     * Clicar botão 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public ComprovanteTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Clicar no botão 'Fechar'");
       if(aguardarCarregamentoElemento(botaoFechar))
            tocarElemento(botaoFechar, "Não foi possível clicar no botão Fechar");
        else // botão fechar não mapeável, utilizado como segundo recurso
            if(aguardarCarregamentoElemento(tituloComprovante)) tocarCoordenadaProporcional(7, 8);
        return this;
    }

    /**
     * Clicar botão 'Compartilhar Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Compartilhar\"")
    public ComprovanteTela tocarBotaoCompartilhar() throws Exception {
        aguardarCarregamentoElemento(botaoCompartilhar);
        tocarElemento(botaoCompartilhar, "Não foi possível clicar no botão Compartilhar");
        salvarEvidencia("Tocou no botão Compartilhar Comprovante");
        return this;
    }

    /**
     * Clicar em 'Sim'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Sim\"")
    public ComprovanteTela tocarBotaoSim() throws Exception {
        if (aguardarCarregamentoElemento(botaoSim)) {
            salvarEvidencia("Clicar em 'Sim'");
            tocarElemento(botaoSim, "Não foi possível clicar  em 'Sim'");
            }
        return this;
    }

    /**
     * Volta para a tela do comprovante
     * @return
     */
    @Step("Volta para a tela do  \"Comprovante\"")
    public ComprovanteTela voltarParaTelaDeComprovante(){
        salvarEvidencia("Voltando para a tela do Comprovante");
        // toca em qualquer região fora das opções de compartilhamento para voltar para a tela de 'Comprovante', elemento não mapeável
        tocarCoordenadaProporcional(20,20);
        return this;
    }

    /**
     * Volta para a tela do comprovante
     * @return ComprovanteTela
     */
    @Step("Validar a exibição da tela  \"Comprovante\"")
    public ComprovanteTela validarExibicaoTelaComprovante() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.COMPROVANTE), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela de comprovante");
        salvarEvidencia("Validar exibição da tela de Comprovante");
        return this;
    }
}
