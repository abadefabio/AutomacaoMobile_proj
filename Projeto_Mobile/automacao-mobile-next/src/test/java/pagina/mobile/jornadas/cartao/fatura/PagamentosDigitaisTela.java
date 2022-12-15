package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PagamentosDigitaisTela extends PaginaBase {

    //botao cartão virtual
    @AndroidFindBy(accessibility = "Cartão virtual")
    @iOSXCUITFindBy(accessibility = "Cartão Virtual. Segurança em compras on-line")
    private MobileElement botaoCartaoVirtual;

    public PagamentosDigitaisTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Método para tocar no botão cartão virtual
     * @return PagamentosDigitaisTela
     * @throws Exception
     */
    @Step("Tocar botão \"Cartão Virtual\"")
    public PagamentosDigitaisTela tocarBotaoCartaoVirtual() throws Exception {
        salvarEvidencia("Tocar no botão \"Cartão Virtual\"");
        tocarElemento(botaoCartaoVirtual, "Não foi possível tocar no botão \"Cartão Virtual\"");
        return this;
    }
}
