package pagina.web.contingencia.transferencia;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferenciaTipoInstituicaoTela extends TransferenciaTela {

    public TransferenciaTipoInstituicaoTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='Banco0-label']/span")
    private WebElement radioButtonBanco;

    @FindBy(xpath = "//*[@id='Institui��o de pagamento1-label']/span")
    private WebElement radioButtonInstituicaoPagamento;

    /**
     * Met�do para clicar no radiobutton 'Banco'
     * @throws Exception
     * @return
     */
    @Step("Clicar radioButton 'Banco'")
    public TransferenciaTipoInstituicaoTela clicarRadionButtonBanco() throws Exception {
        rolarParaBaixoAteElemento(radioButtonBanco);
        aguardarCarregamentoElemento(radioButtonBanco);
        clicarElemento(radioButtonBanco, "N�o foi poss�vel clicar no radiobutton 'Banco'");
        salvarEvidencia("Clicado no radionbutton 'Banco': ");
        return this;
    }

    /**
     * Met�do para clicar radiobutton 'Institui��o de Pagamento'
     * @throws Exception
     * @return
     */
    @Step("Clicar radiobutton 'Institui��o de Pagamento'")
    public TransferenciaTipoInstituicaoTela clicarRadioButtonInstituicaoPagamento() throws Exception {
        rolarParaBaixoAteElemento(radioButtonInstituicaoPagamento);
        aguardarCarregamentoElemento(radioButtonInstituicaoPagamento);
        clicarElemento(radioButtonInstituicaoPagamento, "N�o foi poss�vel clicar no radiobutton 'Institui��o de Pagamento'");
        salvarEvidencia("Clicado no radiobutton 'Institui��o de Pagamento': ");
        return this;
    }
}
