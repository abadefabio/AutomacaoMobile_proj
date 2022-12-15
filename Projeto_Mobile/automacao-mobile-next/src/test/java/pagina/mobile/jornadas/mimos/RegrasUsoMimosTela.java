package pagina.mobile.jornadas.mimos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

public class RegrasUsoMimosTela extends PaginaBase {

    public RegrasUsoMimosTela(AppiumDriver driver) {
        super(driver);
    }

    //RegraUsoMimosTela
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[contains(@label, 'Clique aqui para ver o voucher gerado')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeStaticText")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_banner")
    private MobileElement textoCadastradoRegrasDeUso;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"voltar\")]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"menu\")]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "REGRAS DE USO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label == \"REGRAS DE USO\"$]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REGRAS DE USO\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_see_rules")
    private MobileElement botaoRegrasDeUso;

    /**
     * Validar exibi��o de mensagem de regras de uso cadastrada no sistema de gest�o
     *
     * @return MimosTela
     */
    @Step("Validar exibi��o de mensagem de regras de uso cadastrada no sistema de gest�o")
    public RegrasUsoMimosTela validarExibicaoTextoCadastradoRegrasDeUso() throws Exception {
        if (aguardarCarregamentoElemento(textoCadastradoRegrasDeUso)) {
            salvarEvidencia("Validar exibi��o de mensagem de regras de uso cadastrada no sistema de gest�o");
        } else {
            throw new NoSuchElementException("N�o foi poss�vel verificar a exibi��o da mensagem de regras de uso cadastrada no sistema de gest�o");
        }
        return this;
    }

    /**
     * Tocar bot�o "REGRAS DE USO"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"REGRAS DE USO\"")
    public RegrasUsoMimosTela tocarBotaoRegrasDeUso() throws Exception {
        if(!aguardarCarregamentoElemento(botaoRegrasDeUso))
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRegrasDeUso, "N�o foi poss�vel encontrar o bot�o 'Regras de Uso'!");
        tocarElemento(botaoRegrasDeUso, "N�o foi poss�vel tocar no bot�o 'Regras de Uso'!");
        salvarEvidencia("Tocar no bot�o \"REGRAS DE USO\"");
        return this;
    }
}
