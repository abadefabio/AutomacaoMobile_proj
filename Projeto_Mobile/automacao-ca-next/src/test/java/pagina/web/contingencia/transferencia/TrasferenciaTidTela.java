package pagina.web.contingencia.transferencia;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import br.com.next.automacao.core.tools.imagens.LeitorQRCode;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static framework.WebUtils.aguardarCarregamentoDaPagina;

public class TrasferenciaTidTela extends PaginaBaseWeb {

    public TrasferenciaTidTela(WebDriver driver) {
        super(driver);
    };

    @FindAll({
            @FindBy(id = "qrCodeValue"),
            @FindBy(xpath = "//img[contains(@alt,'Code')]"),
            @FindBy(id = "qrCode")
    })

    private WebElement qrCodeImg;

    /**
     * Método para obter a TID, baseado no método de ler QRCode.
     *
     * @throws Exception
     */
    @Step("Ler TID do QR Code")
    public String lerTID() throws Exception {
        aguardarCarregamentoDaPagina(driver);
        aguardarCarregamentoElemento(qrCodeImg);
        String resposta = LeitorQRCode.lerQRCode(getImagemBase64Header(qrCodeImg));
        String TID;
        TID = StringUtils.substringAfter(resposta, "{\"tid\":\"");
        TID = StringUtils.substringBefore(TID, "\"}");
        OperadorEvidencia.logarPasso("TID: " + TID);
        return TID;
    }
}
