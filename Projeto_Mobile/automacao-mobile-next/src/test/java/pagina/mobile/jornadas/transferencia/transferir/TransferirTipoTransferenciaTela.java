package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class TransferirTipoTransferenciaTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[1]")
    private MobileElement numeroPaginaAtual;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement descricaoPagina;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_ted")
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/rb_type_ted']")
    @AndroidFindBy(xpath = "//*[contains(@text,'TED']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Op��o selecion�vel, TED, \"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@text,'TED']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_ted")
    private MobileElement radioTED;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/rb_type_doc']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_doc")
    @AndroidFindBy(xpath = "//*[contains(@text,'DOC']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Op��o selecion�vel, DOC, \"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'DOC']")
    private MobileElement radioDOC;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='br.com.bradesco.next:id/bt_continue']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "'label == \"Pr�ximo\" AND type == \"XCUIElementTypeButton\"'")
    private MobileElement botaoContinuar;

    public TransferirTipoTransferenciaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o fechar (X)")
    public TransferirTipoTransferenciaTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no bot�o fechar (X)");
        tocarElemento(botaoFechar, "Nao foi possivel tocar no bot�o fechar");
        return this;
    }

    /**
     * Tocar radio-button "TED"
     *
     * @return TransferirTipoTransferenciaTela
     * @throws Exception
     */
    @Step("Tocar radio-button TED")
    public TransferirTipoTransferenciaTela tocarRadioButtonTED() throws Exception{
        aguardarCarregamentoElemento(radioTED);
        tocarElemento(radioTED, "Erro ao tocar radio-button TED");
        salvarEvidencia("Tocar radio-button TED");
        return this;
    }

    /**
     * Verfificar RadioButton TED est� selecionado"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("verfificar Tipo de transferencia")
    public TransferirTipoTransferenciaTela verificarRadioButtonTedSelecionado() throws Exception{
        aguardarCarregamentoElemento(radioTED);
        validarCondicaoBooleana(radioTED.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar radioButton est� selecionado.");
        salvarEvidencia("Validado radioButton TED selecionado.");
        return this;
    }

    /**
     * Tocar bot�o "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TransferirTipoTransferenciaTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar bot�o \"Continuar\"");
        tocarElemento(botaoContinuar, "Erro ao executar a a��o de tocar bot�o \"Continuar\"");
        return this;
    }
    /**
     * verificar verfificar Tipo de transferencia"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("verfificar Tipo de transferencia")
    public TransferirTipoTransferenciaTela verificarTipoTransferencia() throws Exception{
        aguardarCarregamentoElemento(radioTED);
        validarCondicaoBooleana(radioTED.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi possivel validar o tipo de transferencia.");
        salvarEvidencia("Validando existencia do tipo de Tranferencia");
        return this;
    }

    /**
     * Tocar bot�o radio DOC
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar op��o DOC")
    public TransferirTipoTransferenciaTela tocarRadioDoc() throws Exception {
        esperarCarregando();
        aguardarCarregamentoElemento(radioDOC);
        salvarEvidencia("Tocar op��o DOC");
        tocarElemento(radioDOC, "Nao foi possivel tocar a op��o DOC");
        return this;
    }


    /**
     * Tocar bot�o radio TED
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar op��o TED")
    public TransferirTipoTransferenciaTela tocarRadioTed() throws Exception {
        esperarCarregando();
        aguardarCarregamentoElemento(radioTED);
        tocarElemento(radioTED, "Nao foi possivel tocar a op��o DOC");
        salvarEvidencia("Tocar op��o TED");
        return this;
    }

    /**
     * Validar se o bot�o radio DOC desabilitada atrav�s da comparacao de imagens
     *
     * @param imgAntes,imgDepois
     * @return
     * @throws Exception
     */
    @Step("Validar Op��o DOC Desabilitada")
    public void validarDocNaoChecked(String imgAntes, String imgDepois) throws Exception {
        salvarEvidencia("Validar Op��o DOC Desabilitada");
        validarCondicaoBooleana(imgDepois.equals(imgAntes),MetodoComparacaoBooleano.VERDADEIRO,"Nao foi possivel tocar a op��o DOC");
    }

    /**
     * Retorna uma String em hexadecimal da imagem gerada do elemento radioDoc
     *
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Step("Obter imagem botao DOC")
    public String recuperarHashElementoDOCImg() throws IOException, NoSuchAlgorithmException {
        esperarCarregando();
        return recuperarHashElemento(radioDOC);
    }

    }
