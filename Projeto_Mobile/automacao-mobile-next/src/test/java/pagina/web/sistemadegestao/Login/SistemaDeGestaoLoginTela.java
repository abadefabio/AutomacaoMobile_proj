package pagina.web.sistemadegestao.Login;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import framework.WebUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SistemaDeGestaoLoginTela extends PaginaBaseWeb {

    /*************************************************************************************************
     * Tela de Login
     *************************************************************************************************/
    @CacheLookup
    @FindBy(xpath = "//div[@class = \"input-group\"]/input[@id = \"loginForm:username\"]")
    private WebElement campoLogin;

    @CacheLookup
    @FindBy(xpath = "//div[@class = \"input-group\"]/input[@id = \"loginForm:password\"]")
    private WebElement campoSenha;

    @CacheLookup
    @FindBy(id = "loginForm:loginButton")
    private WebElement botaoLogin;

    @CacheLookup
    @FindBy(id = "loginForm:cbEnvironment")
    private WebElement comboboxEsteira;

    public SistemaDeGestaoLoginTela(WebDriver driver) {
        super(driver);
    }


    /**
     * Preencher campo login com usu�rio de acesso
     *
     * @param usuario
     * @return
     * @throws Exception
     */
    @Step("Preencher campo login")
    public SistemaDeGestaoLoginTela preencherCampoLogin(String usuario) throws Exception{
        WebUtils.aguardarCarregamentoDaPagina(driver);
        aguardarCarregamentoElemento(campoLogin);
        digitarTexto(campoLogin, usuario,"N�o foi poss�vel preencher campo login");
        salvarEvidencia("Preencher campo login com: " + usuario);
        return this;
    }

    /**
     * Preencher campo login com senha de usuario
     *
     * @param senha
     * @return
     * @throws Exception
     */
    @Step("Preencher campo Senha")
    public SistemaDeGestaoLoginTela preencherCampoSenha(String senha) throws Exception{
        aguardarCarregamentoElemento(campoSenha);
        digitarTexto(campoSenha, senha,"N�o foi poss�vel preencher campo senha");
        salvarEvidencia("Preencher campo senha");
        return this;
    }

    /**
     * Clicar bot�o Login
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no bot�o Login")
    public SistemaDeGestaoLoginTela clicarBotaoLogin() throws Exception{
        aguardarCarregamentoElemento(botaoLogin);
        salvarEvidencia("Clicar bot�o Login");
        clicarElemento(botaoLogin, "N�o foi possivel clicar no bot�o login");
        return this;
    }

    /**
     * Selecionar esteira
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Combobox com \"Esteira\"")
    public SistemaDeGestaoLoginTela selecionarEsteira(String esteira) throws Exception{
        aguardarCarregamentoElemento(comboboxEsteira);
        rolarAteElemento(comboboxEsteira,"N�o foi poss�vel rolar a tela at� combobox \"Esteira\"");
        clicarElemento(comboboxEsteira.findElement(By.xpath("//option[contains(.,\""+ esteira +"\")]")),"N�o foi poss�vel selecionar a op��o \"" + esteira + "\" no cobobox \"Esteira\"");
        salvarEvidencia("Selecionar \""+ esteira +"\" em Combobox \"Esteira\"");
        return this;
    }
}
