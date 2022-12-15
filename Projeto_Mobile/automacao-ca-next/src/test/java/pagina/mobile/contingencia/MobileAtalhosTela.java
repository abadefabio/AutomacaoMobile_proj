package pagina.mobile.contingencia;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.login.LoginApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MobileAtalhosTela extends PaginaBase {

    public MobileAtalhosTela(AppiumDriver driver){
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/contingency']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@contains(@text,'next Web')]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/image_contingency_icon")
    @AndroidFindBy(id = "br.com.bradesco.next:id/contingency")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"next Web\"`]")
    @iOSXCUITFindBy(accessibility = "next Web")
    private MobileElement contingencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='br.com.bradesco.next:id/ni_system']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Fechar\"`]")
    private MobileElement botaoVoltarFechar;


    /**
     * Validar carregamento da tela pela exibi��o do menu da tela
     */
    @Step ("Tocar op��o 'next Web' Conting�ncia")
    public MobileAtalhosTela tocarBotaoNextWebContingencia() throws Exception {
        salvarEvidencia("Tocar op��o 'next Web' Conting�ncia");
        tocarElemento(contingencia, "N�o foi poss�vel tocar a op��o 'next Web' Contingencia");
        return this;
    }

    /**
     * Validar que a op��o 'next Web' Conting�ncia n�o est� dispon�vel
     */
    @Step ("Validar que a op��o 'next Web' Conting�ncia est� ausente")
    public MobileAtalhosTela validarBotaoNextWebContingenciaAusente(String[] itensEsperados, String itemFaltante) throws Exception {
        salvarEvidencia("Validar que a op��o 'next Web' Conting�ncia est� ausente");
        aguardarPaginaOcultar(LoginApp.PALAVRA_TELA_LOGIN_CPF);
        aguardarPaginaConterQualquerTexto(itensEsperados);
        validarCondicaoBooleana( driver.getPageSource().contains(itemFaltante), MetodoComparacaoBooleano.FALSO,
                "Erro de valida��o: A op��o 'next Web' Conting�ncia est� presente");
        return this;
    }

    /**
     * Tocar o bot�o 'Voltar'
     */
    @Step ("Tocar bot�o 'Voltar'")
    public MobileAtalhosTela tocarBotaoVoltar() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(botaoVoltarFechar);
            salvarEvidencia("Tocar bot�o 'Voltar'");
            tocarElemento(botaoVoltarFechar, "N�o foi poss�vel tocar o bot�o 'Voltar'");
        }
        if (android) {
            salvarEvidencia("Tocar bot�o 'Voltar'");
            voltarTelaAnterior();
        }
        return this;
    }



}
