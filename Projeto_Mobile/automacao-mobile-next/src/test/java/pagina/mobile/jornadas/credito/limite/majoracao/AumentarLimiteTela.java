package pagina.mobile.jornadas.credito.limite.majoracao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.credito.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class AumentarLimiteTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(xpath = "//*[@name='Voltar']")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @iOSXCUITFindBy(xpath = "//*[@name='Voltar']")
    private MobileElement botaoVoltar;

    private MobileElement campoValor;

    private MobileElement botaoConfirmar;

    public AumentarLimiteTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a tela 'Aumentar Limite'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Aumentar Limite'")
    public AumentarLimiteTela validarPresencaTelaAumentarLimite() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.AUMENTAR_LIMITE), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Aumentar Limite' n�o est� presente na tela!");
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
    public AumentarLimiteTela tocarBotaoVoltar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Apagar campo valor
     *
     * @return
     * @throws Exception
     */
    @Step("Apagar campo valor")
    public AumentarLimiteTela apagarValorLimite() throws Exception {
        apagarCampoTexto(campoValor, "N�o foi poss�vel apagar o campo 'Valor'");
        salvarEvidencia("Campo valor apagado");
        return this;
    }

    /**
     * Preencher campo valor
     *
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Preencher campo valor")
    public AumentarLimiteTela preencherValorLimite(String valor) throws Exception {
        escreverTexto(campoValor, valor, "N�o foi poss�vel preencher o campo 'Valor'");
        salvarEvidencia("Preenchido campo 'Valor' com R$ " + valor);
        return this;
    }

    /**
     * Tocar bot�o 'Ver detalhes (Limite)'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'Confirmar'")
    public AumentarLimiteTela tocarBotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar bot�o 'Confirmar'");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel tocar no bot�o 'Confirmar'");
        return this;
    }

}
