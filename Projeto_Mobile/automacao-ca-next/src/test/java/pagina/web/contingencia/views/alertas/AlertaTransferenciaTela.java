package pagina.web.contingencia.views.alertas;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import constantes.alertas.AlertaTransferenciaSucesso;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertaTransferenciaTela extends PaginaBaseWeb {

    public AlertaTransferenciaTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "message-alert-0-btn-0")
    private WebElement botaoVoltar;

    @FindBy(id = "message-alert-0-msg")
    private WebElement mensagemAlertaTransferencia;

    /**
     * Clicar no botão 'Voltar' da pop-up do alerta de transferência com sucesso
     * @throws Exception
     * @return
     */
    @Step("Selecionar opção 'Voltar'")
    public AlertaTransferenciaTela clicarBotaoVoltar() throws Exception {
        rolarParaBaixoAteElemento(botaoVoltar);
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicado no botão 'Voltar'");
        clicarElemento(botaoVoltar, "Não foi possível clicar na opção 'Voltar'");
        return this;
    }

    /**
     * Validar mensagem de alerta de transferência realizada com sucesso, exibida em pop-up, na contingencia web
     * @return
     * @throws Exception
     */
    @Step("validar mensagem alerta sessao expirada")
    public AlertaTransferenciaTela validarMensagemTransferenciaSucesso() throws Exception {
        aguardarCarregamentoElemento(mensagemAlertaTransferencia);
        salvarEvidencia("Validado alerta: " + AlertaTransferenciaSucesso.MENSAGEM_TRANSFERENCIA_COM_SUCESSO);
        aguardarVisibilidadeElemento(mensagemAlertaTransferencia, 20000, 1000);
        Thread.sleep(5000); //animação
        validarAtributoTexto(mensagemAlertaTransferencia, AlertaTransferenciaSucesso.MENSAGEM_TRANSFERENCIA_COM_SUCESSO.toString(), "Atributo texto difere do texto presente no elemento.");
        return this;
    }

}
