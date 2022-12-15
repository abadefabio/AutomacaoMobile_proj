package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import constantes.pagamentos.veiculos.TipoPagamento;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SelecioneTipoPagamentoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_next_option")
    @AndroidFindBy(accessibility = "confirmar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoApply;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_next_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SELECIONE O TIPO DE PAGAMENTO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"SELECIONE O TIPO DE PAGAMENTO\"`]")
    private MobileElement telaTipoPagamento;

    public SelecioneTipoPagamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o Confirmar
     * @return SelecioneTipoPagamentoTela
     */
    @Step("Tocar bot�o Confirmar")
    public SelecioneTipoPagamentoTela tocarBotaoApply() throws NextException {
        salvarEvidencia("Tocar bot�o v");
        tocarElemento(botaoApply, "Ocorreu um erro inesperado ao tentar tocar bot�o de confirma��o");
        return this;
    }
    /**
     * M�todo Utilizado para tocar elemento referente ao tipo de pagamento desejado na tela
     * @param tipoPagamento
     * @return SelecioneTipoPagamentoTelav
     * @throws Exception
     */
    @Step("Tocar campo com estado desejado")
    public SelecioneTipoPagamentoTela tocarCampoTipoPagamento(TipoPagamento tipoPagamento) throws Exception {
        String tradutorLetrasXpath = "translate(@value, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz')";
        By localizador = ios ? new By.ByXPath("//*[@name=\""+ tipoPagamento +"\"]"):new By.ByXPath("//*[lower-case(@text) = \"" + tipoPagamento.toString().toLowerCase() + "\"]");
        tocarElemento(localizador, "O tipo de pagamento " + tipoPagamento + "n�o foi encontrado em tela");
        salvarEvidencia("Selecionar o tipo de pagamento: " + tipoPagamento);
        tocarElemento(localizador, "Ocorreu um erro ao executar a a��o de selecionar o tipo de pagamento    ");
        return this;
    }

    /**
     * Tocar bot�o "Confirmar"
     *
     * @return SelecioneTipoPagamentoTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Confirmar\"")
    public SelecioneTipoPagamentoTela tocarBotaoConfirmar() throws Exception {
        tocarElemento(botaoApply, "N�o foi possivel tocar bot�o \"Confirmar\"");
        salvarEvidencia("Tocar bot�o \"Confirmar\"");
        return this;
    }

}
