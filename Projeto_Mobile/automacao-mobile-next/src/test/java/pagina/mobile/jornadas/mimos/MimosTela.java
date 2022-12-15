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

    @iOSXCUITFindBy(accessibility = "AGORA NÃO")
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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Você\"$]")
    private MobileElement textoNaoPossuiCuponsGerados;

    @AndroidFindBy(id = "br.com.bradesco.next:id/msg")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'rea de mimos')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Essa é a sua área de mimos.\"$]")
    private MobileElement textoPrimeiraTelaTutorialMimos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/msg")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Para ver todos os mimos\"$]")
    private MobileElement textoSegundaTelaTutorialMimos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/msg")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label CONTAINS \"Você pode\"$]")
    private MobileElement textoTerceiraTelaTutorialMimos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_action")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"PRÓXIMO\"]")
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

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ao clicar você vai sair do app do next\"]/following-sibling::XCUIElementTypeButton")
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
    @iOSXCUITFindBy(accessibility = "COPIAR CÓDIGO E IR PARA LOJA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"COPIAR CÓDIGO E IR PARA LOJA\"]")
    private MobileElement botaoGerarCupomDesconto;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Barra de rolagem vertical, 1 página\"]")
    private MobileElement validarLimiteScrollAcima;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.view.ViewGroup")
    @iOSXCUITFindBy(accessibility = "Barra de rolagem vertical, 1 página")
    private MobileElement validarLimiteScrollAbaixo;

    //abertura do browser no app
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.chrome:id/action_bar_root")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Endereço\"`]")
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
     * Retorna o elemento contendo o título da oferta com a descrição procurados
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
     * Validar presença tela 'MIMOS'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Validar presença tela 'MIMOS'")
    public MimosTela validarPresencaTelaMimos() throws Exception {
        validarCondicaoBooleana(validarTelaMimos(), MetodoComparacaoBooleano.VERDADEIRO, "A tela mimos não está presente!");
        salvarEvidencia("Validado App está na tela 'MIMOS'");
        return this;
    }

    /**
     * Realiza tratamento de string texto, deixando tudo em letra maiúscula e recusando qualquer caracter que não seja texto
     *
     * @param texto
     * @return String
     */
    private String trataTexto(String texto) {
        return texto.toUpperCase().replaceAll("[^A-Z]", "");
    }

    /**
     * Verifica se é o primeiro acesso do cliente a funcionalidade Mimos
     *
     * @return boolean
     */
    private boolean verificarPrimeiroAcesso() throws Exception {
        if (aguardarCarregamentoElemento(textoPrimeiraTelaTutorialMimos)) {
            return trataTexto(textoPrimeiraTelaTutorialMimos.getText()).contains(trataTexto("Essa é a sua área de mimos."));
        } else {
            return false;
        }
    }

    /**
     * Toca botão "Próximo"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Próximo\"")
    public MimosTela tocarBotaoProximo() throws Exception {
        aguardarCarregamentoElemento(botaoProximo);
        tocarElemento(botaoProximo, "Não foi possível tocar botão 'Próximo'");
        salvarEvidencia("Tocar botão 'Próximo'");
        return this;
    }

    /**
     * Toca botão "Conhecer"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Conhecer\"")
    public MimosTela tocarBotaoConhecer() throws Exception {
        aguardarCarregamentoElemento(botaoConhecer);
        salvarEvidencia("Tocar botão 'Conhecer'");
        tocarElemento(botaoConhecer, "Não foi possível tocar botão 'Conhecer'");
        return this;
    }

    /**
     * Realiza os passos de primeiro acesso sem gerar evidência para os cenários que não validam os passos do primeiro acesso
     *
     * @return MimosTela
     * @throws Exception
     */
    public MimosTela realizarPrimeiroAcessoSemEvidenciarPassos() throws Exception {
        aguardarCarregamentoElemento(botaoProximo);
        tocarElemento(botaoProximo, "Não foi possível tocar botão 'Próximo'");
        aguardarCarregamentoElemento(botaoProximo);
        tocarElemento(botaoProximo, "Não foi possível tocar botão 'Próximo'");
        aguardarCarregamentoElemento(botaoConhecer);
        tocarElemento(botaoConhecer, "Não foi possível tocar botão 'Conhecer'");
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
        escreverTexto(campoBusca, oferta, "Não foi possível preencher campo de busca");
        salvarEvidencia("Preencher Campo Busca com valor: \"" + oferta + "\"");
        return this;
    }

    /**
     * Toca botão "Ver Meus Cupons"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Ver meus Cupons\"")
    public MimosTela tocarBotaoVerMeusCupons() throws Exception {
        rolaTelaBaixo();
        if(!aguardarCarregamentoElemento(botaoVerMeusCupons))
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVerMeusCupons, "O botão 'VER MEUS CUPONS' não foi encontrado!");
        salvarEvidencia("Visualizar botão Meus Cupons");
        tocarElemento(botaoVerMeusCupons, "Não foi possível tocar no botão 'VER MEUS CUPONS'!");
        return this;
    }

    /**
     * Validar Mensagem "Não Possui Cupons Gerados
     *
     * @return MimosTela
     */
    @Step("Validar Mensagem \"Você não possui cupons gerados até o momento\"")
    public MimosTela validarMensagemNaoPossuiCuponsGerados() throws Exception {
        aguardarCarregamentoElemento(textoNaoPossuiCuponsGerados);
        String mensagemEsperadaNaoPossuiCuponsGerados = "Você não possui cupons gerados até o momento";
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
        tocarElemento(oferta, "Não foi possível selecionar Oferta");
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
        String mensagemEsperadaTela = "Essa é a sua área de mimos. Cada vez que entrar, você vai ver um mimo diferente em destaque.";
        String mensagemGerada = MobileUtils.localizarTexto(mensagemEsperadaTela);
        validarCondicaoBooleana(Strings.isNotNullAndNotEmpty(mensagemGerada),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar texto da primeira mensagem.");
        salvarEvidencia("Validar exibição do texto \"" + mensagemGerada.replace("\n","") + "\" na primeira tela de Tutorial Mimos (Primeiro Acesso)");
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
        String mensagemEsperadaTela = "Para ver todos os mimos é só ir em categorias, lá você acessa os detalhes de cada um.";
        String mensagemGerada = MobileUtils.localizarTexto(mensagemEsperadaTela);
        validarCondicaoBooleana(Strings.isNotNullAndNotEmpty(mensagemGerada),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar texto da segunda mensagem.");
        salvarEvidencia("Validar exibição do texto \"" + mensagemGerada.replace("\n","") + "\" na segunda tela de Tutorial Mimos (Primeiro Acesso)");
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
        String mensagemEsperadaTela = "Você pode favoritar os mimos que mais gostar.";
        String mensagemGerada = MobileUtils.localizarTexto(mensagemEsperadaTela);
        validarCondicaoBooleana(Strings.isNotNullAndNotEmpty(mensagemGerada),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar texto da terceira mensagem.");
        salvarEvidencia("Validou exibição do texto \"" + mensagemGerada.replace("\n","") + "\" na terceira tela de Tutorial Mimos (Primeiro Acesso)");
        return this;
    }

    /**
     * Tocar botão "Categorias"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Categorias\"")
    public MimosTela tocarBotaoCategorias() throws Exception {
        if (verificarPrimeiroAcesso()) {
            realizarPrimeiroAcessoSemEvidenciarPassos();
        }
        aguardarCarregamentoElemento(botaoCategorias);
        salvarEvidencia("Visualizar Card Mimos");
        tocarElemento(botaoCategorias, "Não foi possível selecionar o botão \"Categorias\"");
        salvarEvidencia("Tocar botão \"Categorias\"");
        return this;
    }

    /**
     * Tocar botão conhecer tela primeiro acesso caso ela esteja presente
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão conhecer tela primeiro acesso caso ela esteja presente")
    public MimosTela tocarBotaoConhecerTelaPrimeiroAcesso() throws Exception {
        if (verificarPrimeiroAcesso()) {
            realizarPrimeiroAcessoSemEvidenciarPassos();
        }
        salvarEvidencia("Tocado botão 'Conhecer' na tela de primeiro acesso!");
        return this;
    }

    /**
     * Desliza carrossel até encontar categoria procurada
     *
     * @param categoria
     * @return MimosTela
     */
    @Step("Deslizar carrossel até encontrar card da categoria procurada")
    public MimosTela deslizarCarrosselAteAcharCategoria(String categoria) throws Exception {
        OperadorEvidencia.logarPasso(">>Procurando pela categoria: " + categoria);
        OperadorEvidencia.logarPasso("Caso nao encontre, alterar na massa para outra Categoria disponivel");
        deslizarCarrosselAteEncontrarTexto(labelCardCategoria, categoria, Direcao.DIREITA,20,80,  "String mensagemErro");
        salvarEvidencia("Deslizar carrossel até encontrar card da categoria: \"" + categoria + "\"");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelCardOferta, "Não foi possivel encontrar o elemento 'Oferta'");
        salvarEvidencia("Selecionar oferta: \"" + oferta + "\"");
        tocarElemento(labelCardOferta, "Não foi possível selecionar oferta: \"" + oferta + "\"");
        return this;
    }

    /**
     * Toca ícone "Como Usar"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar ícone \"Como Usar\"")
    public MimosTela tocarIconeComoUsar() throws Exception {
        aguardarCarregamentoElemento(iconeComoUsar);
        tocarElemento(iconeComoUsar, "Não foi possível tocar no ícone \"Como Usar\"");
        salvarEvidencia("Tocar no ícone \"Como Usar\"");
        return this;
    }

    /**
     * Toca Código Promocional
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar Código Promocional")
    public MimosTela tocarBotaoCodigoPromocional() throws Exception {
        if (!aguardarCarregamentoElemento(codigoPromocional)) {
            rolaTelaBaixo();
            aguardarCarregamentoElemento(codigoPromocional);
        }
        if (getDriver() instanceof IOSDriver) {
            tocarElemento(codigoPromocional, "Não foi possível tocar no código promocional");
            Assert.assertEquals(trataTexto(codigoPromocional.getText()), trataTexto("CÓDIGO COPIADO!"));
        } else {
            tocarElemento(codigoPromocional, "Não foi possível tocar no código promocional");
        }
        salvarEvidencia("Tocar no código promocional");
        return this;
    }

    /**
     * Tocar botão "IR PARA PARCEIROS" (O texto do botão pode variar de acordo com a oferta)
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"IR PARA PARCEIRO\"")
    public MimosTela tocarBotaoIrParaParceiros() throws Exception {
        if (!aguardarCarregamentoElemento(botaoIrParaParceiros)) {
            rolaTelaBaixo();
        }
        String textoBotaoIrParaParceiros = botaoIrParaParceiros.getText();
        tocarElemento(botaoIrParaParceiros, "Não foi possível tocar botão \"IR PARA PARCEIROS\"");
        if (getDriver() instanceof AndroidDriver) {
            if (aguardarCarregamentoElemento(iconeNavegadorAndroid)) {
                tocarElemento(iconeNavegadorAndroid, "Não foi possível selecionar \"Navegador\"");
                tocarElemento(botaoApenasUmaVezAndroid, "Não foi possível tocar no botão \"APENAS UMA VEZ\"");
            }
        }
        aguardarCarregamentoElemento(appBrowserWeb);
        salvarEvidencia("Tocar botão \"" + textoBotaoIrParaParceiros + "\"");
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
            throw new AssertionError("Não houve direcionamento para App de Browser Web");
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
            //dá swipe para retornar carrossel
            aguardarCarregamentoElemento(cardMimo);
            rolaTelaBaixo();
            //procura seleciona a oferta
            aguardarCarregamentoElemento(campoBusca);
            escreverTexto(campoBusca, oferta, "Não foi possível preencher campo de busca");
            aguardarCarregamentoElemento(botaoPrimeiraOfertaConsultada);
            tocarElemento(botaoPrimeiraOfertaConsultada, "Não foi possível selecionar Oferta");
        }
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Retornar para o Next");
        return this;
    }

    /**
     * Tocar Botão "Mais Opções"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"...\" no canto superior direito da tela")
    public MimosTela tocarBotaoMaisOpcoes() throws Exception {
        System.out.println(">> Botão \"...\" somente está disponível para MIMOS sem avaliação");
        aguardarCarregamentoElemento(botaoMaisOpcoes);
        tocarElemento(botaoMaisOpcoes, "Não foi possível tocar no ícone \"...\" no canto superior direito da tela");
        salvarEvidencia("Tocar no ícone \"...\" no canto superior direito da tela");
        return this;
    }

    /**
     * Tocar botão "Avaliar Mimo"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar no botão \"Avaliar Mimo\"")
    public MimosTela tocarBotaoAvaliarMimos() throws Exception {
        aguardarCarregamentoElemento(botaoAvaliarMimo);
        tocarElemento(botaoAvaliarMimo, "Não foi possível tocar no botão \"Avaliar Mimos\"");
        salvarEvidencia("Tocar no botão \"Avaliar Mimos\"");
        return this;
    }

    /**
     * Tocar Quinta Estrela Avaliação
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar quinta estrela Avaliação")
    public MimosTela tocarQuintaEstrelaAvaliacao() throws Exception {
        aguardarCarregamentoElemento(QuintaEstrelaAvaliacao);
        if (getDriver() instanceof AndroidDriver) {
            esconderTeclado();
        }
        tocarElemento(QuintaEstrelaAvaliacao, "Não foi possível tocar na quinta estrela da avaliação");
        salvarEvidencia("Tocar quinta estrela em avaliação");
        return this;
    }

    /**
     * Tocar botão "Enviar"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão no \"Enviar\"")
    public MimosTela tocarBotaoEnviar() throws Exception {
        aguardarCarregamentoElemento(botaoEnviar);
        tocarElemento(botaoEnviar, "Não foi possível tocar botão no \"Enviar\"");
        salvarEvidencia("Tocar botão no \"Enviar\"");
        return this;
    }

    /**
     * Validar Não exibição do botão "..."
     *
     * @return MimosTela
     */
    @Step("Validar ícone \"...\" não está presente na tela")
    public MimosTela validarNaoExibicaoBotaoMaisOpcoes() throws Exception {
        if (!aguardarCarregamentoElemento(botaoVoltar)) {
            throw new AssertionError("Tela não foi carregada com sucesso");
        } else if (aguardarCarregamentoElemento(botaoMaisOpcoes)) {
            throw new AssertionError("ícone \"...\" está presente na tela");
        }
        salvarEvidencia("Validar ícone \"...\" não está presente na tela");
        return this;
    }

    /**
     * Tocar botão "Usar Mimo"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão no \"Usar Mimo\"")
    public MimosTela tocarBotaoUsarMimo() throws Exception {
        aguardarCarregamentoElemento(botaoUsarMimo);
        tocarElemento(botaoUsarMimo, "Não foi possível tocar botão \"Usar Mimo\"");
        salvarEvidencia("Tocar botão no \"Usar Mimo\"");
        return this;
    }

    /**
     * Tocar botão "Voltar"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão no \"Usar Mimo\"")
    public MimosTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar botão \"Voltar\"");
        tocarElemento(botaoVoltar, "Não foi possível tocar botão \"Voltar\"");
        return this;
    }

    /**
     * Apaga texto do campo de busca
     *
     * @return MimosTela
     * @throws Exception
     */
    public MimosTela apagarCampoBusca() throws Exception {
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(campoBusca, "Campo Busca não encontrado");
        apagarCampoTexto(campoBusca, "Não foi possível limpar campo busca");
        salvarEvidencia("Apagar Campo Busca");
        return this;
    }

    /**
     * Validar Oferta Não Possui Código Promocional
     *
     * @return MimosTela
     */
    @Step("Validar oferta não possui código promocional")
    public MimosTela validarCodigoPromocional(Boolean temCodigoPromocional) throws Exception {
        if (temCodigoPromocional) {
            if (!aguardarCarregamentoElemento(codigoPromocional)) {
                rolaTelaBaixo();
                aguardarCarregamentoElemento(codigoPromocional);
            }
            if (ios) {
                tocarElemento(codigoPromocional, "Não foi possível tocar no código promocional");
                Assert.assertEquals(trataTexto(codigoPromocional.getText()), trataTexto("CÓDIGO COPIADO!"));
            } else {
                tocarElemento(codigoPromocional, "Não foi possível tocar no código promocional");
            }
            salvarEvidencia("Tocar no código promocional");
        } else {
            if (aguardarCarregamentoElemento(codigoPromocional)) {
                throw new AssertionError("Esperado: Oferta sem código promissional, Real: Código Promocional encontrado na tela");
            }
            salvarEvidencia("Validar Oferta não possui código promocional");
        }

        return this;
    }

    /**
     * Tocar botão "Próximo"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Próximo\"")
    public MimosTela tocarProximo() throws Exception {
        aguardarCarregamentoElemento(botaoProximo);
        salvarEvidencia("Tocar botão \"Próximo\"");
        tocarElemento(botaoProximo, "Não foi possível tocar botão \"Próximo\"");
        return this;
    }

    /**
     * Toca botão "voltar menu"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"voltar menu\"")
    public MimosTela tocarVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar menu'");
        tocarElemento(botaoMenu, "Não foi possível tocar no botão 'Menu' para voltar");
        return this;
    }

    /**
     * Toca botão "tocar Categorias"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"tocar Categorias\"")
    public MimosTela tocarCategorias() throws Exception {
        aguardarCarregamentoElemento(botaoCategorias);
        tocarElemento(botaoCategorias, "Não foi possível tocar botão 'tocar Categorias'");
        salvarEvidencia("Tocar botão 'tocar Categorias'");
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
     * Toca botão "acessar Oferta"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"voltar acessar Oferta\"")
    public MimosTela acessarOferta() throws Exception {
        aguardarCarregamentoElemento(indicadorCategoria);
        esconderTeclado();
        if (android)
            tocarCoordenadaProporcional(49, 62);
        salvarEvidencia("Tocar botão 'Acessar oferta com nome alterado'");
        return this;
    }

    /**
     * Toca botão da oferta (promoção) e descrição específicos
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Promoção\"")
    public MimosTela acessarOferta(String promocao, String descricao) throws Exception {
        esconderTeclado();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(
                botaoOfertaDescricao(promocao, descricao), "Não foi possível encontrar a oferta '" +
                        promocao + "' e descrição '" + descricao + "'"
        );
        salvarEvidencia("Tocar botão 'Acessar oferta com nome alterado'");
        tocarElemento(botaoOfertaDescricao(promocao, descricao),
                "A oferta foi encontrada mas não foi possível tocar no botão");
        return this;
    }

    /**
     * Toca botão (x) "limpar texto"
     *
     * @return MimoaTela
     * @throws Exception
     */
    @Step("Tocar botão \"limpar texto\"")
    public MimosTela limparTexto() throws Exception {
        aguardarCarregamentoElemento(limparTexto);
        tocarElemento(limparTexto, "Não foi possível tocar botão (x) 'Limpar texto'");
        salvarEvidencia("Tocar botão (x) 'limpar texto'");
        return this;
    }

    /**
     * Validar alteração no Card de oferta
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Validar alteração no Card de oferta")
    public MimosTela validarNomeOferta() throws Exception {
        aguardarCarregamentoElemento(validarNomeOferta);
        compararElementoTexto(validarNomeOferta, Oferta.DESCRICAO_OFERTA, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar alteração no Card de oferta");
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
     * Tocar botão "GERAR CUPOM DE DESCONTO"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"GERAR CUPOM DE DESCONTO\"")
    public MimosTela tocarBotaoGerarCupomDeDesconto() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão no \"GERAR CUPOM\"");
        String mensagemErro = "Não foi possível encontrar o botão 'Gerar Cupom de Desconto'";
        if (ios) {
            tocarElementoOculto("//*[@name='GERAR CUPOM DE DESCONTO']", mensagemErro);
        } else {
            tocarElemento(botaoGerarCupom, mensagemErro);
        }
        return this;
    }

    /**
     * Tocar botão "REGRAS DE USO"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"REGRAS DE USO\"")
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
            salvarEvidencia("Tocar no botão \"REGRAS DE USO\"");
            botaoRegrasDeUso.click();
        }else {
            aguardarCarregamentoElemento(botaoRegrasDeUso);
            salvarEvidencia("Tocar no botão \"REGRAS DE USO\"");
            tocarCoordenada(botaoRegrasDeUso);
        }
        return this;
    }

    /**
     * Validar exibição de mensagem de regras de uso cadastrada no sistema de gestão
     *
     * @return MimosTela
     */
    @Step("Validar exibição de mensagem de regras de uso cadastrada no sistema de gestão")
    public MimosTela validarExibicaoTextoCadastradoRegrasDeUso() throws Exception {
      if (aguardarCarregamentoElemento(textoCadastradoRegrasDeUso)) {
            salvarEvidencia("Validar exibição de mensagem de regras de uso cadastrada no sistema de gestão");
      } else {
           throw new NoSuchElementException("Não foi possível verificar a exibição da mensagem de regras de uso cadastrada no sistema de gestão");
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
     * Tocar botão "OK"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"OK\"")
    public MimosTela tocarBotaoOkPopUp() throws Exception {
        aguardarCarregamentoElemento(botaoOK);
        tocarElemento(botaoOK, "Não foi possível tocar botão \"OK, Entendi\"");
        aguardarCarregamentoElemento(headerCupomDeDesconto);
        salvarEvidencia("Tocar botão \"OK, Entendi\"");
        return this;
    }

    /**
     * Validar Exibição do Header de cupom de desconto
     *
     * @return MimosTela
     */
    @Step("Validar Exibição do Header de cupom de desconto")
    public MimosTela validarExibicaoHeaderCupomDeDesconto() throws Exception {
        if (aguardarCarregamentoElemento(headerCupomDeDesconto)) {
            salvarEvidencia("Validar exibição do header Cupom de Desconto");
        } else {
            throw new NoSuchElementException("Não foi possível verificar o carregamento do header Cupom de Desconto");
        }
        return this;
    }

    /**
     * Selecionar botão "Desfavoritar'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Selecionar o botao 'Desfavoritar'")
    public MimosTela selecionarDesfavoritar() throws Exception {
        aguardarCarregamentoElemento(botaoDesfavoritar);
        tocarElemento(botaoDesfavoritar, "Houve um erro ao executar a ação de tocar o elemento botão \"Desfavoritar\"");
        salvarEvidencia("Clicar no botão 'Desfavoritar'");
        return this;
    }

    public boolean ofertaPresenteEmCategoria(String oferta) throws Exception {
        List<MobileElement> listaOfertasCategoria;
        boolean ofertaPresente = false;
        if (android) {
            listaOfertasCategoria = retornarLista(By.xpath("//*[@resource-id = \"br.com.bradesco.next:id/ntv_title\"]"), "Não foi possível recuperar lista de categorias");
        } else {
            listaOfertasCategoria = retornarLista(MobileBy.iOSClassChain("**/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText"), "Não foi possível recuperar lista de categorias");
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
        validarCondicaoBooleana(ofertaPresenteEmCategoria(oferta), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível encontrar a oferta: " + oferta + " dentro da categoria: " + categoria);
        salvarEvidencia("Validada presença da oferta: " + oferta + " dentro da categoria: " + categoria);
        return this;
    }

    /**
     * Validar Oferta não presente em categoria
     *
     * @param categoria
     * @param oferta
     * @return MimosTela
     */
    @Step("Validar a exclusão da oferta na categoria \"Favoritos\"")
    public MimosTela validarOfertaNaoPresenteNaCategoria(String categoria, String oferta) throws Exception {

        validarCondicaoBooleana(ofertaPresenteEmCategoria(oferta), MetodoComparacaoBooleano.FALSO, "Foi possível encontrar a oferta: " + oferta + " dentro da categoria: " + categoria + ", mas o esperado era não encontrar");
        salvarEvidencia("Validada a não presença da oferta: " + oferta + " dentro da categoria: " + categoria);
        return this;
    }

    /**
     * Tocar botão Favoritar
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Favoritar\"")
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
            throw new AssertionError("Esperado: Botão \"Enviar\" Desabilitado, Resultado: Botão \"Enviar\" Habilitado");
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
     * Tocar botão "Fechar"
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
     * Toca Botão cupom de desconto
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar Código Promocional")
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
            tocarElemento(botaoGerarCupomDesconto, "Não foi possível tocar no botão gerar cupom de desconto");
            salvarEvidencia("Ir para loja");
        }

        return this;
    }

    /**
     * Toca botão "voltar menu principal"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão 'voltar menu principal'")
    public MimosTela tocarBotaoVoltarMenuPrincipal() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar menu principal'");
        tocarElemento(botaoVoltarMenuPrincipal, "Não foi possível tocar botão 'Voltar menu principal'");
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
     * Validar presença do label 'Sobre a parceria'
     */
    public MimosTela validarLabelParceria() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelSobreParceria),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar o label 'Sobre a parceria'"
        );
        salvarEvidencia("Validada a presença do label 'Sobre a parceria'");
        return this;
    }

    /**
     * Validar presença do botão 'Use'
     */
    public MimosTela validarPresencaBotaoUse() {
        rolaTelaBaixo();
        validarCondicaoBooleana(verificarPresencaElemento(botaoUse),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar a presença do botão 'Use'");
        salvarEvidencia("Validada a presença do botão 'Use'");
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
        tocarElemento(botaoTextooferta, "Não foi Possivel tocar no elemento 'Texto Oferta'");
        return this;
    }

    /**
     * Valida se o texto informado via parametro está presente na tela
     *
     * @param element
     * @param texto
     * @throws Exception
     */
    private MimosTela validarTextoOferta(MobileElement element, String texto) throws Exception {
        OperadorEvidencia.logarPasso("Texto esperado ...: " + texto);
        OperadorEvidencia.logarPasso("Texto gerado .....: " + element.getText());
        validarCondicaoBooleana(Utilitarios.normalizaString(
                retornarTexto(element, "Não foi possivel Encontrar o elemento na tela"))
                .contains(Utilitarios.normalizaString(texto)),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possivel verificar a mensagem");
        return this;
    }

    /**
     * Tocar Botão Próximo Se Existir
     * @return
     * @throws NextException
     */
    @Step("Tocar Botão Próximo Se Existir")
    public MimosTela tocarBotaoProximoSeExistir() throws NextException {
        if(verificarPresencaElemento(botaoProximo)) {
            tocarElementoSeExistir(botaoProximo, "Erro ao tocar no botão 'Proximo'");
            salvarEvidencia("Tocou no botão 'Proximo'");
        }
        return this;
    }

    /**
     * Tocar Botão Conhecer Se Existir
     * @return
     * @throws NextException
     */
    @Step("Tocar Botão Conhecer Se Existir")
    public MimosTela tocarBotaoConhecerSeExistir() throws NextException {
        if(verificarPresencaElemento(botaoConhecer)) {
            tocarElementoSeExistir(botaoConhecer, "Erro ao tocar no botão 'Conhecer'");
            salvarEvidencia("Tocou no botão 'Conhecer'");
        }
        return this;
    }

    /**
     * Tocar Botão Categorias Se Existir
     * @return
     * @throws NextException
     */
    @Step("Tocar Botão Categorias Se Existir")
    public MimosTela tocarBotaoCategoriasSeExistir() throws NextException {
        if(aguardarCarregamentoElemento(botaoCategorias)) {
            tocarElementoSeExistir(botaoCategorias, "Erro ao tocar no botão 'Categorias'");
            salvarEvidencia("Tocou no botão 'Categorias'");
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
