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

public class EditarTransaçãoTela extends PaginaBase {

    public static ThreadLocal<String> transacaoValidar = new ThreadLocal<String>();


    public EditarTransaçãoTela(AppiumDriver driver) {
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

    @AndroidFindBy(xpath = "//*[@resource-id=\"br.com.bradesco.next:id/tv_text\" and @text=\"Alterações realizadas com sucesso.\"]")
    @iOSXCUITFindBy(accessibility = "Pronto! Alterações realizadas com sucesso.")
    private MobileElement mensagemAlteracoesRealizadas;

    /**
     * Validar exibição da tela de 'Editar'
     * @return
     */
    @Step("Validar exibição da tela de 'Editar'")
    public EditarTransaçãoTela validarTelaEditar() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloEditar),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela 'Editar'");
        salvarEvidencia("Validou exibição da tela de 'Editar'");
        return this;
    }

    /**
     * Tocar botão Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Continuar'")
    public EditarTransaçãoTela tocarContinuar() throws Exception {
        salvarEvidencia("Tocar botao 'Continuar'");
        String mensagemErro = "Nao foi possivel tocar em botão \"Continuar\"";
        if (ios) {
            tocarElemento(botaoContinuar, mensagemErro);
        }else{
            tocarElementoOculto("//android.widget.Button[@text=\"Continuar\"]", mensagemErro);
        }
        return this;
    }

    /**
     * Tocar botão Concluir
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Concluir'")
    public EditarTransaçãoTela tocarConcluir() throws Exception {
        salvarEvidencia("Tocar botao 'Concluir'");
        String mensagemErro = "Nao foi possivel tocar em botão \"Concluir\"";
        if (android){
            tocarElementoOculto("//android.widget.Button[@text=\"Concluir\"]", mensagemErro);
        }else {
            tocarElemento(botaoConcluir, mensagemErro);
        }
        return this;
    }

    /**
     * Validar mensagem do 'Alteração realizada com sucesso'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar mensagem do 'Alteração realizada com sucesso'")
    public EditarTransaçãoTela validarMensagemAlteraçãoRealizadaComSucesso() throws Exception {
        if (ios){
            aguardarCarregamentoElemento(mensagemAlteracoesRealizadas);
        }else{
            verificarPresencaElementoOculto("//*[@resource-id=\"br.com.bradesco.next:id/tv_text\" and @text=\"Alterações realizadas com sucesso.\"]");
        }
        salvarEvidencia("Validar mensagem do 'Alteração realizada com sucesso'");
        return this;
    }

    /**
     * Tocar botão OK 'Alteração realizada com sucesso'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'OK'")
    public EditarTransaçãoTela tocarBotaoOk() throws Exception {
        salvarEvidencia("Tocar botao 'Ok'");
        String mensagemErro = "Nao foi possivel tocar em botão \"Ok\"";
        if (ios) {
            tocarElemento(botaoOk, mensagemErro);
        }else {
            tocarElementoOculto("//*[@resource-id=\"br.com.bradesco.next:id/bt_ok\"]", mensagemErro);
        }
        return this;
    }

}
