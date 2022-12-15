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

    //Botão Salvar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_edit_nickname_save_normal")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_edit_nickname_save_keyboard")
    @iOSXCUITFindBy(accessibility = "SALVAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SALVAR\"]")
    private MobileElement botaoSalvar;

    //Botão OK
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
     * Tocar no Botão 'Salvar'
     *
     * @return EditarDadosTela
     * @throws NextException
     */
    @Step("Tocar botão \"Salvar\"")
    public EditarDadosTela tocarBotaoSalvar() throws NextException {
        salvarEvidencia("Tocar no botão 'Salvar'");
        tocarElemento(botaoSalvar, "Não foi possível tocar no botão 'Salvar'!");
        return this;
    }

    /**
     * Tocar no Botão 'OK'
     *
     * @return EditarDadosTela
     * @throws NextException
     */
    @Step("Tocar botão \"Ok\"")
    public EditarDadosTela tocarBotaoOk() throws NextException {
        salvarEvidencia("Tocar no botão 'OK'");
        tocarElemento(botaoOk, "Não foi possível tocar no botão 'OK'!");
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
        apagarCampoTexto(textoApelido, "Não foi possível apagar o apelido!");
        escreverTexto(textoApelido, apelido, "Não foi possível preencher o apelido!");
        return this;
    }

    /**
     * Validar a exibição da mensagem 'Apelido Alterado!'
     *
     *
     * @return
     */
    @Step("Validar mensagem \"Apelido Alterado\"")
    public EditarDadosTela validarMensagemApelidoAlterado() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.APELIDO_ALTERADO), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Apelido alterado' não está presente na tela!");
        salvarEvidencia("Validar exibição do texto 'Apelido alterado'");
        return this;
    }

    /**
     * Validar a exibição da tela 'Editar Apelido'
     *
     * @return EditarDadosTela
     */
    @Step("Validar tela \"Editar Apelido\"")
    public EditarDadosTela validarTelaEditarApelido() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.TITULO_EDITAR_APELIDO), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Editar Apelido' não está presente na tela!");
        salvarEvidencia("Validar presenca da a tela 'Editar Apelido'");
        return this;
    }
}
