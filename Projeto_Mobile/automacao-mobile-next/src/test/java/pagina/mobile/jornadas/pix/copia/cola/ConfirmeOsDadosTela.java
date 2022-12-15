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
    @AndroidFindBy(xpath = "//*[@text='REALIZAR TRANSAÇÃO']")
    @AndroidFindBy(xpath = "//*[@text='Realizar transação']")
    @iOSXCUITFindBy(xpath = "//*[@name='REALIZAR TRANSAÇÃO']")
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
    @AndroidFindBy(xpath = "//*[@text='AGENDAR TRANSAÇÃO']")
    @AndroidFindBy(xpath = "//*[@text='Agendar Transação']")
    @iOSXCUITFindBy(xpath = "//*[@name='AGENDAR TRANSAÇÃO']")
    @iOSXCUITFindBy(accessibility = "AGENDAR")
    private MobileElement botaoAgendarTransacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_pix_payment_input_data_confirm_additional_info")
    @iOSXCUITFindBy(accessibility = "Informações adicionais")
    private MobileElement linkInformacoesAdicionais;

    public ConfirmeOsDadosTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no botão 'Realizar Transação'
     *
     * @return PixTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Realizar Transação'")
    public ConfirmeOsDadosTela tocarBotaoRealizarTransacao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoRealizarTransacao, "Não foi possível localizar no botão 'Realizar Transação'");
        salvarEvidencia("Tocar no botão 'Realizar Transação'");
        tocarElemento(botaoRealizarTransacao, "Não foi possível tocar no botão 'Realizar Transação'");
        return this;
    }

    /**
     * Validar informações da tela 'Confirme os Dados'
     *
     * @param validarDados Campos e valores a serem validados e passados no json da massa do cenário de teste
     * @param dados        Campos a serem buscados na tela cadastrados na 'Interface ConfirmeOsDados'
     * @return ConfirmeOsDadosTela
     * @throws Exception
     */
    @Step("Validar informarções da tela 'Confirme os Dados'")
    public ConfirmeOsDadosTela validarInformacoesTelaConfirmeDados(JSONObject validarDados, String[] dados) throws Exception {
        aguardarCarregamentoElemento(tituloConfirmeOsDados);
        rolarTelaAteInicio();
        salvarEvidencia("Iniciada a validação das informações da tela 'Confirme os Dados'");
        List<MobileElement> campos = new ArrayList<>(), valores = new ArrayList<>();
        By campo;
        if (android) {
            for (int i=0; i<dados.length; i++) {
                campo = new ByXPath("//*[@text='"+dados[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "Não foi possível encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "Não foi possível encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../*[@resource-id='br.com.bradesco.next:id/nl_pix_payment_data_confirm_value']"),
                        "Não foi possível encontrar o valor referente ao campo: " + campo));
            }
        } else {
            for (int i=0; i<dados.length; i++) {
                campo = new ByXPath("//*[@name='"+dados[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "Não foi possível encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "Não foi possível encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../XCUIElementTypeStaticText[2]"),
                        "Não foi possível encontrar o valor referente ao campo: " + campo));
            }
        }
        validarCamposValor(campos, valores, validarDados);
        salvarEvidencia("Finalizada a validação das informações da tela 'Confirme os Dados'");
        return this;
    }

    /**
     * Tocar no botão 'Quando'
     * fr
     * @return PixTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Quando'")
    public ConfirmeOsDadosTela tocarBotaoQuando() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoQuandoCalendario, "Não foi possível localizar no botão 'Quando' abrir calendario'");
        salvarEvidencia("Tocar no botão 'Quando' abrir calendario");
        tocarElemento(botaoQuandoCalendario, "Não foi possível tocar no botão 'Quando' abrir calendario'");
        return this;
    }

    /**
     * Tocar no botão 'Agendar Transação'
     *
     * @return PixTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Agendar Transação'")
    public ConfirmeOsDadosTela tocarBotaoAgendarTransacao() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoAgendarTransacao, "Não foi possível localizar no botão 'Agendar Transação'");
        salvarEvidencia("Tocar no botão 'Agendar Transação'");
        tocarElemento(botaoAgendarTransacao, "Não foi possível tocar no botão 'Agendar Transação'");
        return this;
    }

    /**
     * Tocar link 'Informações Adicionais'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão 'Informações Adicionais'")
    public ConfirmeOsDadosTela tocarInformacoesAdicionais() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(linkInformacoesAdicionais, "Não foi possível localizar o link 'Informações Adicionais'");
        salvarEvidencia("Tocar no link 'Informações Adicionais'");
        tocarElemento(linkInformacoesAdicionais, "Não foi possível tocar o link 'Informações Adicionais'");
        return this;
    }
}
