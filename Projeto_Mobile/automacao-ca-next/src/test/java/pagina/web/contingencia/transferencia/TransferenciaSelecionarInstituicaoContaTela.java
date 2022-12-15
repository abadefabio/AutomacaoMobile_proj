package pagina.web.contingencia.transferencia;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.WebUtils.aguardarCarregamentoDaPagina;
public class TransferenciaSelecionarInstituicaoContaTela extends TransferenciaTela {

    public TransferenciaSelecionarInstituicaoContaTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'accordionContent active']//input/..")
    private WebElement radioButtonConta;

    @FindBy(xpath = "//*[@id='confirmContacts' and contains(@class,'next-button--primary')]")
    private WebElement botaoConfirmaFavorecido;

    @FindBy(xpath = "//*[@aria-label=\"Ir para pr�xima p�gina\"]")
    private WebElement clicaAvancar;

    /**
     * M�todo para selecionar um Favorecido na lista de contatos
     *
     * @param agencia
     * @param conta
     * @return
     * @throws Exception
     */
    @Step("Selecionar na modal o favorecido para quem ser� feita a transfer�ncia")
    public TransferenciaSelecionarInstituicaoContaTela clicarRadioButtonConta(String agencia, String conta) throws Exception {
        aguardarCarregamentoDaPagina(driver);
        By element = By.xpath("//span[text()='" + agencia.concat(" | ").concat(conta) + "']/parent::td/preceding::td[2]/label/label");
        clicarElemento(element,
                "N�o foi poss�vel clicar no favorecido com ag�ncia: " + agencia + " e conta: " + conta);
        salvarEvidencia("Selecionado o favorecido com ag�ncia: " + agencia + " e conta: " + conta);
        return this;
    }

    /**
     * M�todo para selecionar uma conta na lista de favorecidos
     *
     * @param nome
     * @return
     * @throws Exception
     */
    @Step("Selecionar uma das contas cadastrada do favorecido")
    public TransferenciaSelecionarInstituicaoContaTela selecionarContaFavorecido(String nome) throws Exception {
        aguardarCarregamentoDaPagina(driver);
        By elementoConta = By.xpath("//button/span[text()='" + nome + "']");
        boolean isContatoFavorecido = driver.findElements(elementoConta).size() > 0;
        while (!isContatoFavorecido) {
            salvarEvidencia("[WEB]: N�o foi poss�vel encontrar o favorecido: " + nome);
            clicarElemento(clicaAvancar, "N�o foi poss�vel clicar no bot�o avan�ar");
            aguardarCarregamentoDaPagina(driver);
            isContatoFavorecido = driver.findElements(elementoConta).size() > 0;
            By paginacao = By.xpath("//*[@aria-label=\"Ir para pr�xima p�gina\" and @class=\"next-pagination__item next-pagination__item--round next-pagination__item--navigation next-pagination__item--isDisabled\"]");
            boolean pagina = driver.findElements(paginacao).size() > 0;
            if(pagina && !isContatoFavorecido){
                salvarEvidencia("[WEB]: N�o foi poss�vel encontrar o favorecido: " + nome);
                throw new Exception("[WEB]: N�o foi poss�vel encontrar o favorecido: " + nome);
            }
        };
        boolean elementoExpandido = driver.findElements(By.xpath("//div[@class=\"accordionContent active\"]")).size() > 0;
        WebElement contatoFavorecido = retornaElemento(elementoConta);
        if (!elementoExpandido) {
            clicarElemento(contatoFavorecido, "N�o foi poss�vel clicar na conta do favorecido");
            aguardarCarregamentoDaPagina(driver);
        }
        salvarEvidencia("Selecionada a conta do favorecido: " + nome);
        return this;
    }

    /**
     * M�todo para clicar no bot�o para confirmar a sele��o na lista favorecido
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no bot�o para confirmar a sele��o da conta")
    public TransferenciaSelecionarInstituicaoContaTela clicarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmaFavorecido);
        clicarElemento(botaoConfirmaFavorecido, "N�o foi poss�vel clicar no bot�o confirmar");
        salvarEvidencia("Clicado no bot�o: " + botaoConfirmaFavorecido);
        return this;
    }
}
