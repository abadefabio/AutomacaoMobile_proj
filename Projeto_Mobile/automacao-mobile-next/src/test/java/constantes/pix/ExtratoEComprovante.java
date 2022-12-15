package constantes.pix;

public enum ExtratoEComprovante {
    SETE_DIAS("7 DIAS"),
    QUINZE_DIAS("15 DIAS"),
    TRINTA_DIAS("30 DIAS");

    private String value;

    ExtratoEComprovante(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
