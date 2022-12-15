package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.Mensagem;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class BoletoTela extends PaginaBase {

    //botao compartilhar boleto
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_share_code")
    @iOSXCUITFindBy(accessibility = "COMPARTILHAR BOLETO")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"COMPARTILHAR BOLETO\"")
    private MobileElement tocarCompartilharBoleto;

    public BoletoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao "Compartilhar Boleto"
     *FR
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Compartilhar Boleto\"")
    public BoletoTela tocarBotaoCompartilharBoleto() throws Exception {
        salvarEvidencia("Tocar no botao \"Compartilhar Boleto\"");
        tocarElemento(tocarCompartilharBoleto, "Não foi possível tocar no botao \"Compartilhar Boleto\"");
        return this;
    }

    /**
     * validar titulo tela "BOLETO"
     * FR
     *
     * @throws Exception
     */
    @Step("validar titulo tela \"BOLETO\"")
    public BoletoTela validarTituloTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.BOLETO_TELA.toString()), MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar titulo da tela.");
        salvarEvidencia("validar titulo tela \"BOLETO\"");
        return this;
    }

    /**
     * validar Texto Aplicativos Compartilhamento
     *FR
     *
     * @throws Exception
     */
    @Step("validar texto tela \"Aplicativos Compartilhamento\"")
    public BoletoTela validarTextoAplicativosCompartilhamento() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagem.NEXT.toString()), MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar Texto da tela 'Aplicativos Compartilhamento'.");
        salvarEvidencia("validar Texto em tela \"Aplicativos Compartilhamento\"");
        return this;
    }
}
