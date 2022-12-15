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
    @AndroidFindBy(accessibility = "Mais opções")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Mais opções\"]")
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
    @iOSXCUITFindBy(accessibility = "COPIAR CÓDIGO E IR PARA LOJA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"COPIAR CÓDIGO E IR PARA LOJA\"]")
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
     * Toca botão 'Ver Meus Cupons'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão 'Ver meus Cupons'")
    public OfertaMimosTela tocarBotaoVerMeusCupons() throws Exception {
        if (!aguardarCarregamentoElemento(botaoVerMeusCupons)) {
            rolaTelaBaixo();
        }
        salvarEvidencia("Tocar botão 'Ver Meus Cupons'");
        tocarElemento(botaoVerMeusCupons, "Não foi possível tocar no botão 'Meus Cupons'!");
        return this;
    }

    /**
     * Toca ícone "Como Usar"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar ícone \"Como Usar\"")
    public OfertaMimosTela tocarBotaoComoUsarEstaOferta() throws Exception {
        aguardarCarregamentoElemento(botaoComoUsarEstaOferta);
        salvarEvidencia("Tocar no botão 'Como Usar Esta Oferta'");
        tocarElemento(botaoComoUsarEstaOferta, "Não foi possível tocar no botão 'Como Usar Esta Oferta'!");
        return this;
    }

    /**
     * Tocar Botão 'Mais Opções'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão 'Mais Opções (...)' no canto superior direito da tela")
    public OfertaMimosTela tocarBotaoMaisOpcoes() throws Exception {
        aguardarCarregamentoElemento(botaoMaisOpcoes);
        salvarEvidencia("Tocar no ícone 'Mais Opções (...)' no canto superior direito da tela");
        tocarElemento(botaoMaisOpcoes, "Não foi possível tocar no ícone 'Mais Opções (...)' no canto superior direito da tela");
        return this;
    }

    /**
     * Tocar botão 'Avaliar Mimo'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Avaliar Mimo'")
    public OfertaMimosTela tocarBotaoAvaliarMimos() throws Exception {
        aguardarCarregamentoElemento(botaoAvaliarMimo);
        salvarEvidencia("Tocar no botão 'Avaliar Mimos'!");
        tocarElemento(botaoAvaliarMimo, "Não foi possível tocar no botão 'Avaliar Mimos'!");
        return this;
    }

    /**
     * Tocar botão 'Usar Mimo'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão no 'Usar Mimo'")
    public OfertaMimosTela tocarBotaoUsarMimo() throws Exception {
        aguardarCarregamentoElemento(botaoUsarMimo);
        tocarElemento(botaoUsarMimo, "Não foi possível tocar botão 'Usar Mimo'!");
        salvarEvidencia("Tocar botão no 'Usar Mimo'!");
        return this;
    }

    /**
     * Validar alteração no Card de oferta
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Validar alteração no Card de oferta")
    public OfertaMimosTela validarNomeOferta() throws Exception {
        aguardarCarregamentoElemento(validarNomeOferta);
        salvarEvidencia("Validar alteração no Card de oferta");
        compararElementoTexto(validarNomeOferta, Oferta.DESCRICAO_OFERTA, MetodoComparacao.CONTEM);
        return this;
    }

    /**
     * Tocar botão 'GERAR CUPOM DE DESCONTO'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão 'GERAR CUPOM DE DESCONTO'")
    public OfertaMimosTela tocarBotaoGerarCupomDeDesconto() throws Exception {
        salvarEvidencia("Tocar botão no 'GERAR CUPOM'");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoGerarCupom, "Erro ao tocar no botão 'Gerar Cupom'!");
        tocarElemento(botaoGerarCupom, "Não foi possível tocar no botão 'Gerar Cupom'!");
        return this;
    }

    /**
     * Tocar botão Favoritar
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"Favoritar\"")
    public OfertaMimosTela tocarBotaoFavoritar() throws Exception {
        aguardarCarregamentoElemento(botaoFavoritar);
        tocarElemento(botaoFavoritar, "Houve um erro ao executar a acao de tocar o elemento botao \"Favoritar\"");
        salvarEvidencia("Clicar no botao 'Favoritar'");
        return this;
    }

    /**
     * Selecionar botão "Desfavoritar'
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Selecionar o botao 'Desfavoritar'")
    public OfertaMimosTela selecionarDesfavoritar() throws Exception {
        aguardarCarregamentoElemento(botaoDesfavoritar);
        tocarElemento(botaoDesfavoritar, "Houve um erro ao executar a ação de tocar o elemento botão 'Desfavoritar'!");
        salvarEvidencia("Clicar no botão 'Desfavoritar'!");
        return this;
    }

    /**
     * Toca Botão cupom de desconto
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar Código Promocional")
    public OfertaMimosTela tocarBotaoGerarCupomDesconto() throws Exception {
        if (!aguardarCarregamentoElemento(botaoGerarCupomDesconto)) {
            rolaTelaBaixo();
            aguardarCarregamentoElemento(botaoGerarCupomDesconto);
            salvarEvidencia("Tocar no gerar cupom de desconto");
        }
        if (getDriver() instanceof IOSDriver) {
            tocarElemento(botaoGerarCupomDesconto, "Não foi possível tocar no botão 'Gerar Cupom de Desconto'!");
            salvarEvidencia("Ir para loja");
        } else {
            tocarElemento(botaoGerarCupomDesconto, "Não foi possível tocar no botão gerar cupom de desconto");
            salvarEvidencia("Ir para loja");
        }
        return this;
    }

    /**
     * Validar presença do label 'Sobre a parceria'
     */
    public OfertaMimosTela validarLabelParceria() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelSobreParceria),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar o label 'Sobre a parceria'"
        );
        salvarEvidencia("Validada a presença do label 'Sobre a parceria'");
        return this;
    }

    /**
     * Valida se o texto informado via parametro está presente na tela
     *
     * @param element
     * @param texto
     * @throws Exception
     */
    private void validarTextoOferta(MobileElement element, String texto) throws Exception {
        validarCondicaoBooleana(retornarTexto(element, "Não foi possivel Encontrar o elemento na tela").contains(texto),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possivel verificar a mensagem");
    }
}
