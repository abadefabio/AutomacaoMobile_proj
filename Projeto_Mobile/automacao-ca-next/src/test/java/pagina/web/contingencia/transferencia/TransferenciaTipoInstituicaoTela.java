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

    @FindBy(xpath = "//*[@id='Instituição de pagamento1-label']/span")
    private WebElement radioButtonInstituicaoPagamento;

    /**
     * Metódo para clicar no radiobutton 'Banco'
     * @throws Exception
     * @return
     */
    @Step("Clicar radioButton 'Banco'")
    public TransferenciaTipoInstituicaoTela clicarRadionButtonBanco() throws Exception {
        rolarParaBaixoAteElemento(radioButtonBanco);
        aguardarCarregamentoElemento(radioButtonBanco);
        clicarElemento(radioButtonBanco, "Não foi possível clicar no radiobutton 'Banco'");
        salvarEvidencia("Clicado no radionbutton 'Banco': ");
        return this;
    }

    /**
     * Metódo para clicar radiobutton 'Instituição de Pagamento'
     * @throws Exception
     * @return
     */
    @Step("Clicar radiobutton 'Instituição de Pagamento'")
    public TransferenciaTipoInstituicaoTela clicarRadioButtonInstituicaoPagamento() throws Exception {
        rolarParaBaixoAteElemento(radioButtonInstituicaoPagamento);
        aguardarCarregamentoElemento(radioButtonInstituicaoPagamento);
        clicarElemento(radioButtonInstituicaoPagamento, "Não foi possível clicar no radiobutton 'Instituição de Pagamento'");
        salvarEvidencia("Clicado no radiobutton 'Instituição de Pagamento': ");
        return this;
    }
}
