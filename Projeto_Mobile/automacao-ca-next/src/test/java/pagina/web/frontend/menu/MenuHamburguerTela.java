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
     * Clicar no botão Indicações de Amigos dentro do menu Hamburguer
     *
     * @throws Exception
     * @return MenuHamburguerTela
     */
    @Step("Clicar no botão Indicações de Amigos")
    public MenuHamburguerTela clicarBotaoIndicacoesAmigos() throws Exception {
        clicarElemento(botaoIndicacoesAmigos, "Não foi possível clicar no botão Indicações de Amigos");
        aguardarContainerCarregamentoPaginaDesaparecer();
        salvarEvidencia("Acessar página Indicações de Amigos");
        return this;
    }
}
