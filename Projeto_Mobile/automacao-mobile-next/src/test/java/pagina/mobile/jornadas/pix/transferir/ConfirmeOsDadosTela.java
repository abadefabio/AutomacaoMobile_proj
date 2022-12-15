package pagina.mobile.jornadas.pix.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.pix.Pix;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConfirmeOsDadosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_confirm]")
    @AndroidFindBy(xpath = "//*[@text='REALIZAR TRANSAÇÃO']")
    @iOSXCUITFindBy(accessibility = "REALIZAR TRANSAÇÃO")
    @iOSXCUITFindBy(xpath = "//*[@name='REALIZAR TRANSAÇÃO']")
    private MobileElement botaoRealizarTransacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_cancel")
    @AndroidFindBy(xpath = "//*[@text='CANCELAR']")
    @iOSXCUITFindBy(accessibility = "CANCELAR")
    @iOSXCUITFindBy(xpath = "//*[@name='CANCELAR']")
    private MobileElement botaoCancelar;

    @AndroidFindBy(xpath = "//*[@text='Quando']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Quando')]")
    private MobileElement botaoQuando;

    @AndroidFindBy(xpath = "//*[@text='Descrição']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Descrição')]")
    private MobileElement botaoDescricao;

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextView\"")
    private MobileElement campoDescricao;

    @AndroidFindBy(xpath = "//*[@text='SALVAR MENSAGEM']")
    @iOSXCUITFindBy(xpath = "(//*[@name='SALVAR MENSAGEM'])[2]")
    private MobileElement botaoSalvarMensagem;

    @AndroidFindBy(xpath = "//*[@text='AGENDAR TRANSAÇÃO']")
    @iOSXCUITFindBy(xpath = "//*[@name='AGENDAR TRANSAÇÃO']")
    private MobileElement botaoAgendarTransacao;

    @AndroidFindBy(xpath = "//*[@text='VER COMPROVANTE']")
    @iOSXCUITFindBy(xpath = "//*[@name='VER COMPROVANTE']")
    private MobileElement botaoVerComprovante;

    @AndroidFindBy(xpath = "//*[@text='COMPARTILHAR']")
    @iOSXCUITFindBy(xpath = "//*[@name='Compartilhar']")
    private MobileElement botaoCompartilhar;

    public ConfirmeOsDadosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar tela 'Confirme os Dados'
     */
    @Step("Validar tela 'Confirme os Dados'")
    public ConfirmeOsDadosTela validarConfirmeOsDadosTela() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.CONFIRME_OS_DADOS_TELA), MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar a tela 'Confirme os Dados'");
        salvarEvidencia("Validada a tela 'Confirme os Dados'");
        return this;
    }

    /**
     * Tocar no botão 'Realizar Transação'
     *
     * @return ConfirmeOsDadosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Realizar Transação'")
    public ConfirmeOsDadosTela tocarBotaoRealizarTransacao() throws Exception {
        aguardarCarregamentoElemento(botaoRealizarTransacao);
        salvarEvidencia("Tocar botão 'Realizar Transação'");
        tocarElemento(botaoRealizarTransacao, "Não foi possível tocar no botão 'Realizar Transação'");
        return this;
    }

    /**
     * Tocar no botão 'Cancelar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'Cancelar'")
    public ConfirmeOsDadosTela tocarBotaoCancelar() throws Exception {
        salvarEvidencia("Tocar botão 'Cancelar'");
        tocarElemento(botaoCancelar, "Não foi possível tocar no botão 'Cancelar'");
        return this;
    }

    /**
     * Método que toca no botão 'Quando' na tela 'CONFIRME OS DADOS'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no botão 'Quando'")
    public ConfirmeOsDadosTela tocarBotaoQuando() throws NextException {
        aguardarCarregamentoElemento(botaoQuando);
        salvarEvidencia("Tocar no botão 'Quando'.");
        tocarElemento(botaoQuando, "Não foi possível tocar no botão 'Quando'.");
        return this;
    }

    /**
     * Método que toca no botão 'Descrição' na tela 'CONFIRME OS DADOS'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no botão 'Descrição'")
    public ConfirmeOsDadosTela tocarBotaoDescricao() throws NextException {
        aguardarCarregamentoElemento(botaoDescricao);
        salvarEvidencia("Tocar no botão 'Descrição'.");
        tocarElemento(botaoDescricao, "Não foi possível tocar no botão 'Descrição'.");
        return this;
    }

    /**
     * Método que preenche a 'Descrição' da transação
     * @return ConfirmeOsDadosTela
     */
    @Step("Preencher o campo 'Descrição'")
    public ConfirmeOsDadosTela preencherDescricao(String chavePix) throws Exception {
        if(ios){
            apagarCampoTexto(campoDescricao, "Não foi possível apagar o conteúdo do campo 'Descrição'.");
            escreverTexto(campoDescricao, "PIX para " + chavePix, false, "Não foi possível escrever o texto 'PIX para "+ chavePix +"'.");
        }else{
            teclarBackSpaceAteApagar(campoDescricao, 30);
            digitarTexto(campoDescricao,chavePix);
        }
        salvarEvidencia("Informado uma descrição para a transferência");
        return this;
    }

    /**
     * Método que toca no botão 'Salvar Mensagem'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no botão ' Salvar Mensagem'")
    public ConfirmeOsDadosTela tocarBotaoSalvarMensagem() throws NextException {
        salvarEvidencia("Tocar no botão 'Salvar Mensagem'.");
        tocarElemento(botaoSalvarMensagem, "Não foi possível tocar no botão 'Salvar Mensagem'.");
        return this;
    }

    /**
     * Método que toca no botão 'Agendar Transação'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no botão 'Agendar Transação'")
    public ConfirmeOsDadosTela tocarBotaoAgendarTransacao() throws NextException {
        aguardarCarregamentoElemento(botaoAgendarTransacao);
        salvarEvidencia("Tocar no botão 'Agendar Transação'.");
        tocarElemento(botaoAgendarTransacao, "Não foi possível tocar no botão 'Agendar Transação'.");
        return this;
    }

    /**
     * Método que toca no botão 'Ver Comprovante'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no botão 'Ver Comprovante'")
    public ConfirmeOsDadosTela tocarBotaoVerComprovante() throws NextException {
        aguardarCarregamentoElemento(botaoVerComprovante);
        salvarEvidencia("Tocar no botão 'Ver Comprovante'.");
        tocarElemento(botaoVerComprovante, "Não foi possível tocar no botão 'Ver Comprovante'.");
        return this;
    }

    /**
     * Método que toca no botão 'Compartilhar'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no botão 'Ver Comprovante'")
    public ConfirmeOsDadosTela tocarBotaoCompartilhar() throws NextException {
        aguardarCarregamentoElemento(botaoCompartilhar);
        salvarEvidencia("Tocar no botão 'Compartilhar'.");
        tocarElemento(botaoCompartilhar, "Não foi possível tocar no botão 'Compartilhar'.");
        return this;
    }
}
