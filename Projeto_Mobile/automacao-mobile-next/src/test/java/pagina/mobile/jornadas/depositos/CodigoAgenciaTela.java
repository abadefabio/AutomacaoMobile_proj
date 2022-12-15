package pagina.mobile.jornadas.depositos;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

import br.com.next.automacao.core.base.mobile.PaginaBase;

import constantes.pagamentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CodigoAgenciaTela extends PaginaBase {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='C�digo da ag�ncia']")
    @iOSXCUITFindBy(accessibility = "C�digo da ag�ncia")
    private MobileElement botaoCodigoAgencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_code")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement textoCodigoAgencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_branch_code")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement campoTextoCodigoAgencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    @iOSXCUITFindBy(accessibility = "Pr�ximo")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_apply")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoApply;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeCell\" ")
    private MobileElement botaoAgencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_continue")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botaoContinuarTelaAgendamento;

    public CodigoAgenciaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar em 'Codigo da Ag�ncia'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Codigo da Ag�ncia\"")
    public CodigoAgenciaTela tocarBotaoCodigoAgencia() throws Exception {
        aguardarCarregamentoElemento(botaoCodigoAgencia);
        salvarEvidencia("Clicar em 'Codigo da Ag�ncia'");
        tocarElemento(botaoCodigoAgencia, "N�o foi poss�vel clicar no bot�o 'C�digo da Ag�ncia'");
        return this;
    }

    /**
     * Buscar c�digo da ag�ncia
     *
     * @param agencia via Json
     * @return
     * @throws Exception
     */
    @Step("Buscar \"Codigo da Ag�ncia\"")
    public CodigoAgenciaTela preencherCodigoAgencia(String agencia) throws Exception {
        escreverTexto(textoCodigoAgencia, agencia, "N�o foi poss�vel inserir o C�digo da Ag�ncia");
        salvarEvidencia("Inserir 'Codigo da Ag�ncia'");
        return this;
    }

    /**
     * Clicar em 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Confirmar\"")
    public CodigoAgenciaTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Clicar em 'Confirmar'");
        tocarElemento(botaoConfirmar, "N�o foi poss�vel clicar no bot�o 'Confirmar'");
        return this;
    }

    /**
     * Clicar em 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Apply\"")
    public CodigoAgenciaTela tocarBotaoApply() throws Exception {
        aguardarCarregamentoElemento(botaoApply);
        salvarEvidencia("Clicar em 'Apply'");
        tocarElemento(botaoApply, "N�o foi poss�vel clicar no bot�o 'Apply'");
        return this;
    }

    /**
     * Selecionar primeira agencia
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar agencia")
    public CodigoAgenciaTela selecionarAgencia() throws Exception {
        aguardarCarregamentoElemento(botaoAgencia);
        salvarEvidencia("Selecionar agencia");
        tocarElemento(botaoAgencia, "N�o foi poss�vel selecionar agencia");
        return this;
    }

    /**
     * Escreve o c�digo da ag�ncia
     *
     * @param codigoAgencia
     * @return
     * @throws Exception
     */
    @Step("Inserir \"C�digo Ag�ncia\"")
    public CodigoAgenciaTela inserirCodigoAgencia(String codigoAgencia) throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            if (!aguardarPaginaOcultar("Preencher automaticamente")) {
                voltarTelaAnterior();
            }
            escreverTexto(campoTextoCodigoAgencia, codigoAgencia, "N�o foi poss�vel digitar o c�digo da ag�ncia");
        } else {
            campoTextoCodigoAgencia.sendKeys(codigoAgencia);
        }
        salvarEvidencia("Escreve c�digo da ag�ncia");
        return this;
    }

    /**
     * Clicar em Continuar Tela Agendamento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Continuar\"")
    public CodigoAgenciaTela tocarBotaoContinuarAgendamento() throws Exception {
        boolean botaoContinuarTelaAgendamentoPresente = aguardarCarregamentoElemento(botaoContinuarTelaAgendamento);
        salvarEvidencia("Clicar em 'continuar'");
        if (!botaoContinuarTelaAgendamentoPresente) {
            tocarElemento(botaoConfirmar, "Erro ao tocar no bot�o Confirmar");
        } else {
            tocarElemento(botaoContinuarTelaAgendamento, "N�o foi poss�vel clicar  em Continuar");
        }
        return this;
    }
}
