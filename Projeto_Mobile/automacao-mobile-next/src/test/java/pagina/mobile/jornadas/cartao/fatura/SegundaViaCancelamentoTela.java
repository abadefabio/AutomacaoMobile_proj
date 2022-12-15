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
    @iOSXCUITFindBy(accessibility = "Cancelar por roubo ou perda. Uma 2� via ser� gerada")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancelar por roubo ou perda. Uma 2� via ser� gerada']")
    private MobileElement botaoCancelarPorRouboOuPerda;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility ="Solicitar cart�o com aproxima��o")
    @AndroidFindBy(xpath ="//android.widget.TextView[@content-desc=\"Solicitar cart�o com aproxima��o\"]")
    @iOSXCUITFindBy(xpath ="//*[contains(@name,'Solicitar cart�o com aproxima��o')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$ label contains \"Solicitar cart�o com aproxima��o\"$]")
    private MobileElement botaoSolicitarCartaoComAproximacao;

    public SegundaViaCancelamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela '2� VIA E CANCELAMENTO'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela '2� VIA E CANCELAMENTO'")
    public SegundaViaCancelamentoTela validarTelaSegundaViaECancelamento() {
        aguardarPaginaConterTodosTextos(TituloTela.SEGUNDA_VIA_E_CANCELAMENTO_DO_CARTAO.toString());
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SEGUNDA_VIA_E_CANCELAMENTO_DO_CARTAO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo '2� VIA E CANCELAMENTO' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela '2� VIA E CANCELAMENTO'");
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
        tocarElemento(botaoCancelarPorRouboOuPerda, "N�o foi poss�vel tocar no botao \"Cancelar por roubo ou perda\"");
        return this;
    }

    /**
     * Tocar botao "Solicitar cart�o com aproxima��o"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Solicitar cart�o com aproxima��o\"")
    public SegundaViaCancelamentoTela tocarSolicitarCartaoComAproximacao() throws Exception {
        salvarEvidencia("Tocar no botao \"Solicitar cart�o com aproxima��o\"");
        tocarElemento(botaoSolicitarCartaoComAproximacao, "N�o foi poss�vel tocar no botao \"Solicitar cart�o com aproxima��o\"");
        return this;
    }
}
