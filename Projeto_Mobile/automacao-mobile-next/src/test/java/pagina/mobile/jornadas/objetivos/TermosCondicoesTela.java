package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class TermosCondicoesTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(accessibility = "TERMOS E CONDI��ES")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TERMOS E CONDI��ES\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TERMOS E CONDI��ES\"]")
    private MobileElement tituloTermosECondicoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_header")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Termo de ci�ncia e risco\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Termo de ci�ncia e risco\"]")
    private MobileElement botaoTermoDeCienciaERisco;

    public TermosCondicoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no bot�o 'FECHAR'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'FECHAR'")
    public TermosCondicoesTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("Tocar bot�o 'FECHAR'");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no bot�o 'FECHAR'");
        return this;
    }

    /**
     * Validar presen�a do t�tulo 'TERMOS E CONDI��ES'
     * @return
     * @throws NextException
     */
    @Step("Validar presen�a do t�tulo 'TERMOS E CONDI��ES'")
    public TermosCondicoesTela validarPresencaTituloTermosECondicoes() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTermosECondicoes), MetodoComparacaoBooleano.VERDADEIRO, "O t�tulo 'TERMOS E CONDI��ES', n�o est� na tela");
        salvarEvidencia("Validado t�tulo 'TERMOS E CONDI��ES' est� presente na tela");
        return this;
    }

    /**
     * Validar presen�a do bot�o 'TERMO DE CI�NCIA E RISCO'
     * @return
     * @throws NextException
     */
    @Step("Validar presen�a do bot�o 'TERMO DE CI�NCIA E RISCO'")
    public TermosCondicoesTela validarPresencaBotaoTermoDeCienciaERisco() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoTermoDeCienciaERisco), MetodoComparacaoBooleano.VERDADEIRO, "O bot�o 'TERMO DE CI�NCIA E RISCO', n�o est� na tela");
        salvarEvidencia("Validado bot�o 'TERMO DE CI�NCIA E RISCO' est� presente na tela");
        return this;
    }

    /**
     * Tocar no bot�o 'TERMO DE CI�NCIA E RISCO'
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'TERMO DE CI�NCIA E RISCO'")
    public TermosCondicoesTela tocarBotaoTermoDeCienciaERisco() throws NextException {
        tocarElemento(botaoTermoDeCienciaERisco, "N�o foi poss�vel tocar no bot�o 'TERMO DE CI�NCIA E RISCO'");
        salvarEvidencia("Tocado bot�o 'TERMO DE CI�NCIA E RISCO'");
        return this;
    }
}
