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
            throw new UnsupportedOperationException("O driver não é do tipo IOSDriver");
        }
    }

    /**
     * Clicar botão 'Data Inicial'
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Clicar botão \"Data Inicial\"")
    public ConsultaSaqueTela tocarBotaoDataInicial() throws Exception {
        aguardarCarregamentoElemento(botaoDataInicial);
        salvarEvidencia("Clicar botão 'Data Inicial'");
        tocarElemento(botaoDataInicial, "Não foi possível clicar botão 'Data Inicial'");
        return this;
    }

    /**
     * Clicar botão 'Data Final'
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Clicar botão \"Data Final\"")
    public ConsultaSaqueTela tocarBotaoDataFinal() throws Exception {
        aguardarCarregamentoElemento(botaoDataFinal);
        salvarEvidencia("Clicar botão 'Data Final'");
        tocarElemento(botaoDataFinal, "Não foi possível clicar botão 'Data Final'");
        return this;
    }

    /**
     * Clicar botão 'Continuar'
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Clicar botão \"Continuar\"")
    public ConsultaSaqueTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Clicar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível clicar botão 'Continuar'");
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
     * Tocar botão excluir
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Tocar botão excluir")
    public ConsultaSaqueTela tocarBotaoExcluir() throws Exception {
        aguardarCarregamentoElemento(botaoExcluir);
        salvarEvidencia("Tocar botão excluir");
        tocarElemento(botaoExcluir, "Erro ao tocar no botao excluir");
        return this;
    }

    /**
     * Tocar botão comprovante
     *
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    @Step("Tocar botão comprovante")
    public ConsultaSaqueTela tocarBotaoComprovante() throws Exception {
        aguardarCarregamentoElemento(botaoComprovante);
        salvarEvidencia("Tocar botão comprovante");
        tocarElemento(botaoComprovante, "Não foi possível tocar no botao comprovante");
        return this;
    }

    /**
     * Validar exclusão agendamento
     *
     * @param exclusao : true - valida exclusão agendamento, false - valida não exclusão agendamento
     * @return ConsultaSaqueTela
     * @throws Exception
     */
    public ConsultaSaqueTela validarExclusaoAgendamento(boolean exclusao) throws Exception {
        if (exclusao) {
            if (verificarPresencaElemento(primeiroSaqueListado)) {
                tocarElemento(primeiroSaqueListado, "Erro ao tocar no primeiro elemento listado");
                if (verificarPresencaElemento(getDriver().findElementByAccessibilityId(dataAgendamento.get()))) {
                    throw new AssertionError("O agendamento não foi excluído");
                }
            }
            salvarEvidencia("Validar exclusão saque agendado no dia " + dataAgendamento.get());
        } else {
            if (verificarPresencaElemento(getDriver().findElementByAccessibilityId(dataAgendamento.get()))) {
                salvarEvidencia("Validar saque agendado no dia " + dataAgendamento.get() + " não foi excluído");
                tocarElemento(primeiroSaqueListado, "Erro ao tocar no primeiro elemento listado");
            } else {
                throw new AssertionError("O agendamento não foi encontrado");
            }
        }
        return this;
    }
}
