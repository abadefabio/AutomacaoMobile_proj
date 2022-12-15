package pagina.mobile.comum.so;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ModalCompartilhamentoTela extends PaginaBase {

    public ModalCompartilhamentoTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "android:id/contentPanel")
    @AndroidFindBy(id = "android:id/topPanel")
    @AndroidFindBy(id = "android:id/resolver_list")
    @AndroidFindBy(id = "android:id/text1")
    @AndroidFindBy(id = "android:id/sem_titlePanel_default")
    @AndroidFindBy(id = "android:id/sem_resolver_pagemode_page_list")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bottom_sheet_share_by")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@content-desc,'Para')]")
    @iOSXCUITFindBy(accessibility = "ActivityListView")
    @iOSXCUITFindBy(accessibility = "ActivityContentView")
    @iOSXCUITFindBy(accessibility = "UIActivityContentView")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeScrollView\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeScrollView")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"_boleto, Documento PDF\")]")
    private MobileElement opcoesCompartilhamento;

    //não existe este botão em Android
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Fechar\"])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name, 'Fechar')])[2]")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(accessibility = "Cancelar")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Fechar o compositor\"]")
    private MobileElement botaoCancelarModalCompartilhamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button'")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Permitir') OR contains(@text,'PERMITIR')]")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'Permitir') OR contains(@text,'PERMITIR']")
    private MobileElement permitirCompartilhamento;

    @AndroidFindBy(id = "com.samsung.android.email.provider:id/button2")
    private MobileElement botaoModalDescartarAndroid;

    /**
     * Validar modal de compartilhamento verificando aplicativos
     *
     * @return
     * @throws Exception
     */
    @Step("Validar modal de compartilhamento verificando aplicativos")
    public ModalCompartilhamentoTela validarModalCompartilhamento() throws Exception {
        aguardarCarregamentoElemento(opcoesCompartilhamento);
        validarCondicaoBooleana(verificarPresencaElemento(opcoesCompartilhamento), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possivel validar modal de compartilhamento verificando aplicativos");
        salvarEvidencia("Validar modal de compartilhamento verificando aplicativos");
        return this;
    }

    /**
     * Fechar modal de compartilhamento
     *
     * @return
     * @throws Exception
     */
    @Step("Fechar modal de compartilhamento")
    public ModalCompartilhamentoTela fecharModalCompartilhamento() throws Exception {
        aguardarCarregamentoElemento(botaoCancelarModalCompartilhamento);
        salvarEvidencia("Fechar modal de compartilhamento");
        if (android) {
            voltarTelaAnterior();
        } else {
            try {
                tocarElemento(botaoCancelarModalCompartilhamento, "Não foi possível Fechar o modal de compartilhamento");
            }
            catch (Exception e) {
                OperadorEvidencia.logarPasso(String.format("clicando possicional para fechar modal"));
                tocarCoordenada(12,12);
            }
        }
        if(aguardarCarregamentoElemento(botaoModalDescartarAndroid)) // Descarta compartilhamento por e-mail se apresentar.
            tocarElemento(botaoModalDescartarAndroid,"Erro ao tocar no botão da Modal 'Descartar'");

        return this;
    }

    /**
     * Clicar botão 'Permitir compartilhamento'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão 'Permitir compartilhamento'")
    public ModalCompartilhamentoTela tocarBotaoPermitirCompartilhamento() throws Exception {
        if (android) {
            if (usandoPermissoesAutomaticas()) {
                return this;
            }
            aguardarCarregamentoElemento(permitirCompartilhamento);
            System.out.println(driver.getPageSource());
            salvarEvidencia("Aceitar Permissão para compartilhar");
            tocarElemento(permitirCompartilhamento, "Não foi possível permitir o compartilhamento.");
        }
        return this;
    }
}
