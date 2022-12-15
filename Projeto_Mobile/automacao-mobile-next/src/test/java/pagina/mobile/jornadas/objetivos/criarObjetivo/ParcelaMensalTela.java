package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ParcelaMensalTela extends PaginaBase {

    public static ThreadLocal<String> valor = new ThreadLocal<String>();

    public ParcelaMensalTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Armazena valor informado no objeto thread-safe valorObjetivo
     * @param vvalor
     */
    public static void setValorObjetivo(String vvalor){
        valor.set(vvalor);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_goal_suggestion")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"icon edit\"]/..//XCUIElementTypeTextField")
    private MobileElement campoValorParcela;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_suggestion")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, \"Continuar\")]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Continuar\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"Continuar\")]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_msg_alert")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'O valor mínimo da parcela')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'O valor mínimo da parcela')]")
    private MobileElement valorMinimoParcela;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_msg_alert")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'A parcela não pode ultrapassar a meta')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'A parcela não pode ultrapassar a meta')]")
    private MobileElement valorAcimaDaMeta;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_msg_alert")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'A parcela pode comprometer seu')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'A parcela pode comprometer seu')]")
    private MobileElement valorComprometeOrcamento;

    @iOSXCUITFindBy(accessibility = "PARCELAS MENSAIS")
    private MobileElement textoParcelasMensais;

    /**
     * Preencher valor da parcela do objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo 'Valor' da parcela do objetivo")
    public ParcelaMensalTela preencherValorParcelaMensal(String valor) throws Exception {
        aguardarCarregamentoElemento(campoValorParcela);
        if(ios) tocarCoordenadaProporcional(campoValorParcela,50,95);
        apagarCampoTexto(campoValorParcela, "Não foi possivel apagar o valor no campo parcela");
        escreverTexto(campoValorParcela, valor, "Erro ao preencher Valor da parcela do objetivo.");
        salvarEvidencia("Preencher valor da parcela do objetivo: " + valor);
        return this;
    }

    /**
     * Tocar botao 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao 'Continuar'")
    public ParcelaMensalTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Clicar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Erro ao clicar botao 'Continuar'");
        return this;
    }

    /**
     * Validar texto 'O valor mínimo da parcela é R$ 50,00'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto 'O valor mínimo da parcela é R$ 50,00'")
    public ParcelaMensalTela validarValorMininoParcelaMensal() throws Exception{
        if (!verificarPresencaElemento(valorMinimoParcela)){
            tocarElemento(textoParcelasMensais, "Erro ao esconder teclado, clicando no elemento referente ao texto 'Parcelas Mensais'");
        }
        validarCondicaoBooleana(verificarPresencaElemento(valorMinimoParcela), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar texto 'O valor mínimo da parcela é R$ 50,00'");
        salvarEvidencia("Validado texto 'O valor mínimo da parcela é R$ 50,00'");
        return this;
    }

    /**
     * Validar texto 'A parcela não pode ultrapassar a meta'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto 'A parcela não pode ultrapassar a meta'")
    public ParcelaMensalTela validarValorAcimaMetaParcelaMensal() throws Exception{
        if (!verificarPresencaElemento(valorAcimaDaMeta)){
            tocarElemento(textoParcelasMensais, "Erro ao esconder teclado, clicando no elemento referente ao texto 'Parcelas Mensais'");
        }
        validarCondicaoBooleana(verificarPresencaElemento(valorAcimaDaMeta), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar texto 'A parcela não pode ultrapassar a meta'");
        salvarEvidencia("Validado texto 'A parcela não pode ultrapassar a meta'");
        return this;
    }

    /**
     * Validar texto 'A parcela pode comprometer seu orçamento'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Texto 'A parcela pode comprometer seu orçamento'")
    public ParcelaMensalTela validarValorQueComprometeOrcamento() throws Exception{
        if (!verificarPresencaElemento(valorComprometeOrcamento)){
            tocarElemento(textoParcelasMensais, "Erro ao esconder teclado, clicando no elemento referente ao texto 'Parcelas Mensais'");
        }
        validarCondicaoBooleana(verificarPresencaElemento(valorComprometeOrcamento), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar texto 'A parcela pode comprometer seu orçamento\n'");
        salvarEvidencia("Validado texto 'A parcela pode comprometer seu orçamento'");
        return this;
    }
}
