package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EnvioCartaoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_yes")
    @iOSXCUITFindBy(accessibility = "SIM, USAR ESTE ENDERE�O")
    private MobileElement botaoUsarEsteEndereco;

    public EnvioCartaoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar bo bot�o 'Usar este endere�o'
     *
     * @return EnvioCartaoTela
     * @throws NextException
     */
    @Step("Tocar bo bot�o 'Usar este endere�o'")
    public EnvioCartaoTela tocarBotaoUsarEsteEndereco() throws NextException {
        aguardarCarregamentoElemento(botaoUsarEsteEndereco);
        salvarEvidencia("Tocar no bot�o 'Sim, usar este endere�o'");
        tocarElemento(botaoUsarEsteEndereco, "N�o foi poss�vel tocar no bot�o 'Sim, usar este endere�o'");
        return this;
    }
}
