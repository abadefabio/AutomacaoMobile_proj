package dados.client.portal.massas.utils;

import java.util.stream.Stream;

public enum PortalMassasEnum {

    document("cpf"),
    accountNumber("conta"),
    bank("banco"),
    branch("agencia"),
    name("name"),
    surname("sobrenome"),
    contactDocument("cpfContato"),
    documentDependente("cpfDependente");

    private String value;

    PortalMassasEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Stream<PortalMassasEnum> stream() {
        return Stream.of(PortalMassasEnum.values());
    }
}
