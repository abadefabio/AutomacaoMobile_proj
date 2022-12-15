package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.depositos.saques.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class DepositosSaquesTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_transfer_for_bradesco")
    @iOSXCUITFindBy(accessibility = "Transferir do Bradesco")
    private MobileElement botaoTransferirBradesco;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_transfer_other_bank")
    @iOSXCUITFindBy(accessibility = "Transferir de outros Bancos")
    private MobileElement botaoTransferirOutrosBancos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_cash_machine")
    @iOSXCUITFindBy(accessibility = "Caixa Eletrônico")
    private MobileElement botaoCaixaEletronico;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_schedule_withdrawal")
    @iOSXCUITFindBy(accessibility = "Agendar Saque")
    private MobileElement botaoAgendarSaque;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_view_scheduled_withdrawal")
    @iOSXCUITFindBy(accessibility = "Consultar Saques Agendados e Efetuados")
    private MobileElement botaoConsultarSaques;

    @AndroidFindBy(accessibility = "Menu, Botão")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    private MobileElement botaoMenu;

    public DepositosSaquesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar em 'Transferir do Bradesco'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Transferir do Bradesco\"")
    public DepositosSaquesTela tocarBotaoTransferirBradesco() throws Exception {
        aguardarCarregamentoElemento(botaoTransferirBradesco);
        salvarEvidencia("Clicar no botão 'Tranferir do Bradesco'");
        tocarElemento(botaoTransferirBradesco, "Não foi possível clicar no botão Transferir do Bradesco");
        return this;
    }

    /**
     * Clicar em 'Tranferir de Outros Bancos'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Transferir de outros bancos\"")
    public DepositosSaquesTela tocarBotaoTransferirOutrosBancos() throws Exception {
        aguardarCarregamentoElemento(botaoTransferirOutrosBancos);
        salvarEvidencia("Clicar no botão 'Tranferir de Outros Bancos'");
        tocarElemento(botaoTransferirOutrosBancos, "Não foi possível clicar no botão Tranferir de Outros Bancos");
        return this;
    }

    /**
     * Clicar em 'Caixa Eletrônico'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Caixa Eletronico\"")
    public DepositosSaquesTela tocarBotaoCaixaEletronico() throws Exception {
        aguardarCarregamentoElemento(botaoCaixaEletronico);
        salvarEvidencia("Clicar no botão 'Caixa Eletronico'");
        tocarElemento(botaoCaixaEletronico, "Não foi possível clicar no botão Caixa Eletrônico");
        return this;
    }

    /**
     * Clicar em 'Agendar Saque'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Agendar Saque\"")
    public DepositosSaquesTela tocarBotaoAgendarSaque() throws Exception {
        aguardarCarregamentoElemento(botaoAgendarSaque);
        salvarEvidencia("Tocar no botão 'Agendar Saque'");
        tocarElemento(botaoAgendarSaque, "Não foi possível tocar no botão Agendar Saque");
        return this;
    }

    /**
     * Clicar em 'Consultar Saques Agendados e Efetuados'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Consultar Saques Agendados e Efetuados\"")
    public DepositosSaquesTela tocarBotaoConsultarSaques() throws Exception {
        aguardarCarregamentoElemento(botaoConsultarSaques);
        salvarEvidencia("Clicar no botão 'Consultar Saques Agendados e Efetuados'");
        tocarElemento(botaoConsultarSaques, "Não foi possível clicar no botão Consultar Saques Agendados e Efetuados");
        return this;
    }

    /**
     * Retornar ao Menu
     *
     * @return
     * @throws Exception
     */
    @Step("Retornar ao Menu")
    public DepositosSaquesTela retornarAoMenu() throws Exception {
        aguardarCarregamentoElemento(botaoMenu);
        salvarEvidencia("Clicar no botão 'Menu'");
        tocarElemento(botaoMenu, "Não foi possível clicar no botão 'Menu'");
        return this;
    }

    /**
     * Validar presença da tela 'Depósitos e Saques'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Depósitos e Saques'")
    public DepositosSaquesTela validarPresencaDepositosESaquesTela() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.DEPOSITOS_SAQUES), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Depósitos e Saques' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'Depósitos e Saques'");
        return this;
    }
}
