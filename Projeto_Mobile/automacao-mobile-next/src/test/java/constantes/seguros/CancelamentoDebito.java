package constantes.seguros;

public enum CancelamentoDebito {
    TEXTO_CANCELAMENTO_1("Você tem certeza que voltará a contar com a sorte?"),
    TEXTO_CANCELAMENTO_2("Seu cartão foi roubado?"),
    TEXTO_CANCELAMENTO_3("Você sofreu um sequestro relampago?"),
    TEXTO_CANCELAMENTO_4("E ainda em caso de falecimento você conta");
    private String value;

    private CancelamentoDebito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
