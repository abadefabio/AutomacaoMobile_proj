package teste.api.regressivo.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.massa.conta.TipoConta;
import constantes.CodigosRetorno;
import funcionalidade.transferencia.ListarContatoFunc;
import funcionalidade.transferencia.ListarTransferenciasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.massa.conta.ConsultaConta.consultaConta;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21306 extends TesteBase {

    private ListarTransferenciasFunc listarTransferenciasFunc = new ListarTransferenciasFunc();

    @Test(description = "Obter recibo de transferência efetivadas sem sucesso")
    @Description("VALIDAR MENSAGEM DE RETORNO")

    @Severity(SeverityLevel.NORMAL)

    public void QA21306() throws Exception {

        consultaConta(TipoConta.CONTA_NEXT_CPF,recuperarMassa(JSON.CPF));

        listarTransferenciasFunc.listarRecibosTransferenciasEfetivadasSemSucesso
                (recuperarMassa(JSON.CPF),
                 recuperarMassa("transferId"),
                 recuperarMassa("transferDate"));

        listarTransferenciasFunc.validarRetornoReciboTransferenciaSemSucesso();
    }
}
