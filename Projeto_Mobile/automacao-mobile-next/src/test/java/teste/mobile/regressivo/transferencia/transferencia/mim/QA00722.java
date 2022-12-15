package teste.mobile.regressivo.transferencia.transferencia.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.transferencia.*;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import br.com.next.automacao.core.constantes.massa.JSON;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00722 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();
    private SaldoExtratoFunc saldoExtratoFunc = new SaldoExtratoFunc();



    @Test(description = "REG.TRF.15.03.03 - Validar TRANSFERÊNCIA - Para mim - TED - Conta Corrente Para Conta Poupança utilizando Grana de Emergência - Outros Bancos")
    @Description("Descrição (Objetivo):\n" +
            "Validar TRANSFERÊNCIA - Para mim - TED - De Conta Corrente Para Conta Poupança utilizando Grana de Emergência - Outros Bancos.\n" +
            "\n" +
            "Dados do teste (Massa necessária):\n" +
            "Qualquer CPF que obtenha conta e contatos cadastrados.\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Ter contatos Cadastrados Outra Pessoa (Outros Bancos - PF)\n" +
            "Não obter saldo em conta;\n" +
            "Obter grande de emergência.\n" +
            "Ter cadastro no PACL\n" +
            "\n" +
            "Dependências:\n" +
            "N/A.\n" +
            "\n" +
            "Evidências Necessárias (Resultado Esperado):\n" +
            "TRANSFERÊNCIA - Para mim - TED - De Conta Corrente Para Conta Poupança utilizando Grana de Emergência - Outros Bancos.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00722() throws Exception {

        ContaPagamento dadosTransf = ContaPagamento.TRANSFERENCIA_MIM_CC_CP_ITAU_TED_1;
        String dataAgendamento = DataAgendamento.HOJE.toString();
        TransferenciaMotivo motivo = TransferenciaMotivo.TRANSF_ENTRE_CTAS_MM_TITULARID;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        minhasContas.selecionarMinhaConta(dadosTransf);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem());

        transferirFunc.iniciarAgendamentoTransferenciaComGranaDeEmergencia(dataAgendamento, dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino());

        transferirFunc.selecionarTipoTransferencia(dadosTransf.recuperarTipoTransferencia());

        transferirFunc.selecionarMotivoTransferencia(motivo);

        transferirFunc.validarTransferir(dadosTransf, motivo);

        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_DE_TRANSFERENCIA_DATA_ATUAL);

        transferirFunc.validarComprovanteAgendamentoTransferencia();

        menu.validarTelaMenu();

    }
}
