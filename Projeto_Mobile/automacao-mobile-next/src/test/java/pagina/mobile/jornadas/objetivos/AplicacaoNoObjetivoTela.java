package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.objetivos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class AplicacaoNoObjetivoTela extends PaginaBase {

    @AndroidFindBy(accessibility = "APLICAÇÃO NO OBJETIVO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"APLICAÇÃO NO OBJETIVO\"]")
    private MobileElement tituloAplicacaoNoObjetivo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/view_goals")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Ver Objetivo\"])[1]")
    private MobileElement botaoVerObjetivo;

    public AplicacaoNoObjetivoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Valida a tela: 'Data da Aplicação'
     * @return
     */
    @Step("Valida a tela: 'Aplicação No Objetivo'")
    public AplicacaoNoObjetivoTela validarTituloAplicacaoNoObjetivo(){
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.APLICACAO_NO_OBJETIVO.toString()),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a Tela: 'Aplicação No Objetivo'");
        salvarEvidencia("Validou a tela: 'Aplicação No Objetivo'");
        return this;
    }

    /**
     * Tocar no botão: 'Ver Objetivo'
     * @return
     * @throws NextException
     */
    @Step("Tocar botao 'Confirmar Edição'")
    public AplicacaoNoObjetivoTela tocarBotaoVerObjetivo() throws NextException {
        tocarElemento(botaoVerObjetivo,"Erro ao Tocar no botão : 'Ver Objetivo'");
        salvarEvidencia("Tocar no botão : 'Ver Objetivo'");
        return this;
    }

}
