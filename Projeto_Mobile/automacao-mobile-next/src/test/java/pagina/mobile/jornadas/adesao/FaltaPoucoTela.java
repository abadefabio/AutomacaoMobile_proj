package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class FaltaPoucoTela extends PaginaBase {

    public FaltaPoucoTela(AppiumDriver driver){
        super(driver);
    }

    //botao Acesse o Next
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @iOSXCUITFindBy(accessibility = "ACESSE O NEXT")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ACESSE O NEXT\"]")
    private MobileElement botaoAcesseNext;


    /**
     * Tocar botao Acesse o Next
     * fr
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Acesse o Next <\"")
    public FaltaPoucoTela tocarBotaoAcessenext() throws Exception {
        salvarEvidencia("'Tocar botao Acesse o Next'");
        tocarElemento(botaoAcesseNext, "Erro ao Tocar botao Acesse o Next");
        return this;
    }

    /**
     * validar titulo da tela
     * fr
     * @return
     * @throws Exception
     */
    @Step("validar tela  \"Acesse o Next\"")
    public FaltaPoucoTela validarTituloAcesseNext() throws Exception {
        esperarCarregando();
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.ACESSE_O_NEXT.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Acesse o Next' não está presente na tela!");
        salvarEvidencia("validar que esta na tela de 'Acesse o Next'");
        rolarTelaAteFinal();
        return this;
    }
}
