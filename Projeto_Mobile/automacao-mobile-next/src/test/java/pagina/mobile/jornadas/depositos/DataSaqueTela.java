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
    @Step("Clicar bot�o \"Data\"")
    public DataSaqueTela tocarBotaoData() throws Exception {
        if (verificarPresencaElemento(botaoData)) {
            salvarEvidencia("Clicar em 'Data'");
            tocarElemento(botaoData, "N�o foi poss�vel clicar  em Data");
        }
        return this;
    }

    /**
     * Clicar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Continuar\"")
    public DataSaqueTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botoaContinuar);
        salvarEvidencia("Clicar bot�o 'Continuar'");
        tocarElemento(botoaContinuar, "N�o foi poss�vel clicar bot�o 'Continuar'");
        return this;
    }

    /**
     * Clicar em 'Data' depois de fluxo de Edi��o na tela de Confirma��o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Data\"")
    public DataSaqueTela tocarBotaoDataEdicao() throws Exception {
        aguardarExistenciaElemento(botaoDataEdicao);
        salvarEvidencia("Clicar em 'Data'");
        tocarElemento(botaoDataEdicao, "N�o foi poss�vel clicar  em Data");
        if (!new CalendarioTela((AppiumDriver) driver).verificarPresencaDoCalendario()) {
            tocarElemento(botaoDataEdicao, "N�o foi poss�vel clicar  em Data");
            if (!new CalendarioTela((AppiumDriver) driver).verificarPresencaDoCalendario()) {
                throw new AssertionError("N�o foi poss�vel abrir o calend�rio");
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
    @Step("Clicar bot�o \"Continuar\"")
    public DataSaqueTela tocarBotaoContinuarAgendamento() throws Exception {
        salvarEvidencia("Clicar em 'continuar'");
        if (!verificarPresencaElemento(botoaContinuar)) {
            tocarElemento(botaoConfirmar, "Erro ao tocar no bot�o Confirmar");
        } else {
            tocarElemento(botoaContinuar, "N�o foi poss�vel clicar  em Continuar");
        }
        return this;
    }
}
