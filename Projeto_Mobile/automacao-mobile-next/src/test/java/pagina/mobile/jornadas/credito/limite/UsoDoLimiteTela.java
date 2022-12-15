package pagina.mobile.jornadas.credito.limite;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.credito.Mensagem;
import constantes.credito.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class UsoDoLimiteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    private MobileElement botaoPedirMaisLimite;

    public UsoDoLimiteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Cr�dito (Uso do Limite)'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Cr�dito (Uso do Limite)'")
    public UsoDoLimiteTela validarPresencaTelaUsoDoLimite() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CREDITO, Mensagem.USO_LIMITE), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Cr�dito' e/ou mensagem 'Uso do limite:' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela Cr�dito (Uso do Limite)");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public UsoDoLimiteTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Tocar bot�o 'Pedir Mais Limite'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Pedir Mais Limite'")
    public UsoDoLimiteTela tocarBotaoPedirMaisLimite() throws Exception {
        salvarEvidencia("Tocar bot�o 'Pedir Mais Limite'");
        tocarElemento(botaoPedirMaisLimite, "N�o foi poss�vel tocar no bot�o 'Pedir Mais Limite'");
        return this;
    }
}
