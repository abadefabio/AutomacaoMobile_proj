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
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[$label == \"INSTRU��ES\"$]")
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

    @AndroidFindBy(xpath = "//*[@text = \"SALDO NA CONTA POUPAN�A\"]")
    @iOSXCUITFindBy(accessibility = "Saldo na conta poupan�a")
    private MobileElement campoSaldoPoupanca;

    public InstrucoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar exibi��o campo "Saldo Conta Corrente"
     * @return InstrucoesTela
     */
    @Step("Validar exibi��o campo \"Saldo Conta Corrente\"")
    public InstrucoesTela validarExbicaoSaldoContaCorrente() throws Exception {
        if(android){
            compararElementoTexto(campoSaldoContaCorrente, MensagensEsperadas.CAMPO_SALDO_CONTA_CORRENTE_INSTRUCOES, MetodoComparacao.CONTEM);
        }else{
            compararElementoAtributo(campoSaldoContaCorrente,AtributoElemento.LABEL,MensagensEsperadas.CAMPO_SALDO_CONTA_CORRENTE_INSTRUCOES, MetodoComparacao.CONTEM);
        }
        OperadorEvidencia.logarPasso("Validar exibi��o campo \"Saldo Conta Corrente\"");
        return this;
    }

    /**
     * Validar exibi��o campo "Saldo Conta Poupan�a"
     * @return InstrucoesTela
     */
    @Step("Validar exibi��o campo \"Saldo Conta Poupan�a\"")
    public InstrucoesTela validarExbicaoSaldoPoupanca() throws Exception {
        aguardarCarregamentoElemento(campoSaldoPoupanca);
        if(android){
            compararElementoTexto(campoSaldoPoupanca, MensagensEsperadas.CAMPO_SALDO_POUPANCA_INSTRUCOES, MetodoComparacao.CONTEM);
        }else{
            compararElementoAtributo(campoSaldoPoupanca, AtributoElemento.LABEL,MensagensEsperadas.CAMPO_SALDO_POUPANCA_INSTRUCOES, MetodoComparacao.CONTEM);
        }
        OperadorEvidencia.logarPasso("Validar exibi��o campo \"Saldo Conta Poupan�a\"");
        return this;
    }

    /**
     * Validar exibi��o t�tulo tela "Instru��es"
     * @return InstrucoesTela
     */
    @Step("Validar exibi��o t�tulo tela \"Instru��es\"")
    public InstrucoesTela validarExbicaoTituloTela() throws Exception {
        if(android){
            aguardarCarregamentoElemento(tituloTelaInstrucoes);
            compararElementoTexto(tituloTelaInstrucoes, MensagensEsperadas.TITULO_TELA_TNSTRUCOES, MetodoComparacao.CONTEM);
        }else{
            if(!aguardarCarregamentoElemento(tituloTelaInstrucoes)){
                throw new AssertionError("N�o foi poss�vel verificar a exibi��o do t�tulo \"INSTRU��ES\"");
            }
        }
        OperadorEvidencia.logarPasso("Validar exibi��o t�tulo tela \"Instru��es\"");
        return this;
    }

    /**
     * Validar exibi��o aba "TED"
     * @return InstrucoesTela
     */
    @Step("Validar exibi��o aba \"TED\"")
    public InstrucoesTela validarExibicaoAbaTED() throws Exception {
        if(aguardarCarregamentoElemento(abaTED)){
            OperadorEvidencia.logarPasso("Validar exibi��o aba \"TED\"");
        }else{
            throw new AssertionError("N�o foi poss�vel verificar a exibi��o da aba \"TED\" em tela");
        }
        return this;
    }

    /**
     * Validar exibi��o aba "DOC"
     * @return InstrucoesTela
     */
    @Step("Validar exibi��o aba \"DOC\"")
    public InstrucoesTela validarExbicaoAbaDOC() throws Exception {
        if(aguardarCarregamentoElemento(abaDOC)){
            OperadorEvidencia.logarPasso("Validar exibi��o aba \"DOC\"");
        }else{
            throw new AssertionError("N�o foi poss�vel verificar a exibi��o da aba \"DOC\" em tela");
        }
        return this;
    }

    /**
     * Validar exibi��o aba "NEXT e Bradesco"
     * @return InstrucoesTela
     */
    @Step("Validar exibi��o aba \"NEXT e Bradesco\"")
    public InstrucoesTela validarExbicaoAbaNEXT() throws Exception {
        if(aguardarCarregamentoElemento(abaNEXT)){
            OperadorEvidencia.logarPasso("Validar exibi��o aba \"NEXT e Bradesco\"");
            salvarEvidencia("Validar tela Instru��es");
        }else{
            throw new AssertionError("N�o foi poss�vel verificar a exibi��o da aba \"NEXT e Bradesco\" em tela");
        }
        return this;
    }

    /**
     * Tocar bot�o "Fechar"
     * @return InstrucoesTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Fechar\"")
    public InstrucoesTela tocarBotaoFechar() throws Exception{
        aguardarCarregamentoElemento(botaoFechar);
        tocarElemento(botaoFechar, "Erro ao tocar bot�o \"Fechar\"");
        salvarEvidencia("Tocar bot�o \"Fechar\"");
        return this;
    }
}
