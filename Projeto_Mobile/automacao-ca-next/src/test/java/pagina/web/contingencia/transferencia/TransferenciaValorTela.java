package pagina.web.contingencia.transferencia;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferenciaValorTela extends TransferenciaTela {

    public TransferenciaValorTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "amount")
    private WebElement campoValorTransferencia;

    @FindBy(id = "amount_label")
    private WebElement labelValorTransferencia;

    /**
     * Met�do para retirar o foco do campo  valor
     * @throws Exception
     * @return
     */
    @Step("Retirar o foco do campo valor")
    private TransferenciaValorTela clicarOutroElementoParaRetirarFocoCampoValor() throws Exception {
        //Solu��o tempor�ria para retirar o foco do campo valor
        rolarParaBaixoAteElemento(labelValorTransferencia);
        aguardarCarregamentoElemento(labelValorTransferencia);
        clicarElemento(labelValorTransferencia, "N�o foi poss�vel retirar o foco do campo valor " );
        return this;
    }


    /**
     * Met�do para informar o valor que ser� transferido
     * @throws Exception
     * @return
     */
   @Step("Informar no campo valor")
    public TransferenciaValorTela informarValorTransferir(String valorTransferir) throws Exception {
        rolarParaBaixoAteElemento(campoValorTransferencia);
        aguardarCarregamentoElemento(campoValorTransferencia);
        digitarTexto(campoValorTransferencia, valorTransferir, "N�o foi poss�vel informar o valor que ser� transferido " + valorTransferir);
        salvarEvidencia("Informado o valor que ser� transferido: " + valorTransferir);
        clicarOutroElementoParaRetirarFocoCampoValor();
        return this;
    }
}

