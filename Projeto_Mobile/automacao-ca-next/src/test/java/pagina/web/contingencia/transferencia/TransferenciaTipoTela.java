package pagina.web.contingencia.transferencia;

import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.WebUtils.aguardarCarregamentoDaPagina;

public class TransferenciaTipoTela extends TransferenciaTela {

    public TransferenciaTipoTela(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "TED0-label")
    private WebElement labelTipoTed;
    @FindBy(xpath = "//*[@id='TED0']")
    private WebElement radionButtonTed;
    @FindBy(id = "DOC1-label")
    private WebElement labelTipoDoc;
    @FindBy(xpath = "//*[@id='DOC1']")
    private WebElement radionButtonDoc;

    /**
     * Met�do para clicar tipo de transfer�ncia TED
     *
     * @return TransferenciaTipoTela
     * @throws Exception
     */
    @Step("Clicar radio Button 'Qual o tipo de transfer�ncia? - TED'")
    public TransferenciaTipoTela clicarTransferirTed() throws Exception {
        int cont = 0;
        aguardarCarregamentoDaPagina(driver);
        do {
            Thread.sleep(2000);
            cont++;
            OperadorEvidencia.logarPasso("[WEB]: Aguardando tipo de transfer�ncia ser habilitado. " + cont);
        } while (!radionButtonTed.isEnabled() && cont < 10);
        clicarElemento(labelTipoTed, "N�o foi poss�vel clicar na op��o 'TED'");
        salvarEvidencia("Clicado Tipo de transfer�ncia TED: ");
        return this;
    }

    /**
     * Met�do para clicar no tipo de transfer�ncia DOC
     *
     * @return TransferenciaTipoTela
     * @throws Exception
     */
    @Step("Clicar radio Button 'Qual o tipo de transfer�ncia? - DOC'")
    public TransferenciaTipoTela clicarTransferirDoc() throws Exception {
        int cont = 0;
        aguardarCarregamentoDaPagina(driver);
        rolarParaBaixoAteElemento(labelTipoDoc);
        do {
            Thread.sleep(2000);
            cont++;
            OperadorEvidencia.logarPasso("[WEB]: Aguardando tipo de transfer�ncia ser habilitado. " + cont);
        } while (!radionButtonDoc.isEnabled() && cont < 10);
        clicarElemento(labelTipoDoc, "N�o foi poss�vel clicar na op��o 'DOC'");
        salvarEvidencia("Clicado no tipo de transfer�ncia DOC: ");
        return this;
    }
}
