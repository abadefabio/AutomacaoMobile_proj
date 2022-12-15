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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Código da agência']")
    @iOSXCUITFindBy(accessibility = "Código da agência")
    private MobileElement botaoCodigoAgencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_code")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement textoCodigoAgencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_branch_code")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement campoTextoCodigoAgencia;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_confirm")
    @iOSXCUITFindBy(accessibility = "Próximo")
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
     * Clicar em 'Codigo da Agência'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Codigo da Agência\"")
    public CodigoAgenciaTela tocarBotaoCodigoAgencia() throws Exception {
        aguardarCarregamentoElemento(botaoCodigoAgencia);
        salvarEvidencia("Clicar em 'Codigo da Agência'");
        tocarElemento(botaoCodigoAgencia, "Não foi possível clicar no botão 'Código da Agência'");
        return this;
    }

    /**
     * Buscar código da agência
     *
     * @param agencia via Json
     * @return
     * @throws Exception
     */
    @Step("Buscar \"Codigo da Agência\"")
    public CodigoAgenciaTela preencherCodigoAgencia(String agencia) throws Exception {
        escreverTexto(textoCodigoAgencia, agencia, "Não foi possível inserir o Código da Agência");
        salvarEvidencia("Inserir 'Codigo da Agência'");
        return this;
    }

    /**
     * Clicar em 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Confirmar\"")
    public CodigoAgenciaTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Clicar em 'Confirmar'");
        tocarElemento(botaoConfirmar, "Não foi possível clicar no botão 'Confirmar'");
        return this;
    }

    /**
     * Clicar em 'Confirmar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Apply\"")
    public CodigoAgenciaTela tocarBotaoApply() throws Exception {
        aguardarCarregamentoElemento(botaoApply);
        salvarEvidencia("Clicar em 'Apply'");
        tocarElemento(botaoApply, "Não foi possível clicar no botão 'Apply'");
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
        tocarElemento(botaoAgencia, "Não foi possível selecionar agencia");
        return this;
    }

    /**
     * Escreve o código da agência
     *
     * @param codigoAgencia
     * @return
     * @throws Exception
     */
    @Step("Inserir \"Código Agência\"")
    public CodigoAgenciaTela inserirCodigoAgencia(String codigoAgencia) throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            if (!aguardarPaginaOcultar("Preencher automaticamente")) {
                voltarTelaAnterior();
            }
            escreverTexto(campoTextoCodigoAgencia, codigoAgencia, "Não foi possível digitar o código da agência");
        } else {
            campoTextoCodigoAgencia.sendKeys(codigoAgencia);
        }
        salvarEvidencia("Escreve código da agência");
        return this;
    }

    /**
     * Clicar em Continuar Tela Agendamento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Continuar\"")
    public CodigoAgenciaTela tocarBotaoContinuarAgendamento() throws Exception {
        boolean botaoContinuarTelaAgendamentoPresente = aguardarCarregamentoElemento(botaoContinuarTelaAgendamento);
        salvarEvidencia("Clicar em 'continuar'");
        if (!botaoContinuarTelaAgendamentoPresente) {
            tocarElemento(botaoConfirmar, "Erro ao tocar no botão Confirmar");
        } else {
            tocarElemento(botaoContinuarTelaAgendamento, "Não foi possível clicar  em Continuar");
        }
        return this;
    }
}
