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

public class SolicitarCartaoComAproximacaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath ="//android.widget.Button[@content-desc=\"Sim, Quero pedir 2ª via\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    public SolicitarCartaoComAproximacaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Solicitar Cartão com Aproximação'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela 'Solicitar Cartão com Aproximação'")
    public SolicitarCartaoComAproximacaoTela validarTelaSolicitarCartaoComAproximacao () {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SOLICITAR_CARTAO_APROXIMACAO.toString()),
                MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a tela 'Solicitar Cartão com Aproximação'");
        salvarEvidencia("Validada presença da tela 'Solicitar Cartão com Aproximação'");
        return this;
    }

    /**
     * Tocar botao "Continuar"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Continuar\"")
    public SolicitarCartaoComAproximacaoTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar no botao \"Continuar\"");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botao \"Continuar\"");
        return this;
    }
}
