package pagina.web.frontend.menu;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutGestaoOcorrenciasTela extends PaginaBaseWeb {


    public LogoutGestaoOcorrenciasTela(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//a['_ngcontent-hyd-c5' and @class='brq-cursor brq-logoff']")
    private WebElement btnLogout;

    /**
     * Realiza o logout no Gestao de Ocorrencias
     *
     * @throws Exception
     */
    @Step("Clicar em Sair para deslogar do Gestao de Ocorrencias")
    public LogoutGestaoOcorrenciasTela logoutGestaoOcorrencias() throws Exception {
        clicarElemento(btnLogout, "Não foi possível realizar o logout");
        salvarEvidencia("Logout Gestao de Ocorrencias");
        return this;
    }
}
