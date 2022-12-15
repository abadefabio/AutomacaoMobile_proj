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

import static java.time.Duration.ofSeconds;

public class SegundaViaCancelamentoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Cancelar por roubo ou perda")
    @AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Cancelar por roubo ou perda\"]")
    @iOSXCUITFindBy(accessibility = "Cancelar por roubo ou perda. Uma 2ª via será gerada")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancelar por roubo ou perda. Uma 2ª via será gerada']")
    private MobileElement botaoCancelarPorRouboOuPerda;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility ="Solicitar cartão com aproximação")
    @AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Solicitar cartão com aproximação\"]")
    @iOSXCUITFindBy(xpath ="//*[contains(@name,'Solicitar cartão com aproximação')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$ label contains \"Solicitar cartão com aproximação\"$]")
    private MobileElement botaoSolicitarCartaoComAproximacao;

    public SegundaViaCancelamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela '2ª VIA E CANCELAMENTO'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela '2ª VIA E CANCELAMENTO'")
    public SegundaViaCancelamentoTela validarTelaSegundaViaECancelamento() {
        aguardarPaginaConterTodosTextos(TituloTela.SEGUNDA_VIA_E_CANCELAMENTO_DO_CARTAO.toString());
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SEGUNDA_VIA_E_CANCELAMENTO_DO_CARTAO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título '2ª VIA E CANCELAMENTO' não está presente na tela!");
        salvarEvidencia("Validada presença da tela '2ª VIA E CANCELAMENTO'");
        return this;
    }

    /**
     * Tocar botao "Cancelar por roubo ou perda"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Cancelar por roubo ou perda\"")
    public SegundaViaCancelamentoTela tocarCancelarPorRouboOuPerda() throws Exception {
        salvarEvidencia("Tocar no botao \"Cancelar por roubo ou perda\"");
        tocarElemento(botaoCancelarPorRouboOuPerda, "Não foi possível tocar no botao \"Cancelar por roubo ou perda\"");
        return this;
    }

    /**
     * Tocar botao "Solicitar cartão com aproximação"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Solicitar cartão com aproximação\"")
    public SegundaViaCancelamentoTela tocarSolicitarCartaoComAproximacao() throws Exception {
        salvarEvidencia("Tocar no botao \"Solicitar cartão com aproximação\"");
        tocarElemento(botaoSolicitarCartaoComAproximacao, "Não foi possível tocar no botao \"Solicitar cartão com aproximação\"");
        return this;
    }
}
