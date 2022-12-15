package pagina.mobile.jornadas.credito.limite.majoracao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.credito.Mensagem;
import constantes.credito.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class LimiteAprovadoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    private MobileElement campoValor;

    public LimiteAprovadoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Limite Aprovado'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Limite Aprovado'")
    public LimiteAprovadoTela validarPresencaTelaLimiteAprovado() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.AUMENTAR_LIMITE, Mensagem.LIMITE_APROVADO), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Aumentar Limite' e/ou Mensagem 'Seu novo limite foi aprovado' n�o est�o presentes na tela!");
        salvarEvidencia("Validada presen�a da tela Aumentar Limite");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public LimiteAprovadoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Validar novo valor de limite
     *
     * @return
     * @throws Exception
     */
    @Step("Validar novo valor de limite")
    public LimiteAprovadoTela validarNovoValorLimite(String valor) throws Exception {
        valor = Utilitarios.normalizaStringNumero(valor);
        valor = Utilitarios.reformatarValorMonetario(valor);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valor), MetodoComparacaoBooleano.VERDADEIRO, "O valor de limite esperado n�o est� presente na tela!");
        salvarEvidencia("Validado novo valor do limite: R$ " + valor);
        return this;
    }

}
