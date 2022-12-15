package pagina.mobile.jornadas.investimentos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.investimentos.Mensagem;
import constantes.investimentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class PrimeiroAcessoInvestimentosTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ok")
    @iOSXCUITFindBy(accessibility = "Ok, entendi")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Ok, entendi\"`]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Ok, entendi\"]")
    private MobileElement botaoOkEntendi;

    public PrimeiroAcessoInvestimentosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public PrimeiroAcessoInvestimentosTela tocarBotaoVoltar() throws Exception {
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        salvarEvidencia("Tocado bot�o 'Voltar'");
        return this;
    }

    /**
     * Tocar bot�o 'Ok, entendi'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ok, entendi'")
    public PrimeiroAcessoInvestimentosTela tocarBotaoOkEntendi() throws Exception {
        if(verificarPresencaElemento(botaoOkEntendi)){
            salvarEvidencia("Tocar bot�o 'Ok, entendi'");
            tocarElemento(botaoOkEntendi, "N�o foi poss�vel tocar no bot�o 'Ok, entendi'");
        }
        return this;
    }

    /**
     * Tocar bot�o 'Ok, entendi'
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Ok, entendi'")
    public PrimeiroAcessoInvestimentosTela verifivarPresencaBotaoOkEntendi() throws Exception {

        if (verificarPresencaElemento(botaoOkEntendi)) {
            salvarEvidencia("Tocar bot�o 'Ok, entendi'");
            tocarElemento(botaoOkEntendi, "N�o foi poss�vel tocar no bot�o 'Ok, entendi'");
        }
        return this;
    }

    /**
     * Validar presen�a da tela 'Investimentos (Primeiro Acesso)'
     *
     * @return PrimeiroAcessoInvestimentosTela
     */
    @Step("Validar presen�a da tela 'Investimentos (Primeiro Acesso)'")
    public PrimeiroAcessoInvestimentosTela validarPresencaTelaInvestimentosPrimeiroAcesso() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.INVESTIMENTOS.toString(),Mensagem.PRIMEIRO_ACESSO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Investimentos' e mensagem de 'Primeiro Acesso' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela 'Investimentos (Primeiro Acesso)'");
        return this;
    }
}
