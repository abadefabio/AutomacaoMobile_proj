package pagina.web.sistemadegestao.Mimos.Hub;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SistemaDeGestaoMenuHubTela extends PaginaBaseWeb {

    @FindBy(xpath = "//a[contains(., \"OFERTAS\")]")
    private WebElement linkOfertas;

    @FindBy(xpath = "//a[contains(., \"CATEGORIAS\")]")
    private WebElement linkOrdenar;

    @FindBy(xpath = "//a[contains(., \"ELEGIBILIDADE\")]")
    private WebElement linkCompartilhar;

    @FindBy(xpath = "//a[contains(., \"VOLTAR\")]")
    private WebElement linkVoltarMenuHub;

    public SistemaDeGestaoMenuHubTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar Link OFERTAS
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"OFERTAS\"")
    public SistemaDeGestaoMenuHubTela clicarLinkOfertas() throws Exception{
        aguardarElementoHabilitado(linkOfertas);
        clicarElemento(linkOfertas, "Não foi possível clicar no link \"OFERTAS\" ");
        aguardarPaginaConterQualquerTexto("Oferta Hub");
        salvarEvidencia("Clicar Link \"OFERTAS\"");
        return this;
    }

    /**
     * Clicar Link ORDENAR
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"ORDENAR\"")
    public SistemaDeGestaoMenuHubTela clicarLinkOrdenar() throws Exception{
        aguardarCarregamentoElemento(linkOrdenar);
        clicarElemento(linkOrdenar, "Não foi possível clicar no link \"ORDENAR\" ");
        salvarEvidencia("Clicar Link \"ORDENAR\"");
        return this;
    }

    /**
     * Clicar Link COMPARTILHAR
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"COMPARTILHAR\"")
    public SistemaDeGestaoMenuHubTela clicarLinkCompartilhar() throws Exception{
        aguardarCarregamentoElemento(linkCompartilhar);
        clicarElemento(linkCompartilhar, "Não foi possível clicar no link \"COMPARTILHAR\" ");
        salvarEvidencia("Clicar Link \"COMPARTILHAR\"");
        return this;
    }


    /**
     * Clicar Link VOLTAR
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"VOLTAR\"")
    public SistemaDeGestaoMenuHubTela clicarLinkVoltarMenuHub() throws Exception{
        aguardarCarregamentoElemento(linkVoltarMenuHub);
        clicarElemento(linkVoltarMenuHub, "Não foi possível clicar no link \"VOLTAR\" ");
        salvarEvidencia("Clicar Link \"VOLTAR\"");
        return this;
    }

}
