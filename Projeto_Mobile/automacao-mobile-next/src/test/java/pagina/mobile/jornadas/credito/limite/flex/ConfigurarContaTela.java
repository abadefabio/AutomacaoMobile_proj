package pagina.mobile.jornadas.credito.limite.flex;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.credito.Mensagem;
import constantes.portabilidade.PortabilidadeDados;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConfigurarContaTela extends PaginaBase {

    @AndroidFindBy(id="br.com.bradesco.next:id/cb_checkbox")
    private MobileElement checkConfirmacao;

    @AndroidFindBy(id="br.com.bradesco.next:id/btn_ok_flex_limit_config_act")
    private MobileElement btnConfirmar;

    @AndroidFindBy(xpath="//*[contains(@text, 'Tudo certo')]")
    @iOSXCUITFindBy(xpath="//*[contains(@value, 'Tudo certo')]")
    private MobileElement textoMensagem;

    @AndroidFindBy(id="br.com.bradesco.next:id/btn_ok_flex_limit_config_act")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ok']")
    private MobileElement btnOk;

    public ConfigurarContaTela(AppiumDriver driver) {super(driver);}

    /**
     * Tocar no checkbox 'Grana de Emergencia'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Check de Confirmacao'")
    public ConfigurarContaTela tocarCheckConfirmacao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkConfirmacao, "Nao foi possivel encontrar o check de confirmacao");
        salvarEvidencia("Tocar no Check de Confirmacao");
        tocarElemento(checkConfirmacao,"Nao foi possivel tocar no Check de Confirmacao");
        return this;
    }

    /**
     * Tocar no checkbox 'Emprestimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Confirmar'")
    public ConfigurarContaTela tocarBotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Confirmar'");
        tocarElemento(btnConfirmar,"Nao foi possivel tocar no bot�o 'Confirmar'");
        return this;
    }

    /**
     * Validar Mensagem de Sucesso
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Mensagem de Sucesso")
    public ConfigurarContaTela validarMensagemSucesso() throws Exception {
        compararElementoTexto(textoMensagem, Mensagem.MENSAGEM_SUCESSO_CONFIGURACAO_LIMITE, MetodoComparacao.IGUAL);
        salvarEvidencia("Valida��o realizada com sucesso - 'Tudo certo com as novas configuracoes da sua conta!'");
        return this;
    }

    /**
     * Tocar no botao 'Ok'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ok'")
    public ConfigurarContaTela tocarBotaoOk() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Ok'");
        tocarElemento(btnOk,"Nao foi possivel tocar no bot�o 'Ok'");
        return this;
    }

}
