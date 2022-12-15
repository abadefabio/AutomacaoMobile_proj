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
     * Validar presença da tela 'Limite Aprovado'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Limite Aprovado'")
    public LimiteAprovadoTela validarPresencaTelaLimiteAprovado() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.AUMENTAR_LIMITE, Mensagem.LIMITE_APROVADO), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Aumentar Limite' e/ou Mensagem 'Seu novo limite foi aprovado' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela Aumentar Limite");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public LimiteAprovadoTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valor), MetodoComparacaoBooleano.VERDADEIRO, "O valor de limite esperado não está presente na tela!");
        salvarEvidencia("Validado novo valor do limite: R$ " + valor);
        return this;
    }

}
