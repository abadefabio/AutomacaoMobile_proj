package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class VisaCausasTela extends PaginaBase {

    // botao comecar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Começar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(accessibility = "COMEÇAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"COMEÇAR\"]\n")
    @iOSXCUITFindBy(accessibility = "Próxima Página")
    private MobileElement botaoComecar;

    // botao fechar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "\t\n" + "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement botaoFechar;

    // botao Nao quero participar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Não quero participar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_dont")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Não quero participar\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NÃO QUERO PARTICIPAR\"]")
    private MobileElement naoQueroParticipar;

    // botao voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    // botao Confirmar apoio
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirm")
    @AndroidFindBy(accessibility = "Confirmar Apoio")
    @iOSXCUITFindBy(accessibility = "CONFIRMAR APOIO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONFIRMAR APOIO\"]")
    private MobileElement botaoConfirmar;

    // botao Apoiar causa
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"APOIAR\" or @text=\"APOIAR\"])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"APOIAR\"])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"APOIAR\"])[1]")
    private MobileElement botaoApoiarCausa;

    // botao Apoiar da primeira instituição disponível
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id = \"br.com.bradesco.next:id/bt_support\"])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable//XCUIElementTypeButton[@name=\"APOIAR\"])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"APOIAR\"])[3]")
    private MobileElement botaoApoiarPrimeiraInstituicao;

    // botao Li e Aceito
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_label_text")
    @AndroidFindBy(xpath = "//androidx.appcompat.widget.LinearLayoutCompat[@content-desc=\"Li e aceito os termos.\"]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Li e aceito os termos')]")
    private MobileElement botaoLieAceito;

    // botao continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Continuar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Continuar\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;

    // botao OK
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OK\"]")
    private MobileElement botaoOk;

    // botao mais detalhes
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "MAIS DETALHES")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_more_details")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"MAIS DETALHES\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"MAIS DETALHES\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"MAIS DETALHES\"]")
    private MobileElement botaoMaisDetalhes;

    // botao deixar de apoiar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "DEIXAR DE APOIAR")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"DEIXAR DE APOIAR\"]")
    @iOSXCUITFindBy(accessibility = "DEIXAR DE APOIAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DEIXAR DE APOIAR\"]")
    private MobileElement botaoDeixarDeApoiar;

    // botao sim tenho certeza
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @AndroidFindBy(accessibility = "SIM, TENHO CERTEZA")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"SIM, TENHO CERTEZA\"]")
    @iOSXCUITFindBy(accessibility = "SIM, TENHO CERTEZA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SIM, TENHO CERTEZA\"]")
    private MobileElement botaoSimTenhoCerteza;

    @AndroidFindBy(xpath = "(//android.widget.HorizontalScrollView[@resource-id='br.com.bradesco.next:id/tab_layout_tutorial']//android.widget.LinearLayout)[3]")
    private MobileElement botaoSegundaPagina;

    @iOSXCUITFindBy(xpath = "//*[starts-with(@value,'Apoie causas')]")
    private MobileElement textoApoieCausas;

    public VisaCausasTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão "Começar"
     *
     * @return VisaCausasTela
     * @throws Exception
     */
    @Step("Tocar botão 'Começar'")
    public VisaCausasTela tocarBotaoComecar() throws Exception {
        salvarEvidencia("tutorial de tela 'Visa Causa'");
        if (ios) {
            aguardarElementoHabilitado(textoApoieCausas);
            deslizar(Direcao.DIREITA, 90, 25);
        } else {
            tocarElemento(botaoSegundaPagina, "Não foi possível tocar no botão para avançar para a segunda página!");
        }
        salvarEvidencia("Tocar no botão 'Começar'");
        tocarElemento(botaoComecar, "Não foi possível tocar no botão 'Começar'");
        return this;
    }

    /**
     * Tocar botao "fechar"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"fechar\"")
    public VisaCausasTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("Tocar no botao \"fechar\"");
        tocarElemento(botaoFechar, "Não foi possível tocar no botao \"fechar\"");
        return this;
    }

    /**
     * Tocar botao "Nao Quero Participar"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Nao Quero Participar\"")
    public VisaCausasTela tocarNaoQueroParticipar() throws Exception {
        salvarEvidencia("Tocar no botao \"Nao Quero Participar\"");
        tocarElemento(naoQueroParticipar, "Não foi possível tocar no botao \"Nao Quero Participar\"");
        return this;
    }

    /**
     * Tocar botao "Apoiar Causa"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Apoiar Causa\"")
    public VisaCausasTela tocarBotaoApoiarCausa() throws Exception {
        salvarEvidencia("Tocar no botao \"Apoiar Causa\"");
        tocarElemento(botaoApoiarCausa, "Não foi possível tocar no botao \"Apoiar Causa\"");
        return this;
    }

    /**
     * Tocar botao "Apoiar" da primeira Instituição disponível
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Apoiar\" da primeira Instituição disponível")
    public VisaCausasTela tocarBotaoApoiarPrimeiraInstituicao() throws Exception {
        salvarEvidencia("Tocar no botao \"Apoiar\" da primeira Instituição disponível");
        tocarElemento(botaoApoiarPrimeiraInstituicao, "Não foi possível tocar no botao \"Apoiar\" da primeira Instituição disponível");
        return this;
    }

    /**
     * Tocar botao "Confirmar Apoio"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Confirmar Apoio\"")
    public VisaCausasTela tocarBotaoConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar, "Não foi possível tocar no botao \"Confirmar Apoio\"");
        salvarEvidencia("Tocar no botao \"Confirmar Apoio\"");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botao \"Confirmar Apoio\"");
        return this;
    }

    /**
     * Tocar botao "voltar"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"voltar\"")
    public VisaCausasTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botao \"voltar\"");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botao \"voltar\"");
        return this;
    }

    /**
     * Tocar botao "li e Aceito"
     *
     * @throws Exception
     */
    @Step("Tocar check 'li e aceito'")
    public VisaCausasTela tocarCheckLieAceito() throws Exception {
        esperarCarregando();
        salvarEvidencia("Tocar no check 'li e aceito'");
        tocarElemento(botaoLieAceito, "Não foi possível tocar no check 'li e aceito'");
        return this;
    }

    /**
     * Tocar botao "continuar"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"continuar\"")
    public VisaCausasTela tocarBotaoContinuar() throws Exception {
        esperarCarregando();
        salvarEvidencia("Tocar no botao \"continuar\"");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botao \"continuar\"");
        return this;
    }

    /**
     * Tocar botao "ok"
     *
     * @throws Exception
     */
    @Step("Tocar botão \"ok\"")
    public VisaCausasTela tocarBotaoOk() throws Exception {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocar no botão \"Ok\"");
        tocarElemento(botaoOk, "Não foi possível tocar no botão \"Ok\"");
        return this;
    }

    /**
     * Tocar botao "mais detalhes"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"mais detalhes\"")
    public VisaCausasTela tocarMaisDetalhes() throws Exception {
        salvarEvidencia("Tocar no botao \"mais detalhes\"");
        tocarElemento(botaoMaisDetalhes, "Não foi possível tocar no botao \"mais detalhes\"");
        return this;
    }

    /**
     * Tocar botao "DEIXAR DE APOIAR"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"DEIXAR DE APOIAR\"")
    public VisaCausasTela tocarBotaoDeixarDeApoiar() throws Exception {
        salvarEvidencia("Tocar no botao \"DEIXAR DE APOIAR\"");
        tocarElemento(botaoDeixarDeApoiar, "Não foi possível tocar no botao \"DEIXAR DE APOIAR\"");
        return this;
    }

    /**
     * Tocar botao "SIM, TENHO CERTEZA"
     *
     * @throws Exception
     */
    @Step("Tocar botao \"SIM, TENHO CERTEZA\"")
    public VisaCausasTela tocarBotaoSimTenhoCerteza() throws Exception {
        salvarEvidencia("Tocar no botao \"SIM, TENHO CERTEZA\"");
        tocarElemento(botaoSimTenhoCerteza, "Não foi possível tocar no botao \"SIM, TENHO CERTEZA\"");
        return this;
    }
}
