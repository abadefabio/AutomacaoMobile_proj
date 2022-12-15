package pagina.web.fnext.comum;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class LoginTela extends PaginaBaseWeb {

    /**
     * Navegar para a página de login do Fnext
     * A url foi definida em parâmetro de execução do XML no TestNG,
     * razão pela qual obtemos esse parâmetro previamente na classe do teste e o
     * passamos neste método.
     *
     * @param url
     * @throws Exception
     */
    @Step("Navegar para página inicial do login do Fnext")
    public LoginTela navegar(String url) throws Exception {
        getWebDriver().get(url);
        return this;
    }

    @FindBy(id = "mat-input-0")
    private WebElement campoUsuario;

    @FindBy(id = "mat-input-1")
    private WebElement campoSenha;

    @FindBy(xpath = "//button/div")
    private WebElement botaoConfirmar;

    public LoginTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Preencher campo Usuário no Login
     *
     * @param usuario
     * @return
     * @throws Exception
     */
    @Step("Preencher campo usuário")
    public LoginTela preencherCampoUsuario(String usuario) throws Exception {
        aguardarCarregamentoElemento(campoUsuario);
        digitarTexto(campoUsuario,usuario, "Erro ao digitar usuário");
        return this;
    }


    /**
     * Preencher campo Senha no Login
     *
     * @param senha
     * @return
     * @throws Exception
     */
    @Step("Preencher campo senha")
    public LoginTela preencherCampoSenha(String senha) throws Exception {
        aguardarCarregamentoElemento(campoSenha);
        digitarTexto(campoSenha,senha,"Erro ao digitar senha");
        return this;
    }

    /**
     * Clicar no botão Confirmar no Login
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botao confirmar")
    public LoginTela clicarBotaoConfirmar() throws Exception {
        aguardarElementoClicavel(botaoConfirmar);
        salvarEvidencia("Tela de login preenchida");
        clicarElemento(botaoConfirmar, "Erro ao clicar no botão Confirmar");
        return this;
    }
}
