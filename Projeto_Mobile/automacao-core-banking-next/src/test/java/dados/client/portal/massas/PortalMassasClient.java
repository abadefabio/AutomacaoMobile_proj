package dados.client.portal.massas;

import br.com.bradesco.next.test.data.provider.client.api.*;
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
        client.setConnectTimeout(120, TimeUnit.SECONDS);
        client.setReadTimeout(120, TimeUnit.SECONDS);

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

    public TestDataCardControllerApi testDataCardControllerApi() {
        return new TestDataCardControllerApi(apiClient);
    }

    public TestDataAccountControllerApi testDataAccountControllerApi() {
        return new TestDataAccountControllerApi(apiClient);
    }

    public TestDataInvestmentControllerApi testDataInvestmentControllerApi() {
        return new TestDataInvestmentControllerApi(apiClient);
    }

    public TestDataContactControllerApi testDataContactControllerApi() {
        return new TestDataContactControllerApi(apiClient);
    }
}
