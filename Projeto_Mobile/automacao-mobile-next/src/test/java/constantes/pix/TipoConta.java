package constantes.pix;

public enum TipoConta {
    CONTA_CORRENTE("Conta-corrente"),
    CONTA_POUPANCA("Conta-poupan�a");

    private String value;

    TipoConta(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
