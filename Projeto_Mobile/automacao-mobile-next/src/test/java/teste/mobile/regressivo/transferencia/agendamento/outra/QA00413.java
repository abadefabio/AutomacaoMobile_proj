package teste.mobile.regressivo.transferencia.agendamento.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.DataAgendamento;
import constantes.transferencia.MensagensEsperadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00413 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outrasPessoasFunc = new MeusContatosFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();
    private SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "REG.TRF.15.04.02 - Validar AGENDAMENTO - Outra Pessoa - Conta Corrente Para Poupança - Next AG. 3728  para Next AG. 3750 - PF")
    @Description("Objetivos: \n" +
            "  Validar agendamento para outra pessoa PF, De Conta Corrente Next AG. 3728 para Poupança Next AG. 3750.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            " Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Possuir contato cadastrado Next para realizar transferência;\n" +
            "Possuir saldo em conta.\n" +
            " \n" +
            "Pós-Condições:\n" +
            " Agendamento de transferência outra pessoa, entre contas Next de Conta Corrente para Poupança.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00413() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        ContaPagamento dadosTransf = getDriver() instanceof AndroidDriver ?
                ContaPagamento.TRANSFERENCIA_OUTRA_CC_CP_NEXT_INTERNA_1_ANDROID :
                ContaPagamento.TRANSFERENCIA_OUTRA_CC_CP_NEXT_INTERNA_1_IOS;

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        outrasPessoasFunc.selecionarContatoContaAgencia(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(DataAgendamento.PROXIMO_DIA_UTIL.toString(), dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.validarTransferir(dadosTransf);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();

    }
}
