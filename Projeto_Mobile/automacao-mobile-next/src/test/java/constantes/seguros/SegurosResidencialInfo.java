package constantes.seguros;

public enum SegurosResidencialInfo {

    TEXTO_COBERTURAS("Coberturas"),
    TEXTO_ASSISTENCIAS("Assistências"),
    TEXTO_DADOS_DO_PARCEIRO("Dados do parceiro"),
    TEXTO_CANCELAMENTO("Cancelamento");

    private String value;

    SegurosResidencialInfo(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
