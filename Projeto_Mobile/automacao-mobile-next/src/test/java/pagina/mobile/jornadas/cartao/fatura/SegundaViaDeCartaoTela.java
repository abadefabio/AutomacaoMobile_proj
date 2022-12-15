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
    @AndroidFindBy(xpath ="//android.widget.Button[@content-desc=\"Sim, Quero pedir 2ª via\"]")
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private MobileElement botaoOk;

    public SegundaViaDeCartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela '2ª VIA SOLICITADA'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela '2ª VIA SOLICITADA'")
    public SegundaViaDeCartaoTela validarTelaSegundaViaDeCartao() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CARTAO.toString()),MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível validar titulo da Tela Cartão");
        salvarEvidencia("Validada presença da tela '2ª VIA SOLICITADA'");
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
        tocarElemento(botaoOk, "Não foi possível tocar no botao \"OK\"");
        return this;
    }
}
