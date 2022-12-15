package pagina.mobile.jornadas.cartao.desbloqueio;

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
import org.openqa.selenium.interactions.Actions;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

public class CartaoDesbloqueioTela extends PaginaBase {

    //Botão Desbloquear
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_start")
    @AndroidFindBy(xpath = "android.widget.Button[@resourceId='br.com.bradesco.next:id/bt_start']")
    @iOSXCUITFindBy(accessibility = "Desbloquear")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Desbloquear\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Desbloquear')]")
    private MobileElement botaoDesbloquear;

    //Botão Desbloquear sem Seguro
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "DESBLOQUEAR SEM SEGURO")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"DESBLOQUEAR SEM SEGURO\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DESBLOQUEAR SEM SEGURO\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_without_insurance")
    @AndroidFindBy(xpath = "//android.widget.Button[@resourceId='br.com.bradesco.next:id/btn_continue_without_insurance']")
    private MobileElement botaoDesbloquearSemSeguro;

    // Campo de entrada dos 4 últimos dígitos do cartão
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement campo4DigitosCartao;

    // Campo 1 dos 4 últimos dígitos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/number_card_1")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resourceId='br.com.bradesco.next:id/number_card_1']")
    private MobileElement campo1Campo4DigitosAndroid;

    // Campo 2 dos 4 últimos dígitos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/number_card_2")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resourceId='br.com.bradesco.next:id/number_card_2']")
    private MobileElement campo2Campo4DigitosAndroid;

    // Campo 3 dos 4 últimos dígitos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/number_card_3")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resourceId='br.com.bradesco.next:id/number_card_3']")
    private MobileElement campo3Campo4DigitosAndroid;

    // Campo 4 dos 4 últimos dígitos
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/number_card_4")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resourceId='br.com.bradesco.next:id/number_card_4']")
    private MobileElement campo4Campo4DigitosAndroid;

    //Campo CVV
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    private MobileElement campoCvv;

    // Campo 1 CVV Android
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/cvv_1")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resourceId='br.com.bradesco.next:id/cvv_1']")
    private MobileElement campo1CvvAndroid;

    // Campo 2 CVV Android
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/cvv_2")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resourceId='br.com.bradesco.next:id/cvv_2']")
    private MobileElement campo2CvvAndroid;

    // Campo 3 CVV Android
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/cvv_3")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resourceId='br.com.bradesco.next:id/cvv_3']")
    private MobileElement campo3CvvAndroid;

    //Botão Confirmar (mapeado internamente como Continuar)
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Continuar")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidFindBy(xpath = "//android.widget.Button[@resourceId='br.com.bradesco.next:id/bt_continue']")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTINUAR\"]")
    private MobileElement botaoContinuar;

    //Botão OK
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(id = "OK")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    @iOSXCUITFindBy(xpath = "/XCUIElementTypeButton[@name=\"OK\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_finish")
    @AndroidFindBy(xpath = "//android.widget.Button[@resourceId='br.com.bradesco.next:id/bt_finish']")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(contains(@text,'OK')]")
    private MobileElement botaoOK;

    public CartaoDesbloqueioTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar textos esperados na tela de desbloqueio
     * @param textosEsperados
     */
    public CartaoDesbloqueioTela validarMensagens(String... textosEsperados) {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(textosEsperados),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar mensagens esperadas na tela"
        );
        salvarEvidencia("Validada a tela de desbloqueio");
        return this;
    }

    /**
     * Tocar botao "Desbloquear"
     * @throws Exception
     */
    @Step("Tocar botão \"Desbloquear\"")
    public CartaoDesbloqueioTela tocarBotaoDesbloquear() throws Exception {
        salvarEvidencia("Tocar no botao \"Desbloquear\"");
        tocarElemento(botaoDesbloquear, "Não foi possível tocar no botão \"Desbloquear\"");
        return this;
    }

    /**
     * Tocar botão "Desbloquear com Seguro"
     * @throws Exception
     */
    @Step("Tocar botão \"Desbloquear sem Seguro\"")
    public CartaoDesbloqueioTela tocarBotaoDesbloquearSemSeguro() throws Exception {
        salvarEvidencia("Tocar no botão \"Desbloquear sem Seguro\"");
        tocarElemento(botaoDesbloquearSemSeguro, "Não foi possível tocar no botão \"Desbloquear sem Seguro\"");
        return this;
    }

    /**
     * Validar mensagem na tela desbloqueio do cartão pós confirmação de recebimento
     * @param mensagens
     */
    @Step("Validar mensagens da tela de desbloqueio e seguro")
    public CartaoDesbloqueioTela validarMensagensTela(String... mensagens) {
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(mensagens),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar as mensagens da tela de desbloqueio e seguro"
        );
        salvarEvidencia("Validadas as mensagens da tela de desbloqueio e seguro");
        return this;
    }

    /**
     * Validar presença do campo de 4 últimos dígitos do cartão
     * @throws Exception
     */
    @Step(" Validar presença do campo de 4 últimos dígitos do cartão")
    public CartaoDesbloqueioTela validarPresencaCampo4DigitosCartao() throws Exception {
        final String erro = "O campo de 4 últimos dígitos do cartão não foi encontrado.";
        if (android) {

            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campo1Campo4DigitosAndroid),
                    MetodoComparacaoBooleano.VERDADEIRO, erro
            );
            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campo2Campo4DigitosAndroid),
                    MetodoComparacaoBooleano.VERDADEIRO, erro
            );
            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campo3Campo4DigitosAndroid),
                    MetodoComparacaoBooleano.VERDADEIRO, erro
            );
            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campo4Campo4DigitosAndroid),
                    MetodoComparacaoBooleano.VERDADEIRO, erro
            );
        }

        if (ios) {
            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campo4DigitosCartao),
                    MetodoComparacaoBooleano.VERDADEIRO,
                    erro
            );
        }
        salvarEvidencia("Validada a presença do campo dos 4 últimos dígitos do cartão");
        return this;
    }

    /**
     * Informar 4 últimos dígitos do cartão
     * @param cartao
     * @throws Exception
     */
    @Step("Informar 4 últimos dígitos do cartão")
    public CartaoDesbloqueioTela informar4UltimosDigitos(String cartao) throws Exception {
        String digitosFinais = cartao.substring(cartao.length() - 4);
        if (android) {
            Actions actions = new Actions(getDriver());
            actions.sendKeys(campo1Campo4DigitosAndroid,digitosFinais.substring(0,1));
            actions.sendKeys(campo2Campo4DigitosAndroid,digitosFinais.substring(1,2));
            actions.sendKeys(campo3Campo4DigitosAndroid,digitosFinais.substring(2,3));
            actions.sendKeys(campo4Campo4DigitosAndroid,digitosFinais.substring(3));
            try {
                actions.build().perform();
            } catch (Exception e) {
                throw new NextException("Não foi possível digitar no campo de dígitos", e);
            }
        }
        if (ios) escreverTexto(campo4DigitosCartao, digitosFinais, "Não foi possível informar os 4 últimos dígitos do cartão");
        salvarEvidencia("Informar 4 últimos dígitos do cartão: " + digitosFinais);
        return this;
    }

    /**
     * Validar presença do campo CVV
     * @throws Exception
     */
    @Step("Validar presença do campo CVV")
    public CartaoDesbloqueioTela validarPresencaCampoCvv() throws Exception {
        final String erro = "O campo CVV não foi encontrado.";
        if (android) {
            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campo1CvvAndroid),
                    MetodoComparacaoBooleano.VERDADEIRO, erro
            );
            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campo2CvvAndroid),
                    MetodoComparacaoBooleano.VERDADEIRO, erro
            );
            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campo3CvvAndroid),
                    MetodoComparacaoBooleano.VERDADEIRO, erro
            );
        }

        if (ios) {
            validarCondicaoBooleana(
                    aguardarCarregamentoElemento(campoCvv),
                            MetodoComparacaoBooleano.VERDADEIRO,
                            erro
            );
        }
        salvarEvidencia("Validada a presença do campo CVV");
        return this;
    }

    /**
     * Tocar botao "Continuar"
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar/Confirmar\"")
    public CartaoDesbloqueioTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar no botao \"Continuar/Confirmar\"");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão \"Continuar/Confirmar\"");
        return this;
    }

    /**
     * Informar o CVV do cartão
     * @param cvv
     * @throws Exception
     */
    @Step("Informar CVV")
    public CartaoDesbloqueioTela informarCvv(String cvv) throws Exception {
        if (android) {
            Actions actions = new Actions(getDriver());
            actions.sendKeys(campo1CvvAndroid,cvv.substring(0,1));
            actions.sendKeys(campo2CvvAndroid,cvv.substring(1,2));
            actions.sendKeys(campo3CvvAndroid,cvv.substring(2));
            try {
                actions.build().perform();
            } catch (Exception e) {
                throw new NextException("Não foi possível digitar no campo de dígitos", e);
            }
        }
        if (ios) escreverTexto(campoCvv, cvv, "Não foi possível informar o CVV do cartão");
        salvarEvidencia("Informar CVV do cartão: " + cvv);
        return this;
    }

    /**
     * Tocar botão "OK"
     * @throws Exception
     */
    @Step("Tocar botão \"OK\"")
    public CartaoDesbloqueioTela tocarBotaoOK() throws NextException {
        salvarEvidencia("Tocar no botão \"OK\"");
        tocarElemento(botaoOK, "Não foi possível tocar no botão \"OK\"");
        return this;
    }

    /**
     * Validar presença do botão Desbloquear Sem Seguro
     * @throws Exception
     */
    @Step("Validar presença do botão Desbloquear Sem Seguro")
    public CartaoDesbloqueioTela validarPresencaBotaoDesbloquearSemSeguro() throws Exception {

        validarCondicaoBooleana(
                aguardarCarregamentoElemento(botaoDesbloquearSemSeguro),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar a presença do botão 'Desbloquear Sem Seguro'"
        );
        salvarEvidencia("Validada a presença do campo 'Desbloquear Sem Seguro'");
        return this;
    }

 }
