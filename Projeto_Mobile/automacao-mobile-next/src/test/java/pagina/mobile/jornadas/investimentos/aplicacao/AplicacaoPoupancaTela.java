package pagina.mobile.jornadas.investimentos.aplicacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AplicacaoPoupancaTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_qnt")
    @iOSXCUITFindBy(accessibility = "et_value")
    private MobileElement campoValor;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//*[@name='Continuar']")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_apply")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Aplicar'])[2]")
    private MobileElement botaoAplicar;

    public AplicacaoPoupancaTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Continuar'
     *
     * @return AplicacaoNovoInvestimentoPoupancaTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Continuar'")
    public AplicacaoPoupancaTela tocarBotaoContinuar() throws NextException {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Preencher 'Valor' da aplica��o
     *
     * @param valor Valor a sser aplicado
     * @return AplicacaoNovoInvestimentoPoupancaTela
     * @throws NextException
     */
    @Step("Preencher 'Valor' da aplica��o")
    public AplicacaoPoupancaTela preencherValorAplicacao(String valor) throws NextException {
        aguardarElementoHabilitado(valor);
        escreverTexto(campoValor, valor, "N�o foi poss�vel escrever no campo o valor " + valor);
        salvarEvidencia("Preenchido no campo o valor: " + valor);
        return this;
    }

    /**
     * Tocar no bot�o 'Aplicar'
     *
     * @return AplicacaoNovoInvestimentoPoupancaTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Aplicar'")
    public AplicacaoPoupancaTela tocarBotaoAplicar() throws NextException {
        aguardarCarregamentoElemento(botaoAplicar);
        salvarEvidencia("Tocar no bot�o 'Aplicar'");
        tocarElemento(botaoAplicar, "N�o foi poss�vel tocar no bot�o 'Aplicar'");
        return this;
    }
}
