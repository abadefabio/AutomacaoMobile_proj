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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Vamos lá\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Vamos lá\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Vamos')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'VAMOS LÁ')]")

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
     * Método para fechar a tela Novo Celular do App
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("Método para fechar a tela Novo Celular do App")
    public NovoCelularTela fecharTelaNovoCelular() throws Exception {
        salvarEvidencia("Celular Logado em outro aparelho - Realização de reset CPF");
        tocarElemento(botaoFechar, "Erro ao tocar botão \"Fechar\"");
        aguardarOcultacaoElemento(tituloCabecalho);
        return this;
    }

    /**
     * Método para tocar no botão 'Vamos lá'
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("Método para tocar no botão 'Vamos lá'")
    public NovoCelularTela tocarVamosLa() throws Exception {
        salvarEvidencia("Tocar no botão 'Vamos lá'");
        tocarElemento(botaoVamosLa, "Erro ao tocar botão 'Vamos lá'");
        return this;
    }

    /**
     * Método para tocar no botão 'Tirar foto'
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("Método para tocar no botão 'Tirar foto'")
    public NovoCelularTela tocarTirarFoto() throws Exception {
        salvarEvidencia("Tocar no botão 'Tirar foto'");
        tocarElemento(botaoTirarFoto, "Erro ao tocar no botão 'Tirar foto'");
        return this;
    }

    /**
     * Método para tocar no botão 'Permitir/Ok' da mensagem de Acesso à Câmera
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("Método para tocar no botão 'Permitir/Ok' da mensagem de Acesso à Câmera")
    public NovoCelularTela tocarAcessoCameraPermitirOk() throws Exception {
        salvarEvidencia("Tocar no botão 'Permitir/OK' da mensagem de Acesso à Câmera");
        tocarElemento(botaoAcessoCameraPermitirOk, "Erro ao tocar no botão 'Permitir/OK' da mensagem de Acesso à Câmera!");
        return this;
    }

    /**
     * Verificar primeiro elemento carregado em uma lista de elementos
     *
     * @return int
     */
    @Step("Decidir próxima ação de login")
    public boolean isAcessoCamera() throws Exception {
        if (aguardarPaginaConterQualquerTexto(LoginApp.NEXT_DESEJA_TER_ACESSO_A_CAMERA).equals(LoginApp.NEXT_DESEJA_TER_ACESSO_A_CAMERA) ||
                aguardarPaginaConterQualquerTexto(LoginApp.PERMITIR_QUE_NEXT_TIRE_FOTOS_E_GRAVE_VIDEOS).equals(LoginApp.PERMITIR_QUE_NEXT_TIRE_FOTOS_E_GRAVE_VIDEOS)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Preencher o campo 'Código de segurança'
     *
     * @return NovoCelularTela
     * @throws NextException
     */
    @Step("Escrever no campo \"código de segurança\"")
    public NovoCelularTela escreverCodigoDeSeguranca(ThreadLocal<String> codigoSeguranca) throws NextException {

        escreverTexto(textoCodigoDeSeguranca, codigoSeguranca.get(), "Não foi possível preencher o código de segurança!");
        salvarEvidencia("Preenchido o campo 'código de segurança'");
        return this;
    }

    /**
     * Método para tocar no botão 'Entrar'
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("Método para tocar no botão 'Entrar'")
    public NovoCelularTela tocarEntrar() throws Exception {
        salvarEvidencia("Tocar no botão 'Entrar'");
        tocarElemento(botaoEntrar, "Erro ao tocar no botão 'Entrar'");
        return this;
    }

    /**
     * Método para tocar no botão 'Continuar'
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("Método para tocar no botão 'Continuar'")
    public NovoCelularTela tocarContinuar() throws Exception {
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Erro ao tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Validar a exibição da mensagem 'Tudo certo!'
     *
     * @return NovoCelularTela
     */
    @Step("Validar mensagem \"Tudo certo\"")
    public NovoCelularTela validarMensagemTudoCerto() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(LoginApp.TUDO_CERTO), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Tudo certo!' não está presente na tela!");
        salvarEvidencia("Validar texto 'Tudo Certo!'");
        return this;
    }
}
