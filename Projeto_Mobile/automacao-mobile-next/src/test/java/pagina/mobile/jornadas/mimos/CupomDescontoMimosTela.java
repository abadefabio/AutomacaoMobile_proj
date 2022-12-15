package pagina.mobile.jornadas.mimos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CupomDescontoMimosTela extends PaginaBase {


    public CupomDescontoMimosTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "REGRAS DE USO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[$label == \"REGRAS DE USO\"$]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"REGRAS DE USO\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_see_rules")
    private MobileElement botaoRegrasDeUso;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[$name == \"CUPOM DE DESCONTO\"$]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    private MobileElement headerCupomDeDesconto;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_copy_voucher")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"Clique aqui para gerar cupom de desconto\"")
    @iOSXCUITFindBy(accessibility = "COPIAR C�DIGO E IR PARA LOJA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"COPIAR C�DIGO E IR PARA LOJA\"]")
    private MobileElement botaoGerarCupomDesconto;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "OK, VOLTAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK, VOLTAR\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, \"OK\")]")
    private MobileElement botaoOK;

    /**
     * Tocar bot�o "OK"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK\"")
    public CupomDescontoMimosTela tocarBotaoOkPopUp() throws Exception {
        aguardarCarregamentoElemento(botaoOK);
        tocarElemento(botaoOK, "N�o foi poss�vel tocar bot�o \"OK, Entendi\"");
        aguardarCarregamentoElemento(headerCupomDeDesconto);
        salvarEvidencia("Tocar bot�o \"OK, Entendi\"");
        return this;
    }

    /**
     * Validar Exibi��o do Header de cupom de desconto
     *
     * @return MimosTela
     */
    @Step("Validar Exibi��o do Header de cupom de desconto")
    public CupomDescontoMimosTela validarExibicaoHeaderCupomDeDesconto() throws Exception {
        if (aguardarCarregamentoElemento(headerCupomDeDesconto)) {
            salvarEvidencia("Validar exibi��o do header Cupom de Desconto");
        } else {
            throw new NoSuchElementException("N�o foi poss�vel verificar o carregamento do header Cupom de Desconto");
        }
        return this;
    }

    protected void tocarCoordenadaElemento(MobileElement elemento) throws Exception {
        Point localizacao = elemento.getLocation();
        tocarCoordenada(localizacao.x, localizacao.y);
    }

    /**
     * Toca Bot�o cupom de desconto
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar C�digo Promocional")
    public CupomDescontoMimosTela tocarBotaoGerarCupomDesconto() throws Exception {
        if (!aguardarCarregamentoElemento(botaoGerarCupomDesconto)) {
            rolaTelaBaixo();
            aguardarCarregamentoElemento(botaoGerarCupomDesconto);
            salvarEvidencia("Tocar no gerar cupom de desconto");
        }
        if (getDriver() instanceof IOSDriver) {
            tocarCoordenadaElemento(botaoGerarCupomDesconto);
            salvarEvidencia("Ir para loja");
        } else {
            tocarElemento(botaoGerarCupomDesconto, "N�o foi poss�vel tocar no bot�o gerar cupom de desconto");
            salvarEvidencia("Ir para loja");
        }

        return this;
    }

}
