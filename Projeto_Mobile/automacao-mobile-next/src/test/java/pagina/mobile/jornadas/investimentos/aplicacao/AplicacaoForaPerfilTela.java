package pagina.mobile.jornadas.investimentos.aplicacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AplicacaoForaPerfilTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/discover_profile")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Refazer')]")
    private MobileElement botaoDescobrirPerfil;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(xpath = "//*[@name='Continuar']")
    private MobileElement botaoContinuar;

    public AplicacaoForaPerfilTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Descobrir Perfil'
     *
     * @return AplicacaoForaPerfilTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Descobrir Perfil'")
    public AplicacaoForaPerfilTela tocarBotaoDescobrirPerfil() throws Exception {
        aguardarCarregamentoElemento(botaoDescobrirPerfil);
        salvarEvidencia( "Tocar no bot�o 'Descobrir Perfil'");
        tocarElemento(botaoDescobrirPerfil, "N�o foi poss�vel tocar no bot�o 'Descobrir Perfil'");
        return this;
    }

    /**
     * Tocar no bot�o 'Continuar'
     *
     * @return AplicacaoForaPerfilTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Continuar'")
    public AplicacaoForaPerfilTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia( "Tocar no bot�o 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no bot�o 'Continuar'");
        return this;
    }
}
