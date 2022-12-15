package pagina.mobile.jornadas.investimentos.resgate;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ResgatePoupancaTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_qnt")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement campoValor;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar']")
    private MobileElement botaoResgatar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_withdraw_value_available")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'R$')]")
    private MobileElement labelSaldoPoupanca;

    public ResgatePoupancaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Preencher campo 'Valor'
     *
     * @param valorResgate Valor a ser resgatado
     * @return ResgatePoupancaTela
     * @throws Exception
     */
    @Step("Preencher campo 'Valor'")
    public ResgatePoupancaTela preencherValorResgate(String valorResgate) throws Exception {
        aguardarElementoHabilitado(campoValor);
        escreverTexto(campoValor, valorResgate, "Não foi possível preencher o campo 'Valor'");
        salvarEvidencia("Preenchido o campo 'Valor' com R$ " + valorResgate);
        return this;
    }

    /**
     * Tocar no botão 'Resgatar'
     *
     * @return ResgatePoupancaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Resgatar'")
    public ResgatePoupancaTela tocarBotaoResgatar() throws Exception {
        salvarEvidencia("Tocar no botão 'Resgatar'");
        if (android) {
            tocarElemento(botaoResgatar, "Não foi possível tocar no botão 'Resgatar'");
        } else {
            esconderTeclado();
        }
        return this;
    }

    /**
     * Recuperar o 'Saldo disponível na poupança'
     *
     * @param saldoPoupanca Parêmtro que receberá o saldo disponível para resgate
     * @return ResgatePoupancaTela
     * @throws Exception
     */
    @Step("Recupera o 'Saldo disponível na poupança'")
    public ResgatePoupancaTela recuperarSaldoDisponivelPoupanca(ThreadLocal<String> saldoPoupanca) throws Exception {
        String valorTotalResgate = retornarTexto(labelSaldoPoupanca,"Não foi possível recuperar o valor disponível para resgate");
        saldoPoupanca.set(valorTotalResgate.substring(valorTotalResgate.indexOf("R$")));
        return this;
    }
}
