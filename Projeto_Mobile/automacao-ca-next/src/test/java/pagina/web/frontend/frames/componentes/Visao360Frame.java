package pagina.web.frontend.frames.componentes;

import br.com.next.automacao.core.base.PaginaNext;
import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
Classe para definição única de iframe de base (raiz)
na instanciação, momento em que o iframe é aplicado com método único.
 */
public class Visao360Frame extends PaginaBaseWeb {

    @FindBy(xpath = "//iframe[@title='Main content' and @src='/visao360/backoffice-offline']")
    private WebElement iframe;

    public Visao360Frame(WebDriver driver) throws Exception {
        super(driver);
        irIframe();
    }

    /**
     * Método para acessar o Iframe de modo relativo
     *
     * ATENÇÃO não utilizar defaultContent
     * @return
     * @throws Exception
     */
    @Step("Método para acessar o Iframe")
    private Visao360Frame irIframe() throws Exception{
        driver.switchTo().frame(retornaElemento(iframe));
        return this;
    }
}
