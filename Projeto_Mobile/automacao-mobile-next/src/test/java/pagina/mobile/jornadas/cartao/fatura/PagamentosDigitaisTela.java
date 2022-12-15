package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PagamentosDigitaisTela extends PaginaBase {

    //botao cart�o virtual
    @AndroidFindBy(accessibility = "Cart�o virtual")
    @iOSXCUITFindBy(accessibility = "Cart�o Virtual. Seguran�a em compras on-line")
    private MobileElement botaoCartaoVirtual;

    public PagamentosDigitaisTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * M�todo para tocar no bot�o cart�o virtual
     * @return PagamentosDigitaisTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Cart�o Virtual\"")
    public PagamentosDigitaisTela tocarBotaoCartaoVirtual() throws Exception {
        salvarEvidencia("Tocar no bot�o \"Cart�o Virtual\"");
        tocarElemento(botaoCartaoVirtual, "N�o foi poss�vel tocar no bot�o \"Cart�o Virtual\"");
        return this;
    }
}
