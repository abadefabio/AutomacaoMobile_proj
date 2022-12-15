package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class BuscaCepTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_name")
    @iOSXCUITFindBy(accessibility = "CEP")
    private MobileElement botaoCep;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Estado e cidade']")
    @iOSXCUITFindBy(accessibility = "Estado e cidade")
    private MobileElement botaoEstadoCidade;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Selecione o Estado']")
    @iOSXCUITFindBy(accessibility = "Selecione o estado")
    private MobileElement botaoEstado;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Selecione a Cidade']")
    @iOSXCUITFindBy(accessibility = "Selecionado a cidade")
    private MobileElement botaoCidade;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmaEstado;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmaCidade;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    public BuscaCepTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar em 'Cep'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Cep\"")
    public BuscaCepTela tocarBotaoCep() throws Exception {
        aguardarCarregamentoElemento(botaoCep);
        salvarEvidencia("Clicar em 'Cep'");
        tocarElemento(botaoCep, "N�o foi poss�vel clicar  em Cep");
        return this;
    }

    /**
     * Clicar em 'Estado e Cidade'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Estado e Cidade\"")
    public BuscaCepTela tocarBotaoEstadoECidade() throws Exception {
        aguardarCarregamentoElemento(botaoEstadoCidade);
        salvarEvidencia("Clicar em 'Estado e Cidade'");
        tocarElemento(botaoEstadoCidade, "N�o foi poss�vel clicar  em Estado e Cidade");
        return this;
    }

    /**
     * Clicar em 'Estado'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar em\"Estado\"")
    public BuscaCepTela tocarBotaoEstado() throws Exception {
        aguardarCarregamentoElemento(botaoEstado);
        salvarEvidencia("Clicar em 'Estado'");
        tocarElemento(botaoEstado, "N�o foi poss�vel selecionar Estado");
        return this;
    }

    /**
     * Clicar em 'Cidade'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar em  \"Cidade\"")
    public BuscaCepTela tocarBotaoCidade() throws Exception {
        aguardarCarregamentoElemento(botaoCidade);
        salvarEvidencia("Clicar em 'Cidade'");
        tocarElemento(botaoCidade, "N�o foi poss�vel selecionar  Cidade");
        return this;
    }

    /**
     * Selecionar a Cidade
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar a\"Cidade\"")
    public BuscaCepTela selecionarCidade() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmaCidade);
        salvarEvidencia("Selecionar a 'Cidade'");
        tocarElemento(botaoConfirmaCidade, "N�o foi poss�vel selecionar Cidade");
        return this;
    }

    /**
     * Selecionar o Estado
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar o\"Estado\"")
    public BuscaCepTela selecionarEstado() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmaEstado);
        salvarEvidencia("Selecionar o 'Estado'");
        tocarElemento(botaoConfirmaEstado, "N�o foi poss�vel selecionar Estado");
        return this;
    }

    /**
     * Clicar em 'Confirmar'
     *
     * @return
     * @throws Exception
     */

    @Step("Clicar em  \"Confirmar\"")
    public BuscaCepTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Clicar em 'Confirmar'");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel clicar em 'Confirmar'");
        return this;
    }
}
