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
     * Validar presença da tela 'Crédito (Uso do Limite)'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença tela 'Crédito (Uso do Limite)'")
    public UsoDoLimiteTela validarPresencaTelaUsoDoLimite() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CREDITO, Mensagem.USO_LIMITE), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Crédito' e/ou mensagem 'Uso do limite:' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela Crédito (Uso do Limite)");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public UsoDoLimiteTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Tocar botão 'Pedir Mais Limite'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Pedir Mais Limite'")
    public UsoDoLimiteTela tocarBotaoPedirMaisLimite() throws Exception {
        salvarEvidencia("Tocar botão 'Pedir Mais Limite'");
        tocarElemento(botaoPedirMaisLimite, "Não foi possível tocar no botão 'Pedir Mais Limite'");
        return this;
    }
}
