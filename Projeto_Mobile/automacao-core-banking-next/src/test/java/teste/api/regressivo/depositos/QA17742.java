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
    public class QA17742 extends TesteBase {

        private ProvissionamentoDeSaqueFunc provissionamento = new ProvissionamentoDeSaqueFunc();

        @Test(description = "CONSULTA LISTA DE PROVISIONAMENTO DE SAQUE PERIODO M-3")
        @Description("VALIDAR MENSAGEM DE RETORNO COM RESULTADOS DA LISTA DE PROVISIONAMENTO DE SAQUE DO PERIODO M-3")

        @Severity(SeverityLevel.NORMAL)

        public void QA17742() throws Exception {
            consultaConta(TipoConta.CONTA_NEXT_CPF,recuperarMassa(JSON.CPF));

            provissionamento.inclusaoProvisionamento(
                    recuperarMassa(JSON.CPF),
                    DadosConta.recuperarDadosConta(Conta.AGENCIA),
                    DadosConta.recuperarDadosConta(Conta.CONTA),
                    retornaDataDiaUtil(1, "yyyy-MM-dd"),
                    recuperarMassa("valorSaque"),
                    CodigosRetorno.OK.getCodigo());

            provissionamento.ConsultaListaProvisionamentoDeSaque(
                    recuperarMassa(JSON.CPF),
                    DadosConta.recuperarDadosConta(Conta.AGENCIA),
                    DadosConta.recuperarDadosConta(Conta.CONTA),
                    retornaDataDiaUtil(-58, "yyyy-MM-dd"),
                    retornaDataDiaUtil(1, "yyyy-MM-dd"),
                    CodigosRetorno.OK.getCodigo());

            provissionamento.validarMensagemDeRetornoListaProvisionamentoDeSaque(
                    MensagemRetornoMcir.CONSULTA_EFETUADA_COM_SUCESSO.getCodigoRetorno(),
                    MensagemRetornoMcir.CONSULTA_EFETUADA_COM_SUCESSO.getMensagemRetorno(),
                    DadosConta.recuperarDadosConta(Conta.AGENCIA),DadosConta.recuperarDadosConta(Conta.CONTA));
        }
    }

