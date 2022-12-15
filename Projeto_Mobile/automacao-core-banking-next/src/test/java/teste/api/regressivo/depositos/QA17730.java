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
import static br.com.next.automacao.core.tools.Utilitarios.proximoFeriadoDiaDaSemama;

@Jornada(Jornadas.DEPOSITOS_E_SAQUES)
    public class QA17730 extends TesteBase {

        private ProvissionamentoDeSaqueFunc provissionamento = new ProvissionamentoDeSaqueFunc();

        @Test(description = "AGENDAR SAQUE NO FERIADO")
        @Description("VALIDAR MENSAGEM DE RETORNO DE AGENDAMENTO DE SAQUE NO FERIADO")

        @Severity(SeverityLevel.NORMAL)

        public void QA17730() throws Exception {
            consultaConta(TipoConta.CONTA_NEXT_CPF,recuperarMassa(JSON.CPF));
            provissionamento.inclusaoProvisionamento(
                    recuperarMassa(JSON.CPF),
                    DadosConta.recuperarDadosConta(Conta.AGENCIA),
                    DadosConta.recuperarDadosConta(Conta.CONTA),
                    proximoFeriadoDiaDaSemama("yyyy-MM-dd"),
                    recuperarMassa("valorSaque"),
                    CodigosRetorno.UNPROCESSABLE_ENTITY.getCodigo());

            provissionamento.validarMensagemDeRetorno(
                    MensagemRetornoMcir.DATA_DE_INCLUSAO_INVALIDA.getCodigoRetorno(),
                    MensagemRetornoMcir.DATA_DE_INCLUSAO_INVALIDA.getMensagemRetorno());
        }
    }

