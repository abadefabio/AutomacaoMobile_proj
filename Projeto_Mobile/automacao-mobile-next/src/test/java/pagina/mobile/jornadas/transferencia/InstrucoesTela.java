package pagina.mobile.jornadas.transferencia;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.transferencia.MensagensEsperadas;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InstrucoesTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[$label == \"INSTRUÇÕES\"$]")
    private MobileElement tituloTelaInstrucoes;

    @AndroidFindBy(xpath = "//*[@content-desc=\"TED\"]")
    @iOSXCUITFindBy(accessibility = "TED")
    private MobileElement abaTED;

    @AndroidFindBy(xpath = "//*[@content-desc=\"DOC\"]")
    @iOSXCUITFindBy(accessibility = "DOC")
    private MobileElement abaDOC;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, \"Next\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[$label CONTAINS \"Next\"$]")
    private MobileElement abaNEXT;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoFechar;

    @AndroidFindBy(xpath = "//*[@text = \"SALDO NA CONTA CORRENTE\"]")
    @iOSXCUITFindBy(accessibility = "Saldo na conta corrente")
    private MobileElement campoSaldoContaCorrente;

    @AndroidFindBy(xpath = "//*[@text = \"SALDO NA CONTA POUPANÇA\"]")
    @iOSXCUITFindBy(accessibility = "Saldo na conta poupança")
    private MobileElement campoSaldoPoupanca;

    public InstrucoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar exibição campo "Saldo Conta Corrente"
     * @return InstrucoesTela
     */
    @Step("Validar exibição campo \"Saldo Conta Corrente\"")
    public InstrucoesTela validarExbicaoSaldoContaCorrente() throws Exception {
        if(android){
            compararElementoTexto(campoSaldoContaCorrente, MensagensEsperadas.CAMPO_SALDO_CONTA_CORRENTE_INSTRUCOES, MetodoComparacao.CONTEM);
        }else{
            compararElementoAtributo(campoSaldoContaCorrente,AtributoElemento.LABEL,MensagensEsperadas.CAMPO_SALDO_CONTA_CORRENTE_INSTRUCOES, MetodoComparacao.CONTEM);
        }
        OperadorEvidencia.logarPasso("Validar exibição campo \"Saldo Conta Corrente\"");
        return this;
    }

    /**
     * Validar exibição campo "Saldo Conta Poupança"
     * @return InstrucoesTela
     */
    @Step("Validar exibição campo \"Saldo Conta Poupança\"")
    public InstrucoesTela validarExbicaoSaldoPoupanca() throws Exception {
        aguardarCarregamentoElemento(campoSaldoPoupanca);
        if(android){
            compararElementoTexto(campoSaldoPoupanca, MensagensEsperadas.CAMPO_SALDO_POUPANCA_INSTRUCOES, MetodoComparacao.CONTEM);
        }else{
            compararElementoAtributo(campoSaldoPoupanca, AtributoElemento.LABEL,MensagensEsperadas.CAMPO_SALDO_POUPANCA_INSTRUCOES, MetodoComparacao.CONTEM);
        }
        OperadorEvidencia.logarPasso("Validar exibição campo \"Saldo Conta Poupança\"");
        return this;
    }

    /**
     * Validar exibição título tela "Instruções"
     * @return InstrucoesTela
     */
    @Step("Validar exibição título tela \"Instruções\"")
    public InstrucoesTela validarExbicaoTituloTela() throws Exception {
        if(android){
            aguardarCarregamentoElemento(tituloTelaInstrucoes);
            compararElementoTexto(tituloTelaInstrucoes, MensagensEsperadas.TITULO_TELA_TNSTRUCOES, MetodoComparacao.CONTEM);
        }else{
            if(!aguardarCarregamentoElemento(tituloTelaInstrucoes)){
                throw new AssertionError("Não foi possível verificar a exibição do título \"INSTRUÇÕES\"");
            }
        }
        OperadorEvidencia.logarPasso("Validar exibição título tela \"Instruções\"");
        return this;
    }

    /**
     * Validar exibição aba "TED"
     * @return InstrucoesTela
     */
    @Step("Validar exibição aba \"TED\"")
    public InstrucoesTela validarExibicaoAbaTED() throws Exception {
        if(aguardarCarregamentoElemento(abaTED)){
            OperadorEvidencia.logarPasso("Validar exibição aba \"TED\"");
        }else{
            throw new AssertionError("Não foi possível verificar a exibição da aba \"TED\" em tela");
        }
        return this;
    }

    /**
     * Validar exibição aba "DOC"
     * @return InstrucoesTela
     */
    @Step("Validar exibição aba \"DOC\"")
    public InstrucoesTela validarExbicaoAbaDOC() throws Exception {
        if(aguardarCarregamentoElemento(abaDOC)){
            OperadorEvidencia.logarPasso("Validar exibição aba \"DOC\"");
        }else{
            throw new AssertionError("Não foi possível verificar a exibição da aba \"DOC\" em tela");
        }
        return this;
    }

    /**
     * Validar exibição aba "NEXT e Bradesco"
     * @return InstrucoesTela
     */
    @Step("Validar exibição aba \"NEXT e Bradesco\"")
    public InstrucoesTela validarExbicaoAbaNEXT() throws Exception {
        if(aguardarCarregamentoElemento(abaNEXT)){
            OperadorEvidencia.logarPasso("Validar exibição aba \"NEXT e Bradesco\"");
            salvarEvidencia("Validar tela Instruções");
        }else{
            throw new AssertionError("Não foi possível verificar a exibição da aba \"NEXT e Bradesco\" em tela");
        }
        return this;
    }

    /**
     * Tocar botão "Fechar"
     * @return InstrucoesTela
     * @throws Exception
     */
    @Step("Tocar botão \"Fechar\"")
    public InstrucoesTela tocarBotaoFechar() throws Exception{
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "Erro ao tocar botão \"Fechar\"");
        salvarEvidencia("Tocar botão \"Fechar\"");
        return this;
    }
}
