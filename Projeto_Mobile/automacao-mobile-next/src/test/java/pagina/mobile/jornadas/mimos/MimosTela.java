package pagina.mobile.jornadas.mimos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.mimos.Oferta;
import framework.MobileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.util.Strings;

import java.util.List;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class MimosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_next_title")
    @AndroidFindBy(xpath = "(//android.view.ViewGroup)[3]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"MIMOS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
    private MobileElement tituloTelaMimos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_categories_label")
    @iOSXCUITFindBy(accessibility = "CATEGORIAS")
    private MobileElement botaoCategorias;

    @AndroidFindBy(id = "br.com.bradesco.next:id/np_categories_indicator")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther")
    private MobileElement indicadorCategoria;

    @AndroidFindBy(accessibility = "menu")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoMenu;

    @AndroidFindBy(id = "android:id/search_src_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement campoBusca;

    @AndroidFindBy(id = "br.com.bradesco.next:id/rv_offers")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell")
    private MobileElement botaoPrimeiraOfertaConsultada;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_action")
    @iOSXCUITFindBy(accessibility = "PEGAR CODIGO")
    private MobileElement botaoUsarMimo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"voltar\")]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"menu\")]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar para o menu\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Voltar' AND visible == 1`]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltarMenuPrincipal;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$label contains \"Mais\"$]")
    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/iv_next_option\" or @resource-id= \"br.com.bradesco.next:id/ni_option\"]")
    private MobileElement botaoMaisOpcoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'FAVORITAR']")
    @AndroidFindBy(xpath = "//*[@text = 'Favoritar']")
    @iOSXCUITFindBy(accessibility = "FAVORITAR")
    private MobileElement botaoFavoritar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text = 'DESFAVORITAR']")
    @AndroidFindBy(xpath = "//*[@text = 'Desfavoritar']")
    @iOSXCUITFindBy(accessibility = "DESFAVORITAR")
    private MobileElement botaoDesfavoritar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_how_to_use_title")
    @iOSXCUITFindBy(accessibility = "Como usar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/following-sibling::XCUIElementTypeOther[1]")
    private MobileElement iconeComoUsar;

    @AndroidFindBy(accessibility = "mais detalhes sobre o uso desta oferta")
    @iOSXCUITFindBy(accessibility = "Como usar")
    private MobileElement botaoComoUsarEstaOferta;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout")
    @iOSXCUITFindBy(accessibility = "COD002")
    private MobileElement botaoToqueParaCopiar;

    @iOSXCUITFindBy(accessibility = "Avaliar mimo")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_question")
    private MobileElement botaoAvaliarMimo;

    @iOSXCUITFindBy(accessibility = "Fechar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/fl_next_navigation")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$label == \"emptyStar\"$][5]")
    @AndroidFindBy(accessibility = "5 estrelas")
    private MobileElement QuintaEstrelaAvaliacao;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$label == \"emptyStar\"$][2]")
    @AndroidFindBy(accessibility = "Duas estrelas")
    private MobileElement segundaEstrelaAvaliacao;

    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeTextField\"")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nti_edit_text_comment")
    private MobileElement campoComentario;

    @iOSXCUITFindBy(accessibility = "ENVIAR")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_send")
    private MobileElement botaoEnviar;

    @iOSXCUITFindBy(accessibility = "AGORA N�O")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_not_now")
    private MobileElement botaoAgoraNao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id='br.com.bradesco.next:id/lbl_description'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Teste QA-3074\"])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Teste QA - 3074\"])[1]")
    private MobileElement botaoTextooferta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_get_voucher")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Clique aqui para gerar cupom de desconto')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`value == \"Clique aqui para gerar cupom de desconto\"`]")
    private MobileElement botaoGerarCupom;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_see_vouchers")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"VER MEUS CUPONS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"VER MEUS CUPONS\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Clique aqui para ver meus cupons resgatados dessa oferta\"")
    private MobileElement botaoVerMeusCupons;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/nb_icon_ept\"]/following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Voc�\"$]")
    private MobileElement textoNaoPossuiCuponsGerados;

    @AndroidFindBy(id = "br.com.bradesco.next:id/msg")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'rea de mimos')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Essa � a sua �rea de mimos.\"$]")
    private MobileElement textoPrimeiraTelaTutorialMimos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/msg")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Para ver todos os mimos\"$]")
    private MobileElement textoSegundaTelaTutorialMimos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/msg")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Voc� pode\"$]")
    private MobileElement textoTerceiraTelaTutorialMimos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_action")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PR�XIMO\"]")
    private MobileElement botaoProximo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_action")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONHECER\"]")
    private MobileElement botaoConhecer;

    @AndroidFindBy(id = "android:id/search_close_btn")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Limpar texto\"]")
    private MobileElement limparTexto;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "pegar")
    private MobileElement getBotaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_card")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CATEGORIAS\"]/preceding-sibling::XCUIElementTypeOther")
    private MobileElement cardMimo;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/msg")
    private MobileElement labelCardCategoria;

    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell/XCUIElementTypeButton")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_text")
    private MobileElement codigoPromocional;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ao clicar voc� vai sair do app do next\"]/following-sibling::XCUIElementTypeButton")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_action")
    private MobileElement botaoIrParaParceiros;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Navegador\"]")
    private MobileElement iconeNavegadorAndroid;

    @AndroidFindBy(id = "android:id/button_once")
    private MobileElement botaoApenasUmaVezAndroid;

    @iOSXCUITFindBy(iOSNsPredicate = "type=\"XCUIElementTypeApplication\" and name=\"Safari\" ")
    @AndroidFindBy(id = "com.sec.android.app.sbrowser:id/main_layout")
    private MobileElement appBrowserWeb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_description")
    private MobileElement campoTextoPopUp;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "OK, VOLTAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK, VOLTAR\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, \"OK\")]")
    private MobileElement botaoOK;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "REGRAS DE USO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label == \"REGRAS DE USO\"$]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REGRAS DE USO\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_see_rules")
    private MobileElement botaoRegrasDeUso;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeStaticText")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_banner")
    private MobileElement textoCadastradoRegrasDeUso;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[$name == \"CUPOM DE DESCONTO\"$]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    private MobileElement headerCupomDeDesconto;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_partner")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"XboxOne\"]")
    private MobileElement validarNomeOferta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_copy_voucher")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Clique aqui para gerar cupom de desconto\"")
    @iOSXCUITFindBy(accessibility = "COPIAR C�DIGO E IR PARA LOJA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"COPIAR C�DIGO E IR PARA LOJA\"]")
    private MobileElement botaoGerarCupomDesconto;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Barra de rolagem vertical, 1 p�gina\"]")
    private MobileElement validarLimiteScrollAcima;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(accessibility = "Barra de rolagem vertical, 1 p�gina")
    private MobileElement validarLimiteScrollAbaixo;

    //abertura do browser no app
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.chrome:id/action_bar_root")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Endere�o\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"URL\"]")
    private MobileElement abrindoBrowser;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_partner_title")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/ntv_partner_title']")
    @AndroidFindBy(xpath = "//*[contains(@text,'Sobre a parceria')]")
    @iOSXCUITFindBy(accessibility = "Sobre a parceria")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Sobre a parceria\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sobre a parceria\"]")
    private MobileElement labelSobreParceria;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_action")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/btn_action']")
    @AndroidFindBy(xpath = "//*[contains(@text,'USE')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"USE\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"USE\" AND type == \"XCUIElementTypeButton\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"USE\"]")
    private MobileElement botaoUse;

    public MimosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retorna o elemento contendo o t�tulo da oferta com a descri��o procurados
     *
     * @param oferta
     * @param descricao
     * @return
     * @throws NextException
     */
    private MobileElement botaoOfertaDescricao(String oferta, String descricao) throws NextException {
        MobileElement elemento = null;
        if (android)
            elemento = (MobileElement) retornaElemento(By.xpath("//android.widget.ScrollView//*[@resource-id='br.com.bradesco.next:id/ntv_title' " +
                    "and contains(@text,'" + oferta + "')]/..//*[@resource-id='br.com.bradesco.next:id/ntv_description' " +
                    "and contains(@text,'" + descricao + "')]"));
        if (ios)
            elemento = (MobileElement) retornaElemento(By.xpath("//XCUIElementTypeCell/XCUIElementTypeStaticText[contains" +
                    "(@name,'" + oferta + "')]/..//XCUIElementTypeStaticText[contains" +
                    "(@name,'" + descricao + "')]"));
        return elemento;
    }

    /**
     * Converte AppiumDriver em AndroidDriver
     *
     * @return AndroidDriver<MobileElement>
     */
    private AndroidDriver<MobileElement> getAndroidDiver() {
        if (getDriver() instanceof AndroidDriver) {
            return (AndroidDriver<MobileElement>) getDriver();
        } else {
            throw new UnsupportedOperationException("Not an Android driver.");
        }
    }

    /**
     * Converte AppiumDriver em iOSDriver
     *
     * @return IOSDriver<MobileElement>
     */
    private IOSDriver<MobileElement> getIOSDiver() {
        if (getDriver() instanceof IOSDriver) {
            return (IOSDriver<MobileElement>) getDriver();
        } else {
            throw new UnsupportedOperationException("Not an IOS driver.");
        }
    }

    /**
     * Validar presen�a tela 'MIMOS'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Validar presen�a tela 'MIMOS'")
    public MimosTela validarPresencaTelaMimos() throws Exception {
        validarCondicaoBooleana(validarTelaMimos(), MetodoComparacaoBooleano.VERDADEIRO, "A tela mimos n�o est� presente!");
        salvarEvidencia("Validado App est� na tela 'MIMOS'");
        return this;
    }

    /**
     * Realiza tratamento de string texto, deixando tudo em letra mai�scula e recusando qualquer caracter que n�o seja texto
     *
     * @param texto
     * @return String
     */
    private String trataTexto(String texto) {
        return texto.toUpperCase().replaceAll("[^A-Z]", "");
    }

    /**
     * Verifica se � o primeiro acesso do cliente a funcionalidade Mimos
     *
     * @return boolean
     */
    private boolean verificarPrimeiroAcesso() throws Exception {
        if (aguardarCarregamentoElemento(textoPrimeiraTelaTutorialMimos)) {
            return trataTexto(textoPrimeiraTelaTutorialMimos.getText()).contains(trataTexto("Essa � a sua �rea de mimos."));
        } else {
            return false;
        }
    }

    /**
     * Toca bot�o "Pr�ximo"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Pr�ximo\"")
    public MimosTela tocarBotaoProximo() throws Exception {
        aguardarCarregamentoElemento(botaoProximo);
        tocarElemento(botaoProximo, "N�o foi poss�vel tocar bot�o 'Pr�ximo'");
        salvarEvidencia("Tocar bot�o 'Pr�ximo'");
        return this;
    }

    /**
     * Toca bot�o "Conhecer"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Conhecer\"")
    public MimosTela tocarBotaoConhecer() throws Exception {
        aguardarCarregamentoElemento(botaoConhecer);
        salvarEvidencia("Tocar bot�o 'Conhecer'");
        tocarElemento(botaoConhecer, "N�o foi poss�vel tocar bot�o 'Conhecer'");
        return this;
    }

    /**
     * Realiza os passos de primeiro acesso sem gerar evid�ncia para os cen�rios que n�o validam os passos do primeiro acesso
     *
     * @return MimosTela
     * @throws Exception
     */
    public MimosTela realizarPrimeiroAcessoSemEvidenciarPassos() throws Exception {
        aguardarCarregamentoElemento(botaoProximo);
        tocarElemento(botaoProximo, "N�o foi poss�vel tocar bot�o 'Pr�ximo'");
        aguardarCarregamentoElemento(botaoProximo);
        tocarElemento(botaoProximo, "N�o foi poss�vel tocar bot�o 'Pr�ximo'");
        aguardarCarregamentoElemento(botaoConhecer);
        tocarElemento(botaoConhecer, "N�o foi poss�vel tocar bot�o 'Conhecer'");
        return this;
    }

    /**
     * Deslizar Card Para Cima
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Deslizar Card para Cima")
    public MimosTela deslizarCardParaCima() throws Exception {
        if (verificarPrimeiroAcesso()) {
            realizarPrimeiroAcessoSemEvidenciarPassos();
        }
        aguardarCarregamentoElemento(cardMimo);
        salvarEvidencia("Visualizar Card Mimos");
        rolaTelaBaixo();
        aguardarCarregamentoElemento(campoBusca);
        salvarEvidencia("Deslizar tela para cima");
        return this;
    }

    /**
     * Deslizar Card Para Baixo
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Deslizar Card para Cima")
    public MimosTela deslizarCardParaBaixo() throws Exception {
        aguardarCarregamentoElemento(cardMimo);
        salvarEvidencia("Visualizar Card Mimos");
        rolaTelaBaixo();
        aguardarCarregamentoElemento(campoBusca);
        salvarEvidencia("Deslizar tela para Baixo");
        return this;
    }

    /**
     * Preencher campo busca com oferta desejada
     *
     * @param oferta
     * @return MimosTela
     * @throws Exception
     */
    @Step("Preencher campo \"Busca\"")
    public MimosTela preenherCampoBusca(String oferta) throws Exception {
        aguardarCarregamentoElemento(campoBusca);
        escreverTexto(campoBusca, oferta, "N�o foi poss�vel preencher campo de busca");
        salvarEvidencia("Preencher Campo Busca com valor: \"" + oferta + "\"");
        return this;
    }

    /**
     * Toca bot�o "Ver Meus Cupons"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Ver meus Cupons\"")
    public MimosTela tocarBotaoVerMeusCupons() throws Exception {
        rolaTelaBaixo();
        if(!aguardarCarregamentoElemento(botaoVerMeusCupons))
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerMeusCupons, "O bot�o 'VER MEUS CUPONS' n�o foi encontrado!");
        salvarEvidencia("Visualizar bot�o Meus Cupons");
        tocarElemento(botaoVerMeusCupons, "N�o foi poss�vel tocar no bot�o 'VER MEUS CUPONS'!");
        return this;
    }

    /**
     * Validar Mensagem "N�o Possui Cupons Gerados
     *
     * @return MimosTela
     */
    @Step("Validar Mensagem \"Voc� n�o possui cupons gerados at� o momento\"")
    public MimosTela validarMensagemNaoPossuiCuponsGerados() throws Exception {
        aguardarCarregamentoElemento(textoNaoPossuiCuponsGerados);
        String mensagemEsperadaNaoPossuiCuponsGerados = "Voc� n�o possui cupons gerados at� o momento";
        Assert.assertEquals(trataTexto(textoNaoPossuiCuponsGerados.getText()), trataTexto(mensagemEsperadaNaoPossuiCuponsGerados));
        salvarEvidencia("Validar mensagem: \"" + mensagemEsperadaNaoPossuiCuponsGerados + "\"");
        return this;
    }

    /**
     * Selecionar Oferta consultada
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Selecionar oferta consultada")
    public MimosTela selecionarOfertaConsultada(String textoOferta) throws Exception {
        By oferta = ios ? By.xpath("//XCUIElementTypeStaticText[@name='"+textoOferta+"']") :
                By.xpath("//android.widget.TextView[@text='"+textoOferta+"']");

        aguardarCarregamentoElemento(oferta);
        salvarEvidencia("Selecionar Oferta com texto: '"+textoOferta+"'");
        tocarElemento(oferta, "N�o foi poss�vel selecionar Oferta");
        aguardarOcultacaoElemento(oferta);
        return this;
    }

    /**
     * Validar mensagem exibida na primeira tela Tutorial Mimos
     *
     * @return MimosTela
     */
    @Step("Validar mensagem exibida na primeira tela Tutorial Mimos")
    public MimosTela validarMensagemPrimeiraTelaTutorialMimos() throws Exception {

        aguardarPaginaConterTodosTextos("MIMOS");
        String mensagemEsperadaTela = "Essa � a sua �rea de mimos. Cada vez que entrar, voc� vai ver um mimo diferente em destaque.";
        String mensagemGerada = MobileUtils.localizarTexto(mensagemEsperadaTela);
        validarCondicaoBooleana(Strings.isNotNullAndNotEmpty(mensagemGerada),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar texto da primeira mensagem.");
        salvarEvidencia("Validar exibi��o do texto \"" + mensagemGerada.replace("\n","") + "\" na primeira tela de Tutorial Mimos (Primeiro Acesso)");
        return this;
    }

    /**
     * Validar mensagem exibida na segunda tela Tutorial Mimos
     *
     * @return MimosTela
     */
    @Step("Validar mensagem exibida na segunda tela Tutorial Mimos")
    public MimosTela validarMensagemSegundaTelaTutorialMimos() throws Exception {

        aguardarPaginaConterTodosTextos("MIMOS");
        String mensagemEsperadaTela = "Para ver todos os mimos � s� ir em categorias, l� voc� acessa os detalhes de cada um.";
        String mensagemGerada = MobileUtils.localizarTexto(mensagemEsperadaTela);
        validarCondicaoBooleana(Strings.isNotNullAndNotEmpty(mensagemGerada),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar texto da segunda mensagem.");
        salvarEvidencia("Validar exibi��o do texto \"" + mensagemGerada.replace("\n","") + "\" na segunda tela de Tutorial Mimos (Primeiro Acesso)");
        return this;
    }

    /**
     * Validar mensagem exibida na terceira tela Tutorial Mimos
     *
     * @return MimosTela
     */
    @Step("Validar mensagem exibida na terceira tela Tutorial Mimos")
    public MimosTela validarMensagemTerceiraTelaTutorialMimos() throws Exception {

        aguardarPaginaConterTodosTextos("MIMOS");
        String mensagemEsperadaTela = "Voc� pode favoritar os mimos que mais gostar.";
        String mensagemGerada = MobileUtils.localizarTexto(mensagemEsperadaTela);
        validarCondicaoBooleana(Strings.isNotNullAndNotEmpty(mensagemGerada),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar texto da terceira mensagem.");
        salvarEvidencia("Validou exibi��o do texto \"" + mensagemGerada.replace("\n","") + "\" na terceira tela de Tutorial Mimos (Primeiro Acesso)");
        return this;
    }

    /**
     * Tocar bot�o "Categorias"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Categorias\"")
    public MimosTela tocarBotaoCategorias() throws Exception {
        if (verificarPrimeiroAcesso()) {
            realizarPrimeiroAcessoSemEvidenciarPassos();
        }
        aguardarCarregamentoElemento(botaoCategorias);
        salvarEvidencia("Visualizar Card Mimos");
        tocarElemento(botaoCategorias, "N�o foi poss�vel selecionar o bot�o \"Categorias\"");
        salvarEvidencia("Tocar bot�o \"Categorias\"");
        return this;
    }

    /**
     * Tocar bot�o conhecer tela primeiro acesso caso ela esteja presente
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o conhecer tela primeiro acesso caso ela esteja presente")
    public MimosTela tocarBotaoConhecerTelaPrimeiroAcesso() throws Exception {
        if (verificarPrimeiroAcesso()) {
            realizarPrimeiroAcessoSemEvidenciarPassos();
        }
        salvarEvidencia("Tocado bot�o 'Conhecer' na tela de primeiro acesso!");
        return this;
    }

    /**
     * Desliza carrossel at� encontar categoria procurada
     *
     * @param categoria
     * @return MimosTela
     */
    @Step("Deslizar carrossel at� encontrar card da categoria procurada")
    public MimosTela deslizarCarrosselAteAcharCategoria(String categoria) throws Exception {
        OperadorEvidencia.logarPasso(">>Procurando pela categoria: " + categoria);
        OperadorEvidencia.logarPasso("Caso nao encontre, alterar na massa para outra Categoria disponivel");
        deslizarCarrosselAteEncontrarTexto(labelCardCategoria, categoria, Direcao.DIREITA,20,80,  "String mensagemErro");
        salvarEvidencia("Deslizar carrossel at� encontrar card da categoria: \"" + categoria + "\"");
        return this;
    }

    /**
     * Seleciona Card de Oferta Procurada entre as ofertas abaixo do carrossel
     *
     * @param oferta
     * @return MimosTela
     * @throws Exception
     */
    @Step("Selecioonar card oferta")
    public MimosTela selecionarCardOferta(String oferta) throws Exception {

        OperadorEvidencia.logarPasso("Procurando pela oferta:" + oferta);
        By labelCardOferta;
        if (android) {
            labelCardOferta = By.xpath("//android.widget.TextView[contains(@text,\"" + oferta + "\")]");
        } else {
            labelCardOferta = MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[$label CONTAINS \"" + oferta + "\"$]");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelCardOferta, "N�o foi possivel encontrar o elemento 'Oferta'");
        salvarEvidencia("Selecionar oferta: \"" + oferta + "\"");
        tocarElemento(labelCardOferta, "N�o foi poss�vel selecionar oferta: \"" + oferta + "\"");
        return this;
    }

    /**
     * Toca �cone "Como Usar"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar �cone \"Como Usar\"")
    public MimosTela tocarIconeComoUsar() throws Exception {
        aguardarCarregamentoElemento(iconeComoUsar);
        tocarElemento(iconeComoUsar, "N�o foi poss�vel tocar no �cone \"Como Usar\"");
        salvarEvidencia("Tocar no �cone \"Como Usar\"");
        return this;
    }

    /**
     * Toca C�digo Promocional
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar C�digo Promocional")
    public MimosTela tocarBotaoCodigoPromocional() throws Exception {
        if (!aguardarCarregamentoElemento(codigoPromocional)) {
            rolaTelaBaixo();
            aguardarCarregamentoElemento(codigoPromocional);
        }
        if (getDriver() instanceof IOSDriver) {
            tocarElemento(codigoPromocional, "N�o foi poss�vel tocar no c�digo promocional");
            Assert.assertEquals(trataTexto(codigoPromocional.getText()), trataTexto("C�DIGO COPIADO!"));
        } else {
            tocarElemento(codigoPromocional, "N�o foi poss�vel tocar no c�digo promocional");
        }
        salvarEvidencia("Tocar no c�digo promocional");
        return this;
    }

    /**
     * Tocar bot�o "IR PARA PARCEIROS" (O texto do bot�o pode variar de acordo com a oferta)
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"IR PARA PARCEIRO\"")
    public MimosTela tocarBotaoIrParaParceiros() throws Exception {
        if (!aguardarCarregamentoElemento(botaoIrParaParceiros)) {
            rolaTelaBaixo();
        }
        String textoBotaoIrParaParceiros = botaoIrParaParceiros.getText();
        tocarElemento(botaoIrParaParceiros, "N�o foi poss�vel tocar bot�o \"IR PARA PARCEIROS\"");
        if (getDriver() instanceof AndroidDriver) {
            if (aguardarCarregamentoElemento(iconeNavegadorAndroid)) {
                tocarElemento(iconeNavegadorAndroid, "N�o foi poss�vel selecionar \"Navegador\"");
                tocarElemento(botaoApenasUmaVezAndroid, "N�o foi poss�vel tocar no bot�o \"APENAS UMA VEZ\"");
            }
        }
        aguardarCarregamentoElemento(appBrowserWeb);
        salvarEvidencia("Tocar bot�o \"" + textoBotaoIrParaParceiros + "\"");
        return this;
    }

    /**
     * Validar redirecionamento para app de Browser Web
     *
     * @return MimosTela
     */
    @Step("Validar redirecionamento para App de Browser Web")
    public MimosTela validarRedirecionamentoAppWeb() throws Exception {
        if (android && !aguardarCarregamentoElemento(appBrowserWeb)) {
            retornaElemento(By.xpath("//android.widget.FrameLayout[@package=\"com.android.chrome\"]"));
            salvarEvidencia("Validar redirecionamento para App de Browser Web");
        } else if (aguardarCarregamentoElemento(appBrowserWeb)) {
            salvarEvidencia("Validar redirecionamento para App de Browser Web");
        } else {
            throw new AssertionError("N�o houve direcionamento para App de Browser Web");
        }
        return this;
    }

    /**
     * Retornar para o App do NEXT
     *
     * @return MimosTela
     */
    @Step("Retornar para o App do Next")
    public MimosTela retornarAppNext(String oferta) throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            //d� swipe para retornar carrossel
            aguardarCarregamentoElemento(cardMimo);
            rolaTelaBaixo();
            //procura seleciona a oferta
            aguardarCarregamentoElemento(campoBusca);
            escreverTexto(campoBusca, oferta, "N�o foi poss�vel preencher campo de busca");
            aguardarCarregamentoElemento(botaoPrimeiraOfertaConsultada);
            tocarElemento(botaoPrimeiraOfertaConsultada, "N�o foi poss�vel selecionar Oferta");
        }
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Retornar para o Next");
        return this;
    }

    /**
     * Tocar Bot�o "Mais Op��es"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"...\" no canto superior direito da tela")
    public MimosTela tocarBotaoMaisOpcoes() throws Exception {
        System.out.println(">> Bot�o \"...\" somente est� dispon�vel para MIMOS sem avalia��o");
        aguardarCarregamentoElemento(botaoMaisOpcoes);
        tocarElemento(botaoMaisOpcoes, "N�o foi poss�vel tocar no �cone \"...\" no canto superior direito da tela");
        salvarEvidencia("Tocar no �cone \"...\" no canto superior direito da tela");
        return this;
    }

    /**
     * Tocar bot�o "Avaliar Mimo"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o \"Avaliar Mimo\"")
    public MimosTela tocarBotaoAvaliarMimos() throws Exception {
        aguardarCarregamentoElemento(botaoAvaliarMimo);
        tocarElemento(botaoAvaliarMimo, "N�o foi poss�vel tocar no bot�o \"Avaliar Mimos\"");
        salvarEvidencia("Tocar no bot�o \"Avaliar Mimos\"");
        return this;
    }

    /**
     * Tocar Quinta Estrela Avalia��o
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar quinta estrela Avalia��o")
    public MimosTela tocarQuintaEstrelaAvaliacao() throws Exception {
        aguardarCarregamentoElemento(QuintaEstrelaAvaliacao);
        if (getDriver() instanceof AndroidDriver) {
            esconderTeclado();
        }
        tocarElemento(QuintaEstrelaAvaliacao, "N�o foi poss�vel tocar na quinta estrela da avalia��o");
        salvarEvidencia("Tocar quinta estrela em avalia��o");
        return this;
    }

    /**
     * Tocar bot�o "Enviar"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o no \"Enviar\"")
    public MimosTela tocarBotaoEnviar() throws Exception {
        aguardarCarregamentoElemento(botaoEnviar);
        tocarElemento(botaoEnviar, "N�o foi poss�vel tocar bot�o no \"Enviar\"");
        salvarEvidencia("Tocar bot�o no \"Enviar\"");
        return this;
    }

    /**
     * Validar N�o exibi��o do bot�o "..."
     *
     * @return MimosTela
     */
    @Step("Validar �cone \"...\" n�o est� presente na tela")
    public MimosTela validarNaoExibicaoBotaoMaisOpcoes() throws Exception {
        if (!aguardarCarregamentoElemento(botaoVoltar)) {
            throw new AssertionError("Tela n�o foi carregada com sucesso");
        } else if (aguardarCarregamentoElemento(botaoMaisOpcoes)) {
            throw new AssertionError("�cone \"...\" est� presente na tela");
        }
        salvarEvidencia("Validar �cone \"...\" n�o est� presente na tela");
        return this;
    }

    /**
     * Tocar bot�o "Usar Mimo"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o no \"Usar Mimo\"")
    public MimosTela tocarBotaoUsarMimo() throws Exception {
        aguardarCarregamentoElemento(botaoUsarMimo);
        tocarElemento(botaoUsarMimo, "N�o foi poss�vel tocar bot�o \"Usar Mimo\"");
        salvarEvidencia("Tocar bot�o no \"Usar Mimo\"");
        return this;
    }

    /**
     * Tocar bot�o "Voltar"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o no \"Usar Mimo\"")
    public MimosTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar bot�o \"Voltar\"");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar bot�o \"Voltar\"");
        return this;
    }

    /**
     * Apaga texto do campo de busca
     *
     * @return MimosTela
     * @throws Exception
     */
    public MimosTela apagarCampoBusca() throws Exception {
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(campoBusca, "Campo Busca n�o encontrado");
        apagarCampoTexto(campoBusca, "N�o foi poss�vel limpar campo busca");
        salvarEvidencia("Apagar Campo Busca");
        return this;
    }

    /**
     * Validar Oferta N�o Possui C�digo Promocional
     *
     * @return MimosTela
     */
    @Step("Validar oferta n�o possui c�digo promocional")
    public MimosTela validarCodigoPromocional(Boolean temCodigoPromocional) throws Exception {
        if (temCodigoPromocional) {
            if (!aguardarCarregamentoElemento(codigoPromocional)) {
                rolaTelaBaixo();
                aguardarCarregamentoElemento(codigoPromocional);
            }
            if (ios) {
                tocarElemento(codigoPromocional, "N�o foi poss�vel tocar no c�digo promocional");
                Assert.assertEquals(trataTexto(codigoPromocional.getText()), trataTexto("C�DIGO COPIADO!"));
            } else {
                tocarElemento(codigoPromocional, "N�o foi poss�vel tocar no c�digo promocional");
            }
            salvarEvidencia("Tocar no c�digo promocional");
        } else {
            if (aguardarCarregamentoElemento(codigoPromocional)) {
                throw new AssertionError("Esperado: Oferta sem c�digo promissional, Real: C�digo Promocional encontrado na tela");
            }
            salvarEvidencia("Validar Oferta n�o possui c�digo promocional");
        }

        return this;
    }

    /**
     * Tocar bot�o "Pr�ximo"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Pr�ximo\"")
    public MimosTela tocarProximo() throws Exception {
        aguardarCarregamentoElemento(botaoProximo);
        salvarEvidencia("Tocar bot�o \"Pr�ximo\"");
        tocarElemento(botaoProximo, "N�o foi poss�vel tocar bot�o \"Pr�ximo\"");
        return this;
    }

    /**
     * Toca bot�o "voltar menu"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"voltar menu\"")
    public MimosTela tocarVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar menu'");
        tocarElemento(botaoMenu, "N�o foi poss�vel tocar no bot�o 'Menu' para voltar");
        return this;
    }

    /**
     * Toca bot�o "tocar Categorias"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"tocar Categorias\"")
    public MimosTela tocarCategorias() throws Exception {
        aguardarCarregamentoElemento(botaoCategorias);
        tocarElemento(botaoCategorias, "N�o foi poss�vel tocar bot�o 'tocar Categorias'");
        salvarEvidencia("Tocar bot�o 'tocar Categorias'");
        return this;
    }

    /**
     * Deslizar carrossel para selecionar categorias'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Deslizar para carrossel para esquerda")
    public MimosTela moverCarrossel() throws Exception {
        aguardarCarregamentoElemento(indicadorCategoria);
        if (ios) {
            for (int i = 0; i <= 3; i++) {
                deslizar(By.xpath("//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther"), Direcao.ESQUERDA, 10, 90);
            }
        } else {
            for (int i = 0; i <= 3; i++) {
                deslizar(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup[2]"), Direcao.ESQUERDA, 10, 90);
            }
        }
        salvarEvidencia("mover Carrossel 'mover Carrossel'");
        return this;
    }

    /**
     * Toca bot�o "acessar Oferta"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"voltar acessar Oferta\"")
    public MimosTela acessarOferta() throws Exception {
        aguardarCarregamentoElemento(indicadorCategoria);
        esconderTeclado();
        if (android)
            tocarCoordenadaProporcional(49, 62);
        salvarEvidencia("Tocar bot�o 'Acessar oferta com nome alterado'");
        return this;
    }

    /**
     * Toca bot�o da oferta (promo��o) e descri��o espec�ficos
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Promo��o\"")
    public MimosTela acessarOferta(String promocao, String descricao) throws Exception {
        esconderTeclado();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(
                botaoOfertaDescricao(promocao, descricao), "N�o foi poss�vel encontrar a oferta '" +
                        promocao + "' e descri��o '" + descricao + "'"
        );
        salvarEvidencia("Tocar bot�o 'Acessar oferta com nome alterado'");
        tocarElemento(botaoOfertaDescricao(promocao, descricao),
                "A oferta foi encontrada mas n�o foi poss�vel tocar no bot�o");
        return this;
    }

    /**
     * Toca bot�o (x) "limpar texto"
     *
     * @return MimoaTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"limpar texto\"")
    public MimosTela limparTexto() throws Exception {
        aguardarCarregamentoElemento(limparTexto);
        tocarElemento(limparTexto, "N�o foi poss�vel tocar bot�o (x) 'Limpar texto'");
        salvarEvidencia("Tocar bot�o (x) 'limpar texto'");
        return this;
    }

    /**
     * Validar altera��o no Card de oferta
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Validar altera��o no Card de oferta")
    public MimosTela validarNomeOferta() throws Exception {
        aguardarCarregamentoElemento(validarNomeOferta);
        compararElementoTexto(validarNomeOferta, Oferta.DESCRICAO_OFERTA, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar altera��o no Card de oferta");
        return this;
    }

    /**
     * Validar Limite do Scroll acima
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Validar limitte do scroll acima")
    public MimosTela validaLimiteScrollAcima() throws Exception {
        aguardarCarregamentoElemento(campoBusca);
        rolaTelaCima();
        salvarEvidencia("Validar limitte do scroll para acima");
        return this;
    }

    /**
     * Rolar tela Mimos para cima - Exibir ofertas no card
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Rolar tela Mimos Para Cima")
    public MimosTela rolarTelaMimosParaBaixo() {
        rolaTelaBaixo();
        OperadorEvidencia.logarPasso("Rolar tela Mimos para baixo - Exibir ofertas no card");
        return this;
    }

    /**
     * validar Limite Scroll Abaixo
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("validar limite scroll para baixo")
    public MimosTela validaLimiteScrollAbaixo() throws Exception {
        aguardarCarregamentoElemento(cardMimo);
        rolaTelaBaixo();
        aguardarCarregamentoElemento(campoBusca);
        salvarEvidencia("Validar limitte do scroll para baixo");
        return this;
    }


    /**
     * Tocar bot�o "GERAR CUPOM DE DESCONTO"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"GERAR CUPOM DE DESCONTO\"")
    public MimosTela tocarBotaoGerarCupomDeDesconto() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar bot�o no \"GERAR CUPOM\"");
        String mensagemErro = "N�o foi poss�vel encontrar o bot�o 'Gerar Cupom de Desconto'";
        if (ios) {
            tocarElementoOculto("//*[@name='GERAR CUPOM DE DESCONTO']", mensagemErro);
        } else {
            tocarElemento(botaoGerarCupom, mensagemErro);
        }
        return this;
    }

    /**
     * Tocar bot�o "REGRAS DE USO"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"REGRAS DE USO\"")
    public MimosTela tocarBotaoRegrasDeUso() throws Exception {
        if(ios){
            int count = 0;
            do{
                if(count > 3){
                    break;
                }
                rolarTela(0.7,0.3);
                count++;
            } while(!aguardarExistenciaElemento(botaoRegrasDeUso, 2, 500));
            salvarEvidencia("Tocar no bot�o \"REGRAS DE USO\"");
            botaoRegrasDeUso.click();
        }else {
            aguardarCarregamentoElemento(botaoRegrasDeUso);
            salvarEvidencia("Tocar no bot�o \"REGRAS DE USO\"");
            tocarCoordenada(botaoRegrasDeUso);
        }
        return this;
    }

    /**
     * Validar exibi��o de mensagem de regras de uso cadastrada no sistema de gest�o
     *
     * @return MimosTela
     */
    @Step("Validar exibi��o de mensagem de regras de uso cadastrada no sistema de gest�o")
    public MimosTela validarExibicaoTextoCadastradoRegrasDeUso() throws Exception {
      if (aguardarCarregamentoElemento(textoCadastradoRegrasDeUso)) {
            salvarEvidencia("Validar exibi��o de mensagem de regras de uso cadastrada no sistema de gest�o");
      } else {
           throw new NoSuchElementException("N�o foi poss�vel verificar a exibi��o da mensagem de regras de uso cadastrada no sistema de gest�o");
      }
        return this;
    }

    /**
     * Validar mensagem exibida no popup
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Validar mensagem popup")
    public MimosTela validarMensagemPopUp(String oferta) throws Exception {
        aguardarCarregamentoElemento(campoTextoPopUp);
        if (getDriver() instanceof AndroidDriver) {
            compararElementoTexto(campoTextoPopUp, oferta, MetodoComparacao.IGUAL);
        } else {
            compararElementoTexto(campoTextoPopUp, oferta, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar mensagem popup");
        return this;
    }

    /**
     * Tocar bot�o "OK"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK\"")
    public MimosTela tocarBotaoOkPopUp() throws Exception {
        aguardarCarregamentoElemento(botaoOK);
        tocarElemento(botaoOK, "N�o foi poss�vel tocar bot�o \"OK, Entendi\"");
        aguardarCarregamentoElemento(headerCupomDeDesconto);
        salvarEvidencia("Tocar bot�o \"OK, Entendi\"");
        return this;
    }

    /**
     * Validar Exibi��o do Header de cupom de desconto
     *
     * @return MimosTela
     */
    @Step("Validar Exibi��o do Header de cupom de desconto")
    public MimosTela validarExibicaoHeaderCupomDeDesconto() throws Exception {
        if (aguardarCarregamentoElemento(headerCupomDeDesconto)) {
            salvarEvidencia("Validar exibi��o do header Cupom de Desconto");
        } else {
            throw new NoSuchElementException("N�o foi poss�vel verificar o carregamento do header Cupom de Desconto");
        }
        return this;
    }

    /**
     * Selecionar bot�o "Desfavoritar'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Selecionar o botao 'Desfavoritar'")
    public MimosTela selecionarDesfavoritar() throws Exception {
        aguardarCarregamentoElemento(botaoDesfavoritar);
        tocarElemento(botaoDesfavoritar, "Houve um erro ao executar a a��o de tocar o elemento bot�o \"Desfavoritar\"");
        salvarEvidencia("Clicar no bot�o 'Desfavoritar'");
        return this;
    }

    public boolean ofertaPresenteEmCategoria(String oferta) throws Exception {
        List<MobileElement> listaOfertasCategoria;
        boolean ofertaPresente = false;
        if (android) {
            listaOfertasCategoria = retornarLista(By.xpath("//*[@resource-id = \"br.com.bradesco.next:id/ntv_title\"]"), "N�o foi poss�vel recuperar lista de categorias");
        } else {
            listaOfertasCategoria = retornarLista(MobileBy.iOSClassChain("**/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText"), "N�o foi poss�vel recuperar lista de categorias");
        }
        if (listaOfertasCategoria != null) {
            for (MobileElement ofertaCategoria : listaOfertasCategoria) {
                if (trataTexto(ofertaCategoria.getText()).contains(trataTexto(oferta))) {
                    ofertaPresente = true;
                }
            }
        }
        return ofertaPresente;
    }

    /**
     * Validar oferta na categoria
     *
     * @param categoria
     * @param oferta
     * @return MimosTela
     */
    @Step("Validar oferta na categoria")
    public MimosTela validarOfertaNaCategoria(String categoria, String oferta) throws Exception {
        validarCondicaoBooleana(ofertaPresenteEmCategoria(oferta), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel encontrar a oferta: " + oferta + " dentro da categoria: " + categoria);
        salvarEvidencia("Validada presen�a da oferta: " + oferta + " dentro da categoria: " + categoria);
        return this;
    }

    /**
     * Validar Oferta n�o presente em categoria
     *
     * @param categoria
     * @param oferta
     * @return MimosTela
     */
    @Step("Validar a exclus�o da oferta na categoria \"Favoritos\"")
    public MimosTela validarOfertaNaoPresenteNaCategoria(String categoria, String oferta) throws Exception {

        validarCondicaoBooleana(ofertaPresenteEmCategoria(oferta), MetodoComparacaoBooleano.FALSO, "Foi poss�vel encontrar a oferta: " + oferta + " dentro da categoria: " + categoria + ", mas o esperado era n�o encontrar");
        salvarEvidencia("Validada a n�o presen�a da oferta: " + oferta + " dentro da categoria: " + categoria);
        return this;
    }

    /**
     * Tocar bot�o Favoritar
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Favoritar\"")
    public MimosTela tocarBotaoFavoritar() throws Exception {
        aguardarCarregamentoElemento(botaoFavoritar);
        tocarElemento(botaoFavoritar, "Houve um erro ao executar a acao de tocar o elemento botao \"Favoritar\"");
        salvarEvidencia("Clicar no botao 'Favoritar'");
        return this;
    }

    /**
     * Tocar Segunda Estrela Avaliacao
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar segunda estrela da avaliacao")
    public MimosTela tocarSegundaEstrelaAvaliacao() throws Exception {
        aguardarCarregamentoElemento(segundaEstrelaAvaliacao);
        tocarElemento(segundaEstrelaAvaliacao, "Nao foi possivel tocar na segunda estrela da avaliacao");
        salvarEvidencia("Tocar segunda estrela em avaliacao");
        return this;
    }

    /**
     * Validar botao "Enviar" desabilitado
     *
     * @return MimosTela
     */
    @Step("validar botao \"Enviar\" desabilitado")
    public MimosTela validarBotaoEnviarDesabilitado() throws Exception {
        esconderTeclado();
        aguardarCarregamentoElemento(botaoEnviar);
        if (botaoEnviar.isEnabled()) {
            throw new AssertionError("Esperado: Bot�o \"Enviar\" Desabilitado, Resultado: Bot�o \"Enviar\" Habilitado");
        }
        salvarEvidencia("Validar botao \"Enviar\" desabilitado");
        return this;
    }

    /**
     * Preencher Campo Comentario
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Preencher campo comentario")
    public MimosTela preencherComentarios() throws Exception {
        aguardarCarregamentoElemento(campoComentario);
        escreverTexto(campoComentario, "COMENTARIO PADRAO", "Nao foi possivel escrever texto campo comentario");
        esconderTeclado();
        salvarEvidencia("Preencher campo comentario com \"COMENTARIO PADRAO\"");
        return this;
    }

    /**
     * Tocar botao "+"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botao \"=\"")
    public MimosTela tocarBotaoRetornarMenu() throws Exception {
        aguardarCarregamentoElemento(botaoMenu);
        tocarElemento(botaoMenu, "Nao foi possivel tocar botao \"=\"");
        salvarEvidencia("Tocar botao \"=\"");
        return this;
    }

    /**
     * Validar Exibicao Carrossel
     *
     * @return MimosTela
     */
    @Step("Validar Exibicao Carrossel")
    public MimosTela validarExibicaoCarrossel() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelCardCategoria),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Nao foi possivel validar a exibicao do carrossel"
        );
        salvarEvidencia("Validar exibicao do carrossel");
        return this;
    }

    /**
     * Tocar bot�o "Fechar"
     *
     * @return MimosTela
     * @throws Exception
     */
    public MimosTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "Nao foi possivel tocar na segunda estrela da avaliacao");
        salvarEvidencia("Tocar segunda estrela em avaliacao");
        return this;
    }


    /**
     * Toca Bot�o cupom de desconto
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar C�digo Promocional")
    public MimosTela tocarBotaoGerarCupomDesconto() throws Exception {
        if (!aguardarCarregamentoElemento(botaoGerarCupomDesconto)) {
            rolaTelaBaixo();
            aguardarCarregamentoElemento(botaoGerarCupomDesconto);
            salvarEvidencia("Tocar no gerar cupom de desconto");
        }
        if (getDriver() instanceof IOSDriver) {
            tocarCoordenadaElemento(botaoGerarCupomDesconto);
            salvarEvidencia("Ir para loja");
        } else {
            tocarElemento(botaoGerarCupomDesconto, "N�o foi poss�vel tocar no bot�o gerar cupom de desconto");
            salvarEvidencia("Ir para loja");
        }

        return this;
    }

    /**
     * Toca bot�o "voltar menu principal"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'voltar menu principal'")
    public MimosTela tocarBotaoVoltarMenuPrincipal() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar menu principal'");
        tocarElemento(botaoVoltarMenuPrincipal, "N�o foi poss�vel tocar bot�o 'Voltar menu principal'");
        return this;
    }

    /**
     * validar a abaertura do browser com o link do parceiro
     *
     * @return MimosTela
     * @throws Exception
     */
    public MimosTela validarAberturaBrowser(String link) throws Exception {
        aguardarCarregamentoElemento(abrindoBrowser);
        salvarEvidencia("Validando a abertura do browser com o link do parceiro:");
        verificarPresencaElemento(abrindoBrowser);
        return this;
    }

    protected void tocarCoordenadaElemento(MobileElement elemento) throws Exception {
        Point localizacao = elemento.getLocation();
        tocarCoordenada(localizacao.x, localizacao.y);
    }

    /**
     * Validar presen�a do label 'Sobre a parceria'
     */
    public MimosTela validarLabelParceria() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelSobreParceria),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar o label 'Sobre a parceria'"
        );
        salvarEvidencia("Validada a presen�a do label 'Sobre a parceria'");
        return this;
    }

    /**
     * Validar presen�a do bot�o 'Use'
     */
    public MimosTela validarPresencaBotaoUse() {
        rolaTelaBaixo();
        validarCondicaoBooleana(verificarPresencaElemento(botaoUse),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar a presen�a do bot�o 'Use'");
        salvarEvidencia("Validada a presen�a do bot�o 'Use'");
        return this;
    }

    /**
     * Tocar Botao 'Texto Oferta'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar Botao 'Texto Oferta'")
    public MimosTela tocarBotaoTextoOferta(String texto) throws Exception {
        aguardarCarregamentoElemento(botaoTextooferta);
        validarTextoOferta(botaoTextooferta, texto);
        salvarEvidencia("Tocar Botao 'Texto Oferta'");
        tocarElemento(botaoTextooferta, "N�o foi Possivel tocar no elemento 'Texto Oferta'");
        return this;
    }

    /**
     * Valida se o texto informado via parametro est� presente na tela
     *
     * @param element
     * @param texto
     * @throws Exception
     */
    private MimosTela validarTextoOferta(MobileElement element, String texto) throws Exception {
        OperadorEvidencia.logarPasso("Texto esperado ...: " + texto);
        OperadorEvidencia.logarPasso("Texto gerado .....: " + element.getText());
        validarCondicaoBooleana(Utilitarios.normalizaString(
                retornarTexto(element, "N�o foi possivel Encontrar o elemento na tela"))
                .contains(Utilitarios.normalizaString(texto)),
                MetodoComparacaoBooleano.VERDADEIRO, "N�o foi possivel verificar a mensagem");
        return this;
    }

    /**
     * Tocar Bot�o Pr�ximo Se Existir
     * @return
     * @throws NextException
     */
    @Step("Tocar Bot�o Pr�ximo Se Existir")
    public MimosTela tocarBotaoProximoSeExistir() throws NextException {
        if(verificarPresencaElemento(botaoProximo)) {
            tocarElementoSeExistir(botaoProximo, "Erro ao tocar no bot�o 'Proximo'");
            salvarEvidencia("Tocou no bot�o 'Proximo'");
        }
        return this;
    }

    /**
     * Tocar Bot�o Conhecer Se Existir
     * @return
     * @throws NextException
     */
    @Step("Tocar Bot�o Conhecer Se Existir")
    public MimosTela tocarBotaoConhecerSeExistir() throws NextException {
        if(verificarPresencaElemento(botaoConhecer)) {
            tocarElementoSeExistir(botaoConhecer, "Erro ao tocar no bot�o 'Conhecer'");
            salvarEvidencia("Tocou no bot�o 'Conhecer'");
        }
        return this;
    }

    /**
     * Tocar Bot�o Categorias Se Existir
     * @return
     * @throws NextException
     */
    @Step("Tocar Bot�o Categorias Se Existir")
    public MimosTela tocarBotaoCategoriasSeExistir() throws NextException {
        if(aguardarCarregamentoElemento(botaoCategorias)) {
            tocarElementoSeExistir(botaoCategorias, "Erro ao tocar no bot�o 'Categorias'");
            salvarEvidencia("Tocou no bot�o 'Categorias'");
        }
        return this;
    }

    /**
     * Validar tela
     * @return
     */
    private boolean validarTelaMimos(){
        if(aguardarPaginaConterTodosTextos("MIMOS"))
            return true;
        if(aguardarCarregamentoElemento(tituloTelaMimos))
            return true;
        if(aguardarVisibilidadeElemento(tituloTelaMimos, 45,1500))
            return true;
        return false;
    }

}
