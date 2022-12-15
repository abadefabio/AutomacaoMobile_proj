package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.cartao.Mensagem;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ContratarSeguroTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_without_insurance")
    @AndroidFindBy(xpath = "//android.widget.Button[@Text =\"contratar sem seguro\"]")
    @iOSXCUITFindBy(accessibility = "CONTRATAR SEM SEGURO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTRATAR SEM SEGURO\"`]")
    private MobileElement botaoContratarSemSeguro;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_with_insurance")
    @AndroidFindBy(xpath = "//android.widget.Button[@Text =\"contratar com seguro\"]")
    @iOSXCUITFindBy(accessibility = "CONTRATAR COM SEGURO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTRATAR COM SEGURO\"`]")
    private MobileElement botaoContratarComSeguro;

    public ContratarSeguroTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença do texto 'Proteja seu cartão de crédito contra perda, furto, roubo ou outros imprevistos e concorra a R$ 12 mil toda semana!'
     *
     * @throws Exception
     */
    @Step("Validar presença do texto 'Proteja seu cartão de crédito contra perda, furto, roubo ou outros imprevistos e concorra a R$ 12 mil toda semana!'")
    public ContratarSeguroTela validarMensagemContratarSeguro() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.MENSAGEM_CONTRATAR_SEGURO_TELA)), MetodoComparacaoBooleano.VERDADEIRO, "Texto 'Proteja seu cartão de crédito contra perda, furto, roubo ou outros imprevistos e concorra a R$ 12 mil toda semana!' não está presente na tela!");
        salvarEvidencia("Validada presença do texto 'Proteja seu cartão de crédito contra perda, furto, roubo ou outros imprevistos e concorra a R$ 12 mil toda semana!'");
        return this;
    }

    /**
     * Tocar botao 'Contratar sem Seguro'
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Contratar sem Seguro'")
    public ContratarSeguroTela tocarContratarSemSeguro() throws Exception {
        salvarEvidencia("Tocar no botao 'Contratar sem Seguro'");
        tocarElemento(botaoContratarSemSeguro, "Não foi possível tocar no botao 'Contratar sem Seguro'");
        return this;
    }
}
