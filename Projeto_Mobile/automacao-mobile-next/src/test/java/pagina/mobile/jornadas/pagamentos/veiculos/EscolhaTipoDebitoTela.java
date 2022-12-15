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
    @AndroidFindBy(accessibility = "ESCOLHA O TIPO DE D�BITO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"ESCOLHA O TIPO DE D�BITO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"ESCOLHA O TIPO DE D�BITO\"`]")
    private MobileElement telaTipoDebito;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"D�bitos via Renavam\"]")
    @iOSXCUITFindBy(accessibility = "D�bitos via Renavam")
    private MobileElement debitosViaRenavam;

    public EscolhaTipoDebitoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o Confirmar
     * @return EscolhaTipoDebitoTela
     */
    @Step("Tocar bot�o Confirmar")
    public EscolhaTipoDebitoTela tocarBotaoApply() throws NextException {
        salvarEvidencia("Tocar bot�o v");
        tocarElemento(botaoApply, "Ocorreu um erro inesperado ao tentar tocar bot�o de confirma��o");
        return this;
    }

    /**
     * M�todo Utilizado para tocar elemento referente ao tipo de d�bito desejado na tela
     * @param tipoDebito
     * @return EscolhaTipoDebitoTela
     * @throws Exception
     */
    @Step("Tocar campo com o tipo de d�bito desejado")
    public EscolhaTipoDebitoTela tocarCampoTipoDebito(String tipoDebito) throws Exception {
        String tradutorLetrasXpath = "translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz')";
        By localizador = ios ? new By.ByXPath("//*[contains("+ tradutorLetrasXpath + ", \"" + tipoDebito.toLowerCase() +"\")]") : new By.ByXPath("//*[contains(lower-case(@text), \""+ tipoDebito.toLowerCase() +"\")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "O tipo de d�bito: " + tipoDebito + "n�o foi encontrado em tela");
        salvarEvidencia("Selecionar o tipo de d�bito: " + tipoDebito);
        tocarElemento(localizador, "Ocorreu um erro ao executar a a��o de selecionar o tipo de d�bito");

        return this;
    }

    /**
     * Validar tela "Tipo de D�bito"
     *
     * @return EscolhaTipoDebitoTela
     * @throws Exception
     */
    @Step("Validar tela \"Tipo de D�bito\"")
    public EscolhaTipoDebitoTela validarTelaTipoDebito() throws Exception {
        aguardarCarregamentoElemento(telaTipoDebito);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TIPO_DE_DEBITO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Escolha Tipo de D�bito' n�o est� presente na tela!");
        salvarEvidencia("Validar tela \"Tipo de D�bito\"");
        return this;
    }
}
