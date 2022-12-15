package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class LoginNextShopTempTela extends PaginaBase {

    public LoginNextShopTempTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    private MobileElement barraDePesquisa;

    @AndroidFindBy(accessibility = "Celulares e smartphones\\nCelulares e smartphones")
    private MobileElement botaoDeCategoriaCelularSmartphone;

    @AndroidFindBy(accessibility = "Companhia Brasileira de Tecnologia para e-commerce\\n10% de cashbacks")
    private MobileElement botaoDeLojaCompanhiaBrasileiraVTEX;

    @AndroidFindBy(accessibility = "VTEX")
    private MobileElement botaoDeLojaVTEX;

    @AndroidFindBy(accessibility = "VTEX Project")
    private MobileElement botaoDeLojaVTEXProject;

    /**
     * Realiza o toque no primeiro elemento do Carrossel na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"barra de pesquisa\"")
    public LoginNextShopTempTela tocarBarraDePesquisa() throws Exception {
        aguardarCarregamentoElemento(barraDePesquisa);
        tocarElemento(barraDePesquisa, "Houve um erro ao interagir com a barra de pesquisa.");
        salvarEvidencia("Tocar a barra de pesquisa.");
        return this;
    }
    /**
     * Realiza o toque na Categoria de Smartphones na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"Categoria de Smartphone\"")
    public LoginNextShopTempTela tocarBotaoCategoriaCelularESmartphone() throws Exception {
        aguardarCarregamentoElemento(botaoDeCategoriaCelularSmartphone);
        tocarElemento(botaoDeCategoriaCelularSmartphone, "Houve um erro ao interagir com a Categoria de Smartphone.");
        salvarEvidencia("Tocar a Categoria de Smartphone.");
        return this;
    }
    /**
     * Realiza o toque na Loja Companhia Brasileira na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"Loja Companhia Brasileira\"")
    public LoginNextShopTempTela tocarBotaoLojaCompanhiaBrasileiraVTEX() throws Exception {
        aguardarCarregamentoElemento(botaoDeLojaCompanhiaBrasileiraVTEX);
        tocarElemento(botaoDeLojaCompanhiaBrasileiraVTEX, "Houve um erro ao interagir com a Loja Companhia Brasileira.");
        salvarEvidencia("Tocar a Loja Companhia Brasileira.");
        return this;
    }
    /**
     * Realiza o toque na Loja VTEX na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"Loja VTEX\"")
    public LoginNextShopTempTela tocarBotaoLojaVTEX() throws Exception {
        aguardarCarregamentoElemento(botaoDeLojaVTEX);
        tocarElemento(botaoDeLojaVTEX, "Houve um erro ao interagir com a Loja VTEX.");
        salvarEvidencia("Tocar a Loja VTEX.");
        return this;
    }

    /**
     * Realiza o toque na Loja VTEX Project na Home do Marketplace
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com a \"Loja VTEX Project\"")
    public LoginNextShopTempTela tocarBotaoLojaVTEXProject() throws Exception {
        aguardarCarregamentoElemento(botaoDeLojaVTEXProject);
        tocarElemento(botaoDeLojaVTEXProject, "Houve um erro ao interagir com a Loja VTEX Project.");
        salvarEvidencia("Tocar a Loja VTEX Project.");
        return this;
    }
}

