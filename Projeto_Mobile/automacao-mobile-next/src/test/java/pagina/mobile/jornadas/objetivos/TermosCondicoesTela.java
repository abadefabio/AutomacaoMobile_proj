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
    @AndroidFindBy(accessibility = "TERMOS E CONDIÇÕES")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"TERMOS E CONDIÇÕES\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TERMOS E CONDIÇÕES\"]")
    private MobileElement tituloTermosECondicoes;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_header")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"Termo de ciência e risco\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Termo de ciência e risco\"]")
    private MobileElement botaoTermoDeCienciaERisco;

    public TermosCondicoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar no botão 'FECHAR'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'FECHAR'")
    public TermosCondicoesTela tocarBotaoFechar() throws Exception {
        salvarEvidencia("Tocar botão 'FECHAR'");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'FECHAR'");
        return this;
    }

    /**
     * Validar presença do título 'TERMOS E CONDIÇÕES'
     * @return
     * @throws NextException
     */
    @Step("Validar presença do título 'TERMOS E CONDIÇÕES'")
    public TermosCondicoesTela validarPresencaTituloTermosECondicoes() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTermosECondicoes), MetodoComparacaoBooleano.VERDADEIRO, "O título 'TERMOS E CONDIÇÕES', não está na tela");
        salvarEvidencia("Validado título 'TERMOS E CONDIÇÕES' está presente na tela");
        return this;
    }

    /**
     * Validar presença do botão 'TERMO DE CIÊNCIA E RISCO'
     * @return
     * @throws NextException
     */
    @Step("Validar presença do botão 'TERMO DE CIÊNCIA E RISCO'")
    public TermosCondicoesTela validarPresencaBotaoTermoDeCienciaERisco() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(botaoTermoDeCienciaERisco), MetodoComparacaoBooleano.VERDADEIRO, "O botão 'TERMO DE CIÊNCIA E RISCO', não está na tela");
        salvarEvidencia("Validado botão 'TERMO DE CIÊNCIA E RISCO' está presente na tela");
        return this;
    }

    /**
     * Tocar no botão 'TERMO DE CIÊNCIA E RISCO'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'TERMO DE CIÊNCIA E RISCO'")
    public TermosCondicoesTela tocarBotaoTermoDeCienciaERisco() throws NextException {
        tocarElemento(botaoTermoDeCienciaERisco, "Não foi possível tocar no botão 'TERMO DE CIÊNCIA E RISCO'");
        salvarEvidencia("Tocado botão 'TERMO DE CIÊNCIA E RISCO'");
        return this;
    }
}
