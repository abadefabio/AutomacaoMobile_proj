package constantes.open.finance;

public enum TituloTela {

    OPEN_FINANCE("OPEN FINANCE"),
    DADOS_QUE_EU_ENVIEI("DADOS QUE EU ENVIEI");

    private String value;

    private TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
