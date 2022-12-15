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
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Débito Automático']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Débito Automático\"")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Débito Automático\"`]")
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
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Next PIX - Termo de Adesão']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next PIX - Termo de Adesão']")
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
     * Tocar botão "Débito Automático"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Debito Automatico\"")
    public TermosCondicoesTela tocarDebitoAutomatico() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDebitoAutomatico, "Não foi possível tocar no botão 'Débito Automatico'");
        salvarEvidencia("Tocar botão 'Débito Automatico'");
        tocarElemento(botaoDebitoAutomatico, "Não foi possível tocar no botão Débito Automatico");
        return this;
    }

    /**
     * Tocar botão "Termo de Adesão"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Termo de Adesao\"")
    public TermosCondicoesTela tocarTermoAdesao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoTermoAdesao, "Não foi possível tocar no botão 'Termo de Adesao'");
        salvarEvidencia("Tocar botão 'Termo de Adesao'");
        tocarElemento(botaoTermoAdesao, "Não foi possível tocar no botão Termo de Adesao");
        return this;
    }

    /**
     * Validar que esta na tela termos e condições
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela Termos e condições")
    public TermosCondicoesTela validarTelaTermosCondicoes() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Normaliza.String, TituloTela.TERMOS_CONDICOES.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'termos e condições' não está presente na tela!");
        salvarEvidencia("Validado tela termos e condições'!");
        return this;
    }

    /**
     * Validar que esta na tela termos e condições PIX
     *
     * @return
     * @throws Exception
     */
    @Step("Validar tela Termos e condições PIX")
    public TermosCondicoesTela validarTelaTermosCondicoesPix() throws Exception {
        aguardarCarregamentoElemento(textoPix);
        validarAtributoTexto(textoPix, TermosCondicoes.TEXTO_PIX.toString(), "Erro ao validar texto 'PIX'");
        salvarEvidencia("Validado tela termos e condições PIX'!");
        return this;
    }

    /**
     * Tocar botão "PIX"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'PIX'")
    public TermosCondicoesTela tocarbotaoPix() throws Exception {
        salvarEvidencia("Tocar botão 'Pix'");
        tocarElemento(botaoPix, "Não foi possível tocar no botão Pix");
        return this;
    }

    /**
     * Tocar botão "Termo de Adesão - Next PIX"
     *
     * @return
     * @throws Exception
     */
    public TermosCondicoesTela tocarTermoAdesaoNextPix() throws Exception {
        salvarEvidencia("Tocar botão 'Termo de Adesão - Next PIX'");
        tocarElemento(botaoTermoAdesaoNextPix, "Não foi possível tocar no botão Termo de Adesao - Next PIX");
        return this;
    }

}


