package pagina.web.contingencia.views.alertas;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.drivers.OperadorDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class AlertaSessaoFinalizadaSairTela extends PaginaBaseWeb {

    public AlertaSessaoFinalizadaSairTela(WebDriver driver) {
        super(driver);
    }

    @FindBys({

            @FindBy(id = "message-alert-0-btn-0"),
            @FindBy(xpath = "//button[@id='message-alert-0-btn-0']"),
            @FindBy(xpath = "//button[contains(text(), 'Sair')]"),
    })
    private WebElement botaoSair;

    /**
     * Selecionar a opção 'Sair' da página de contingência (finalizar)
     * @throws Exception
     */
    @Step("Selecionar opção 'Sair'")
    public AlertaSessaoFinalizadaSairTela selecionarOpcaoSair() throws Exception {
        aguardarCarregamentoElemento(botaoSair);
        salvarEvidencia("Clicar no botão 'Sair' no popup final");
        aguardarPaginaConterQualquerTexto("Sair");
        salvarEvidencia("Contingência finalizada no navegador");
            ((JavascriptExecutor) OperadorDriver.getWebDriver()).executeScript("arguments[0].click();", new Object[]{this.retornaElemento(botaoSair)});
        return this;
    }
}
