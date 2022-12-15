package pagina.mobile.jornadas.pagamentos.comprovante;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.constantes.MetodoComparacaoBooleano.VERDADEIRO;
import static constantes.pagamentos.TituloTela.COMPROVANTE;

public class ComprovantePdfTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_share")
    @iOSXCUITFindBy(accessibility = "Compartilhar")
    private MobileElement botaoCompartilhar;

    public ComprovantePdfTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Comprovante PDF'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Comprovante PDF'")
    public ComprovantePdfTela validarPresencaTelaComprovantePDF() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(COMPROVANTE), VERDADEIRO, "T�tulo '" + COMPROVANTE + "' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela " + COMPROVANTE);
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public ComprovantePdfTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Clicar bot�o 'Compartilhar Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Compartilhar\"")
    public ComprovantePdfTela tocarBotaoCompartilhar() throws Exception {
        tocarElemento(botaoCompartilhar, "N�o foi poss�vel clicar no bot�o Compartilhar");
        aguardarOcultacaoElemento(botaoCompartilhar);
        salvarEvidencia("Tocado bot�o compartilhar");
        return this;
    }

    /**
     * Validar bot�o 'Compartilhar Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar bot�o \"Compartilhar\"")
    public ComprovantePdfTela validarBotaoCompartilhar() {
        salvarEvidencia("Tocado bot�o compartilhar");
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoCompartilhar), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar bot�o compartilhar");
        return this;
    }

}
