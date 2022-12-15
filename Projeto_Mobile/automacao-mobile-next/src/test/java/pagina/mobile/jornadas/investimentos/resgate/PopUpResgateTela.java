package pagina.mobile.jornadas.investimentos.resgate;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PopUpResgateTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_negative")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'EDITAR VALOR')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Editar Valor'`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$ label CONTAINS 'Editar valor'$]")
    private MobileElement botaoEditarValor;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_positive")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'RESGATAR TUDO')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='RESGATAR TUDO']")
    private MobileElement botaoResgatarTudo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @iOSXCUITFindBy(accessibility = "RESGATAR")
    private MobileElement botaoResgatar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_secondary_button")
    @iOSXCUITFindBy(accessibility = "CANCELAR")
    private MobileElement botaoCancelar;

    public PopUpResgateTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar bot�o 'Editar Valor' do popup
     *
     * @return PopUpResgateTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Editar Valor'")
    public PopUpResgateTela tocarBotaoEditarValor() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Editar Valor'");
        tocarElemento(botaoEditarValor, "N�o foi poss�vel tocar no bot�o 'Editar Valor'");
        return this;
    }

    /**
     * Tocar bot�o 'Resgatar Tudo' do popup
     *
     * @return PopUpResgateTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Resgatar Tudo'")
    public PopUpResgateTela tocarBotaoResgatarTudo() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Resgatar Tudo'");
        tocarElemento(botaoResgatarTudo, "N�o foi poss�vel tocar no bot�o 'Resgatar Tudo'");
        return this;
    }

    /**
     * Tocar bot�o 'Resgatar' do popup
     *
     * @return PopUpResgateTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Resgatar'")
    public PopUpResgateTela tocarBotaoResgatar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Resgatar'");
        tocarElemento(botaoResgatar, "N�o foi poss�vel tocar no bot�o 'Resgatar'");
        return this;
    }

    /**
     * Tocar bot�o 'Cancelar' do popup
     *
     * @return PopUpResgateTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Cancelar'")
    public PopUpResgateTela tocarBotaoCancelar() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Cancelar'");
        tocarElemento(botaoCancelar, "N�o foi poss�vel tocar no bot�o 'Cancelar'");
        return this;
    }
}
