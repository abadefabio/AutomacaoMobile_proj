package constantes.seguros;

public enum SucessoCancelamento {
    TEXTO_SUCESSO_CANCELAMENTO("Recebemos seu pedido.");

    private String value;

    private SucessoCancelamento(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
