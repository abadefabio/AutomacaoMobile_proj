package constantes.pix;

public enum TipoContestacao {

    FUI_VITIMA_DE_GOLPE_AMEACA("Fui v�tima de golpe/amea�a");

    private String value;

    TipoContestacao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
