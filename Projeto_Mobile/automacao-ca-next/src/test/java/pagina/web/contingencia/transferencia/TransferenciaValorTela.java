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
     * Metódo para retirar o foco do campo  valor
     * @throws Exception
     * @return
     */
    @Step("Retirar o foco do campo valor")
    private TransferenciaValorTela clicarOutroElementoParaRetirarFocoCampoValor() throws Exception {
        //Solução temporária para retirar o foco do campo valor
        rolarParaBaixoAteElemento(labelValorTransferencia);
        aguardarCarregamentoElemento(labelValorTransferencia);
        clicarElemento(labelValorTransferencia, "Não foi possível retirar o foco do campo valor " );
        return this;
    }


    /**
     * Metódo para informar o valor que será transferido
     * @throws Exception
     * @return
     */
   @Step("Informar no campo valor")
    public TransferenciaValorTela informarValorTransferir(String valorTransferir) throws Exception {
        rolarParaBaixoAteElemento(campoValorTransferencia);
        aguardarCarregamentoElemento(campoValorTransferencia);
        digitarTexto(campoValorTransferencia, valorTransferir, "Não foi possível informar o valor que será transferido " + valorTransferir);
        salvarEvidencia("Informado o valor que será transferido: " + valorTransferir);
        clicarOutroElementoParaRetirarFocoCampoValor();
        return this;
    }
}

