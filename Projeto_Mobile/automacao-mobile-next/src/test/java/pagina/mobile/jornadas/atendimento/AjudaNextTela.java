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
    @AndroidFindBy(xpath = "//*[@text = 'Cartões']")
    @iOSXCUITFindBy(accessibility = "Cartões")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cartões']")
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
    @AndroidFindBy(xpath = "//*[@text = 'Transações']")
    @iOSXCUITFindBy(accessibility = "Transações")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transações']")
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
     * Tocar botão "Iniciar Chat"
     *
     * @return AjudaNextTela
     * @throws Exception
     */
    @Step("Tocar botão 'Iniciar Chat'")
    public AjudaNextTela tocarBotaoIniciarChat() throws Exception {
        salvarEvidencia("Tocar botão 'Iniciar Chat'");
        tocarElemento(botaoIniciarChat, "Não foi possivel tocar no botão 'Iniciar Chat'");
        return this;
    }

    /**
     * Tocar botão 'Ver Histórico
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Ver Histórico'")
    public AjudaNextTela tocarbotaoVerHistorico() throws Exception {
        salvarEvidencia("Tocar botão 'Ver Histórico");
        tocarElemento(botaoVerHistorico, "Não foi possível tocar no botão 'Ver Histórico");
        return this;
    }

     /**
     * Tocar botão 'Menu'"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Menu'")
    public AjudaNextTela tocarBotaoMenu() throws Exception {
        salvarEvidencia("Tocar botão 'Menu'");
        tocarElemento(botaoMenu,"Não foi possível tocar no botão 'Menu'");
        return this;
    }
    /**
     * Tocar botão 'Voltar'"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public AjudaNextTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar,"Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Método criado para Clicar no botão desejado do FAQ
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no botão da Pergunta do FAQ")
    public AjudaNextTela tocarPerguntaFaq(String textoBotao) throws Exception {
        By localizador = ios ? new MobileBy.ByAccessibilityId(textoBotao) : new By.ByXPath(" //*[@text = \""+textoBotao+"\"]/../*[@resource-id = \"br.com.bradesco.next:id/nl_faq_question\")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "A " + textoBotao + "não foi encontrada em tela");
        salvarEvidencia("Clicar no botão da Pergunta do FAQ" + textoBotao);
        tocarElemento(localizador, "Ocorreu um erro ao executar a ação de clicar no botão"+textoBotao);
        return this;
    }

    /**
     * Validar presença botão 'Cartões'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Cartoes'")
    public AjudaNextTela validarPresencaBotaoCartoes() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoCartoes), MetodoComparacaoBooleano.VERDADEIRO, "'botão Cartões' não está presente na tela!");
        salvarEvidencia("Validada presença do botão 'Cartões'");
        return this;
    }

    /**
     * Validar presença botão 'Conta'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Conta'")
    public AjudaNextTela validarPresencaBotaoConta() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoConta), MetodoComparacaoBooleano.VERDADEIRO, "'botão Conta' não está presente na tela!");
        salvarEvidencia("Validada presença do botão 'Conta'");
        return this;
    }

    /**
     * Validar presença botão 'Empréstimos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Emprestimos'")
    public AjudaNextTela validarPresencaBotaoEmprestimos() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoEmprestimos), MetodoComparacaoBooleano.VERDADEIRO, "'botão Empréstimos' não está presente na tela!");
        salvarEvidencia("Validada presença do botão 'Empréstimos'");
        return this;
    }

    /**
     * Validar presença botão 'Indique Amigos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Indique Amigos'")
    public AjudaNextTela validarPresencaBotaoIndiqueAmigos() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoIndiqueAmigos, "Não foi possivel encontar o botão 'Indique Amigos'");
        salvarEvidencia("Validada presença do botão 'Indique Amigos'");
        return this;
    }

    /**
     * Validar presença botão 'Investimentos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Investimentos'")
    public AjudaNextTela validarPresencaBotaoInvestimentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos, "Não foi possivel encontar o botão 'Investimentos'");
        salvarEvidencia("Validada presença do botão 'Investimentos'");
        return this;
    }

    /**
     * Validar presença botão 'Mimos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Mimos'")
    public AjudaNextTela validarPresencaBotaoMimos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "Não foi possivel encontar o botão 'Mimos'");
        salvarEvidencia("Validada presença do botão 'Mimos'");
        return this;
    }

    /**
     * Validar presença botão 'NextJoy'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'NextJoy'")
    public AjudaNextTela validarPresencaBotaoNextJoy() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos, "Não foi possivel encontar o botão 'NextJoy'");
        salvarEvidencia("Validada presença do botão 'NextJoy'");
        return this;
    }

    /**
     * Validar presença botão 'NextShop'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'NextShop'")
    public AjudaNextTela validarPresencaBotaoNextShop() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoNextShop, "Não foi possivel encontar o botão 'NextShop'");
        salvarEvidencia("Validada presença do botão 'NextShop'");
        return this;
    }

    /**
     * Validar presença botão 'OpenFinance'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'OpenFinance'")
    public AjudaNextTela validarPresencaBotaoOpenFinance() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOpenFinance, "Não foi possivel encontar o botão 'OpenFinance'");
        salvarEvidencia("Validada presença do botão 'OpenFinance'");
        return this;
    }

    /**
     * Validar presença botão 'Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Pix'")
    public AjudaNextTela validarPresencaBotaoPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPix, "Não foi possivel encontar o botão 'Pix'");
        salvarEvidencia("Validada presença do botão 'Pix'");
        return this;
    }

    /**
     * Validar presença botão 'Segurança'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Seguranca'")
    public AjudaNextTela validarPresencaBotaoSeguranca() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSeguranca, "Não foi possivel encontar o botão 'Segurança'");
        salvarEvidencia("Validada presença do botão 'Segurança'");
        return this;
    }

    /**
     * Validar presença botão 'Seguros'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Seguros'")
    public AjudaNextTela validarPresencaBotaoSeguros() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSeguros, "Não foi possivel encontar o botão 'Seguros'");
        salvarEvidencia("Validada presença do botão 'Seguros'");
        return this;
    }

    /**
     * Validar presença botão 'Sobre nós'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Sobre nos'")
    public AjudaNextTela validarPresencaBotaoSobreNos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSobreNos, "Não foi possivel encontar o botão 'Sobre nós'");
        salvarEvidencia("Validada presença do botão 'Sobre nós'");
        return this;
    }

    /**
     * Validar presença botão 'Transações'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Transacoes'")
    public AjudaNextTela validarPresencaBotaoTransacoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTransacoes, "Não foi possivel encontar o botão 'Transações'");
        salvarEvidencia("Validada presença do botão 'Transações'");
        return this;
    }

    /**
     * Validar presença botão 'Trazer Salário'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Trazer Salario'")
    public AjudaNextTela validarPresencaBotaoTrazerSalario() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTrazerSalario, "Não foi possivel encontar o botão 'Trazer Salário'");
        salvarEvidencia("Validada presença do botão 'Trazer Salário'");
        return this;
    }

    /**
     * Validar presença botão 'Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botao 'Vaquinha'")
    public AjudaNextTela validarPresencaBotaoVaquinha() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVaquinha, "Não foi possivel encontar o botão 'Vaquinha'");
        salvarEvidencia("Validada presença do botão 'Vaquinha'");
        return this;
    }
}




