package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CompleteSeuCadastroTela extends PaginaBase {

    public CompleteSeuCadastroTela(AppiumDriver driver){
        super(driver);
    }

    //botao Foto do documento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/asv_documents")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Foto do documento\")]")
    @iOSXCUITFindBy(accessibility = "Foto do documento")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$ label contains \"Foto do documento\"$]")
    private MobileElement botaoFotoDocumento;

    //botao V�deo de seguran�a
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/asv_liveness")
    @AndroidFindBy(xpath = "//*[contains(@text,\"V�deo de seguran�a\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$ label contains \"V�deo de seguran�a\"$]")
    private MobileElement botaoVideoDeSeguranca;

    //botao Escolha de cesta e cart�o
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/nl_description\"])[7]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Escolha de cesta\")]")
    @iOSXCUITFindBy(accessibility = "Escolha de cesta e cart�o")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Escolha de cesta e cart�o\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Escolha de cesta e cart�o, Desabilitado\"]")
    private MobileElement botaoEscolhaCestaECartao;

    //botao Complete Seu Cadastro
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/menu_degustation_banner_image")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'banner')]/preceding-sibling::XCUIElementTypeStaticText)[2]")
    private MobileElement botaoCompleteSeuCadastro;

    //Tela Complete Seu Cadastro
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_complete_registration")
    @iOSXCUITFindBy(accessibility = "completeYourRegistration")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"completeYourRegistration\"]")
    private MobileElement telaCompleteSeuCadastro;

     //Bot�o Voltar ao Menu
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar ao menu\"`]")
    private MobileElement botaoVoltarAoMenu;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Dados pessoais\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Dados pessoais\"]")
    private MobileElement botaoDadosPessoais;

    /**
     * Tocar botao 'Foto Documento'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Foto Documento\"")
    public CompleteSeuCadastroTela tocarBotaoFotoDocumento() throws Exception {
        salvarEvidencia("'Tocar botao Foto do Documento'");
        tocarElemento(botaoFotoDocumento, "Erro ao Tocar botao Foto Documento");
        return this;
    }

    /**
     * Tocar botao 'VideoDeSeguranca'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o  \"Video De Seguranca\"")
    public CompleteSeuCadastroTela tocarBotaoVideoDeSeguranca() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVideoDeSeguranca,"N�o foi poss�vel encontrar o bot�o V�deo de Seguran�a");
        salvarEvidencia("Tocar bot�o Video de Seguran�a'");
        tocarElemento(botaoVideoDeSeguranca, "Erro ao Tocar botao Video De Seguran�a");
        return this;
    }

    /**
     * Tocar bot�o 'Escolha de Cesta e Cart�o'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o  \"Escolha de Cesta e Cart�o\"")
    public CompleteSeuCadastroTela tocarBotaoEscolhaCestaCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEscolhaCestaECartao, "N�o foi possivel encontrar o bot�o 'Escolha de Cesta e Cart�o'");
        salvarEvidencia("Tocar bot�o 'Escolha de Cesta e Cart�o'");
        tocarElemento(botaoEscolhaCestaECartao, "Erro ao tocar 'Escolha de Cesta e Cart�o'");
        return this;
    }

    /**
     *Valida tela 'Complete Seu Cadastro'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela 'Complete Seu Cadastro'")
    public CompleteSeuCadastroTela validaTelaCompleSeuCadastro() throws Exception{
        boolean telaPresente = aguardarCarregamentoElemento(telaCompleteSeuCadastro);
        validarCondicaoBooleana(telaPresente, MetodoComparacaoBooleano.VERDADEIRO, "Tela 'Complete Seu Cadastro' n�o est� presente!");
        salvarEvidencia("Valida tela 'Complete Seu Cadastro'");
        return this;
    }

    /**
     * Tocar bot�o 'Dados Pessoais'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o  \"Dados Pessoais\"")
    public CompleteSeuCadastroTela tocarBotaoDadosPessoais() throws Exception {
        salvarEvidencia("Tocar bot�o 'Dados Pessoais'");
        tocarElemento(botaoDadosPessoais, "Erro ao tocar 'Dados Pessoais'");
        return this;
    }
}

