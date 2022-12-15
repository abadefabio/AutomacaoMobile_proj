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
     * Validar presença da tela 'Desbloqueio de Cartão'
     *
     * @throws Exception
     */
    @Step("Validar presença da tela 'Desbloqueio de Cartão'")
    public DesbloqueioDeCartaoTela validarTelaDesbloqueioDeCartao() throws Exception {
        if (android) {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.DESBLOQUEIO_DE_CARTAO_TELA_ANDROID)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Desbloqueio de Cartão' não está presente na tela!");
            salvarEvidencia("Validada presença da tela 'Desbloqueio de Cartão'");
        } else {
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(TituloTela.DESBLOQUEIO_DE_CARTAO_TELA_IOS)), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Desbloqueio de Cartão' não está presente na tela!");
            salvarEvidencia("Validada presença da tela 'Desbloqueio de Cartão'");
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
        tocarElemento(botaoContinuar, "Não foi possível tocar no botao 'Continuar'");
        return this;
    }

    /**
     * Preencher os quatro últimos digitos do Cartão
     *
     * @throws Exception
     */
    @Step("Preencher quatro últimos digitos do Cartão")
    public DesbloqueioDeCartaoTela preencherQuatroUltimosDigitosDoCartão(String cartao) throws Exception {
        String digitosFinais = cartao.substring(cartao.length() - 4);
        if (android) {
            String erro = "Erro ao preencher os quatro ultimos digitos do cartão";
            Actions actions = new Actions(getDriver());
            actions.sendKeys(campoPreencher4Digitos, digitosFinais.substring(0, 1));
            actions.sendKeys(campoPreencher4Digitos, digitosFinais.substring(1, 2));
            actions.sendKeys(campoPreencher4Digitos, digitosFinais.substring(2, 3));
            actions.sendKeys(campoPreencher4Digitos, digitosFinais.substring(3));
            actions.build().perform();
        }
        if (ios)
        escreverTexto(campoPreencher4Digitos, digitosFinais, "Não foi possível informar os 4 últimos dígitos do cartão");
        salvarEvidencia("Informar 4 últimos dígitos do cartão: " + digitosFinais);
        return this;
    }

    /**
     * Informar o CVV do cartão
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
                throw new NextException("Não foi possível digitar no campo de dígitos", e);
            }
        }
        if (ios) escreverTexto(campoPreencherCVV, cvv, "Não foi possível informar o CVV do cartão");
        salvarEvidencia("Informar CVV do cartão: " + cvv);
        return this;
    }

    /**
     * Tocar botão "OK"
     * @throws Exception
     */
    @Step("Tocar botão \"OK\"")
    public DesbloqueioDeCartaoTela tocarBotaoOK() throws Exception {
        salvarEvidencia("Tocar no botão \"OK\"");
        tocarElemento(botaoOK, "Não foi possível tocar no botão \"OK\"");
        return this;
    }

    /**
     * Validar presença da mensagem 'Crédito ativado!'
     *
     * @throws Exception
     */
    @Step("Validar presença da mensagem 'Crédito ativado!'")
    public DesbloqueioDeCartaoTela validarMensagemCreditoAtivado() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.CREDITO_ATIVADO)), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Crédito ativado!' não está presente na tela!");
        salvarEvidencia("Validada presença da mensagem 'Crédito ativado!'");
        return this;
    }

    /**
     * Validar presença da mensagem 'Tudo Certo!'
     *
     * @throws Exception
     */
    @Step("Validar presença da mensagem 'Tudo Certo!'")
    public DesbloqueioDeCartaoTela validarMensagemTudoCerto() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(Mensagem.TUDO_CERTO)), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Tudo Certo!' não está presente na tela!");
        salvarEvidencia("Validada presença da mensagem 'Tudo Certo!'");
        return this;
    }
}
