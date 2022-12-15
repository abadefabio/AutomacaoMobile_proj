package constantes.pix;

public enum MinhasChaves {
    CHAVE_ALEATORIA_CONTA_POUPANCA("Chave aleatória na conta-poupança");

    private final String value;

    MinhasChaves(String value) {

        this.value = value;
    }

    @Override
    public String toString() {

        return value;
    }
}
