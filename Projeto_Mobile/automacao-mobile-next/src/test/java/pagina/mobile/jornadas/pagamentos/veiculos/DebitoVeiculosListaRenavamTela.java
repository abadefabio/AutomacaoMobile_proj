package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DebitoVeiculosListaRenavamTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_search_list")
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"buscar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Buscar\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Buscar\"")
    private MobileElement campoBusca;

    public DebitoVeiculosListaRenavamTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Preencher campo busca com valor renavam
     *
     * @param renavam
     * @return
     * @throws NextException
     */
    @Step("Preencher campo busca com valor renavam")
    public DebitoVeiculosListaRenavamTela preencherCampoPesquisa(String renavam) throws NextException {
        escreverTexto(campoBusca, renavam, "Erro ao preencher campo de busca");
        salvarEvidencia("Preencher campo busca com valor: "+ renavam);
        return this;
    }

    /**
     * Método Utilizado para tocar elemento referente ao renavam desejado na tela
     * @param renavam
     * @return
     * @throws Exception
     */
    @Step("Tocar campo com o renavam desejado")
    public DebitoVeiculosListaRenavamTela tocarCampoRenavam(String renavam) throws Exception {
        By localizador = ios ? new By.ByXPath("//*[@name = " + renavam + "]"): new By.ByXPath("//*[@text = " + renavam + "]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "O renavam " + renavam + "não foi encontrado em tela");
        salvarEvidencia("Selecionar o renavam " + renavam);
        tocarElemento(localizador, "Ocorreu um erro ao executar a ação de selecionar o renavam");
        return this;
    }
}
