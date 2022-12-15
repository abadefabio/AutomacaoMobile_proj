package constantes.depositos.saques;

public enum TipoSaque {
    PROPRIO("Pr�prio"),
    OUTRO_BENEFICIARIO("Outro Benefici�rio");

    private String value;

    private TipoSaque(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}