package pagina.web.sistemadegestao.Menu;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SistemaDeGestaoMenuTela extends PaginaBaseWeb {

    @FindBy(xpath = "//a[contains(., \"MIMOS\")]")
    private WebElement linkMimos;

    @FindBy(xpath = "//*[@id=\"content\"]/header/div/div/ul/li[6]/a")
    WebElement linkCard;

    @FindBy(xpath = "//*[@id=\"formCadastro:texto\"]")
    WebElement digitarTextoCard;

    @FindBy(xpath = "//*[@id=\"formCadastro\"]/div/div[2]/div[2]/a[2]")
    WebElement clicarBotaoSalvar;

    @FindBy(xpath = "/html/body/div[5]/div/div[10]/button[1]")
    WebElement clicarBotaoSim;

    @FindBy(xpath = "/html/body/div[3]/div/div[10]/button[1]")
    WebElement clicarBotaoOk;

    public SistemaDeGestaoMenuTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar Link MIMOS
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"MIMOS\"")
    public SistemaDeGestaoMenuTela clicarLinkMIMOS() throws Exception {
        aguardarElementoHabilitado(linkMimos);
        salvarEvidencia("Clicar Link para página \"MIMOS\"");
        clicarElemento(linkMimos, "Não foi possível clicar no menu Mimos");
        aguardarPaginaConterQualquerTexto("MENU MIMOS");
        return this;
    }

    /**
     * Clicar Link CARD
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"CARD\"")
    public SistemaDeGestaoMenuTela clicarLinkCARD() throws Exception {
        aguardarCarregamentoElemento(linkCard);
        salvarEvidencia("Clicar Link para página \"CARD\"");
        clicarElemento(linkCard, "Não foi possível clicar no link 'CARD'");
        return this;
    }

}
