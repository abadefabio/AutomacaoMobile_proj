package pagina.mobile.jornadas.mimos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.mimos.Oferta;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class OfertaMimosTela extends PaginaBase {

    public OfertaMimosTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"voltar\")]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"menu\")]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Mais op��es")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Mais op��es\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$label contains \"Mais\"$]")
    private MobileElement botaoMaisOpcoes;

    @iOSXCUITFindBy(accessibility = "Avaliar mimo")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_question")
    private MobileElement botaoAvaliarMimo;

    @AndroidFindBy(xpath = "//*[@text = \"FAVORITAR\"]")
    @iOSXCUITFindBy(accessibility = "FAVORITAR")
    private MobileElement botaoFavoritar;

    @AndroidFindBy(xpath = "//*[@text = \"DESFAVORITAR\"]")
    @iOSXCUITFindBy(accessibility = "DESFAVORITAR")
    private MobileElement botaoDesfavoritar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_action")
    @iOSXCUITFindBy(accessibility = "PEGAR CODIGO")
    private MobileElement botaoUsarMimo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_how_to_use_title")
    @iOSXCUITFindBy(accessibility = "Como usar")
    @iOSXCUITFindBy(accessibility = "Como usar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/following-sibling::XCUIElementTypeOther[1]")
    private MobileElement botaoComoUsarEstaOferta;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout")
    @iOSXCUITFindBy(accessibility = "COD002")
    private MobileElement botaoToqueParaCopiar;

    // AVALIAR MAPEAMENTO E LOCAL CORRETO
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_get_voucher")
    @iOSXCUITFindBy(xpath = " //*[@name=\"GERAR CUPOM DE DESCONTO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"GERAR CUPOM DE DESCONTO\"]")
    private MobileElement botaoGerarCupom;

    // AVALIAR MAPEAMENTO E LOCAL CORRETO
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_copy_voucher")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Clique aqui para gerar cupom de desconto\"")
    @iOSXCUITFindBy(accessibility = "COPIAR C�DIGO E IR PARA LOJA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"COPIAR C�DIGO E IR PARA LOJA\"]")
    private MobileElement botaoGerarCupomDesconto;

    // AVALIAR MAPEAMENTO E LOCAL CORRETO
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_see_vouchers")
    @iOSXCUITFindBy(xpath = "//*[@name=\"VER MEUS CUPONS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"VER MEUS CUPONS\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Clique aqui para ver meus cupons resgatados dessa oferta\"")
    private MobileElement botaoVerMeusCupons;

    // AVALIAR MAPEAMENTO E LOCAL CORRETO
    @iOSXCUITFindBy(iOSClassChain = "**XCUIElementTypeCell/XCUIElementTypeButton")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_text")
    private MobileElement codigoPromocional;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_partner")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"XboxOne\"]")
    private MobileElement validarNomeOferta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_partner_title")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/ntv_partner_title']")
    @AndroidFindBy(xpath = "//*[contains(@text,'Sobre a parceria')]")
    @iOSXCUITFindBy(accessibility = "Sobre a parceria")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Sobre a parceria\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sobre a parceria\"]")
    private MobileElement labelSobreParceria;

    /**
     * Toca bot�o 'Ver Meus Cupons'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ver meus Cupons'")
    public OfertaMimosTela tocarBotaoVerMeusCupons() throws Exception {
        if (!aguardarCarregamentoElemento(botaoVerMeusCupons)) {
            rolaTelaBaixo();
        }
        salvarEvidencia("Tocar bot�o 'Ver Meus Cupons'");
        tocarElemento(botaoVerMeusCupons, "N�o foi poss�vel tocar no bot�o 'Meus Cupons'!");
        return this;
    }

    /**
     * Toca �cone "Como Usar"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar �cone \"Como Usar\"")
    public OfertaMimosTela tocarBotaoComoUsarEstaOferta() throws Exception {
        aguardarCarregamentoElemento(botaoComoUsarEstaOferta);
        salvarEvidencia("Tocar no bot�o 'Como Usar Esta Oferta'");
        tocarElemento(botaoComoUsarEstaOferta, "N�o foi poss�vel tocar no bot�o 'Como Usar Esta Oferta'!");
        return this;
    }

    /**
     * Tocar Bot�o 'Mais Op��es'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Mais Op��es (...)' no canto superior direito da tela")
    public OfertaMimosTela tocarBotaoMaisOpcoes() throws Exception {
        aguardarCarregamentoElemento(botaoMaisOpcoes);
        salvarEvidencia("Tocar no �cone 'Mais Op��es (...)' no canto superior direito da tela");
        tocarElemento(botaoMaisOpcoes, "N�o foi poss�vel tocar no �cone 'Mais Op��es (...)' no canto superior direito da tela");
        return this;
    }

    /**
     * Tocar bot�o 'Avaliar Mimo'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Avaliar Mimo'")
    public OfertaMimosTela tocarBotaoAvaliarMimos() throws Exception {
        aguardarCarregamentoElemento(botaoAvaliarMimo);
        salvarEvidencia("Tocar no bot�o 'Avaliar Mimos'!");
        tocarElemento(botaoAvaliarMimo, "N�o foi poss�vel tocar no bot�o 'Avaliar Mimos'!");
        return this;
    }

    /**
     * Tocar bot�o 'Usar Mimo'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o no 'Usar Mimo'")
    public OfertaMimosTela tocarBotaoUsarMimo() throws Exception {
        aguardarCarregamentoElemento(botaoUsarMimo);
        tocarElemento(botaoUsarMimo, "N�o foi poss�vel tocar bot�o 'Usar Mimo'!");
        salvarEvidencia("Tocar bot�o no 'Usar Mimo'!");
        return this;
    }

    /**
     * Validar altera��o no Card de oferta
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Validar altera��o no Card de oferta")
    public OfertaMimosTela validarNomeOferta() throws Exception {
        aguardarCarregamentoElemento(validarNomeOferta);
        salvarEvidencia("Validar altera��o no Card de oferta");
        compararElementoTexto(validarNomeOferta, Oferta.DESCRICAO_OFERTA, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Tocar bot�o 'GERAR CUPOM DE DESCONTO'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'GERAR CUPOM DE DESCONTO'")
    public OfertaMimosTela tocarBotaoGerarCupomDeDesconto() throws Exception {
        salvarEvidencia("Tocar bot�o no 'GERAR CUPOM'");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoGerarCupom, "Erro ao tocar no bot�o 'Gerar Cupom'!");
        tocarElemento(botaoGerarCupom, "N�o foi poss�vel tocar no bot�o 'Gerar Cupom'!");
        return this;
    }

    /**
     * Tocar bot�o Favoritar
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Favoritar\"")
    public OfertaMimosTela tocarBotaoFavoritar() throws Exception {
        aguardarCarregamentoElemento(botaoFavoritar);
        tocarElemento(botaoFavoritar, "Houve um erro ao executar a acao de tocar o elemento botao \"Favoritar\"");
        salvarEvidencia("Clicar no botao 'Favoritar'");
        return this;
    }

    /**
     * Selecionar bot�o "Desfavoritar'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Selecionar o botao 'Desfavoritar'")
    public OfertaMimosTela selecionarDesfavoritar() throws Exception {
        aguardarCarregamentoElemento(botaoDesfavoritar);
        tocarElemento(botaoDesfavoritar, "Houve um erro ao executar a a��o de tocar o elemento bot�o 'Desfavoritar'!");
        salvarEvidencia("Clicar no bot�o 'Desfavoritar'!");
        return this;
    }

    /**
     * Toca Bot�o cupom de desconto
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar C�digo Promocional")
    public OfertaMimosTela tocarBotaoGerarCupomDesconto() throws Exception {
        if (!aguardarCarregamentoElemento(botaoGerarCupomDesconto)) {
            rolaTelaBaixo();
            aguardarCarregamentoElemento(botaoGerarCupomDesconto);
            salvarEvidencia("Tocar no gerar cupom de desconto");
        }
        if (getDriver() instanceof IOSDriver) {
            tocarElemento(botaoGerarCupomDesconto, "N�o foi poss�vel tocar no bot�o 'Gerar Cupom de Desconto'!");
            salvarEvidencia("Ir para loja");
        } else {
            tocarElemento(botaoGerarCupomDesconto, "N�o foi poss�vel tocar no bot�o gerar cupom de desconto");
            salvarEvidencia("Ir para loja");
        }
        return this;
    }

    /**
     * Validar presen�a do label 'Sobre a parceria'
     */
    public OfertaMimosTela validarLabelParceria() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelSobreParceria),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar o label 'Sobre a parceria'"
        );
        salvarEvidencia("Validada a presen�a do label 'Sobre a parceria'");
        return this;
    }

    /**
     * Valida se o texto informado via parametro est� presente na tela
     *
     * @param element
     * @param texto
     * @throws Exception
     */
    private void validarTextoOferta(MobileElement element, String texto) throws Exception {
        validarCondicaoBooleana(retornarTexto(element, "N�o foi possivel Encontrar o elemento na tela").contains(texto),
                MetodoComparacaoBooleano.VERDADEIRO, "N�o foi possivel verificar a mensagem");
    }
}
