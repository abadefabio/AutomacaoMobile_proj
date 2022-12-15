package pagina.mobile.jornadas.investimentos.perfil;

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

public class PerfilVencidoTela  extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"PERFIL VENCIDO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PERFIL VENCIDO\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"PERFIL VENCIDO\"`]")
    private MobileElement tituloPerfilVencido;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/discover_profile")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Refazer perfil\"]")
    private MobileElement botaoRefazerPerfil;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//*[contains(@text,\"escolheu um produto\"]")
    @iOSXCUITFindBy(accessibility = "Voc� escolheu um produto que envolve risco")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Voc� escolheu um produto que envolve risco\"]")
    private MobileElement tituloSemPerfilDefinido;

    public PerfilVencidoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar a exibi��o da tela: 'Perfil Vencido'
     * @return
     */
    @Step("Validar a exibi��o da tela: 'Perfil Vencido'")
    public PerfilVencidoTela validarExibicaoTelaPerfilVencido(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloPerfilVencido),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a exibi��o da tela: 'Perfil Vencido'");
        salvarEvidencia("Validou a exibi��o da tela: 'Perfil Vencido'");
        return this;
    }
    /**
     * Validar a exibi��o da tela: 'Sem Perfil' - Voce escolheu um produto que envolve risco
     * @return
     */
    @Step("Validar a exibi��o da tela: 'Sem Perfil'")
    public PerfilVencidoTela validarExibicaoTelaSemPerfil(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloSemPerfilDefinido),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a exibi��o da tela: 'Sem Perfil'");
        salvarEvidencia("Validou a exibi��o da tela: 'Sem Perfil'");
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar'
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Continuar'")
    public PerfilVencidoTela tocarBotaoContinuar() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar,"Erro ao tocar no bot�o 'Continuar'");
        return this;
    }

    /**
     * Tocar no bot�o 'Refazer Perfil'
     * @return
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Refazer Perfil'")
    public PerfilVencidoTela tocarBotaoRefazerPerfil() throws NextException {
        salvarEvidencia("Tocar no bot�o 'Refazer Perfil'");
        tocarElemento(botaoRefazerPerfil,"Erro ao tocar no bot�o 'Refazer Perfil'");
        return this;
    }

}
