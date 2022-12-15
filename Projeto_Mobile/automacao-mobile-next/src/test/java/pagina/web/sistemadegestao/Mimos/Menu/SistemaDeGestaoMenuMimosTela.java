package pagina.web.sistemadegestao.Mimos.Menu;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import framework.WebUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SistemaDeGestaoMenuMimosTela extends PaginaBaseWeb {

    @FindBy(xpath = "//a[contains(., \"PARCEIROS\")]")
    private WebElement linkParceiros;

    @FindBy(xpath = "//a[contains(., \"CATEGORIAS\")]")
    private WebElement linkCategorias;

    @FindBy(xpath = "//a[contains(., \"ELEGIBILIDADE\")]")
    private WebElement linkElegibilidade;

    @FindBy(xpath = "//a[contains(., \"JOY\")]")
    private WebElement linkJoy;

    @FindBy(xpath = "//a[contains(., \"HUB\")]")
    private WebElement linkHub;

    @FindBy(xpath = "//a[contains(., \"CARD\")]")
    private WebElement linkCard;

    @FindBy(xpath = "//a[contains(., \"ORDENAR CARD\")]")
    private WebElement linkOrdenarCard;

    @FindBy(xpath = "//a[contains(., \"ESTATISTICAS\")]")
    private WebElement linkEstatisticas;

    @FindBy(xpath = "//a[contains(., \"VOLTAR\")]")
    private WebElement linkVoltarMenuMimos;

    @FindBy(xpath = "//a[contains(., \"TERMOS E CONDI\")]")
    private WebElement linkTermosCondicoes ;

    public SistemaDeGestaoMenuMimosTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar Link PARCEIROS
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"PARCEIROS\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkParceiros() throws Exception{
        aguardarCarregamentoElemento(linkParceiros);
        clicarElemento(linkParceiros, "Não foi possível clicar no link \"PARCEIROS\" ");
        salvarEvidencia("Clicar Link \"PARCEIROS\"");
        return this;
    }

    /**
     * Clicar Link CATEGORIAS
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"CATEGORIAS\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkCategorias() throws Exception{
        aguardarCarregamentoElemento(linkCategorias);
        clicarElemento(linkCategorias, "Não foi possível clicar no link \"CATEGORIAS\" ");
        salvarEvidencia("Clicar Link \"CATEGORIAS\"");
        return this;
    }

    /**
     * Clicar Link ELEGIBILIDADE
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"ELEGIBILIDADE\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkEligibilidade() throws Exception{
        aguardarCarregamentoElemento(linkElegibilidade);
        clicarElemento(linkElegibilidade, "Não foi possível clicar no link \"ELEGIBILIDADE\" ");
        salvarEvidencia("Clicar Link \"ELEGIBILIDADE\"");
        return this;
    }

    /**
     * Clicar Link JOY
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"PARCEIROS\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkJoy() throws Exception{
        aguardarCarregamentoElemento(linkJoy);
        clicarElemento(linkJoy, "Não foi possível clicar no link \"JOY\" ");
        salvarEvidencia("Clicar Link \"JOY\"");
        return this;
    }

    /**
     * Clicar Link HUB
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"HUB\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkHub() throws Exception{
        aguardarElementoHabilitado(linkHub);
        clicarElemento(linkHub, "Não foi possível clicar no link \"HUB\" ");
        aguardarPaginaConterQualquerTexto("MENU HUB");
        salvarEvidencia("Clicar Link \"HUB\"");
        return this;
    }

    /**
     * Clicar Link CARD
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"CARD\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkCard() throws Exception{
        aguardarCarregamentoElemento(linkCard);
        clicarElemento(linkCard, "Não foi possível clicar no link \"CARD\" ");
        salvarEvidencia("Clicar Link \"CARD\"");
        return this;
    }

    /**
     * Clicar Link ORDENAR CARD
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"ORDENAR CARD\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkOrdenarCard() throws Exception{
        aguardarCarregamentoElemento(linkOrdenarCard);
        clicarElemento(linkOrdenarCard, "Não foi possível clicar no link \"ORDENAR CARD\" ");
        salvarEvidencia("Clicar Link \"ORDENAR CARD\"");
        return this;
    }

    /**
     * Clicar Link ESTATISTICAS
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"ESTATISTICAS\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkEstatisticas() throws Exception{
        aguardarCarregamentoElemento(linkEstatisticas);
        clicarElemento(linkEstatisticas, "Não foi possível clicar no link \"ESTATISTICAS\" ");
        salvarEvidencia("Clicar Link \"ESTATISTICAS\"");
        return this;
    }

    /**
     * Clicar Link VOLTAR
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"VOLTAR\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkVoltarMenuMimos() throws Exception{
        aguardarCarregamentoElemento(linkVoltarMenuMimos);
        clicarElemento(linkVoltarMenuMimos, "Não foi possível clicar no link \"VOLTAR\" ");
        salvarEvidencia("Clicar Link \"VOLTAR\"");
        return this;
    }

    /**
     * Clicar Link TERMOS E CONDIÇÕES
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"TERMOS E CONDICOES\"")
    public SistemaDeGestaoMenuMimosTela clicarLinkTermosECondicoes() throws Exception{
        WebUtils.aguardarCarregamentoDaPagina(driver);
        aguardarCarregamentoElemento(linkTermosCondicoes);
        salvarEvidencia("Clicar no link \"TERMOS E CONDICOES\"");
        clicarElemento(linkTermosCondicoes, "Não foi possível Clicar no link \"TERMOS E CONDICOES\" ");
        return this;
    }

}
