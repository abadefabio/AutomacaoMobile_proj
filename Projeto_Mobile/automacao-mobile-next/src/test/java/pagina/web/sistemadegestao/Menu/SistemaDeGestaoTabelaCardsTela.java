package pagina.web.sistemadegestao.Menu;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SistemaDeGestaoTabelaCardsTela extends PaginaBaseWeb {

    @FindBy(xpath = "//a[contains(.,'Card')]")
    private WebElement tituloTelaInicialCard;

    public SistemaDeGestaoTabelaCardsTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Método para obter o link referente ao ícone de editar
     * na coluna 6 da linha da tabela de cards que corresponde ao id card
     * @param idCard
     * @return
     * @throws NextException
     */
    public WebElement obterLinkEditar(String idCard) throws NextException {
        return retornaElemento(
                By.xpath("//table[@id='formConsultarOfertasHUB:tableCard']" +
                        "//span[contains(.,'" + idCard + "')]/../../td[6]/a")
        );
    }

    /**
     * Clicar Link Editar Card
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no link \"Editar CARD\"")
    public SistemaDeGestaoTabelaCardsTela clicarLinkEditCard(String idCard) throws Exception {
        WebElement editarCard = obterLinkEditar(idCard);
        aguardarElementoHabilitado(editarCard);
        salvarEvidencia("Clicar Link para editar card com id " + idCard);
        clicarElemento(editarCard, "Não foi possível clicar no card com id " + idCard);
        return this;
    }

    /**
     * Validar tela
     */
    @Step("Validar tela inicial 'Cards'")
    public SistemaDeGestaoTabelaCardsTela validarTela() {
        validarCondicaoBooleana(
                aguardarCarregamentoElemento(tituloTelaInicialCard),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar a tela inicial 'Card' com a tabela de cards"
        );
        salvarEvidencia("Validada a tela inicial 'Cards'");
        return this;
    }

}
