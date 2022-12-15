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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Opção selecionável, TED, \"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@text,'TED']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_ted")
    private MobileElement radioTED;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/rb_type_doc']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/rb_type_doc")
    @AndroidFindBy(xpath = "//*[contains(@text,'DOC']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Opção selecionável, DOC, \"]")
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
    @iOSXCUITFindBy(iOSNsPredicate = "'label == \"Próximo\" AND type == \"XCUIElementTypeButton\"'")
    private MobileElement botaoContinuar;

    public TransferirTipoTransferenciaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferirTipoTransferenciaTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no botão fechar (X)");
        tocarElemento(botaoFechar, "Nao foi possivel tocar no botão fechar");
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
     * Verfificar RadioButton TED está selecionado"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("verfificar Tipo de transferencia")
    public TransferirTipoTransferenciaTela verificarRadioButtonTedSelecionado() throws Exception{
        aguardarCarregamentoElemento(radioTED);
        validarCondicaoBooleana(radioTED.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar radioButton está selecionado.");
        salvarEvidencia("Validado radioButton TED selecionado.");
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirTipoTransferenciaTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar botão \"Continuar\"");
        tocarElemento(botaoContinuar, "Erro ao executar a ação de tocar botão \"Continuar\"");
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
        validarCondicaoBooleana(radioTED.isEnabled(), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possivel validar o tipo de transferencia.");
        salvarEvidencia("Validando existencia do tipo de Tranferencia");
        return this;
    }

    /**
     * Tocar botão radio DOC
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar opção DOC")
    public TransferirTipoTransferenciaTela tocarRadioDoc() throws Exception {
        esperarCarregando();
        aguardarCarregamentoElemento(radioDOC);
        salvarEvidencia("Tocar opção DOC");
        tocarElemento(radioDOC, "Nao foi possivel tocar a opção DOC");
        return this;
    }


    /**
     * Tocar botão radio TED
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar opção TED")
    public TransferirTipoTransferenciaTela tocarRadioTed() throws Exception {
        esperarCarregando();
        aguardarCarregamentoElemento(radioTED);
        tocarElemento(radioTED, "Nao foi possivel tocar a opção DOC");
        salvarEvidencia("Tocar opção TED");
        return this;
    }

    /**
     * Validar se o botão radio DOC desabilitada através da comparacao de imagens
     *
     * @param imgAntes,imgDepois
     * @return
     * @throws Exception
     */
    @Step("Validar Opção DOC Desabilitada")
    public void validarDocNaoChecked(String imgAntes, String imgDepois) throws Exception {
        salvarEvidencia("Validar Opção DOC Desabilitada");
        validarCondicaoBooleana(imgDepois.equals(imgAntes),MetodoComparacaoBooleano.VERDADEIRO,"Nao foi possivel tocar a opção DOC");
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
