package teste.api.regressivo.transferencia;

import org.testng.annotations.Test;
import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.transferencia.ListarInstrucoesTransferenciaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21999 extends TesteBase {
    ListarInstrucoesTransferenciaFunc listarInstrucoesTransferencia = new ListarInstrucoesTransferenciaFunc();

    @Test(description = "Exibir instruções de transferência")
    @Description("VALIDAR MENSAGEM DE RETORNO")
    @Severity(SeverityLevel.NORMAL)
    public void QA21999() throws Exception {
        listarInstrucoesTransferencia.listarInstrucoesTransferencia(recuperarMassa(JSON.CPF));
        listarInstrucoesTransferencia.validarInstrucoesTransferencia();
    }
}
