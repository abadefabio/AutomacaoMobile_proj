package pagina.web.contingencia.transferencia;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferenciaNomeTransferenciaTela extends TransferenciaTela {

    public TransferenciaNomeTransferenciaTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "description")
    private WebElement campoNomeTransferencia;

    /**
     * Met�do para informar Nome da transfer�ncia
     * @throws Exception
     * @return
     */
    @Step("Informar campo 'D� um nome para sua transfer�ncia'")
    public TransferenciaNomeTransferenciaTela informarNomeTransferencia(String nomeTransferencia) throws Exception {
        rolarParaBaixoAteElemento(campoNomeTransferencia);
        aguardarCarregamentoElemento(campoNomeTransferencia);
        digitarTexto(campoNomeTransferencia, nomeTransferencia, "N�o foi poss�vel informar nome da transfer�ncia " + nomeTransferencia);
        campoNomeTransferencia.sendKeys(Keys.TAB);
        salvarEvidencia("Informado nome da transfer�ncia: " + nomeTransferencia);
        return this;
    }
}
