package constantes.adesao;

public enum TipoCartao {

    VISA_NEXT_INTERNACIONAL("Visa Next Internacional"),
    VISA_NEXT_PLATINUM("Visa Next Platinum"),
    VISA_DEBITO("Visa Débito");


    private String value;

    TipoCartao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
