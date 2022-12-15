package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EscolherInstituicaoTela extends PaginaBase {

    public EscolherInstituicaoTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_choose_institution")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Escolha uma\")]")
    private MobileElement textoEscolhaUmaInstituicao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_choose_institution")
    @AndroidFindBy(xpath = "//*[contains(@text, 'ESCOLHER INSTITUIÇÃO')]")
    @iOSXCUITFindBy(accessibility = "ESCOLHER INSTITUIÇÃO")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"ESCOLHER INSTITUIÇÃO\")]")
    private MobileElement botaoEscolherInstituicao;

    /**
     * Tocar botão "EscolherInstituicao"
     * fr
     * @return TutorialOpenFinanceTela
     * @throws Exception
     */
    @Step("Tocar botão \"Escolher Instituicao\"")
    public EscolherInstituicaoTela tocarBotaoEscolherInstituicao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEscolherInstituicao,"Não foi possivel rolar tela ate o elemento");
        salvarEvidencia("Tocar botão \"Escolher Instituicao\"");
        tocarElemento(botaoEscolherInstituicao, "Não foi possivel tocar botão \"Escolher Instituicao\"");
        return this;
    }
}
