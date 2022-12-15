package br.com.next.automacao.core.api.reset.cpf;

import io.restassured.http.Header;

public class ResetCpfApiAtributos {

    protected static Header[] obterHeadersRedefinirCpf(String cpf, String esteira, String token) {

        return new Header[] {
                new Header("X-Next-AuthToken", token),
                new Header("coreIp", esteira),
                new Header("cpf", cpf)
        };
    }
}

