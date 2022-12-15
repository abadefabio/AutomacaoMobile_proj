package pagina.web.contingencia.views.perfil;


import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MeusDadosTela extends PaginaBaseWeb {

    public MeusDadosTela(WebDriver driver) {
        super(driver);
    }

    private WebElement elementoCampo(String campo) throws Exception {
        By locatorLinha = By.xpath("//span[contains(text(),'" + campo +
                "')]/../span[2]");
        return retornarElemento(locatorLinha, "Não foi possível encontrar o valor a partir do campo "
                 + campo);
    }

    /**
     * Validar campos na tela Meus Dados
     * @throws Exception
     */
    @Step("Validar campo tela 'Meus Dados'")
    public MeusDadosTela validarCampo(String campo, String valor) throws Exception {
        WebElement valorCampo = elementoCampo(campo);
        aguardarCarregamentoElemento(valorCampo);
        compararElementoTexto(valorCampo, valor, MetodoComparacao.IGUAL);
        salvarEvidencia("Validação do campo " + campo + " realizada com sucesso.");
        return this;
    }

}
