package constantes.configuracoes.perfil;

public enum FormaDePagamento {
    POR_BOLETO("Por Boleto"),
    POR_DEBITO_AUTOMATICO("Por Debito Automatico");

    private String value;

    FormaDePagamento(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
