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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Opção selecionável, , Conta-Corrente, \"`]")
    private MobileElement radioContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='br.com.bradesco.next:id/rb_type_savings']")
    @AndroidFindBy(xpath = "//*[@text='Conta-poupança']")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    @AndroidBy(id = "br.com.bradesco.next:id/rb_type_savings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Opção selecionável, , Poupança, \"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Opção selecionável, Poupança, \"`]")
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
    @iOSXCUITFindBy(accessibility = "Pra qual tipo de conta você quer transferir?")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Pra qual tipo de conta\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pra qual tipo de conta você quer transferir?\"]")
    private  MobileElement textoTela;

    public TransferirTipoContaTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botão "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferirTipoContaTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no botão fechar (X)" );
        tocarElemento( botaoFechar, "Nao foi possivel tocar no botão fechar" );
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
     * Verfificar RadioButton Conta Corrente está selecionado"
     *
     * @return TransferirTipoContaTela
     * @throws Exception
     */
    @Step("Verfificar RadioButton Conta Corrente está selecionado")
    public TransferirTipoContaTela verificarRadioButtonContaCorrenteSelecionado() throws Exception{
        aguardarCarregamentoElemento(radioContaCorrente);
        validarCondicaoBooleana(radioContaCorrente.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar RadioButton Conta Corrente está selecionado.");
        salvarEvidencia("Validado RadioButton Conta Corrente selecionado.");
        return this;
    }

    /**
     * Tocar radio-button "Poupança"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Poupança\"")
    public TransferirTipoContaTela tocarRadioButtonPoupanca() throws Exception{
        tocarElemento(radioPoupanca, "Erro ao tocar radio-button \"Poupança\"");
        salvarEvidencia("Tocar radio-button \"Poupança\"");
        return this;
    }

    /**
     * Verfificar RadioButton Conta Poupança está selecionado"
     *
     * @return TransferirTipoContaTela
     * @throws Exception
     */
    @Step("Verfificar RadioButton Conta Corrente está selecionado")
    public TransferirTipoContaTela verificarRadioButtonContaPoupancaSelecionado() throws Exception{
        aguardarCarregamentoElemento(radioPoupanca);
        validarCondicaoBooleana(radioPoupanca.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar RadioButton Conta Poupança está selecionado.");
        salvarEvidencia("Validado RadioButton Conta Poupança selecionado.");
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirTipoContaTela tocarBotaoContinuar() throws Exception{
        salvarEvidencia("Tocar botão \"Continuar\"");
        tocarElemento(botaoContinuar, "Erro ao executar a ação de tocar botão \"Continuar\"");
        return this;
    }

    /**
     * Validar descrição Data na tela
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
