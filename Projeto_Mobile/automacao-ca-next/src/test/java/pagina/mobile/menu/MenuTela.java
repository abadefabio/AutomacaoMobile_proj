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
    O elemento do menu de Transferência não tem funcionado no Next 137 com UiAutomator,
    embora funcione em demais aparelhos. Por enquanto, será melhor não utilizar UiAutomator
    para fazer a rolagem rápida até o elemento, que não é encontrado mais.
     */
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"TRANSFERÊNCIA\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Transferência')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"TRANSFERÊNCIA\"$]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'TRANSFERÊNCIA')]")
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
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"DEPÓSITOS E SAQUES\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Débitos e saques')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"DEPÓSITOS E SAQUES\"$]")
    private MobileElement botaoDepositosSaques;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"TRAZER SALÁRIO\"));")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"TRAZER SALÁRIO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"TRAZER SALÁRIO\"$]")
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
    @AndroidFindBy(xpath = "//*[@content-desc = \"Menu Notificações.\"]/preceding-sibling::android.widget.ImageView")
    @AndroidFindBy(accessibility = "Menu Notificações.")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS \"Menu Notificações\"")
    private MobileElement botaoNotificacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_menu_profile_arrow")
    @iOSXCUITFindBy(accessibility = "icon-gear")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-gear\"]")
    private MobileElement botaoEngrenagem;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_positive")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeButton\"  and name = \"Sim\"")
    private MobileElement botaoSimPopup;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"PROTEÇÃO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"PROTEÇÃO\"$]")
    private MobileElement botaoProtecao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_menu_partner_cashback")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='INDIQUE AMIGOS']")
    private MobileElement botaoParceiros;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_menu_settings")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONFIGURAÇÕES DO APP\"`]")
    private MobileElement botaoConfiguracoesDoApp;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_menu_terms")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"TERMOS E CONDIÇÕES\"`]")
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
     * Tocar no botão "Saldo e Extrato"
     * @throws Exception
     */
    @Step ("Tocar o botão \"SALDO E EXTRATO\"")
    public MenuTela tocarMenuSaldoExtrato() throws Exception {
        if (!verificarPresencaElemento(botaoSaldoExtrato))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSaldoExtrato, "Não foi possível encontrar o botão 'Saldo e Extrato'");
        }
        salvarEvidencia("Visualizar o botão 'Saldo e Extrato'");
        tocarElemento(botaoSaldoExtrato, "Não foi possível tocar no botão 'Saldo e Extrato'" );
        salvarEvidencia( "Tocar no botão 'Saldo e Extrato'" );
        return this;
    }

    /**
     * Tocar no botão "Transferência"
     * @throws Exception
     */
    @Step ("Tocar o botão \"TRANSFERÊNCIA\"")
    public MenuTela tocarMenuTransferencia() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTransferencia,"Erro ao rolar tela para encontrar botão transferência");
        salvarEvidencia( "Visualizar o botão 'Transferência'" );
        tocarElemento(botaoTransferencia, "Não foi possível tocar no botão 'Transferência'" );
        salvarEvidencia( "Tocar no botão 'Transferência'" );
        return this;
    }

    /**
     * Tocar no botão "Recarga Celular"
     * @throws Exception
     * @return MenuTela
     */
    @Step ("Tocar no botão \"RECARGA CELULAR\"")
    public MenuTela tocarMenuRecarga() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRecarga,"Não foi possível localizar o botão 'Recarga'");
        salvarEvidencia("Tocar o botão 'Recarga Celular'");
        tocarElemento(botaoRecarga, "Não foi possível tocar no botão 'Recarga Celular'" );
        return this;
    }

    /**
     * Tocar no botão 'Depósitos e Saques'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o botão \"DEPÓSITOS E SAQUES\"")
    public MenuTela tocarMenuDepositosSaques() throws Exception {
        if (!verificarPresencaElemento(botaoDepositosSaques))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDepositosSaques, "Botão 'Depósitos e Saques' não encontrado");
        }

        salvarEvidencia( "Visualizar o botão 'Depósitos e Saques'" );
        tocarElemento(botaoDepositosSaques, "Não foi possível tocar no botão 'Depósitos e Saques'");
        salvarEvidencia( "Tocar no botão 'Depósitos e Saques'" );
        return this;
    }

    /**
     * Tocar no botão 'Trazer Salario'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o botão \"TRAZER SALÁRIO\"")
    public MenuTela tocarMenuTrazerSalario() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTrazerSalario,"Não foi possível encontrar o botão 'Trazer Salário'");
        salvarEvidencia( "Visualizar o botão 'Trazer Salário'" );
        tocarElemento(botaoTrazerSalario, "Não foi possível tocar no botão 'Trazer Salário'" );
        aguardarOcultacaoElemento(botaoTrazerSalario);
        salvarEvidencia( "Tocar no botão 'Trazer Salário'" );
        return this;
    }

    /**
     * Tocar Botão 'Parceiros'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"PARCEIROS\"")
    public MenuTela tocarMenuParceiros() throws Exception{
        if(!verificarPresencaElemento(botaoParceiros))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoParceiros, "Não foi possível contrar o botão 'Parceiros'");
        }

        salvarEvidencia("Visualizar botão 'Parceiros'");
        tocarElemento(botaoParceiros, "Não foi possível tocar no botão 'Parceiros'");
        salvarEvidencia("Tocar no botão 'Parceiros'");
        return this;
    }
    /**
     * Tocar Botão 'Indique Amigos'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"Indique Amigos\"")
    public MenuTela tocarMenuIndiqueAmigos() throws Exception{
        rolarTelaAteFinal();
        salvarEvidencia("Visualizar botão 'indique Amigos'");
        tocarElemento(botaoIndiqueAmigos, "Não foi possível tocar no botão 'Indique Amigos'");
        salvarEvidencia("Tocar no botão 'Indique Amigos'");
        return this;
    }

    /**
     * Tocar no botão 'Vaquinha'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o botão \"VAQUINHA\"")
    public MenuTela tocarMenuVaquinha() throws Exception {
        if (!verificarPresencaElemento(botaoVaquinha))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVaquinha,"Não foi possível encontrar o botão 'Vaquinha'");
        }

        salvarEvidencia("Visualizar o botão 'Vaquinha'");
        tocarElemento(botaoVaquinha, "Não foi possível tocar no botão 'Vaquinha'");
        salvarEvidencia("Tocar no botão 'Vaquinha'");
        return this;
    }

    /**
     * Tocar no botão 'Sair'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o botão \"Sair\"")
    public MenuTela tocarMenuSair() throws Exception {
        if (!verificarPresencaElemento(botaoSair))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSair,"Não foi possível encontrar o botão 'Sair'");
        }

        salvarEvidencia("Visualizar o botão 'Sair'");
        tocarElemento(botaoSair, "Não foi possível tocar no botão 'Sair'");
        salvarEvidencia("Tocar o botão 'Sair'");
        return this;
    }

    /**
     * Tocar no botão 'Notificações'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o botão \"Notificações\"")
    public MenuTela tocarMenuNotificacoes() throws Exception {
        aguardarCarregamentoElemento(botaoNotificacoes);

        salvarEvidencia("Visualizar botão 'Notificações'");
        tocarElemento(botaoNotificacoes, "Não foi possível tocar no botão 'Notificações'");
        salvarEvidencia("Tocar no botão 'Notificações'");
        return this;
    }

    /**
     * Tocar no botão 'Sim' em Notificações
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"Sim\" em Notificações")
    public MenuTela tocarBotaoSimPopUp() throws Exception {
        aguardarCarregamentoElemento(botaoSimPopup);

        tocarElemento(botaoSimPopup, "Não foi possível tocar no botão 'Sim'");
        salvarEvidencia("Tocar no botão 'Sim'");
        return this;
    }

    /**
     * Tocar no botão 'Protecao'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o botão \"PROTEÇÃO\"")
    public MenuTela clicarMenuProtecao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoProtecao,"Não foi possível encontrar o botão 'Proteção'");
        salvarEvidencia( "Visualizar o botão 'Proteção'" );
        tocarElemento(botaoProtecao, "Não foi possível tocar no botão 'Proteção'" );
        salvarEvidencia( "Tocar no botão 'Proteção'" );
        return this;
    }

    /**
     * Tocar no botão 'Investimentos'
     * @return
     * @throws Exception
     */
    @Step ("Tocar o botão Investimentos")
    public MenuTela clicarMenuInvestimentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos,"Não foi possível encontrar o menu 'Investimentos'");
        salvarEvidencia( "Tocar no menu 'Investimentos'");
        tocarElemento(botaoInvestimentos, "Não foi possível tocar no menu 'Investimentos'" );
        return this;
    }

    /**
     * Tocar Botão 'CONFIGURAÇÕES DO APP'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"CONFIGURAÇÕES DO APP\"")
    public MenuTela tocarBotaoConfiguracoesApp() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesDoApp, "Não foi possível encontrar o botão 'Configurações do APP'");
        salvarEvidencia("Visualizar botão 'Configurações do APP'");
        tocarElemento(botaoConfiguracoesDoApp, "Não foi possível tocar no botão 'Configurações do APP'");
        salvarEvidencia("Tocar no botão 'Configurações do APP'");
        return this;
    }

    /**
     * Tocar Botão 'TERMOS E CONDIÇÕES'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"TERMOS E CONDIÇÕES\"")
    public MenuTela tocarBotaoTermosECondicoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTermosECondicoes,"Não foi possível encontrar o botão 'Termos e Condições'" );
        salvarEvidencia("Visualizar botão \"TERMOS E CONDIÇÕES\"");
        tocarElemento(botaoTermosECondicoes, "Não foi possível tocar no botão 'TERMOS E CONDIÇÕES'");
        salvarEvidencia("Tocar no botão 'TERMOS E CONDIÇÕES'");
        return this;
    }

    /**
     * Tocar Botão 'REORGANIZAR MENU'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"REORGANIZAR MENU\"")
    public MenuTela tocarBotaoReorganizarMenu() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoReorganizarMenu, "Não foi possível localizar o botão 'Reorganizar Menu'");
        salvarEvidencia("Visualizar o botão \"REORGANIZAR MENU\"");
        tocarElemento(botaoReorganizarMenu, "Não foi possível tocar no botão 'REORGANIZAR MENU'");
        salvarEvidencia("Tocar no botão 'REORGANIZAR MENU'");
        return this;
    }

    /**
     * Validar Menu não exibe botão 'PARCEIROS'
     *
     * @return
     */
    @Step("Validar Menu não exibe botão \"PARCEIROS\"")
    public MenuTela validarMenuSemParceiros() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoReorganizarMenu, "Botão 'Reorganizar Menu' não encontrado");
        salvarEvidencia("Menu não exibe opção 'Indique Amigos'");
        validarCondicaoBooleana(verificarPresencaElemento(botaoIndiqueAmigos),MetodoComparacaoBooleano.FALSO,"Menu 'Indique um Amigo' encontrado, para este CT não deveria exibir. 'ERRO'");
        salvarEvidencia("Confirmação da não existencia do Menu Indique Amigos, não exibe.'");

        if(aguardarCarregamentoElemento(botaoParceiros)) {
            throw new AssertionError("Botão Indique Amigos Encontrado na tela");
        }else{
            salvarEvidencia("Menu não exibe opção 'Indique Amigos'");
        }
        return this;
    }

    /**
     * Tocar botão Mimos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"MIMOS\"")
    public MenuTela tocarBotaoMimos() throws Exception{
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "Não foi possível encontrar o botão 'Mimos'");
        salvarEvidencia("Visualizar botão 'Mimos'");
        tocarElemento(botaoMimos, "Não foi possível tocar no botão 'Mimos'" );
        salvarEvidencia( "Tocar no botão 'Mimos'" );
        return this;
    }

    /**
     * Tocar botão Mimos sem salvar em evidência
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"MIMOS\" sem evidencia")
    public MenuTela tocarBotaoMimosSemEvidencia() throws Exception{
        if (!verificarPresencaElemento(botaoMimos))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "Não foi possível encontrar o botão 'Mimos'");
        }
        tocarElemento(botaoMimos, "Não foi possível tocar no botão 'Mimos'" );
        return this;
    }

    /**
     * Tocar botão Comprovantes
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"COMPROVANTES\"")
    public MenuTela tocarBotaoComprovantes() throws Exception{
        if (!verificarPresencaElemento(botaoComprovantes))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoComprovantes, "Não foi possível encontrar o botão 'Mimos'");
        }

        salvarEvidencia("Visualizar botão 'Comprovantes'");
        tocarElemento(botaoComprovantes, "Não foi possível tocar no botão 'Comprovantes'" );
        salvarEvidencia( "Tocar no botão 'Comprovantes'" );
        return this;
    }

    /**
     * Validar Exibição de tela "Menu"
     * @return
     * @throws Exception
     */
    @Step("Validar Exibição de tela \"Menu\"")
    public MenuTela validarExibicaoTelaMenu() throws Exception{
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL);
        validarCondicaoBooleana(!textoEncontrado.isEmpty(), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela de menu");
        salvarEvidencia("Tela de menu inicial validada");
        return this;
    }

    /**
     * Validar Exibição de tela "Menu" logo após login
     * @return
     * @throws Exception
     */
    @Step("Validar Exibição de tela \"Menu\"")
    public MenuTela validarExibicaoTelaMenuAposLogin() throws Exception {
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL);
        validarCondicaoBooleana(!textoEncontrado.isEmpty(), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela de menu");
        salvarEvidencia("Login Efetuado com Sucesso - Validar Exibição da tela de Menu do App");
        return this;
    }

    /**
     * Aguarda carregamento do botão notificações na tela de Menu
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
        //Alterado o método para utilizar diretamente o click para agilizar o processo durante o login
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
     * Tocar no botão ver perfil
     * @throws Exception
     */
    @Step ("Tocar no botão ver perfil")
    public MenuTela tocarBotaoVerPerfil() throws Exception {
        salvarEvidencia("Tocar no botão ver perfil");
        tocarElemento(botaoVerPerfil, "Não foi possível tocar no botão ver perfil");
        return this;
    }

    /**
     * Tocar no botão "Menu Objetivos"
     * @throws Exception
     */
    @Step ("Tocar o botão \"Objetivos\"")
    public MenuTela tocarMenuObjetivos() throws Exception {
        if (!verificarPresencaElemento(botaoObjetivos))
        {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoObjetivos, "Não foi possível encontrar o botão 'Objetivos'");
        }
        salvarEvidencia("Visualizar o botão 'Objetivos'");
        tocarElemento(botaoObjetivos, "Não foi possível tocar no botão 'Objetivos'" );
        salvarEvidencia( "Tocar no botão 'Objetivos'" );
        return this;
    }
}
