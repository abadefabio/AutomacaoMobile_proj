package pagina.mobile.jornadas.depositos;

import org.testng.Assert;
import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.depositos.saques.DepositosSaques;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TransferirBradescoTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name]")
    private MobileElement informativoBradesco;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_go_app_bradesco")
    @iOSXCUITFindBy(accessibility = "Ir para o App Bradesco")
    private MobileElement botaoIrAppBradesco;

    @iOSXCUITFindBy(accessibility = "Open")
    private MobileElement botaoAbrir;

    @AndroidFindBy(accessibility = "Bradesco")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Bradesco\"]")
    private MobileElement appBradesco;

    public TransferirBradescoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Voltar\"")
    public TransferirBradescoTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicar no botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível clicar no botão Voltar");
        return this;
    }

    /**
     * Validar Mensagem informativo de transferencia do Bradesco
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Informativo Bradesco")
    public TransferirBradescoTela validarInformativoBradesco() throws Exception {
        aguardarCarregamentoElemento(informativoBradesco);
        compararElementoTexto(informativoBradesco, DepositosSaques.DO_BRADESCO_PARA_NEXT, MetodoComparacao.CONTEM);
        salvarEvidencia("Informativo Bradesco validado!");
        return this;
    }

    /**
     * Clicar no botão 'Ir para o App Bradesco'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Ir para o App Bradesco\"")
    public TransferirBradescoTela tocarBotaoIrAppBradesco() throws Exception {
        aguardarCarregamentoElemento(botaoIrAppBradesco);
        salvarEvidencia("Clicar no botão 'Ir para o App Bradesco'");
        tocarElemento(botaoIrAppBradesco, "Não foi possível clicar no botão 'Ir para app Bradesco'");
        if (verificarPresencaElemento(new MobileBy.ByAccessibilityId("Open"))) {
            tocarElemento(botaoAbrir, "Não foi possível clicar no botão 'Open'");
        }
        return this;
    }

    /**
     * Validar que o Aplicativo Bradesco foi aberto.
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Informativo Bradesco")
    public TransferirBradescoTela validarAppBradesco() {
        aguardarCarregamentoElemento(appBradesco);
        Assert.assertTrue(appBradesco.isDisplayed());
        salvarEvidencia("Aplicativo Bradesco Aberto!");
        return this;
    }
}
