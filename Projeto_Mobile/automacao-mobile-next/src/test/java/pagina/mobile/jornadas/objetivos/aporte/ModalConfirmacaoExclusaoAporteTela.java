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
     * Validar mensagem de confirmação de exclusão de agendamento de aporte
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem de confirmação de exclusão de agendamento de aporte")
    public ModalConfirmacaoExclusaoAporteTela validarMensagemConfirmacaoExclusaoAgendamentoAporte(String mensagem) throws Exception {
        salvarEvidencia("Validado mensagem de confirmação de exclusão de agendamento de aporte: " + mensagem);
        validarAtributoTexto(mensagemModal, mensagem, "Não foi possível validar mensagem de confirmação de exclusão de agendamento de aporte!");
        return this;
    }

    /**
     * Tocar botão excluir
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão excluir")
    public ModalConfirmacaoExclusaoAporteTela tocarBotaoExcluir() throws Exception {
        salvarEvidencia("Tocar botão excluir");
        tocarElemento(botaoExcluir, "Não foi possível tocar no botão excluir");
        return this;
    }

}
