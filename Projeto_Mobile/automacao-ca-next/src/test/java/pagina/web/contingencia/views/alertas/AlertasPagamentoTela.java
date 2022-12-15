package pagina.web.contingencia.views.alertas;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.alertas.AlertaCodigoBarrasInvalido;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.WebUtils.aguardarCarregamentoDaPagina;

public class AlertasPagamentoTela extends PaginaBaseWeb {

    public AlertasPagamentoTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "message-alert-0-msg")
    private WebElement alertaMensagem;

    @FindBy(id= "message-alert-0-btn-0")
    private WebElement botaoVoltarAlerta;

    /**
     * Validar se o alerta de codigo de barras invalido aparece após digitar um código de barras inválido.
     * @throws Exception
     */
    @Step("Validar alerta códigos de barras inválido da página de pagamento")
    public AlertasPagamentoTela validarCodigoInvalido(AlertaCodigoBarrasInvalido alertaCodigoBarrasInvalido) throws Exception {
        aguardarCarregamentoDaPagina(driver);
        compararElementoAtributo(alertaMensagem, AtributoElemento.TEXTO, alertaCodigoBarrasInvalido.toString(), MetodoComparacao.IGUAL);
        salvarEvidencia("Validado alerta" + alertaCodigoBarrasInvalido);
        return this;
    }

    /**
     * Clicar no botão voltar após alerta de códigos de barras inválido ser exibido.
     *
     * @return AlertasPagamentoTela
     * @throws Exception
     */
    @Step("Clicar no botão voltar")
    public AlertasPagamentoTela clicarBotaoVoltarAlerta() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarAlerta);
        salvarEvidencia("Clicar botão Voltar(alerta)");
        clicarElemento(botaoVoltarAlerta, "não foi possível clicar no botão Voltar");
        return this;
    }
}
