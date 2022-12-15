package constantes.saldoextrato;

public enum TituloTela {

    SALDO_EXTRATO("SALDO E EXTRATO");

    private String value;

    private TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
