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
    @iOSXCUITFindBy(accessibility = "Caixa Eletr�nico")
    private MobileElement botaoCaixaEletronico;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_schedule_withdrawal")
    @iOSXCUITFindBy(accessibility = "Agendar Saque")
    private MobileElement botaoAgendarSaque;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_view_scheduled_withdrawal")
    @iOSXCUITFindBy(accessibility = "Consultar Saques Agendados e Efetuados")
    private MobileElement botaoConsultarSaques;

    @AndroidFindBy(accessibility = "Menu, Bot�o")
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
    @Step("Clicar bot�o \"Transferir do Bradesco\"")
    public DepositosSaquesTela tocarBotaoTransferirBradesco() throws Exception {
        aguardarCarregamentoElemento(botaoTransferirBradesco);
        salvarEvidencia("Clicar no bot�o 'Tranferir do Bradesco'");
        tocarElemento(botaoTransferirBradesco, "N�o foi poss�vel clicar no bot�o Transferir do Bradesco");
        return this;
    }

    /**
     * Clicar em 'Tranferir de Outros Bancos'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Transferir de outros bancos\"")
    public DepositosSaquesTela tocarBotaoTransferirOutrosBancos() throws Exception {
        aguardarCarregamentoElemento(botaoTransferirOutrosBancos);
        salvarEvidencia("Clicar no bot�o 'Tranferir de Outros Bancos'");
        tocarElemento(botaoTransferirOutrosBancos, "N�o foi poss�vel clicar no bot�o Tranferir de Outros Bancos");
        return this;
    }

    /**
     * Clicar em 'Caixa Eletr�nico'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Caixa Eletronico\"")
    public DepositosSaquesTela tocarBotaoCaixaEletronico() throws Exception {
        aguardarCarregamentoElemento(botaoCaixaEletronico);
        salvarEvidencia("Clicar no bot�o 'Caixa Eletronico'");
        tocarElemento(botaoCaixaEletronico, "N�o foi poss�vel clicar no bot�o Caixa Eletr�nico");
        return this;
    }

    /**
     * Clicar em 'Agendar Saque'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o \"Agendar Saque\"")
    public DepositosSaquesTela tocarBotaoAgendarSaque() throws Exception {
        aguardarCarregamentoElemento(botaoAgendarSaque);
        salvarEvidencia("Tocar no bot�o 'Agendar Saque'");
        tocarElemento(botaoAgendarSaque, "N�o foi poss�vel tocar no bot�o Agendar Saque");
        return this;
    }

    /**
     * Clicar em 'Consultar Saques Agendados e Efetuados'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar bot�o \"Consultar Saques Agendados e Efetuados\"")
    public DepositosSaquesTela tocarBotaoConsultarSaques() throws Exception {
        aguardarCarregamentoElemento(botaoConsultarSaques);
        salvarEvidencia("Clicar no bot�o 'Consultar Saques Agendados e Efetuados'");
        tocarElemento(botaoConsultarSaques, "N�o foi poss�vel clicar no bot�o Consultar Saques Agendados e Efetuados");
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
        salvarEvidencia("Clicar no bot�o 'Menu'");
        tocarElemento(botaoMenu, "N�o foi poss�vel clicar no bot�o 'Menu'");
        return this;
    }

    /**
     * Validar presen�a da tela 'Dep�sitos e Saques'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presen�a da tela 'Dep�sitos e Saques'")
    public DepositosSaquesTela validarPresencaDepositosESaquesTela() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.DEPOSITOS_SAQUES), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Dep�sitos e Saques' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela 'Dep�sitos e Saques'");
        return this;
    }
}
