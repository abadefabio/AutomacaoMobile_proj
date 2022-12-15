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

    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc, 'Conta-poupança')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name, 'Conta-poupança')]")
    private MobileElement botaoContaPoupanca;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save_new_number")
    @iOSXCUITFindBy(accessibility = "Salvar")
    private MobileElement botaoSalvar;

    public FormaDePagamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar botão 'Conta Corrente'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Conta Corrente\"")
    public FormaDePagamentoTela tocarBotaoContaCorrente() throws Exception {
        tocarElemento(botaoContaCorrente, "Não foi possível clicar no botão Conta Corrente");
        salvarEvidencia("Clicar no botão 'Conta Corrente'");
        return this;
    }

    /**
     * Clicar botão 'Conta Poupança'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Conta Poupança\"")
    public FormaDePagamentoTela tocarBotaoContaPoupanca() throws Exception {
        tocarElemento(botaoContaPoupanca, "Não foi possível clicar no botão Conta Poupança");
        salvarEvidencia("Clicar no botão 'Conta Poupança'");
        return this;
    }

    /**
     * Clicar botão 'Salvar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Salvar\"")
    public FormaDePagamentoTela tocarBotaoSalvar() throws Exception {
        aguardarCarregamentoElemento(botaoSalvar);
        salvarEvidencia("Clicar no botão 'Salvar'");
        compararElementoTexto(botaoSalvar, Recarga.SALVAR, MetodoComparacao.IGUAL);
        tocarElemento(botaoSalvar, "Não foi possível clicar no botão Salvar");
        return this;
    }
}
