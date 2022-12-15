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
import static br.com.next.automacao.core.tools.Utilitarios.retornaDataDiaUtil;

@Jornada(Jornadas.DEPOSITOS_E_SAQUES)
    public class QA17702 extends TesteBase {

        private ProvissionamentoDeSaqueFunc provissionamento = new ProvissionamentoDeSaqueFunc();

        @Test(description = "AGENDAR SAQUE COM SUCESSO VALOR ENTRE 50MIL E 999MIL, SEM AGENDAMENTO NA MESMA DATA")
        @Description("VALIDAR MENSAGEM DE RETORNO DE AGENDAMENTO DE SAQUE COM SUCESSO")

        @Severity(SeverityLevel.NORMAL)

        public void QA17702() throws Exception {
            consultaConta(TipoConta.CONTA_NEXT_CPF,recuperarMassa(JSON.CPF));
            provissionamento.inclusaoProvisionamento(
                    recuperarMassa(JSON.CPF),
                    DadosConta.recuperarDadosConta(Conta.AGENCIA),
                    DadosConta.recuperarDadosConta(Conta.CONTA),
                    retornaDataDiaUtil(2, "yyyy-MM-dd"),
                    recuperarMassa("valorSaque"),
                    CodigosRetorno.OK.getCodigo());

            provissionamento.validarMensagemDeInculsaoComSucesso(
                    MensagemRetornoMcir.INCLUSAO_EFETUADA_COM_SUCESSO.getCodigoRetorno(),
                    MensagemRetornoMcir.INCLUSAO_EFETUADA_COM_SUCESSO.getMensagemRetorno(),
                    recuperarMassa(JSON.CPF),
                    DadosConta.recuperarDadosConta(Conta.AGENCIA),
                    DadosConta.recuperarDadosConta(Conta.CONTA));
        }
    }

