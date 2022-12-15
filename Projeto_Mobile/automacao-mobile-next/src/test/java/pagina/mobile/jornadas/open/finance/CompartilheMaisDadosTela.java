package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.open.finance.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CompartilheMaisDadosTela extends PaginaBase {

    public CompartilheMaisDadosTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text, \"SELECIONAR TODOS OS DADOS\")]")
    @iOSXCUITFindBy(accessibility = "SELECIONAR TODOS OS DADOS")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SELECIONAR TODOS OS DADOS\"]")
    private MobileElement botaoSelecionarTodosDados;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text, \"CONTINUAR MESMO ASSIM\")]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR MESMO ASSIM")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CONTINUAR MESMO ASSIM\"]")
    private MobileElement botaoContinuarMesmoAssim;


    /**
     * Tocar botao "Selecionar todos os dados"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Selecionar todos os dados\"")
    public CompartilheMaisDadosTela tocarBotaoSelecionarTodosOsDados() throws Exception {
        tocarElemento(botaoSelecionarTodosDados, "Não foi possivel tocar botao \"Selecionar todos os dados\"");
        salvarEvidencia("Tocar botao \"Selecionar todos os dados\"");
        return this;
    }

    /**
     * Tocar botao "Continuar Mesmo Assim"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Continuar Mesmo Assim\"")
    public CompartilheMaisDadosTela tocarBotaoContinuarMesmoAssim() throws Exception {
        tocarElemento(botaoSelecionarTodosDados, "Não foi possivel tocar botao \"Continuar Mesmo Assim\"");
        salvarEvidencia("Tocar botao \"Continuar Mesmo Assim\"");
        return this;
    }
    /**
     * validar "Melhore sua experiencia  no open Finance"
     * fr
     *
     * @throws Exception
     */
    @Step("validar \"Melhore sua experiencia  no open Finance\"")
    public CompartilheMaisDadosTela validarTextoMelhoreSuaExperiencia() throws Exception {
        salvarEvidencia("Melhore sua experiencia  no open Finance.");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.MSG_MELHORE_SUA_EXPERIENCIA), MetodoComparacaoBooleano.VERDADEIRO, "Erro, não foi possivel validar texto da tela dados Necessarios!");
        return this;
    }

}
