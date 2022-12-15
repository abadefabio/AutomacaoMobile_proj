package constantes.mimos;

public enum TituloTela {

    MIMOS("MIMOS"),
    AVALIAR_MIMO("AVALIAR MIMO");

    private String value;

    TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
