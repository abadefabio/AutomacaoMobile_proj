package pagina.mobile.jornadas.pix;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TermosECondicoesTela extends PaginaBase {

    public TermosECondicoesTela(AppiumDriver driver) {super(driver);}

    @AndroidFindBy(xpath = "//*[contains(@text,'Termo de Ades�o ao Pix')]/..")
    @iOSXCUITFindBy(accessibility = "Termo de Ades�o ao Pix")
    private MobileElement botaoTermoAdesaoPix;

    @AndroidFindBy(xpath = "//*[contains(@text,'TERMOS E CONDI��ES PARA O USO DO PIX NO BRADESCO')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TERMOS E CONDI��ES PARA O USO DO PIX NO BRADESCO']")
    private MobileElement labelTermosECondicoesPixBradesco;

    @AndroidFindBy(xpath = "//*[contains(@text,'CLIENTE')]")
    @iOSXCUITFindBy(accessibility = "CLIENTE")
    private MobileElement labelCliente;

    @AndroidFindBy(accessibility = "voltar")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/cb_checkbox']")
    @iOSXCUITFindBy(accessibility = "Li e Concordo com os Termos e Condi��es do Uso do Pix no Bradesco")
    private MobileElement checkBoxTermos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'CONTINUAR')]")
    @iOSXCUITFindBy(accessibility = "continuar")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CONTINUAR')]")
    private MobileElement botaoContinuar;

    /**
     * Clicar bot�o 'Termo Adesao Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Termo Adesao Pix\"")
    public TermosECondicoesTela tocarBotaoTermoAdesaoPix() throws Exception {
        aguardarCarregamentoElemento(botaoTermoAdesaoPix);
        salvarEvidencia("Clicar no bot�o 'Termo Adesao Pix'");
        tocarElemento(botaoTermoAdesaoPix, "N�o foi poss�vel clicar no bot�o 'Termo Adesao Pix'");
        salvarEvidencia("Termo Adesao Pix");
        return this;
    }

    /**
     * Validar o Termo
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Termo Adesao Pix\"")
    public TermosECondicoesTela validarTermoAdesaoPix() throws Exception {
        aguardarCarregamentoElemento(labelTermosECondicoesPixBradesco);
        salvarEvidencia("Termos e condi��es para o uso do Pix no Bradesco");
        rolarTelaAteFinal(10);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelCliente,"N�o foi poss�vel validar o fim do termo");
        salvarEvidencia("Termo Adesao Pix");
        return this;
    }

    /**
     * Clicar bot�o 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Voltar\"")
    public TermosECondicoesTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicar no bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel clicar no bot�o 'Voltar'");
        return this;
    }

    /**
     * Clicar check box 'Termos e Condi��es'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar check box \"Termos e Condi��es\"")
    public TermosECondicoesTela tocarCheckBoxTermosECondi��es() throws Exception {
        aguardarCarregamentoElemento(checkBoxTermos);
        tocarElemento(checkBoxTermos, "N�o foi poss�vel clicar no check box 'Termos e Condi��es'");
        salvarEvidencia("Clicar no check box 'Termos e Condi��es'");
        return this;
    }

    /**
     * Clicar bot�o 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TermosECondicoesTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "N�o foi poss�vel clicar no bot�o 'Continuar'");
        salvarEvidencia("Clicar no bot�o 'Continuar'");
        return this;
    }

}
