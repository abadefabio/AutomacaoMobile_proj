package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AvisoTransferenciaRepitidaTela extends PaginaBase {

    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText")
    private MobileElement subtitulo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/../../..//XCUIElementTypeOther/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name, 'Para')]")
    private MobileElement celulaPara;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/../../..//XCUIElementTypeOther/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name, 'Banco')]")
    private MobileElement celulaBanco;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/../../..//XCUIElementTypeOther/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name, 'Valor')]")
    private MobileElement celulaValor;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    private MobileElement botaoContinuar;

    public AvisoTransferenciaRepitidaTela(AppiumDriver driver) {
        super(driver);
    }
}
