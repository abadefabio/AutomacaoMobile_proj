package constantes.seguros;

public enum SucessoCancelamentoCredito {
    //TODOS
    TEXTO_SUCESSO_CANCELAMENTO("Recebemos seu pedido.");

    private String value;

    private SucessoCancelamentoCredito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
