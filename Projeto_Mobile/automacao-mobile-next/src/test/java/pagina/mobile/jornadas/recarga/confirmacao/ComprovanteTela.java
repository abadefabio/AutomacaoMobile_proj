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
    @AndroidFindBy(accessibility = "Fechar, Bot�o")
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
     * Clicar bot�o 'Visualizar'  - Comprovante de Recarga
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Visualizar\"")
    public ComprovanteTela tocarBotaoVisualizar() throws Exception {
        aguardarCarregamentoElemento(botaoVisualizar);
        salvarEvidencia("Clicar no bot�o 'Visualizar'");
        tocarElemento(botaoVisualizar, "N�o foi poss�vel clicar no bot�o Visualizar");
        return this;
    }

    /**
     * Validar T�tulo do Comprovante da Recarga
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
            throw new NextException("Comprovante n�o encontrado!", e);
        }
        return this;
    }

    /**
     * Clicar bot�o 'Fechar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\"")
    public ComprovanteTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Clicar no bot�o 'Fechar'");
       if(aguardarCarregamentoElemento(botaoFechar))
            tocarElemento(botaoFechar, "N�o foi poss�vel clicar no bot�o Fechar");
        else // bot�o fechar n�o mape�vel, utilizado como segundo recurso
            if(aguardarCarregamentoElemento(tituloComprovante)) tocarCoordenadaProporcional(7, 8);
        return this;
    }

    /**
     * Clicar bot�o 'Compartilhar Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Compartilhar\"")
    public ComprovanteTela tocarBotaoCompartilhar() throws Exception {
        aguardarCarregamentoElemento(botaoCompartilhar);
        tocarElemento(botaoCompartilhar, "N�o foi poss�vel clicar no bot�o Compartilhar");
        salvarEvidencia("Tocou no bot�o Compartilhar Comprovante");
        return this;
    }

    /**
     * Clicar em 'Sim'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Sim\"")
    public ComprovanteTela tocarBotaoSim() throws Exception {
        if (aguardarCarregamentoElemento(botaoSim)) {
            salvarEvidencia("Clicar em 'Sim'");
            tocarElemento(botaoSim, "N�o foi poss�vel clicar  em 'Sim'");
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
        // toca em qualquer regi�o fora das op��es de compartilhamento para voltar para a tela de 'Comprovante', elemento n�o mape�vel
        tocarCoordenadaProporcional(20,20);
        return this;
    }

    /**
     * Volta para a tela do comprovante
     * @return ComprovanteTela
     */
    @Step("Validar a exibi��o da tela  \"Comprovante\"")
    public ComprovanteTela validarExibicaoTelaComprovante() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.COMPROVANTE), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o da tela de comprovante");
        salvarEvidencia("Validar exibi��o da tela de Comprovante");
        return this;
    }
}
