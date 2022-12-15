package teste.mobile.regressivo.transferencia.agendamento.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.DataAgendamento;
import constantes.transferencia.TipoDeConta;
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
public class QA00419 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc transferir = new TransferirFunc();

    @Test(description = "REG.TRF.15.04.05 - Validar AGENDAMENTO - Outra Pessoa - Conta Corrente para Instituição de Pagamento - Bradescard - PJ ")
    @Description("Objetivos: \n" +
            " Validar agendamento para Instituição de Pagamento, De Conta Corrente Next Para Instituição de Pagamento Bradescard Outra pessoa.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            " Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Possuir contato cadastrado Instituição de Pagamento para realizar transferência;\n" +
            "Possuir saldo em conta.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "  Agendamento de transferência outra pessoa, entre Conta Corrente e Instituição de Pagamento Bradescard.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00419() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(TransferirPara.OUTRA_PESSOA);

        outraPessoa.selecionarContatoContaAgencia(ContaPagamento.CONTA_INSTITUICAO_BRADESCARD_3);

        transferir.exibirFaixaDropdown();

        transferir.ocultarFaixaDropdown();

        transferir.verificarTipoDeContaOrigemEstaSelecionado(TipoDeConta.CONTA_CORRENTE);

        transferir.agendarTransferenciaContaCorrenteParaInstituicaoPagamento(DataAgendamento.PROXIMO_DIA_UTIL);

        transferir.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();
    }
}
