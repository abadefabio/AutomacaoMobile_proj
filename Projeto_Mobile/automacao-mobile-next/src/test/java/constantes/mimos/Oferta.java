package constantes.mimos;

public enum Oferta {
    DESCRICAO_OFERTA("XboxOne"),
    NUMERO_MAXIMO_CUPONS_UM("Você só pode gerar 1 cupons por promoção. Aproveite os outros mimos que o next preparou para você"),
    NUMERO_MAXIMO_CUPONS_CINCO("Você só pode gerar 5 cupons por promoção. Aproveite os outros mimos que o next preparou para você");

    private String value;

    Oferta(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
