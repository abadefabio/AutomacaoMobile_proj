package pagina.mobile.jornadas.seguros.residencial.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.seguros.SegurosResidencial;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SaldoInsuficienteResidencialTela extends PaginaBase {

    public SaldoInsuficienteResidencialTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Título da tela SALDO INSUFICIENTE
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SEGUROS\"]")
    private MobileElement headerTituloTelaSaldoInsuficiente;

    // ìcone FECHAR da tela SALDO INSUFICIENTE
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"leftNavigationIcon\"]")
    private MobileElement btnFecharTelaSaldoInsuficiente;

    // Botão OK da tela SALDO INSUFICIENTE
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'primaryButton')]")
    private MobileElement btnOKTelaSaldoInsuficiente;
    /*     *************************     */

    /*
    Método para Valida tela SALDO INSUFICIENTE
     */
    @Step("Valida tela SALDO INSUFICIENTE")
    public SaldoInsuficienteResidencialTela validaTelaSaldoInsuficiente() throws Exception {
        aguardarCarregamentoElemento(headerTituloTelaSaldoInsuficiente);
        compararElementoTexto(headerTituloTelaSaldoInsuficiente, SegurosResidencial.TITULO_TELA_SALDO_INSUFICIENTE, MetodoComparacao.IGUAL);
        salvarEvidencia("Tela SALDO INSUFICIENTE");
        return this;
    }
    /*
    Método para Tocar no botão <OK> da tela SALDO INSUFICIENTE
     */
    @Step("Tocar no botão <OK> da tela SALDO INSUFICIENTE")
    public SaldoInsuficienteResidencialTela tocarBtnOKTelaSaldoInsuficiente() throws Exception {
        aguardarCarregamentoElemento(btnOKTelaSaldoInsuficiente);
        salvarEvidencia("Tocar no botão <OK> da tela SALDO INSUFICIENTE");
        tocarElemento(btnOKTelaSaldoInsuficiente, "Não foi possível tocar no botão <OK> da tela SALDO INSUFICIENTE.");
        return this;
    }
}
