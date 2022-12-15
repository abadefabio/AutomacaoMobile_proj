package constantes.pix;

public enum TipoLimite {

    DIARIO("Limite di�rio"),
    DIURNO("Diurno");

    private String value;

    TipoLimite(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
