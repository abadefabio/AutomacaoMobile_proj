package br.com.next.automacao.core.api.data.migration;

import br.com.next.automacao.core.base.api.DadosRequisicaoBase;
import br.com.next.automacao.core.base.api.RequisicaoBase;
import br.com.next.automacao.core.base.api.RespostaBase;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.ReadProperties;

import java.time.LocalDateTime;

import static br.com.next.automacao.core.constantes.MetodoRequisicao.GET;
import static br.com.next.automacao.core.constantes.MetodoRequisicao.POST;

public class DataMigrationApi {

    private static final String esteira = ReadProperties.getEsteira();
    private static final String uri = ReadProperties.getCaUrl();
    private static final String caminhoRequisicao = "/v1/data-migration/batch/queue";

    /**
     * Executa um job do Data Migration
     * @param jobName
     * @return executionId
     * @throws NextException
     */
    public static RespostaBase executarJob(String jobName,
                           LocalDateTime startDateTime,
                           LocalDateTime endDateTime,
                           boolean isDeltaMigration) throws NextException {
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .definirHeaders(DataMigrationJobsAtributos.obterHeadersJobs(esteira))
                .definirCorpoRequisicao(
                        DataMigrationJobsAtributos.obterCorpoRequisicaoJob(
                                jobName,
                                startDateTime,
                                endDateTime,
                                isDeltaMigration
                        )
                )
                /*
                Notar que o caminho da requisição não deve conter
                a barra normal (/) no final, caso contrário seria
                gerado um erro interno do servidor - 500.
                 */
                .definirCaminhoRequisicao(caminhoRequisicao);

        return RequisicaoBase.executarRequisicao(dadosRequisicaoBase, POST);
    }

    /**
     * Retorna status da execução de um job
     * @param executionId
     * @return status
     * @throws NextException
     */
    public static RespostaBase executarVerificarStatusJob(int executionId) throws NextException {
        DadosRequisicaoBase dadosRequisicaoBase = new DadosRequisicaoBase(uri);
        dadosRequisicaoBase
                .definirHeaders(DataMigrationVerificarStatusAtributos.obterHeadersStatusJob())
                /*
                Notar que a barra no final do caminho é necessária para esta requisição
                mas não para a requisição de iniciar um job.
                 */
                .definirCaminhoRequisicao(caminhoRequisicao + "/" + executionId);

        return RequisicaoBase
                .executarRequisicao(dadosRequisicaoBase, GET);
    }

}
