package pagina.mobile.menu;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.error.NextError;
import br.com.next.automacao.core.exception.NextException;
import constantes.login.LoginApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MenuTela extends PaginaBase {

    public MenuTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    /*
    O elemento do menu de Transfer�ncia n�o tem funcionado no Next 137 com UiAutomator,
    embora funcione em demais aparelhos. Por enquanto, ser� melhor n�o utilizar UiAutomator
    para fazer a rolagem r�pida at� o elemento, que n�o � encontrado mais.
     */
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"TRANSFER�NCIA\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Transfer�ncia')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"TRANSFER�NCIA\"$]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'TRANSFER�NCIA')]")
    private MobileElement botaoTransferencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"RECARGA CELULAR\"));")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"RECARGA CELULAR\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"RECARGA CELULAR\"$]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Recarga celular')]")
    private MobileElement botaoRecarga;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"SALDO E EXTRATO\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Saldo e extrato')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"SALDO E EXTRATO\"$]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'SALDO E EXTRATO')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Saldo e extrato')]")
    private MobileElement botaoSaldoExtrato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"OBJETIVOS\"]")
    @AndroidFindBy(accessibility = "Objetivos")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Objetivos')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"OBJETIVOS\"$]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'OBJETIVOS')]")
    private MobileElement botaoObjetivos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"DEP�SITOS E SAQUES\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'D�bitos e saques')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"DEP�SITOS E SAQUES\"$]")
    private MobileElement botaoDepositosSaques;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"TRAZER SAL�RIO\"));")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"TRAZER SAL�RIO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"TRAZER SAL�RIO\"$]")
    private MobileElement botaoTrazerSalario;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"VAQUINHA\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"VAQUINHA\"$]")
    private MobileElement botaoVaquinha;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_menu_logout")
    @iOSXCUITFindBy(accessibility = "SAIR")
    private MobileElement botaoSair;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_menu_toolbar_notifications")
    @AndroidFindBy(xpath = "//*[@content-desc = \"Menu Notifica��es.\"]/preceding-sibling::android.widget.ImageView")
    @AndroidFindBy(accessibility = "Menu Notifica��es.")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS \"Menu Notifica��es\"")
    private MobileElement botaoNotificacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_menu_profile_arrow")
    @iOSXCUITFindBy(accessibility = "icon-gear")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-gear\"]")
    private MobileElement botaoEngrenagem;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_positive")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeButton\"  and name = \"Sim\"")
    private MobileElement botaoSimPopup;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"PROTE��O\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"PROTE��O\"$]")
    private MobileElement botaoProtecao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_menu_partner_cashback")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='INDIQUE AMIGOS']")
    private MobileElement botaoParceiros;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_menu_settings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONFIGURA��ES DO APP\"`]")
    private MobileElement botaoConfiguracoesDoApp;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_menu_terms")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"TERMOS E CONDI��ES\"`]")
    private MobileElement botaoTermosECondicoes;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector())" +
            ".scrollIntoView(new UiSelector().resourceId(\"br.com.bradesco.next:id/nbt_menu_reorder\"));")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"REORGANIZAR MENU\"`]")
    private MobileElement botaoReorganizarMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Mimos\"]/parent::XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'MIMOS')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Mimos')]")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"MIMOS\"]")
    private MobileElement botaoMimos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Comprovantes\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"COMPROVANTES\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Comprovantes')]")
    private MobileElement botaoComprovantes;

    @iOSXCUITFindBy(accessibility = "PARCERIAS")
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector())" +
            ".scrollIntoView(new UiSelector().resourceId(\"br.com.bradesco.next:id/nbt_menu_partner_cashback\"));")
    private MobileElement botaoIndiqueAmigos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/image_view_menu_profile_photo")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"foto\"]")
    private MobileElement fotoCliente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Ver perfil")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver perfil\"`]")
    private MobileElement botaoVerPerfil;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'INVESTIMENTOS']")
    @AndroidFindBy(xpath = "//*[contains(@text,'Investimentos')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Investimentos\"]/parent::XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'INVESTIMENTOS')]")
    private MobileElement botaoInvestimentos;

    /**
     * Tocar no bot�o "Saldo e Extrato"
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"SALDO E EXTRATO\"")
    public MenuTela tocarMenuSaldoExtrato() throws Exception {
        if (!verificarPresencaElemento(botaoSaldoExtrato))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSaldoExtrato, "N�o foi poss�vel encontrar o bot�o 'Saldo e Extrato'");
        }
        salvarEvidencia("Visualizar o bot�o 'Saldo e Extrato'");
        tocarElemento(botaoSaldoExtrato, "N�o foi poss�vel tocar no bot�o 'Saldo e Extrato'" );
        salvarEvidencia( "Tocar no bot�o 'Saldo e Extrato'" );
        return this;
    }

    /**
     * Tocar no bot�o "Transfer�ncia"
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"TRANSFER�NCIA\"")
    public MenuTela tocarMenuTransferencia() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTransferencia,"Erro ao rolar tela para encontrar bot�o transfer�ncia");
        salvarEvidencia( "Visualizar o bot�o 'Transfer�ncia'" );
        tocarElemento(botaoTransferencia, "N�o foi poss�vel tocar no bot�o 'Transfer�ncia'" );
        salvarEvidencia( "Tocar no bot�o 'Transfer�ncia'" );
        return this;
    }

    /**
     * Tocar no bot�o "Recarga Celular"
     * @throws Exception
     * @return MenuTela
     */
    @Step ("Tocar no bot�o \"RECARGA CELULAR\"")
    public MenuTela tocarMenuRecarga() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRecarga,"N�o foi poss�vel localizar o bot�o 'Recarga'");
        salvarEvidencia("Tocar o bot�o 'Recarga Celular'");
        tocarElemento(botaoRecarga, "N�o foi poss�vel tocar no bot�o 'Recarga Celular'" );
        return this;
    }

    /**
     * Tocar no bot�o 'Dep�sitos e Saques'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"DEP�SITOS E SAQUES\"")
    public MenuTela tocarMenuDepositosSaques() throws Exception {
        if (!verificarPresencaElemento(botaoDepositosSaques))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDepositosSaques, "Bot�o 'Dep�sitos e Saques' n�o encontrado");
        }

        salvarEvidencia( "Visualizar o bot�o 'Dep�sitos e Saques'" );
        tocarElemento(botaoDepositosSaques, "N�o foi poss�vel tocar no bot�o 'Dep�sitos e Saques'");
        salvarEvidencia( "Tocar no bot�o 'Dep�sitos e Saques'" );
        return this;
    }

    /**
     * Tocar no bot�o 'Trazer Salario'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"TRAZER SAL�RIO\"")
    public MenuTela tocarMenuTrazerSalario() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTrazerSalario,"N�o foi poss�vel encontrar o bot�o 'Trazer Sal�rio'");
        salvarEvidencia( "Visualizar o bot�o 'Trazer Sal�rio'" );
        tocarElemento(botaoTrazerSalario, "N�o foi poss�vel tocar no bot�o 'Trazer Sal�rio'" );
        aguardarOcultacaoElemento(botaoTrazerSalario);
        salvarEvidencia( "Tocar no bot�o 'Trazer Sal�rio'" );
        return this;
    }

    /**
     * Tocar Bot�o 'Parceiros'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"PARCEIROS\"")
    public MenuTela tocarMenuParceiros() throws Exception{
        if(!verificarPresencaElemento(botaoParceiros))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoParceiros, "N�o foi poss�vel contrar o bot�o 'Parceiros'");
        }

        salvarEvidencia("Visualizar bot�o 'Parceiros'");
        tocarElemento(botaoParceiros, "N�o foi poss�vel tocar no bot�o 'Parceiros'");
        salvarEvidencia("Tocar no bot�o 'Parceiros'");
        return this;
    }
    /**
     * Tocar Bot�o 'Indique Amigos'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"Indique Amigos\"")
    public MenuTela tocarMenuIndiqueAmigos() throws Exception{
        rolarTelaAteFinal();
        salvarEvidencia("Visualizar bot�o 'indique Amigos'");
        tocarElemento(botaoIndiqueAmigos, "N�o foi poss�vel tocar no bot�o 'Indique Amigos'");
        salvarEvidencia("Tocar no bot�o 'Indique Amigos'");
        return this;
    }

    /**
     * Tocar no bot�o 'Vaquinha'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"VAQUINHA\"")
    public MenuTela tocarMenuVaquinha() throws Exception {
        if (!verificarPresencaElemento(botaoVaquinha))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVaquinha,"N�o foi poss�vel encontrar o bot�o 'Vaquinha'");
        }

        salvarEvidencia("Visualizar o bot�o 'Vaquinha'");
        tocarElemento(botaoVaquinha, "N�o foi poss�vel tocar no bot�o 'Vaquinha'");
        salvarEvidencia("Tocar no bot�o 'Vaquinha'");
        return this;
    }

    /**
     * Tocar no bot�o 'Sair'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"Sair\"")
    public MenuTela tocarMenuSair() throws Exception {
        if (!verificarPresencaElemento(botaoSair))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSair,"N�o foi poss�vel encontrar o bot�o 'Sair'");
        }

        salvarEvidencia("Visualizar o bot�o 'Sair'");
        tocarElemento(botaoSair, "N�o foi poss�vel tocar no bot�o 'Sair'");
        salvarEvidencia("Tocar o bot�o 'Sair'");
        return this;
    }

    /**
     * Tocar no bot�o 'Notifica��es'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"Notifica��es\"")
    public MenuTela tocarMenuNotificacoes() throws Exception {
        aguardarCarregamentoElemento(botaoNotificacoes);

        salvarEvidencia("Visualizar bot�o 'Notifica��es'");
        tocarElemento(botaoNotificacoes, "N�o foi poss�vel tocar no bot�o 'Notifica��es'");
        salvarEvidencia("Tocar no bot�o 'Notifica��es'");
        return this;
    }

    /**
     * Tocar no bot�o 'Sim' em Notifica��es
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"Sim\" em Notifica��es")
    public MenuTela tocarBotaoSimPopUp() throws Exception {
        aguardarCarregamentoElemento(botaoSimPopup);

        tocarElemento(botaoSimPopup, "N�o foi poss�vel tocar no bot�o 'Sim'");
        salvarEvidencia("Tocar no bot�o 'Sim'");
        return this;
    }

    /**
     * Tocar no bot�o 'Protecao'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"PROTE��O\"")
    public MenuTela clicarMenuProtecao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoProtecao,"N�o foi poss�vel encontrar o bot�o 'Prote��o'");
        salvarEvidencia( "Visualizar o bot�o 'Prote��o'" );
        tocarElemento(botaoProtecao, "N�o foi poss�vel tocar no bot�o 'Prote��o'" );
        salvarEvidencia( "Tocar no bot�o 'Prote��o'" );
        return this;
    }

    /**
     * Tocar no bot�o 'Investimentos'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o bot�o Investimentos")
    public MenuTela clicarMenuInvestimentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos,"N�o foi poss�vel encontrar o menu 'Investimentos'");
        salvarEvidencia( "Tocar no menu 'Investimentos'");
        tocarElemento(botaoInvestimentos, "N�o foi poss�vel tocar no menu 'Investimentos'" );
        return this;
    }

    /**
     * Tocar Bot�o 'CONFIGURA��ES DO APP'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"CONFIGURA��ES DO APP\"")
    public MenuTela tocarBotaoConfiguracoesApp() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesDoApp, "N�o foi poss�vel encontrar o bot�o 'Configura��es do APP'");
        salvarEvidencia("Visualizar bot�o 'Configura��es do APP'");
        tocarElemento(botaoConfiguracoesDoApp, "N�o foi poss�vel tocar no bot�o 'Configura��es do APP'");
        salvarEvidencia("Tocar no bot�o 'Configura��es do APP'");
        return this;
    }

    /**
     * Tocar Bot�o 'TERMOS E CONDI��ES'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"TERMOS E CONDI��ES\"")
    public MenuTela tocarBotaoTermosECondicoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTermosECondicoes,"N�o foi poss�vel encontrar o bot�o 'Termos e Condi��es'" );
        salvarEvidencia("Visualizar bot�o \"TERMOS E CONDI��ES\"");
        tocarElemento(botaoTermosECondicoes, "N�o foi poss�vel tocar no bot�o 'TERMOS E CONDI��ES'");
        salvarEvidencia("Tocar no bot�o 'TERMOS E CONDI��ES'");
        return this;
    }

    /**
     * Tocar Bot�o 'REORGANIZAR MENU'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"REORGANIZAR MENU\"")
    public MenuTela tocarBotaoReorganizarMenu() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoReorganizarMenu, "N�o foi poss�vel localizar o bot�o 'Reorganizar Menu'");
        salvarEvidencia("Visualizar o bot�o \"REORGANIZAR MENU\"");
        tocarElemento(botaoReorganizarMenu, "N�o foi poss�vel tocar no bot�o 'REORGANIZAR MENU'");
        salvarEvidencia("Tocar no bot�o 'REORGANIZAR MENU'");
        return this;
    }

    /**
     * Validar Menu n�o exibe bot�o 'PARCEIROS'
     *
     * @return
     */
    @Step("Validar Menu n�o exibe bot�o \"PARCEIROS\"")
    public MenuTela validarMenuSemParceiros() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoReorganizarMenu, "Bot�o 'Reorganizar Menu' n�o encontrado");
        salvarEvidencia("Menu n�o exibe op��o 'Indique Amigos'");
        validarCondicaoBooleana(verificarPresencaElemento(botaoIndiqueAmigos),MetodoComparacaoBooleano.FALSO,"Menu 'Indique um Amigo' encontrado, para este CT n�o deveria exibir. 'ERRO'");
        salvarEvidencia("Confirma��o da n�o existencia do Menu Indique Amigos, n�o exibe.'");

        if(aguardarCarregamentoElemento(botaoParceiros)) {
            throw new AssertionError("Bot�o Indique Amigos Encontrado na tela");
        }else{
            salvarEvidencia("Menu n�o exibe op��o 'Indique Amigos'");
        }
        return this;
    }

    /**
     * Tocar bot�o Mimos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"MIMOS\"")
    public MenuTela tocarBotaoMimos() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "N�o foi poss�vel encontrar o bot�o 'Mimos'");
        salvarEvidencia("Visualizar bot�o 'Mimos'");
        tocarElemento(botaoMimos, "N�o foi poss�vel tocar no bot�o 'Mimos'" );
        salvarEvidencia( "Tocar no bot�o 'Mimos'" );
        return this;
    }

    /**
     * Tocar bot�o Mimos sem salvar em evid�ncia
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"MIMOS\" sem evidencia")
    public MenuTela tocarBotaoMimosSemEvidencia() throws Exception{
        if (!verificarPresencaElemento(botaoMimos))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "N�o foi poss�vel encontrar o bot�o 'Mimos'");
        }
        tocarElemento(botaoMimos, "N�o foi poss�vel tocar no bot�o 'Mimos'" );
        return this;
    }

    /**
     * Tocar bot�o Comprovantes
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"COMPROVANTES\"")
    public MenuTela tocarBotaoComprovantes() throws Exception{
        if (!verificarPresencaElemento(botaoComprovantes))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComprovantes, "N�o foi poss�vel encontrar o bot�o 'Mimos'");
        }

        salvarEvidencia("Visualizar bot�o 'Comprovantes'");
        tocarElemento(botaoComprovantes, "N�o foi poss�vel tocar no bot�o 'Comprovantes'" );
        salvarEvidencia( "Tocar no bot�o 'Comprovantes'" );
        return this;
    }

    /**
     * Validar Exibi��o de tela "Menu"
     * @return
     * @throws Exception
     */
    @Step("Validar Exibi��o de tela \"Menu\"")
    public MenuTela validarExibicaoTelaMenu() throws Exception{
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL);
        validarCondicaoBooleana(!textoEncontrado.isEmpty(), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o da tela de menu");
        salvarEvidencia("Tela de menu inicial validada");
        return this;
    }

    /**
     * Validar Exibi��o de tela "Menu" logo ap�s login
     * @return
     * @throws Exception
     */
    @Step("Validar Exibi��o de tela \"Menu\"")
    public MenuTela validarExibicaoTelaMenuAposLogin() throws Exception {
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL);
        validarCondicaoBooleana(!textoEncontrado.isEmpty(), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o da tela de menu");
        salvarEvidencia("Login Efetuado com Sucesso - Validar Exibi��o da tela de Menu do App");
        return this;
    }

    /**
     * Aguarda carregamento do bot�o notifica��es na tela de Menu
     * @return
     */
    public boolean verificarExibicaoBotaoNotificacoes() throws Exception {
        rolaTelaCima();
        return aguardarCarregamentoElemento(botaoNotificacoes);
    }

    /**
     * Tocar a foto do cliente
     * @throws Exception
     */
    @Step ("Tocar a foto do cliente")
    public MenuTela tocarFotoCliente() throws Exception {
        aguardarCarregamentoElemento(fotoCliente);
        salvarEvidencia("Tocar foto do cliente");
        //Alterado o m�todo para utilizar diretamente o click para agilizar o processo durante o login
        try {
            fotoCliente.click();
        } catch (Exception ex) {
            throw new NextException(this, ex.getMessage(), ex);
        } catch (Error er) {
            throw new NextError(this, er.getMessage(), er);
        }
        return this;
    }

    /**
     * Tocar no bot�o ver perfil
     * @throws Exception
     */
    @Step ("Tocar no bot�o ver perfil")
    public MenuTela tocarBotaoVerPerfil() throws Exception {
        salvarEvidencia("Tocar no bot�o ver perfil");
        tocarElemento(botaoVerPerfil, "N�o foi poss�vel tocar no bot�o ver perfil");
        return this;
    }

    /**
     * Tocar no bot�o "Menu Objetivos"
     * @throws Exception
     */
    @Step ("Tocar o bot�o \"Objetivos\"")
    public MenuTela tocarMenuObjetivos() throws Exception {
        if (!verificarPresencaElemento(botaoObjetivos))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoObjetivos, "N�o foi poss�vel encontrar o bot�o 'Objetivos'");
        }
        salvarEvidencia("Visualizar o bot�o 'Objetivos'");
        tocarElemento(botaoObjetivos, "N�o foi poss�vel tocar no bot�o 'Objetivos'" );
        salvarEvidencia( "Tocar no bot�o 'Objetivos'" );
        return this;
    }
}
