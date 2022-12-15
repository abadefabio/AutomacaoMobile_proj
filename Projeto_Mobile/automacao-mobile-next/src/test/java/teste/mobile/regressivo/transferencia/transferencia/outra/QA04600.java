package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.MensagensEsperadas;
import constantes.transferencia.TipoTransferencia;
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

;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA04600 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc transferir = new TransferirFunc();

    @Test(description = "REG.TRF.15.05.06 - Validar TRANSFERÊNCIA - Outra Pessoa - Instituição de Pagamento - Poupança - Bradescard - PF")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Outra Pessoa - Instituição de Pagamento - Poupança - Bradescard - P")
    @Severity(SeverityLevel.NORMAL)
    public void QA04600() throws Exception{

        ContaPagamento dadosTransf = ContaPagamento.CONTA_INSTITUICAO_PAGAMENTO_NU;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        outraPessoa.selecionarContatoContaAgencia(dadosTransf);

        transferir.exibirFaixaDropdown();

        transferir.ocultarFaixaDropdown();

        transferir.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferir.iniciarTransferenciaInstituicaoPagamento(dadosTransf);

        transferir.selecionarTipoTransferencia(TipoTransferencia.TED);

        transferir.selecionarMotivoTransferencia(TransferenciaMotivo.CREDITO_EM_CONTA_PG);

        transferir.validarTransferir(dadosTransf);

        transferir.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_TRANSFERENCIA);

        transferir.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();
    }
}
