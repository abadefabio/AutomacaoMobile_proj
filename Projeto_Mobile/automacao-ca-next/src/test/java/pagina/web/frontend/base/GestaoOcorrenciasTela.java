package pagina.web.frontend.base;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GestaoOcorrenciasTela extends PaginaBaseWeb {

    @FindBy(xpath = "//section[@class='brq-loader-container']")
    private WebElement containerCarregamentoPagina;

    public GestaoOcorrenciasTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Método para aguardar container de carregamento de página desaparecer
     *
     * @return CarregamentoPaginaContainer
     */
    @Step("Aguardar container de carregamento de página desaparecer")
    public GestaoOcorrenciasTela aguardarContainerCarregamentoPaginaDesaparecer() {
        validarCondicaoBooleana(aguardarOcultacaoElemento(containerCarregamentoPagina), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível verificar se o container de carregamento de página desapareceu.");
        return this;
    }
}
