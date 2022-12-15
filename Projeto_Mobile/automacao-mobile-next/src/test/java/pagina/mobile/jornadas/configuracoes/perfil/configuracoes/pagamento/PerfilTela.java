package pagina.mobile.jornadas.configuracoes.perfil.configuracoes.pagamento;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;

import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import pagina.mobile.jornadas.configuracoes.perfil.configuracoes.da.conta.ConfiguracoesDaContaTela;

public class PerfilTela extends PaginaBase {

    //botao configuracoes pagamento
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_payment_settings")
    @iOSXCUITFindBy(accessibility = "CONFIGURA��ES DE PAGAMENTO")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"CONFIGURA��ES DE PAGAMENTO\"")
    private MobileElement botaoConfiguracoesPagamento;

    //bot�o Meus Dados
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_profile_my_data")
    @iOSXCUITFindBy(accessibility = "MEUS DADOS")
    private MobileElement botaoMeusDados;

    //�cone c�mera
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_profile_edit_photo")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"editar foto\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Mudar foto de perfil\"`][1]")
    private MobileElement iconeCamera;

    //botao Tirar Foto
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntvPhotoOptionsTake")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"TIRAR FOTO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Tirar Foto\"`]")
    private MobileElement botaoTirarFoto;

    //botao Escolher na Galeria
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntvPhotoOptionsChoose")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"ESCOLHER NA GALERIA\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Escolher na Galeria\"`]")
    private MobileElement botaoEscolherNaGaleria;

    //botao permitir (usando apenas no Android)
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement botaoPermitir;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Voltar, Bot�o")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    private MobileElement botaoVoltarAoMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_terms")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='TERMOS E CONDI��ES']")
    @iOSXCUITFindBy(accessibility = "TERMOS E CONDI��ES")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TERMOS E CONDI��ES\"`]")
    private MobileElement botaoTermosCondicoes;

    //botao configuracoes APP
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_app_settings")
    @AndroidFindBy(xpath = "//*[contains(@text, 'CONFIGURA��ES DO APP')]")
    @iOSXCUITFindBy(accessibility = "CONFIGURA��ES DO APP")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"CONFIGURA��ES DO APP\"")
    private MobileElement botaoConfiguracoesApp;

    //texto do popup Cart�o ainda n�o emitido
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_description")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Cart�o ainda n�o emitido.')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Cart�o ainda n�o emitido.')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Cart�o ainda n�o emitido.\"")
    private MobileElement popupCartaoNaoEmitido;

    //botao ok
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text, 'OK')]")
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"OK\"")
    private MobileElement botaoOK;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_profile_account_config")
    @iOSXCUITFindBy(accessibility = "CONFIGURA��ES DA CONTA")
    private MobileElement botaoConfiguracoesDaConta;

    public PerfilTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o Configura��es Pagamento
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Configura��es Pagamento\"")
    public PerfilTela tocarConfiguracoesPagamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesPagamento, "N�o foi poss�vel encontrar o bot�o 'Configura��es Pagamento'");
        salvarEvidencia("Tocar no bot�o 'Configuracoes Pagamento'");
        tocarElemento(botaoConfiguracoesPagamento, "N�o foi poss�vel Tocar no bot�o Configura��es Pagamento");
        return this;
    }

    /**
     * Tocar bot�o "Meus Dados"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Meus Dados\"")
    public PerfilTela tocarMeusDados() throws Exception{
        salvarEvidencia("Tocar bot�o 'Meus Dados'");
        tocarElemento(botaoMeusDados,"N�o foi poss�vel tocar no bot�o 'Meus Dados'");
        return this;
    }

    /**
     * Validar presen�a da tela 'Perfil'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Perfil\"")
    public PerfilTela validarTelaPerfil() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.PERFIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Perfil' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a da na tela 'Perfil'");
        return this;
    }

    /**
     * Tocar �cone de c�mera
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar �cone de c�mera")
    public PerfilTela tocarIconeCamera() throws Exception{
        salvarEvidencia("Tocar �cone de c�mera");
        tocarElemento(iconeCamera, "N�o foi poss�vel tocar no �cone de c�mera");
        return this;
    }

    /**
     * Tocar bot�o "Tirar Foto"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Tirar Foto\"")
    public PerfilTela tocarBotaoTirarFoto() throws Exception{
        salvarEvidencia("Tocar bot�o \"Tirar Foto\"");
        tocarElemento(botaoTirarFoto, "N�o foi poss�vel tocar no bot�o 'Tirar Foto'");
        return this;
    }

    /**
     * Tocar bot�o "Escolher na Galeria"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Escolher na Galeria\"")
    public PerfilTela tocarBotaoEscolherNaGaleria() throws Exception{
        salvarEvidencia("Tocar bot�o \"Escolher na Galeria\"");
        tocarElemento(botaoEscolherNaGaleria, "N�o foi poss�vel tocar no bot�o 'Escolher na Galeria'");
        return this;
    }

    /**
     * Clicar bot�o 'Permitir' - acesso para compartilhar arquivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Permitir\"")
    public PerfilTela tocarBotaoPermitir() throws Exception {
        if (getDriver() instanceof AndroidFindBy && verificarPresencaElemento(botaoPermitir)) {
            tocarElemento(botaoPermitir, "N�o foi poss�vel clicar no bot�o Permitir");
        }
        return this;
    }

    /**
     * Tocar bot�o 'Voltar ao Menu'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar ao Menu'")
    public PerfilTela tocarBotaoVoltarAoMenu() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar ao Menu'");
        tocarElemento(botaoVoltarAoMenu, "N�o foi possivel tocar no bot�o 'Voltar ao Menu'");
        return this;
    }

    /**
     * Tocar bot�o "Termos e condi��es"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Termos e condi��es\"")
    public PerfilTela tocarTermosCondicoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTermosCondicoes, "N�o foi poss�vel tocar no bot�o 'Termos e condi��es'");
        salvarEvidencia("Tocar bot�o 'Termos e condi��es'");
        tocarElemento(botaoTermosCondicoes, "N�o foi poss�vel tocar no bot�o Termos e condi��es");
        return this;

    }

    /**
     * Tocar bot�o Configura��es APP
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Configura��es APP\"")
    public PerfilTela tocarConfiguracoesAPP() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesApp, "N�o foi poss�vel encontrar o bot�o 'Configura��es do APP'");
        salvarEvidencia("Tocar no bot�o 'Configuracoes do APP'");
        tocarElemento(botaoConfiguracoesApp, "N�o foi poss�vel Tocar no bot�o Configura��es do APP");
        return this;
    }

    /**
     * Validar presen�a da tela 'Perfil'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Perfil\"")
    public PerfilTela verificarPresencaPopupCartaoNaoEmidito() throws Exception {
        if(verificarPresencaElemento(popupCartaoNaoEmitido)){
            salvarEvidencia("Clicar bot�o OK");
            tocarElemento(botaoOK, "N�o foi poss�vel Tocar no bot�o OK");
        }
        return this;
    }

    /**
     * Tocar no Bot�o 'Configuracoes Da Conta'
     *
     * @return PerfilTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Configuracoes Da Conta'")
    public PerfilTela tocarBotaoConfiguracoesDaConta() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Configuracoes Da Conta'");
        tocarElemento(botaoConfiguracoesDaConta, "N�o foi poss�vel tocar no bot�o 'Configuracoes Da Conta'!");
        return this;
    }
}
