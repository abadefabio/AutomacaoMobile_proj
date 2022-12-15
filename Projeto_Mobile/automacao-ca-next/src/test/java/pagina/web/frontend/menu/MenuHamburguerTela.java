package pagina.web.frontend.menu;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagina.web.frontend.base.GestaoOcorrenciasTela;

public class MenuHamburguerTela extends GestaoOcorrenciasTela {

    @FindBy(css = "a[href='/tratamentoocorrencias/ocorrencias/mgm.shtml']")
    private WebElement botaoIndicacoesAmigos;

    public MenuHamburguerTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar no bot�o Indica��es de Amigos dentro do menu Hamburguer
     *
     * @throws Exception
     * @return MenuHamburguerTela
     */
    @Step("Clicar no bot�o Indica��es de Amigos")
    public MenuHamburguerTela clicarBotaoIndicacoesAmigos() throws Exception {
        clicarElemento(botaoIndicacoesAmigos, "N�o foi poss�vel clicar no bot�o Indica��es de Amigos");
        aguardarContainerCarregamentoPaginaDesaparecer();
        salvarEvidencia("Acessar p�gina Indica��es de Amigos");
        return this;
    }
}
