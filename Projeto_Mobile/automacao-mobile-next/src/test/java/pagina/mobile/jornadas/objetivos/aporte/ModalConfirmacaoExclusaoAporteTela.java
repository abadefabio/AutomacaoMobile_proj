package pagina.mobile.jornadas.objetivos.aporte;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class ModalConfirmacaoExclusaoAporteTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage//following-sibling::XCUIElementTypeStaticText")
    private MobileElement mensagemModal;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Excluir\"]")
    private MobileElement botaoExcluir;

    public ModalConfirmacaoExclusaoAporteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar mensagem de confirma��o de exclus�o de agendamento de aporte
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem de confirma��o de exclus�o de agendamento de aporte")
    public ModalConfirmacaoExclusaoAporteTela validarMensagemConfirmacaoExclusaoAgendamentoAporte(String mensagem) throws Exception {
        salvarEvidencia("Validado mensagem de confirma��o de exclus�o de agendamento de aporte: " + mensagem);
        validarAtributoTexto(mensagemModal, mensagem, "N�o foi poss�vel validar mensagem de confirma��o de exclus�o de agendamento de aporte!");
        return this;
    }

    /**
     * Tocar bot�o excluir
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o excluir")
    public ModalConfirmacaoExclusaoAporteTela tocarBotaoExcluir() throws Exception {
        salvarEvidencia("Tocar bot�o excluir");
        tocarElemento(botaoExcluir, "N�o foi poss�vel tocar no bot�o excluir");
        return this;
    }

}
