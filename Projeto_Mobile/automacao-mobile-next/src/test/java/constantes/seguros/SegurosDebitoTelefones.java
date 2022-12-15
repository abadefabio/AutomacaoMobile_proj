package constantes.seguros;

public enum SegurosDebitoTelefones {
    //TODOS
    TEXTO_TELEFONES_1("0800 275 6398"),
    TEXTO_TELEFONES_2("0800 704 8383"),
    TEXTO_TELEFONES_3("0800 722 0099"),
    TEXTO_TELEFONES_4("0800 701 7000");

    private String value;

    SegurosDebitoTelefones(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
