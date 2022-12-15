package constantes.seguros;

public enum TipoSeguro {

    PARA_O_SEU_DIA_A_DIA("Para o seu dia a dia"),
    PARA_O_SEU_CARTAO("Para o seu cartão");

    private String value;

    TipoSeguro(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
