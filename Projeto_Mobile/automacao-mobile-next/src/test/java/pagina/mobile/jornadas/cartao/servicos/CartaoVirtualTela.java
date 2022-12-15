package pagina.mobile.jornadas.cartao.servicos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CartaoVirtualTela extends PaginaBase {

    //botao Ver como funciona
    @AndroidFindBy(accessibility = "VER COMO FUNCIONA")
    @iOSXCUITFindBy(accessibility = "ver como funciona")
    private MobileElement botaoVerComoFunciona;

    //botao OK, Entendi
    @AndroidFindBy(accessibility = "OK, ENTENDI")
    @iOSXCUITFindBy(accessibility = "OK, ENTENDI")
    private MobileElement botaoOkEntendi;

    public CartaoVirtualTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * M�todo para tocar no bot�o Ver como funciona
     *
     * @return CartaoVirtualTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Ver como funciona\"")
    public CartaoVirtualTela tocarBotaoVerComoFunciona() throws Exception {
        aguardarCarregamentoElemento(botaoVerComoFunciona);
        salvarEvidencia("Tocar no bot�o \"Ver como funciona\"");
        tocarElemento(botaoVerComoFunciona, "N�o foi poss�vel tocar no bot�o \"Ver como funciona\"");
        return this;
    }

    /**
     * M�todo para tocar no bot�o OK, Entendi
     *
     * @return CartaoVirtualTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK, Entendi\"")
    public CartaoVirtualTela tocarBotaoOkEntendi() throws Exception {
        aguardarCarregamentoElemento(botaoOkEntendi);
        salvarEvidencia("Tocar no bot�o \"OK, Entendi\"");
        tocarElemento(botaoOkEntendi, "N�o foi poss�vel tocar no bot�o \"OK, Entendi\"");
        return this;
    }
}

