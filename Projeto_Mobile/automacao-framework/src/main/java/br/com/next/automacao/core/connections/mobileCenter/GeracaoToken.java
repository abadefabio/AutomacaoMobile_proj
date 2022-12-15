package br.com.next.automacao.core.connections.mobileCenter;

import br.com.next.automacao.core.connections.login.TokenMobileCenter;
import com.google.gson.Gson;
import com.lowagie.text.pdf.codec.Base64;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.next.automacao.core.connections.Conexao.*;
import static br.com.next.automacao.core.tools.ReadProperties.getClientIdMobileCenter;
import static br.com.next.automacao.core.tools.ReadProperties.getSecretMobileCenter;


/**
 * A class geração token contém:
 * Consulta se existe token,
 * Geração de um novo token
 *
 * @author Joyce Melo
 * @version 1.0
 * @since 2022-01
 */

public class GeracaoToken {

    private static final Gson gson = new Gson();

    private static final boolean naoPossuiClientId = getClientIdMobileCenter().contains("oauthClientId");
    private static final boolean naoPossuiSecret = getSecretMobileCenter().contains("oauthClientSecret");
    private static final boolean  naoExisteClientId = getClientIdMobileCenter().contains("null");

    public static Response createTokenMobileCenter(Response responseConnector) {

        Map<String, String> headers = Map.of("JSESSIONID", responseConnector.getCookie("JSESSIONID"),
                "x-hp4msecret", responseConnector.getCookie("hp4msecret"),
                "tenant-id", responseConnector.getCookie("TENANT_ID_COOKIE"));

        var resultBuscaCredentials = buscaCredenciaisMobileCenter(headers, responseConnector);

        if (naoPossuiClientId && naoPossuiSecret) {

            var resultToken = verificaSeTokenExiste(resultBuscaCredentials).collect(Collectors.toList());
            return validaTokenOuGeraToken(resultToken, headers, resultBuscaCredentials, responseConnector);

        } else if (naoExisteClientId) {
            return geraTokenMobileCenter(headers, responseConnector.getDetailedCookies());
        } else {
            var clientId = new String(Base64.decode(getClientIdMobileCenter()));
            var resultToken = verificaSeTokenExiste(resultBuscaCredentials).filter(x -> x.getClientId().equals(clientId))
                    .collect(Collectors.toList());
            return validaTokenOuGeraToken(resultToken, headers, resultBuscaCredentials, responseConnector);
        }
    }

    private static Response buscaCredenciaisMobileCenter(Map<String, String> headers, Response responseConnector) {
        return buscaCredentialsMobileCenter(headers, responseConnector.getDetailedCookies());
    }

    private static Stream<Credentials> verificaSeTokenExiste(Response resultBusca) {
        return resultBusca.jsonPath()
                .getList(".", Credentials.class)
                .stream().filter(x -> x.getName().equals("AUTOMACAO E2E"));
    }

    private static Response validaTokenOuGeraToken(List<Credentials> resultToken, Map<String, String> headers, Response resultBuscaCredentials, Response responseConnector) {

        var cookies = responseConnector.getDetailedCookies();

        // se a lista possui dados é pq ja existe um token
        if (resultToken.size() > 0) {

            var tokenAutomacao = resultToken.get(0);

            if (naoPodeValidarToken(resultToken)) {
                deleteTokenMobileCenter(headers, cookies, tokenAutomacao.getClientId());
                return geraTokenMobileCenter(headers, cookies);
            } else {
                var clientId = new String(Base64.decode(getClientIdMobileCenter()));
                var secret = new String(Base64.decode(getSecretMobileCenter()));
                var body = new TokenMobileCenter(clientId, secret, tokenAutomacao.getTenant());
                return validaTokenMobileCenter(headers, resultBuscaCredentials.getDetailedCookies(), gson.toJson(body));
            }
        } else {
            return geraTokenMobileCenter(headers, cookies);
        }
    }

    private static  Boolean naoPodeValidarToken(List<Credentials> resultToken) {
        return resultToken.get(0).getSecret() == null ||
                getSecretMobileCenter().equals("oauthClientSecret") || getSecretMobileCenter().equals("null");
    }
}