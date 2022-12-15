package teste.api.regressivo.depositos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.massa.conta.Conta;
import br.com.next.automacao.core.constantes.massa.conta.TipoConta;
import br.com.next.automacao.core.massa.conta.DadosConta;
import constantes.CodigosRetorno;
import constantes.MensagemRetornoMcir;
import funcionalidade.depositos.ProvissionamentoDeSaqueFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.massa.conta.ConsultaConta.consultaConta;

@Jornada(Jornadas.DEPOSITOS_E_SAQUES)
    public class QA17735 extends TesteBase {

        private ProvissionamentoDeSaqueFunc provissionamento = new ProvissionamentoDeSaqueFunc();

        @Test(description = "CONSULTA AGENDAMENTO DE SAQUE COM AGENCIA INVALIDA")
        @Description("VALIDAR MENSAGEM DE RETORNO DE CONSULTA DE AGENDAMENTO DE SAQUE COM AGENCIA INVALIDA")

        @Severity(SeverityLevel.NORMAL)

        public void QA17735() throws Exception {
            consultaConta(TipoConta.CONTA_NEXT_CPF,recuperarMassa(JSON.CPF));

            provissionamento.consultaProvisionamento(
                    recuperarMassa(JSON.CPF),
                    recuperarMassa("agencia"),
                    DadosConta.recuperarDadosConta(Conta.CONTA),
                    recuperarMassa("dataHoraInclusaoSolicitacao"),
                    CodigosRetorno.UNPROCESSABLE_ENTITY.getCodigo());

            provissionamento.validarMensagemDeRetorno(
                    MensagemRetornoMcir.CODIGO_DO_PRODUTO_INEXISTENTE.getCodigoRetorno(),
                    MensagemRetornoMcir.CODIGO_DO_PRODUTO_INEXISTENTE.getMensagemRetorno());
        }
    }

