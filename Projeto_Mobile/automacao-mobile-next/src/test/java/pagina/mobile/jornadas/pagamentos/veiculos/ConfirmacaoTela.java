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
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"data do d�bito\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"data de d�bito\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"data de d�bito\"]")
    private MobileElement campoDataDebitoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"data do d�bito\"]/../*[@resource-id= \"br.com.bradesco.next:id/ntv_label_value\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"data de d�bito\"]/following-sibling::XCUIElementTypeStaticText")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"data de d�bito\"]/following-sibling::XCUIElementTypeStaticText")
    private MobileElement valorDataDebitoTabelaDadosDePagamento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[lower-case(@text) = \"dados do ve�culo\"]")
    @iOSXCUITFindBy(xpath = "//*[lower-case(@name) = \"dados do ve�culo\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"dados do ve�culo\"]")
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
     * Validar exibi��o do texto pagamento
     * @return
     */
    @Step("Validar exibi��o do texto pagamento")
    public ConfirmacaoTela validarExibicaoTextoPagamento(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(textoPagamento), MetodoComparacaoBooleano.VERDADEIRO, "O teste falhou: Texto Pagamento n�o foi carregado");
        salvarEvidencia("Validar exibi��o do campo pagamento");
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
        validarAtributoTexto(valorPagamento, valor, "O valor encontrado na tela � diferente do valor esperado");
        salvarEvidencia("Validar atributo valor");
        return this;
    }

    /**
     * Validar os campos tipo de pagamento e daata d�bito dos campos dados de pagamento
     * @param dicionarioDados
     * @return
     * @throws Exception
     */
    @Step("Validar os campos tipo de pagamento e daata d�bito dos campos dados de pagamento")
    public ConfirmacaoTela validarCamposDadosDePagamento(Map dicionarioDados) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoDataDebitoTabelaDadosDePagamento, "N�o foi poss�vel encontrar o campo data d�bito");
        MobileElement[] camposArray = {campoTipoPagamentoTabelaDadosDePagamento, campoDataDebitoTabelaDadosDePagamento};
        List<MobileElement> elementosCampo = Arrays.asList(camposArray);
        MobileElement[] valoresArray = {valorTipoPagamentoTabelaDadosDePagamento,valorDataDebitoTabelaDadosDePagamento};
        List<MobileElement> elementosValor = Arrays.asList(valoresArray);
        Map dicionarioDadosNormalizado = new HashMap();
        dicionarioDados.forEach((chave, valor)-> {
            if(ios){
                if(chave.equals("data do d�bito"))
                    dicionarioDadosNormalizado.put("data de d�bito", valor);
                if(chave.equals("tipo do d�bito"))
                    dicionarioDadosNormalizado.put("tipo de d�bito", valor);
            }
            else
                dicionarioDadosNormalizado.put(chave, valor);
        });
        validarCamposValor(elementosCampo, elementosValor, dicionarioDadosNormalizado);
        salvarEvidencia("Validar dados de pagamento");
        return this;
    }

    /**
     * Validar o campo renavam em dados do ve�culo
     * @param renavam
     * @return
     * @throws Exception
     */
    @Step("Validar o campo renavam em dados do ve�culo")
    public ConfirmacaoTela validarRenavamDoVeiculo(String renavam) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(valorRenavamTabelaDadosDoVeiculo, "N�o foi poss�vel encontrar o valor data d�bito");
        validarAtributoTexto(valorRenavamTabelaDadosDoVeiculo, renavam, "Erro ao validar o valor " + renavam + " no atributo texto do elemento");
        salvarEvidencia("Validar renavam do ve�culo");
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(valorValorTotalTabelaDadosDoTributo, "N�o foi poss�vel encontrar o valor do tributo");
        validarAtributoTexto(valorValorTotalTabelaDadosDoTributo, valor, "Erro ao validar o valor do tributo");
        salvarEvidencia("Validar o valor total do tributo");
        return this;
    }

    /**
     * M�todo criado para selecionar o tipo de conta para pagamento do renavam (Conta Corrente ou Conta Poupan�a)
     *
     * @return ConfirmacaoTela
     * @throws Exception
     */
    @Step("Selecionar o tipo de conta para efetuar o pagamento")
    public ConfirmacaoTela tocarTipoContaPagamento(String contaPagamento) throws Exception {
        By localizador = ios ? new By.ByXPath("//*[contains(lower-case(@label), " + contaPagamento + ")]") : new By.ByXPath("//*[contains(lower-case(@text), " + contaPagamento + ")]");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(localizador, "A " + contaPagamento + "n�o foi encontrada em tela");
        salvarEvidencia("Selecionar o tipo de conta para pagamento " + contaPagamento);
        tocarElemento(localizador, "Ocorreu um erro ao executar a a��o de selecionar o tipo de conta para pagamento");
        return this;
    }

    /**
     * Tocar bot�o Confirmar
     * @return
     */
    @Step("Tocar bot�o Confirmar")
    public ConfirmacaoTela tocarBotaoConfirmar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoConfirmar, "Erro ao rolar a tela at� elemento bot�o Confirmar ");
        salvarEvidencia("Tocar bot�o Confirmar");
        tocarElemento(botaoConfirmar, "Ocorreu um erro ao tocar no bot�o Confirmar");
        return this;
    }

    /**
     * M�todo armazena o valor do atributo texto da valor total da transa��o em vari�vel do teste
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("M�todo armazena o valor do atributo texto da valor total da transa��o em vari�vel do teste")
    public ConfirmacaoTela recuperarValorTotal(ThreadLocal valor) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoValorTotalDadosDoTributo, "N�o foi poss�vel encontrar o campo total");
        salvarEvidencia("Valor total da transa��o");
        valor.set(retornarTexto(campoValorTotalDadosDoTributo, "Ocorreu um erro ao tentar recuperar atributo texto do elemento referente ao valor total"));
        return this;
    }
}
