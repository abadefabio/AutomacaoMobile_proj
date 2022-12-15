package pagina.mobile.jornadas.pix;

import org.openqa.selenium.By;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import constantes.pix.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class IncluirChavePixTela extends PaginaBase {

    public IncluirChavePixTela(AppiumDriver driver) {super(driver);}

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'CONTINUAR')]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(accessibility = "Próxima Página")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'INCLUIR CHAVE')]")
    @iOSXCUITFindBy(accessibility = "INCLUIR CHAVE")
    @iOSXCUITFindBy(accessibility = "Iniciar")
    private MobileElement botaoIncluirChave;

    @AndroidFindBy(xpath = "//*[contains(@text,'INCLUIR ESTA CHAVE')]")
    @iOSXCUITFindBy(accessibility = "INCLUIR ESTA CHAVE")
    private MobileElement botaoIncluirEstaChave;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Faça um Pix')]")
    @iOSXCUITFindBy(accessibility = "Faça um Pix")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Faça um Pix')]")
    private MobileElement labelFacaUmPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'O dinheiro cai na hora')]")
    @iOSXCUITFindBy(accessibility = "O dinheiro cai na hora")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'O dinheiro cai na hora')]")
    private MobileElement labelDinheiroCaiNaHora;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Simplifique sua vida')]")
    @iOSXCUITFindBy(accessibility = "Simplifique sua vida")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Simplifique sua vida')]")
    private MobileElement labelSimplifiqueSuaVida;

    @AndroidFindBy(xpath = "//*[contains(@text,'VOLTAR AO PIX')]")
    @iOSXCUITFindBy(accessibility = "VOLTAR AO PIX")
    private MobileElement botaoVoltarAoPix;

    @AndroidFindBy(xpath = "//*[contains(@text,'PAGAR')]/..")
    @iOSXCUITFindBy(accessibility = "PAGAR")
    private MobileElement abaPagar;

    /**
     * Clicar botão 'Continuar'
     *
     * @return IncluirChavePixTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public IncluirChavePixTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Clicar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível clicar no botão 'Continuar'");
        return this;
    }

    /**
     * Clicar botão 'Incluir Chave'
     *
     * @return IncluirChavePixTela
     * @throws Exception
     */
    @Step("Tocar botão \"Incluir Chave\"")
    public IncluirChavePixTela tocarBotaoIncluirChave() throws Exception {
        aguardarCarregamentoElemento(botaoIncluirChave);
        tocarElemento(botaoIncluirChave, "Não foi possível clicar no botão 'Incluir Chave'");
        salvarEvidencia("Clicar no botão 'Incluir Chave'");
        return this;
    }

    /**
     * Selecionar Chave
     *
     * @param chave Tipo de chave a ser selecionada
     * @return IncluirChavePixTela
     * @throws NextException
     */
    @Step("Selecionar Chave")
    public IncluirChavePixTela selecionarChave(String chave) throws NextException {
        aguardarElementoHabilitado(botaoIncluirEstaChave);
        By radioButton;
        if (android) {
            radioButton = By.xpath("//*[contains(@text,'"+chave+"')]");
        } else {
            radioButton = By.xpath("//XCUIElementTypeButton[@name='"+chave+"']");
        }
        tocarElemento(radioButton, "Não foi possível selecionar a opção '"+chave+"'");
        salvarEvidencia("Selecionada a opção '"+chave+"'");
        return this;
    }

    /**
     * Clicar botão 'Incluir Esta Chave'
     *
     * @return IncluirChavePixTela
     * @throws Exception
     */
    @Step("Tocar opção \"Incluir Esta Chave\"")
    public IncluirChavePixTela tocarBotaoIncluirEstaChave() throws Exception {
        aguardarCarregamentoElemento(botaoIncluirEstaChave);
        tocarElemento(botaoIncluirEstaChave, "Não foi possível clicar no botão 'Incluir Esta Chave'");
        salvarEvidencia("Clicar no botão 'Incluir Esta Chave'");
        return this;
    }

    /**
     * Selecionar tipo de conta
     *
     * @param tipoConta Tipo de conta a ser selecionada (Corrente ou Poupança)
     * @return IncluirChavePixTela
     * @throws NextException
     */
    @Step("Selecionar tipo de conta")
    public IncluirChavePixTela selecionarTipoConta(String tipoConta) throws NextException {
        aguardarElementoHabilitado(botaoContinuar);
        By radioButton;
        if (android) {
            radioButton = By.xpath("//*[@text='"+tipoConta+"']");
        } else {
            radioButton = By.xpath("//*[@name='"+tipoConta+"']");
        }
        tocarElemento(radioButton, "Não foi possível selecionar a opção '"+tipoConta+"'");
        salvarEvidencia("Selecionar a opção '"+tipoConta+"'");
        return this;
    }

    /**
     * Realizar Tutorial Pix
     *
     * @return IncluirChavePixTela
     * @throws Exception
     */
    @Step("Realizar tutorial pix")
    public IncluirChavePixTela realizarTutorialPix() throws Exception {
        aguardarCarregamentoElemento(labelFacaUmPix);
        tocarBotaoContinuar();
        aguardarCarregamentoElemento(labelDinheiroCaiNaHora);
        tocarBotaoContinuar();
        aguardarCarregamentoElemento(labelSimplifiqueSuaVida);
        tocarBotaoIncluirChave();
        return this;
    }

    /**
     * Valida a tela Chave Incluída com Sucesso
     *
     *
     * @throws Exception
     */
    @Step("Validar Chave Incluída com Sucesso")
    public IncluirChavePixTela validarChaveIncluidaComSucesso() throws Exception {
        aguardarPaginaConterTodosTextos(Mensagens.CHAVE_INCLUIDA_COM_SUCESSO);
        salvarEvidencia("Chave incluída com sucesso");
        return this;
    }

    /**
     * Valida a tela opções menu pix
     *
     * @throws Exception
     */
    @Step("Validar tela opções menu pix")
    public IncluirChavePixTela validarTelaOpcoesMenuPix() {
        aguardarCarregamentoElemento(abaPagar);
        salvarEvidencia("Validar tela Menu Pix");
        return this;
    }

    /**
     * Clicar botao 'Voltar ao Pix'
     *
     * @throws Exception
     */
    @Step("Clicar botao 'Voltar ao Pix'")
    public IncluirChavePixTela clicarBotaoVoltarAoPix() throws Exception {
        aguardarCarregamentoElemento(botaoVoltarAoPix);
        tocarElemento(botaoVoltarAoPix, "Não foi possível clicar no botão 'Voltar ao Pix'");
        salvarEvidencia("Clicar no botão 'Voltar ao Pix'");
        return this;
    }
}
