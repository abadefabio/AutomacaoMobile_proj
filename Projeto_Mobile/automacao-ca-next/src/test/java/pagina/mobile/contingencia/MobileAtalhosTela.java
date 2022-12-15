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
     * Validar carregamento da tela pela exibição do menu da tela
     */
    @Step ("Tocar opção 'next Web' Contingência")
    public MobileAtalhosTela tocarBotaoNextWebContingencia() throws Exception {
        salvarEvidencia("Tocar opção 'next Web' Contingência");
        tocarElemento(contingencia, "Não foi possível tocar a opção 'next Web' Contingencia");
        return this;
    }

    /**
     * Validar que a opção 'next Web' Contingência não está disponível
     */
    @Step ("Validar que a opção 'next Web' Contingência está ausente")
    public MobileAtalhosTela validarBotaoNextWebContingenciaAusente(String[] itensEsperados, String itemFaltante) throws Exception {
        salvarEvidencia("Validar que a opção 'next Web' Contingência está ausente");
        aguardarPaginaOcultar(LoginApp.PALAVRA_TELA_LOGIN_CPF);
        aguardarPaginaConterQualquerTexto(itensEsperados);
        validarCondicaoBooleana( driver.getPageSource().contains(itemFaltante), MetodoComparacaoBooleano.FALSO,
                "Erro de validação: A opção 'next Web' Contingência está presente");
        return this;
    }

    /**
     * Tocar o botão 'Voltar'
     */
    @Step ("Tocar botão 'Voltar'")
    public MobileAtalhosTela tocarBotaoVoltar() throws Exception {
        if (ios) {
            aguardarCarregamentoElemento(botaoVoltarFechar);
            salvarEvidencia("Tocar botão 'Voltar'");
            tocarElemento(botaoVoltarFechar, "Não foi possível tocar o botão 'Voltar'");
        }
        if (android) {
            salvarEvidencia("Tocar botão 'Voltar'");
            voltarTelaAnterior();
        }
        return this;
    }



}
