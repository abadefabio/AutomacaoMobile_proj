package teste.api.regressivo.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.massa.conta.TipoConta;
import constantes.CodigosRetorno;
import funcionalidade.transferencia.ListarTransferenciasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.massa.conta.ConsultaConta.consultaConta;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21300 extends TesteBase {

    private ListarTransferenciasFunc listarTransferenciasFunc = new ListarTransferenciasFunc();

    @Test(description = "Lista de transferências programadas/agendadas com resultado")
    @Description("VALIDAR MENSAGEM DE RETORNO")
    @Severity(SeverityLevel.NORMAL)
    public void QA21300() throws Exception {
        listarTransferenciasFunc.listarTransferenciasProgramadasAgendadas(
                recuperarMassa(JSON.CPF),
                "2022-06-23T13:26:17.926892300Z",
                "2022-11-23T13:26:17.926892300Z");

        listarTransferenciasFunc.validarStatusResposta(CodigosRetorno.OK.getCodigo());
    }

}
