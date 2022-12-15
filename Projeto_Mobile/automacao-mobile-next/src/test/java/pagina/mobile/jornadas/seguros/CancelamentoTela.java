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

    // Título da Tela de CANCELAMENTO
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_title' and contains(@text, 'CANCELAMENTO')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CANCELAMENTO\"]")
    private MobileElement headerTituloTelaCancelamento;

    // Lista Motivo do Cancelamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Motivo do cancelamento')]")
    private MobileElement listaMotivoDoCancelamento;

    // Botão Confirmar Seleção
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system_option")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirmar']")
    private MobileElement botaoConfirmarSelecao;

    // Botão Confirmar
    @AndroidFindBy(id = "br.com.bradesco.next:id/confirm")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"buttonConfirm\"]")
    private MobileElement botaoConfirmar;

    // Botão OK
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_receipt")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'OK')]")
    private MobileElement botaoOk;

    /**
     * Método para Validar a Tela de 'cancelamento'
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
     * Método responsável por tocar na lista Motivo do Cancelamento
     *
     * @return CancelamentoTela
     * @throws NextException
     */
    public CancelamentoTela tocarListaMotivoDoCancelamento() throws NextException {
        salvarEvidencia("Tocar lista Motivo do Cancelamento");
        if (android) {
            tocarElemento(listaMotivoDoCancelamento, "Não foi possível tocar na lista Motivo do Cancelamento");
        } else {
            tocarCoordenada(listaMotivoDoCancelamento);
        }
        return this;
    }

    /**
     * Método responsável por tocar no Motivo do Cancelamento
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
        salvarEvidencia("Tocar botão '" + motivoCancelamento + "'");
        tocarElemento(botaoMotivoCancelamento, "Não foi possível tocar no motivo cancelamento '" + motivoCancelamento + "'");
        return this;
    }

    /**
     * Método Responsável por tocar no botão 'Confirmar Seleção'
     *
     * @return
     * @throws NextException
     */
    public CancelamentoTela tocarBotaoConfirmarSelecao() throws NextException {
        salvarEvidencia("Tocar botão Confirmar Seleção");
        tocarElemento(botaoConfirmarSelecao, "Não foi possível tocar no botão 'Confirmar Seleção'");
        return this;
    }

    /**
     * Método responsável por tocar no botão 'Confirmar'
     *
     * @return CancelamentoTela
     * @throws NextException
     */
    public CancelamentoTela tocarBotaoCorfirmar() throws NextException {
        salvarEvidencia("Tocar botão Confirmar");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        return this;
    }

    /**
     * Método responsável por tocar no botão 'OK'
     *
     * @return CancelamentoTela
     * @throws NextException
     */
    public CancelamentoTela tocarBotaoOk() throws NextException {
        salvarEvidencia("Tocar botão OK");
        tocarElemento(botaoOk, "Não foi possível tocar no botão 'OK'");
        return this;
    }
}
