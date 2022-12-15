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

public class AtencaoTela extends PaginaBase {

    public AtencaoTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'OK, ENTENDI')]")
    @iOSXCUITFindBy(accessibility = "OK, ENTENDI")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK, ENTENDI\"]")
    private MobileElement botaoOkEntendi;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Dados necessários')]")
    @iOSXCUITFindBy(accessibility = "Dados necessários")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Dados necessários\"]")
    private MobileElement textoDadosNecessarios;

    /**
     * Tocar "botao Ok Entendi"
     * fr
     *
     * @throws Exception
     */
    @Step("Tocar \"Ok Entendi\"")
    public AtencaoTela tocarBotaoOkEntendi() throws Exception {
        salvarEvidencia("Tocar \"botao Ok Entendi\"");
        tocarElemento(botaoOkEntendi, "Não foi possivel tocar \"botao Ok Entendi\"");
        return this;
    }

    /**
     * validar " Dados Necessarios"
     * fr
     *
     * @throws Exception
     */
    @Step("validar \"Dados Necessarios\"")
    public AtencaoTela validarTelaAtencao() throws Exception {
        salvarEvidencia("Atenção \"Dados Necessarios\"");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.MSG_DADOS_NESCESSARIOS), MetodoComparacaoBooleano.VERDADEIRO, "Erro, não foi possivel validar texto da tela dados Necessarios!");
        return this;
    }



}
