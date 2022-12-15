package teste.mobile.regressivo.transferencia.agendamento.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.*;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00397 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();


    @Test(description = "REG.TRF.15.02.03 -Validar AGENDAMENTO - Para mim - TED - Conta Corrente Para Instituição de Pagamento - Bradescard ")
    @Description("Objetivos: \n" +
            " Validar AGENDAMENTO - Para mim - TED - De Conta Corrente Para Instituição de Pagamento - Bradescard.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            " Obter aparelho android e/ou IOS;\n" +
            "Obter aplicatilhio instalado;\n" +
            "Obterconta ativa no NEXT;\n" +
            "Ter contatos Cadastrados de Instituição de Pagamento Bradescard\n" +
            "Obter saldo em conta.\n" +
            " \n" +
            "Pós-Condições:\n" +
            " AGENDAMENTO - Para mim - TED - De Conta Corrente Para Instituição de Pagamento - Bradescard com sucesso.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00397() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_MIM_CC_PG_BRADESCARD_TED_1;

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        minhasContas.selecionarMinhaConta(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(DataAgendamento.PROXIMO_DIA_UTIL.toString(), dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.selecionarTipoTransferencia(TipoTransferencia.TED);

        transferirFunc.selecionarMotivoTransferencia(TransferenciaMotivo.TRANSF_ENTRE_CTAS_MM_TITULA_PG);

        transferirFunc.validarTransferir(dadosTransf);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();

    }
}
