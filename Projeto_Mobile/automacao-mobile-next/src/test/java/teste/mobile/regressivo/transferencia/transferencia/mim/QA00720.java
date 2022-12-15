package teste.mobile.regressivo.transferencia.transferencia.mim;

import org.testng.annotations.Test;

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
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00720 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContasFunc = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();

    @Test(description = "REG.TRF.15.03.01 - Validar TRANSFERÊNCIA - Para mim - DOC - Conta Poupança Para Conta Corrente - Outros Bancos - Compart.Comprov.")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Para mim - DOC - De Conta Poupança Para Conta Corrente - Outros Bancos.\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PF)\n" +
            "Possuir saldo em conta.\n" +
            "Ter cadastro no PACL\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "TRANSFERÊNCIA - Para mim - DOC - De Conta Poupança Para Conta Corrente - Outros Bancos.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00720() throws Exception {

        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_MIM_CP_CC_ITAU_DOC_2;
        String dataAgendamento = DataAgendamento.HOJE.toString();
        TransferenciaMotivo motivo = TransferenciaMotivo.CREDITO_EM_CONTA_CORRENTE;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        minhasContasFunc.selecionarMinhaConta(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(dataAgendamento, dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.selecionarTipoTransferencia(dadosTransf.recuperarTipoTransferencia()); // DOC ou TED

        transferirFunc.selecionarMotivoTransferencia(motivo);

        transferirFunc.validarTransferir(dadosTransf, motivo);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_TRANSFERENCIA);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();
    }
}
