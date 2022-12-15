package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.open.finance.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static constantes.open.finance.Mensagens.MSG_MAIS_PODER_PARA_VC_FAZER_ACONTECER;

public class TutorialOpenFinanceTela extends PaginaBase {

    public TutorialOpenFinanceTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_control")
    @AndroidFindBy(xpath = "//*[contains(@text, 'VOCÊ NO CONTROLE')]")
    @iOSXCUITFindBy(accessibility = "VOCÊ NO CONTROLE")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"VOCÊ NO CONTROLE\")]")
    private MobileElement textoVoceNoControle;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Mais poder par')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,\"Mais poder par\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"Mais poder par\"]")
    private MobileElement textoMaisPoderParaVoceFazerAcontecer;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_arrow")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"Mais poder par\"]")
    private MobileElement botaoSetaParaBaixo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_continue")
    @AndroidFindBy(xpath = "//*[contains(@text, 'CONTINUAR')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"CONTINUAR\")]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"CONTINUAR\"]")
    private MobileElement botaoVoltar;


    /**
     * Validar tela com o "texto Voce No Controle"
     * fr
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"PAGAMENTOS\"")
    public TutorialOpenFinanceTela validarTelaTutorialPrimeiroAcessoOpenFinance() throws Exception {
        aguardarCarregamentoElemento(textoVoceNoControle);
        validarAtributoTexto(textoVoceNoControle, Mensagens.MSG_VOCE_NO_CONTROLE, "Erro ao validar tela com o \"texto Voce No Controle\"");
        salvarEvidencia("Validar tela \"com o texto Voce No Controle\"");
        return this;
    }

    /**
     * Validar tela "Open Finance"
     * fr
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Open Finance\"")
    public TutorialOpenFinanceTela validarTelaOpenFinance() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(MSG_MAIS_PODER_PARA_VC_FAZER_ACONTECER.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Validar o dado MAIS PODER PARA VC FAZER ACONTECER da presentes na tela!");
        salvarEvidencia("Validar tela \"Open Finance\"");
        return this;
    }

    /**
     * Tocar botão "Continuar"
     * fr
     * @return TutorialOpenFinanceTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TutorialOpenFinanceTela tocarBotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão \"Continuar\"");
        tocarElemento(botaoContinuar, "Não foi possivel tocar botão \"Continuar\"");
        return this;
    }
}
