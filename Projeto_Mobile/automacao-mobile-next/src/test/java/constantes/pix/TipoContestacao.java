package constantes.pix;

public enum TipoContestacao {

    FUI_VITIMA_DE_GOLPE_AMEACA("Fui vítima de golpe/ameaça");

    private String value;

    TipoContestacao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
