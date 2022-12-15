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
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Opção selecionável, Sim, \"")
    @iOSXCUITFindBy(accessibility = "Opção selecionável, Sim, ")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Opção selecionável, Sim, \"`]")
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
     * Validar presença da tela 'Boleto'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Boleto'")
    public BoletoTela validarPresencaBoletoTela() throws Exception {
        esperarCarregando();
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.BOLETO), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Boleto' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'Boleto'");
        return this;
    }

    /**
     * Selecionar botão radio 'Sim'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar botão radio 'Sim'")
    public BoletoTela selecionarSim() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRadioSim,"Não foi possível Selecionar botão radio 'Sim'");
        aguardarCarregamentoElemento(botaoRadioSim);
        tocarElemento(botaoRadioSim, "Não foi possível Selecionar botão radio 'Sim'");
        salvarEvidencia("Selecionado botão radio 'Sim'");
        return this;
    }

    /**
     * Tocar botão 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Confirmar'")
    public BoletoTela tocarbotaoConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar,"Não foi possível encontrar o botão 'Confirmar'");
        salvarEvidencia("Tocar botão 'Confirmar'");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        return this;
    }
}
