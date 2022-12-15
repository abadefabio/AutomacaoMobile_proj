package funcionalidade.web.contingencia.migration;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.exception.NextException;
import constantes.data.migration.DataMigrationJobs;
import pagina.api.data.migration.DataMigrationServico;

public class DataMigrationFunc extends FuncionalidadeBase {

    Integer executionIdSecurityJob;
    DataMigrationServico dataMigrationServico = new DataMigrationServico();
    DataMigrationServico.JobsParalelos jobsParalelos;

    public void iniciarJobs() throws NextException {
        jobsParalelos = dataMigrationServico
                .iniciarDataMigration(DataMigrationJobs.TIMEOUT_FINALIZACAO, DataMigrationJobs.PARAMETROS_JOBS);

    }

    public void aguardarJobs() throws NextException {
        new DataMigrationServico()
                .aguardarJobFinalizar(DataMigrationJobs.TIMEOUT_FINALIZACAO,
                        jobsParalelos.obterExecutionIdSecurityJob());
    }

}
