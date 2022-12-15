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
     * Validar presença da tela 'Comprovante PDF'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Comprovante PDF'")
    public ComprovantePdfTela validarPresencaTelaComprovantePDF() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(COMPROVANTE), VERDADEIRO, "Título '" + COMPROVANTE + "' não está presente na tela!");
        salvarEvidencia("Validada presença da tela " + COMPROVANTE);
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public ComprovantePdfTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Clicar botão 'Compartilhar Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Compartilhar\"")
    public ComprovantePdfTela tocarBotaoCompartilhar() throws Exception {
        tocarElemento(botaoCompartilhar, "Não foi possível clicar no botão Compartilhar");
        aguardarOcultacaoElemento(botaoCompartilhar);
        salvarEvidencia("Tocado botão compartilhar");
        return this;
    }

    /**
     * Validar botão 'Compartilhar Comprovante'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar botão \"Compartilhar\"")
    public ComprovantePdfTela validarBotaoCompartilhar() {
        salvarEvidencia("Tocado botão compartilhar");
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoCompartilhar), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar botão compartilhar");
        return this;
    }

}
