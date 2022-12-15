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
    @AndroidFindBy(accessibility = "APLICA��O FORA DO PERFIL")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"APLICA��O FORA DO PERFIL\"`]")
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
     * Validar presen�a do t�tulo 'APLICA��O FORA DO PERFIL'
     * @return
     * @throws NextException
     */
    @Step("Validar presen�a do t�tulo 'APLICA��O FORA DO PERFIL'")
    public AplicacaoForaPerfilTela validarPresencaTituloAplicacaoForaPerfil() throws NextException {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloTela), MetodoComparacaoBooleano.VERDADEIRO, "O t�tulo 'APLICA��O FORA DO PERFIL', n�o est� na tela");
        salvarEvidencia("Validado t�tulo 'APLICA��O FORA DO PERFIL' est� presente na tela");
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar'
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Continuar'")
    public AplicacaoForaPerfilTela tocarBotaoContinuar() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Tocar no bot�o 'Refazer o perfil'
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Refazer o perfil'")
    public AplicacaoForaPerfilTela tocarBotaoRefazerOPerfil() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Refazer o perfil'");
        tocarElemento(botaoRefazerOPerfil, "N�o foi poss�vel tocar no bot�o 'Refazer o perfil'");
        return this;
    }
}
