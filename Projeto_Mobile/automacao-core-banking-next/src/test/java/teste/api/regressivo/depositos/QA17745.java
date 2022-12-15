package teste.api.regressivo.depositos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.CodigosRetorno;
import constantes.MensagemRetornoMcir;
import funcionalidade.depositos.ProvissionamentoDeSaqueFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.DEPOSITOS_E_SAQUES)
    public class QA17745 extends TesteBase {

        private ProvissionamentoDeSaqueFunc provissionamento = new ProvissionamentoDeSaqueFunc();

        @Test(description = "CONSULTA LIMITE ATIVO DO CLIENTE NA MIDIA NEXT")
        @Description("VALIDAR MENSAGEM DE RETORNO DE CONSULTA DE REGRA ATIVA PARA O CLIENTE NEXTO")

        @Severity(SeverityLevel.NORMAL)

        public void QA17745() throws Exception {

            provissionamento.consultaParametroProvisionamentoDeSaque(
                    recuperarMassa(JSON.CPF),
                    CodigosRetorno.OK.getCodigo());

            provissionamento.validarMensagemDeRetornoParametroAtivoNoAmbiente(
                    MensagemRetornoMcir.CONSULTA_EFETUADA_COM_SUCESSO.getCodigoRetorno(),
                    MensagemRetornoMcir.CONSULTA_EFETUADA_COM_SUCESSO.getMensagemRetorno());

        }
    }

