package constantes.objetivos.aporte;

public enum TituloTelaAplicacaoCancelada {

    TITULO_TELA_APLICACAO_CANCELADA ("APLICAÇÃO CANCELADA");

    private String value;

    TituloTelaAplicacaoCancelada(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
