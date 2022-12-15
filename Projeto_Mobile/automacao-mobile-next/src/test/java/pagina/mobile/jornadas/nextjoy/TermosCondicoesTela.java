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
        tocarElemento(checkBoxLiAceitoTermos, "Não foi possível selecionar o checkbox 'Li e concordo'");
        salvarEvidencia("Selecionar checkbox 'Li e concordo'");
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     *
     * @return TermosCondicoesTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Continuar'")
    public TermosCondicoesTela tocarBotaoContinuar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoContinuar, "Não foi possível encontrar o botão 'Continuar'");
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }
}
