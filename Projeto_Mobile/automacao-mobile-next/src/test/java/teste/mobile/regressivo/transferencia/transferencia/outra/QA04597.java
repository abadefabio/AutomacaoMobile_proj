package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.DataAgendamento;
import constantes.transferencia.MensagensEsperadas;
import constantes.transferencia.TransferenciaMotivo;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA04597 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();
    private SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    private ThreadLocal<String> valorDisponivelSaldo = new ThreadLocal<>();
    private ThreadLocal<String> valorTransferencia = new ThreadLocal<>();

    @Test(description = "Validar TRANSFERÊNCIA - Outra Pessoa - TED - Conta Corrente para Conta Corrente utilizando Grana de Emergência - Outros Bancos - PJ")
    @Description("*Ser cliente Next\n" +
            "*Ter acesso ao APP Next\n" +
            "*Estar logado no APP Next")
    @Severity(SeverityLevel.NORMAL)

    public void QA04597() throws Exception{
        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_OUTRA_CC_CC_ITAU_TED_1;
        String dataAgendamento = DataAgendamento.HOJE.toString();
        TransferenciaMotivo motivo = TransferenciaMotivo.CREDITO_EM_CONTA_CORRENTE;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.tocarExibirSaldoConta(valorDisponivelSaldo);

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        outraPessoa.selecionarContatoContaAgencia(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(dataAgendamento, dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.selecionarTipoTransferencia(dadosTransf.recuperarTipoTransferencia()); // DOC ou TED

        transferirFunc.selecionarMotivoTransferencia(TransferenciaMotivo.CREDITO_EM_CONTA);

        transferirFunc.obterValorDaTransferencia(valorTransferencia);

        transferirFunc.validarTransferir(dadosTransf);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_DE_TRANSFERENCIA_DATA_ATUAL);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();

        Integer valorInicial = Integer.parseInt(Utilitarios.normalizaStringNumero(valorDisponivelSaldo.get()));
        Integer valorDaTransferencia = Integer.parseInt(Utilitarios.normalizaStringNumero(valorTransferencia.get()));
        Integer tarifaGranaEmergencia = Integer.parseInt(Utilitarios.normalizaStringNumero(recuperarMassa("tarifaGranaEmergencia")));

        Integer valorSaldoFinal = (valorInicial - (valorDaTransferencia + tarifaGranaEmergencia));

        menu.validaSaldoFinal(valorSaldoFinal.toString());

    }
}
