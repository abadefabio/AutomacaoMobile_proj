package constantes.seguros;

public enum SegurosResidencialSimularNovamente {

    TEXTO_VANTAGENS_PRA_VOCE("Vantagens pra voc�"),
    TEXTO_PROTE��O_COMPLETA("Prote��o completa"),
    TEXTO_PAGAMENTO("Pagamento"),
    TEXTO_RESIDENCIA_SEGURADA("Resid�ncia segurada");

    private String value;

    SegurosResidencialSimularNovamente(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
