package constantes.pagamentos;

public enum JSONPagamentos {

    CODIGO_DE_BARRA("codigoDeBarra"),
    DESCRICAO("descricao");


    private String value;
    private JSONPagamentos(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
