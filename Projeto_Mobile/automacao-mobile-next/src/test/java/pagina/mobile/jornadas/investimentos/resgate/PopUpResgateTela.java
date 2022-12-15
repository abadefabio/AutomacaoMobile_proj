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
     * Tocar botão 'Editar Valor' do popup
     *
     * @return PopUpResgateTela
     * @throws Exception
     */
    @Step("Tocar botão 'Editar Valor'")
    public PopUpResgateTela tocarBotaoEditarValor() throws Exception {
        salvarEvidencia("Tocar no botão 'Editar Valor'");
        tocarElemento(botaoEditarValor, "Não foi possível tocar no botão 'Editar Valor'");
        return this;
    }

    /**
     * Tocar botão 'Resgatar Tudo' do popup
     *
     * @return PopUpResgateTela
     * @throws Exception
     */
    @Step("Tocar botão 'Resgatar Tudo'")
    public PopUpResgateTela tocarBotaoResgatarTudo() throws Exception {
        salvarEvidencia("Tocar no botão 'Resgatar Tudo'");
        tocarElemento(botaoResgatarTudo, "Não foi possível tocar no botão 'Resgatar Tudo'");
        return this;
    }

    /**
     * Tocar botão 'Resgatar' do popup
     *
     * @return PopUpResgateTela
     * @throws Exception
     */
    @Step("Tocar botão 'Resgatar'")
    public PopUpResgateTela tocarBotaoResgatar() throws Exception {
        salvarEvidencia("Tocar no botão 'Resgatar'");
        tocarElemento(botaoResgatar, "Não foi possível tocar no botão 'Resgatar'");
        return this;
    }

    /**
     * Tocar botão 'Cancelar' do popup
     *
     * @return PopUpResgateTela
     * @throws Exception
     */
    @Step("Tocar botão 'Cancelar'")
    public PopUpResgateTela tocarBotaoCancelar() throws Exception {
        salvarEvidencia("Tocar no botão 'Cancelar'");
        tocarElemento(botaoCancelar, "Não foi possível tocar no botão 'Cancelar'");
        return this;
    }
}
