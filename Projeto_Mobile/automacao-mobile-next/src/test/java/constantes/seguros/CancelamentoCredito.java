package constantes.seguros;

public enum CancelamentoCredito {
    //TODOS
    TEXTO_CANCELAMENTO_1("Você tem certeza que voltará a contar com a sorte?"),
    TEXTO_CANCELAMENTO_2("Seu cartão foi roubado?"),
    TEXTO_CANCELAMENTO_3("Você sofreu um sequestro relampago?");

    private String value;

    private CancelamentoCredito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
