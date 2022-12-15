package constantes.vaquinha;

public enum ValoresVaquinha {
    MAIOR_MAXIMO("6000000"),
    VALIDO("20000");

    private String value;

    private ValoresVaquinha(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}