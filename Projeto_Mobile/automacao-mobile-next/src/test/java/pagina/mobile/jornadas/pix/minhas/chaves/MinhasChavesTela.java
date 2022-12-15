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
     * Tocar botão 'Compartilhar' chave
     *
     * @param descricaoChave
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Compartilhar' chave")
    public MinhasChavesTela tocarBotaoCompartilharChave(String descricaoChave) throws NextException {
        By botaoCompartilhar;
        if (ios) {
            botaoCompartilhar = By.xpath("//XCUIElementTypeStaticText[@name='" + descricaoChave + "']/following-sibling::XCUIElementTypeStaticText[1]");
        } else {
            botaoCompartilhar = By.xpath("//*[@text='" + descricaoChave + "']/../*[@resource-id='br.com.bradesco.next:id/nni_pix_key_list_item_share_icon']");
        }
        salvarEvidencia("Tocar no botão compartilhar da : " + descricaoChave);
        tocarElemento(botaoCompartilhar, "Não foi possível tocar no botão compartilhar da: " + descricaoChave);
        return this;
    }

    /**
     * Tocar botão 'Excluir Chave'
     *
     * @param descricaoChave
     * @param chaveAtiva
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Excluir' chave")
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
        salvarEvidencia("Tocar no botão excluir da chave: " + descricaoChave);
        tocarElemento(botaoExcluirChave, "Não foi possível tocar no botão excluir da chave: " + descricaoChave);
        return this;
    }

    /**
     * Tocar botão 'Sim Remover'
     *
     * @return MinhasChavesTela
     * @throws Exception
     */
    @Step("Tocar botão 'Sim Remover'")
    public MinhasChavesTela tocarBotaoSimRemover() throws Exception {
        aguardarCarregamentoElemento(botaoSimRemover);
        salvarEvidencia("Tocar no botão 'Sim Remover'");
        tocarElemento(botaoSimRemover, "Não foi possível Tocar no botão 'Sim Remover'");
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
     * Tocar botão 'OK'
     *
     * @return MinhasChavesTela
     * @throws Exception
     */
    @Step("Tocar botão 'OK'")
    public MinhasChavesTela tocarBotaoOK() throws Exception {
        aguardarCarregamentoElemento(botaoOK);
        salvarEvidencia("Tocar no botão 'OK'");
        tocarElemento(botaoOK, "Não foi possível tocar no botão 'OK'");
        return this;
    }

    /**
     * Validar exclusão de chave aleatória
     *
     * @param descricaoChave
     * @return MinhasChavesTela
     */
    @Step("Validar Exclusão Chave Aleatória")
    public MinhasChavesTela validarExclusaoChaveAleatoria(String descricaoChave) {
        By botaoExcluirChave;
        if (ios) {
            botaoExcluirChave = By.xpath("//XCUIElementTypeStaticText[@name='" + descricaoChave + "']/../XCUIElementTypeButton[2]");
        } else {
            botaoExcluirChave = By.xpath("//*[@text='" + descricaoChave + "']/../*[@resource-id='br.com.bradesco.next:id/nni_pix_key_list_item_delete_icon']");
        }
        boolean validacao = !verificarPresencaElemento(botaoExcluirChave);
        salvarEvidencia("Chave aleatória removida: " + descricaoChave);
        validarCondicaoBooleana(validacao, MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível remover: " + descricaoChave);
        return this;
    }

    /**
     * Tocar no botão 'Incluir Chave'
     *
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Incluir Chave'")
    public MinhasChavesTela tocarBotaoIncluirChave() throws NextException {
        aguardarCarregamentoElemento(botaoIncluirChave);
        salvarEvidencia("Tocar no botão 'Incluir Chave'");
        tocarElemento(botaoIncluirChave, "Não foi possível tocar no botão 'Incluir Chave'");
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
        tocarElemento(abaPendentes, "Não foi possível tocar na aba 'Pendentes'");
        return this;
    }

    /**
     * Tocar no botão 'Trazer para o Next'
     *
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Trazer para o Next'")
    public MinhasChavesTela tocarBotaoTrazerParaONext() throws NextException {
        aguardarCarregamentoElemento(botaoTrazarParaONext);
        salvarEvidencia("Tocar no botão 'Trazer para o Next'");
        tocarElemento(botaoTrazarParaONext, "Não foi possível tocar no botão 'Trazer para o Next'");
        return this;
    }

    /**
     * Tocar no botão 'Iniciar Portabilidade'
     *
     * @return MinhasChavesTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Iniciar Portabilidade'")
    public MinhasChavesTela tocarBotaoIniciarPortabilidade() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoIniciarPortabilidade, "Não foi possível encontrar o botão 'Iniciar Portabilidade'");
        salvarEvidencia("Tocar no botão 'Iniciar Portabilidade'");
        tocarElemento(botaoIniciarPortabilidade, "Não foi possível tocar no botão 'Iniciar Portabilidade'");
        return this;
    }

    /**
     * Tocar no botão 'Sim, Cancelar Portabilidade'
     *
     * @return MinhasChavesTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Sim, Cancelar Portabilidade'")
    public MinhasChavesTela tocarBotaoSimCancelarPortabilidade() throws NextException {
        aguardarCarregamentoElemento(botaoSimCancelarPortabilidade);
        salvarEvidencia("Tocar no botão 'Sim, Cancelar Portabilidade'");
        tocarElemento(botaoSimCancelarPortabilidade, "Não foi possível tocar no botão 'Sim, Cancelar Portabilidade'");
        return this;
    }
}
