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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Valor da aplicação\"]/following-sibling::XCUIElementTypeTextField")
    private MobileElement campoValor;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_value")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_error_msg")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"resgate mínimo\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"aplicação mínima\")]")
    private MobileElement alertaValorMinimo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Data da aplicação\"]/../XCUIElementTypeButton")
    private MobileElement dataAplicacao;

    public AplicacaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Informar o valor da aplicação
     * @return
     * @throws NextException
     */
    @Step("Informar o valor da aplicação")
    public AplicacaoTela informarValorAplicacao(String valor) throws NextException {
        escreverTexto(campoValor, valor, "Não foi possível informar o valor, " + valor + " no campo valor da aplicação");
        salvarEvidencia("Informado o valor de aplicação: " + valor);
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Continuar'")
    public AplicacaoTela tocarBotaoContinuar() throws NextException {
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Tocar botão Data Aplicação
     *
     * @return AplicacaoTela
     * @throws Exception
     */
    @Step("Tocar botão Data Aplicação")
    public AplicacaoTela tocarBotaoData() throws Exception {
        salvarEvidencia("Tocar botão Data Aplicação");
        tocarElemento(dataAplicacao, "Não foi possível tocar o botão Data Aplicação");
        return this;
    }

    /**
     * Verificar presença alerta Aplicação Minima
     *
     * @return AplicacaoTela
     * @throws Exception
     */
    @Step("Verificar presença alerta Aplicação Minima")
    public AplicacaoTela verificaAplicacaoMinima() throws Exception {
        aguardarCarregamentoElemento(alertaValorMinimo);
        OperadorEvidencia.logarPasso("Iniciar validação do botão Continuar desabilitado devido ao alerta de valor minimo em tela.");
        if (android) {
            compararElementoTexto(alertaValorMinimo, Mensagem.ALERTA_VALOR_MINIM0_NEXT_CDB, MetodoComparacao.CONTEM);
            OperadorEvidencia.logarPasso("Validação com sucesso! Botão Continuar desabilitado e alerta de valor minimo apresentado na tela.");
        } else {
            verificarPresencaElemento(alertaValorMinimo);
            OperadorEvidencia.logarPasso("Validação com sucesso! Botão Continuar desabilitado e alerta de valor minimo apresentado na tela.");
        }
        salvarEvidencia("Verificar presença alerta Aplicação Minima");
        return this;
    }
}
