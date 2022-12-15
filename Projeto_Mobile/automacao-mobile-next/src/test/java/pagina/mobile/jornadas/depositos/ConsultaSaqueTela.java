package pagina.mobile.jornadas.depositos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.mobile.PaginaBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConsultaSaqueTela extends PaginaBase {

    private static ThreadLocal<String> dataAgendamento = new ThreadLocal<>();
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and name = \"Saque agendado\"")
    @iOSXCUITFindBy(accessibility = "Saque agendado")
    private MobileElement primeiroSaqueListado;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_delete")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"icon delete medium\"])[2]")
    private MobileElement botaoLixeira;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_start_dt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Data inicial\"]/following-sibling::XCUIElementTypeButton[1]")
    private MobileElement botaoDataInicial;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_end_dt")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Data final\"]/following-sibling::XCUIElementTypeButton[1]")
    private MobileElement botaoDataFinal;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='CONTINUAR'])[2]")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_delete")
    @iOSXCUITFindBy(accessibility = "Excluir")
    private MobileElement botaoExcluir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_receipt")
    @iOSXCUITFindBy(accessibility = "Comprovante")
    private MobileElement botaoComprovante;

    public ConsultaSaqueTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retorna driver do tipo IOSDriver
     *
     * @return IOSDriver
     */
    private IOSDriver<MobileElement> getIOSDriver() {
        if (ios) {
            return (IOSDriver<MobileElement>) getDriver();
        } else {
            throw new UnsupportedOperationException("O driver n�o � do tipo IOSDriver");
        }
    }

    /**
     * Clicar bot�o 'Data Inicial'
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Data Inicial\"")
    public ConsultaSaqueTela tocarBotaoDataInicial() throws Exception {
        aguardarCarregamentoElemento(botaoDataInicial);
        salvarEvidencia("Clicar bot�o 'Data Inicial'");
        tocarElemento(botaoDataInicial, "N�o foi poss�vel clicar bot�o 'Data Inicial'");
        return this;
    }

    /**
     * Clicar bot�o 'Data Final'
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Data Final\"")
    public ConsultaSaqueTela tocarBotaoDataFinal() throws Exception {
        aguardarCarregamentoElemento(botaoDataFinal);
        salvarEvidencia("Clicar bot�o 'Data Final'");
        tocarElemento(botaoDataFinal, "N�o foi poss�vel clicar bot�o 'Data Final'");
        return this;
    }

    /**
     * Clicar bot�o 'Continuar'
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Clicar bot�o \"Continuar\"")
    public ConsultaSaqueTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Clicar bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel clicar bot�o 'Continuar'");
        return this;
    }

    /**
     * Tocar no primeiro agendamento da lista
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Tocar no primeiro agendamento da lista")
    public ConsultaSaqueTela selecionarPrimeiroSaqueListado() throws Exception {
        aguardarCarregamentoElemento(primeiroSaqueListado);
        salvarEvidencia("Tocar primeiro agendamento da lista");
        tocarElemento(primeiroSaqueListado, "Erro ao selecionar primeiro agendamento da lista");
       return this;
    }

    /**
     * Tocar bot�o excluir
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Tocar bot�o excluir")
    public ConsultaSaqueTela tocarBotaoExcluir() throws Exception {
        aguardarCarregamentoElemento(botaoExcluir);
        salvarEvidencia("Tocar bot�o excluir");
        tocarElemento(botaoExcluir, "Erro ao tocar no botao excluir");
        return this;
    }

    /**
     * Tocar bot�o comprovante
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Tocar bot�o comprovante")
    public ConsultaSaqueTela tocarBotaoComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoComprovante);
        salvarEvidencia("Tocar bot�o comprovante");
        tocarElemento(botaoComprovante, "N�o foi poss�vel tocar no botao comprovante");
        return this;
    }

    /**
     * Validar exclus�o agendamento
     *
     * @param exclusao : true - valida exclus�o agendamento, false - valida n�o exclus�o agendamento
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    public ConsultaSaqueTela validarExclusaoAgendamento(boolean exclusao) throws Exception {
        if (exclusao) {
            if (verificarPresencaElemento(primeiroSaqueListado)) {
                tocarElemento(primeiroSaqueListado, "Erro ao tocar no primeiro elemento listado");
                if (verificarPresencaElemento(getDriver().findElementByAccessibilityId(dataAgendamento.get()))) {
                    throw new AssertionError("O agendamento n�o foi exclu�do");
                }
            }
            salvarEvidencia("Validar exclus�o saque agendado no dia " + dataAgendamento.get());
        } else {
            if (verificarPresencaElemento(getDriver().findElementByAccessibilityId(dataAgendamento.get()))) {
                salvarEvidencia("Validar saque agendado no dia " + dataAgendamento.get() + " n�o foi exclu�do");
                tocarElemento(primeiroSaqueListado, "Erro ao tocar no primeiro elemento listado");
            } else {
                throw new AssertionError("O agendamento n�o foi encontrado");
            }
        }
        return this;
    }
}
