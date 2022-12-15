package pagina.mobile.jornadas.configuracoes.perfil.termos.condicoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.Normaliza;
import constantes.configuracoes.perfil.TituloTela;
import constantes.pix.TermosCondicoes;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermosCondicoesTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='D�bito Autom�tico']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"D�bito Autom�tico\"")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"D�bito Autom�tico\"`]")
    private MobileElement botaoDebitoAutomatico;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Termo de Adesao\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Termo de Adesao\")]")
    private MobileElement botaoTermoAdesao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='PIX']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'PIX')]")
    private MobileElement botaoPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Next PIX - Termo de Ades�o']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next PIX - Termo de Ades�o']")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Next PIX')]")
    private MobileElement botaoTermoAdesaoNextPix;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='PIX']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='PIX']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='PIX']")
    private MobileElement textoPix;

    public TermosCondicoesTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Tocar bot�o "D�bito Autom�tico"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Debito Automatico\"")
    public TermosCondicoesTela tocarDebitoAutomatico() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDebitoAutomatico, "N�o foi poss�vel tocar no bot�o 'D�bito Automatico'");
        salvarEvidencia("Tocar bot�o 'D�bito Automatico'");
        tocarElemento(botaoDebitoAutomatico, "N�o foi poss�vel tocar no bot�o D�bito Automatico");
        return this;
    }

    /**
     * Tocar bot�o "Termo de Ades�o"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Termo de Adesao\"")
    public TermosCondicoesTela tocarTermoAdesao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTermoAdesao, "N�o foi poss�vel tocar no bot�o 'Termo de Adesao'");
        salvarEvidencia("Tocar bot�o 'Termo de Adesao'");
        tocarElemento(botaoTermoAdesao, "N�o foi poss�vel tocar no bot�o Termo de Adesao");
        return this;
    }

    /**
     * Validar que esta na tela termos e condi��es
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela Termos e condi��es")
    public TermosCondicoesTela validarTelaTermosCondicoes() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Normaliza.String, TituloTela.TERMOS_CONDICOES.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'termos e condi��es' n�o est� presente na tela!");
        salvarEvidencia("Validado tela termos e condi��es'!");
        return this;
    }

    /**
     * Validar que esta na tela termos e condi��es PIX
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela Termos e condi��es PIX")
    public TermosCondicoesTela validarTelaTermosCondicoesPix() throws Exception {
        aguardarCarregamentoElemento(textoPix);
        validarAtributoTexto(textoPix, TermosCondicoes.TEXTO_PIX.toString(), "Erro ao validar texto 'PIX'");
        salvarEvidencia("Validado tela termos e condi��es PIX'!");
        return this;
    }

    /**
     * Tocar bot�o "PIX"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o 'PIX'")
    public TermosCondicoesTela tocarbotaoPix() throws Exception {
        salvarEvidencia("Tocar bot�o 'Pix'");
        tocarElemento(botaoPix, "N�o foi poss�vel tocar no bot�o Pix");
        return this;
    }

    /**
     * Tocar bot�o "Termo de Ades�o - Next PIX"
     *
     * @return
     * @throws Exception
     */
    public TermosCondicoesTela tocarTermoAdesaoNextPix() throws Exception {
        salvarEvidencia("Tocar bot�o 'Termo de Ades�o - Next PIX'");
        tocarElemento(botaoTermoAdesaoNextPix, "N�o foi poss�vel tocar no bot�o Termo de Adesao - Next PIX");
        return this;
    }

}


