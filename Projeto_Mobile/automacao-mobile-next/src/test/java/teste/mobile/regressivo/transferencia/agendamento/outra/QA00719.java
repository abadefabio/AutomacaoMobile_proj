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

    @Test(description = "REG.TRF.15.04.01 - Validar AGENDAMENTO - Outra Pessoa - Poupança Para Poupança - Bradesco - PF - AUT.")
    @Description("Descrição (Objetivo):\n" +
            "Validar agendamento para outra pessoa PJ, De Poupança Next Para Poupança Bradesco, com valor SUPERIOR.\n" +
            "Dados do teste (Massa necessária):\n" +
            "Utilizar massa com saldo em conta poupança para agendamento da transferência;\n" +
            "Contato Pessoa Jurídica;\n" +
            "Tipo de Conta: Conta Bradesco, Ex: AG 1382 Cta: 0022-1;\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Possuir contato cadastrado Bradesco para realizar transferência;\n" +
            "Possuir saldo em conta.\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "Agendamento de transferência outra pessoa, entre contas Poupança Next para Bradesco PJ.")
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

        // de conta poupança
        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferencia(DataAgendamento.PROXIMO_DIA_UTIL.toString(), dadosTransf);

        // para conta poupança, tipo transferência interna
        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.validarTransferir(dadosTransf);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA);

        transferirFunc.validarComprovanteAgendamentoTransferencia();
    }
}
