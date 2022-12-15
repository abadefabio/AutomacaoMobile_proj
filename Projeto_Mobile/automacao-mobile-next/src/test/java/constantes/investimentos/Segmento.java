package constantes.investimentos;

public enum Segmento {

    CDB("CDB"),
    FUNDOS("Fundos"),
    POUPANCA("Poupança"),
    AGORA_INVESTIMENTOS("Ágora Investimentos");

    private String value;

    Segmento(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
