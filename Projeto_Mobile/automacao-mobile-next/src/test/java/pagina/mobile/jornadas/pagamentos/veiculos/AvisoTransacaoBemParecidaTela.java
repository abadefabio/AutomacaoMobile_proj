package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AvisoTransacaoBemParecidaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id ="br.com.bradesco.next:id/text_vehicle_payment_duplicate")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"A gente reparou que voc� fez uma transa��o bem parecida a essa. Tem certeza de que quer continuar?\"])[1]")
    private MobileElement textoAGenteReparouQueVoceFezUmaTransacaoBemParecidaAEstaTemCertezaDeQueQuerContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"tipo do pagamento\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"tipo de pagamento\"]")
    private MobileElement campoTipoPagamentoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"tipo do pagamento\"]/../*[@resource-id= \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"tipo de pagamento\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement valorTipoPagamentoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"Exerc�cio\"]/../*[@resource-id= \"br.com.bradesco.next:id/tv_description\"]")
    @iOSXCUITFindBy(accessibility = "Exerc�cio")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Exerc�cio\"]")
    private MobileElement campoExercicioTabelaDadosPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"Exerc�cio\"]/../*[@resource-id= \"br.com.bradesco.next:id/tv_description\"]")
    @iOSXCUITFindBy(xpath ="//*[@name= \"Exerc�cio\"]/../XCUIElementTypeStaticText[not(contains(@name, \"Exerc�cio\"))]")
    private MobileElement valorExercicioTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Data de d�bito")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Data de d�bito\"]")
    @AndroidFindBy(accessibility ="Data do d�bito")
    private MobileElement campoDataDeDebitoTabelaDadosPagamento;


    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"Data de d�bito\"]/../*[@resource-id= \"br.com.bradesco.next:id/tv_description\"]")
    @iOSXCUITFindBy(xpath ="//*[@name= \"Data de d�bito\"]/../XCUIElementTypeStaticText[not(contains(@name, \"Data\"))]")
    private MobileElement valorDataDeDebitoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Renavam")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Renavam\"]")
    @AndroidFindBy(accessibility ="Renavam")
    private MobileElement campoRenavamTabelaDadosPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"Renavam\"]/../*[@resource-id= \"br.com.bradesco.next:id/tv_description\"]")
    @iOSXCUITFindBy(xpath ="//*[@name= \"Renavam\"]/../XCUIElementTypeStaticText[not(contains(@name, \"Renavam\"))]")
    private MobileElement valorRenavamTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Placa do ve�culo")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Placa do ve�culo\"]")
    @AndroidFindBy(accessibility ="Placa do Ve�culo")
    private MobileElement campoPlacaDoVeiculoTabelaDadosPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"Placa do ve�culo\"]/../*[@resource-id= \"br.com.bradesco.next:id/tv_description\"]")
    @iOSXCUITFindBy(xpath ="//*[@name= \"Placa do ve�culo\"]/../XCUIElementTypeStaticText[not(contains(@name, \"Placa\"))]")
    private MobileElement valorPlacaDoVeiculoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Valor Total")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Valor Total\"]")
    @AndroidFindBy(accessibility ="Valor total")
    private MobileElement campoValorTotalTabelaDadosPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"Valor Total\"]/../*[@resource-id= \"br.com.bradesco.next:id/tv_description\"]")
    @iOSXCUITFindBy(xpath ="//*[@name= \"Valor Total\"]/../XCUIElementTypeStaticText[not(contains(@name, \"Valor\"))]")
    private MobileElement valorValorTotalTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility ="Continuar")
    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton[@name=\"Continuar\"]")
    @AndroidFindBy(id ="br.com.bradesco.next:id/bt_continue_payment")
    private MobileElement botaoContinuar;

    public AvisoTransacaoBemParecidaTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Validar texto A Gente Reparou Que Voce Fez Uma Transacao Bem Parecida A Esta Tem Certeza De Que Quer Continuar
     * @return
     */
    @Step("Validar exibi��o do texto A Gente Reparou Que Voce Fez Uma Transacao Bem Parecida A Esta Tem Certeza De Que Quer Continuar")
    public AvisoTransacaoBemParecidaTela validarTextoAgenteReparouQueVoceFezUmaTransacaoBemParecidaAEstaTemCertezaDeQueQuerContinuar(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoAGenteReparouQueVoceFezUmaTransacaoBemParecidaAEstaTemCertezaDeQueQuerContinuar), MetodoComparacaoBooleano.VERDADEIRO, "Texto A Gente Reparou Que Voce Fez Uma Transacao Bem Parecida A Esta Tem Certeza De Que Quer Continuar n�o est� presente na tela!");
        salvarEvidencia("Validar exibi��o do texto A Gente Reparou Que Voce Fez Uma Transacao Bem Parecida A Esta Tem Certeza De Que Quer Continuar");
        return this;
    }

    /**
     * Verificar se mensagem de transa��o repetida feito est� presente na tela
     * @return
     */
    @Step("Verificar se mensagem de transa��o repetida feito est� presente na tela")
    public boolean mensagemTransacaoRepetidaPresente() {
        return aguardarCarregamentoElemento(textoAGenteReparouQueVoceFezUmaTransacaoBemParecidaAEstaTemCertezaDeQueQuerContinuar);
    }

    /**
     * Validar os campos tipo de pagamento, Exercicio, Data de Debito, Renavam, Placa do Veiculo, Valor Total
     * @param dicionarioDados
     * @return
     * @throws Exception
     */
    @Step("Validar os campos tipo de pagamento, Exercicio, Data de Debito, Renavam, Placa do Veiculo, Valor Total")
    public AvisoTransacaoBemParecidaTela validarCamposDadosDePagamento(Map dicionarioDados) throws Exception {
        MobileElement[] camposArray = {campoTipoPagamentoTabelaDadosDePagamento,campoExercicioTabelaDadosPagamento,campoDataDeDebitoTabelaDadosPagamento,campoRenavamTabelaDadosPagamento,campoPlacaDoVeiculoTabelaDadosPagamento,campoValorTotalTabelaDadosPagamento};
        List<MobileElement> elementosCampo = Arrays.asList(camposArray);
        MobileElement[] valoresArray = {valorTipoPagamentoTabelaDadosDePagamento,valorExercicioTabelaDadosDePagamento,valorDataDeDebitoTabelaDadosDePagamento,valorRenavamTabelaDadosDePagamento,valorPlacaDoVeiculoTabelaDadosDePagamento,valorValorTotalTabelaDadosDePagamento};
        List<MobileElement> elementosValor = Arrays.asList(valoresArray);
        validarCamposValor(elementosCampo, elementosValor, dicionarioDados);
        salvarEvidencia("Validar dados de pagamento");
        return this;
    }

    /**
     * Tocar bot�o Continuar
     * @return
     */
    @Step("Tocar bot�o Continuar")
    public AvisoTransacaoBemParecidaTela tocarBotaoContinuar() throws Exception {
        salvarEvidencia("Tocar bot�o Continuar");
        tocarElemento(botaoContinuar, "Ocorreu um erro ao tocar no bot�o Continuar");
        return this;
    }
}
