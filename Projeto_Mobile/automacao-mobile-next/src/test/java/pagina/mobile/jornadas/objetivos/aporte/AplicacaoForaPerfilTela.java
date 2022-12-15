package pagina.mobile.jornadas.objetivos.aporte;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AplicacaoForaPerfilTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(accessibility = "APLICAÇÃO FORA DO PERFIL")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"APLICAÇÃO FORA DO PERFIL\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
    private MobileElement tituloTela;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_profile")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]/preceding-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement mensagemAplicacaoDifereDoPerfil;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\" OR label == \"Confirmar\"`]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_profile")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Refazer\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Refazer o perfil\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Refazer o perfil\"]")
    private MobileElement botaoRefazerOPerfil;

    public AplicacaoForaPerfilTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença do título 'APLICAÇÃO FORA DO PERFIL'
     * @return
     * @throws NextException
     */
    @Step("Validar presença do título 'APLICAÇÃO FORA DO PERFIL'")
    public AplicacaoForaPerfilTela validarPresencaTituloAplicacaoForaPerfil() throws NextException {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTela), MetodoComparacaoBooleano.VERDADEIRO, "O título 'APLICAÇÃO FORA DO PERFIL', não está na tela");
        salvarEvidencia("Validado título 'APLICAÇÃO FORA DO PERFIL' está presente na tela");
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Continuar'")
    public AplicacaoForaPerfilTela tocarBotaoContinuar() throws NextException {
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }

    /**
     * Tocar no botão 'Refazer o perfil'
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Refazer o perfil'")
    public AplicacaoForaPerfilTela tocarBotaoRefazerOPerfil() throws NextException {
        salvarEvidencia("Tocar no botão 'Refazer o perfil'");
        tocarElemento(botaoRefazerOPerfil, "Não foi possível tocar no botão 'Refazer o perfil'");
        return this;
    }
}
