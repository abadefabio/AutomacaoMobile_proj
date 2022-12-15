package teste.mobile.regressivo.transferencia.agendamento.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.*;
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
public class QA00719 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outrasPessoasFunc = new MeusContatosFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();

    @Test(description = "REG.TRF.15.04.01 - Validar AGENDAMENTO - Outra Pessoa - Poupan�a Para Poupan�a - Bradesco - PF - AUT.")
    @Description("Descri��o (Objetivo):\n" +
            "Validar agendamento para outra pessoa PJ, De Poupan�a Next Para Poupan�a Bradesco, com valor SUPERIOR.\n" +
            "Dados do teste (Massa necess�ria):\n" +
            "Utilizar massa com saldo em conta poupan�a para agendamento da transfer�ncia;\n" +
            "Contato Pessoa Jur�dica;\n" +
            "Tipo de Conta: Conta Bradesco, Ex: AG 1382 Cta: 0022-1;\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Possuir contato cadastrado Bradesco para realizar transfer�ncia;\n" +
            "Possuir saldo em conta.\n" +
            "\n" +
            "Depend�ncias:\n" +
            "N/A.\n" +
            "\n" +
            "Evid�ncias Necess�rias (Resultado Esperado):\n" +
            "Agendamento de transfer�ncia outra pessoa, entre contas Poupan�a Next para Bradesco PJ.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00719() throws Exception {

        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_OUTRA_CP_CP_BRADESCO;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        // outra pessoa
        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        outrasPessoasFunc.selecionarContatoContaAgencia(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        // de conta poupan�a
        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(DataAgendamento.PROXIMO_DIA_UTIL.toString(), dadosTransf);

        // para conta poupan�a, tipo transfer�ncia interna
        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.validarTransferir(dadosTransf);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA);

        transferirFunc.validarComprovanteAgendamentoTransferencia();
    }
}
