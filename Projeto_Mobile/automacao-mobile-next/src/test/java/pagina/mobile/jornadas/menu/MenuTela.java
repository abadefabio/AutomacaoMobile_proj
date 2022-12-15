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
    O elemento do menu de Transfer�ncia n�o tem funcionado no Next 137 com UiAutomator,
    embora funcione em demais aparelhos. Por enquanto, ser� melhor n�o utilizar UiAutomator
    para fazer a rolagem r�pida at� o elemento, que n�o � encontrado mais.
     */
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"TRANSFER�NCIA\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Transfer�ncia')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"TRANSFER�NCIA\"$]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Transferencia\"]/..")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'TRANSFER�NCIA')]")
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
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and upper-case(@text) = \"DEP�SITOS E SAQUES\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'D�bitos e saques')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"Dep�sitos e saques\"$]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-DepositoSaques\"]/../..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-DepositoSaques\"]/..")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"DEP�SITOS E SAQUES\"$]")
    private MobileElement botaoDepositosSaques;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"TRAZER SAL�RIO\"));")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"TRAZER SAL�RIO\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Trazer sal�rio')]")
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
    @AndroidFindBy(xpath = "//*[@content-desc = \"Menu Notifica��es.\"]/preceding-sibling::android.widget.ImageView")
    @AndroidFindBy(accessibility = "Menu Notifica��es.")
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Menu Notifica��es\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS \"Menu Notifica��es\"")
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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Uhu! Voc� mandou bem demais! Objetivo conclu�do.\"`][1]")
    private MobileElement mensagemNotificao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nt_know_more_nt")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver mais em jornada de Objetivos\"`][1]")
    private MobileElement botaoVerMais;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_see_more")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ver mais \"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Ver mais\"]")
    @iOSXCUITFindBy(accessibility = "Ver mais servi�os do next")
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
    @AndroidFindBy(xpath = "//*[contains(@text,'Empr�stimos')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'CR�DITO')]")
    @AndroidFindBy(accessibility = "CR�DITO na posi��o linha 5 coluna 2. Toque para acessar. Toque e segure para mover para uma nova posi��o.")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"CR�DITO na posi��o linha 5 coluna 2. Toque para acessar. Toque e segure para mover para uma nova posi��o.\"]")
    @AndroidFindBy(xpath = "//*[@text='Cr�dito']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Empr�stimos')]")
    @iOSXCUITFindBy(xpath = "//*[@name = \"newMenu-Credito\"]/..")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"newMenu-Credito\"]/..")
    @iOSXCUITFindBy(accessibility = "CR�DITO, na linha 6 coluna 1. Toque para acessar. Toque e segure para mover para uma nova posi��o.")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CR�DITO')]")
    private MobileElement botaoEmprestimos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Cart�o\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cart�o']")
    @AndroidFindBy(xpath = "//*[@text='Cart�o']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Cart�o\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$ label contains \"CART�O\"$]")
    @iOSXCUITFindBy(accessibility = "newMenu-Cartao")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CART�O')]")
    private MobileElement botaoCartao;

    @AndroidFindBy(xpath = "(//*[@resource-id='br.com.bradesco.next:id/tv_description_nt'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Poxa, Fulano n�o aceitou a vaquinha :(\"])[1]")
    private MobileElement botaoNotificacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Doa��es\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Doa��es')]")
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

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/ntvMenuItemText\" and @text = \"Poupan�a\"]")
    @iOSXCUITFindBy(accessibility = "brand_poupanca")
    private MobileElement botaoPoupanca;

    @AndroidFindBy(xpath = "//*[@text='VER DEPOIS']")
    @iOSXCUITFindBy(xpath = "//*[@name='VER DEPOIS']")
    private MobileElement botaVerDepoisCreditoParcelado;

    public MenuTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no bot�o "Saldo e Extrato"
     *
     * @throws Exception
     */
    @Step("Tocar o bot�o \"SALDO E EXTRATO\"")
    public MenuTela tocarMenuSaldoExtrato() throws Exception {
        if (ios) {
            rolarTelaParaCimaAosPoucosAteEncontrarElemento(botaoAjuda, "Nao foi possivel encontrar botao 'Saldos e Extratos'");
        }
        if (!verificarPresencaElemento(botaoSaldoExtrato)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSaldoExtrato, "N�o foi poss�vel encontrar o bot�o 'Saldo e Extrato'");
        }
        salvarEvidencia("Visualizar o bot�o 'Saldo e Extrato'");
        tocarElemento(botaoSaldoExtrato, "N�o foi poss�vel tocar no bot�o 'Saldo e Extrato'");
        salvarEvidencia("Tocar no bot�o 'Saldo e Extrato'");
        return this;
    }

    /**
     * Tocar no bot�o "Transfer�ncia"
     *
     * @throws Exception
     */
    @Step("Tocar o bot�o \"TRANSFER�NCIA\"")
    public MenuTela tocarMenuTransferencia() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTransferencia, "Erro ao rolar tela para encontrar bot�o transfer�ncia");
        salvarEvidencia("Visualizar o bot�o 'Transfer�ncia'");
        tocarElemento(botaoTransferencia, "N�o foi poss�vel tocar no bot�o 'Transfer�ncia'");
        if (!aguardarOcultacaoElemento(botaoTransferencia)) {
            tocarElemento(botaoTransferencia, "N�o foi poss�vel tocar no bot�o 'Transfer�ncia'");
        }
        esperarCarregando();
        salvarEvidencia("Tocar no bot�o 'Transfer�ncia'");
        return this;
    }

    /**
     * Tocar no bot�o "Recarga Celular"
     *
     * @return MenuTela
     * @throws Exception
     */
    @Step("Tocar no bot�o \"RECARGA CELULAR\"")
    public MenuTela tocarMenuRecarga() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRecarga, "N�o foi poss�vel localizar o bot�o 'Recarga'");
        salvarEvidencia("Tocar o bot�o 'Recarga Celular'");
        tocarElemento(botaoRecarga, "N�o foi poss�vel tocar no bot�o 'Recarga Celular'");
        return this;
    }

    /**
     * Tocar no bot�o 'Dep�sitos e Saques'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"DEP�SITOS E SAQUES\"")
    public MenuTela tocarMenuDepositosSaques() throws Exception {
        if (!verificarPresencaElemento(botaoDepositosSaques)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDepositosSaques, "Bot�o 'Dep�sitos e Saques' n�o encontrado");
        }

        salvarEvidencia("Visualizar o bot�o 'Dep�sitos e Saques'");
        tocarElemento(botaoDepositosSaques, "N�o foi poss�vel tocar no bot�o 'Dep�sitos e Saques'");
        salvarEvidencia("Tocar no bot�o 'Dep�sitos e Saques'");
        return this;
    }

    /**
     * Tocar no bot�o 'Trazer Salario'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"TRAZER SAL�RIO\"")
    public MenuTela tocarMenuTrazerSalario() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTrazerSalario, "N�o foi poss�vel encontrar o bot�o 'Trazer Sal�rio'");
        salvarEvidencia("Visualizar o bot�o 'Trazer Sal�rio'");
        tocarElemento(botaoTrazerSalario, "N�o foi poss�vel tocar no bot�o 'Trazer Sal�rio'");
        aguardarOcultacaoElemento(botaoTrazerSalario);
        salvarEvidencia("Tocar no bot�o 'Trazer Sal�rio'");
        return this;
    }

    /**
     * Tocar Bot�o 'Parceiros'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"PARCEIROS\"")
    public MenuTela tocarMenuParceiros() throws Exception {
        if (!verificarPresencaElemento(botaoParceiros)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoParceiros, "N�o foi poss�vel contrar o bot�o 'Parceiros'");
        }

        salvarEvidencia("Visualizar bot�o 'Parceiros'");
        tocarElemento(botaoParceiros, "N�o foi poss�vel tocar no bot�o 'Parceiros'");
        salvarEvidencia("Tocar no bot�o 'Parceiros'");
        return this;
    }

    /**
     * Tocar Bot�o 'Parcerias'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o 'Parcerias'")
    public MenuTela tocarMenuParcerias() throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoParcerias, "N�o foi poss�vel encontrar o bot�o 'Parcerias'!");
        salvarEvidencia("Visualizar bot�o 'Parcerias'");
        tocarElemento(botaoParcerias, "N�o foi poss�vel tocar no bot�o 'Parcerias'");
        salvarEvidencia("Tocar no bot�o 'Parcerias'");
        return this;
    }

    /**
     * Tocar Bot�o 'Flow'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o 'Flow''")
    public MenuTela tocarFlow() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Visualizar bot�o 'Flow'");
        tocarElemento(botaoFlow, "N�o foi poss�vel tocar no bot�o 'Flow'");
        salvarEvidencia("Tocar no bot�o 'Flow'");
        return this;
    }

    /**
     * Tocar no bot�o 'Vaquinha'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"VAQUINHA\"")
    public MenuTela tocarMenuVaquinha() throws Exception {
        if (!verificarPresencaElemento(botaoVaquinha)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVaquinha, "N�o foi poss�vel encontrar o bot�o 'Vaquinha'");
        }

        salvarEvidencia("Visualizar o bot�o 'Vaquinha'");
        tocarElemento(botaoVaquinha, "N�o foi poss�vel tocar no bot�o 'Vaquinha'");
        salvarEvidencia("Tocar no bot�o 'Vaquinha'");
        esperarCarregando();
        return this;
    }

    /**
     * Tocar no bot�o 'Sair'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"Sair\"")
    public MenuTela tocarMenuSair() throws Exception {
        if (!verificarPresencaElemento(botaoSair)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSair, "N�o foi poss�vel encontrar o bot�o 'Sair'");
        }

        salvarEvidencia("Tocar no bot�o 'Sair'");
        tocarElemento(botaoSair, "N�o foi poss�vel tocar no bot�o 'Sair'");
        return this;
    }

    /**
     * Tocar no bot�o 'Notifica��es'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"Notifica��es\"")
    public MenuTela tocarMenuNotificacoes() throws Exception {
        if (!aguardarCarregamentoElemento(botaoNotificacoes))
            rolaTelaCima();
        salvarEvidencia("Visualizar bot�o 'Notifica��es'");
        tocarElemento(botaoNotificacoes, "N�o foi poss�vel tocar no bot�o 'Notifica��es'");
        salvarEvidencia("Tocado no bot�o 'Notifica��es'");
        return this;
    }

    /**
     * Tocar no bot�o 'Seguros'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"Seguros\"")
    public MenuTela tocarMenuSeguros() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSeguros, "N�o foi poss�vel encontrar o bot�o 'Seguros'");
        salvarEvidencia("Tocar no bot�o 'Seguros'");
        tocarElemento(botaoSeguros, "N�o foi poss�vel tocar no bot�o 'Seguros'");
        return this;
    }

    /**
     * Tocar no bot�o 'Investimentos'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o Investimentos")
    public MenuTela clicarMenuInvestimentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoInvestimentos, "N�o foi poss�vel encontrar o bot�o 'Investimentos'");
        salvarEvidencia("Tocar o bot�o \"Investimentos\"");
        tocarElemento(botaoInvestimentos, "N�o foi poss�vel tocar no bot�o \"Investimentos\"");
        aguardarOcultacaoElemento(botaoInvestimentos);
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTermosECondicoes, "N�o foi poss�vel encontrar o bot�o 'Termos e Condi��es'");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSair, "Bot�o 'Reorganizar Menu' n�o encontrado");
        salvarEvidencia("Menu n�o exibe op��o 'Indique Amigos'");
        validarCondicaoBooleana(verificarPresencaElemento(botaoParcerias), MetodoComparacaoBooleano.FALSO, "Menu 'Indique um Amigo' encontrado, para este CT n�o deveria exibir. 'ERRO'");
        salvarEvidencia("Confirma��o da n�o existencia do Menu Indique Amigos, n�o exibe.'");

        if (aguardarCarregamentoElemento(botaoParceiros)) {
            throw new AssertionError("Bot�o Indique Amigos Encontrado na tela");
        } else {
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
    public MenuTela tocarBotaoMimos() throws Exception {
        if (android) {
            rolaTelaBaixo();
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "N�o foi poss�vel encontrar o bot�o 'Mimos'");
        } else {
            rolarTelaAteFinal();
        }
        salvarEvidencia("Tocar no bot�o 'Mimos'");
        tocarElemento(botaoMimos, "N�o foi poss�vel tocar no bot�o 'Mimos'");
        return this;
    }

    /**
     * Tocar bot�o Mimos sem salvar em evid�ncia
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"MIMOS\" sem evidencia")
    public MenuTela tocarBotaoMimosSemEvidencia() throws Exception {
        if (!verificarPresencaElemento(botaoMimos)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoMimos, "N�o foi poss�vel encontrar o bot�o 'Mimos'");
        }
        tocarElemento(botaoMimos, "N�o foi poss�vel tocar no bot�o 'Mimos'");
        return this;
    }

    /**
     * Tocar bot�o Comprovantes
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o \"COMPROVANTES\"")
    public MenuTela tocarBotaoComprovantes() throws Exception {
        int cont = 0;
        while (!verificarPresencaElemento(botaoComprovantes)) {
            cont++;
            rolarTela(0.8D, 0.2D);
            if (cont > 15) break;
        }
        salvarEvidencia("Visualizar bot�o 'Comprovantes'");
        tocarElemento(botaoComprovantes, "N�o foi poss�vel tocar no bot�o 'Comprovantes'");
        salvarEvidencia("Tocar no bot�o 'Comprovantes'");
        return this;
    }

    /**
     * Validar Exibi��o de tela "Menu"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Exibi��o de tela \"Menu\"")
    public MenuTela validarExibicaoTelaMenu() throws Exception {
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL);
        validarCondicaoBooleana(!textoEncontrado.isEmpty(), MetodoComparacaoBooleano.VERDADEIRO, "N?o foi poss?vel validar a exibi??o da tela de menu");
        salvarEvidencia("Tela de menu inicial validada");
        return this;
    }

    /**
     * Validar Exibi��o de tela "Menu" logo ap�s login
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Exibi��o de tela \"Menu\"")
    public MenuTela validarExibicaoTelaMenuAposLogin() throws Exception {
        String textoEncontrado = aguardarPaginaConterQualquerTexto(LoginApp.LISTA_PALAVRAS_VALIDACAO_TELA_INICIAL);
       // validarCondicaoBooleana(Strings.isNotNullAndNotEmpty(textoEncontrado), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exib��o da tela de menu");
        salvarEvidencia("Login Efetuado com Sucesso - Validar Exibi��o da tela de Menu do App");
        return this;
    }

    /**
     * Fecha tela de clicar Sugest�o de cr�dito parcelado
     *
     * @return
     * @throws Exception
     */
    @Step("Fecha tela de clicar Sugest�o de cr�dito parcelado")
    public MenuTela fecharTelaCreditoParceladoInicio() {
        try {
            salvarEvidencia("Fechando tela de Sugest�o de Cr�dito Parcelado se vis�vel");
            retornaElemento(botaVerDepoisCreditoParcelado, 10).click();
        } catch (Exception ignore) {
            salvarEvidencia("   Ignorado");
        }
        return this;
    }

    /**
     * Aguarda carregamento do bot�o notifica��es na tela de Menu
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
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(fotoCliente, "N�o foi poss�vel encontrar a foto do cliente.");
        salvarEvidencia("Tocar foto do cliente");
        tocarElemento(fotoCliente, "N�o foi poss�vel tocar a foto do cliente");
        return this;
    }

    /**
     * Tocar no bot�o ver perfil
     *
     * @throws Exception
     */
    @Step("Tocar no bot�o ver perfil")
    public MenuTela tocarBotaoVerPerfil() throws Exception {
        salvarEvidencia("Tocar no bot�o ver perfil");
        tocarElemento(botaoVerPerfil, "N�o foi poss�vel tocar no bot�o ver perfil");
        return this;
    }

    /**
     * Tocar no bot�o "Menu Objetivos"
     *
     * @throws Exception
     */
    @Step("Tocar o bot�o \"Objetivos\"")
    public MenuTela tocarMenuObjetivos() throws Exception {
        if (!verificarPresencaElemento(botaoObjetivos)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoObjetivos, "N�o foi poss�vel encontrar o bot�o 'Objetivos'");
        }
        salvarEvidencia("Visualizar o bot�o 'Objetivos'");
        tocarElemento(botaoObjetivos, "N�o foi poss�vel tocar no bot�o 'Objetivos'");
        salvarEvidencia("Tocar no bot�o 'Objetivos'");
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
     * Tocar no bot�o "Ver Mais"
     *
     * @throws Exception
     */
    @Step("Tocar no bot�o \"Ver Mais\"")
    public MenuTela tocarBotaoVerMais() throws Exception {
        tocarElemento(botaoVerMais, "N�o foi poss�vel tocar em Ver Mais");
        salvarEvidencia("Tocar no bot�o Ver Mais");
        return this;
    }

    /**
     * Tocar no bot�o "Ver Mais" para expandir as op�?es do Menu
     *
     * @throws Exception
     */
    @Step("Tocar no bot�o \"Ver Mais\" para expandir as op�?es do Menu")
    public MenuTela tocarBotaoVerMaisMenu() throws Exception {
        aguardarCarregamentoElemento(botaoVerMaisMenu);
        tocarElemento(botaoVerMaisMenu, "N�o foi poss�vel tocar em Ver Mais para expandir o menu na Home");
        return this;
    }


    /**
     * Tocar no bot�o "PAGAMENTOS"
     *
     * @throws Exception
     */
    @Step("Tocar o bot�o \"PAGAMENTOS\"")
    public MenuTela tocarBotaoPagamentos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPagamentos, "N�o foi poss�vel encontrar o bot�o \"PAGAMENTOS\"");
        salvarEvidencia("Tocar bot�o \"PAGAMENTOS\"");
        tocarElemento(botaoPagamentos, "Ocorreu um erro ao executar a a��o de tocar no bot�o \"PAGAMENTOS\"");
        return this;
    }

    /**
     * Tocar no bot�o "FLOW"
     *
     * @throws Exception
     */
    @Step("Tocar o bot�o \"FLOW\"")
    public MenuTela tocarBotaoFlow() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoFlow, "N�o foi poss�vel encontrar o bot�o \"FLOW\"");
        salvarEvidencia("Tocar bot�o \"FLOW\"");
        tocarElemento(botaoFlow, "Ocorreu um erro ao executar a a��o de tocar no bot�o \"FLOW\"");
        return this;
    }

    /**
     * M�todo Criado para deslizar o Bubble do chat de ajuda, na tela de Menu, para o Bot�o fechar.
     *
     * @throws Exception
     */
    @Step("M�todo Criado para deslizar o Bubble do chat de ajuda, na tela de Menu, para o Bot�o fechar")
    public MenuTela moverIconeBubbleParaFechar() throws Exception {
        aguardarCarregamentoElemento(iconeBubbleChat);
        arrastarElementoProporcional(iconeBubbleChat, 10, 95);
        salvarEvidencia("Fechar Bubble do Chat");
        arrastarElementoProporcional(iconeBubbleChat, 51, 96, 9000);
        return this;
    }

    /**
     * Tocar no bot�o 'AJUDA'
     *
     * @throws Exception
     */
    @Step("Tocar o bot�o 'AJUDA'")
    public MenuTela tocarBotaoAjuda() throws Exception {
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(botaoAjuda, "N�o foi poss�vel encontrar o bot�o 'AJUDA'");
        salvarEvidencia("Tocar bot�o 'AJUDA'");
        tocarElemento(botaoAjuda, "Ocorreu um erro ao executar a a��o de tocar no bot�o 'AJUDA'");
        return this;
    }

    /**
     * Tocar no bot�o 'Empr�stimos'
     *
     * @throws Exception
     */
    @Step("Tocar o bot�o 'Empr�stimos'")
    public MenuTela tocarBotaoEmprestimos() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEmprestimos, "N�o foi poss�vel encontrar o bot�o 'Empr�stimos'");
        salvarEvidencia("Tocar bot�o 'Empr�stimos'");
        tocarElemento(botaoEmprestimos, "N�o foi poss�vel tocar no bot�o 'Empr�stimos'");
        esperarCarregando();
        return this;
    }

    /**
     * "Validar que o Bubble do Chat n�o esta na tela"
     *
     * @return
     * @throws Exception
     */
    @Step("Validar que o Bubble do Chat n�o esta na tela")
    public MenuTela validarAusenciaDoBubbleChatNaTelaDeMenu() {
        aguardarCarregamentoElemento(iconeBubbleChat);
        validarCondicaoBooleana(aguardarCarregamentoElemento(iconeBubbleChat), MetodoComparacaoBooleano.FALSO, "Bubble n�o foi fechado");
        salvarEvidencia("Bubble fechado, teste Finalizado");
        return this;
    }

    /**
     * Tocar no bot�o 'CART�O'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o 'CART�O'")
    public MenuTela tocarBotaoCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCartao, "N�o foi poss�vel encontrar o bot�o 'CART�O'");
        salvarEvidencia("Tocar bot�o 'CART�O'");
        tocarElemento(botaoCartao, "N�o foi poss�vel tocar no bot�o 'CART�O");
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
     * Tocar no bot�o 'DOA��ES'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o 'DOA��ES'")
    public MenuTela tocarBotaoDoacoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDoacoes, "N�o foi poss�vel encontrar o bot�o 'DOA��ES'");
        salvarEvidencia("Tocar bot�o 'Doa��es'");
        tocarElemento(botaoDoacoes, "N�o foi poss�vel tocar no bot�o 'DOA��ES");
        return this;
    }

    /**
     * 'tocar Botao Complete Seu Cadastro
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o 'Complete Seu Cadastro'")
    public MenuTela tocarBotaoCompleteSeuCadastro() throws Exception {
        salvarEvidencia("Tocar bot�o 'Complete Seu Cadastro'");
        tocarElemento(botaoCompleteSeuCadastro, "N�o foi poss�vel tocar no bot�o 'Complete Seu Cadastro");
        return this;
    }

    /**
     * Tocar no bot�o "NextJoy"
     *
     * @return MenuTela
     * @throws Exception
     */
    @Step("Tocar no bot�o \"NextJoy\"")
    public MenuTela tocarMenuNextJoy() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoNextJoy, "N�o foi poss�vel localizar o bot�o 'NextJoy'");
        salvarEvidencia("Tocar o bot�o 'NextJoy'");
        tocarElemento(botaoNextJoy, "N�o foi poss�vel tocar no bot�o 'NextJoy'");
        return this;
    }

    /**
     * Tocar no bot�o "Exibir Saldo"
     * fr
     * @return MenuTela
     * @throws Exception
     */
    @Step("Tocar no bot�o \"Exibir Saldo\"")
    public MenuTela tocarExibirSaldo() throws Exception {
        rolarTelaAteInicio();
        salvarEvidencia("Preparando para tocar o bot�o 'Exibir Saldo'");
        tocarElemento(botaoExibirSaldo, "N�o foi poss�vel tocar no bot�o 'Exibir Saldo' olhinho");
        aguardarCarregamentoElemento(botaoExibirSaldo);
        salvarEvidencia("Tocado bot�o 'Exibir Saldo'");
        return this;
    }

    /**
     * Comparar saldo final ao inicial para verificar se debitou o valor da aplica��o"
     * fr
     * @return MenuTela
     * @throws Exception
     */
    @Step("validar \"Saldo Final\"")
    public MenuTela validarSaldoFinal(String saldo) throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Utilitarios.reformatarValorMonetario(saldo.toString())), MetodoComparacaoBooleano.VERDADEIRO, "Valor do saldo apresentado em tela n�o confere!");
        salvarEvidencia("'Valida��o do saldo com sucesso!'");
        return this;
    }


    /**
     * Retorna o valor dispon�vel de saldo em conta para validar apos investimento efetuado
     * fr
     * @return
     * @throws Exception
     */
    @Step("Retorna o valor dispon�vel de saldo em conta para validar apos investimento efetuado")
    public MenuTela retornarValorSaldoDisponivel(ThreadLocal valor) throws Exception {
        if (valor != null) {
            valor.set(Utilitarios.normalizaStringNumero(retornarTexto(saldoDaConta, "N�o foi poss�vel retornar valor dispon�vel de saldo em conta")));
            OperadorEvidencia.logarPasso("Valor contido na thread: " + valor.get());
        }
        return this;
    }

    /**
     * Tocar no bot�o "Pix"
     *
     * @return MenuTela
     * @throws Exception
     */
    @Step("Tocar no bot�o \"Pix\"")
    public MenuTela tocarMenuPix() throws Exception {
        salvarEvidencia("Tocar o bot�o 'Pix'");
        tocarElemento(botaoPix, "N�o foi poss�vel tocar no bot�o 'Pix'");
        return this;
    }

    /**
     * tocar Botao nextShop
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o 'nextShop'")
    public MenuTela tocarBotaoNextShop() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoNextShop, "N�o foi poss�vel encontrar o bot�o 'NextShopS'");
        salvarEvidencia("Tocar bot�o 'NextShop'");
        tocarElemento(botaoNextShop, "N�o foi poss�vel tocar no bot�o 'NextShop");
        return this;
    }

    /**
     * tocar Botao openFinance
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o 'Open Finance'")
    public MenuTela tocarBotaoOpenFinance() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(openFinance, "N�o foi poss�vel encontrar o bot�o 'openFinance'");
        salvarEvidencia("Tocar bot�o Menu - 'Open Finance'");
        tocarElemento(openFinance, "N�o foi poss�vel tocar no bot�o 'openFinance");
        return this;
    }

    /**
     * Tocar no bot�o 'Poupan�a'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar o bot�o Poupan�a")
    public MenuTela clicarMenuPoupanca() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoPoupanca,"N�o foi poss�vel encontrar o bot�o 'Poupan�a'");
        salvarEvidencia("Tocar o bot�o \"Poupan�a\"");
        tocarElemento(botaoPoupanca, "N�o foi poss�vel tocar no bot?o \"Poupan�a\"");
        aguardarOcultacaoElemento(botaoPoupanca);
        return this;
    }

}
