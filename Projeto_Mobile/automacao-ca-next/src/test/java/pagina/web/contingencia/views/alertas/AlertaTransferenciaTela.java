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
     * Clicar no bot�o 'Voltar' da pop-up do alerta de transfer�ncia com sucesso
     * @throws Exception
     * @return
     */
    @Step("Selecionar op��o 'Voltar'")
    public AlertaTransferenciaTela clicarBotaoVoltar() throws Exception {
        rolarParaBaixoAteElemento(botaoVoltar);
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicado no bot�o 'Voltar'");
        clicarElemento(botaoVoltar, "N�o foi poss�vel clicar na op��o 'Voltar'");
        return this;
    }

    /**
     * Validar mensagem de alerta de transfer�ncia realizada com sucesso, exibida em pop-up, na contingencia web
     * @return
     * @throws Exception
     */
    @Step("validar mensagem alerta sessao expirada")
    public AlertaTransferenciaTela validarMensagemTransferenciaSucesso() throws Exception {
        aguardarCarregamentoElemento(mensagemAlertaTransferencia);
        salvarEvidencia("Validado alerta: " + AlertaTransferenciaSucesso.MENSAGEM_TRANSFERENCIA_COM_SUCESSO);
        aguardarVisibilidadeElemento(mensagemAlertaTransferencia, 20000, 1000);
        Thread.sleep(5000); //anima��o
        validarAtributoTexto(mensagemAlertaTransferencia, AlertaTransferenciaSucesso.MENSAGEM_TRANSFERENCIA_COM_SUCESSO.toString(), "Atributo texto difere do texto presente no elemento.");
        return this;
    }

}
