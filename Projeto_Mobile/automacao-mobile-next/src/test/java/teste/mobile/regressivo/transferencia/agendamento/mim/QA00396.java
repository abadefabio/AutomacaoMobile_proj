package teste.mobile.regressivo.transferencia.agendamento.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.DataAgendamento;
import constantes.transferencia.TipoDeConta;
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
public class QA00396 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferir = new TransferirFunc();
    private SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();

    @Test(description = "REG.TRF.15.02.02 -Validar AGENDAMENTO - Para mim - DOC - Poupan�a Para Conta Corrente - Outros Bancos")
    @Description("Objetivos: \n" +
            "Validar AGENDAMENTO - Para Mim - TED - Poupan�a para Conta Corrente - Outros Bancos.\n" +
            " \n" +
            "Pr�-Requisitos:\n" +
            "Obter aparelho android e/ou IOS;\n" +
            "Obter aplicatilhio instalado;\n" +
            "Obterconta ativa no NEXT;\n" +
            "Ter contatos Cadastrados Para Mim (Outros Bancos - PF)\n" +
            "Obter saldo em conta;\n" +
            "Ter cadastro no PACL.\n" +
            " \n" +
            "P�s-Condi��es:\n" +
            " Validar AGENDAMENTO - Para Mim - TED - Poupan�a para Conta Corrente - Outros Bancos com sucesso.\n" +
            " \n" +
            "Evidencias necess�rias:\n" +
            "Todo o fluxo at� as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00396() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(TransferirPara.MIM);

        minhasContas.selecionarMinhaConta(ContaPagamento.CONTA_BANCO_ITAU);

        transferir.exibirFaixaDropdown();

        transferir.ocultarFaixaDropdown();

        transferir.selecionarTipoDeContaOrigem(TipoDeConta.CONTA_POUPANCA);

        transferir.agendarTransferenciaPoupanca(DataAgendamento.PROXIMO_DIA_UTIL);

        transferir.validarComprovanteAgendamentoTransferencia();
    }
}
