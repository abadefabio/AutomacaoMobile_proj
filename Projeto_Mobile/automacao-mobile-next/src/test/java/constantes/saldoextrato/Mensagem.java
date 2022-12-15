package constantes.saldoextrato;

public enum Mensagem {

    SALDO_ATUAL("SALDO ATUAL");

    private String value;

    private Mensagem(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
