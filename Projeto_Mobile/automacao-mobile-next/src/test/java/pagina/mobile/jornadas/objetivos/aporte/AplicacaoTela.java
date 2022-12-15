package pagina.mobile.jornadas.objetivos.aporte;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;

import constantes.investimentos.Mensagem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class AplicacaoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_amount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Valor da aplica��o\"]/following-sibling::XCUIElementTypeTextField")
    private MobileElement campoValor;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_error_msg")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"resgate m�nimo\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"aplica��o m�nima\")]")
    private MobileElement alertaValorMinimo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Data da aplica��o\"]/../XCUIElementTypeButton")
    private MobileElement dataAplicacao;

    public AplicacaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Informar o valor da aplica��o
     * @return
     * @throws NextException
     */
    @Step("Informar o valor da aplica��o")
    public AplicacaoTela informarValorAplicacao(String valor) throws NextException {
        escreverTexto(campoValor, valor, "N�o foi poss�vel informar o valor, " + valor + " no campo valor da aplica��o");
        salvarEvidencia("Informado o valor de aplica��o: " + valor);
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar'
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Continuar'")
    public AplicacaoTela tocarBotaoContinuar() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Tocar bot�o Data Aplica��o
     *
     * @return AplicacaoTela
     * @throws Exception
     */
    @Step("Tocar bot�o Data Aplica��o")
    public AplicacaoTela tocarBotaoData() throws Exception {
        salvarEvidencia("Tocar bot�o Data Aplica��o");
        tocarElemento(dataAplicacao, "N�o foi poss�vel tocar o bot�o Data Aplica��o");
        return this;
    }

    /**
     * Verificar presen�a alerta Aplica��o Minima
     *
     * @return AplicacaoTela
     * @throws Exception
     */
    @Step("Verificar presen�a alerta Aplica��o Minima")
    public AplicacaoTela verificaAplicacaoMinima() throws Exception {
        aguardarCarregamentoElemento(alertaValorMinimo);
        OperadorEvidencia.logarPasso("Iniciar valida��o do bot�o Continuar desabilitado devido ao alerta de valor minimo em tela.");
        if (android) {
            compararElementoTexto(alertaValorMinimo, Mensagem.ALERTA_VALOR_MINIM0_NEXT_CDB, MetodoComparacao.CONTEM);
            OperadorEvidencia.logarPasso("Valida��o com sucesso! Bot�o Continuar desabilitado e alerta de valor minimo apresentado na tela.");
        } else {
            verificarPresencaElemento(alertaValorMinimo);
            OperadorEvidencia.logarPasso("Valida��o com sucesso! Bot�o Continuar desabilitado e alerta de valor minimo apresentado na tela.");
        }
        salvarEvidencia("Verificar presen�a alerta Aplica��o Minima");
        return this;
    }
}
