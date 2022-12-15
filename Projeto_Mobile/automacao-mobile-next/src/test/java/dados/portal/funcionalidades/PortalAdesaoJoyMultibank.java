package dados.portal.funcionalidades;

import br.com.bradesco.next.test.data.provider.client.invoker.ApiException;
import br.com.bradesco.next.test.data.provider.client.model.AvailableCustomerOnboardingJoyMultibankResponse;
import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingJoyMultibankRequest;
import br.com.bradesco.next.test.data.provider.client.model.CreateOnboardingJoyMultibankResponse;
import br.com.bradesco.next.test.data.provider.client.model.GetAvailableCustomerOnboardingJoyMultibankRequest;
import br.com.bradesco.next.test.data.provider.client.model.GetAvailableCustomerOnboardingJoyMultibankResponse;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import constantes.adesao.multibank.Config;
import dados.database.ContaMultibankSelecaoExternalCustomer;
import dados.portal.base.BasePortalFunc;
import dados.portal.base.PortalMassasClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static constantes.adesao.multibank.Config.MAX_REGISTROS_RETORNADOS_API_CONSULTA_CPFS;
import static dados.portal.base.PortalMassasClient.getCoreIP;
import static dados.portal.base.PortalMassasClient.getCsrUserId;
import static dados.portal.base.PortalMassasClient.getCsrUserPassword;
import static dados.portal.base.PortalMassasClient.getEsteira;
import static dados.portal.utils.PortalMassasUtil.alterPropertiesJsonObject;
import static dados.portal.utils.PortalMassasUtil.convertResponseJsonObject;
import static java.util.Objects.isNull;

public class PortalAdesaoJoyMultibank extends BasePortalFunc {

    int maxTentativas = Config.MAX_TENTATIVAS_TESTE;

    public JSONObject criarAdesaoJoyMultibankVariasTentativas(JSONObject arquivoJson, String minDependentesAtuais, String maxDependentesAtuais) {
        return (JSONObject) executarPortal("Criar adesão Joy Multibank",
                new JSONObject() {{
                }},
                () -> {
                    JSONObject json = null;

                    // -------- Tentativas de realizar a adesão --------
                    List<String> cpsUtilizados = new ArrayList<>();
                    while (isNull(json) && maxTentativas > 0) {
                        try {

                            var customer = new PortalAdesaoJoyMultibank().encontrarCpfMultibancoAdesaoJoy(
                                    cpsUtilizados,
                                    Integer.parseInt(minDependentesAtuais),
                                    Integer.parseInt(maxDependentesAtuais)
                            );
                            json = new PortalAdesaoJoyMultibank().criarAdesaoJoyMultibank(Objects.requireNonNull(customer), arquivoJson);
                            maxTentativas--;
                        } catch (Exception ignored) {
                        }
                    }
                    // -------- Fim das tentativas de realizar a adesão -------

                    if (isNull(json))
                        throw new NextException("Não foi possível gerar a adesão multibanco. Verifique os logs para saber a causa.", new Exception());

                    return json;
                });
    }

    private AvailableCustomerOnboardingJoyMultibankResponse encontrarCpfMultibancoAdesaoJoy(List<String> cpsUtilizados, int minDependentesAtuais, int maxDependentesAtuais) throws Exception {
        var body = new GetAvailableCustomerOnboardingJoyMultibankRequest();
        body.setMaxDependent(maxDependentesAtuais);
        body.setMinDependent(minDependentesAtuais);
        body.setTotalCustomers(MAX_REGISTROS_RETORNADOS_API_CONSULTA_CPFS);

        GetAvailableCustomerOnboardingJoyMultibankResponse response;
        try {
            response = new PortalMassasClient()
                    .testDataOnboardingJoyMultibankControllerApi()
                    .findAvailableCustomerJoyMultibank(getCoreIP(),
                            getEsteira(),
                            body);
        } catch (ApiException ignored) {
            return null;
        }

        if (maxTentativas == Config.MAX_TENTATIVAS_TESTE)
            throw new NextException("Tentativa máxima excedida", new Exception());

        AvailableCustomerOnboardingJoyMultibankResponse customer = null;
        int indiceAleatorio;
        int maxTentativas = response.getCustomers().size();
        while (maxTentativas > 0) {
            indiceAleatorio = (int) Math.floor(Math.random() * (response.getCustomers().size()));
            customer = response.getCustomers().get(indiceAleatorio);
            String cpf = customer.getCpf();
            if (cpsUtilizados.contains(cpf)) {
                maxTentativas--;
                continue;
            }
            cpsUtilizados.add(cpf);
            break;
        }

        if (isNull(customer)) // sem massa disponível
            throw new NextException("Não foi possível obter massa de responsável válida!", new Exception());

        return customer;
    }

    private JSONObject criarAdesaoJoyMultibank(AvailableCustomerOnboardingJoyMultibankResponse customer, JSONObject arquivoJson) {

        String cpf = customer.getCpf();
        int digitos = cpf.length();
        int size = 11;

        if (digitos < size) {
            cpf = String.format("%011d", Integer.parseInt(cpf));
        }

        CreateOnboardingJoyMultibankRequest body = new CreateOnboardingJoyMultibankRequest();
        body.setDeviceId(customer.getCustomerIdResponsavel());
        body.setDocument(cpf);
        body.setHashId(customer.getIdCustomerResponsavel());

        CreateOnboardingJoyMultibankResponse response = null;
        try {
            response = new PortalMassasClient()
                    .testDataOnboardingJoyMultibankControllerApi()
                    .createOnboardingJoyMultibank(getCoreIP(),
                            getEsteira(),
                            getCsrUserId(),
                            getCsrUserPassword(),
                            body);
        } catch (ApiException e) {
            OperadorEvidencia.logarPasso(e.getResponseBody().toString());
            return null;
        }

        OperadorEvidencia.logarPasso(String.format("[PORTAL DE MASSA]: Massa adesao response: %s", response));

        JSONObject onboardingResponseJson = null;
        try {
            onboardingResponseJson = convertResponseJsonObject(response);
        } catch (JsonProcessingException | ParseException e) {
            return null;
        }

        return alterPropertiesJsonObject(onboardingResponseJson, arquivoJson);
    }

    /**
     * @param externalCustomer
     * @param arquivoJson
     * @return
     * @throws Exception
     */
    public JSONObject criarAdesaoJoyMultibank(ContaMultibankSelecaoExternalCustomer.ExternalCustomer externalCustomer, JSONObject arquivoJson) throws Exception {
        var response = executarPortal("Criar adesão joy multibank",
                new JSONObject() {{
                }},
                () -> {
                    CreateOnboardingJoyMultibankRequest body = new CreateOnboardingJoyMultibankRequest();
                    body.setDeviceId(externalCustomer.getCustomerIdResponsavel());
                    body.setDocument(externalCustomer.getCpfResponsavel());
                    body.setHashId(externalCustomer.getIdClienteResponsavel());

                    return new PortalMassasClient()
                            .testDataOnboardingControllerApi()
                            .createOnboardingJoyMultibank(getCoreIP(),
                                    getEsteira(),
                                    getCsrUserId(),
                                    getCsrUserPassword(),
                                    body);
                });

        var onboardingResponseJson = convertResponseJsonObject(response);
        return alterPropertiesJsonObject(onboardingResponseJson, arquivoJson);
    }
}
