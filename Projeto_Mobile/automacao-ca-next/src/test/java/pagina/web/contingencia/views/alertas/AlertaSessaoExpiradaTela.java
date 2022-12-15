package pagina.web.contingencia.views.alertas;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.alertas.AlertaSessaoExpirada;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertaSessaoExpiradaTela extends PaginaBaseWeb {

    public AlertaSessaoExpiradaTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(), 'Sair')]")
    private WebElement botaoSair;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement botaoEfetuarLogin;

    @FindBy(xpath = "//span[contains(text(),'expir') and contains(text(),'logar')]")
    private WebElement mensagemSessaoExpirada;

    @FindBy(xpath = "//span[@class=\"next-label next-label--title-2\"]")
    private WebElement tituloPagamento;

    /**
     * Selecionar a op��o 'Sair' da p�gina de conting�ncia (finalizar sess�o expirada)
     * @throws Exception
     */
    @Step("Selecionar op��o 'Sair'")
    public AlertaSessaoExpiradaTela selecionarOpcaoSair() throws Exception {
        aguardarCarregamentoElemento(botaoSair);
        clicarElemento(botaoSair, "N�o foi poss�vel clicar na op��o 'Sair'");
        return this;
    }

    /**
     * Validar mensagem de alerta de sess�o expirada, exibida em pop-up, na contingencia web
     * @return
     * @throws Exception
     */
    @Step("validar mensagem alerta sessao expirada")
    public AlertaSessaoExpiradaTela validarMensagemAlertaSessaoExpirada() throws Exception {
        aguardarCarregamentoElemento(mensagemSessaoExpirada);
        Thread.sleep(10000); //garantia anima��o
        compararElementoAtributo(mensagemSessaoExpirada, AtributoElemento.TEXTO, AlertaSessaoExpirada.MENSAGEM_SESSAO_EXPIRADA.toString(), MetodoComparacao.IGUAL);
        salvarEvidencia("Validado alerta" + AlertaSessaoExpirada.MENSAGEM_SESSAO_EXPIRADA.toString());
        return this;
    }
}
