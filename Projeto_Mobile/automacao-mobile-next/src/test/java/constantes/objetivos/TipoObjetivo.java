package constantes.objetivos;

public enum TipoObjetivo {

    TIPO_OBJETIVO_CASA("Casa"),
    TIPO_OBJETIVO_CASAMENTO("Casamento"),
    TIPO_OBJETIVO_CELULAR("Celular"),
    TIPO_OBJETIVO_PRODUTO("Produto");




    private String value;

    private TipoObjetivo(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }

}
