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
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00422 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();

    @Test(description = "REG.TRF.15.04.06 - Validar AGENDAMENTO - Outra Pessoa - Poupança para Instituição de Pagamento - Outros Bancos - PJ ")
    @Description("Objetivos: \n" +
            " Validar agendamento para Instituição de Pagamento Outra pessoa, De Poupança Next Para Instituição de Pagamento outros bancos.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            " Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Possuir contato cadastrado Instituição de Pagamento Outros bancos para realizar transferência;\n" +
            "Possuir saldo em conta;\n" +
            "Ter cadastro no PACL.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "  Agendamento de transferência outra pessoa, entre Poupança Next e Instituição de Pagamento outros bancos.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00422() throws Exception {

        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_OUTRA_CP_PG_BRADESCARD_TED_1;
        String dataAgendamento = DataAgendamento.PROXIMO_DIA_UTIL.toString();
        TransferenciaMotivo motivo = TransferenciaMotivo.CREDITO_EM_CONTA_PG;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        outraPessoa.selecionarContatoContaAgencia(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(dataAgendamento, dadosTransf);

        transferirFunc.selecionarTipoTransferencia(dadosTransf.recuperarTipoTransferencia());

        transferirFunc.selecionarMotivoTransferencia(motivo);

        transferirFunc.validarTransferir(dadosTransf, motivo);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();

    }
}
