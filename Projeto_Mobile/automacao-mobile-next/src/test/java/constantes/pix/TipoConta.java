package constantes.pix;

public enum TipoConta {
    CONTA_CORRENTE("Conta-corrente"),
    CONTA_POUPANCA("Conta-poupança");

    private String value;

    TipoConta(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
