package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.transferencia.MensagensEsperadas;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class TransferirTipoContaTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[1]")
    private MobileElement numeroPaginaAtual;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement descricaoPagina;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.RadioButton[1]")
    @AndroidBy(id = "br.com.bradesco.next:id/rb_type_current")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Op��o selecion�vel, , Conta-Corrente, \"`]")
    private MobileElement radioContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='br.com.bradesco.next:id/rb_type_savings']")
    @AndroidFindBy(xpath = "//*[@text='Conta-poupan�a']")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    @AndroidBy(id = "br.com.bradesco.next:id/rb_type_savings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Op��o selecion�vel, , Poupan�a, \"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Op��o selecion�vel, Poupan�a, \"`]")
    private MobileElement radioPoupanca;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//android.widget.Button")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_instruction")
    @iOSXCUITFindBy(accessibility = "Pra qual tipo de conta voc� quer transferir?")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Pra qual tipo de conta\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pra qual tipo de conta voc� quer transferir?\"]")
    private  MobileElement textoTela;

    public TransferirTipoContaTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar bot�o "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o fechar (X)")
    public TransferirTipoContaTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no bot�o fechar (X)" );
        tocarElemento( botaoFechar, "Nao foi possivel tocar no bot�o fechar" );
        return this;
    }

    /**
     * Tocar radio-button "Conta-Corrente"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Conta-Corrente\"")
    public TransferirTipoContaTela tocarRadioButtonContaCorrente() throws Exception {
        tocarElemento(radioContaCorrente, "Erro ao tocar radio-button \"Conta-Corrente\"");
        salvarEvidencia("Tocar radio-button \"Conta-Corrente\"");
        return this;
    }

    /**
     * Verfificar RadioButton Conta Corrente est� selecionado"
     *
     * @return TransferirTipoContaTela
     * @throws Exception
     */
    @Step("Verfificar RadioButton Conta Corrente est� selecionado")
    public TransferirTipoContaTela verificarRadioButtonContaCorrenteSelecionado() throws Exception{
        aguardarCarregamentoElemento(radioContaCorrente);
        validarCondicaoBooleana(radioContaCorrente.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar RadioButton Conta Corrente est� selecionado.");
        salvarEvidencia("Validado RadioButton Conta Corrente selecionado.");
        return this;
    }

    /**
     * Tocar radio-button "Poupan�a"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Poupan�a\"")
    public TransferirTipoContaTela tocarRadioButtonPoupanca() throws Exception{
        tocarElemento(radioPoupanca, "Erro ao tocar radio-button \"Poupan�a\"");
        salvarEvidencia("Tocar radio-button \"Poupan�a\"");
        return this;
    }

    /**
     * Verfificar RadioButton Conta Poupan�a est� selecionado"
     *
     * @return TransferirTipoContaTela
     * @throws Exception
     */
    @Step("Verfificar RadioButton Conta Corrente est� selecionado")
    public TransferirTipoContaTela verificarRadioButtonContaPoupancaSelecionado() throws Exception{
        aguardarCarregamentoElemento(radioPoupanca);
        validarCondicaoBooleana(radioPoupanca.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar RadioButton Conta Poupan�a est� selecionado.");
        salvarEvidencia("Validado RadioButton Conta Poupan�a selecionado.");
        return this;
    }

    /**
     * Tocar bot�o "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TransferirTipoContaTela tocarBotaoContinuar() throws Exception{
        salvarEvidencia("Tocar bot�o \"Continuar\"");
        tocarElemento(botaoContinuar, "Erro ao executar a a��o de tocar bot�o \"Continuar\"");
        return this;
    }

    /**
     * Validar descri��o Data na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Descricao\" da tela")
    public TransferirTipoContaTela tipoDeContaDescricao() throws Exception {
        aguardarCarregamentoElemento(textoTela);
        salvarEvidencia("validar tipo de conta");
        compararElementoTexto(textoTela, MensagensEsperadas.TIPOCONTA_TRANSFERENCIA, MetodoComparacao.IGUAL);
        return this;
    }

}
