package pagina.mobile.jornadas.investimentos.resgate;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ResgateTela extends PaginaBase {

    public ResgateTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@text=\"Resgatar tudo\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_with_draw")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Resgatar tudo\"]")
    private MobileElement botaoResgatarTudo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/next_text_view_goal_fund_balance")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total disponível para resgate: \"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement labelTotalDisponivelResgate;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/value_withdraw_edit_text")
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeTextField")
    private MobileElement campoValorResgate;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_value")
    @iOSXCUITFindBy(accessibility = "Continuar")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    private MobileElement botaoContinuar;

    /**
     * Preencher campo 'Valor do resgate'
     *
     * @param valorResgate Valor a ser resgatado
     * @return ResgateTela
     * @throws NextException
     */
    @Step("Preencher campo 'Valor do resgate'")
    public ResgateTela preencherCampoValorResgate(String valorResgate) throws NextException {
        aguardarElementoHabilitado(campoValorResgate);
        escreverTexto(campoValorResgate, valorResgate, true, "Não foi possível preencher no campo 'Valor do resgate'");
        salvarEvidencia("Preenchido no campo 'Valor do resgate' o valor " + valorResgate);
        return this;
    }

    /**
     * Tocar no botão 'Resgatar tudo'
     *
     * @return ResgateTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Resgatar tudo'")
    public ResgateTela tocarResgatarTudo() throws Exception {
        aguardarElementoHabilitado(botaoResgatarTudo);
        tocarElemento(botaoResgatarTudo,"Não foi possível tocar no botão 'Resgatar tudo'");
        salvarEvidencia("Tocado no botão 'Resgatar tudo'");
        esconderTeclado();
        return this;
    }

    /**
     * Retorna o valor preenchido no resgate
     *
     * @param valorResgate Valor do resgate a ser retornado
     * @return Retorna o valor do resgate
     * @throws Exception
     */
    @Step("Retornar o valor informado no resgate ")
    public ResgateTela retornarValorPreenchidoResgate(ThreadLocal<String> valorResgate) throws Exception {
        valorResgate.set(retornarTexto(campoValorResgate, "Não foi possível retornar o valor do resgate").substring(3));
        return this;
    }

    /**
     * Recupera 'Valor total' disponível para resgate
     *
     * @param valorTotalDisponivelParaResgate Parâmetro que receberá o valor total disponível para resgate
     * @return ResgateTela
     * @throws Exception
     */
    @Step("Recupera 'Valor total' disponível para resgate")
    public ResgateTela recuperarValorTotalDisponivelParaResgate(ThreadLocal<String> valorTotalDisponivelParaResgate) throws Exception {
        String valorTotalResgate = retornarTexto(labelTotalDisponivelResgate,"Não foi possível recuperar o valor disponível para resgate");
        valorTotalDisponivelParaResgate.set(valorTotalResgate.substring(valorTotalResgate.indexOf("R$")).substring(3));
        return this;
    }

    /**
     * Tocar no botão 'Continuar'
     *
     * @return ResgateTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Continuar'")
    public ResgateTela tocarBotaoContinuar() throws Exception {
        aguardarElementoHabilitado(botaoContinuar);
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar,"Não foi possível tocar no botão 'Continuar'");
        return this;
    }
}
