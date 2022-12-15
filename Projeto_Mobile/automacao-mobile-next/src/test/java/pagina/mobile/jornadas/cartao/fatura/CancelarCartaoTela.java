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

public class CancelarCartaoTela extends PaginaBase {

    // cancelar por roubo e perda
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Cancelar por roubo ou perda")
    @AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Cancelar por roubo ou perda\"]")
    @iOSXCUITFindBy(accessibility = "Cancelar por roubo ou perda. Uma 2ª via será gerada")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancelar por roubo ou perda. Uma 2ª via será gerada']")
    private MobileElement botaoCancelarRouboPerda;

    //meu cartao esta danificado
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath ="//*[@content-desc='Cancelar por estar danificado']")
    @iOSXCUITFindBy(xpath = "//*[@name='Cancelar por estar danificado. Uma 2ª via será gerada']")
    private MobileElement tocarCartaoDanificado;

    public CancelarCartaoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar botao "Cancelar por roubo ou perda"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Cancelar por roubo ou perda'")
    public CancelarCartaoTela tocarCancelarRouboPerda() throws Exception {
        salvarEvidencia("Tocar no botao 'Cancelar por roubo ou perda'");
        tocarElemento(botaoCancelarRouboPerda, "Não foi possível tocar no botao 'Cancelar por roubo ou perda'");
        return this;
    }

    /**
     * Tocar botao "Meu Cartao Danificado"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Meu Cartao Danificado\"")
    public CancelarCartaoTela tocarCartaoDanificado() throws Exception {
        tocarElemento(tocarCartaoDanificado, "Não foi possível tocar no botao \"Meu Cartao Danificado\"");
        salvarEvidencia("Tocar no botao \"Meu Cartao Danificado\"");
        return this;
    }

    /**
     * Validar presença da tela '2ª VIA E CANCELAMENTO'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela '2ª VIA E CANCELAMENTO'")
    public CancelarCartaoTela validarTelaSegundaViaECancelamento() throws Exception {

        validarCondicaoBooleana((
                aguardarPaginaConterTodosTextos(
                        TituloTela.SEGUNDA_VIA_E_CANCELAMENTO_DO_CARTAO.toString())),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Título '2ª VIA E CANCELAMENTO' não está presente na tela!");
        salvarEvidencia("Validada presença da tela '2ª VIA E CANCELAMENTO'");
        return this;
    }
}
