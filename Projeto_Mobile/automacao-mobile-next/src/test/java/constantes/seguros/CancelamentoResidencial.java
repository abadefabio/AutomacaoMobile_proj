package constantes.seguros;

public enum CancelamentoResidencial {

    TEXTO_CANCELAMENTO_1("Voc� tem certeza que voltar� a contar"),
    TEXTO_CANCELAMENTO_2("Precisou de um chaveiro,encanador,"),
    TEXTO_CANCELAMENTO_3("Chegou em casa e sua porta j� estava aberta");
    private String value;

    private CancelamentoResidencial(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}

