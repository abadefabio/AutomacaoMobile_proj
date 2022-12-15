package pagina.web.cockpit;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
Classe para definição única de iframe de base (raiz)
na instanciação, momento em que o iframe é aplicado com método único.
 */
public class FrameContainer extends PaginaBaseWeb {

    public FrameContainer(WebDriver driver) throws Exception {
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
    private FrameContainer irIframe() throws Exception{
        driver.switchTo().frame(retornaElemento(By.id("frame-container")));
        return this;
    }
}
