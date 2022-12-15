package pagina.mobile.jornadas.credito.emprestimo.contratacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.Direcao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import framework.AcoesGerais;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class SimularCreditoTela extends PaginaBase {

    public SimularCreditoTela(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "icon edit medium")
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_edit")
    private MobileElement botaoEditarValor;

    @iOSXCUITFindBy(accessibility = "icon close rounded")
    private MobileElement botaoApagar;

    @iOSXCUITFindBy(accessibility = "Campo editável. Valor atual 0.0")
    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id='br.com.bradesco.next:id/tv_current_value'])[1]")
    private MobileElement textoCampoValor;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name, 'Campo editável. Valor atual')][2]/following-sibling::XCUIElementTypeSlider[1]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSlider[`value == \"100%\"`]")
    @AndroidFindBy(xpath = "//android.widget.SeekBar[@content-desc=\"%d vezes\"]")
    private MobileElement slideQtdeParcelas;

    @iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Calcular\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_calculate")
    private MobileElement botaoCalcular;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Continuar\"])[1]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id='br.com.bradesco.next:id/ntv_continue'])[1]")
    @AndroidFindBy(xpath = "//*[@text='Continuar']")
    private MobileElement botaoContinuar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_amount")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Taxa de 2,40% a.m\"])[1]")
    private MobileElement valorMensal;


    /**
     * Tocar botão Editar Valor 'icone Lapis'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão Editar Valor 'icone Lapis'")
    public SimularCreditoTela tocarBotaoEditarValor() throws Exception {
        salvarEvidencia("Tocar botão Editar Valor 'icone Lapis'");
        tocarElemento(botaoEditarValor, "Não foi possível tocar botão Editar Valor 'icone Lapis'");
        return this;
    }

    /**
     * Preencher campo 'Valor'
     *
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Preencher campo 'Valor'")
    public SimularCreditoTela preencherCampoValor(String valor) throws Exception {
        aguardarCarregamentoElemento(textoCampoValor);
        if (ios) tocarBotaoApagarvalor();
        escreverTexto(textoCampoValor, valor, "Não foi possível preencher o campo 'Valor' com: " + valor);
        esconderTeclado();
        salvarEvidencia("Preenchido campo 'Valor' com: " + valor);
        return this;
    }

    /** Tocar botão 'Apagar Texto'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Apagar Texto'")
    private SimularCreditoTela tocarBotaoApagarvalor() throws Exception {
        salvarEvidencia("Tocar botão 'Apagar Texto'");
        tocarElemento(botaoApagar,"Não foi possível tocar botão 'Apagar Texto'");
        return this;
    }

    /**
     * Arrastar Elemento Quantidade de Parcelas
     *
     * @return
     * @throws Exception
     */
    @Step("Arrastar Elemento Quantidade de Parcelas")
    public SimularCreditoTela arrastarSlideQtdeVezes() throws NextException {
        aguardarCarregamentoElemento(slideQtdeParcelas);
        if (android){
            tocarCoordenadaProporcional(slideQtdeParcelas,6,50);
        }else {
            new AcoesGerais((AppiumDriver) driver)
                    .deslizar(slideQtdeParcelas, Direcao.ESQUERDA, 6, 90);
        }
        salvarEvidencia("Arrastar Elemento Quantidade de Parcelas");
        return this;
    }

    /**
     * Tocar botão 'Calcular'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Calcular'")
    public SimularCreditoTela tocarBotaoCalcular() throws Exception {
        esconderTeclado();
        salvarEvidencia("Tocar botão 'Calcular'");
        tocarElemento(botaoCalcular, "Não foi possível tocar botao 'Calcular'");
        return this;
    }

    /**
     * Tocar botão 'Continuar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public SimularCreditoTela tocarBotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar botao 'Continuar'");
        return this;
    }


    /**
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Validar valor mensal")
    public SimularCreditoTela validarValorMensalSimulacao(String valor) throws Exception {

        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(valorMensal,"Nao foi possivel encontrar elemento 'Continuar'");
        if (android)        validarCondicaoBooleana(retornarTexto(valorMensal,"Nao foi possivel encontrar elemento").contains(valor), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar o valor mensal: "+valor);
        else verificarPresencaElemento(valorMensal);
        salvarEvidencia("Validar valor mensal");
        return this;
    }
}
