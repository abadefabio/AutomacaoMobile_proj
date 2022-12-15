package br.com.next.automacao.core.connections.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokenMobileCenter {

    private String client;
    private String secret;
    private Integer tenant;

}