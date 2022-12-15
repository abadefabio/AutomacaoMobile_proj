package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SegundaViaDeCartaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_ok")
    @AndroidFindBy(xpath ="//android.widget.Button[@content-desc=\"Sim, Quero pedir 2� via\"]")
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private MobileElement botaoOk;

    public SegundaViaDeCartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela '2� VIA SOLICITADA'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela '2� VIA SOLICITADA'")
    public SegundaViaDeCartaoTela validarTelaSegundaViaDeCartao() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CARTAO.toString()),MetodoComparacaoBooleano.VERDADEIRO,"N�o foi poss�vel validar titulo da Tela Cart�o");
        salvarEvidencia("Validada presen�a da tela '2� VIA SOLICITADA'");
        return this;
    }

    /**
     * Tocar botao "OK"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"OK\"")
    public SegundaViaDeCartaoTela tocarOk() throws Exception {
        aguardarElementoHabilitado(botaoOk);
        salvarEvidencia("Tocar no botao \"OK\"");
        tocarElemento(botaoOk, "N�o foi poss�vel tocar no botao \"OK\"");
        return this;
    }
}
