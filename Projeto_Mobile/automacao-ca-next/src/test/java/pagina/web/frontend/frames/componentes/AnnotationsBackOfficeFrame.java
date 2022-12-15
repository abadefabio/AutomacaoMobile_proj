package pagina.web.frontend.frames.componentes;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
Classe para definição única de iframe de base (raiz)
na instanciação, momento em que o iframe é aplicado com método único.
 */
public class AnnotationsBackOfficeFrame extends PaginaBaseWeb {

    @FindBy(xpath = "//iframe[@title='Main content' and @src='/annotations/backoffice']")
    private WebElement iframe;

    public AnnotationsBackOfficeFrame(WebDriver driver) throws Exception {
        super(driver);
        iIframe();
    }

    /**
     * Método para acessar o Iframe de modo relativo
     *
     * ATENÇÃO não utilizar defaultContent
     * @return
     * @throws Exception
     */
    @Step("Método para acessar o Iframe de modo relativo")
    private AnnotationsBackOfficeFrame iIframe() throws Exception {
        driver.switchTo().frame(retornaElemento(iframe));
        return this;
    }
}
