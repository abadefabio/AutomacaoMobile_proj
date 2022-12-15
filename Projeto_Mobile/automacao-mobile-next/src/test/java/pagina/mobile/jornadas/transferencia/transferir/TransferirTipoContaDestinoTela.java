package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.transferencia.MensagensEsperadas;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class TransferirTipoContaDestinoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[1]")
    private MobileElement numeroPaginaAtual;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement descricaoPagina;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='Conta-corrente']")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[1]")
    @AndroidBy(id = "br.com.bradesco.next:id/rb_type_current")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text=\"Conta-corrente\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Opção selecionável, Conta-Corrente, \"]")
    private MobileElement radioContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='Conta-poupança']")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    @AndroidBy(id = "br.com.bradesco.next:id/rb_type_savings")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Poupança')]")
    private MobileElement radioPoupanca;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='br.com.bradesco.next:id/bt_continue']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton['label == \"Continuar\"']")
    @iOSXCUITFindBy(iOSNsPredicate = "'label == \"Próximo\" AND type == \"XCUIElementTypeButton\"'")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_instruction")
    private MobileElement textoTela;

    public TransferirTipoContaDestinoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirTipoContaDestinoTela tocarBotaoContinuar() throws Exception{
        esconderTeclado();
        salvarEvidencia("Tocar botão \"Continuar\"");
        tocarElemento(botaoContinuar, "Erro ao executar a ação de tocar botão \"Continuar\"");
        return this;
    }

    /**
     * Tocar botão "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferirTipoContaDestinoTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no botão fechar (X)" );
        tocarElemento(botaoFechar, "Nao foi possivel tocar no botão fechar" );
        return this;
    }

    /**
     * verificar verfificar Tipo de transferencia"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("verfificar Tipo de transferencia")
    public TransferirTipoContaDestinoTela verificarTipoTransferencia() throws Exception{
        esconderTeclado();
        aguardarCarregamentoElemento(radioContaCorrente);
        validarCondicaoBooleana(radioContaCorrente.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possivel validar o tipo de transferencia.");
        salvarEvidencia("Validando existencia do tipo de Tranferencia");
        return this;
    }
    /**
     * verificar verfificar Tipo de transferencia"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("verfificar Tipo de transferencia")
    public TransferirTipoContaDestinoTela verificarMgsTipoTransferencia() throws Exception{
        aguardarCarregamentoElemento(textoTela);
        compararElementoTexto(textoTela, MensagensEsperadas.TIPOCONTA_TRANSFERENCIA, MetodoComparacao.IGUAL);
        salvarEvidencia("Validando existencia do tipo de Tranferencia");
        return this;
    }

    /**
     * Tocar radio-button "Conta-Corrente"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Conta-Corrente\"")
    public TransferirTipoContaDestinoTela tocarRadioButtonContaCorrente() throws Exception{
        aguardarCarregamentoElemento(radioContaCorrente);
        tocarElemento(radioContaCorrente, "Erro ao tocar radio-button \"Conta-Corrente\"");
        salvarEvidencia("Tocar radio-button \"Conta-Corrente\"");
        return this;
    }

    /**
     * Tocar radio-button "Poupança"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Poupança\"")
    public TransferirTipoContaDestinoTela tocarRadioButtonPoupanca() throws Exception{
        aguardarCarregamentoElemento(radioPoupanca);
        tocarElemento(radioPoupanca, "Erro ao tocar radio-button \"Poupança\"");
        salvarEvidencia("Tocar radio-button \"Poupança\"");
        return this;
    }

}
