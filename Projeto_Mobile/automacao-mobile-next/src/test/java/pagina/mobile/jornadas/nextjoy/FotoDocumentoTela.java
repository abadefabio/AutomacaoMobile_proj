package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class FotoDocumentoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "OK, CONTINUAR")
    private MobileElement botaoOkContinuar;

    public FotoDocumentoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar botão 'OK, continuar'
     *
     * @return FotoDocumentoTela
     * @throws NextException
     */
    @Step("Tocar botão 'OK, continuar'")
    public FotoDocumentoTela tocarBotaoOkContinuar() throws NextException {
        aguardarCarregamentoElemento(botaoOkContinuar);
        salvarEvidencia("Tocar no botão 'Ok, continuar'");
        tocarElemento(botaoOkContinuar, "Não foi possível tocar no botão 'Ok, continuar'");
        return this;
    }
}
