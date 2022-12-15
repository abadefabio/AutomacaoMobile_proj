package pagina.mobile.jornadas.menu;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.login.LoginApp;
import framework.MobileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MenuTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    /*
    O elemento do menu de Transferência não tem funcionado no Next 137 com UiAutomator,
    embora funcione em demais aparelhos. Por enquanto, será melhor não utilizar UiAutomator
    para fazer a rolagem rápida até o elemento, que não é encontrado mais.
     */
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"TRANSFERÊNCIA\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Transferência')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"TRANSFERÊNCIA\"$]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Transferencia\"]/..")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'TRANSFERÊNCIA')]")
    @iOSXCUITFindBy(id = "newMenu-Transferencia")
    private MobileElement botaoTransferencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"RECARGA CELULAR\"));")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"RECARGA CELULAR\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Recarga celular')]")
    @iOSXCUITFindBy(xpath = "//*[@name = \"newMenu-RecargaCelular\"]/..")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"RECARGA CELULAR\"$]")
    private MobileElement botaoRecarga;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"SALDO E EXTRATO\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Saldo e extrato') or contains(@text,'Extrato')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"SALDO E EXTRATO\"$]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'SALDO E EXTRATO')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Saldo e extrato') or contains(@name,'Extrato')]")
    private MobileElement botaoSaldoExtrato;


    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"OBJETIVOS\"]")
    @AndroidFindBy(accessibility = "Objetivos")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Objetivos')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Objetivos\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"OBJETIVOS\"$]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'OBJETIVOS')]")
    private MobileElement botaoObjetivos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and upper-case(@text) = \"DEPÓSITOS E SAQUES\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Débitos e saques')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"Depósitos e saques\"$]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-DepositoSaques\"]/../..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-DepositoSaques\"]/..")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"DEPÓSITOS E SAQUES\"$]")
    private MobileElement botaoDepositosSaques;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"TRAZER SALÁRIO\"));")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"TRAZER SALÁRIO\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Trazer salário')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-TrazerSalario\"]/../..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-TrazerSalario\"]/..")
    private MobileElement botaoTrazerSalario;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Vaquinha\"]/..")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"VAQUINHA\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Vaquinha')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Vaquinha\"]/../..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Vaquinha\"]/..")
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
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Menu Notificações\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS \"Menu Notificações\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1]")
    private MobileElement botaoNotificacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_menu_profile_arrow")
    @iOSXCUITFindBy(accessibility = "icon-gear")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-gear\"]")
    private MobileElement botaoEngrenagem;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Seguros\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Seguros')]")
    private MobileElement botaoSeguros;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Mimos\"]/..")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'MIMOS')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Mimos')]")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"MIMOS\"]")
    private MobileElement botaoMimos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Comprovantes\"]/parent::XCUIElementTypeOther")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"COMPROVANTES\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Comprovantes')]")
    private MobileElement botaoComprovantes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "PARCERIAS")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_menu_partner_cashback")
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector())" +
            ".scrollIntoView(new UiSelector().resourceId(\"br.com.bradesco.next:id/nbt_menu_partner_cashback\"));")
    private MobileElement botaoParcerias;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/image_view_menu_profile_photo")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"foto\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver perfil\"`]")
    private MobileElement fotoCliente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/constraint_layout_menu_profile")
    @iOSXCUITFindBy(accessibility = "Ver perfil")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver perfil\"`]")
    private MobileElement botaoVerPerfil;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Investimentos\"]/..")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'INVESTIMENTOS']")
    @AndroidFindBy(xpath = "//*[contains(@text,'Investimentos')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'INVESTIMENTOS']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Investimentos\"]/parent::XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"new-investment-menu\"]/parent::XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Investimentos\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Investimentos')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'INVESTIMENTOS')]")
    private MobileElement botaoInvestimentos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_description_nt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Uhu! Você mandou bem demais! Objetivo concluído.\"`][1]")
    private MobileElement mensagemNotificao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nt_know_more_nt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver mais em jornada de Objetivos\"`][1]")
    private MobileElement botaoVerMais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_see_more")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver mais \"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ver mais\"]")
    @iOSXCUITFindBy(accessibility = "Ver mais serviços do next")
    private MobileElement botaoVerMaisMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'Pagar']")
    @AndroidFindBy(xpath = "//*[contains(@text,'Pagamentos') or contains(@text,'Pagar')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Pagar') or contains(@value,'Pagar')]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Pagamentos')])[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[8]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"newMenu-PagarConta\"])[2]")
    private MobileElement botaoPagamentos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/text_view_menu_toolbar_help")
    @AndroidFindBy(xpath = "//*[@text ='AJUDA']")
    @iOSXCUITFindBy(accessibility = "AJUDA")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'AJUDA'`]")
    private MobileElement botaoAjuda;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "icon ballon chat")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'icon ballon chat'`]")
    private MobileElement iconeBubbleChat;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='Flow']")
    @iOSXCUITFindBy(xpath = "//*[@name = \"newMenu-Flow\"]/..")
    private MobileElement botaoFlow;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Empréstimos')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'CRÉDITO')]")
    @AndroidFindBy(accessibility = "CRÉDITO na posição linha 5 coluna 2. Toque para acessar. Toque e segure para mover para uma nova posição.")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"CRÉDITO na posição linha 5 coluna 2. Toque para acessar. Toque e segure para mover para uma nova posição.\"]")
    @AndroidFindBy(xpath = "//*[@text='Crédito']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Empréstimos')]")
    @iOSXCUITFindBy(xpath = "//*[@name = \"newMenu-Credito\"]/..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Credito\"]/..")
    @iOSXCUITFindBy(accessibility = "CRÉDITO, na linha 6 coluna 1. Toque para acessar. Toque e segure para mover para uma nova posição.")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CRÉDITO')]")
    private MobileElement botaoEmprestimos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Cartão\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cartão']")
    @AndroidFindBy(xpath = "//*[@text='Cartão']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Cartão\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"CARTÃO\"$]")
    @iOSXCUITFindBy(accessibility = "newMenu-Cartao")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CARTÃO')]")
    private MobileElement botaoCartao;

    @AndroidFindBy(xpath = "(//*[@resource-id='br.com.bradesco.next:id/tv_description_nt'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Poxa, Fulano não aceitou a vaquinha :(\"])[1]")
    private MobileElement botaoNotificacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Doações\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Doações')]")
    private MobileElement botaoDoacoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/menu_degustation_banner_image")
    @AndroidFindBy(xpath = "//android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'banne')]/preceding-sibling::XCUIElementTypeStaticText)[2]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeImage\"")
    private MobileElement botaoCompleteSeuCadastro;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='nextJoy']")
    @AndroidFindBy(xpath = "//*[contains(@text,'nextJoy')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"nextJoy\"$]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'nextJoy')]")
    private MobileElement botaoNextJoy;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Ver saldo")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ver saldo\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_show_hide_balance_hide")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Toque para mostrar.\"]")
    private MobileElement botaoExibirSaldo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"R$\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, \"R$\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@value, \"R$\")]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/text_view_menu_balance_show")
    private MobileElement saldoDaConta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Pix\"));")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Pix\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Pix')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Pix')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name='brand_banking_instant_payment_pix'])[1]")
    @iOSXCUITFindBy(xpath = "//*[@name = \"newPix\"]/..")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"Pix\"$]")
    private MobileElement botaoPix;

    @AndroidFindBy(xpath = "//*[contains(@text,'NextShop')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Novo. nextShop')]")
    private MobileElement botaoNextShop;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Open finance\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Open finance')]")
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Open finance\"));")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Open finance')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"Open finance\"$]")
    private MobileElement openFinance;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Poupança\"]")
    @iOSXCUITFindBy(accessibility = "brand_poupanca")
    private MobileElement botaoPoupanca;

    @AndroidFindBy(xpath = "//*[@text='VER DEPOIS']")
    @iOSXCUITFindBy(xpath = "//*[@name='VER DEPOIS']")
    private MobileElement botaVerDepoisCreditoParcelado;

    public MenuTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no botão "Saldo e Extrato"
     *
     * @throws Exception
     */
    @Step("Tocar o botão \"SALDO E EXTRATO\"")
    public MenuTela tocarMenuSaldoExtrato() throws Exception {
        if (ios) {
            rolarTelaParaCimaAosPoucosAteEncontrarElemento(botaoAjuda, "Nao foi possivel encontrar botao 'Saldos e Extratos'");
        }
        if (!verificarPresencaElemento(botaoSaldoExtrato)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSaldoExtrato, "Não foi possível encontrar o botão 'Saldo e Extrato'");
        }
        salvarEvidencia("Visualizar o botão 'Saldo e Extrato'");
        tocarElemento(botaoSaldoExtrato, "Não foi possível tocar no botão 'Saldo e Extrato'");
        salvarEvidencia("Tocar no botão 'Saldo e Extrato'");
        return this;
    }

    /**
     * Tocar no botão "Transferência"
     *
     * @throws Exception
     */
    @Step("Tocar o botão \"TRANSFERÊNCIA\"")
    public MenuTela tocarMenuTransferencia() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTransferencia, "Erro ao rolar tela para encontrar botão transferência");
        salvarEvidencia("Visualizar o botão 'Transferência'");
        tocarElemento(botaoTransferencia, "Não foi possível tocar no botão 'Transferência'");
        if (!aguardarOcultacaoElemento(botaoTransferencia)) {
            tocarElemento(botaoTransferencia, "Não foi possível tocar no botão 'Transferência'");
        }
        esperarCarregando();
        salvarEvidencia("Tocar no botão 'Transferência'");
        return this;
    }

    /**
     * Tocar no botão "Recarga Celular"
     *
     * @return MenuTela
     * @throws Exception
     */
    @Step("Tocar no botão \"RECARGA CELULAR\"")
    public MenuTela tocarMenuRecarga() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRecarga, "Não foi possível localizar o botão 'Recarga'");
        salvarEvidencia("Tocar o botão 'Recarga Celular'");
        tocarElemento(botaoRecarga, "Não foi possível tocar no botão 'Recarga Celular'");
        return this;
    }

    /**
     * Tocar no botão 'Depósitos e Saques'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"DEPÓSITOS E SAQUES\"")
    public MenuTela tocarMenuDepositosSaques() throws Exception {
        if (!verificarPresencaElemento(botaoDepositosSaques)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDepositosSaques, "Botão 'Depósitos e Saques' não encontrado");
        }

        salvarEvidencia("Visualizar o botão 'Depósitos e Saques'");
        tocarElemento(botaoDepositosSaques, "Não foi possível tocar no botão 'Depósitos e Saques'");
        salvarEvidencia("Tocar no botão 'Depósitos e Saques'");
        return this;
    }

    /**
     * Tocar no botão 'Trazer Salario'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"TRAZER SALÁRIO\"")
    public MenuTela tocarMenuTrazerSalario() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTrazerSalario, "Não foi possível encontrar o botão 'Trazer Salário'");
        salvarEvidencia("Visualizar o botão 'Trazer Salário'");
        tocarElemento(botaoTrazerSalario, "Não foi possível tocar no botão 'Trazer Salário'");
        aguardarOcultacaoElemento(botaoTrazerSalario);
        salvarEvidencia("Tocar no botão 'Trazer Salário'");
        return this;
    }

    /**
     * Tocar Botão 'Parceiros'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"PARCEIROS\"")
    public MenuTela tocarMenuParceiros() throws Exception {
        if (!verificarPresencaElemento(botaoParceiros)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoParceiros, "Não foi possível contrar o botão 'Parceiros'");
        }

        salvarEvidencia("Visualizar botão 'Parceiros'");
        tocarElemento(botaoParceiros, "Não foi possível tocar no botão 'Parceiros'");
        salvarEvidencia("Tocar no botão 'Parceiros'");
        return this;
    }

    /**
     * Tocar Botão 'Parcerias'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão 'Parcerias'")
    public MenuTela tocarMenuParcerias() throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoParcerias, "Não foi possível encontrar o botão 'Parcerias'!");
        salvarEvidencia("Visualizar botão 'Parcerias'");
        tocarElemento(botaoParcerias, "Não foi possível tocar no botão 'Parcerias'");
        salvarEvidencia("Tocar no botão 'Parcerias'");
        return this;
    }

    /**
     * Tocar Botão 'Flow'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão 'Flow''")
    public MenuTela tocarFlow() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Visualizar botão 'Flow'");
        tocarElemento(botaoFlow, "Não foi possível tocar no botão 'Flow'");
        salvarEvidencia("Tocar no botão 'Flow'");
        return this;
    }

    /**
     * Tocar no botão 'Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"VAQUINHA\"")
    public MenuTela tocarMenuVaquinha() throws Exception {
        if (!verificarPresencaElemento(botaoVaquinha)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVaquinha, "Não foi possível encontrar o botão 'Vaquinha'");
        }

        salvarEvidencia("Visualizar o botão 'Vaquinha'");
        tocarElemento(botaoVaquinha, "Não foi possível tocar no botão 'Vaquinha'");
        salvarEvidencia("Tocar no botão 'Vaquinha'");
        esperarCarregando();
        return this;
    }

    /**
     * Tocar no botão 'Sair'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"Sair\"")
    public MenuTela tocarMenuSair() throws Exception {
        if (!verificarPresencaElemento(botaoSair)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSair, "Não foi possível encontrar o botão 'Sair'");
        }

        salvarEvidencia("Tocar no botão 'Sair'");
        tocarElemento(botaoSair, "Não foi possível tocar no botão 'Sair'");
        return this;
    }

    /**
     * Tocar no botão 'Notificações'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"Notificações\"")
    public MenuTela tocarMenuNotificacoes() throws Exception {
        if (!aguardarCarregamentoElemento(botaoNotificacoes))
            rolaTelaCima();
        salvarEvidencia("Visualizar botão 'Notificações'");
        tocarElemento(botaoNotificacoes, "Não foi possível tocar no botão 'Notificações'");
        salvarEvidencia("Tocado no botão 'Notificações'");
        return this;
    }

    /**
     * Tocar no botão 'Seguros'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"Seguros\"")
    public MenuTela tocarMenuSeguros() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSeguros, "Não foi possível encontrar o botão 'Seguros'");
        salvarEvidencia("Tocar no botão 'Seguros'");
        tocarElemento(botaoSeguros, "Não foi possível tocar no botão 'Seguros'");
        return this;
    }

    /**
     * Tocar no botão 'Investimentos'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão Investimentos")
    public MenuTela clicarMenuInvestimentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos, "Não foi possível encontrar o botão 'Investimentos'");
        salvarEvidencia("Tocar o botão \"Investimentos\"");
        tocarElemento(botaoInvestimentos, "Não foi possível tocar no botão \"Investimentos\"");
        aguardarOcultacaoElemento(botaoInvestimentos);
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTermosECondicoes, "Não foi possível encontrar o botão 'Termos e Condições'");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSair, "Botão 'Reorganizar Menu' não encontrado");
        salvarEvidencia("Menu não exibe opção 'Indique Amigos'");
        validarCondicaoBooleana(verificarPresencaElemento(botaoParcerias), MetodoComparacaoBooleano.FALSO, "Menu 'Indique um Amigo' encontrado, para este CT não deveria exibir. 'ERRO'");
        salvarEvidencia("Confirmação da não existencia do Menu Indique Amigos, não exibe.'");

        if (aguardarCarregamentoElemento(botaoParceiros)) {
            throw new AssertionError("Botão Indique Amigos Encontrado na tela");
        } else {
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
    public MenuTela tocarBotaoMimos() throws Exception {
        if (android) {
            rolaTelaBaixo();
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "Não foi possível encontrar o botão 'Mimos'");
        } else {
            rolarTelaAteFinal();
        }
        salvarEvidencia("Tocar no botão 'Mimos'");
        tocarElemento(botaoMimos, "Não foi possível tocar no botão 'Mimos'");
        return this;
    }

    /**
     * Tocar botão Mimos sem salvar em evidência
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"MIMOS\" sem evidencia")
    public MenuTela tocarBotaoMimosSemEvidencia() throws Exception {
        if (!verificarPresencaElemento(botaoMimos)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "Não foi possível encontrar o botão 'Mimos'");
        }
        tocarElemento(botaoMimos, "Não foi possível tocar no botão 'Mimos'");
        return this;
    }

    /**
     * Tocar botão Comprovantes
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão \"COMPROVANTES\"")
    public MenuTela tocarBotaoComprovantes() throws Exception {
        int cont = 0;
        while (!verificarPresencaElemento(botaoComprovantes)) {
            cont++;
            rolarTela(0.8D, 0.2D);
            if (cont > 15) break;
        }
        salvarEvidencia("Visualizar botão 'Comprovantes'");
        tocarElemento(botaoComprovantes, "Não foi possível tocar no botão 'Comprovantes'");
        salvarEvidencia("Tocar no botão 'Comprovantes'");
        return this;
    }

    /**
     * Validar Exibição de tela "Menu"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Exibição de tela \"Menu\"")
    public MenuTela validarExibicaoTelaMenu() throws Exception {
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL);
        validarCondicaoBooleana(!textoEncontrado.isEmpty(), MetodoComparacaoBooleano.VERDADEIRO, "N?o foi poss?vel validar a exibi??o da tela de menu");
        salvarEvidencia("Tela de menu inicial validada");
        return this;
    }

    /**
     * Validar Exibição de tela "Menu" logo após login
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Exibição de tela \"Menu\"")
    public MenuTela validarExibicaoTelaMenuAposLogin() throws Exception {
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL);
       // validarCondicaoBooleana(Strings.isNotNullAndNotEmpty(textoEncontrado), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibção da tela de menu");
        salvarEvidencia("Login Efetuado com Sucesso - Validar Exibição da tela de Menu do App");
        return this;
    }

    /**
     * Fecha tela de clicar Sugestão de crédito parcelado
     *
     * @return
     * @throws Exception
     */
    @Step("Fecha tela de clicar Sugestão de crédito parcelado")
    public MenuTela fecharTelaCreditoParceladoInicio() {
        try {
            salvarEvidencia("Fechando tela de Sugestão de Crédito Parcelado se visível");
            retornaElemento(botaVerDepoisCreditoParcelado, 10).click();
        } catch (Exception ignore) {
            salvarEvidencia("   Ignorado");
        }
        return this;
    }

    /**
     * Aguarda carregamento do botão notificações na tela de Menu
     *
     * @return
     */
    public boolean verificarExibicaoBotaoNotificacoes() throws Exception {
        rolaTelaCima();
        return aguardarCarregamentoElemento(botaoNotificacoes);
    }

    /**
     * Tocar a foto do cliente
     *
     * @throws Exception
     */
    @Step("Tocar a foto do cliente")
    public MenuTela tocarFotoCliente() throws Exception {
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(fotoCliente, "Não foi possível encontrar a foto do cliente.");
        salvarEvidencia("Tocar foto do cliente");
        tocarElemento(fotoCliente, "Não foi possível tocar a foto do cliente");
        return this;
    }

    /**
     * Tocar no botão ver perfil
     *
     * @throws Exception
     */
    @Step("Tocar no botão ver perfil")
    public MenuTela tocarBotaoVerPerfil() throws Exception {
        salvarEvidencia("Tocar no botão ver perfil");
        tocarElemento(botaoVerPerfil, "Não foi possível tocar no botão ver perfil");
        return this;
    }

    /**
     * Tocar no botão "Menu Objetivos"
     *
     * @throws Exception
     */
    @Step("Tocar o botão \"Objetivos\"")
    public MenuTela tocarMenuObjetivos() throws Exception {
        if (!verificarPresencaElemento(botaoObjetivos)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoObjetivos, "Não foi possível encontrar o botão 'Objetivos'");
        }
        salvarEvidencia("Visualizar o botão 'Objetivos'");
        tocarElemento(botaoObjetivos, "Não foi possível tocar no botão 'Objetivos'");
        salvarEvidencia("Tocar no botão 'Objetivos'");
        return this;
    }

    /**
     * Validar "Mensagem Notificacao"
     *
     * @throws Exception
     */
    @Step("Validar \"Mensagem Notifcacao\"")
    public MenuTela mensagemNotificacao() throws Exception {
        aguardarCarregamentoElemento(mensagemNotificao);
        salvarEvidencia("Validar mensagem notificacao");
        verificarPresencaElemento(mensagemNotificao);
        return this;
    }

    /**
     * Tocar no botão "Ver Mais"
     *
     * @throws Exception
     */
    @Step("Tocar no botão \"Ver Mais\"")
    public MenuTela tocarBotaoVerMais() throws Exception {
        tocarElemento(botaoVerMais, "Não foi possível tocar em Ver Mais");
        salvarEvidencia("Tocar no botão Ver Mais");
        return this;
    }

    /**
     * Tocar no botão "Ver Mais" para expandir as opç?es do Menu
     *
     * @throws Exception
     */
    @Step("Tocar no botão \"Ver Mais\" para expandir as opç?es do Menu")
    public MenuTela tocarBotaoVerMaisMenu() throws Exception {
        aguardarCarregamentoElemento(botaoVerMaisMenu);
        tocarElemento(botaoVerMaisMenu, "Não foi possível tocar em Ver Mais para expandir o menu na Home");
        return this;
    }


    /**
     * Tocar no botão "PAGAMENTOS"
     *
     * @throws Exception
     */
    @Step("Tocar o botão \"PAGAMENTOS\"")
    public MenuTela tocarBotaoPagamentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagamentos, "Não foi possível encontrar o botão \"PAGAMENTOS\"");
        salvarEvidencia("Tocar botão \"PAGAMENTOS\"");
        tocarElemento(botaoPagamentos, "Ocorreu um erro ao executar a ação de tocar no botão \"PAGAMENTOS\"");
        return this;
    }

    /**
     * Tocar no botão "FLOW"
     *
     * @throws Exception
     */
    @Step("Tocar o botão \"FLOW\"")
    public MenuTela tocarBotaoFlow() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoFlow, "Não foi possível encontrar o botão \"FLOW\"");
        salvarEvidencia("Tocar botão \"FLOW\"");
        tocarElemento(botaoFlow, "Ocorreu um erro ao executar a ação de tocar no botão \"FLOW\"");
        return this;
    }

    /**
     * Método Criado para deslizar o Bubble do chat de ajuda, na tela de Menu, para o Botão fechar.
     *
     * @throws Exception
     */
    @Step("Método Criado para deslizar o Bubble do chat de ajuda, na tela de Menu, para o Botão fechar")
    public MenuTela moverIconeBubbleParaFechar() throws Exception {
        aguardarCarregamentoElemento(iconeBubbleChat);
        arrastarElementoProporcional(iconeBubbleChat, 10, 95);
        salvarEvidencia("Fechar Bubble do Chat");
        arrastarElementoProporcional(iconeBubbleChat, 51, 96, 9000);
        return this;
    }

    /**
     * Tocar no botão 'AJUDA'
     *
     * @throws Exception
     */
    @Step("Tocar o botão 'AJUDA'")
    public MenuTela tocarBotaoAjuda() throws Exception {
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(botaoAjuda, "Não foi possível encontrar o botão 'AJUDA'");
        salvarEvidencia("Tocar botão 'AJUDA'");
        tocarElemento(botaoAjuda, "Ocorreu um erro ao executar a ação de tocar no botão 'AJUDA'");
        return this;
    }

    /**
     * Tocar no botão 'Empréstimos'
     *
     * @throws Exception
     */
    @Step("Tocar o botão 'Empréstimos'")
    public MenuTela tocarBotaoEmprestimos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEmprestimos, "Não foi possível encontrar o botão 'Empréstimos'");
        salvarEvidencia("Tocar botão 'Empréstimos'");
        tocarElemento(botaoEmprestimos, "Não foi possível tocar no botão 'Empréstimos'");
        esperarCarregando();
        return this;
    }

    /**
     * "Validar que o Bubble do Chat não esta na tela"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar que o Bubble do Chat não esta na tela")
    public MenuTela validarAusenciaDoBubbleChatNaTelaDeMenu() {
        aguardarCarregamentoElemento(iconeBubbleChat);
        validarCondicaoBooleana(aguardarCarregamentoElemento(iconeBubbleChat), MetodoComparacaoBooleano.FALSO, "Bubble não foi fechado");
        salvarEvidencia("Bubble fechado, teste Finalizado");
        return this;
    }

    /**
     * Tocar no botão 'CARTÃO'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão 'CARTÃO'")
    public MenuTela tocarBotaoCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCartao, "Não foi possível encontrar o botão 'CARTÃO'");
        salvarEvidencia("Tocar botão 'CARTÃO'");
        tocarElemento(botaoCartao, "Não foi possível tocar no botão 'CARTÃO");
        return this;
    }

    /**
     * @param texto
     * @return
     */
    @Step("Validar mensagem notificacao")
    public MenuTela validarNotificacao(String texto) throws NextException {
        aguardarCarregamentoElemento(botaoNotificacao);
        esperarCarregando();
        String mensagem = MobileUtils.localizarTexto(texto);
        salvarEvidencia("Validando mensagem notificacao contendo: [" + texto + "], Encontrado: [" + mensagem + "]");
        validarCondicaoBooleana(mensagem.contains(texto), MetodoComparacaoBooleano.VERDADEIRO, "Nao foi possivel encontrar texto na tela.");
        salvarEvidencia("Validou a mensagem de notificacao: " + mensagem);

        return this;
    }

    /**
     * Tocar no botão 'DOAÇÕES'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão 'DOAÇÕES'")
    public MenuTela tocarBotaoDoacoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDoacoes, "Não foi possível encontrar o botão 'DOAÇÕES'");
        salvarEvidencia("Tocar botão 'Doações'");
        tocarElemento(botaoDoacoes, "Não foi possível tocar no botão 'DOAÇÕES");
        return this;
    }

    /**
     * 'tocar Botao Complete Seu Cadastro
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão 'Complete Seu Cadastro'")
    public MenuTela tocarBotaoCompleteSeuCadastro() throws Exception {
        salvarEvidencia("Tocar botão 'Complete Seu Cadastro'");
        tocarElemento(botaoCompleteSeuCadastro, "Não foi possível tocar no botão 'Complete Seu Cadastro");
        return this;
    }

    /**
     * Tocar no botão "NextJoy"
     *
     * @return MenuTela
     * @throws Exception
     */
    @Step("Tocar no botão \"NextJoy\"")
    public MenuTela tocarMenuNextJoy() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoNextJoy, "Não foi possível localizar o botão 'NextJoy'");
        salvarEvidencia("Tocar o botão 'NextJoy'");
        tocarElemento(botaoNextJoy, "Não foi possível tocar no botão 'NextJoy'");
        return this;
    }

    /**
     * Tocar no botão "Exibir Saldo"
     * fr
     * @return MenuTela
     * @throws Exception
     */
    @Step("Tocar no botão \"Exibir Saldo\"")
    public MenuTela tocarExibirSaldo() throws Exception {
        rolarTelaAteInicio();
        salvarEvidencia("Preparando para tocar o botão 'Exibir Saldo'");
        tocarElemento(botaoExibirSaldo, "Não foi possível tocar no botão 'Exibir Saldo' olhinho");
        aguardarCarregamentoElemento(botaoExibirSaldo);
        salvarEvidencia("Tocado botão 'Exibir Saldo'");
        return this;
    }

    /**
     * Comparar saldo final ao inicial para verificar se debitou o valor da aplicação"
     * fr
     * @return MenuTela
     * @throws Exception
     */
    @Step("validar \"Saldo Final\"")
    public MenuTela validarSaldoFinal(String saldo) throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Utilitarios.reformatarValorMonetario(saldo.toString())), MetodoComparacaoBooleano.VERDADEIRO, "Valor do saldo apresentado em tela não confere!");
        salvarEvidencia("'Validação do saldo com sucesso!'");
        return this;
    }


    /**
     * Retorna o valor disponível de saldo em conta para validar apos investimento efetuado
     * fr
     * @return
     * @throws Exception
     */
    @Step("Retorna o valor disponível de saldo em conta para validar apos investimento efetuado")
    public MenuTela retornarValorSaldoDisponivel(ThreadLocal valor) throws Exception {
        if (valor != null) {
            valor.set(Utilitarios.normalizaStringNumero(retornarTexto(saldoDaConta, "Não foi possível retornar valor disponível de saldo em conta")));
            OperadorEvidencia.logarPasso("Valor contido na thread: " + valor.get());
        }
        return this;
    }

    /**
     * Tocar no botão "Pix"
     *
     * @return MenuTela
     * @throws Exception
     */
    @Step("Tocar no botão \"Pix\"")
    public MenuTela tocarMenuPix() throws Exception {
        salvarEvidencia("Tocar o botão 'Pix'");
        tocarElemento(botaoPix, "Não foi possível tocar no botão 'Pix'");
        return this;
    }

    /**
     * tocar Botao nextShop
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão 'nextShop'")
    public MenuTela tocarBotaoNextShop() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoNextShop, "Não foi possível encontrar o botão 'NextShopS'");
        salvarEvidencia("Tocar botão 'NextShop'");
        tocarElemento(botaoNextShop, "Não foi possível tocar no botão 'NextShop");
        return this;
    }

    /**
     * tocar Botao openFinance
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão 'Open Finance'")
    public MenuTela tocarBotaoOpenFinance() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(openFinance, "Não foi possível encontrar o botão 'openFinance'");
        salvarEvidencia("Tocar botão Menu - 'Open Finance'");
        tocarElemento(openFinance, "Não foi possível tocar no botão 'openFinance");
        return this;
    }

    /**
     * Tocar no botão 'Poupança'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o botão Poupança")
    public MenuTela clicarMenuPoupanca() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPoupanca,"Não foi possível encontrar o botão 'Poupança'");
        salvarEvidencia("Tocar o botão \"Poupança\"");
        tocarElemento(botaoPoupanca, "Não foi possível tocar no bot?o \"Poupança\"");
        aguardarOcultacaoElemento(botaoPoupanca);
        return this;
    }

}
