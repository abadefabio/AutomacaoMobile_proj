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
    @AndroidFindBy(xpath = "//*[@text='REALIZAR TRANSA��O']")
    @iOSXCUITFindBy(accessibility = "REALIZAR TRANSA��O")
    @iOSXCUITFindBy(xpath = "//*[@name='REALIZAR TRANSA��O']")
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

    @AndroidFindBy(xpath = "//*[@text='Descri��o']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Descri��o')]")
    private MobileElement botaoDescricao;

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextView\"")
    private MobileElement campoDescricao;

    @AndroidFindBy(xpath = "//*[@text='SALVAR MENSAGEM']")
    @iOSXCUITFindBy(xpath = "(//*[@name='SALVAR MENSAGEM'])[2]")
    private MobileElement botaoSalvarMensagem;

    @AndroidFindBy(xpath = "//*[@text='AGENDAR TRANSA��O']")
    @iOSXCUITFindBy(xpath = "//*[@name='AGENDAR TRANSA��O']")
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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Pix.CONFIRME_OS_DADOS_TELA), MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar a tela 'Confirme os Dados'");
        salvarEvidencia("Validada a tela 'Confirme os Dados'");
        return this;
    }

    /**
     * Tocar no bot�o 'Realizar Transa��o'
     *
     * @return ConfirmeOsDadosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Realizar Transa��o'")
    public ConfirmeOsDadosTela tocarBotaoRealizarTransacao() throws Exception {
        aguardarCarregamentoElemento(botaoRealizarTransacao);
        salvarEvidencia("Tocar bot�o 'Realizar Transa��o'");
        tocarElemento(botaoRealizarTransacao, "N�o foi poss�vel tocar no bot�o 'Realizar Transa��o'");
        return this;
    }

    /**
     * Tocar no bot�o 'Cancelar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Cancelar'")
    public ConfirmeOsDadosTela tocarBotaoCancelar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Cancelar'");
        tocarElemento(botaoCancelar, "N�o foi poss�vel tocar no bot�o 'Cancelar'");
        return this;
    }

    /**
     * M�todo que toca no bot�o 'Quando' na tela 'CONFIRME OS DADOS'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no bot�o 'Quando'")
    public ConfirmeOsDadosTela tocarBotaoQuando() throws NextException {
        aguardarCarregamentoElemento(botaoQuando);
        salvarEvidencia("Tocar no bot�o 'Quando'.");
        tocarElemento(botaoQuando, "N�o foi poss�vel tocar no bot�o 'Quando'.");
        return this;
    }

    /**
     * M�todo que toca no bot�o 'Descri��o' na tela 'CONFIRME OS DADOS'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no bot�o 'Descri��o'")
    public ConfirmeOsDadosTela tocarBotaoDescricao() throws NextException {
        aguardarCarregamentoElemento(botaoDescricao);
        salvarEvidencia("Tocar no bot�o 'Descri��o'.");
        tocarElemento(botaoDescricao, "N�o foi poss�vel tocar no bot�o 'Descri��o'.");
        return this;
    }

    /**
     * M�todo que preenche a 'Descri��o' da transa��o
     * @return ConfirmeOsDadosTela
     */
    @Step("Preencher o campo 'Descri��o'")
    public ConfirmeOsDadosTela preencherDescricao(String chavePix) throws Exception {
        if(ios){
            apagarCampoTexto(campoDescricao, "N�o foi poss�vel apagar o conte�do do campo 'Descri��o'.");
            escreverTexto(campoDescricao, "PIX para " + chavePix, false, "N�o foi poss�vel escrever o texto 'PIX para "+ chavePix +"'.");
        }else{
            teclarBackSpaceAteApagar(campoDescricao, 30);
            digitarTexto(campoDescricao,chavePix);
        }
        salvarEvidencia("Informado uma descri��o para a transfer�ncia");
        return this;
    }

    /**
     * M�todo que toca no bot�o 'Salvar Mensagem'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no bot�o ' Salvar Mensagem'")
    public ConfirmeOsDadosTela tocarBotaoSalvarMensagem() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Salvar Mensagem'.");
        tocarElemento(botaoSalvarMensagem, "N�o foi poss�vel tocar no bot�o 'Salvar Mensagem'.");
        return this;
    }

    /**
     * M�todo que toca no bot�o 'Agendar Transa��o'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no bot�o 'Agendar Transa��o'")
    public ConfirmeOsDadosTela tocarBotaoAgendarTransacao() throws NextException {
        aguardarCarregamentoElemento(botaoAgendarTransacao);
        salvarEvidencia("Tocar no bot�o 'Agendar Transa��o'.");
        tocarElemento(botaoAgendarTransacao, "N�o foi poss�vel tocar no bot�o 'Agendar Transa��o'.");
        return this;
    }

    /**
     * M�todo que toca no bot�o 'Ver Comprovante'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no bot�o 'Ver Comprovante'")
    public ConfirmeOsDadosTela tocarBotaoVerComprovante() throws NextException {
        aguardarCarregamentoElemento(botaoVerComprovante);
        salvarEvidencia("Tocar no bot�o 'Ver Comprovante'.");
        tocarElemento(botaoVerComprovante, "N�o foi poss�vel tocar no bot�o 'Ver Comprovante'.");
        return this;
    }

    /**
     * M�todo que toca no bot�o 'Compartilhar'
     * @return ConfirmeOsDadosTela
     */
    @Step("Tocar no bot�o 'Ver Comprovante'")
    public ConfirmeOsDadosTela tocarBotaoCompartilhar() throws NextException {
        aguardarCarregamentoElemento(botaoCompartilhar);
        salvarEvidencia("Tocar no bot�o 'Compartilhar'.");
        tocarElemento(botaoCompartilhar, "N�o foi poss�vel tocar no bot�o 'Compartilhar'.");
        return this;
    }
}
