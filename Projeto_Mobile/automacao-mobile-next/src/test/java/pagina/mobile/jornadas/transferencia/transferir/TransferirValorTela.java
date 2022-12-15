package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.transferencia.MensagemValidacaoCamposTranferir;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.concurrent.Callable;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

public class TransferirValorTela extends PaginaBase {

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    public TransferirValorTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Armazena valor informado no objeto thread-safe valorTransferencia
     * @param vvalor
     */
    public static void setValorTransferencia(String vvalor){
        valor.set(vvalor);
    }

    /**
     * retorna string com o valor de ag�ncia armazenado no objeto thread-safe valorTransferencia
     * @return valor
     */
    public static String retornaValorTransferencia(){
        return  valor.get();
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoFechar;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[1]")
    private MobileElement numeroPaginaAtual;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeStaticText[@visible=\"true\"])[2]")
    private MobileElement descricaoPagina;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='br.com.bradesco.next:id/et_qnt']")
    @AndroidBy(id = "br.com.bradesco.next:id/et_qnt")
    @AndroidFindBy(xpath = "//*[@text=\"R$0,00\"]")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='br.com.bradesco.next:id/et_qnt']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"TRANSFERIR\"]/../XCUIElementTypeOther//XCUIElementTypeTextField")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH \"R$\" AND visible == true")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"R$  0,00\"`]")
    private MobileElement valorTransferencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_msg_error_one")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-warning\"]/following::XCUIElementTypeStaticText")
    private MobileElement msgValidacaoCampoValor;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "*//android.widget.Button[@text=\"Continuar\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continuar\"]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @AndroidBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Continuar\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/bt_continue']")
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton['label == \"Pr�ximo\"']")
    @iOSXCUITFindBy(iOSNsPredicate = "'label == \"Pr�ximo\" AND type == \"XCUIElementTypeButton\"'")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Pr�ximo\"]")
    private MobileElement botaoProximo;

    /**
     * Tocar bot�o "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o fechar (X)")
    public TransferirValorTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no bot�o fechar (X)" );
        tocarElemento( botaoFechar, "Nao foi possivel tocar no bot�o fechar" );
        return this;
    }

    /**
     * Preencher campo "Valor Transfer�ncia"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valor Transfer�ncia\"")
    public TransferirValorTela preencherValorTransferencia() throws Exception {
        String valor = String.valueOf(numeroAleatorio(100,5000)); // 100..5000 -> 1,00 at� 50,00
        setValorTransferencia(valor);
        return preencherValorTransferencia(valor);
    }

    /**
     * Preencher campo "Valor Transfer�ncia"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valor Transfer�ncia\"")
    public TransferirValorTela preencherValorTransferencia(String valor) throws Exception {
        preencherValorTransferencia(valor, () -> null);
        return this;
    }

    /**
     * Preencher campo "Valor Transfer�ncia" chamando uma fun��o ap�s escrever valor e antes de esconder teclado
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valor Transfer�ncia\"")
    public TransferirValorTela preencherValorTransferencia(String valor, Callable<Boolean> funcao) throws Exception {
        setValorTransferencia(valor);
        aguardarCarregamentoElemento(valorTransferencia);
        if (ios) {
            valorTransferencia.sendKeys(valor);
        } else {
            escreverTexto(valorTransferencia, valor, "Erro ao preencher valor transfer�ncia");
        }
        salvarEvidencia("Preencher valor transfer�ncia com " + retornaValorTransferencia());
        funcao.call();
        esconderTeclado();
        return this;
    }

    /**
     * Tocar bot�o "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TransferirValorTela tocarBotaoContinuar() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "Erro ao tocar bot�o \"Continuar\"");
        salvarEvidencia("Tocar bot�o \"Continuar\"");
        return this;
    }

    /**
     * Tocar bot�o "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Pr�ximo\"")
    public TransferirValorTela tocarBotaoProximo() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        esconderTeclado();
        tocarElemento(botaoContinuar, "Erro ao tocar bot�o \"Continuar\"");
        salvarEvidencia("Tocar bot�o \"Continuar\"");
        return this;
    }

    /**
     * validar label : 'Se voc� continuar com essa transfer�ncia, vai usar a grana de emerg�ncia ok?'
     * @return
     * @throws Exception
     */
    public TransferirValorTela validarLabelDeUsoGranaDeEmergencia() throws Exception {
        By labelUsoDeGranaDeEmergencia;
        if(ios) {
            labelUsoDeGranaDeEmergencia = new MobileBy.ByXPath("//XCUIElementTypeStaticText[contains(@name,\"Se voc� continuar com essa transfer�ncia\")]");
        }
        else {
            labelUsoDeGranaDeEmergencia = new By.ById("br.com.bradesco.next:id/ctv_msg_error_two");
        }
        if (android) {
            esconderTeclado();
        }
        validarCondicaoBooleana(verificarPresencaElemento(labelUsoDeGranaDeEmergencia), MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a mensagem Voc� n�o tem grana suficiente pra essa transfer�ncia");
        salvarEvidencia("Validou a label sem saldo 'Se voc� continuar com essa transfer�ncia, vai usar a grana de emerg�ncia ok?'");
        return this;
    }
     /**
     * Validar label na tela: "Voc� n�o tem grana suficiente pra essa transfer�ncia". Seu saldo � de R$ XX,XX
     *
     * @return
     * @throws Exception
     */
    @Step("Validar label sem saldo: 'Voc� n�o tem grana suficiente pra essa transfer�ncia'")
    public TransferirValorTela validarLabelSemSaldoParaTranferencia() throws Exception {
        By labelSemSaldo;
        if(ios) {
            labelSemSaldo = new MobileBy.ByXPath("//XCUIElementTypeStaticText[contains(@name,\"Voc� n�o tem grana\")]");
        }
        else {
            labelSemSaldo = new By.ById("br.com.bradesco.next:id/ctv_msg_error_one");
        }
        validarCondicaoBooleana(verificarPresencaElemento(labelSemSaldo), MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a mensagem Voc� n�o tem grana suficiente pra essa transfer�ncia");
        salvarEvidencia("Validou a label sem saldo 'Voc� n�o tem grana suficiente pra essa transfer�ncia'");
        return this;
    }

    /**
     * Valida a label de valida��o do campo de valor
     *
     * @return
     * @throws Exception
     */
    @Step("Validar a label de valida��o do campo de valor")
    public TransferirValorTela validarLabelValidacaoCampoValor(MensagemValidacaoCamposTranferir mensagemValidacaoCamposTranferir) throws Exception {
        aguardarCarregamentoElemento(msgValidacaoCampoValor);
        salvarEvidencia("Validado mensagem de valida��o: " + mensagemValidacaoCamposTranferir.toString() + "do campo de valor");
        validarAtributoTexto(msgValidacaoCampoValor, mensagemValidacaoCamposTranferir.MENSAGEM_VALOR_ACIMA_LIMITE.toString(), "N�o poss�vel validar o texto: " + mensagemValidacaoCamposTranferir.MENSAGEM_VALOR_ACIMA_LIMITE);
        return this;
    }

    /**
     * Apaga o valor do campo de valor
     *
     * @return
     * @throws Exception
     */
    @Step("Apagar o valor do campo de valor")
    public TransferirValorTela apagarValorCampoValor() throws Exception{
        aguardarCarregamentoElemento(valorTransferencia);
        salvarEvidencia("Apagado valor do campo Valor");
        apagarCampoTexto(valorTransferencia, "N�o foi poss�vel apagar o valor do campo Valor");
        return this;
    }
}
