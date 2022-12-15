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
     * Metódo para clicar no botão 'Avançar' na tela de transferência
     * @throws Exception
     * @return
     */
    @Step("Clicar no botão avançar na tela de transferência")
    public TransferenciaTela clicarBotaoAvancar() throws Exception {
        rolarParaBaixoAteElemento(botaoAvancar);
        aguardarCarregamentoElemento(botaoAvancar);
        salvarEvidencia("Clicado botão avançar ");
        clicarElemento(botaoAvancar, "Não foi possível clicar no botão 'Avançar'");
        return this;
    }

    /**
     * Metódo para clicar botão 'Voltar' na tela de transferência
     * @throws Exception
     * @return
     */
    @Step("Clicar no botão avançar na tela de transferência")
    public TransferenciaTela clicarBotaoVoltar() throws Exception {
        rolarParaBaixoAteElemento(botaoVoltar);
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicado botão voltar ");
        clicarElemento(botaoVoltar, "Não foi possível clicar no botão 'Voltar'");
        return this;
    }
}
