package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class ProdutoObjetivoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_favorite_product")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Comprar no ShopFácil\"])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Comprar no ShopFácil\"])[1]")
    private MobileElement botaoShopFacil;

    public ProdutoObjetivoTela(AppiumDriver driver) {
        super(driver);
    }

    /** Tocar no botão ShopFacil
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'ShopFacil'")
    public ProdutoObjetivoTela tocarBotaoShoppFacil() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoShopFacil,"Nao foi possivel encontrar o botao 'ShopFacil'");
        tocarElemento(botaoShopFacil,"Nao foi possivel tocar no botao 'ShopFacil'");
        salvarEvidencia("Tocar botao 'ShopFacil'");
        return this;
    }
}
