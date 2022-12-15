package pagina.mobile.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.login.LoginApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static java.time.Duration.ofSeconds;

public class NovoCelularTela extends PaginaBase {

    private static ThreadLocal<Integer> quantidadeJanelasAbertas = null;
    private static ArrayList<String> listaJanelasAbertasNavegador = null;

    public NovoCelularTela(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

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
    @AndroidFindBy(xpath = "android.widget.Button[resource-id='br.com.bradesco.next:id/bt_dont_have_cell_phone']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Vamos lá\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Vamos lá\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Vamos')]")
    private MobileElement botaoVamosLa;

    /**
     * Método para fechar a tela Novo Celular do App
     * @return NovoCelularTela
     * @throws Exception
     */
    @Step("Método para fechar a tela Novo Celular do App")
    public NovoCelularTela fecharTelaNovoCelular() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Celular Logado em outro aparelho - Realização de reset CPF");
        tocarElemento(botaoFechar, "Erro ao tocar botão \"Fechar\"");
        aguardarPaginaOcultar(LoginApp.PALAVRA_TELA_RESETCPF_VAMOSLA);
        return this;
    }

}
