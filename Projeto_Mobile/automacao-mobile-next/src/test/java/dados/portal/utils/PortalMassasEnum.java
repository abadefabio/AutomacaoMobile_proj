package dados.portal.utils;

import java.util.stream.Stream;

public enum PortalMassasEnum {

    CPF("cpf"),
    DOCUMENT("document"),
    ACCOUNT_NUMBER("conta"),
    BANK("banco"),
    BRANCH("agencia"),
    NAME("name"),
    SURNAME("sobrenome"),
    CONTACT_DOCUMENT("cpfContato"),
    DOCUMENT_DEPENDENT("cpfDependente");

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
