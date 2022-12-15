package pagina.mobile.jornadas.comprovantes.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ObjetivosFinalizadosTela extends PaginaBase {

    public ObjetivosFinalizadosTela(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon expansible cell\"])[1]")
    @AndroidFindBy(accessibility = ",Lista suspensa,SelecioneObjetivo")
    private MobileElement botaoObjetivo;

    // ios não está sendo possível ser mapeado.
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout")
    private MobileElement objetivoSelecionado;

    @iOSXCUITFindBy(accessibility = "Confirmar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    private MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Lista suspensa,Selecione')]")
    @AndroidFindBy(accessibility = ",Lista suspensa,SelecionePeríodo")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='icon expansible cell'])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell")
    private MobileElement botaoPeriodo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_send_receipts")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_visualize")
    @iOSXCUITFindBy(accessibility = "Visualizar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Visualizar']")
    private MobileElement botaoVisualizar;

    @AndroidFindBy(id="br.com.bradesco.next:id/item_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirmar']")
    private MobileElement botaoEnviar;

    @iOSXCUITFindBy(accessibility = "Extrato enviado para:")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_text_extract_sended_to")
    private MobileElement mensagemSucessoEnvioEmail;

    /** Tocar botão Periodo
     * @return
     * @throws NextException
     */
    public ObjetivosFinalizadosTela selecionarPeriodo() throws NextException {
        aguardarCarregamentoElemento(botaoPeriodo);
        salvarEvidencia("Tocar botao Periodo");
        tocarElemento(botaoPeriodo,"Nao foi possivel tocar botao Periodo");
        return this;
    }

    /** Tocar botão Enviar Comprovante
     * @return
     * @throws NextException
     */
    public ObjetivosFinalizadosTela tocarBotaoEnviar() throws NextException {
        aguardarCarregamentoElemento(botaoEnviar);
        salvarEvidencia("Tocar botao Enviar Comprovante");
        tocarElemento(botaoEnviar,"Nao foi possivel tocar botao Enviar Comprovante");
        return this;
    }

    /** Tocar botão Visualizar
     * @return
     * @throws NextException
     */
    public ObjetivosFinalizadosTela tocarBotaoVisualizar() throws NextException {
        aguardarCarregamentoElemento(botaoVisualizar);
        salvarEvidencia("Tocar botao Visualizar");
        tocarElemento(botaoVisualizar,"Nao foi possivel tocar botao Visualizar");
        return this;
    }

    /** Tocar botão objetivo para ser selecionado
     * @return
     * @throws NextException
     */
    public ObjetivosFinalizadosTela tocarBotaoSelecionarObjetivo() throws Exception {

        tocarElemento(botaoObjetivo,"Nao foi possivel tocar botao 'Objetivo'");
        salvarEvidencia("Tocar botao objetivo");
        return this;
    }

    /** Tocar botão objetivo para selecionar
     * @return
     * @throws NextException
     */
    public ObjetivosFinalizadosTela tocarbotaoObjetivoSelecao() throws Exception {
        if(android) {
            tocarElemento(objetivoSelecionado, "Nao foi possivel tocar no objetivo para selecionar");
            salvarEvidencia("Tocar botao Objetivo para Selecionar");
        }
        return this;
    }

    /** Tocar botão Confirmar
     * @return
     * @throws NextException
     */
    public ObjetivosFinalizadosTela tocarbotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Tocar botao Confirmar");
        tocarElemento(botaoConfirmar,"Nao foi possivel tocar no botao Confirmar");
        return this;
    }

    /** Validar mensagem de email enviado com sucesso
     * @return
     * @throws NextException
     */
    public ObjetivosFinalizadosTela validarEnvioEmailComprovante(){

        salvarEvidencia("Validar mensagem envio de e-mail com sucesso!");
        verificarPresencaElemento(mensagemSucessoEnvioEmail);
        return this;
    }
}
