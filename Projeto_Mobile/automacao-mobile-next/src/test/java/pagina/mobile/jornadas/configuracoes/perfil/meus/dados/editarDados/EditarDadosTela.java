package pagina.mobile.jornadas.configuracoes.perfil.meus.dados.editarDados;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.configuracoes.perfil.meusDados.Mensagens;
import constantes.configuracoes.perfil.meusDados.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EditarDadosTela extends PaginaBase {

    //Bot�o Salvar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_edit_nickname_save_normal")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_edit_nickname_save_keyboard")
    @iOSXCUITFindBy(accessibility = "SALVAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SALVAR\"]")
    private MobileElement botaoSalvar;

    //Bot�o OK
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbtSuccessMyDataConfirm")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private MobileElement botaoOk;

    //Campo de texto Apelido
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    private MobileElement textoApelido;

    public EditarDadosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no Bot�o 'Salvar'
     *
     * @return EditarDadosTela
     * @throws NextException
     */
    @Step("Tocar bot�o \"Salvar\"")
    public EditarDadosTela tocarBotaoSalvar() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Salvar'");
        tocarElemento(botaoSalvar, "N�o foi poss�vel tocar no bot�o 'Salvar'!");
        return this;
    }

    /**
     * Tocar no Bot�o 'OK'
     *
     * @return EditarDadosTela
     * @throws NextException
     */
    @Step("Tocar bot�o \"Ok\"")
    public EditarDadosTela tocarBotaoOk() throws NextException {
        salvarEvidencia("Tocar no bot�o 'OK'");
        tocarElemento(botaoOk, "N�o foi poss�vel tocar no bot�o 'OK'!");
        return this;
    }

    /**
     * Escrever no campo 'Apelido'
     *
     * @return EditarDadosTela
     * @throws NextException
     */
    @Step("Escrever no campo \"Apelido\"")
    public EditarDadosTela escreverApelido(String apelido) throws Exception {

        salvarEvidencia("Escrever novo Apelido: " + apelido);
        apagarCampoTexto(textoApelido, "N�o foi poss�vel apagar o apelido!");
        escreverTexto(textoApelido, apelido, "N�o foi poss�vel preencher o apelido!");
        return this;
    }

    /**
     * Validar a exibi��o da mensagem 'Apelido Alterado!'
     *
     *
     * @return
     */
    @Step("Validar mensagem \"Apelido Alterado\"")
    public EditarDadosTela validarMensagemApelidoAlterado() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.APELIDO_ALTERADO), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Apelido alterado' n�o est� presente na tela!");
        salvarEvidencia("Validar exibi��o do texto 'Apelido alterado'");
        return this;
    }

    /**
     * Validar a exibi��o da tela 'Editar Apelido'
     *
     * @return EditarDadosTela
     */
    @Step("Validar tela \"Editar Apelido\"")
    public EditarDadosTela validarTelaEditarApelido() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TITULO_EDITAR_APELIDO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Editar Apelido' n�o est� presente na tela!");
        salvarEvidencia("Validar presenca da a tela 'Editar Apelido'");
        return this;
    }
}
