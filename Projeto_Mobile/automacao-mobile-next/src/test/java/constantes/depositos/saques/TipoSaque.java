package constantes.depositos.saques;

public enum TipoSaque {
    PROPRIO("Próprio"),
    OUTRO_BENEFICIARIO("Outro Beneficiário");

    private String value;

    private TipoSaque(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}