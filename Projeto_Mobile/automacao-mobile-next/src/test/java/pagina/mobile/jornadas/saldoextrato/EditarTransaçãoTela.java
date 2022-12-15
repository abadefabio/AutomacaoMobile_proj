package pagina.mobile.jornadas.saldoextrato;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EditarTransa��oTela extends PaginaBase {

    public static ThreadLocal<String> transacaoValidar = new ThreadLocal<String>();


    public EditarTransa��oTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"EDITAR\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"EDITAR\"]")
    private MobileElement tituloEditar;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Continuar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\" OR label == \"CONTINUAR\"`][1]")
    private MobileElement botaoContinuar;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Concluir\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\" OR label == \"CONTINUAR\"`][1]")
    private MobileElement botaoConcluir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK\"]")
    private MobileElement botaoOk;

    @AndroidFindBy(xpath = "//*[@resource-id=\"br.com.bradesco.next:id/tv_text\" and @text=\"Altera��es realizadas com sucesso.\"]")
    @iOSXCUITFindBy(accessibility = "Pronto! Altera��es realizadas com sucesso.")
    private MobileElement mensagemAlteracoesRealizadas;

    /**
     * Validar exibi��o da tela de 'Editar'
     * @return
     */
    @Step("Validar exibi��o da tela de 'Editar'")
    public EditarTransa��oTela validarTelaEditar() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloEditar),
                MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o da tela 'Editar'");
        salvarEvidencia("Validou exibi��o da tela de 'Editar'");
        return this;
    }

    /**
     * Tocar bot�o Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Continuar'")
    public EditarTransa��oTela tocarContinuar() throws Exception {
        salvarEvidencia("Tocar botao 'Continuar'");
        String mensagemErro = "Nao foi possivel tocar em bot�o \"Continuar\"";
        if (ios) {
            tocarElemento(botaoContinuar, mensagemErro);
        }else{
            tocarElementoOculto("//android.widget.Button[@text=\"Continuar\"]", mensagemErro);
        }
        return this;
    }

    /**
     * Tocar bot�o Concluir
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Concluir'")
    public EditarTransa��oTela tocarConcluir() throws Exception {
        salvarEvidencia("Tocar botao 'Concluir'");
        String mensagemErro = "Nao foi possivel tocar em bot�o \"Concluir\"";
        if (android){
            tocarElementoOculto("//android.widget.Button[@text=\"Concluir\"]", mensagemErro);
        }else {
            tocarElemento(botaoConcluir, mensagemErro);
        }
        return this;
    }

    /**
     * Validar mensagem do 'Altera��o realizada com sucesso'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem do 'Altera��o realizada com sucesso'")
    public EditarTransa��oTela validarMensagemAltera��oRealizadaComSucesso() throws Exception {
        if (ios){
            aguardarCarregamentoElemento(mensagemAlteracoesRealizadas);
        }else{
            verificarPresencaElementoOculto("//*[@resource-id=\"br.com.bradesco.next:id/tv_text\" and @text=\"Altera��es realizadas com sucesso.\"]");
        }
        salvarEvidencia("Validar mensagem do 'Altera��o realizada com sucesso'");
        return this;
    }

    /**
     * Tocar bot�o OK 'Altera��o realizada com sucesso'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'OK'")
    public EditarTransa��oTela tocarBotaoOk() throws Exception {
        salvarEvidencia("Tocar botao 'Ok'");
        String mensagemErro = "Nao foi possivel tocar em bot�o \"Ok\"";
        if (ios) {
            tocarElemento(botaoOk, mensagemErro);
        }else {
            tocarElementoOculto("//*[@resource-id=\"br.com.bradesco.next:id/bt_ok\"]", mensagemErro);
        }
        return this;
    }

}
