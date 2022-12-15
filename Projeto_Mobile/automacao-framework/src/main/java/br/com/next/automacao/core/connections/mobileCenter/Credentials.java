package br.com.next.automacao.core.connections.mobileCenter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
    private String type;

    private String name;

    private String description;

    private String creator;

    private String clientId;

    private String secret;

    private Integer tenant;

    private String activationDate;

    private String expirationDate;
}