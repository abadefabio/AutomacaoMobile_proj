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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Valor da aplicação\"]/../XCUIElementTypeTextField")
    private MobileElement campoValorAplicacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Data da aplicação\"]/../XCUIElementTypeButton")
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
        escreverTexto(campoValorAplicacao, valor, true, "Não foi possível preencher no campo o valor " + valor);
        salvarEvidencia("Preenchido o campo com o valor: " + valor);
        return this;
    }

    /**
     * Apaagr conteúdo do campo 'Valor'
     *
     * @return AplicacaoTela
     * @throws Exception
     */
    @Step("Apagar conteúdo do campo 'Valor'")
    public AplicacaoTela apagarCampoValor() throws Exception {
        aguardarElementoHabilitado(campoValorAplicacao);
        apagarCampoTexto(campoValorAplicacao, "Não foi possível apagar o conteúdo do campo 'Valor'");
        salvarEvidencia("Apagado o conteúdo do campo 'Valor'");
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     *
     * @return AplicacaoInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Continuar'")
    public AplicacaoTela tocarBotaoContinuar() throws Exception {
        aguardarElementoHabilitado(botaoContinuar);
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Tocar no botão 'Data da aplicação'
     *
     * @return AplicacaoInvestimentoTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Data da aplicação'")
    public AplicacaoTela tocarBotaoDataDaAplicacao() throws NextException {
        aguardarCarregamentoElemento(botaoDataAplicacao);
        salvarEvidencia("Tocar no botão 'Data da aplicação'");
        tocarElemento(botaoDataAplicacao, "Não foi possível encontrar o botão 'Data da aplicação'");
        return this;
    }
}
