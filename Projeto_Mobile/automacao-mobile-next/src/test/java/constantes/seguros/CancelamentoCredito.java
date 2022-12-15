package constantes.seguros;

public enum CancelamentoCredito {
    //TODOS
    TEXTO_CANCELAMENTO_1("Voc� tem certeza que voltar� a contar com a sorte?"),
    TEXTO_CANCELAMENTO_2("Seu cart�o foi roubado?"),
    TEXTO_CANCELAMENTO_3("Voc� sofreu um sequestro relampago?");

    private String value;

    private CancelamentoCredito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
