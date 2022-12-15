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
     * Tocar no botão 'Continuar'
     *
     * @return AplicacaoNovoInvestimentoPoupancaTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Continuar'")
    public AplicacaoPoupancaTela tocarBotaoContinuar() throws NextException {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Preencher 'Valor' da aplicação
     *
     * @param valor Valor a sser aplicado
     * @return AplicacaoNovoInvestimentoPoupancaTela
     * @throws NextException
     */
    @Step("Preencher 'Valor' da aplicação")
    public AplicacaoPoupancaTela preencherValorAplicacao(String valor) throws NextException {
        aguardarElementoHabilitado(valor);
        escreverTexto(campoValor, valor, "Não foi possível escrever no campo o valor " + valor);
        salvarEvidencia("Preenchido no campo o valor: " + valor);
        return this;
    }

    /**
     * Tocar no botão 'Aplicar'
     *
     * @return AplicacaoNovoInvestimentoPoupancaTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Aplicar'")
    public AplicacaoPoupancaTela tocarBotaoAplicar() throws NextException {
        aguardarCarregamentoElemento(botaoAplicar);
        salvarEvidencia("Tocar no botão 'Aplicar'");
        tocarElemento(botaoAplicar, "Não foi possível tocar no botão 'Aplicar'");
        return this;
    }
}
