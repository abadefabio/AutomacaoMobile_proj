package br.com.next.automacao.core.api.data.migration;

import io.restassured.http.Header;
import org.json.simple.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataMigrationJobsAtributos {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static JSONObject obterCorpoRequisicaoJob(String jobName, LocalDateTime startTime, LocalDateTime endTime, boolean isDelta) {

        JSONObject requisicao = new JSONObject();
        JSONObject params = new JSONObject();

        params.put("startDateTime", startTime.format(formatter));
        params.put("endDateTime", endTime.format(formatter));
        params.put("isDeltaMigration", isDelta);

        requisicao.put("jobName", jobName);
        requisicao.put("params", params);


        return requisicao;
    }

    public static Header[] obterHeadersJobs(String esteira) {
        return new Header[] {
                new Header("core-ip", esteira),
                new Header("Content-Type", "application/json;charset=UTF-8")
        };
    }

}
