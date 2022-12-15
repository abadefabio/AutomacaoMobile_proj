package pagina.api.data.migration;

import br.com.next.automacao.core.api.data.migration.DataMigrationApi;
import br.com.next.automacao.core.base.TesteNext;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import constantes.data.migration.DataMigrationJobs;
import org.testng.Reporter;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

public class DataMigrationServico {

    private final int EXECUTION_ID_INVALIDO = -1;

    static void logarPasso(String texto) {
        Reporter.log(texto, true);
    }

    /**
     * Executa Customer Job
     *
     * @return executionId
     * @throws NextException
     * @params jobName, parametros
     */
    public Integer executarJob(DataMigrationJobs jobName, DataMigrationJobs parametros) {

        int executionId = EXECUTION_ID_INVALIDO;
        try {
            logarPasso("Preparando para executar job " + jobName);
            RespostaBase respostaBase = DataMigrationApi.executarJob(
                    jobName.toString(),
                    parametros.obterHoraInicial(),
                    parametros.obterHoraFinal(),
                    parametros.isDeltaMigration());

            Integer statusCode = respostaBase.getResponse().statusCode();
            if (!ValueRange.of(200, 202).isValidIntValue(statusCode)) {
                logarPasso("Job " + jobName + " retornou o status code " + statusCode);
                return EXECUTION_ID_INVALIDO;
            }
            executionId = respostaBase.obterJsonPath().getInt("executionId");
            logarPasso("Execution Id " + executionId + " -> " + jobName);

        } catch (NextException ne) {
            ne.printStackTrace();
        }
        return executionId;
    }

    /**
     * Executa Customer Job e Security Job
     *
     * @return executionId do Security Job
     * @throws NextException
     * @params parametros
     */
    public JobsParalelos iniciarDataMigration(DataMigrationJobs timeout, DataMigrationJobs parametros) {

        JobsParalelos jobsParalelos = new JobsParalelos();
        /*
        Executamos ambos Customer Job e Security Job em thread à parte
        para não termos que esperar a dependência entre eles
        e seguir com o teste mobile enquanto isto,
        e tomamos o executionId apenas do Security Job
        para verificar mais tarde se este também finalizou.
         */
        jobsParalelos.passarParametros(timeout, parametros);
        jobsParalelos.start();
        return jobsParalelos;
    }

    /**
     * Verifica se todos os jobs foram finalizados
     *
     * @param executionIds
     * @return boolean
     * @throws NextException
     */
    public boolean verificarJobFinalizado(Integer... executionIds) {

        try {
            List<Boolean> listaStatusCompletado = new ArrayList();
            for (Integer executionId : executionIds) {

                if (executionId == EXECUTION_ID_INVALIDO)
                    continue;

                RespostaBase respostaBase = DataMigrationApi.executarVerificarStatusJob(executionId);

                Integer statusCode = respostaBase.getResponse().statusCode();
                if (!ValueRange.of(200, 202).isValidIntValue(statusCode)) {
                    logarPasso("Job de verificação de status retornou o status code " + statusCode);
                    return false;
                }

                String status = respostaBase.obterJsonPath().getString("status");
                if (status.equals("COMPLETED")) {
                    logarPasso("Job com id " + executionId + " finalizado.");
                    listaStatusCompletado.add(true);
                } else {
                    listaStatusCompletado.add(false);
                }
            }

            for (Boolean statusCompletado : listaStatusCompletado) {
                if (!statusCompletado)
                    return false;
            }
        } catch (NextException ne) {
            ne.printStackTrace();
        }

        return true;
    }

    /**
     * Aguardar job(s) finalizar(em)
     *
     * @param executionIds
     * @return boolean
     * @throws NextException
     */
    public void aguardarJobFinalizar(DataMigrationJobs timeout, Integer... executionIds) {

        long inicio = System.currentTimeMillis();
        boolean jobFinalizado;
        do {
            dormir(500);
            if (System.currentTimeMillis() - inicio > timeout.timeoutTerminoJobs() * 1000L)
                break;
            try {
                jobFinalizado = verificarJobFinalizado(executionIds);
            } catch (AssertionError e) {
                jobFinalizado = false;
            }
        } while (!jobFinalizado);
    }

    /**
     * Método helper para fazer o mesmo que Thread.sleep()
     *
     * @param tempo
     */
    public void dormir(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class JobsParalelos extends Thread {
        Integer executionId;
        DataMigrationJobs timeout;
        DataMigrationJobs parametros;

        public void passarParametros(DataMigrationJobs timeout, DataMigrationJobs parametros) {
            this.timeout = timeout;
            this.parametros = parametros;
        }

        public Integer obterExecutionIdSecurityJob() {
            return this.executionId;
        }

        @Override
        public void run() {
            DataMigrationJobs job;

            /*
            Job para excluir tabela de devices e CPFs - Offboarding
            */
            job = DataMigrationJobs.DATAMIGRATIONSECURITYOFFBOARDINGJOB;
            Integer executionIdSecurityOffBoard = executarJob(job, parametros);
            if (executionIdSecurityOffBoard.equals(EXECUTION_ID_INVALIDO)) {
                logarPasso("Ocorreu um erro com o job " + job);
                executionId = EXECUTION_ID_INVALIDO;
            }

            /*
            Job para excluir tabela de devices e CPFs - Offboarding
            */
            job = DataMigrationJobs.DATAMIGRATIONCUSTOMEROFFBOARDINGJOB;
            Integer executionIdCustomerOffBoard = executarJob(job, parametros);
            if (executionIdCustomerOffBoard.equals(EXECUTION_ID_INVALIDO)) {
                logarPasso("Ocorreu um erro com o job " + job);
                executionId = EXECUTION_ID_INVALIDO;
            }

            /*
            Customer Job primeiro
            */
            job = DataMigrationJobs.DATAMIGRATIONCUSTOMERJOB;
            Integer executionIdCustomerJob = executarJob(job, parametros);
            if (executionIdCustomerJob.equals(EXECUTION_ID_INVALIDO)) {
                logarPasso("Ocorreu um erro com o job " + job);
                executionId = EXECUTION_ID_INVALIDO;
            }
            aguardarJobFinalizar(timeout, executionIdCustomerJob);

            /*
            Job para atualizar os contatos de transferência mobile na WEB
            */
            job = DataMigrationJobs.DATAMIGRATIONCONTACTJOB;
            Integer executionIdContactJob = executarJob(job, parametros);
            if (executionIdContactJob.equals(EXECUTION_ID_INVALIDO)) {
                logarPasso("Ocorreu um erro com o job " + job);
                executionId = EXECUTION_ID_INVALIDO;
            }

            executionId = executionIdContactJob;

            /*
            Depois da finalização do Customer Job, iniciamos
            o Security Job, mas não esperamos mais
            */
            job = DataMigrationJobs.DATAMIGRATIONSECURITYJOB;
            Integer executionIdSecurityJob = executarJob(job, parametros);
            if (executionIdSecurityJob.equals(EXECUTION_ID_INVALIDO)) {
                logarPasso("Ocorreu um erro com o job " + job);
                executionId = EXECUTION_ID_INVALIDO;
            }

            executionId = executionIdSecurityJob;
        }
    }

}
