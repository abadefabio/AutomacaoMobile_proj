package pagina.mobile.jornadas.transferencia.confereDados;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.retornaNomeContato;
import static pagina.mobile.jornadas.transferencia.para.outra.NovoContatoTela.retornaAgenciaContato;
import static pagina.mobile.jornadas.transferencia.para.outra.NovoContatoTela.retornaContaContato;


public class ConfereDadosTela extends PaginaBase {

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeImage)[1]")
    private MobileElement imagemFotoUsuarioUm;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeImage)[2]")
    private MobileElement imagemFotoUsuarioDois;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'De,')]")
    private MobileElement celulaDe;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Para,')]")
    private MobileElement celulaPara;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'CPF/CNPJ,')]")
    private MobileElement celulaCPFCNPJ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Banco,')]")
    private MobileElement celulaBanco;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Ag�ncia,')]")
    private MobileElement celulaAgencia;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Conta,')]")
    private MobileElement celulaConta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Quando,')]")
    private MobileElement celulaQuando;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Tipo de Conta (origem),')]")
    private MobileElement celulaTipoContaOrigem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Tipo de transfer�ncia,')]")
    private MobileElement celulaTipoTransferencia;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Tipo de Conta (destino),')]")
    private MobileElement celulaTipoContaDestino;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Finalidade,')]")
    private MobileElement celulaTipoContaFinalidade;

    @AndroidFindBy(id = "//android.widget.TextView[@content-desc=\"56617-8\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"CONFERE OS DADOS\"]/../XCUIElementTypeOther//XCUIElementTypeCell[contains(@name, 'Descri��o,')]")
    private MobileElement celulaTipoContaDescricao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/bt_transfer")
    @AndroidFindBy(accessibility = "Transferir")
    @AndroidFindBy(xpath = "//*[contains(@text,'Transferir') OR @content-desc='Transferir']")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/bt_transfer']")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Transferir\"]")
    @iOSXCUITFindBy(xpath = "//*[translate(@label, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz') = \"transferir\"]")
    private MobileElement botaoTransferir;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"BANCO BRADESCAR\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"BANCO B.\"]")
    private MobileElement txtContaPag;

    @AndroidFindBy(id = "br.com.bradesco.next:id/calendar")
    private MobileElement switchSalvar;

    public ConfereDadosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar bot�o "Transferir"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Transferir\"")
    public ConfereDadosTela tocarBotaoTransferir() throws Exception{
        aguardarCarregamentoElemento(botaoTransferir);
        rolaTelaBaixo();
        tocarElemento(botaoTransferir, "Erro ao tocar bot�o \"Transferir\"");
        salvarEvidencia("Tocar bot�o \"Transferir\"");
        return this;
    }

    /**
     * Validar agencia informada na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"agencia\" informada na tela")
    public ConfereDadosTela validarContaTipoPagamento(Enum bradescar) throws Exception {
        aguardarCarregamentoElemento(txtContaPag);
        OperadorEvidencia.logarPasso("validar conta Bradescard");
        salvarEvidencia("Validar a existencia da conta :" + retornaContaContato() + " adicionada.");
        verificarPresencaElemento(txtContaPag);
        return this;
    }

    /**
     * Validar agencia informada na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"agencia\" informada na tela")
    public ConfereDadosTela validarAgencia() throws Exception {
        MobileElement txtAgencia = retornarElemento(new By.ByXPath("//android.widget.TextView[@content-desc,\"" + retornaAgenciaContato() + "\"]"), "erro, n�o foi possivel verificar o elemento agencia.");
        aguardarCarregamentoElemento(txtAgencia);
        salvarEvidencia("Valida��o da ag�ncia com:" + retornaAgenciaContato());
        validarAtributoTexto(txtAgencia, retornaAgenciaContato(),"Erro ao validar agencia informada.");
        return this;
    }
    /**
     * Validar agencia informada na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"agencia\" informada na tela")
    public ConfereDadosTela validarAgenciaInformada(String agencia) throws Exception {
        aguardarCarregamentoElemento(botaoTransferir);
        if(android) {
            MobileElement txtAgencia = retornarElemento(new By.ByXPath("//android.widget.TextView[@content-desc=\"1091\"]"), "erro, n�o foi possivel verificar o elemento agencia.");
            validarAtributoTexto(txtAgencia,agencia,"Erro ao validar numero da agencia");
        }else{
            MobileElement txtAgencia = retornarElemento(new By.ByXPath("//XCUIElementTypeStaticText[@name=\"1091\"]"), "erro, n�o foi possivel verificar o elemento agencia.");
            validarAtributoTexto(txtAgencia,agencia,"Erro ao validar numero da agencia");
        }
        salvarEvidencia("Valida��o da ag�ncia no comprovante com:" + agencia);
        return this;
    }
    /**
     * Validar conta informada na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"conta\" informada na tela")
    public ConfereDadosTela validarContaInformada() throws Exception {
        aguardarCarregamentoElemento(botaoTransferir);
        if(ios) {
            String contaoInformado = retornaContaContato();
            OperadorEvidencia.logarPasso(retornaContaContato());
            MobileElement txtConta = retornarElemento(new By.ByXPath("//XCUIElementTypeStaticText[contains(@name,'" + contaoInformado + "']"), "erro, n�o foi possivel verificar o elemento Conta.");
            validarAtributoTexto(txtConta, retornaContaContato(), "Erro ao validar agencia informada.");
            salvarEvidencia("Valida��o com:" + retornaContaContato());
        }else {
            MobileElement txtConta = retornarElemento(new By.ByXPath("//android.widget.TextView[@content-desc='" + retornaContaContato() + "']"), "erro, n�o foi possivel verificar o elemento Conta.");
            validarAtributoTexto(txtConta, retornaContaContato(), "Erro ao validar agencia informada.");
            salvarEvidencia("Valida��o com:" + retornaContaContato());
            OperadorEvidencia.logarPasso(retornaContaContato());
        }
        return this;
    }

    /**
     * Validar Nome do contato na tela
     *
     * @return
     * @throws Exception
     */
    @Step("Validar \"Nome\" informado na tela")
    public ConfereDadosTela validarNomeContato() throws Exception {
        String nomeInformado = retornaNomeContato();
        aguardarCarregamentoElemento(botaoTransferir);
        if(ios) {
            MobileElement txtNome = retornarElemento(new By.ByXPath("//XCUIElementTypeStaticText[@name='" + nomeInformado + "']"), "erro, n�o foi possivel verificar o elemento nome.");
            validarAtributoTexto(txtNome, retornaNomeContato(), "Erro ao validar nome informado.");
        }else {
            MobileElement txtNome = retornarElemento(new By.ByXPath("//android.widget.TextView[@content-desc='" + nomeInformado + "']"), "erro, n�o foi possivel verificar o elemento nome.");
            validarAtributoTexto(txtNome, retornaNomeContato(), "Erro ao validar nome informado.");
        }
        salvarEvidencia("Valida��o do nome no comprovante:" + retornaNomeContato());
        return this;
    }
}
