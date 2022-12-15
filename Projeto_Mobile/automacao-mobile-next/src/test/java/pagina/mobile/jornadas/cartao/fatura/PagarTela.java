package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;

import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;


public class PagarTela extends PaginaBase {

    //botao ok,continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_flat_button")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "OK, CONTINUAR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK, CONTINUAR\"`]")
    private MobileElement tocarOkContinuar;

    //botao Gerar Boleto
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Gerar Boleto")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_pay_invoice")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Gerar Boleto\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Gerar Boleto\")]")
    private MobileElement tocarGerarBoleto;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    public PagarTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao "Ok, Continuar"
     *FR
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Ok, Continuar\"")
    public PagarTela tocarBotaoOkContinuar() throws Exception {
        salvarEvidencia("Tocar no botao \"Ok, Continuar\"");
        tocarElemento(tocarOkContinuar, "Não foi possível tocar no botao \"Ok, Continuar\"");
        return this;
    }

    /**
     * Tocar botao "Gerar Boleto"
     *FR
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Gerar Boleto\"")
    public PagarTela tocarBotaoGerarBoleto() throws Exception {
        if(android) esconderTeclado();
        salvarEvidencia("Tocar no botao \"Gerar Boleto\"");
        tocarElemento(tocarGerarBoleto, "Não foi possível tocar no botao \"Gerar Boleto\"");
        return this;
    }

    /**
     * validar titulo tela "PAGAR"
     *FR
     *
     * @throws Exception
     */
    @Step("validar titulo tela \"PAGAR\"")
    public PagarTela validarTituloTela() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.PAGAR.toString()),MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar titulo da tela.");
        salvarEvidencia("validar titulo tela \"PAGAR\"");
        return this;
    }

    /**
     * Tocar botão 'Voltar' (<)
     *
     * @return PagarTela
     * @throws NextException
     */
    @Step("Tocar botão 'Voltar' (<)")
    public PagarTela tocarBotaoVoltar() throws NextException {
        salvarEvidencia("Tocar botão 'Voltar' (<)");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar' (<)");
        return this;
    }
}
