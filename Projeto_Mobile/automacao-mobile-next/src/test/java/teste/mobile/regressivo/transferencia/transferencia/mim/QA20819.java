package teste.mobile.regressivo.transferencia.transferencia.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.DataAgendamento;
import constantes.transferencia.MensagensEsperadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA20819 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();
    private SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    private ThreadLocal<String> valorDisponivelSaldo = new ThreadLocal<>();
    private ThreadLocal<String> valorTransferencia = new ThreadLocal<>();


    @Test(description = " Validar TRANSFERÊNCIA - Para mim - TED - Conta Corrente P/ Conta Corrente - NEXT p/ Bradesco")
    @Description("")
    @Severity(SeverityLevel.NORMAL)

    public void QA20819() throws Exception {
        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_MIM_CC_CC_BRADESCO_INTERNA_1;
        String dataAgendamento = DataAgendamento.HOJE.toString();

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.tocarExibirSaldoConta(valorDisponivelSaldo);

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        minhasContas.selecionarMinhaConta(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(dataAgendamento, dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.obterValorDaTransferencia(valorTransferencia);

        transferirFunc.validarTransferir(dadosTransf);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_DE_TRANSFERENCIA_DATA_ATUAL);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();

        Integer valorInicial = Integer.parseInt(Utilitarios.normalizaStringNumero(valorDisponivelSaldo.get()));
        Integer valorDaTransferencia = Integer.parseInt(Utilitarios.normalizaStringNumero(valorTransferencia.get()));

        Integer valorSaldoFinal = valorInicial - valorDaTransferencia;

        menu.validaSaldoFinal(valorSaldoFinal.toString());
    }
}
