package pagina.web.frontend.frames.componentes;

import br.com.next.automacao.core.base.PaginaNext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
Classe para definição única de iframe de base (raiz)
na instanciação, momento em que o iframe é aplicado com método único.
 */
public class ComponenteOcorrenciasFrame extends PaginaNext {

    @FindBy(id = "frame1")
    private WebElement frame1;

    @FindBy(id = "frame2")
    private WebElement frame2;

    public ComponenteOcorrenciasFrame(WebDriver driver) throws Exception {
        super(driver);
        definirIframeBase();
    }

    /**
     * Método para retornar o iframe de base do componente Ocorrências
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar o iframe do componente Ocorrências")
    private ComponenteOcorrenciasFrame definirIframeBase() throws Exception{
        driver.switchTo().frame(retornaElemento(frame1));
        return this;
    }


}
