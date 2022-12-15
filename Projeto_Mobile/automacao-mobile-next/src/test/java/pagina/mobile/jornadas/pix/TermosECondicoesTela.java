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

    @AndroidFindBy(xpath = "//*[contains(@text,'Termo de Adesão ao Pix')]/..")
    @iOSXCUITFindBy(accessibility = "Termo de Adesão ao Pix")
    private MobileElement botaoTermoAdesaoPix;

    @AndroidFindBy(xpath = "//*[contains(@text,'TERMOS E CONDIÇÕES PARA O USO DO PIX NO BRADESCO')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TERMOS E CONDIÇÕES PARA O USO DO PIX NO BRADESCO']")
    private MobileElement labelTermosECondicoesPixBradesco;

    @AndroidFindBy(xpath = "//*[contains(@text,'CLIENTE')]")
    @iOSXCUITFindBy(accessibility = "CLIENTE")
    private MobileElement labelCliente;

    @AndroidFindBy(accessibility = "voltar")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @AndroidFindBy(xpath = "//*[@resource-id='br.com.bradesco.next:id/cb_checkbox']")
    @iOSXCUITFindBy(accessibility = "Li e Concordo com os Termos e Condições do Uso do Pix no Bradesco")
    private MobileElement checkBoxTermos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'CONTINUAR')]")
    @iOSXCUITFindBy(accessibility = "continuar")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'CONTINUAR')]")
    private MobileElement botaoContinuar;

    /**
     * Clicar botão 'Termo Adesao Pix'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Termo Adesao Pix\"")
    public TermosECondicoesTela tocarBotaoTermoAdesaoPix() throws Exception {
        aguardarCarregamentoElemento(botaoTermoAdesaoPix);
        salvarEvidencia("Clicar no botão 'Termo Adesao Pix'");
        tocarElemento(botaoTermoAdesaoPix, "Não foi possível clicar no botão 'Termo Adesao Pix'");
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
        salvarEvidencia("Termos e condições para o uso do Pix no Bradesco");
        rolarTelaAteFinal(10);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(labelCliente,"Não foi possível validar o fim do termo");
        salvarEvidencia("Termo Adesao Pix");
        return this;
    }

    /**
     * Clicar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Voltar\"")
    public TermosECondicoesTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicar no botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível clicar no botão 'Voltar'");
        return this;
    }

    /**
     * Clicar check box 'Termos e Condições'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar check box \"Termos e Condições\"")
    public TermosECondicoesTela tocarCheckBoxTermosECondições() throws Exception {
        aguardarCarregamentoElemento(checkBoxTermos);
        tocarElemento(checkBoxTermos, "Não foi possível clicar no check box 'Termos e Condições'");
        salvarEvidencia("Clicar no check box 'Termos e Condições'");
        return this;
    }

    /**
     * Clicar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TermosECondicoesTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "Não foi possível clicar no botão 'Continuar'");
        salvarEvidencia("Clicar no botão 'Continuar'");
        return this;
    }

}
