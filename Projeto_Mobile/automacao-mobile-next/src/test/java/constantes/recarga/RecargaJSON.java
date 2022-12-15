package constantes.recarga;

public enum RecargaJSON {

    VALOR_RECARGA("valorRecarga");

    private String value;

    private RecargaJSON(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
