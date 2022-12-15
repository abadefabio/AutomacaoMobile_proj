package pagina.mobile.jornadas.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TirarFotoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_photo")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.Button")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeButton\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton")
    private MobileElement botaoTirarFoto;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    //@iOSXCUITFindBy(accessibility = "Curti")
    //@iOSXCUITFindBy(xpath = "//*[contains(@name,'Curti')]")
    //@iOSXCUITFindBy(accessibility = "Continuar")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Curti') or contains(@name,'Continuar')]")
    private MobileElement botaoCurtiContinuar;

    public TirarFotoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Método para tocar no botão 'Tirar foto'
     * @return TirarFotoTela
     * @throws Exception
     */
    @Step("Método para tocar no botão 'Tirar foto'")
    public TirarFotoTela tocarBotaoTirarFoto() throws Exception {
        salvarEvidencia("Tocar no botão verde para 'Tirar foto'");
        tocarElemento(botaoTirarFoto, "Erro ao tirar a foto!");
        return this;
    }

    /**
     * Método para tocar no botão 'Curti' ou 'Continuar'
     * @return TirarFotoTela
     * @throws Exception
     */
    @Step("Método para tocar no botão 'Curti/Continuar'")
    public TirarFotoTela tocarBotaoCurtiContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoCurtiContinuar);
        salvarEvidencia("Tocar no botão 'Curti/Continuar'");
        tocarElemento(botaoCurtiContinuar, "Erro ao tocar no botão 'Curti/Continuar'");
        return this;
    }
}
