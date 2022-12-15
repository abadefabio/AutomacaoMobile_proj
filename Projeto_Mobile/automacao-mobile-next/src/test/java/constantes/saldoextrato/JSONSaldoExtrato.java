package constantes.saldoextrato;

public enum JSONSaldoExtrato {

    VALOR_EXTRATO("valorExtrato");

    private String value;
    private JSONSaldoExtrato(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
