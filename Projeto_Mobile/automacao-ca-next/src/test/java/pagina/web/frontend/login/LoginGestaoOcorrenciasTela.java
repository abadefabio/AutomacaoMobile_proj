package pagina.web.frontend.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagina.web.frontend.base.GestaoOcorrenciasTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class LoginGestaoOcorrenciasTela extends GestaoOcorrenciasTela {

    @FindBy(id = "user")
    private WebElement campoUsuario;

    @FindBy(id = "pass")
    private WebElement campoSenha;

    @FindBy(xpath = "//button[text()='CONFIRMAR']")
    private WebElement btnConfirmar;

    @FindBy(className = "brq-loader-container")
    private WebElement loading_container;

    public LoginGestaoOcorrenciasTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Informa o usuário na tela de login do Gestao de Ocorrencias
     *
     * @throws Exception
     * @return LoginGestaoOcorrenciasTela
     */
    @Step("Navegar tela Gestao de Ocorrencias")
    public LoginGestaoOcorrenciasTela navegarTelaGestaoOcorrencias(String gestaoOcorrencia_Url) {
        navegar(gestaoOcorrencia_Url);
        return this;
    }

    /**
     * Navegar para a página de login do Gestão de Ocorrencias
     * A url foi definida em parâmetro dentro da funcionalidade de login
     *
     * @param url
     * @throws Exception
     * @return LoginGestaoOcorrenciasTela
     */
    @Step("Navegar tela Gestao de Ocorrencias")
    public LoginGestaoOcorrenciasTela navegar(String url) {
        getWebDriver().get(url);
        return this;
    }

    /**
     * Informa o usuário na tela de login do Gestao de Ocorrencias
     *
     * @param usuario
     * @throws Exception
     * @return LoginGestaoOcorrenciasTela
     */
    @Step("Informar usuario")
    public LoginGestaoOcorrenciasTela informarUsuario(String usuario) throws Exception {
        digitarTexto(campoUsuario, usuario, "Não foi possível digitar o texto " + usuario);
        salvarEvidencia("Informar Usuario");
        return this;
    }

    /**
     * Informa a senha na tela de login do Gestao de Ocorrencias
     *
     * @param senha
     * @throws Exception
     * @return LoginGestaoOcorrenciasTela
     */

    @Step("Informar senha")
    public LoginGestaoOcorrenciasTela informarSenha(String senha) throws Exception {
        digitarTexto(campoSenha, senha, "Não foi possível digitar o texto " + senha);
        salvarEvidencia("Informar Senha");
        return this;
    }

    /**
     * Clicar no botão CONFIRMAR para realizar o login no Gestão de Ocorrencias
     *
     * @throws Exception
     * @return LoginGestaoOcorrenciasTela
     */

    @Step("Clicar em Confirmar")
    public LoginGestaoOcorrenciasTela clicarConfirmar() throws Exception {
        clicarElemento(btnConfirmar, "Não foi possível clicar em CONFIRMAR");
        aguardarContainerCarregamentoPaginaDesaparecer();
        salvarEvidencia("Clicar em CONFIRMAR");
        return this;
    }
}
