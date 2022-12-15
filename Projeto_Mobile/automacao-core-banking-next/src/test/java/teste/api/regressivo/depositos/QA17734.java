package teste.api.regressivo.depositos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.CodigosRetorno;
import constantes.MensagemRetornoMcir;
import funcionalidade.depositos.ProvissionamentoDeSaqueFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.DEPOSITOS_E_SAQUES)
    public class QA17734 extends TesteBase {

        private ProvissionamentoDeSaqueFunc provissionamento = new ProvissionamentoDeSaqueFunc();

        @Test(description = "CONSULTAR AGENDAR SAQUE COM SUCESSO VALOR ENTRE 50MIL E 999MIL, SEM AGENDAMENTO NA MESMA DATA")
        @Description("VALIDAR MENSAGEM DE RETORNO DE AGENDAMENTO DE SAQUE COM SUCESSO")

        @Severity(SeverityLevel.NORMAL)

        public void QA17734() throws Exception {

            provissionamento.consultaProvisionamento(
                    recuperarMassa("cpf"),
                    recuperarMassa("agencia"),
                    recuperarMassa("conta"),
                    recuperarMassa("dataHoraConsulta"),
                    CodigosRetorno.OK.getCodigo());

            provissionamento.validarMensagemDeConsultaComSucesso(
                    MensagemRetornoMcir.CONSULTA_EFETUADA_COM_SUCESSO.getCodigoRetorno(),
                    MensagemRetornoMcir.CONSULTA_EFETUADA_COM_SUCESSO.getMensagemRetorno(),
                    recuperarMassa("cpf"),
                    recuperarMassa("agencia"),
                    recuperarMassa("conta"),
                    recuperarMassa("dataHoraInclusaoSolicitacao"),
                    recuperarMassa("dataHoraConsulta"),
                    recuperarMassa("valorSolicitacao"),
                    recuperarMassa("codigoProtocolo"));
        }
    }

