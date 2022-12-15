package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class TransferirMotivoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[1]")
    private MobileElement numeroPaginaAtual;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement descricaoPagina;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//*[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='br.com.bradesco.next:id/bt_continue']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(id = "Continuar")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Continuar')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton['label == \"Continuar\"']")
    @iOSXCUITFindBy(iOSNsPredicate = "'label == \"Continuar\"'")
    private MobileElement botaoContinuar;

    //clicar em escolher Motivo da transferencia
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_choose")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Escolher motivo\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Escolher motivo\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Escolher motivo\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Escolher motivo\"`]")
    private MobileElement escolherMotivo;

    //selecionar o Motivo da transferencia na lista
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"CREDITO EM CONTA\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CREDITO EM CONTA\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CREDITO EM CONTA\"]")
    private MobileElement selecionarMotivo;

    //confirmar o Motivo da transferencia apos selecão
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/item_apply")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Confirmar Seleção\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement confirmarMotivo;


    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_choose")
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/tv_choose']")
    @AndroidFindBy(xpath = "//*[contains(@text,'motivo')]")
    @iOSXCUITFindBy(id = "Escolher motivo")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Escolher motivo\"")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Escolher motivo\"`]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Escolher motivo\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Escolher motivo\"]")
    private MobileElement botaoEscolherMotivo;

    public TransferirMotivoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botão "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferirMotivoTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no botão fechar (X)" );
        tocarElemento( botaoFechar, "Nao foi possivel tocar no botão fechar" );
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirMotivoTela tocarBotaoContinuar() throws Exception{
        esperarCarregando();
        aguardarElementoHabilitado(botaoContinuar);
        salvarEvidencia("Tocar botão \"Continuar\"");
        tocarElemento(botaoContinuar, "Erro ao executar a ação de tocar botão \"Continuar\"");
        return this;
    }

    /**
     * Tocar botão "Escolher Motivo"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Escolher Motivo\"")
    public TransferirMotivoTela tocarBotaoEscolherMotivo() throws Exception{
        aguardarCarregamentoElemento(botaoEscolherMotivo);
        salvarEvidencia("Tocar botão \"Escolher Motivo\"");
        tocarElemento(botaoEscolherMotivo, "Erro ao executar a ação de tocar botão \"Escolher Motivo\"");
        return this;
    }

    @Step("Tocar Botao \"Motivo\"")
    public TransferirMotivoTela tocarMotivo() throws Exception{
        aguardarCarregamentoElemento(escolherMotivo);
        salvarEvidencia("Tocar botao \"Escolher Motivo\"");
        tocarElemento(escolherMotivo, "Erro ao executar a ação de tocar botao \"Escolher Motivo\"");
        return this;
    }
    /**
     * Tocar selec?o "Motivo"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar \"Motivo\"")
    public TransferirMotivoTela selecionarMotivo() throws Exception{
        aguardarCarregamentoElemento(selecionarMotivo);
        salvarEvidencia("Tocar Seleção de \"Motivo\"");
        tocarElemento(selecionarMotivo, "Erro ao executar a ação de tocar \"Motivo\"");
        return this;
    }

    /**
     * Tocar em Confirmar "Motivo"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar \"Motivo\"")
    public TransferirMotivoTela confirmarMotivo() throws Exception{
        aguardarCarregamentoElemento(confirmarMotivo);
        salvarEvidencia("Tocar botao para \"Confirmar Motivo\"");
        tocarElemento(confirmarMotivo, "Erro ao executar a ação de tocar \"Confirmar Motivo\"");
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirMotivoTela verificarPresencaBotaoContinuarClicar() throws Exception{
        if(aguardarCarregamentoElemento(botaoContinuar)) {
            tocarElemento(botaoContinuar, "Erro ao executar a acao de tocar botao \"Continuar\"");
            salvarEvidencia("Tocar botao \"Continuar\"");
        }
        return this;
    }
}
