package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DependentesTela extends PaginaBase {

    private By dependente;

    public DependentesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no dependente selecionado
     *
     * @param nome
     * @return DependentesTela
     * @throws Exception
     */
    @Step("Tocar no dependente selecionado")
    public DependentesTela selecionarDependente(String nome) throws Exception {
        dependente = MobileBy.iOSNsPredicateString("label CONTAINS '" + nome + "'");
        aguardarCarregamentoElemento(dependente);
        salvarEvidencia("Tocar no dependente selecionado");
        tocarElemento(dependente, "Não foi possível tocar no dependente selecionado");
        return this;
    }
}
