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
    @iOSXCUITFindBy(accessibility = "SIM, USAR ESTE ENDEREÇO")
    private MobileElement botaoUsarEsteEndereco;

    public EnvioCartaoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar bo botão 'Usar este endereço'
     *
     * @return EnvioCartaoTela
     * @throws NextException
     */
    @Step("Tocar bo botão 'Usar este endereço'")
    public EnvioCartaoTela tocarBotaoUsarEsteEndereco() throws NextException {
        aguardarCarregamentoElemento(botaoUsarEsteEndereco);
        salvarEvidencia("Tocar no botão 'Sim, usar este endereço'");
        tocarElemento(botaoUsarEsteEndereco, "Não foi possível tocar no botão 'Sim, usar este endereço'");
        return this;
    }
}
