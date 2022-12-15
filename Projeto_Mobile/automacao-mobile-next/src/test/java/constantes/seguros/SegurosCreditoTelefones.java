package constantes.seguros;

public enum SegurosCreditoTelefones {
    //TODOS
    TEXTO_TELEFONES_1("0800 275 6398"),
    TEXTO_TELEFONES_2("0800 727 9988"),
    TEXTO_TELEFONES_3("0800 722 0099"),
    TEXTO_TELEFONES_4("0800 727 9933");
    
    private String value;

    SegurosCreditoTelefones(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
