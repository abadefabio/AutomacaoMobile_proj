package constantes.mimos;

public enum Categoria {

    BELEZA("Beleza"),
    CELULAR("Celular"),
    AUTOMACAO("Automação"),
    FAVORITOS("Favoritos"),
    ESPECIAIS_PARA_VOCE("Especiais pra você");

    private String value;

    Categoria(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
