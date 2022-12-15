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
    //Botao acessar ações extras
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Mais opções")
    @iOSXCUITFindBy(accessibility = "Mais opções")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(accessibility = "Mais Opções")
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
                "Não foi possível validar a tela principal 'Pix'."
        );
        salvarEvidencia("Validada a tela inicial do 'Pix'");
        return this;
    }

    /**
     * Tocar botão 'Mais Opções' (Engrenagem)
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Mais Opções'")
    public PixTela tocarBotaoMaisOpcoes() throws Exception {
        aguardarCarregamentoElemento(botaoMaisOpcoes);
        salvarEvidencia("Tocar no botão 'Mais Opções'");
        tocarElemento(botaoMaisOpcoes, "Não foi possível Tocar no botão 'Mais Opções'");
        return this;
    }

    /**
     * Tocar no botão 'Transferir'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'Transferir'")
    public PixTela tocarBotaoTransferir() throws Exception {
        aguardarCarregamentoElemento(botaoTransferir);
        salvarEvidencia("Tocar botão 'Transferir'");
        tocarElemento(botaoTransferir, "Não foi possível tocar no botão 'Transferir'");
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
        tocarElemento(abaReceber, "Não foi possível tocar na aba 'Receber'");
        return this;
    }

    /**
     * Tocar no botão 'Minhas Chaves'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Minhas Chaves'")
    public PixTela tocarBotaoMinhasChaves() throws NextException {
        aguardarCarregamentoElemento(botaoMinhasChaves);
        salvarEvidencia("Tocar no botão 'Minhas Chaves'");
        tocarElemento(botaoMinhasChaves, "Não foi possível tocar no botão 'Minhas Chaves'");
        return this;
    }

    /**
     * Tocar no botão 'Pix Copia e Cola'
     *
     * @return PixTela
     */
    @Step("Tocar no botão 'Pix Copia e Cola'")
    public PixTela tocarBotaoPixCopiaCola() throws NextException {
        aguardarCarregamentoElemento(botaoPixCopiaCola);
        salvarEvidencia("Tocar no botão 'Pix Copia e Cola'");
        tocarElemento(botaoPixCopiaCola, "Não foi possível tocar no botão 'Pix Copia e Cola'");
        return this;
    }

    /**
     * Tocar no botão 'Contato Pix'
     *
     * @return PixTela
     */
    @Step("Tocar no botão 'Contato Pix'")
    public PixTela tocarBotaoContatoPix() throws NextException {
        aguardarCarregamentoElemento(botaoContatoPix);
        salvarEvidencia("Tocar no botão 'Contato Pix'");
        tocarElemento(botaoContatoPix, "Não foi possível acionar no botão 'Contato Pix'");
        return this;
    }

    /**
     * Tocar no botão 'Mostrar Saldo'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Mostrar Saldo'")
    public PixTela tocarBotaoMostrarSaldo() throws NextException {
        aguardarCarregamentoElemento(botaoMostrarSaldo);
        tocarElemento(botaoMostrarSaldo, "Não foi possível tocar no botão 'Mostrar Saldo'");
        salvarEvidencia("Tocado botão 'Mostrar Saldo'");
        return this;
    }

    /**
     * Tocar no botão 'Extratos e Comprovantes'
     *
     * @return PixTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Extratos e Comprovantes'")
    public PixTela tocarBotaoExtratosEComprovantes() throws NextException {
        aguardarCarregamentoElemento(botaoExtratosEComprovantes);
        salvarEvidencia("Tocar botão 'Extratos e Comprovantes'");
        tocarElemento(botaoExtratosEComprovantes, "Não foi possível tocar no botão 'Extratos e Comprovantes'");
        return this;
    }
}
