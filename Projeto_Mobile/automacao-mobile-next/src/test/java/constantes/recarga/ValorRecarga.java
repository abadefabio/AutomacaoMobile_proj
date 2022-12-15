package constantes.recarga;

public enum ValorRecarga {
    UM_REAL("R$ 1,00"),
    CINCO_REAIS("R$ 5,00"),
    DEZ_REAIS("R$ 10,00"),
    DOIS_MIL_REAIS("R$ 2.000,00"),
    DOIS_MIL_CINQUENTA_REAIS("R$ 2.050,00"),
    SETENTA_E_SETE_REAIS("R$ 77,00"),
    DOIS_MIL_DUZENTOS_REAIS("R$ 2.200,00");

    private String value;

    private ValorRecarga(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
