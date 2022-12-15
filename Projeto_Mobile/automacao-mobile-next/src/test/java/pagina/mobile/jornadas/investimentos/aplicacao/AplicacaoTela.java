package pagina.mobile.jornadas.investimentos.aplicacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AplicacaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='CONTINUAR']")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_amount")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Valor da aplica��o\"]/../XCUIElementTypeTextField")
    private MobileElement campoValorAplicacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Data da aplica��o\"]/../XCUIElementTypeButton")
    private MobileElement botaoDataAplicacao;

    public AplicacaoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Preencher o campo 'Valor'
     *
     * @param valor Valor a ser aplicado
     * @return AplicacaoInvestimentoTela
     * @throws NextException
     */
    @Step("Preencher o campo 'Valor'")
    public AplicacaoTela preencherCampoValor(String valor) throws NextException {
        aguardarElementoHabilitado(campoValorAplicacao);
        escreverTexto(campoValorAplicacao, valor, true, "N�o foi poss�vel preencher no campo o valor " + valor);
        salvarEvidencia("Preenchido o campo com o valor: " + valor);
        return this;
    }

    /**
     * Apaagr conte�do do campo 'Valor'
     *
     * @return AplicacaoTela
     * @throws Exception
     */
    @Step("Apagar conte�do do campo 'Valor'")
    public AplicacaoTela apagarCampoValor() throws Exception {
        aguardarElementoHabilitado(campoValorAplicacao);
        apagarCampoTexto(campoValorAplicacao, "N�o foi poss�vel apagar o conte�do do campo 'Valor'");
        salvarEvidencia("Apagado o conte�do do campo 'Valor'");
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar'
     *
     * @return AplicacaoInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Continuar'")
    public AplicacaoTela tocarBotaoContinuar() throws Exception {
        aguardarElementoHabilitado(botaoContinuar);
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Tocar no bot�o 'Data da aplica��o'
     *
     * @return AplicacaoInvestimentoTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Data da aplica��o'")
    public AplicacaoTela tocarBotaoDataDaAplicacao() throws NextException {
        aguardarCarregamentoElemento(botaoDataAplicacao);
        salvarEvidencia("Tocar no bot�o 'Data da aplica��o'");
        tocarElemento(botaoDataAplicacao, "N�o foi poss�vel encontrar o bot�o 'Data da aplica��o'");
        return this;
    }
}
