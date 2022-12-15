package pagina.web.cockpit;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
Classe para defini��o �nica de iframe de base (raiz)
na instancia��o, momento em que o iframe � aplicado com m�todo �nico.
 */
public class FrameContainer extends PaginaBaseWeb {

    public FrameContainer(WebDriver driver) throws Exception {
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
    private FrameContainer irIframe() throws Exception{
        driver.switchTo().frame(retornaElemento(By.id("frame-container")));
        return this;
    }
}
