package pagina.web.contingencia.transferencia;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferenciaTela extends PaginaBaseWeb {

    public TransferenciaTela(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "stepFormNextButton")
    private WebElement botaoAvancar;

    @FindBy(id = "stepFormBackButton")
    private WebElement botaoVoltar;

    /**
     * Met�do para clicar no bot�o 'Avan�ar' na tela de transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Clicar no bot�o avan�ar na tela de transfer�ncia")
    public TransferenciaTela clicarBotaoAvancar() throws Exception {
        rolarParaBaixoAteElemento(botaoAvancar);
        aguardarCarregamentoElemento(botaoAvancar);
        salvarEvidencia("Clicado bot�o avan�ar ");
        clicarElemento(botaoAvancar, "N�o foi poss�vel clicar no bot�o 'Avan�ar'");
        return this;
    }

    /**
     * Met�do para clicar bot�o 'Voltar' na tela de transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Clicar no bot�o avan�ar na tela de transfer�ncia")
    public TransferenciaTela clicarBotaoVoltar() throws Exception {
        rolarParaBaixoAteElemento(botaoVoltar);
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicado bot�o voltar ");
        clicarElemento(botaoVoltar, "N�o foi poss�vel clicar no bot�o 'Voltar'");
        return this;
    }
}
