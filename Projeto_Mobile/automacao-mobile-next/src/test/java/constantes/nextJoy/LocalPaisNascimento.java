package constantes.nextJoy;

public enum LocalPaisNascimento {
    BRASIL("SP-SAO PAULO");

    private String value;

    LocalPaisNascimento(String value) {

        this.value = value;
    }

    public String getValue() {

        return this.value;
    }
}
