package teste.mobile.regressivo.transferencia.agendamento.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.DataAgendamento;
import constantes.transferencia.MensagensEsperadas;
import constantes.transferencia.TransferenciaMotivo;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00417 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outrasPessoasFunc = new MeusContatosFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();
    private SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "REG.TRF.15.04.03 - Validar AGENDAMENTO - Outra Pessoa - DOC - Poupança para Conta Corrente - Outros Bancos - PJ ")
    @Description("Objetivos: \n" +
            " Validar agendamento para outra pessoa PJ do tipo DOC, De Poupança Next Para Conta Corrente Outros bancos.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            " Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Possuir contato cadastrado outros bancos PJ para realizar transferência;\n" +
            "Possuir saldo em conta;\n" +
            "Ter cadastro no PACL.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "  Agendamento de transferência outra pessoa PJ do tipo DOC, entre Poupança Next e Conta Corrente Outros bancos.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00417() throws Exception {

        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_OUTRA_CP_CC_ITAU_DOC_1;
        String dataAgendamento = DataAgendamento.PROXIMO_DIA_UTIL_MAIS_2.toString();
        TransferenciaMotivo motivo = TransferenciaMotivo.OUTROS;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        outrasPessoasFunc.selecionarContatoContaAgencia(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        // Selecionar uma data posterior ao dia de hoje e definir valor
        transferirFunc.iniciarAgendamentoTransferencia(dataAgendamento, dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        // Este fluxo requer DOC
        transferirFunc.selecionarTipoTransferencia(dadosTransf.recuperarTipoTransferencia()); // DOC ou TED

        // O motivo - ou finalidade - não é especificado pelo fluxo, então utilizamos "Outros".
        transferirFunc.selecionarMotivoTransferencia(motivo);

        transferirFunc.validarTransferir(dadosTransf, motivo);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();

    }
}
