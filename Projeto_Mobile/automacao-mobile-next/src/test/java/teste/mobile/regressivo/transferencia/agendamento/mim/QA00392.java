package teste.mobile.regressivo.transferencia.agendamento.mim;

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
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00392 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();
    private SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "REG.TRF.15.02.01 - Validar AGENDAMENTO - Para mim - Conta Corrente Para Conta Corrente - Next para Bradesco")
    @Description("Objetivos: \n" +
            " Validar AGENDAMENTO - Para mim - De Conta Corrente Para Conta Corrente - Next para Bradesco.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "Obter aparelho android e/ou IOS;\n" +
            "Obter aplicatilhio instalado;\n" +
            "Obterconta ativa no NEXT;\n" +
            "Ter contatos Cadastrados Para mim (Bradesco - PF);\n" +
            "Obter saldo em conta.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "Transferência Para Mim tipo TED de conta corrente Next para conta corrente outro bancocom sucesso.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00392() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_MIM_CC_CC_BRADESCO_INTERNA_1;

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        minhasContas.selecionarMinhaConta(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(DataAgendamento.PROXIMO_DIA_UTIL.toString(), dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.validarTransferir(dadosTransf);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA);

        transferirFunc.validarComprovanteAgendamentoTransferencia();
    }
}
