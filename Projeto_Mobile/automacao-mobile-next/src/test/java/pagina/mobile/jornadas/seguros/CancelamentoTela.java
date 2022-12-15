package pagina.mobile.jornadas.seguros;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CancelamentoTela extends PaginaBase {

    public CancelamentoTela(AppiumDriver driver) {
        super(driver);
    }

    // Elementos

    // T�tulo da Tela de CANCELAMENTO
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_title' and contains(@text, 'CANCELAMENTO')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CANCELAMENTO\"]")
    private MobileElement headerTituloTelaCancelamento;

    // Lista Motivo do Cancelamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Motivo do cancelamento')]")
    private MobileElement listaMotivoDoCancelamento;

    // Bot�o Confirmar Sele��o
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirmar']")
    private MobileElement botaoConfirmarSelecao;

    // Bot�o Confirmar
    @AndroidFindBy(id = "br.com.bradesco.next:id/confirm")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonConfirm\"]")
    private MobileElement botaoConfirmar;

    // Bot�o OK
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_receipt")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'OK')]")
    private MobileElement botaoOk;

    /**
     * M�todo para Validar a Tela de 'cancelamento'
     *
     * @return CancelamentoTela
     * @throws Exception
     */
    public CancelamentoTela validaTelaCancelamento() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaCancelamento);
        verificarPresencaElemento(headerTituloTelaCancelamento);
        salvarEvidencia("Tela de 'Cancelamento'");
        return this;
    }

    /**
     * M�todo respons�vel por tocar na lista Motivo do Cancelamento
     *
     * @return CancelamentoTela
     * @throws NextException
     */
    public CancelamentoTela tocarListaMotivoDoCancelamento() throws NextException {
        salvarEvidencia("Tocar lista Motivo do Cancelamento");
        if (android) {
            tocarElemento(listaMotivoDoCancelamento, "N�o foi poss�vel tocar na lista Motivo do Cancelamento");
        } else {
            tocarCoordenada(listaMotivoDoCancelamento);
        }
        return this;
    }

    /**
     * M�todo respons�vel por tocar no Motivo do Cancelamento
     *
     * @param motivoCancelamento
     * @return CancelamentoTela
     * @throws NextException
     */
    public CancelamentoTela tocarBotaoMotivoDoCancelamento(String motivoCancelamento) throws NextException {
        By botaoMotivoCancelamento;
        if (android) {
            botaoMotivoCancelamento = By.xpath("//*[@resource-id='br.com.bradesco.next:id/nl_label_text' and contains(@text, '" + motivoCancelamento + "')]");
        } else {
            botaoMotivoCancelamento = By.xpath("//XCUIElementTypeStaticText[@name='" + motivoCancelamento + "']");
        }
        salvarEvidencia("Tocar bot�o '" + motivoCancelamento + "'");
        tocarElemento(botaoMotivoCancelamento, "N�o foi poss�vel tocar no motivo cancelamento '" + motivoCancelamento + "'");
        return this;
    }

    /**
     * M�todo Respons�vel por tocar no bot�o 'Confirmar Sele��o'
     *
     * @return
     * @throws NextException
     */
    public CancelamentoTela tocarBotaoConfirmarSelecao() throws NextException {
        salvarEvidencia("Tocar bot�o Confirmar Sele��o");
        tocarElemento(botaoConfirmarSelecao, "N�o foi poss�vel tocar no bot�o 'Confirmar Sele��o'");
        return this;
    }

    /**
     * M�todo respons�vel por tocar no bot�o 'Confirmar'
     *
     * @return CancelamentoTela
     * @throws NextException
     */
    public CancelamentoTela tocarBotaoCorfirmar() throws NextException {
        salvarEvidencia("Tocar bot�o Confirmar");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel tocar no bot�o 'Confirmar'");
        return this;
    }

    /**
     * M�todo respons�vel por tocar no bot�o 'OK'
     *
     * @return CancelamentoTela
     * @throws NextException
     */
    public CancelamentoTela tocarBotaoOk() throws NextException {
        salvarEvidencia("Tocar bot�o OK");
        tocarElemento(botaoOk, "N�o foi poss�vel tocar no bot�o 'OK'");
        return this;
    }
}
