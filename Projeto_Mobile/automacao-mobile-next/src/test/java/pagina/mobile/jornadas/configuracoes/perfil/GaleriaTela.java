package pagina.mobile.jornadas.configuracoes.perfil;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static java.time.Duration.ofSeconds;

public class GaleriaTela extends PaginaBase {

    public GaleriaTela(AppiumDriver driver){
        super(driver);
    }

    //primeira imagem da galeria
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id='com.android.documentsui:id/icon_thumb'])[1]")
    @AndroidFindBy(xpath = "(//*[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]")
    @AndroidFindBy(xpath = "(//*[@resource-id='com.google.android.documentsui:id/icon_mime_lg'])[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains \"Foto, \" or label contains \"Live Photo, \"")
    private MobileElement primeiraImagemGaleria;

    //pasta de todas as fotos (apenas iOS)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[`label == \"Todas as Fotos\"`]")
    private MobileElement pastaTodasAsFotos;

    /**
     * Tocar primeira imagem da Galeria
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar primeira imagem da Galeria")
    public GaleriaTela tocarPrimeiraImagemDaGaleria() throws Exception {
        if (getDriver() instanceof IOSDriver && verificarPresencaElemento(pastaTodasAsFotos)) {
            aguardarCarregamentoElemento(pastaTodasAsFotos);
            salvarEvidencia("Tocar pasta 'Todas as Fotos'");
            tocarElemento(pastaTodasAsFotos, "Não foi possível tocar na pasta 'Todas as Fotos'");
            rolarTelaAteInicio();
            salvarEvidencia("Rolar tela para cima");
        }
        aguardarCarregamentoElemento(primeiraImagemGaleria);
        salvarEvidencia("Tocar primeira imagem da Galeria");
        tocarElemento(primeiraImagemGaleria, "Não foi possível tocar primeira imagem da Galeria");
        return this;
    }
}
