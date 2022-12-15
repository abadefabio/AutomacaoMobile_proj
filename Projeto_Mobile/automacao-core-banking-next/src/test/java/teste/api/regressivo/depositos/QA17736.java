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
    public class QA17736 extends TesteBase {

        private ProvissionamentoDeSaqueFunc provissionamento = new ProvissionamentoDeSaqueFunc();

        @Test(description = "CONSULTA AGENDAMENTO DE SAQUE COM CONTA INVALIDA")
        @Description("VALIDAR MENSAGEM DE RETORNO DE CONSULTA DE AGENDAMENTO DE SAQUE COM CONTA INVALIDA")

        @Severity(SeverityLevel.NORMAL)

        public void QA17736() throws Exception {
            consultaConta(TipoConta.CONTA_NEXT_CPF,recuperarMassa(JSON.CPF));

            provissionamento.consultaProvisionamento(
                    recuperarMassa(JSON.CPF),
                    DadosConta.recuperarDadosConta(Conta.AGENCIA),
                    recuperarMassa("conta"),
                    recuperarMassa("dataHoraInclusaoSolicitacao"),
                    CodigosRetorno.UNPROCESSABLE_ENTITY.getCodigo());

            provissionamento.validarMensagemDeRetorno(
                    MensagemRetornoMcir.CONSULTA_CODIGO_DA_CONTA_INVALIDO.getCodigoRetorno(),
                    MensagemRetornoMcir.CONSULTA_CODIGO_DA_CONTA_INVALIDO.getMensagemRetorno());
        }
    }

