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
    public class QA18283 extends TesteBase {

    private ProvissionamentoDeSaqueFunc provissionamento = new ProvissionamentoDeSaqueFunc();

    @Test(description = "EXCLUSÃO DE PROVISIONAMENTO DE SAQUE FORA DA DATA PERMITIDA")
    @Description("VALIDAR MENSAGEM DE RETORNO DE TENTATIVA DE EXCLUSÃO FORA DA DATA PERMITIDA")

    @Severity(SeverityLevel.NORMAL)

    public void QA18283() throws Exception {
        consultaConta(TipoConta.CONTA_NEXT_CPF,recuperarMassa(JSON.CPF));

        provissionamento.ExclusaoProvisionamentoDeSaque(
                recuperarMassa(JSON.CPF),
                DadosConta.recuperarDadosConta(Conta.AGENCIA),
                DadosConta.recuperarDadosConta(Conta.CONTA),
                recuperarMassa("dataHoraInclusaoSolicitacao"),
                CodigosRetorno.UNPROCESSABLE_ENTITY.getCodigo());

        provissionamento.validarMensagemDeRetorno(
                MensagemRetornoMcir.DT_EXCL_DEVE_SER_ATE_1_DIA_ANTES_DO_SAQUE.getCodigoRetorno(),
                MensagemRetornoMcir.DT_EXCL_DEVE_SER_ATE_1_DIA_ANTES_DO_SAQUE.getMensagemRetorno());
    }

}
