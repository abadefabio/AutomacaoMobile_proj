package constantes.vaquinha;

public enum TituloTela {

    VAQUINHA("VAQUINHA"),
    EXCLUIR("EXCLUIR");

    private String value;

    TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
