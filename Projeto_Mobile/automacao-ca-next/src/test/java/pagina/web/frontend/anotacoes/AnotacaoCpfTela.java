package pagina.web.frontend.anotacoes;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AnotacaoCpfTela extends PaginaBaseWeb {

    public AnotacaoCpfTela(WebDriver driver) {super(driver);}

    @FindAll({
            @FindBy(xpath = "//input[@id='mat-input-2']"),
            @FindBy(xpath = "//mat-label[contains(text(), 'CPF')]/../../../input")
    })
    private WebElement inputCpfAnotacao;

    @FindBy(xpath = "//div[@class='column-buttons']//button[text()='Limpar']")
    private WebElement btnLimpar;

    @FindBy(xpath = "//div[@class='column-buttons']//button[text()='Buscar']")
    private WebElement btnBuscar;

    /**
     * Informar CPF na p�gina de Anota��es do Gestao de Ocorrencias
     *
     * @param cpf
     * @throws Exception
     */
    @Step("Entrar com CPF")
    public AnotacaoCpfTela informarCpf(String cpf) throws Exception {
        aguardarCarregamentoQualquerElemento(btnBuscar);
        digitarTexto(inputCpfAnotacao, cpf, "N�o foi poss�vel digitar o texto " + cpf);
        salvarEvidencia("Informar CPF");
        return this;
    }

    /**
     * Clicar no bot�o Buscar para abrir a tela de anota��es do cliente
     *
     * @throws Exception
     */
    @Step("Clicar no bot�o Buscar")
    public AnotacaoCpfTela clicarBuscar() throws Exception {
        clicarElemento(btnBuscar, "N�o foi poss�vel clicar no campo CPF");
        salvarEvidencia("Clicar em buscar");
        return this;
    }

}
