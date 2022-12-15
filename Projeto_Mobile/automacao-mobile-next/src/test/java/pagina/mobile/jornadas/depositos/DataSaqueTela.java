package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import pagina.mobile.comum.next.CalendarioTela;

public class DataSaqueTela extends PaginaBase {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[not(contains(@name, \"Info\") or contains(@name, \"Fechar\") or contains(@name, \"Continuar\"))]")
    private MobileElement botaoData;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botoaContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[not(contains(@name, \"Fechar\") or contains(@name, \"Confirmar\"))]")
    private MobileElement botaoDataEdicao;

    public DataSaqueTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar em 'Data'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Data\"")
    public DataSaqueTela tocarBotaoData() throws Exception {
        if (verificarPresencaElemento(botaoData)) {
            salvarEvidencia("Clicar em 'Data'");
            tocarElemento(botaoData, "Não foi possível clicar  em Data");
        }
        return this;
    }

    /**
     * Clicar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Continuar\"")
    public DataSaqueTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botoaContinuar);
        salvarEvidencia("Clicar botão 'Continuar'");
        tocarElemento(botoaContinuar, "Não foi possível clicar botão 'Continuar'");
        return this;
    }

    /**
     * Clicar em 'Data' depois de fluxo de Edição na tela de Confirmação
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Data\"")
    public DataSaqueTela tocarBotaoDataEdicao() throws Exception {
        aguardarExistenciaElemento(botaoDataEdicao);
        salvarEvidencia("Clicar em 'Data'");
        tocarElemento(botaoDataEdicao, "Não foi possível clicar  em Data");
        if (!new CalendarioTela((AppiumDriver) driver).verificarPresencaDoCalendario()) {
            tocarElemento(botaoDataEdicao, "Não foi possível clicar  em Data");
            if (!new CalendarioTela((AppiumDriver) driver).verificarPresencaDoCalendario()) {
                throw new AssertionError("Não foi possível abrir o calendário");
            }
        }
        return this;
    }

    /**
     * Clicar em Continuar Tela Agendamento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Continuar\"")
    public DataSaqueTela tocarBotaoContinuarAgendamento() throws Exception {
        salvarEvidencia("Clicar em 'continuar'");
        if (!verificarPresencaElemento(botoaContinuar)) {
            tocarElemento(botaoConfirmar, "Erro ao tocar no botão Confirmar");
        } else {
            tocarElemento(botoaContinuar, "Não foi possível clicar  em Continuar");
        }
        return this;
    }
}
