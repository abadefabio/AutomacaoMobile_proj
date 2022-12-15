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
     * retorna string com o valor de agência armazenado no objeto thread-safe valorTransferencia
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
    @iOSXCUITFindBy(iOSClassChain = "//**/XCUIElementTypeButton['label == \"Próximo\"']")
    @iOSXCUITFindBy(iOSNsPredicate = "'label == \"Próximo\" AND type == \"XCUIElementTypeButton\"'")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Próximo\"]")
    private MobileElement botaoProximo;

    /**
     * Tocar botão "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferirValorTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia( "Tocar no botão fechar (X)" );
        tocarElemento( botaoFechar, "Nao foi possivel tocar no botão fechar" );
        return this;
    }

    /**
     * Preencher campo "Valor Transferência"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valor Transferência\"")
    public TransferirValorTela preencherValorTransferencia() throws Exception {
        String valor = String.valueOf(numeroAleatorio(100,5000)); // 100..5000 -> 1,00 até 50,00
        setValorTransferencia(valor);
        return preencherValorTransferencia(valor);
    }

    /**
     * Preencher campo "Valor Transferência"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valor Transferência\"")
    public TransferirValorTela preencherValorTransferencia(String valor) throws Exception {
        preencherValorTransferencia(valor, () -> null);
        return this;
    }

    /**
     * Preencher campo "Valor Transferência" chamando uma função após escrever valor e antes de esconder teclado
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valor Transferência\"")
    public TransferirValorTela preencherValorTransferencia(String valor, Callable<Boolean> funcao) throws Exception {
        setValorTransferencia(valor);
        aguardarCarregamentoElemento(valorTransferencia);
        if (ios) {
            valorTransferencia.sendKeys(valor);
        } else {
            escreverTexto(valorTransferencia, valor, "Erro ao preencher valor transferência");
        }
        salvarEvidencia("Preencher valor transferência com " + retornaValorTransferencia());
        funcao.call();
        esconderTeclado();
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirValorTela tocarBotaoContinuar() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "Erro ao tocar botão \"Continuar\"");
        salvarEvidencia("Tocar botão \"Continuar\"");
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Próximo\"")
    public TransferirValorTela tocarBotaoProximo() throws Exception{
        aguardarCarregamentoElemento(botaoContinuar);
        esconderTeclado();
        tocarElemento(botaoContinuar, "Erro ao tocar botão \"Continuar\"");
        salvarEvidencia("Tocar botão \"Continuar\"");
        return this;
    }

    /**
     * validar label : 'Se você continuar com essa transferência, vai usar a grana de emergência ok?'
     * @return
     * @throws Exception
     */
    public TransferirValorTela validarLabelDeUsoGranaDeEmergencia() throws Exception {
        By labelUsoDeGranaDeEmergencia;
        if(ios) {
            labelUsoDeGranaDeEmergencia = new MobileBy.ByXPath("//XCUIElementTypeStaticText[contains(@name,\"Se você continuar com essa transferência\")]");
        }
        else {
            labelUsoDeGranaDeEmergencia = new By.ById("br.com.bradesco.next:id/ctv_msg_error_two");
        }
        if (android) {
            esconderTeclado();
        }
        validarCondicaoBooleana(verificarPresencaElemento(labelUsoDeGranaDeEmergencia), MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a mensagem Você não tem grana suficiente pra essa transferência");
        salvarEvidencia("Validou a label sem saldo 'Se você continuar com essa transferência, vai usar a grana de emergência ok?'");
        return this;
    }
     /**
     * Validar label na tela: "Você não tem grana suficiente pra essa transferência". Seu saldo é de R$ XX,XX
     *
     * @return
     * @throws Exception
     */
    @Step("Validar label sem saldo: 'Você não tem grana suficiente pra essa transferência'")
    public TransferirValorTela validarLabelSemSaldoParaTranferencia() throws Exception {
        By labelSemSaldo;
        if(ios) {
            labelSemSaldo = new MobileBy.ByXPath("//XCUIElementTypeStaticText[contains(@name,\"Você não tem grana\")]");
        }
        else {
            labelSemSaldo = new By.ById("br.com.bradesco.next:id/ctv_msg_error_one");
        }
        validarCondicaoBooleana(verificarPresencaElemento(labelSemSaldo), MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a mensagem Você não tem grana suficiente pra essa transferência");
        salvarEvidencia("Validou a label sem saldo 'Você não tem grana suficiente pra essa transferência'");
        return this;
    }

    /**
     * Valida a label de validação do campo de valor
     *
     * @return
     * @throws Exception
     */
    @Step("Validar a label de validação do campo de valor")
    public TransferirValorTela validarLabelValidacaoCampoValor(MensagemValidacaoCamposTranferir mensagemValidacaoCamposTranferir) throws Exception {
        aguardarCarregamentoElemento(msgValidacaoCampoValor);
        salvarEvidencia("Validado mensagem de validação: " + mensagemValidacaoCamposTranferir.toString() + "do campo de valor");
        validarAtributoTexto(msgValidacaoCampoValor, mensagemValidacaoCamposTranferir.MENSAGEM_VALOR_ACIMA_LIMITE.toString(), "Não possível validar o texto: " + mensagemValidacaoCamposTranferir.MENSAGEM_VALOR_ACIMA_LIMITE);
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
        apagarCampoTexto(valorTransferencia, "Não foi possível apagar o valor do campo Valor");
        return this;
    }
}
