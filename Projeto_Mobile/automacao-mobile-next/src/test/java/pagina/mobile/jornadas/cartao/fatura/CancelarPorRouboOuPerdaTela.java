package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CancelarPorRouboOuPerdaTela extends PaginaBase {

    // botao CONTINUAR
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath ="//android.widget.Button[@content-desc=\"OK, Cancelar\"]")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;

    public CancelarPorRouboOuPerdaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Cancelar por roubo ou perda'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela 'Cancelar por roubo ou perda'")
    public CancelarPorRouboOuPerdaTela validarTelaCancelarPorRouboOuPerda() throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CANCELAR_POR_ROUBO_OU_PERDA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'CANCELAR POR ROUBO OU PERDA' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'CANCELAR POR ROUBO OU PERDA'");
        return this;
    }

    /**
     * Tocar botao "Ok, Cancelar"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"Cancelar por roubo ou perda\"")
    public CancelarPorRouboOuPerdaTela tocarOkCancelar() throws Exception {

        salvarEvidencia("Tocar no botao 'CONTINUAR'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botao 'CONTINUAR'");
        return this;
    }
}
