package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.pagamentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EscolhaTipoDebitoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_next_option")
    @AndroidFindBy(accessibility = "confirmar")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"confirmar\"]")
    private MobileElement botaoApply;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_next_title")
    @AndroidFindBy(accessibility = "ESCOLHA O TIPO DE DÉBITO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"ESCOLHA O TIPO DE DÉBITO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"ESCOLHA O TIPO DE DÉBITO\"`]")
    private MobileElement telaTipoDebito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Débitos via Renavam\"]")
    @iOSXCUITFindBy(accessibility = "Débitos via Renavam")
    private MobileElement debitosViaRenavam;

    public EscolhaTipoDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão Confirmar
     * @return EscolhaTipoDebitoTela
     */
    @Step("Tocar botão Confirmar")
    public EscolhaTipoDebitoTela tocarBotaoApply() throws NextException {
        salvarEvidencia("Tocar botão v");
        tocarElemento(botaoApply, "Ocorreu um erro inesperado ao tentar tocar botão de confirmação");
        return this;
    }

    /**
     * Método Utilizado para tocar elemento referente ao tipo de débito desejado na tela
     * @param tipoDebito
     * @return EscolhaTipoDebitoTela
     * @throws Exception
     */
    @Step("Tocar campo com o tipo de débito desejado")
    public EscolhaTipoDebitoTela tocarCampoTipoDebito(String tipoDebito) throws Exception {
        String tradutorLetrasXpath = "translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz')";
        By localizador = ios ? new By.ByXPath("//*[contains("+ tradutorLetrasXpath + ", \"" + tipoDebito.toLowerCase() +"\")]") : new By.ByXPath("//*[contains(lower-case(@text), \""+ tipoDebito.toLowerCase() +"\")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "O tipo de débito: " + tipoDebito + "não foi encontrado em tela");
        salvarEvidencia("Selecionar o tipo de débito: " + tipoDebito);
        tocarElemento(localizador, "Ocorreu um erro ao executar a ação de selecionar o tipo de débito");

        return this;
    }

    /**
     * Validar tela "Tipo de Débito"
     *
     * @return EscolhaTipoDebitoTela
     * @throws Exception
     */
    @Step("Validar tela \"Tipo de Débito\"")
    public EscolhaTipoDebitoTela validarTelaTipoDebito() throws Exception {
        aguardarCarregamentoElemento(telaTipoDebito);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TIPO_DE_DEBITO), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Escolha Tipo de Débito' não está presente na tela!");
        salvarEvidencia("Validar tela \"Tipo de Débito\"");
        return this;
    }
}
