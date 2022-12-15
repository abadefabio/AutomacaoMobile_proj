package pagina.mobile.jornadas.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class GeolocalizacaoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK, ENTENDI\"`]")
    private MobileElement okGeolocalizacao;

    @AndroidFindBy(xpath = "//*[@resource-id = \"com.android.packageinstaller:id/permission_allow_button\" or @resource-id = \"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
    @iOSXCUITFindBy(accessibility = "Permitir Durante o Uso do App")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Permitir Durante o Uso do App\"]\n")
    private MobileElement permitirGeolocalizacao;

    public GeolocalizacaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * M�todo para confirmar tela de geolocaliza��o
     *
     * @throws Exception
     */
    @Step("Confirmar geolocalizacao")
    public GeolocalizacaoTela confirmarGeolocalizacao() throws Exception {
        if (verificarPresencaElemento(okGeolocalizacao)){
            tocarElemento(okGeolocalizacao, "N�o foi poss�vel confirmar a geolocalizacao");
            salvarEvidencia("Aceitar Geolocaliza��o");
        }
        return this;
    }

    /**
     * M�todo para permitir uso de geolocaliza��o
     *
     * @throws Exception
     */
    @Step("Permitir uso Localizacao")
    public GeolocalizacaoTela tocarPermitirUsoLocalizacao() throws Exception {
        if(verificarPresencaElemento(permitirGeolocalizacao)){
            tocarElemento(permitirGeolocalizacao, "N�o foi poss�vel permitir o uso da localizacao");
            salvarEvidencia("Permitir uso da Localiza��o");
        }
        return this;
    }
}
