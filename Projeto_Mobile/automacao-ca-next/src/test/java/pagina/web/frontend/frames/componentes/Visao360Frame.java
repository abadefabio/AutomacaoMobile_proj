package pagina.web.frontend.frames.componentes;

import br.com.next.automacao.core.base.PaginaNext;
import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
Classe para defini��o �nica de iframe de base (raiz)
na instancia��o, momento em que o iframe � aplicado com m�todo �nico.
 */
public class Visao360Frame extends PaginaBaseWeb {

    @FindBy(xpath = "//iframe[@title='Main content' and @src='/visao360/backoffice-offline']")
    private WebElement iframe;

    public Visao360Frame(WebDriver driver) throws Exception {
        super(driver);
        irIframe();
    }

    /**
     * M�todo para acessar o Iframe de modo relativo
     *
     * ATEN��O n�o utilizar defaultContent
     * @return
     * @throws Exception
     */
    @Step("M�todo para acessar o Iframe")
    private Visao360Frame irIframe() throws Exception{
        driver.switchTo().frame(retornaElemento(iframe));
        return this;
    }
}
