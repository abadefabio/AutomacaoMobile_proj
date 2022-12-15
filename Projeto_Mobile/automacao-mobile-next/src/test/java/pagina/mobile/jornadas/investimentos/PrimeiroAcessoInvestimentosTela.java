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
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public PrimeiroAcessoInvestimentosTela tocarBotaoVoltar() throws Exception {
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        salvarEvidencia("Tocado botão 'Voltar'");
        return this;
    }

    /**
     * Tocar botão 'Ok, entendi'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Ok, entendi'")
    public PrimeiroAcessoInvestimentosTela tocarBotaoOkEntendi() throws Exception {
        if(verificarPresencaElemento(botaoOkEntendi)){
            salvarEvidencia("Tocar botão 'Ok, entendi'");
            tocarElemento(botaoOkEntendi, "Não foi possível tocar no botão 'Ok, entendi'");
        }
        return this;
    }

    /**
     * Tocar botão 'Ok, entendi'
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Ok, entendi'")
    public PrimeiroAcessoInvestimentosTela verifivarPresencaBotaoOkEntendi() throws Exception {

        if (verificarPresencaElemento(botaoOkEntendi)) {
            salvarEvidencia("Tocar botão 'Ok, entendi'");
            tocarElemento(botaoOkEntendi, "Não foi possível tocar no botão 'Ok, entendi'");
        }
        return this;
    }

    /**
     * Validar presença da tela 'Investimentos (Primeiro Acesso)'
     *
     * @return PrimeiroAcessoInvestimentosTela
     */
    @Step("Validar presença da tela 'Investimentos (Primeiro Acesso)'")
    public PrimeiroAcessoInvestimentosTela validarPresencaTelaInvestimentosPrimeiroAcesso() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.INVESTIMENTOS.toString(),Mensagem.PRIMEIRO_ACESSO), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Investimentos' e mensagem de 'Primeiro Acesso' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela 'Investimentos (Primeiro Acesso)'");
        return this;
    }
}
