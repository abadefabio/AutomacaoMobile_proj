package pagina.mobile.jornadas.cartao.fatura;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.cartao.Mensagem;
import constantes.cartao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static java.time.Duration.ofSeconds;

public class DesbloqueioDeCartaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(accessibility = "Continuar")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/content")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resourceId='br.com.bradesco.next:id/content']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement campoPreencher4Digitos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/content_cvv")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resourceId='br.com.bradesco.next:id/content_cvv']\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement campoPreencherCVV;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='ok']")
    @iOSXCUITFindBy(accessibility = "OK")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private MobileElement botaoOK;

    public DesbloqueioDeCartaoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presen�a da tela 'Desbloqueio de Cart�o'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Desbloqueio de Cart�o'")
    public DesbloqueioDeCartaoTela validarTelaDesbloqueioDeCartao() throws Exception {
        if (android) {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.DESBLOQUEIO_DE_CARTAO_TELA_ANDROID)), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Desbloqueio de Cart�o' n�o est� presente na tela!");
            salvarEvidencia("Validada presen�a da tela 'Desbloqueio de Cart�o'");
        } else {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.DESBLOQUEIO_DE_CARTAO_TELA_IOS)), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Desbloqueio de Cart�o' n�o est� presente na tela!");
            salvarEvidencia("Validada presen�a da tela 'Desbloqueio de Cart�o'");
        }
        return this;
    }

    /**
     * Tocar botao 'Continuar'
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Continuar'")
    public DesbloqueioDeCartaoTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar no botao 'Continuar'");
        tocarElemento(botaoContinuar, "N�o foi poss�vel tocar no botao 'Continuar'");
        return this;
    }

    /**
     * Preencher os quatro �ltimos digitos do Cart�o
     *
     * @throws Exception
     */
    @Step("Preencher quatro �ltimos digitos do Cart�o")
    public DesbloqueioDeCartaoTela preencherQuatroUltimosDigitosDoCart�o(String cartao) throws Exception {
        String digitosFinais = cartao.substring(cartao.length() - 4);
        if (android) {
            String erro = "Erro ao preencher os quatro ultimos digitos do cart�o";
            Actions actions = new Actions(getDriver());
            actions.sendKeys(campoPreencher4Digitos, digitosFinais.substring(0, 1));
            actions.sendKeys(campoPreencher4Digitos, digitosFinais.substring(1, 2));
            actions.sendKeys(campoPreencher4Digitos, digitosFinais.substring(2, 3));
            actions.sendKeys(campoPreencher4Digitos, digitosFinais.substring(3));
            actions.build().perform();
        }
        if (ios)
        escreverTexto(campoPreencher4Digitos, digitosFinais, "N�o foi poss�vel informar os 4 �ltimos d�gitos do cart�o");
        salvarEvidencia("Informar 4 �ltimos d�gitos do cart�o: " + digitosFinais);
        return this;
    }

    /**
     * Informar o CVV do cart�o
     * @throws Exception
     */
    @Step("Informar CVV")
    public DesbloqueioDeCartaoTela preencherCVV(String cvv) throws NextException {
        if (android) {
            Actions actions = new Actions(getDriver());
            actions.sendKeys(campoPreencherCVV,cvv.substring(0,1));
            actions.sendKeys(campoPreencherCVV,cvv.substring(1,2));
            actions.sendKeys(campoPreencherCVV,cvv.substring(2));
            try {
                actions.build().perform();
            } catch (Exception e) {
                throw new NextException("N�o foi poss�vel digitar no campo de d�gitos", e);
            }
        }
        if (ios) escreverTexto(campoPreencherCVV, cvv, "N�o foi poss�vel informar o CVV do cart�o");
        salvarEvidencia("Informar CVV do cart�o: " + cvv);
        return this;
    }

    /**
     * Tocar bot�o "OK"
     * @throws Exception
     */
    @Step("Tocar bot�o \"OK\"")
    public DesbloqueioDeCartaoTela tocarBotaoOK() throws Exception {
        salvarEvidencia("Tocar no bot�o \"OK\"");
        tocarElemento(botaoOK, "N�o foi poss�vel tocar no bot�o \"OK\"");
        return this;
    }

    /**
     * Validar presen�a da mensagem 'Cr�dito ativado!'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da mensagem 'Cr�dito ativado!'")
    public DesbloqueioDeCartaoTela validarMensagemCreditoAtivado() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.CREDITO_ATIVADO)), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Cr�dito ativado!' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da mensagem 'Cr�dito ativado!'");
        return this;
    }

    /**
     * Validar presen�a da mensagem 'Tudo Certo!'
     *
     * @throws Exception
     */
    @Step("Validar presen�a da mensagem 'Tudo Certo!'")
    public DesbloqueioDeCartaoTela validarMensagemTudoCerto() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.TUDO_CERTO)), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Tudo Certo!' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da mensagem 'Tudo Certo!'");
        return this;
    }
}
