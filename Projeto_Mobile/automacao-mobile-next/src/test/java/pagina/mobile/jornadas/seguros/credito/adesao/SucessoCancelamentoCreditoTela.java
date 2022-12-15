package pagina.mobile.jornadas.seguros.credito.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.seguros.SucessoCancelamentoCredito;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SucessoCancelamentoCreditoTela extends PaginaBase {

    public SucessoCancelamentoCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    //Elementos
    // Texto SUCESSO CANCELAMENTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_await_activation")
    @iOSXCUITFindBy(accessibility = "titleLabel")
    private MobileElement textoSucessoCancelamento;

    // bot�o OK da tela de SUCCESSO DE CANCELAMENTO
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_await_activation")
    @iOSXCUITFindBy(accessibility = "titleLabel")
    private MobileElement botaoOk;

    /**
     * M�todo para validar a tela de SUCCESSO DE CANCELAMENTO
     * @return
     * @throws Exception
     */
    @Step("Valida tela SUCCESSO DE CANCELAMENTO")
    public SucessoCancelamentoCreditoTela validaTelaSucessoCancelamento() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(SucessoCancelamentoCredito.TEXTO_SUCESSO_CANCELAMENTO)), MetodoComparacaoBooleano.VERDADEIRO,"Texto de Sucesso de Cancelamento n�o presente na tela");
        salvarEvidencia("Tela SUCCESSO DE CANCELAMENTO");
        return this;
    }

    /**
     * M�todo para tocar no bot�o OK da tela de SUCCESSO DE CANCELAMENTO
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o OK da tela de SUCCESSO DE CANCELAMENTO")
    public SucessoCancelamentoCreditoTela tocarBotaoOk() throws Exception {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocar no bot�o OK da tela de SUCCESSO DE CANCELAMENTO");
        tocarElemento(botaoOk, "N�o foi poss�vel tocar no tocar OK da tela de SUCCESSO DE CANCELAMENTO");
        return this;
    }
}
