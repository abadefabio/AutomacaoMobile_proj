package pagina.web.contingencia.transferencia;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.UnsupportedEncodingException;

public class TransferenciaTipoContaTela extends TransferenciaTela {

    public TransferenciaTipoContaTela(WebDriver driver) {
        super(driver);
    }

    public static String ajustarEncodeString(String string) throws UnsupportedEncodingException {
        return string;
    }

    @FindBy(id = "recipientAccountType")
    private WebElement campoTipoConta;

    /**
     * Metódo para clicar na item tipo conta
     * @throws Exception
     * @return
     */
    @Step("Selecionar o valor 'TipoConta'")
    public TransferenciaTipoContaTela selecionarTipoConta(String tipoConta) throws Exception {
        rolarParaBaixoAteElemento(campoTipoConta);
        aguardarCarregamentoElemento(campoTipoConta);
        selecionarTextoCombobox(campoTipoConta, ajustarEncodeString(tipoConta),  "Não foi possível clicar no tipo da conta: " + tipoConta );
        salvarEvidencia("Selecionado tipo conta: " + tipoConta );
        return this;
    }
}
