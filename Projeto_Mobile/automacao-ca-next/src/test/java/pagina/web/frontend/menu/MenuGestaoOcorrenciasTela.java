package pagina.web.frontend.menu;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuGestaoOcorrenciasTela extends PaginaBaseWeb {

    public MenuGestaoOcorrenciasTela(WebDriver driver) { super(driver);}

    @FindBy(css = "div.menu-container")
    private WebElement menuHamburguer;

    @FindBy(xpath = "//span[text()='Gestão de Ocorrências']")
    private WebElement tituloGestaoOcorrencias;

    @FindBy(xpath = "//a[contains(text(),'Anotações')]")
    private WebElement menuAnotacoes;

    /**
     * Clicar no menu Hamburguer no menu Gestao de Ocorrencias
     *
     * @throws Exception
     * @return MenuGestaoOcorrenciasTela
     */
    @Step("Clicar no menu Hamburguer")
    public MenuGestaoOcorrenciasTela clicarMenuHamburguer() throws Exception {
        clicarElemento(menuHamburguer, "Não foi possível clicar no menu Hamburguer");
        salvarEvidencia("Acessar menu Hamburguer");
        return this;
    }

    /**
     * Clicar na aba Anotacao no menu Gestao de Ocorrencias
     *
     * @throws Exception
     */
    @Step("Clicar na aba Anotacao")
    public MenuGestaoOcorrenciasTela clicarAbaAnotacao() throws Exception {
        clicarElemento(menuAnotacoes, "Não foi possível clicar na aba Anotacao");
        atualizarPagina();
        salvarEvidencia("Acessar Menu Anotacoes");
        return this;
    }
}
