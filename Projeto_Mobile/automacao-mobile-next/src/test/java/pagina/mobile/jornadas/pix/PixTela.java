package pagina.mobile.jornadas.pix;

import org.testng.util.Strings;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;

import constantes.pix.Pix;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PixTela extends PaginaBase {
    //Botao acessar a��es extras
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Mais op��es")
    @iOSXCUITFindBy(accessibility = "Mais op��es")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(accessibility = "Mais Op��es")
    private MobileElement botaoMaisOpcoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Transferir')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transferir']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton")
    @iOSXCUITFindBy(accessibility = "Transferir")
    @iOSXCUITFindBy(xpath = "//*[@name='Transferir']")
    private MobileElement botaoTransferir;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/text' and contains(@text, 'Receber')]")
    @AndroidFindBy(xpath = "//*[@text='RECEBER']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='RECEBER']")
    @iOSXCUITFindBy(xpath = "//*[@name='RECEBER']")
    private MobileElement abaReceber;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_action_name' and contains(@text, 'Minhas chaves')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Minhas chaves']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Minhas chaves']")
    private MobileElement botaoMinhasChaves;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Pix Copia')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Pix Copia')]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Pix Copia')]")
    private MobileElement botaoPixCopiaCola;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_show_balance")
    @iOSXCUITFindBy(accessibility = "Mostrar saldo")
    @iOSXCUITFindBy(xpath = "//*[@name='Mostrar saldo']")
    private MobileElement botaoMostrarSaldo;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/nl_extracts_vaunchers']")
    @iOSXCUITFindBy(accessibility = "EXTRATOS E COMPROVANTES")
    private MobileElement botaoExtratosEComprovantes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Contato Pix')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Contato Pix']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Contato Pix')]")
    private MobileElement botaoContatoPix;

    public PixTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela inicial do Pix
     */
    @Step("Validar tela inicial 'Pix'")
    public PixTela validarTelaPix() {
        validarCondicaoBooleana(
                (Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto(Pix.TELA_PIX))),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar a tela principal 'Pix'."
        );
        salvarEvidencia("Validada a tela inicial do 'Pix'");
        return this;
    }

    /**
     * Tocar bot�o 'Mais Op��es' (Engrenagem)
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Mais Op��es'")
    public PixTela tocarBotaoMaisOpcoes() throws Exception {
        aguardarCarregamentoElemento(botaoMaisOpcoes);
        salvarEvidencia("Tocar no bot�o 'Mais Op��es'");
        tocarElemento(botaoMaisOpcoes, "N�o foi poss�vel Tocar no bot�o 'Mais Op��es'");
        return this;
    }

    /**
     * Tocar no bot�o 'Transferir'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Transferir'")
    public PixTela tocarBotaoTransferir() throws Exception {
        aguardarCarregamentoElemento(botaoTransferir);
        salvarEvidencia("Tocar bot�o 'Transferir'");
        tocarElemento(botaoTransferir, "N�o foi poss�vel tocar no bot�o 'Transferir'");
        return this;
    }

    /**
     * Tocar na aba 'Receber'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar na aba 'Receber'")
    public PixTela tocarAbaReceber() throws NextException {
        aguardarCarregamentoElemento(abaReceber);
        salvarEvidencia("Tocar na aba 'Receber'");
        tocarElemento(abaReceber, "N�o foi poss�vel tocar na aba 'Receber'");
        return this;
    }

    /**
     * Tocar no bot�o 'Minhas Chaves'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Minhas Chaves'")
    public PixTela tocarBotaoMinhasChaves() throws NextException {
        aguardarCarregamentoElemento(botaoMinhasChaves);
        salvarEvidencia("Tocar no bot�o 'Minhas Chaves'");
        tocarElemento(botaoMinhasChaves, "N�o foi poss�vel tocar no bot�o 'Minhas Chaves'");
        return this;
    }

    /**
     * Tocar no bot�o 'Pix Copia e Cola'
     *
     * @return PixTela
     */
    @Step("Tocar no bot�o 'Pix Copia e Cola'")
    public PixTela tocarBotaoPixCopiaCola() throws NextException {
        aguardarCarregamentoElemento(botaoPixCopiaCola);
        salvarEvidencia("Tocar no bot�o 'Pix Copia e Cola'");
        tocarElemento(botaoPixCopiaCola, "N�o foi poss�vel tocar no bot�o 'Pix Copia e Cola'");
        return this;
    }

    /**
     * Tocar no bot�o 'Contato Pix'
     *
     * @return PixTela
     */
    @Step("Tocar no bot�o 'Contato Pix'")
    public PixTela tocarBotaoContatoPix() throws NextException {
        aguardarCarregamentoElemento(botaoContatoPix);
        salvarEvidencia("Tocar no bot�o 'Contato Pix'");
        tocarElemento(botaoContatoPix, "N�o foi poss�vel acionar no bot�o 'Contato Pix'");
        return this;
    }

    /**
     * Tocar no bot�o 'Mostrar Saldo'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Mostrar Saldo'")
    public PixTela tocarBotaoMostrarSaldo() throws NextException {
        aguardarCarregamentoElemento(botaoMostrarSaldo);
        tocarElemento(botaoMostrarSaldo, "N�o foi poss�vel tocar no bot�o 'Mostrar Saldo'");
        salvarEvidencia("Tocado bot�o 'Mostrar Saldo'");
        return this;
    }

    /**
     * Tocar no bot�o 'Extratos e Comprovantes'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Extratos e Comprovantes'")
    public PixTela tocarBotaoExtratosEComprovantes() throws NextException {
        aguardarCarregamentoElemento(botaoExtratosEComprovantes);
        salvarEvidencia("Tocar bot�o 'Extratos e Comprovantes'");
        tocarElemento(botaoExtratosEComprovantes, "N�o foi poss�vel tocar no bot�o 'Extratos e Comprovantes'");
        return this;
    }
}
