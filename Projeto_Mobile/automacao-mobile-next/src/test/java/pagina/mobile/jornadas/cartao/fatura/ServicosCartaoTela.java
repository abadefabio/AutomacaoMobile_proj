package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ServicosCartaoTela extends PaginaBase {

    // Visa causa
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Visa Causas")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Visa Causas\"]")
    @AndroidFindBy(accessibility = "Apoie uma causa e faça a diferença")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Apoie uma causa e faça a diferença\"]")
    @iOSXCUITFindBy(accessibility = "Visa Causas. Apoie uma causa e faça a diferença")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Visa Causas. Apoie uma causa e faça a diferença\"]")
    @iOSXCUITFindBy(accessibility = "Apoie uma causa e faça a diferença")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Apoie uma causa e faça a diferença\"]")
    private MobileElement tocarVisaCausa;

    // seguro cartao
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    private MobileElement tocarSeguroCartao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Aviso viagem")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Aviso viagem\"]")
    @iOSXCUITFindBy(accessibility = "Aviso viagem. Pra usar o cartão no exterior")
    private MobileElement botaoAvisoViagem;

    @AndroidFindBy(accessibility = "botão continuar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout/android.widget.TextView)[1]")
    @iOSXCUITFindBy(accessibility = "Continente")
    private MobileElement botaoSelecionarContinente;

    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout/android.widget.TextView)[2]")
    @iOSXCUITFindBy(accessibility = "Período")
    private MobileElement botaoPeriodo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_check")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "Continuar")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoContinuarContinente;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @iOSXCUITFindBy(accessibility = "Aviso de Viagem ativado.")
    private MobileElement textoConfirmacaoSucesso;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK\"]")
    private MobileElement botaoOk;

    public ServicosCartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao "Seguro Cartao"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Seguro Cartao\"")
    public ServicosCartaoTela tocarSeguroCartao() throws Exception {
        tocarElemento(tocarSeguroCartao, "Não foi possível tocar no botao \"Seguro Cartao\"");
        salvarEvidencia("Tocar no botao \"Seguro Cartao\"");
        return this;
    }

    /**
     * Tocar botao "Visa Causa"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Visa Causa\"")
    public ServicosCartaoTela tocarVisaCausa() throws Exception {
        salvarEvidencia("Tocar no botao \"Visa Causa\"");
        tocarElemento(tocarVisaCausa, "Não foi possível tocar no botao \"Visa Causa\"");
        return this;
    }

    /**
     * Tocar botao "Aviso Viagem"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Aviso Viagem\"")
    public ServicosCartaoTela tocarBotaoAvisoViagem() throws Exception {
        salvarEvidencia("Tocar no botao \"Aviso Viagem\"");
        tocarElemento(botaoAvisoViagem, "Não foi possível tocar no botao \"Aviso Viagem\"");
        return this;
    }

    /**
     * Tocar botao "Continuar"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Continuar\"")
    public ServicosCartaoTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no botao \"Continuar\"");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botao \"Continuar\"");
        return this;
    }

    /**
     * Tocar botao "Selecionar Continente"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Selecionar Continente\"")
    public ServicosCartaoTela tocarSelecionarContinente() throws Exception {
        salvarEvidencia("Tocar no botao \"Selecionar Pais\"");
        tocarElemento(botaoSelecionarContinente, "Não foi possível tocar no botao \"Selecionar Pais\"");
        return this;
    }

    /**
     * Tocar botao "Selecionar Periodo"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Selecionar Periodo\"")
    public ServicosCartaoTela tocarSelecionarPeriodo() throws Exception {
        salvarEvidencia("Tocar no botao \"Selecionar Periodo\"");
        tocarElemento(botaoPeriodo, "Não foi possível tocar no botao \"Selecionar Periodo\"");
        return this;
    }

    /**
     * Tocar botao "Confirmar"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Confirmar\"")
    public ServicosCartaoTela tocarBotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar no botao \"Confirmar\"");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botao \"Confirmar\"");
        return this;
    }

    /**
     * Tocar botao "Continuar"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Continuar\"")
    public ServicosCartaoTela tocarBotaoContinuarContinente() throws Exception {
        aguardarCarregamentoElemento(botaoContinuarContinente);
        salvarEvidencia("Tocar no botao \"Continuar\"");
        tocarElemento(botaoContinuarContinente, "Não foi possível tocar no botao \"Continuar\"");
        return this;
    }


    /**
     * Validar Sucesso Operacao
     *
     *
     * @throws Exception
     */
    @Step("Validar Sucesso Operacao")
    public ServicosCartaoTela validarMensagemSucesso(String texto) throws Exception {
        validarAtributoTexto(textoConfirmacaoSucesso,texto,"Não foi possivel validar o texto de confirmacao.");
        salvarEvidencia("Validar Sucesso Operacao");
        return this;
    }

    /**
     * Tocar botao "OK"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"OK\"")
    public ServicosCartaoTela tocarBotaoOk() throws Exception {
        salvarEvidencia("Tocar no botao \"OK\"");
        tocarElemento(botaoOk, "Não foi possível tocar no botao \"OK\"");
        return this;
    }

    /**
     * Selecionar Continente através do rolar tela
     *
     *
     * @throws Exception
     */
    @Step("Selecionar Continente")
    public ServicosCartaoTela seleconarContinente() throws Exception {
        rolarTela(0.6,0.4);
        salvarEvidencia("Selecionado Continente");
        return this;
    }
}
