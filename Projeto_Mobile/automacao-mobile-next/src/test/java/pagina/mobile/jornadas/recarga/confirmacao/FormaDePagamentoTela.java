package pagina.mobile.jornadas.recarga.confirmacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.recarga.Recarga;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class FormaDePagamentoTela extends PaginaBase {

    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc, 'Conta-corrente')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name, 'Conta-corrente')]")
    private MobileElement botaoContaCorrente;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc, 'Conta-poupan�a')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name, 'Conta-poupan�a')]")
    private MobileElement botaoContaPoupanca;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save_new_number")
    @iOSXCUITFindBy(accessibility = "Salvar")
    private MobileElement botaoSalvar;

    public FormaDePagamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar bot�o 'Conta Corrente'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Conta Corrente\"")
    public FormaDePagamentoTela tocarBotaoContaCorrente() throws Exception {
        tocarElemento(botaoContaCorrente, "N�o foi poss�vel clicar no bot�o Conta Corrente");
        salvarEvidencia("Clicar no bot�o 'Conta Corrente'");
        return this;
    }

    /**
     * Clicar bot�o 'Conta Poupan�a'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Conta Poupan�a\"")
    public FormaDePagamentoTela tocarBotaoContaPoupanca() throws Exception {
        tocarElemento(botaoContaPoupanca, "N�o foi poss�vel clicar no bot�o Conta Poupan�a");
        salvarEvidencia("Clicar no bot�o 'Conta Poupan�a'");
        return this;
    }

    /**
     * Clicar bot�o 'Salvar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Salvar\"")
    public FormaDePagamentoTela tocarBotaoSalvar() throws Exception {
        aguardarCarregamentoElemento(botaoSalvar);
        salvarEvidencia("Clicar no bot�o 'Salvar'");
        compararElementoTexto(botaoSalvar, Recarga.SALVAR, MetodoComparacao.IGUAL);
        tocarElemento(botaoSalvar, "N�o foi poss�vel clicar no bot�o Salvar");
        return this;
    }
}
