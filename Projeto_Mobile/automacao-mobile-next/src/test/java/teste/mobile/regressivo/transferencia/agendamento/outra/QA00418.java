package teste.mobile.regressivo.transferencia.agendamento.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.MensagensEsperadas;
import constantes.transferencia.TipoDeConta;
import constantes.transferencia.TipoTransferencia;
import constantes.transferencia.TransferenciaMotivo;
import constantes.transferencia.ValorTransferencia;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import funcionalidade.mobile.transferencia.para.mim.NovasContasFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


@Jornada(Jornadas.TRANSFERENCIA)
public class QA00418 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc operacaoTransferencia = new TransferirFunc();
    private NovasContasFunc novaContas = new NovasContasFunc();


    @Test(description = "REG.TRF.15.04.04 - Validar AGENDAMENTO - Outra Pessoa - TED - Poupan�a para Conta Corrente - Sem Saldo dispon�vel - Outros Bancos - PF ")
    @Description("Objetivos: \n" +
            " Validar agendamento para outra pessoa PF do tipo TED, De Poupan�a Next Para Conta Corrente Outros bancos, cliente sem saldo dispon�vel.\n" +
            " \n" +
            "Pr�-Requisitos:\n" +
            " Obter aplicativo do next instalado;\n" +
            "Possuir conta ativa no next;\n" +
            "Possuir contato cadastrado outros bancos PF para realizar transfer�ncia;\n" +
            "N�o possuir saldo em conta;\n" +
            "Ter cadastro no PACL.\n" +
            " \n" +
            "P�s-Condi��es:\n" +
            " Agendamento de transfer�ncia outra pessoa PF do tipo TED, entre Poupan�a Next e Conta Corrente Outros bancos.\n" +
            " \n" +
            "Evidencias necess�rias:\n" +
            "Todo o fluxo at� as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00418() throws Exception {

        String cpf = recuperarMassa(JSON.CPF);
        JSONObject contaPagamento = atualizarContaPagamento(recuperarJSSONMassa("contaPagamento"));

        login.efetuarLoginUsuarioExistente(cpf, recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(contaPagamento.get("transferirPara").toString());

        outraPessoa.selecionarContaContatoPF(contaPagamento.get("nome").toString(), contaPagamento.get("sobreNome").toString(), contaPagamento.get("cpfConta").toString(), contaPagamento.get("numeroBanco").toString(), contaPagamento.get("agencia").toString(), contaPagamento.get("conta").toString());

        operacaoTransferencia.iniciarAgendamentoTransferencia();

        operacaoTransferencia.selecionarMotivoTransferencia(contaPagamento.get("finalidade").toString());

        operacaoTransferencia.validarTransferir(contaPagamento);
        operacaoTransferencia.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_AGENDAMENTO_TRANSFERENCIA);
        operacaoTransferencia.validarTelaComprovanteAgendamentoTransferencia();

    }

    private JSONObject atualizarContaPagamento(JSONObject contaPagamento) {

        contaPagamento.put("tipoContaOrigem", TipoDeConta.CONTA_POUPANCA);
        contaPagamento.put("tipoTransferencia", TipoTransferencia.TED);
        contaPagamento.put("tipoContaDestino", TipoDeConta.CONTA_CORRENTE);
        contaPagamento.put("valor", ValorTransferencia.VALOR_ALEATORIO_100_A_500);
        contaPagamento.put("transferirPara", TransferirPara.OUTRA_PESSOA);
        contaPagamento.put("finalidade", TransferenciaMotivo.CREDITO_EM_CONTA);

        return contaPagamento;
    }
}
