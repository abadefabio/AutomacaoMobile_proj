package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class HomeNextShopTela extends PaginaBase {

    public HomeNextShopTela(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "buscar no nextshop")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"buscar no nextshop\"]")
    private MobileElement barraDePesquisa;

    @AndroidFindBy(accessibility = "Celulares e smartphones\\nCelulares e smartphones")
    @iOSXCUITFindBy(accessibility = "Celulares e smartphones\\nCelulares e smartphones")
    private MobileElement botaoDeCategoriaCelularSmartphone;

    @AndroidFindBy(accessibility = "Companhia Brasileira de Tecnologia para e-commerce\\n10% de cashbacks")
    @iOSXCUITFindBy(accessibility = "Companhia Brasileira de Tecnologia para e-commerce\\n10% de cashbacks")
    private MobileElement botaoDeLojaCompanhiaBrasileiraVTEX;

    @AndroidFindBy(accessibility = "VTEX")
    @iOSXCUITFindBy(accessibility = "VTEX")
    private MobileElement botaoDeLojaVTEX;

    @AndroidFindBy(accessibility = "VTEX Project")
    @iOSXCUITFindBy(accessibility = "VTEX Project")
    private MobileElement botaoDeLojaVTEXProject;

    /**
     * Realiza o toque no primeiro elemento do Carrossel na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"barra de pesquisa\"")
    public HomeNextShopTela tocarBarraDePesquisa() throws Exception {
        salvarEvidencia("Tocar a barra de pesquisa.");
        tocarElemento(barraDePesquisa, "Houve um erro ao interagir com a barra de pesquisa.");
        return this;
    }
    /**
     * Realiza o toque na Categoria de Smartphones na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"Categoria de Smartphone\"")
    public HomeNextShopTela tocarBotaoCategoriaCelularESmartphone() throws Exception {
        salvarEvidencia("Tocar a Categoria de Smartphone.");
        tocarElemento(botaoDeCategoriaCelularSmartphone, "Houve um erro ao interagir com a Categoria de Smartphone.");
        return this;
    }
    /**
     * Realiza o toque na Loja VTEX na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"Loja VTEX\"")
    public HomeNextShopTela tocarBotaoLojaVTEX() throws Exception {
        salvarEvidencia("Tocar a Loja VTEX");
        tocarElemento(botaoDeLojaVTEX, "Houve um erro ao interagir com a Loja VTEX.");
        return this;
    }

    /**
     * Realiza o toque na Loja VTEX Project na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"Loja VTEX Project\"")
    public HomeNextShopTela tocarBotaoLojaVTEXProject() throws Exception {
        salvarEvidencia("Tocar a Loja VTEX Project");
        tocarElemento(botaoDeLojaVTEXProject, "Houve um erro ao interagir com a Loja VTEX Project.");
        return this;
    }
}

