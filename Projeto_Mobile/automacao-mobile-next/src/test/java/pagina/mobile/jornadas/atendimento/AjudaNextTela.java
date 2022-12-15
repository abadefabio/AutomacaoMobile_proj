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
    @AndroidFindBy(xpath = "//*[@text = 'VER HIST�RICO']")
    @iOSXCUITFindBy(accessibility = "Ver hist�rico")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Ver hist�rico']")
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
    @AndroidFindBy(xpath = "//*[@text = 'Cart�es']")
    @iOSXCUITFindBy(accessibility = "Cart�es")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cart�es']")
    private MobileElement botaoCartoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Conta']")
    @iOSXCUITFindBy(accessibility = "Conta")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Conta']")
    private MobileElement botaoConta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Empr�stimos']")
    @iOSXCUITFindBy(accessibility = "Empr�stimos")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Empr�stimos']")
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
    @AndroidFindBy(xpath = "//*[@text = 'Seguran�a']")
    @iOSXCUITFindBy(accessibility = "Seguran�a")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Seguran�a']")
    private MobileElement botaoSeguranca;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Seguros']")
    @iOSXCUITFindBy(accessibility = "Seguros")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Seguros']")
    private MobileElement botaoSeguros;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Sobre n�s']")
    @iOSXCUITFindBy(accessibility = "Sobre n�s")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sobre n�s']")
    private MobileElement botaoSobreNos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Transa��es']")
    @iOSXCUITFindBy(accessibility = "Transa��es")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transa��es']")
    private MobileElement botaoTransacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Trazer sal�rio']")
    @iOSXCUITFindBy(accessibility = "Trazer sal�rio")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Trazer sal�rio']")
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
     * Validar presen�a da tela 'Ajuda Next'
     *
     * @return AjudaNextTela
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Ajuda Next'")
    public AjudaNextTela validarPresencaAjudaNextTela() {
        verificarPresencaElemento(botaoVerHistorico);
        salvarEvidencia("Validada presen�a da tela 'Ajuda'");
        return this;
    }

    /**
     * Tocar bot�o "Iniciar Chat"
     *
     * @return AjudaNextTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Iniciar Chat'")
    public AjudaNextTela tocarBotaoIniciarChat() throws Exception {
        salvarEvidencia("Tocar bot�o 'Iniciar Chat'");
        tocarElemento(botaoIniciarChat, "N�o foi possivel tocar no bot�o 'Iniciar Chat'");
        return this;
    }

    /**
     * Tocar bot�o 'Ver Hist�rico
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ver Hist�rico'")
    public AjudaNextTela tocarbotaoVerHistorico() throws Exception {
        salvarEvidencia("Tocar bot�o 'Ver Hist�rico");
        tocarElemento(botaoVerHistorico, "N�o foi poss�vel tocar no bot�o 'Ver Hist�rico");
        return this;
    }

     /**
     * Tocar bot�o 'Menu'"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Menu'")
    public AjudaNextTela tocarBotaoMenu() throws Exception {
        salvarEvidencia("Tocar bot�o 'Menu'");
        tocarElemento(botaoMenu,"N�o foi poss�vel tocar no bot�o 'Menu'");
        return this;
    }
    /**
     * Tocar bot�o 'Voltar'"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public AjudaNextTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar,"N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * M�todo criado para Clicar no bot�o desejado do FAQ
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no bot�o da Pergunta do FAQ")
    public AjudaNextTela tocarPerguntaFaq(String textoBotao) throws Exception {
        By localizador = ios ? new MobileBy.ByAccessibilityId(textoBotao) : new By.ByXPath(" //*[@text = \""+textoBotao+"\"]/../*[@resource-id = \"br.com.bradesco.next:id/nl_faq_question\")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "A " + textoBotao + "n�o foi encontrada em tela");
        salvarEvidencia("Clicar no bot�o da Pergunta do FAQ" + textoBotao);
        tocarElemento(localizador, "Ocorreu um erro ao executar a a��o de clicar no bot�o"+textoBotao);
        return this;
    }

    /**
     * Validar presen�a bot�o 'Cart�es'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Cartoes'")
    public AjudaNextTela validarPresencaBotaoCartoes() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoCartoes), MetodoComparacaoBooleano.VERDADEIRO, "'bot�o Cart�es' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a do bot�o 'Cart�es'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Conta'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Conta'")
    public AjudaNextTela validarPresencaBotaoConta() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoConta), MetodoComparacaoBooleano.VERDADEIRO, "'bot�o Conta' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a do bot�o 'Conta'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Empr�stimos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Emprestimos'")
    public AjudaNextTela validarPresencaBotaoEmprestimos() {
        validarCondicaoBooleana(verificarPresencaElemento(botaoEmprestimos), MetodoComparacaoBooleano.VERDADEIRO, "'bot�o Empr�stimos' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a do bot�o 'Empr�stimos'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Indique Amigos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Indique Amigos'")
    public AjudaNextTela validarPresencaBotaoIndiqueAmigos() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoIndiqueAmigos, "N�o foi possivel encontar o bot�o 'Indique Amigos'");
        salvarEvidencia("Validada presen�a do bot�o 'Indique Amigos'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Investimentos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Investimentos'")
    public AjudaNextTela validarPresencaBotaoInvestimentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos, "N�o foi possivel encontar o bot�o 'Investimentos'");
        salvarEvidencia("Validada presen�a do bot�o 'Investimentos'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Mimos'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Mimos'")
    public AjudaNextTela validarPresencaBotaoMimos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "N�o foi possivel encontar o bot�o 'Mimos'");
        salvarEvidencia("Validada presen�a do bot�o 'Mimos'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'NextJoy'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'NextJoy'")
    public AjudaNextTela validarPresencaBotaoNextJoy() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos, "N�o foi possivel encontar o bot�o 'NextJoy'");
        salvarEvidencia("Validada presen�a do bot�o 'NextJoy'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'NextShop'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'NextShop'")
    public AjudaNextTela validarPresencaBotaoNextShop() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoNextShop, "N�o foi possivel encontar o bot�o 'NextShop'");
        salvarEvidencia("Validada presen�a do bot�o 'NextShop'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'OpenFinance'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'OpenFinance'")
    public AjudaNextTela validarPresencaBotaoOpenFinance() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOpenFinance, "N�o foi possivel encontar o bot�o 'OpenFinance'");
        salvarEvidencia("Validada presen�a do bot�o 'OpenFinance'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Pix'")
    public AjudaNextTela validarPresencaBotaoPix() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPix, "N�o foi possivel encontar o bot�o 'Pix'");
        salvarEvidencia("Validada presen�a do bot�o 'Pix'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Seguran�a'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Seguranca'")
    public AjudaNextTela validarPresencaBotaoSeguranca() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSeguranca, "N�o foi possivel encontar o bot�o 'Seguran�a'");
        salvarEvidencia("Validada presen�a do bot�o 'Seguran�a'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Seguros'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Seguros'")
    public AjudaNextTela validarPresencaBotaoSeguros() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSeguros, "N�o foi possivel encontar o bot�o 'Seguros'");
        salvarEvidencia("Validada presen�a do bot�o 'Seguros'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Sobre n�s'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Sobre nos'")
    public AjudaNextTela validarPresencaBotaoSobreNos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSobreNos, "N�o foi possivel encontar o bot�o 'Sobre n�s'");
        salvarEvidencia("Validada presen�a do bot�o 'Sobre n�s'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Transa��es'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Transacoes'")
    public AjudaNextTela validarPresencaBotaoTransacoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTransacoes, "N�o foi possivel encontar o bot�o 'Transa��es'");
        salvarEvidencia("Validada presen�a do bot�o 'Transa��es'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Trazer Sal�rio'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Trazer Salario'")
    public AjudaNextTela validarPresencaBotaoTrazerSalario() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTrazerSalario, "N�o foi possivel encontar o bot�o 'Trazer Sal�rio'");
        salvarEvidencia("Validada presen�a do bot�o 'Trazer Sal�rio'");
        return this;
    }

    /**
     * Validar presen�a bot�o 'Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a do botao 'Vaquinha'")
    public AjudaNextTela validarPresencaBotaoVaquinha() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVaquinha, "N�o foi possivel encontar o bot�o 'Vaquinha'");
        salvarEvidencia("Validada presen�a do bot�o 'Vaquinha'");
        return this;
    }
}




