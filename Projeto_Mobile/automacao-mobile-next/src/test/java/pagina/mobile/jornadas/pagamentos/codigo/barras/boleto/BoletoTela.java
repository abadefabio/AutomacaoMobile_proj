package pagina.mobile.jornadas.pagamentos.codigo.barras.boleto;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.pagamentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class BoletoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_yep")
    @AndroidFindBy(xpath = "//*[contains(@text, \"Sim\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Op��o selecion�vel, Sim, \"")
    @iOSXCUITFindBy(accessibility = "Op��o selecion�vel, Sim, ")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Op��o selecion�vel, Sim, \"`]")
    private MobileElement botaoRadioSim;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text, \"Confirmar\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Confirmar\"`][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Confirmar\"])[1]")
    private MobileElement botaoConfirmar;

    public BoletoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Boleto'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Boleto'")
    public BoletoTela validarPresencaBoletoTela() throws Exception {
        esperarCarregando();
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.BOLETO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Boleto' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'Boleto'");
        return this;
    }

    /**
     * Selecionar bot�o radio 'Sim'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar bot�o radio 'Sim'")
    public BoletoTela selecionarSim() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRadioSim,"N�o foi poss�vel Selecionar bot�o radio 'Sim'");
        aguardarCarregamentoElemento(botaoRadioSim);
        tocarElemento(botaoRadioSim, "N�o foi poss�vel Selecionar bot�o radio 'Sim'");
        salvarEvidencia("Selecionado bot�o radio 'Sim'");
        return this;
    }

    /**
     * Tocar bot�o 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Confirmar'")
    public BoletoTela tocarbotaoConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar,"N�o foi poss�vel encontrar o bot�o 'Confirmar'");
        salvarEvidencia("Tocar bot�o 'Confirmar'");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel tocar no bot�o 'Confirmar'");
        return this;
    }
}
