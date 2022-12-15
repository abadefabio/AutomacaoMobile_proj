package br.com.next.automacao.core.tools.configuracao;

import br.com.next.automacao.core.tools.ssl.DummyTrustManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
/**
 * Testes de
 * login Jira e
 * mobile Center
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */

public class ValidateConnectionsTest {


    @Test(description = "should return status 200 for connection to Jira if vpn is connected or null if off")
    public void connectionJira200Test() {
        var response = testConnectionUrl("https://jira.prebanco.com.br");
        if (response != null) {
            assertNotNull(response);
            assertEquals(200, response.statusCode());
        }
    }

    @Test(description = "should return status 200 for connection to Mobile Center if vpn is connected or null if off")
    public void connectionMobileCenter200Test() {

        var response = testConnectionUrl("https://mobilecenter.net.bradesco.com.br");
        if (response != null) {
            assertNotNull(response);
            assertEquals(200, response.statusCode());
        }

    }

    private HttpResponse<String> testConnectionUrl(String url) {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new DummyTrustManager()},
                    new java.security.SecureRandom());

            HttpClient client = HttpClient.newBuilder()
                    .sslContext(sc)
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .timeout(Duration.ofSeconds(5))
                    .uri(new URI(url))
                    .header("Content-Type", "application/json")
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}