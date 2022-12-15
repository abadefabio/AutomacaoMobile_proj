package constantes.seguros;

public enum CancelamentoDebito {
    TEXTO_CANCELAMENTO_1("Voc� tem certeza que voltar� a contar com a sorte?"),
    TEXTO_CANCELAMENTO_2("Seu cart�o foi roubado?"),
    TEXTO_CANCELAMENTO_3("Voc� sofreu um sequestro relampago?"),
    TEXTO_CANCELAMENTO_4("E ainda em caso de falecimento voc� conta");
    private String value;

    private CancelamentoDebito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
