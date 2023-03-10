package pagina.mobile.jornadas.atendimento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AjudaNextTela extends PaginaBase {


    @AndroidFindBy(xpath = "//*[@text = 'AJUDA NEXT']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='AJUDA']")
    private MobileElement tituloTelaAjuda;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_open_history")
    @AndroidFindBy(xpath = "//*[@text = 'VER HISTÓRICO']")
    @iOSXCUITFindBy(accessibility = "Ver histórico")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ver histórico']")
    private MobileElement botaoVerHistorico;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id ="br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Voltar']")
    private MobileElement botaoMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_start_chat")
    @AndroidFindBy(xpath = "//*[@text = 'INICIAR CHAT']")
    @iOSXCUITFindBy(accessibility = "Iniciar chat")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Iniciar chat']")
    private MobileElement botaoIniciarChat;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @AndroidFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Voltar']")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Cartőes']")
    @iOSXCUITFindBy(accessibility = "Cartőes")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cartőes']")
    private MobileElement botaoCartoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Conta']")
    @iOSXCUITFindBy(accessibility = "Conta")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Conta']")
    private MobileElement botaoConta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Empréstimos']")
    @iOSXCUITFindBy(accessibility = "Empréstimos")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Empréstimos']")
    private MobileElement botaoEmprestimos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Indique amigos']")
    @iOSXCUITFindBy(accessibility = "Indique amigos")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Indique amigos']")
    private MobileElement botaoIndiqueAmigos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Investimentos']")
    @iOSXCUITFindBy(accessibility = "Investimentos")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Investimentos']")
    private MobileElement botaoInvestimentos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Mimos']")
    @iOSXCUITFindBy(accessibility = "Mimos")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mimos']")
    private MobileElement botaoMimos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'nextJoy']")
    @iOSXCUITFindBy(accessibility = "nextJoy")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='nextJoy']")
    private MobileElement botaoNextJoy;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'nextShop']")
    @iOSXCUITFindBy(accessibility = "nextShop")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='nextShop']")
    private MobileElement botaoNextShop;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Open Finance']")
    @iOSXCUITFindBy(accessibility = "Open Finance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Open Finance']")
    private MobileElement botaoOpenFinance;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Pix']")
    @iOSXCUITFindBy(accessibility = "Pix")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pix']")
    private MobileElement botaoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Segurança']")
    @iOSXCUITFindBy(accessibility = "Segurança")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Segurança']")
    private MobileElement botaoSeguranca;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Seguros']")
    @iOSXCUITFindBy(accessibility = "Seguros")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Seguros']")
    private MobileElement botaoSeguros;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Sobre nós']")
    @iOSXCUITFindBy(accessibility = "Sobre nós")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sobre nós']")
    private MobileElement botaoSobreNos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Transaçőes']")
    @iOSXCUITFindBy(accessibility = "Transaçőes")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transaçőes']")
    private MobileElement botaoTransacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Trazer salário']")
    @iOSXCUITFindBy(accessibility = "Trazer salário")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Trazer salário']")
    private MobileElement botaoTrazerSalario;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Vaquinha']")
    @iOSXCUITFindBy(accessibility = "Vaquinha")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Vaquinha']")
    private MobileElement botaoVaquinha;


    public AjudaNextTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Ajuda Next'
     *
     * @return AjudaNextTela
     * @throws Exception
     */
    @Step("Validar presença da tela 'Ajuda Next'")
    public AjudaNextTela validarPresencaAjudaNextTela() {
        verificarPresencaElemento(botaoVerHistorico);
        salvarEvidencia("Validada presença da tela 'Ajuda'");
        return this;
    }

    /**
     * Tocar botăo "Iniciar Chat"
     *
     * @return AjudaNextTela
     * @throws Exception
     */
    @Step("Tocar botăo 'Iniciar Chat'")
    public AjudaNextTela tocarBotaoIniciarChat() throws Exception {
        salvarEvidencia("Tocar botăo 'Iniciar Chat'");
        tocarElemento(botaoIniciarChat, "Năo foi possivel tocar no botăo 'Iniciar Chat'");
        return this;
    }

    /**
     * Tocar botăo 'Ver Histórico
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botăo 'Ver Histórico'")
    public AjudaNextTela tocarbotaoVerHistorico() throws Exception {
        salvarEvidencia("Tocar botăo 'Ver Histórico");
        tocarElemento(botaoVerHistorico, "Năo foi possível tocar no botăo 'Ver Histórico");
        return this;
    }

     /**
     * Tocar botăo 'Menu'"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botăo 'Menu'")
    public AjudaNextTela tocarBotaoMenu() throws Exception {
        salvarEvidencia("Tocar botăo 'Menu'");
        tocarElemento(botaoMenu,"Năo foi possível tocar no botăo 'Menu'");
        return this;
    }
    /**
     * Tocar botăo 'Voltar'"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botăo 'Voltar'")
    public AjudaNextTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botăo 'Voltar'");
        tocarElemento(botaoVoltar,"Năo foi possível tocar no botăo 'Voltar'");
        return this;
    }

    /**
     * Método criado para Clicar no botăo desejado do FAQ
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botăo da Pergunta do FAQ")
    public AjudaNextTela tocarPerguntaFaq(String textoBotao) throws Exception {
        By localizador = ios ? new MobileBy.ByAccessibilityId(textoBotao) : new By.ByXPath(" //*[@text = \""+textoBotao+"\"]/../*[@resource-id = \"br.com.bradesco.next:id/nl_faq_question\")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "A " + textoBotao + "năo foi encontrada em tela");
        salvarEvidencia("Clicar no botăo da Pergunta do FAQ" + textoBotao);
        tocarElemento(localizador, "Ocorreu um erro ao executar a açăo de clicar no botăo"+textoBotao);
        return this;
    }

    /**
     * Validar presença botăo 'Cartőes'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Cartoes'")
    public AjudaNextTela validarPresencaBotaoCartoes() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoCartoes), MetodoComparacaoBooleano.VERDADEIRO, "'botăo Cartőes' năo está presente na tela!");
        salvarEvidencia("Validada presença do botăo 'Cartőes'");
        return this;
    }

    /**
     * Validar presença botăo 'Conta'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Conta'")
    public AjudaNextTela validarPresencaBotaoConta() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoConta), MetodoComparacaoBooleano.VERDADEIRO, "'botăo Conta' năo está presente na tela!");
        salvarEvidencia("Validada presença do botăo 'Conta'");
        return this;
    }

    /**
     * Validar presença botăo 'Empréstimos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Emprestimos'")
    public AjudaNextTela validarPresencaBotaoEmprestimos() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoEmprestimos), MetodoComparacaoBooleano.VERDADEIRO, "'botăo Empréstimos' năo está presente na tela!");
        salvarEvidencia("Validada presença do botăo 'Empréstimos'");
        return this;
    }

    /**
     * Validar presença botăo 'Indique Amigos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Indique Amigos'")
    public AjudaNextTela validarPresencaBotaoIndiqueAmigos() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoIndiqueAmigos, "Năo foi possivel encontar o botăo 'Indique Amigos'");
        salvarEvidencia("Validada presença do botăo 'Indique Amigos'");
        return this;
    }

    /**
     * Validar presença botăo 'Investimentos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Investimentos'")
    public AjudaNextTela validarPresencaBotaoInvestimentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos, "Năo foi possivel encontar o botăo 'Investimentos'");
        salvarEvidencia("Validada presença do botăo 'Investimentos'");
        return this;
    }

    /**
     * Validar presença botăo 'Mimos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Mimos'")
    public AjudaNextTela validarPresencaBotaoMimos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "Năo foi possivel encontar o botăo 'Mimos'");
        salvarEvidencia("Validada presença do botăo 'Mimos'");
        return this;
    }

    /**
     * Validar presença botăo 'NextJoy'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'NextJoy'")
    public AjudaNextTela validarPresencaBotaoNextJoy() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos, "Năo foi possivel encontar o botăo 'NextJoy'");
        salvarEvidencia("Validada presença do botăo 'NextJoy'");
        return this;
    }

    /**
     * Validar presença botăo 'NextShop'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'NextShop'")
    public AjudaNextTela validarPresencaBotaoNextShop() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoNextShop, "Năo foi possivel encontar o botăo 'NextShop'");
        salvarEvidencia("Validada presença do botăo 'NextShop'");
        return this;
    }

    /**
     * Validar presença botăo 'OpenFinance'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'OpenFinance'")
    public AjudaNextTela validarPresencaBotaoOpenFinance() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOpenFinance, "Năo foi possivel encontar o botăo 'OpenFinance'");
        salvarEvidencia("Validada presença do botăo 'OpenFinance'");
        return this;
    }

    /**
     * Validar presença botăo 'Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Pix'")
    public AjudaNextTela validarPresencaBotaoPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPix, "Năo foi possivel encontar o botăo 'Pix'");
        salvarEvidencia("Validada presença do botăo 'Pix'");
        return this;
    }

    /**
     * Validar presença botăo 'Segurança'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Seguranca'")
    public AjudaNextTela validarPresencaBotaoSeguranca() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSeguranca, "Năo foi possivel encontar o botăo 'Segurança'");
        salvarEvidencia("Validada presença do botăo 'Segurança'");
        return this;
    }

    /**
     * Validar presença botăo 'Seguros'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Seguros'")
    public AjudaNextTela validarPresencaBotaoSeguros() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSeguros, "Năo foi possivel encontar o botăo 'Seguros'");
        salvarEvidencia("Validada presença do botăo 'Seguros'");
        return this;
    }

    /**
     * Validar presença botăo 'Sobre nós'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Sobre nos'")
    public AjudaNextTela validarPresencaBotaoSobreNos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSobreNos, "Năo foi possivel encontar o botăo 'Sobre nós'");
        salvarEvidencia("Validada presença do botăo 'Sobre nós'");
        return this;
    }

    /**
     * Validar presença botăo 'Transaçőes'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Transacoes'")
    public AjudaNextTela validarPresencaBotaoTransacoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTransacoes, "Năo foi possivel encontar o botăo 'Transaçőes'");
        salvarEvidencia("Validada presença do botăo 'Transaçőes'");
        return this;
    }

    /**
     * Validar presença botăo 'Trazer Salário'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Trazer Salario'")
    public AjudaNextTela validarPresencaBotaoTrazerSalario() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTrazerSalario, "Năo foi possivel encontar o botăo 'Trazer Salário'");
        salvarEvidencia("Validada presença do botăo 'Trazer Salário'");
        return this;
    }

    /**
     * Validar presença botăo 'Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Vaquinha'")
    public AjudaNextTela validarPresencaBotaoVaquinha() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVaquinha, "Năo foi possivel encontar o botăo 'Vaquinha'");
        salvarEvidencia("Validada presença do botăo 'Vaquinha'");
        return this;
    }
}




