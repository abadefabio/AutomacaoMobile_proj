package constantes.pix;

public enum AjudaPix {

    AJUDA_PIX("AJUDA PIX");

    private String value;

    private AjudaPix(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
