package pagina.mobile.login;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class GeolocalizacaoTela extends PaginaBase {

    public GeolocalizacaoTela(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    private MobileElement okGeolocalizacao;

    @AndroidFindBy(xpath = "//*[@resource-id = \"com.android.packageinstaller:id/permission_allow_button\" or @resource-id = \"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")
    private MobileElement permitirGeolocalizacao;

    @Step("confirmar geolocalizacao")
    public GeolocalizacaoTela confirmarGeolocalizacao() throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            tocarElemento(okGeolocalizacao, "Não foi possível confirmar a geolocalizacao");
            salvarEvidencia("Aceitar Geolocalização");
            aguardarCarregamentoElemento(permitirGeolocalizacao);
            tocarElemento(permitirGeolocalizacao, "Não foi possível permitir a geolocalização.");
        }
        return this;
    }

}
