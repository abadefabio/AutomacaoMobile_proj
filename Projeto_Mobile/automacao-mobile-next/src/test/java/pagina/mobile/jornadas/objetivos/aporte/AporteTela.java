package pagina.mobile.jornadas.objetivos.aporte;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class AporteTela extends PaginaBase {

    //botao voltar '<'
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Voltar\"`]")
    @AndroidFindBy(accessibility = "Voltar, Botão")
    @AndroidFindBy(id="br.com.bradesco.next:id/animated_view")
    private MobileElement botaoVoltar;

    //titulo da tela
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"APLICAÇÃO\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"APLICAÇÃO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"APLICAÇÃO\")]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Voltar\"]/following::XCUIElementTypeStaticText)[1]")
    @AndroidFindBy(accessibility = "APORTE")
    @AndroidFindBy(id="br.com.bradesco.next:id/toolbar_title")
    private MobileElement textoTituloTela;

    //texto:Se você aplicar esse dinheiro extra, vai ficar ainda mais perto do seu sonho :)
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "Se você aplicar esse dinheiro extra, vai ficar ainda mais perto do seu sonho :)")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Se você aplicar esse dinheiro extra, vai ficar ainda mais perto do seu sonho :)\"`]")
    @AndroidFindBy(id="br.com.bradesco.next:id/tv_extra_money")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Se você aplicar esse dinheiro\")]")
    private MobileElement textoExplicativo;

    //botao Ok, entendi
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeButton[`label == \"Ok, entendi\"`]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Ok, entendi\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ok, entendi\"]")
    @AndroidFindBy (id="br.com.bradesco.next:id/btn_ok")
    @AndroidFindBy(xpath="//*[contains(@text,\"Ok, entendi\")]")
    private MobileElement botaoOkEntendi;

    public AporteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar titulo da tela
     * @return AporteTela
     * @throws Exception
     */
    @Step("Validar presenca do titulo da tela")
    public AporteTela validarPresencaTituloDaTela()throws Exception{
        validarCondicaoBooleana(verificarPresencaElemento(textoTituloTela), MetodoComparacaoBooleano.VERDADEIRO,"Erro ao localizar titulo da tela aporte");
        salvarEvidencia("Validar presenca do titulo da tela aporte");
        return this;
    }


    /**
     * Verificica se o botão 'Ok, entendi' está na tela, caso esteja, toca no mesmo
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Ok, entendi'")
    public AporteTela tocarBotaoOkEntendi() throws NextException {
        // botão não apresenta em algumas situações dependendo do estado da massa
        if(verificarPresencaElemento(botaoOkEntendi)){
            salvarEvidencia("Tocou no botão 'Ok, entendi'");
            tocarElemento(botaoOkEntendi,"Erro ao tocar no Botão 'Ok, entendi'");
        }
        return this;
    }
}

