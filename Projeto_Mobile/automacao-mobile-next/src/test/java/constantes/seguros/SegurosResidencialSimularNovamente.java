package constantes.seguros;

public enum SegurosResidencialSimularNovamente {

    TEXTO_VANTAGENS_PRA_VOCE("Vantagens pra você"),
    TEXTO_PROTEÇÃO_COMPLETA("Proteção completa"),
    TEXTO_PAGAMENTO("Pagamento"),
    TEXTO_RESIDENCIA_SEGURADA("Residência segurada");

    private String value;

    SegurosResidencialSimularNovamente(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
