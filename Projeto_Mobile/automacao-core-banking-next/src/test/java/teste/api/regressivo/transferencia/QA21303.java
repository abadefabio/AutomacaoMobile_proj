package teste.api.regressivo.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.transferencia.ListarTransferenciasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.time.Instant;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21303 extends TesteBase {

    private ListarTransferenciasFunc listarTransferencias = new ListarTransferenciasFunc();

    @Test(description = "Lista de transferências programadas/agendadas sem range de pesquisa")
    @Description("VALIDAR MENSAGEM DE RETORNO")
    @Severity(SeverityLevel.NORMAL)
    public void QA21303() throws Exception {

        listarTransferencias.listarTransferenciasProgramadasAgendadas(
                recuperarMassa(JSON.CPF),
                "",
                "")
            .validarListaTransferenciasSemRangePesquisa();
    }
}
