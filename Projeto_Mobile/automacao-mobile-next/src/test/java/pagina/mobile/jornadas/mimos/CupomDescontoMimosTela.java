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
    @iOSXCUITFindBy(accessibility = "COPIAR CÓDIGO E IR PARA LOJA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"COPIAR CÓDIGO E IR PARA LOJA\"]")
    private MobileElement botaoGerarCupomDesconto;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "OK, VOLTAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK, VOLTAR\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, \"OK\")]")
    private MobileElement botaoOK;

    /**
     * Tocar botão "OK"
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar botão \"OK\"")
    public CupomDescontoMimosTela tocarBotaoOkPopUp() throws Exception {
        aguardarCarregamentoElemento(botaoOK);
        tocarElemento(botaoOK, "Não foi possível tocar botão \"OK, Entendi\"");
        aguardarCarregamentoElemento(headerCupomDeDesconto);
        salvarEvidencia("Tocar botão \"OK, Entendi\"");
        return this;
    }

    /**
     * Validar Exibição do Header de cupom de desconto
     *
     * @return MimosTela
     */
    @Step("Validar Exibição do Header de cupom de desconto")
    public CupomDescontoMimosTela validarExibicaoHeaderCupomDeDesconto() throws Exception {
        if (aguardarCarregamentoElemento(headerCupomDeDesconto)) {
            salvarEvidencia("Validar exibição do header Cupom de Desconto");
        } else {
            throw new NoSuchElementException("Não foi possível verificar o carregamento do header Cupom de Desconto");
        }
        return this;
    }

    protected void tocarCoordenadaElemento(MobileElement elemento) throws Exception {
        Point localizacao = elemento.getLocation();
        tocarCoordenada(localizacao.x, localizacao.y);
    }

    /**
     * Toca Botão cupom de desconto
     *
     * @return MimosTela
     * @throws Exception
     */
    @Step("Tocar Código Promocional")
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
            tocarElemento(botaoGerarCupomDesconto, "Não foi possível tocar no botão gerar cupom de desconto");
            salvarEvidencia("Ir para loja");
        }

        return this;
    }

}
