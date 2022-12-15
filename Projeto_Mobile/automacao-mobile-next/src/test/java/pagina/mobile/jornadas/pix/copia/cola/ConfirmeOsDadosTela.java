package pagina.mobile.jornadas.pix.copia.cola;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import java.util.ArrayList;
import java.util.List;

public class ConfirmeOsDadosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='REALIZAR TRANSA��O']")
    @AndroidFindBy(xpath = "//*[@text='Realizar transa��o']")
    @iOSXCUITFindBy(xpath = "//*[@name='REALIZAR TRANSA��O']")
    private MobileElement botaoRealizarTransacao;

    @AndroidFindBy(xpath = "//*[@text='CONFIRME OS DADOS']")
    @iOSXCUITFindBy(xpath = "//*[@name='CONFIRME OS DADOS']")
    private MobileElement tituloConfirmeOsDados;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='Quando']")
    @AndroidFindBy(xpath = "//*[@text='QUANDO']")
    @iOSXCUITFindBy(xpath = "//*[@name='Quando']")
    @iOSXCUITFindBy(accessibility = "Quando")
    private MobileElement botaoQuandoCalendario;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='AGENDAR TRANSA��O']")
    @AndroidFindBy(xpath = "//*[@text='Agendar Transa��o']")
    @iOSXCUITFindBy(xpath = "//*[@name='AGENDAR TRANSA��O']")
    @iOSXCUITFindBy(accessibility = "AGENDAR")
    private MobileElement botaoAgendarTransacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_pix_payment_input_data_confirm_additional_info")
    @iOSXCUITFindBy(accessibility = "Informa��es adicionais")
    private MobileElement linkInformacoesAdicionais;

    public ConfirmeOsDadosTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Realizar Transa��o'
     *
     * @return PixTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Realizar Transa��o'")
    public ConfirmeOsDadosTela tocarBotaoRealizarTransacao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRealizarTransacao, "N�o foi poss�vel localizar no bot�o 'Realizar Transa��o'");
        salvarEvidencia("Tocar no bot�o 'Realizar Transa��o'");
        tocarElemento(botaoRealizarTransacao, "N�o foi poss�vel tocar no bot�o 'Realizar Transa��o'");
        return this;
    }

    /**
     * Validar informa��es da tela 'Confirme os Dados'
     *
     * @param validarDados Campos e valores a serem validados e passados no json da massa do cen�rio de teste
     * @param dados        Campos a serem buscados na tela cadastrados na 'Interface ConfirmeOsDados'
     * @return ConfirmeOsDadosTela
     * @throws Exception
     */
    @Step("Validar informar��es da tela 'Confirme os Dados'")
    public ConfirmeOsDadosTela validarInformacoesTelaConfirmeDados(JSONObject validarDados, String[] dados) throws Exception {
        aguardarCarregamentoElemento(tituloConfirmeOsDados);
        rolarTelaAteInicio();
        salvarEvidencia("Iniciada a valida��o das informa��es da tela 'Confirme os Dados'");
        List<MobileElement> campos = new ArrayList<>(), valores = new ArrayList<>();
        By campo;
        if (android) {
            for (int i=0; i<dados.length; i++) {
                campo = new ByXPath("//*[@text='"+dados[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "N�o foi poss�vel encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "N�o foi poss�vel encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../*[@resource-id='br.com.bradesco.next:id/nl_pix_payment_data_confirm_value']"),
                        "N�o foi poss�vel encontrar o valor referente ao campo: " + campo));
            }
        } else {
            for (int i=0; i<dados.length; i++) {
                campo = new ByXPath("//*[@name='"+dados[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "N�o foi poss�vel encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "N�o foi poss�vel encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../XCUIElementTypeStaticText[2]"),
                        "N�o foi poss�vel encontrar o valor referente ao campo: " + campo));
            }
        }
        validarCamposValor(campos, valores, validarDados);
        salvarEvidencia("Finalizada a valida��o das informa��es da tela 'Confirme os Dados'");
        return this;
    }

    /**
     * Tocar no bot�o 'Quando'
     * fr
     * @return PixTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Quando'")
    public ConfirmeOsDadosTela tocarBotaoQuando() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoQuandoCalendario, "N�o foi poss�vel localizar no bot�o 'Quando' abrir calendario'");
        salvarEvidencia("Tocar no bot�o 'Quando' abrir calendario");
        tocarElemento(botaoQuandoCalendario, "N�o foi poss�vel tocar no bot�o 'Quando' abrir calendario'");
        return this;
    }

    /**
     * Tocar no bot�o 'Agendar Transa��o'
     *
     * @return PixTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Agendar Transa��o'")
    public ConfirmeOsDadosTela tocarBotaoAgendarTransacao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAgendarTransacao, "N�o foi poss�vel localizar no bot�o 'Agendar Transa��o'");
        salvarEvidencia("Tocar no bot�o 'Agendar Transa��o'");
        tocarElemento(botaoAgendarTransacao, "N�o foi poss�vel tocar no bot�o 'Agendar Transa��o'");
        return this;
    }

    /**
     * Tocar link 'Informa��es Adicionais'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Informa��es Adicionais'")
    public ConfirmeOsDadosTela tocarInformacoesAdicionais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(linkInformacoesAdicionais, "N�o foi poss�vel localizar o link 'Informa��es Adicionais'");
        salvarEvidencia("Tocar no link 'Informa��es Adicionais'");
        tocarElemento(linkInformacoesAdicionais, "N�o foi poss�vel tocar o link 'Informa��es Adicionais'");
        return this;
    }
}
