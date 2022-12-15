package dados.base;

import br.com.bradesco.next.test.data.provider.client.api.TestDataAccountControllerApi;
import br.com.bradesco.next.test.data.provider.client.api.TestDataCardControllerApi;
import br.com.bradesco.next.test.data.provider.client.api.TestDataContactControllerApi;
import br.com.bradesco.next.test.data.provider.client.api.TestDataOnboardingControllerApi;
import br.com.bradesco.next.test.data.provider.client.api.TestDataOnboardingJoyControllerApi;
import br.com.bradesco.next.test.data.provider.client.api.TestDataOnboardingJoyMultibankControllerApi;
import br.com.bradesco.next.test.data.provider.client.invoker.ApiClient;
import br.com.next.automacao.core.tools.ReadProperties;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class PortalMassasClient {

    ApiClient apiClient;

    public PortalMassasClient() {
        init();
    }

    private void init() {
        apiClient = new ApiClient()
                .setBasePath(ReadProperties.getCaUrl());
        apiClient.setHttpClient(defineTimeConnect());
    }

    private OkHttpClient defineTimeConnect() {

        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10*60, TimeUnit.SECONDS);
        client.setReadTimeout(10*60, TimeUnit.SECONDS);

        return client;
    }

    public static String getCoreIP() {
        var ambiente = ReadProperties.getAmbiente();
        if (ambiente.toLowerCase().trim().equals("ti")) {
            return "ti-lado-a";
        } else {
            return "seven-samurai";
        }
    }

    public static String getEsteira() {
        return ReadProperties.getEsteira();
    }

    public static String getCsrUserId() {
        return ReadProperties.getEmuladorUser();
    }

    public static String getCsrUserPassword() {
        return ReadProperties.getEmuladorPass();
    }
    public TestDataOnboardingControllerApi testDataOnboardingControllerApi() {
        return new TestDataOnboardingControllerApi(apiClient);
    }

    public TestDataOnboardingJoyControllerApi testDataOnboardingJoyControllerApi() {
        return new TestDataOnboardingJoyControllerApi(apiClient);
    }

    public TestDataCardControllerApi testDataCardControllerApi() {
        return new TestDataCardControllerApi(apiClient);
    }

    public TestDataAccountControllerApi testDataAccountControllerApi() {
        return new TestDataAccountControllerApi(apiClient);
    }

    public TestDataContactControllerApi testDataContactControllerApi() {
        return new TestDataContactControllerApi(apiClient);
    }

    public TestDataOnboardingJoyMultibankControllerApi testDataOnboardingJoyMultibankControllerApi() {
        return new TestDataOnboardingJoyMultibankControllerApi(apiClient);
    }
}
