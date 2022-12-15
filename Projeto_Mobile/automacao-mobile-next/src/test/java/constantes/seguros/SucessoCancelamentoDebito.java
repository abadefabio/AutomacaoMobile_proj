package constantes.seguros;

public enum SucessoCancelamentoDebito {
    TEXTO_SUCESSO_CANCELAMENTO("Recebemos seu pedido.");

    private String value;

    private SucessoCancelamentoDebito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
