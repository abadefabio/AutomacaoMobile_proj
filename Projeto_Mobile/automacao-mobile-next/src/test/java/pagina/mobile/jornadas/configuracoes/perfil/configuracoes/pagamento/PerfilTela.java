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
    @iOSXCUITFindBy(accessibility = "CONFIGURAÇÕES DE PAGAMENTO")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"CONFIGURAÇÕES DE PAGAMENTO\"")
    private MobileElement botaoConfiguracoesPagamento;

    //botão Meus Dados
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_profile_my_data")
    @iOSXCUITFindBy(accessibility = "MEUS DADOS")
    private MobileElement botaoMeusDados;

    //ícone câmera
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
    @AndroidFindBy(accessibility = "Voltar, Botão")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    private MobileElement botaoVoltarAoMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_terms")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='TERMOS E CONDIÇÕES']")
    @iOSXCUITFindBy(accessibility = "TERMOS E CONDIÇÕES")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TERMOS E CONDIÇÕES\"`]")
    private MobileElement botaoTermosCondicoes;

    //botao configuracoes APP
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_app_settings")
    @AndroidFindBy(xpath = "//*[contains(@text, 'CONFIGURAÇÕES DO APP')]")
    @iOSXCUITFindBy(accessibility = "CONFIGURAÇÕES DO APP")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"CONFIGURAÇÕES DO APP\"")
    private MobileElement botaoConfiguracoesApp;

    //texto do popup Cartão ainda não emitido
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_description")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Cartão ainda não emitido.')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Cartão ainda não emitido.')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Cartão ainda não emitido.\"")
    private MobileElement popupCartaoNaoEmitido;

    //botao ok
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text, 'OK')]")
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"OK\"")
    private MobileElement botaoOK;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_profile_account_config")
    @iOSXCUITFindBy(accessibility = "CONFIGURAÇÕES DA CONTA")
    private MobileElement botaoConfiguracoesDaConta;

    public PerfilTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão Configurações Pagamento
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Configurações Pagamento\"")
    public PerfilTela tocarConfiguracoesPagamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesPagamento, "Não foi possível encontrar o botão 'Configurações Pagamento'");
        salvarEvidencia("Tocar no botão 'Configuracoes Pagamento'");
        tocarElemento(botaoConfiguracoesPagamento, "Não foi possível Tocar no botão Configurações Pagamento");
        return this;
    }

    /**
     * Tocar botão "Meus Dados"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Meus Dados\"")
    public PerfilTela tocarMeusDados() throws Exception{
        salvarEvidencia("Tocar botão 'Meus Dados'");
        tocarElemento(botaoMeusDados,"Não foi possível tocar no botão 'Meus Dados'");
        return this;
    }

    /**
     * Validar presença da tela 'Perfil'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Perfil\"")
    public PerfilTela validarTelaPerfil() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.PERFIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Perfil' não está presente na tela!");
        salvarEvidencia("Validar presença da na tela 'Perfil'");
        return this;
    }

    /**
     * Tocar ícone de câmera
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar ícone de câmera")
    public PerfilTela tocarIconeCamera() throws Exception{
        salvarEvidencia("Tocar ícone de câmera");
        tocarElemento(iconeCamera, "Não foi possível tocar no ícone de câmera");
        return this;
    }

    /**
     * Tocar botão "Tirar Foto"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Tirar Foto\"")
    public PerfilTela tocarBotaoTirarFoto() throws Exception{
        salvarEvidencia("Tocar botão \"Tirar Foto\"");
        tocarElemento(botaoTirarFoto, "Não foi possível tocar no botão 'Tirar Foto'");
        return this;
    }

    /**
     * Tocar botão "Escolher na Galeria"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Escolher na Galeria\"")
    public PerfilTela tocarBotaoEscolherNaGaleria() throws Exception{
        salvarEvidencia("Tocar botão \"Escolher na Galeria\"");
        tocarElemento(botaoEscolherNaGaleria, "Não foi possível tocar no botão 'Escolher na Galeria'");
        return this;
    }

    /**
     * Clicar botão 'Permitir' - acesso para compartilhar arquivos
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Permitir\"")
    public PerfilTela tocarBotaoPermitir() throws Exception {
        if (getDriver() instanceof AndroidFindBy && verificarPresencaElemento(botaoPermitir)) {
            tocarElemento(botaoPermitir, "Não foi possível clicar no botão Permitir");
        }
        return this;
    }

    /**
     * Tocar botão 'Voltar ao Menu'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar ao Menu'")
    public PerfilTela tocarBotaoVoltarAoMenu() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar ao Menu'");
        tocarElemento(botaoVoltarAoMenu, "Não foi possivel tocar no botão 'Voltar ao Menu'");
        return this;
    }

    /**
     * Tocar botão "Termos e condições"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Termos e condições\"")
    public PerfilTela tocarTermosCondicoes() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTermosCondicoes, "Não foi possível tocar no botão 'Termos e condições'");
        salvarEvidencia("Tocar botão 'Termos e condições'");
        tocarElemento(botaoTermosCondicoes, "Não foi possível tocar no botão Termos e condições");
        return this;

    }

    /**
     * Tocar botão Configurações APP
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Configurações APP\"")
    public PerfilTela tocarConfiguracoesAPP() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfiguracoesApp, "Não foi possível encontrar o botão 'Configurações do APP'");
        salvarEvidencia("Tocar no botão 'Configuracoes do APP'");
        tocarElemento(botaoConfiguracoesApp, "Não foi possível Tocar no botão Configurações do APP");
        return this;
    }

    /**
     * Validar presença da tela 'Perfil'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Perfil\"")
    public PerfilTela verificarPresencaPopupCartaoNaoEmidito() throws Exception {
        if(verificarPresencaElemento(popupCartaoNaoEmitido)){
            salvarEvidencia("Clicar botão OK");
            tocarElemento(botaoOK, "Não foi possível Tocar no botão OK");
        }
        return this;
    }

    /**
     * Tocar no Botão 'Configuracoes Da Conta'
     *
     * @return PerfilTela
     * @throws Exception
     */
    @Step("Tocar botão 'Configuracoes Da Conta'")
    public PerfilTela tocarBotaoConfiguracoesDaConta() throws Exception {
        salvarEvidencia("Tocar no botão 'Configuracoes Da Conta'");
        tocarElemento(botaoConfiguracoesDaConta, "Não foi possível tocar no botão 'Configuracoes Da Conta'!");
        return this;
    }
}
