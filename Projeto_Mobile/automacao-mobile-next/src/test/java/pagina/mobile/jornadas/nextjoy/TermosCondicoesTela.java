package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermosCondicoesTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/cb_checkbox")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Li e aceito os termos'])[1]")
    private MobileElement checkBoxLiAceitoTermos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    public TermosCondicoesTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Selecionar checkbox 'Li e concordo'
     *
     * @return TermosCondicoesTela
     * @throws NextException
     */
    @Step("Selecionar checkbox 'Li e concordo'")
    public TermosCondicoesTela selecionarCheckBoxLiAceitoTermos() throws NextException {
        tocarElemento(checkBoxLiAceitoTermos, "N�o foi poss�vel selecionar o checkbox 'Li e concordo'");
        salvarEvidencia("Selecionar checkbox 'Li e concordo'");
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar'
     *
     * @return TermosCondicoesTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Continuar'")
    public TermosCondicoesTela tocarBotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "N�o foi poss�vel encontrar o bot�o 'Continuar'");
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
