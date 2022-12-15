package constantes.saldoextrato;

public enum Aba {

    SAIDA("SAÍDA"),
    ENTRADA("ENTRADA"),
    TODAS("TODAS"),
    FUTUROS("FUTUROS");

    private String value;

    private Aba(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
