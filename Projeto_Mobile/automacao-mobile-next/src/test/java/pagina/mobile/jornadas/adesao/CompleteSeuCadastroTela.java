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

    //botao Vídeo de segurança
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/asv_liveness")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Vídeo de segurança\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$ label contains \"Vídeo de segurança\"$]")
    private MobileElement botaoVideoDeSeguranca;

    //botao Escolha de cesta e cartão
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/nl_description\"])[7]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Escolha de cesta\")]")
    @iOSXCUITFindBy(accessibility = "Escolha de cesta e cartão")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Escolha de cesta e cartão\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Escolha de cesta e cartão, Desabilitado\"]")
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

     //Botão Voltar ao Menu
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
    @Step("Tocar botão  \"Video De Seguranca\"")
    public CompleteSeuCadastroTela tocarBotaoVideoDeSeguranca() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoVideoDeSeguranca,"Não foi possível encontrar o botão Vídeo de Segurança");
        salvarEvidencia("Tocar botão Video de Segurança'");
        tocarElemento(botaoVideoDeSeguranca, "Erro ao Tocar botao Video De Segurança");
        return this;
    }

    /**
     * Tocar botão 'Escolha de Cesta e Cartão'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão  \"Escolha de Cesta e Cartão\"")
    public CompleteSeuCadastroTela tocarBotaoEscolhaCestaCartao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEscolhaCestaECartao, "Não foi possivel encontrar o botão 'Escolha de Cesta e Cartão'");
        salvarEvidencia("Tocar botão 'Escolha de Cesta e Cartão'");
        tocarElemento(botaoEscolhaCestaECartao, "Erro ao tocar 'Escolha de Cesta e Cartão'");
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
        validarCondicaoBooleana(telaPresente, MetodoComparacaoBooleano.VERDADEIRO, "Tela 'Complete Seu Cadastro' não está presente!");
        salvarEvidencia("Valida tela 'Complete Seu Cadastro'");
        return this;
    }

    /**
     * Tocar botão 'Dados Pessoais'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão  \"Dados Pessoais\"")
    public CompleteSeuCadastroTela tocarBotaoDadosPessoais() throws Exception {
        salvarEvidencia("Tocar botão 'Dados Pessoais'");
        tocarElemento(botaoDadosPessoais, "Erro ao tocar 'Dados Pessoais'");
        return this;
    }
}

