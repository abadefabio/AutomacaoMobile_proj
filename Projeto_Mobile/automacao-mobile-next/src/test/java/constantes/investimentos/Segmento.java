package constantes.investimentos;

public enum Segmento {

    CDB("CDB"),
    FUNDOS("Fundos"),
    POUPANCA("Poupan�a"),
    AGORA_INVESTIMENTOS("�gora Investimentos");

    private String value;

    Segmento(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
