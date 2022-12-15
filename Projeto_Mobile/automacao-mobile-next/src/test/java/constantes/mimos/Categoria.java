package constantes.mimos;

public enum Categoria {

    BELEZA("Beleza"),
    CELULAR("Celular"),
    AUTOMACAO("Automa��o"),
    FAVORITOS("Favoritos"),
    ESPECIAIS_PARA_VOCE("Especiais pra voc�");

    private String value;

    Categoria(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
