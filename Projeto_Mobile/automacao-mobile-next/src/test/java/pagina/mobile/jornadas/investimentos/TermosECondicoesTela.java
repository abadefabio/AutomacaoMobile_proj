package pagina.mobile.jornadas.investimentos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermosECondicoesTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Fechar, Botão")
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Aceite de Termos e Condições, desmarcado")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Aceite de Termos e Condi\")]")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[contains(@label,\"Aceite de Termos e Condi\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == \"Aceite de Termos e Condições, desmarcado\"`]")
    @AndroidFindBy(id="br.com.bradesco.next:id/rl_accept_checkbox")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@resource-id,\"br.com.bradesco.next:id/rl_accept_checkbox\")]")
    private MobileElement checkBoxLiEAceitoOsTermosECondicoes;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id = 'br.com.bradesco.next:id/rl_header']/android.widget.TextView[@text = 'Termo de ciência e risco']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Termo de ciência e risco\"]")
    private MobileElement botaoTermoDeCienciaERisco;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Aceitar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Aceitar\"`]")
    @AndroidFindBy(id="br.com.bradesco.next:id/btn_accept")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,\"Aceitar\")]")
    private MobileElement botaoAceitar;

    public TermosECondicoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no botão 'Fechar' (x)
     *
     * @return TermosECondicoesTela
     * @throws Exception
     */
    @Step("Tocar no botao 'Fechar' (x)")
    public TermosECondicoesTela tocarBotaoFechar() throws Exception {
        aguardarElementoHabilitado(botaoFechar);
        salvarEvidencia( "Tocar no botão 'Fechar' (x)");
        tocarElemento(botaoFechar, "Nao foi possível tocar no botão 'Fechar' (x)");
        return this;
    }

    /**
     * Tocar no checkbox 'Li e aceito os termos de condição'
     *
     * @return TermosECondicoesTela
     * @throws Exception
     */
    @Step("Tocar no checkbox 'Li e aceito os termos de condições'")
    public TermosECondicoesTela tocarCheckboxLiAceitoTermosCondicao()throws Exception {
        aguardarCarregamentoElemento(checkBoxLiEAceitoOsTermosECondicoes);
        tocarElemento(checkBoxLiEAceitoOsTermosECondicoes,"Nao foi possível tocar no checkbox 'Li e aceito os termos de condições'");
        salvarEvidencia("Tocado no checkbox 'Li e aceito os termos de condições'");
        return this;
    }

    /**
     * Tocar no botão 'Aceitar'
     *
     * @return TermosECondicoesTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Aceitar'")
    public TermosECondicoesTela tocarBotaoAceitar()throws Exception{
        salvarEvidencia("Tocar no botão 'Aceitar'");
        tocarElemento(botaoAceitar,"Nao foi possível tocar no botão 'Aceitar'");
        return this;
    }

    /**
     * Tocar no botão (v) para expansão e leitura do Termo de ciência e risco
     *
     * @return TermosECondicoesTela
     * @throws Exception
     */
    @Step("Tocar no botão (v) para expansão e leitura do Termo de ciência e risco")
    public TermosECondicoesTela tocarBotaoTermoDeCienciaERisco() throws Exception {
        tocarElemento(botaoTermoDeCienciaERisco, "Nao foi possivel tocar no botão (v) para expansão e leitura do Termo de ciência e risco");
        salvarEvidencia( "Tocado no botão (v) para expansão e leitura do Termo de ciência e risco");
        return this;
    }
}
