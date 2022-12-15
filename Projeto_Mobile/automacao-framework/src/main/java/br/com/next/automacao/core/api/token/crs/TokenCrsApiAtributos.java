package br.com.next.automacao.core.api.token.crs;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.json.simple.JSONObject;

public class TokenCrsApiAtributos {


    protected static Header[] obterHeadersGerarTokenCrs() {
        return new Header[] {
                new Header("ContentType", ContentType.JSON.toString()),
                new Header("Accept", ContentType.TEXT.toString()),
                new Header("channel", "MNCC"),
        };
    }

    protected static Header[] obterHeadersLogoffTokenCliente(String token) {
        return new Header[] {
                new Header("Authorization", "Basic ZGV2OmNhcGNv"),
                new Header("X-Next-AuthToken", token),
                new Header("ContentType", ContentType.JSON.toString()),
        };
    }

    protected static JSONObject obterCorpoRequisicaoGeralTokenCrs(String cpf, String user, String password) {

        /*
        Corpo da requisição, comum à geração do token e ao logoff.
         */

        JSONObject requisicao = new JSONObject();
        requisicao.put("agentId", user);
        requisicao.put("cpf", cpf);
        requisicao.put("password", password);
        requisicao.put("csrUserId", user);
        requisicao.put("host", "D4253E0227");
        requisicao.put("ticketId", "1235656");

        return requisicao;
    }

}

