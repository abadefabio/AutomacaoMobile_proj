package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class LojaNextShopTela extends PaginaBase {

    public LojaNextShopTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "R$ 3,40\\n de cashback\\nPen Drive Data Key 4GB\\nR$ 34,00\\n12x de R$ 2,83 sem juros\\nVTEX")
    @iOSXCUITFindBy(accessibility = "R$ 3,40\\n de cashback\\nPen Drive Data Key 4GB\\nR$ 34,00\\n12x de R$ 2,83 sem juros\\nVTEX")
    private MobileElement cardProdutoLoja;

    /**
     * Realiza o toque no card do produto selecionado na Loja.
     *
     * @return HomeMarketplace
     * @throws Exception
     */
    @Step("Integarir com o \"Card Produto\"")
    public LojaNextShopTela tocarCardProdutoLoja() throws Exception {
        aguardarCarregamentoElemento(cardProdutoLoja);
        tocarElemento(cardProdutoLoja, "Houve um erro ao interagir com o card do produto.");
        salvarEvidencia("Tocar o card do produto.");
        return this;
    }
}
