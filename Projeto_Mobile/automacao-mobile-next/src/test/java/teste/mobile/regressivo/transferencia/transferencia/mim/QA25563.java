package teste.mobile.regressivo.transferencia.transferencia.mim;

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
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA25563 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContasFunc = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();

    @Test(description = "REG.TRF.15.03.04 - Validar TRANSFERÊNCIA - Para mim - TED - Conta Poupança Para Conta Corrente - Outros Bancos com Acentuação")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Para mim - TED - De Conta Poupança Para Conta Corrente - Outros Bancos.\n" +            "Validar TRANSFERÊNCIA - Para mim - TED - De Conta Poupança Para Conta Corrente - Outros Bancos.\n" +
            "\n" +
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
            "TRANSFERÊNCIA - Para mim - TED - De Conta Poupança Para Conta Corrente - Outros Bancos.")
    @Severity(SeverityLevel.NORMAL)
    public void QA25563() throws Exception {

        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_MIM_CP_CC_ITAU_TED_3;
        String dataAgendamento = DataAgendamento.HOJE.toString();
        TransferenciaMotivo motivo = TransferenciaMotivo.TRANSF_ENTRE_CTAS_MM_TITULARID;

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
