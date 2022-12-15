package pagina.mobile.jornadas.investimentos.agora;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AgoraInvestimentosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_enable")
    @AndroidFindBy(xpath = "//*[contains(@text,\"QUERO COMEÇAR A INVESTIR\")]")
    @iOSXCUITFindBy(accessibility = "QUERO COMEÇAR A INVESTIR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"QUERO COMEÇAR A INVESTIR\"`]")
    private MobileElement botaoQueroComecarAgora;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Menu, Botão\"]")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    private MobileElement botaoVoltar;

    public AgoraInvestimentosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no botão 'Quero começar agora'
     *
     * @return AgoraInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Quero começar agora'")
    public AgoraInvestimentosTela tocarBotaoQueroComecarAgora() throws Exception {
        aguardarElementoHabilitado(botaoQueroComecarAgora);
        salvarEvidencia("Tocar no botão 'Quero começar agora'");
        tocarElemento(botaoQueroComecarAgora, "Não foi possível tocar no botão 'Quero começar agora'");
        return this;
    }

    /**
     * Voltar para o APP Next
     *
     * @return AgoraInvestimentoTela
     * @throws InterruptedException
     */
    @Step("Voltar para o APP Next")
    public AgoraInvestimentosTela voltarParaAppNext() throws InterruptedException {
        if (ios) {
            tocarCoordenadaProporcional(2,2);
        } else {
            for (int i=0; i<=1; i++) {
                ((AndroidDriver<?>) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
                // Necessário espera de 1 segundo para que o App seja selecionado no segundo laço da repetição
                Thread.sleep(1000);
            }
        }
        salvarEvidencia("App Next selecionado com sucesso!");
        return this;
    }

    /**
     * Tocar no botão 'Voltar' (<)
     *
     * @return AgoraInvestimentoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Voltar' (<)")
    public AgoraInvestimentosTela tocarBotaoVoltar() throws Exception {
        aguardarElementoHabilitado(botaoVoltar);
        salvarEvidencia("Tocar no botão 'Voltar' (<)");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar' (<)");
        return this;
    }
}
