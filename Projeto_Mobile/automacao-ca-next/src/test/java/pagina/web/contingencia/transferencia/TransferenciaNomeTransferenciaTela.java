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
     * Metódo para informar Nome da transferência
     * @throws Exception
     * @return
     */
    @Step("Informar campo 'Dê um nome para sua transferência'")
    public TransferenciaNomeTransferenciaTela informarNomeTransferencia(String nomeTransferencia) throws Exception {
        rolarParaBaixoAteElemento(campoNomeTransferencia);
        aguardarCarregamentoElemento(campoNomeTransferencia);
        digitarTexto(campoNomeTransferencia, nomeTransferencia, "Não foi possível informar nome da transferência " + nomeTransferencia);
        campoNomeTransferencia.sendKeys(Keys.TAB);
        salvarEvidencia("Informado nome da transferência: " + nomeTransferencia);
        return this;
    }
}
