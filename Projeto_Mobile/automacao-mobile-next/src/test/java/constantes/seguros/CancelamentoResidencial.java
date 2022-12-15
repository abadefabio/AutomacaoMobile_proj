package constantes.seguros;

public enum CancelamentoResidencial {

    TEXTO_CANCELAMENTO_1("Você tem certeza que voltará a contar"),
    TEXTO_CANCELAMENTO_2("Precisou de um chaveiro,encanador,"),
    TEXTO_CANCELAMENTO_3("Chegou em casa e sua porta já estava aberta");
    private String value;

    private CancelamentoResidencial(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}

