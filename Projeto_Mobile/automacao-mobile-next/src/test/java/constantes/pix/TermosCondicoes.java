package constantes.pix;

public enum TermosCondicoes {

    TEXTO_PIX("PIX");

    private String value;

    private TermosCondicoes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
