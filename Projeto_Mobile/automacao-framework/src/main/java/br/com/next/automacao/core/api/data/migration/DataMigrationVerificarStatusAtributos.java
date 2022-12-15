package br.com.next.automacao.core.api.data.migration;

import io.restassured.http.Header;

import java.time.format.DateTimeFormatter;

public class DataMigrationVerificarStatusAtributos {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static Header[] obterHeadersStatusJob() {
        return new Header[] {
                new Header("Content-Type", "application/json;charset=UTF-8"),
                new Header("x-content-type-options", "nosniff"),
                new Header("x-xss-protection", "1; mode=block"),
                new Header("cache-control", "no-cache, no-store, max-age=0, must-revalidate"),
                new Header("pragma", "no-cache"),
                new Header("expires", "0"),
                new Header("x-frame-options", "DENY"),
                new Header("Content-Encoding", "gzip"),
                new Header("Server", "None")
        };
    }

}
