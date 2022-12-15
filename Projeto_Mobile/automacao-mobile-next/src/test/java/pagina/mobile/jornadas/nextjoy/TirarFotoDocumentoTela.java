package pagina.mobile.jornadas.nextjoy;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TirarFotoDocumentoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(xpath = "CONTINUAR")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='TIRAR FOTO DA FRENTE'])[2]")
    private MobileElement botaoTirarFotoFrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    private MobileElement botaoAcessoCameraPermitirOk;

    @AndroidFindBy(accessibility = "Confirmar")
    @iOSXCUITFindBy(xpath = "//*[@name='check']")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='TIRAR FOTO DO VERSO'])[2]")
    private MobileElement botaoTirarFotoVerso;

    public TirarFotoDocumentoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no botão 'Continuar'
     *
     * @return TirarFotoDocumentoTela
     * @throws NextException
     */
    @Step("Tocar botão 'Continuar'")
    public TirarFotoDocumentoTela tocarBotaoContinuar() throws NextException {
        esperarCarregando();
        aguardarElementoHabilitado(botaoContinuar);
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Tocar botão 'Tirar foto da frente'
     *
     * @return TirarFotoDocumentoTela
     * @throws NextException
     */
    @Step("Tocar botão 'Tirar foto da frente'")
    public TirarFotoDocumentoTela tocarBotaoTirarFotoDaFrente() throws NextException {
        aguardarElementoHabilitado(botaoTirarFotoFrente);
        salvarEvidencia("Tocar no botão 'Tirar foto da frente'");
        tocarElemento(botaoTirarFotoFrente, "Não foi possível tocar no botão 'Tirar foto da frente'");
        return this;
    }

    /**
     * Tocar no botão 'Permitir/Ok' da mensagem de Acesso à Câmera se visível em tela
     *
     * @return TirarFotoDocumentoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Permitir/Ok' da mensagem de Acesso à Câmera se visível em tela")
    public TirarFotoDocumentoTela tocarAcessoCameraPermitirOkSeVisivelEmTela() throws Exception {
        if (aguardarCarregamentoElemento(botaoAcessoCameraPermitirOk)) {
            salvarEvidencia("Tocar no botão 'Permitir/OK' da mensagem de Acesso à Câmera");
            tocarElemento(botaoAcessoCameraPermitirOk, "Erro ao tocar no botão 'Permitir/OK' da mensagem de Acesso à Câmera!");
        }
        return this;
    }

    /**
     * Tocar botão 'Confirmar'
     *
     * @return TirarFotoDocumentoTela
     * @throws NextException
     */
    @Step("Tocar botão 'Confirmar'")
    public TirarFotoDocumentoTela tocarBotaoConfirmar() throws NextException {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Tocar no botão 'Confirmar'");
        tocarElemento(botaoConfirmar, "Não foi possível tocar no botão 'Confirmar'");
        return this;
    }

    /**
     * Tocar botão 'Tirar foto do verso'
     *
     * @return TirarFotoDocumentoTela
     * @throws NextException
     */
    @Step("Tocar botão 'Tirar foto do verso'")
    public TirarFotoDocumentoTela tocarBotaoTirarFotoDoVerso() throws NextException {
        aguardarElementoHabilitado(botaoTirarFotoVerso);
        salvarEvidencia("Tocar no botão 'Tirar foto do verso'");
        tocarElemento(botaoTirarFotoVerso, "Não foi possível tocar no botão 'Tirar foto do verso'");
        return this;
    }
}
