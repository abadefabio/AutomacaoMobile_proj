package dados.utils;

import java.util.stream.Stream;


public enum PortalMassasEnum {

    DOCUMENT("cpf"),
    ACCOUNT_NUNBER("conta"),
    BANK("banco"),
    BRANCH("agencia"),
    NAME("name"),
    SURNAME("sobrenome"),
    CONTACT_DOCUMENT("cpfContato");

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
