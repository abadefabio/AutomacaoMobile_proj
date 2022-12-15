package pagina.mobile.jornadas.pix.copia.cola;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SucessoTela extends PaginaBase {

    @AndroidFindBy(xpath = "//*[@text='VER COMPROVANTE']")
    @iOSXCUITFindBy(xpath = "//*[@name='VER COMPROVANTE']")
    private MobileElement botaoVerComprovante;

    private MobileElement textoSucesso;

    public SucessoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Ver Comprovante'
     *
     * @return SucessoTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Ver Comprovante'")
    public SucessoTela tocarBotaoVerComprovante() throws NextException {
        aguardarCarregamentoElemento(botaoVerComprovante);
        salvarEvidencia("Tocar no bot�o 'Ver Comprovante'");
        tocarElemento(botaoVerComprovante, "N�o foi poss�vel tocar no bot�o 'Ver Comprovante'");
        return this;
    }
}
