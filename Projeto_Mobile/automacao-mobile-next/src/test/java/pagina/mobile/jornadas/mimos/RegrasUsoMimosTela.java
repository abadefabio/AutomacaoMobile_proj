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
     * Validar exibição de mensagem de regras de uso cadastrada no sistema de gestão
     *
     * @return MimosTela
     */
    @Step("Validar exibição de mensagem de regras de uso cadastrada no sistema de gestão")
    public RegrasUsoMimosTela validarExibicaoTextoCadastradoRegrasDeUso() throws Exception {
        if (aguardarCarregamentoElemento(textoCadastradoRegrasDeUso)) {
            salvarEvidencia("Validar exibição de mensagem de regras de uso cadastrada no sistema de gestão");
        } else {
            throw new NoSuchElementException("Não foi possível verificar a exibição da mensagem de regras de uso cadastrada no sistema de gestão");
        }
        return this;
    }

    /**
     * Tocar botão "REGRAS DE USO"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"REGRAS DE USO\"")
    public RegrasUsoMimosTela tocarBotaoRegrasDeUso() throws Exception {
        if(!aguardarCarregamentoElemento(botaoRegrasDeUso))
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRegrasDeUso, "Não foi possível encontrar o botão 'Regras de Uso'!");
        tocarElemento(botaoRegrasDeUso, "Não foi possível tocar no botão 'Regras de Uso'!");
        salvarEvidencia("Tocar no botão \"REGRAS DE USO\"");
        return this;
    }
}
