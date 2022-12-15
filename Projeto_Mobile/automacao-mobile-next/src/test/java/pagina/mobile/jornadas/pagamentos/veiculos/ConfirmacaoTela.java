package pagina.mobile.jornadas.pagamentos.veiculos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmacaoTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_payment_typev")
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"pagamento\"]")
    @iOSXCUITFindBy(accessibility = "Pagamento")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@label) = \"pagamento\"]")
    private MobileElement textoPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_payment_value")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@label) = \"pagamento\"]/../*[contains(@name, \"R$\")]")
    @iOSXCUITFindBy(xpath = "//*[translate(@label, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"pagamento\"]/../*[contains(@name, \"R$\")]")
    private MobileElement valorPagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"dados de pagamento\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@text) = \"dados do pagamento\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"dados do pagamento\"]")
    private MobileElement tituloTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"tipo do pagamento\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"tipo de pagamento\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"tipo de pagamento\"]")
    private MobileElement campoTipoPagamentoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"tipo do pagamento\"]/../*[@resource-id= \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"tipo de pagamento\"]/following-sibling::XCUIElementTypeStaticText")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"tipo de pagamento\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement valorTipoPagamentoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"data do débito\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"data de débito\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"data de débito\"]")
    private MobileElement campoDataDebitoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"data do débito\"]/../*[@resource-id= \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"data de débito\"]/following-sibling::XCUIElementTypeStaticText")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"data de débito\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement valorDataDebitoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"dados do veículo\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"dados do veículo\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"dados do veículo\"]")
    private MobileElement tituloTabelaDadosDoVeiculo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"renavam\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"renavam\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"renavam\"]")
    private MobileElement campoRenavamTabelaDadosDoVeiculo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"renavam\"]/../*[@resource-id= \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"renavam\"]/following-sibling::XCUIElementTypeStaticText")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"renavam\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement valorRenavamTabelaDadosDoVeiculo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"dados do tributo\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"dados do tributo\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"dados do tributo\"]")
    private MobileElement tituloTabelaDadosDoTributo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"valor total\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"valor total\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"valor total\"]")
    private MobileElement campoValorTotalDadosDoTributo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"valor total\"]/../*[@resource-id = \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"valor total\"]/following-sibling::XCUIElementTypeStaticText")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"valor total\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement valorValorTotalTabelaDadosDoTributo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirmation")
    @iOSXCUITFindBy(id = "//*[lower-case(@name) = \"confirmar\"]")
    @iOSXCUITFindBy(id = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz')  = \"confirmar\"]")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    public ConfirmacaoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Validar exibição do texto pagamento
     * @return
     */
    @Step("Validar exibição do texto pagamento")
    public ConfirmacaoTela validarExibicaoTextoPagamento(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoPagamento), MetodoComparacaoBooleano.VERDADEIRO, "O teste falhou: Texto Pagamento não foi carregado");
        salvarEvidencia("Validar exibição do campo pagamento");
        return this;
    }

    /**
     * Validar valor pagamento
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Validar valor pagamento")
    public ConfirmacaoTela validarValorPagamento(String valor) throws Exception {
        validarAtributoTexto(valorPagamento, valor, "O valor encontrado na tela é diferente do valor esperado");
        salvarEvidencia("Validar atributo valor");
        return this;
    }

    /**
     * Validar os campos tipo de pagamento e daata débito dos campos dados de pagamento
     * @param dicionarioDados
     * @return
     * @throws Exception
     */
    @Step("Validar os campos tipo de pagamento e daata débito dos campos dados de pagamento")
    public ConfirmacaoTela validarCamposDadosDePagamento(Map dicionarioDados) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoDataDebitoTabelaDadosDePagamento, "Não foi possível encontrar o campo data débito");
        MobileElement[] camposArray = {campoTipoPagamentoTabelaDadosDePagamento, campoDataDebitoTabelaDadosDePagamento};
        List<MobileElement> elementosCampo = Arrays.asList(camposArray);
        MobileElement[] valoresArray = {valorTipoPagamentoTabelaDadosDePagamento,valorDataDebitoTabelaDadosDePagamento};
        List<MobileElement> elementosValor = Arrays.asList(valoresArray);
        Map dicionarioDadosNormalizado = new HashMap();
        dicionarioDados.forEach((chave, valor)-> {
            if(ios){
                if(chave.equals("data do débito"))
                    dicionarioDadosNormalizado.put("data de débito", valor);
                if(chave.equals("tipo do débito"))
                    dicionarioDadosNormalizado.put("tipo de débito", valor);
            }
            else
                dicionarioDadosNormalizado.put(chave, valor);
        });
        validarCamposValor(elementosCampo, elementosValor, dicionarioDadosNormalizado);
        salvarEvidencia("Validar dados de pagamento");
        return this;
    }

    /**
     * Validar o campo renavam em dados do veículo
     * @param renavam
     * @return
     * @throws Exception
     */
    @Step("Validar o campo renavam em dados do veículo")
    public ConfirmacaoTela validarRenavamDoVeiculo(String renavam) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(valorRenavamTabelaDadosDoVeiculo, "Não foi possível encontrar o valor data débito");
        validarAtributoTexto(valorRenavamTabelaDadosDoVeiculo, renavam, "Erro ao validar o valor " + renavam + " no atributo texto do elemento");
        salvarEvidencia("Validar renavam do veículo");
        return this;
    }

    /**
     * Validar o campo valor total do tributo
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Validar o campo valor total do tributo")
    public ConfirmacaoTela validarValorTotal(String valor) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(valorValorTotalTabelaDadosDoTributo, "Não foi possível encontrar o valor do tributo");
        validarAtributoTexto(valorValorTotalTabelaDadosDoTributo, valor, "Erro ao validar o valor do tributo");
        salvarEvidencia("Validar o valor total do tributo");
        return this;
    }

    /**
     * Método criado para selecionar o tipo de conta para pagamento do renavam (Conta Corrente ou Conta Poupança)
     *
     * @return ConfirmacaoTela
     * @throws Exception
     */
    @Step("Selecionar o tipo de conta para efetuar o pagamento")
    public ConfirmacaoTela tocarTipoContaPagamento(String contaPagamento) throws Exception {
        By localizador = ios ? new By.ByXPath("//*[contains(lower-case(@label), " + contaPagamento + ")]") : new By.ByXPath("//*[contains(lower-case(@text), " + contaPagamento + ")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "A " + contaPagamento + "não foi encontrada em tela");
        salvarEvidencia("Selecionar o tipo de conta para pagamento " + contaPagamento);
        tocarElemento(localizador, "Ocorreu um erro ao executar a ação de selecionar o tipo de conta para pagamento");
        return this;
    }

    /**
     * Tocar botão Confirmar
     * @return
     */
    @Step("Tocar botão Confirmar")
    public ConfirmacaoTela tocarBotaoConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar, "Erro ao rolar a tela até elemento botão Confirmar ");
        salvarEvidencia("Tocar botão Confirmar");
        tocarElemento(botaoConfirmar, "Ocorreu um erro ao tocar no botão Confirmar");
        return this;
    }

    /**
     * Método armazena o valor do atributo texto da valor total da transação em variável do teste
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Método armazena o valor do atributo texto da valor total da transação em variável do teste")
    public ConfirmacaoTela recuperarValorTotal(ThreadLocal valor) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoValorTotalDadosDoTributo, "Não foi possível encontrar o campo total");
        salvarEvidencia("Valor total da transação");
        valor.set(retornarTexto(campoValorTotalDadosDoTributo, "Ocorreu um erro ao tentar recuperar atributo texto do elemento referente ao valor total"));
        return this;
    }
}
