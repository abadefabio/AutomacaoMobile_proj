package constantes.seguros;

public enum SegurosResidencialTelefones {

    TEXTO_TELEFONES_1("11 3003 1022"),
    TEXTO_TELEFONES_2("4004 2757"),
    TEXTO_TELEFONES_3("0800 701 2757"),
    TEXTO_TELEFONES_4("0800 727 9966");

    private String value;

    SegurosResidencialTelefones(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
