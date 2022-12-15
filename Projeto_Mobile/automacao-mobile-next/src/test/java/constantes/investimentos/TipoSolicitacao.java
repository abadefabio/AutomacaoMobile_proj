package constantes.investimentos;

public enum TipoSolicitacao {
    APLICACAO("Aplicação"),
    RESGATE("Resgate");

    private String value;

    TipoSolicitacao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
