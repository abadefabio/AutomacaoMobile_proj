package pagina.mobile.jornadas.pix.minhas.chaves;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;

import constantes.pix.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MinhasChavesTela extends PaginaBase {

    public MinhasChavesTela(AppiumDriver driver) {

        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Sim, remover')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'SIM, REMOVER')]")
    @iOSXCUITFindBy(accessibility = "SIM, REMOVER")
    private MobileElement botaoSimRemover;

    @AndroidFindBy(xpath = "//*[contains(@text,'OK')]")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOK;

    @AndroidFindBy(xpath = "//*[contains(@text,'INCLUIR CHAVE')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Incluir chave')]")
    private MobileElement botaoIncluirChave;

    @AndroidFindBy(xpath = "//*[contains(@text, 'PENDENTES')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'PENDENTES')]")
    private MobileElement abaPendentes;

    @AndroidFindBy(xpath = "//*[contains(@text, 'TRAZER PARA O NEXT')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'TRAZER PARA O NEXT')]")
    private MobileElement botaoTrazarParaONext;

    @AndroidFindBy(xpath = "//*[contains(@text, 'INICIAR PORTABILIDADE')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Iniciar portabilidade')]")
    private MobileElement botaoIniciarPortabilidade;

    @AndroidFindBy(xpath = "//*[contains(@text, 'SIM, CANCELAR PORTABILIDADE')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'SIM, CANCELAR PORTABILIDADE')]")
    private MobileElement botaoSimCancelarPortabilidade;

    /**
     * Tocar bot�o 'Compartilhar' chave
     *
     * @param descricaoChave
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Compartilhar' chave")
    public MinhasChavesTela tocarBotaoCompartilharChave(String descricaoChave) throws NextException {
        By botaoCompartilhar;
        if (ios) {
            botaoCompartilhar = By.xpath("//XCUIElementTypeStaticText[@name='" + descricaoChave + "']/following-sibling::XCUIElementTypeStaticText[1]");
        } else {
            botaoCompartilhar = By.xpath("//*[@text='" + descricaoChave + "']/../*[@resource-id='br.com.bradesco.next:id/nni_pix_key_list_item_share_icon']");
        }
        salvarEvidencia("Tocar no bot�o compartilhar da : " + descricaoChave);
        tocarElemento(botaoCompartilhar, "N�o foi poss�vel tocar no bot�o compartilhar da: " + descricaoChave);
        return this;
    }

    /**
     * Tocar bot�o 'Excluir Chave'
     *
     * @param descricaoChave
     * @param chaveAtiva
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Excluir' chave")
    public MinhasChavesTela tocarBotaoExcluirChave(String descricaoChave, boolean chaveAtiva) throws NextException {
        By botaoExcluirChave;
        if (ios) {
            botaoExcluirChave = chaveAtiva ?
                    By.xpath("//*[@name='"+descricaoChave+"']/following-sibling::*[@type='XCUIElementTypeStaticText'][2]") :
                    By.xpath("//XCUIElementTypeCell/following::*[@name='"+descricaoChave+"']/following-sibling::*[@type='XCUIElementTypeStaticText'][last()]");
        } else {
            botaoExcluirChave = By.xpath("//*[@text='" + descricaoChave + "']/../*[@resource-id='br.com.bradesco.next:id/nni_pix_key_list_item_delete_icon']");
        }
        aguardarCarregamentoElemento(botaoExcluirChave);
        salvarEvidencia("Tocar no bot�o excluir da chave: " + descricaoChave);
        tocarElemento(botaoExcluirChave, "N�o foi poss�vel tocar no bot�o excluir da chave: " + descricaoChave);
        return this;
    }

    /**
     * Tocar bot�o 'Sim Remover'
     *
     * @return MinhasChavesTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Sim Remover'")
    public MinhasChavesTela tocarBotaoSimRemover() throws Exception {
        aguardarCarregamentoElemento(botaoSimRemover);
        salvarEvidencia("Tocar no bot�o 'Sim Remover'");
        tocarElemento(botaoSimRemover, "N�o foi poss�vel Tocar no bot�o 'Sim Remover'");
        return this;
    }

    /**
     * Validar 'Chave Removida'
     *
     * @return MinhasChavesTela
     */
    @Step("Validar 'Chave Removida'")
    public MinhasChavesTela validarChaveRemovida() {
        aguardarCarregamentoElemento(Mensagens.CHAVE_REMOVIDA);
        salvarEvidencia("Chave Removida");
        return this;
    }

    /**
     * Tocar bot�o 'OK'
     *
     * @return MinhasChavesTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'OK'")
    public MinhasChavesTela tocarBotaoOK() throws Exception {
        aguardarCarregamentoElemento(botaoOK);
        salvarEvidencia("Tocar no bot�o 'OK'");
        tocarElemento(botaoOK, "N�o foi poss�vel tocar no bot�o 'OK'");
        return this;
    }

    /**
     * Validar exclus�o de chave aleat�ria
     *
     * @param descricaoChave
     * @return MinhasChavesTela
     */
    @Step("Validar Exclus�o Chave Aleat�ria")
    public MinhasChavesTela validarExclusaoChaveAleatoria(String descricaoChave) {
        By botaoExcluirChave;
        if (ios) {
            botaoExcluirChave = By.xpath("//XCUIElementTypeStaticText[@name='" + descricaoChave + "']/../XCUIElementTypeButton[2]");
        } else {
            botaoExcluirChave = By.xpath("//*[@text='" + descricaoChave + "']/../*[@resource-id='br.com.bradesco.next:id/nni_pix_key_list_item_delete_icon']");
        }
        boolean validacao = !verificarPresencaElemento(botaoExcluirChave);
        salvarEvidencia("Chave aleat�ria removida: " + descricaoChave);
        validarCondicaoBooleana(validacao, MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel remover: " + descricaoChave);
        return this;
    }

    /**
     * Tocar no bot�o 'Incluir Chave'
     *
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Incluir Chave'")
    public MinhasChavesTela tocarBotaoIncluirChave() throws NextException {
        aguardarCarregamentoElemento(botaoIncluirChave);
        salvarEvidencia("Tocar no bot�o 'Incluir Chave'");
        tocarElemento(botaoIncluirChave, "N�o foi poss�vel tocar no bot�o 'Incluir Chave'");
        return this;
    }

    /**
     * Tocar na aba 'Pendentes'
     *
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar na aba 'Pendentes'")
    public MinhasChavesTela tocarAbaPendentes() throws NextException {
        aguardarCarregamentoElemento(abaPendentes);
        salvarEvidencia("Tocar na aba 'Pendentes'");
        tocarElemento(abaPendentes, "N�o foi poss�vel tocar na aba 'Pendentes'");
        return this;
    }

    /**
     * Tocar no bot�o 'Trazer para o Next'
     *
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Trazer para o Next'")
    public MinhasChavesTela tocarBotaoTrazerParaONext() throws NextException {
        aguardarCarregamentoElemento(botaoTrazarParaONext);
        salvarEvidencia("Tocar no bot�o 'Trazer para o Next'");
        tocarElemento(botaoTrazarParaONext, "N�o foi poss�vel tocar no bot�o 'Trazer para o Next'");
        return this;
    }

    /**
     * Tocar no bot�o 'Iniciar Portabilidade'
     *
     * @return MinhasChavesTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Iniciar Portabilidade'")
    public MinhasChavesTela tocarBotaoIniciarPortabilidade() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoIniciarPortabilidade, "N�o foi poss�vel encontrar o bot�o 'Iniciar Portabilidade'");
        salvarEvidencia("Tocar no bot�o 'Iniciar Portabilidade'");
        tocarElemento(botaoIniciarPortabilidade, "N�o foi poss�vel tocar no bot�o 'Iniciar Portabilidade'");
        return this;
    }

    /**
     * Tocar no bot�o 'Sim, Cancelar Portabilidade'
     *
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Sim, Cancelar Portabilidade'")
    public MinhasChavesTela tocarBotaoSimCancelarPortabilidade() throws NextException {
        aguardarCarregamentoElemento(botaoSimCancelarPortabilidade);
        salvarEvidencia("Tocar no bot�o 'Sim, Cancelar Portabilidade'");
        tocarElemento(botaoSimCancelarPortabilidade, "N�o foi poss�vel tocar no bot�o 'Sim, Cancelar Portabilidade'");
        return this;
    }
}
