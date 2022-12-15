package constantes.objetivos;

public enum TipoEdicao {

    EDICAO_PRAZO("Edição do prazo do Objetivo"),
    EDICAO_PRAZO_E_DIA("Edição do prazo e dia do Objetivo");



    private String value;

    private TipoEdicao(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }

}
