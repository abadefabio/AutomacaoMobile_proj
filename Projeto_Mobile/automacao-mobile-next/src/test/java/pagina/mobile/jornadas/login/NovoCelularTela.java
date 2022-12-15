package pagina.mobile.jornadas.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.login.LoginApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.ArrayList;

public class NovoCelularTela extends PaginaBase {

    private static ThreadLocal<Integer> quantidadeJanelasAbertas = null;
    private static ArrayList<String> listaJanelasAbertasNavegador = null;

    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(xpath = "//*[@label=\"NOVO CELULAR\"]")
    private MobileElement tituloCabecalho;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_perfil")
    @iOSXCUITFindBy(accessibility = "cashin-phone-icon")
    private MobileElement loginNovoCelular;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_dont_have_cell_phone")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.Button")
    @AndroidFindBy(xpath = "android.widget.Button[resource-id='br.com.bradesco.next:id/bt_dont_have_cell_phone']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Vamos l�\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Vamos l�\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Vamos')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'VAMOS L�')]")

    private MobileElement botaoVamosLa;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_photo")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.Button")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Tirar foto\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Tirar foto')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'TIRAR FOTO')]")
    private MobileElement botaoTirarFoto;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private MobileElement botaoAcessoCameraPermitirOk;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_invite")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    private MobileElement textoCodigoDeSeguranca;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_ok")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Entrar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Entrar\"]")
    private MobileElement botaoEntrar;

    public NovoCelularTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * M�todo para fechar a tela Novo Celular do App
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("M�todo para fechar a tela Novo Celular do App")
    public NovoCelularTela fecharTelaNovoCelular() throws Exception {
        salvarEvidencia("Celular Logado em outro aparelho - Realiza��o de reset CPF");
        tocarElemento(botaoFechar, "Erro ao tocar bot�o \"Fechar\"");
        aguardarOcultacaoElemento(tituloCabecalho);
        return this;
    }

    /**
     * M�todo para tocar no bot�o 'Vamos l�'
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("M�todo para tocar no bot�o 'Vamos l�'")
    public NovoCelularTela tocarVamosLa() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Vamos l�'");
        tocarElemento(botaoVamosLa, "Erro ao tocar bot�o 'Vamos l�'");
        return this;
    }

    /**
     * M�todo para tocar no bot�o 'Tirar foto'
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("M�todo para tocar no bot�o 'Tirar foto'")
    public NovoCelularTela tocarTirarFoto() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Tirar foto'");
        tocarElemento(botaoTirarFoto, "Erro ao tocar no bot�o 'Tirar foto'");
        return this;
    }

    /**
     * M�todo para tocar no bot�o 'Permitir/Ok' da mensagem de Acesso � C�mera
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("M�todo para tocar no bot�o 'Permitir/Ok' da mensagem de Acesso � C�mera")
    public NovoCelularTela tocarAcessoCameraPermitirOk() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Permitir/OK' da mensagem de Acesso � C�mera");
        tocarElemento(botaoAcessoCameraPermitirOk, "Erro ao tocar no bot�o 'Permitir/OK' da mensagem de Acesso � C�mera!");
        return this;
    }

    /**
     * Verificar primeiro elemento carregado em uma lista de elementos
     *
     * @return int
     */
    @Step("Decidir pr�xima a��o de login")
    public boolean isAcessoCamera() throws Exception {
        if (aguardarPaginaConterQualquerTexto(LoginApp.NEXT_DESEJA_TER_ACESSO_A_CAMERA).equals(LoginApp.NEXT_DESEJA_TER_ACESSO_A_CAMERA) ||
                aguardarPaginaConterQualquerTexto(LoginApp.PERMITIR_QUE_NEXT_TIRE_FOTOS_E_GRAVE_VIDEOS).equals(LoginApp.PERMITIR_QUE_NEXT_TIRE_FOTOS_E_GRAVE_VIDEOS)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Preencher o campo 'C�digo de seguran�a'
     *
     * @return NovoCelularTela
     * @throws NextException
     */
    @Step("Escrever no campo \"c�digo de seguran�a\"")
    public NovoCelularTela escreverCodigoDeSeguranca(ThreadLocal<String> codigoSeguranca) throws NextException {

        escreverTexto(textoCodigoDeSeguranca, codigoSeguranca.get(), "N�o foi poss�vel preencher o c�digo de seguran�a!");
        salvarEvidencia("Preenchido o campo 'c�digo de seguran�a'");
        return this;
    }

    /**
     * M�todo para tocar no bot�o 'Entrar'
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("M�todo para tocar no bot�o 'Entrar'")
    public NovoCelularTela tocarEntrar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Entrar'");
        tocarElemento(botaoEntrar, "Erro ao tocar no bot�o 'Entrar'");
        return this;
    }

    /**
     * M�todo para tocar no bot�o 'Continuar'
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("M�todo para tocar no bot�o 'Continuar'")
    public NovoCelularTela tocarContinuar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "Erro ao tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Validar a exibi��o da mensagem 'Tudo certo!'
     *
     * @return NovoCelularTela
     */
    @Step("Validar mensagem \"Tudo certo\"")
    public NovoCelularTela validarMensagemTudoCerto() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(LoginApp.TUDO_CERTO), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Tudo certo!' n�o est� presente na tela!");
        salvarEvidencia("Validar texto 'Tudo Certo!'");
        return this;
    }
}
