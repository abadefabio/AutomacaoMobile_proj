package constantes.credito;

public enum JSONCredito {
    VALOR_LIMITE("valorLimite");

    private String value;
    private JSONCredito(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
