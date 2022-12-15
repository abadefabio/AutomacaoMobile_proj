package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class YeahTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_activate_now")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Ativar agora']")
    @iOSXCUITFindBy(accessibility = "ATIVAR AGORA")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ATIVAR AGORA\"`]")
    private MobileElement tocarAtivarAgora;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_activate_later")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Ativar mais tarde']")
    @iOSXCUITFindBy(accessibility = "ATIVAR MAIS TARDE  ")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ATIVAR MAIS TARDE\"`]")
    private MobileElement tocarAtivarMaisTarde;

    public YeahTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botao 'Ativar Agora'
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Ativar Agora'")
    public YeahTela tocarBotaoAtivarAgora() throws Exception {
        salvarEvidencia("Tocar no botao 'Ativar Agora'");
        tocarElemento(tocarAtivarAgora, "N�o foi poss�vel tocar no botao 'Ativar Agora'");
        return this;
    }

    /**
     * Validar presen�a da tela 'Yeah!'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Yeah!'")
    public YeahTela validarTelaYEAH() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.YEAH)), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Yeah!' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'Yeah!'");
        return this;
    }
}
