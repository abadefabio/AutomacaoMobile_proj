package constantes.objetivos.aporte;

public enum MensagemConfirmacaoExclusaoAgedamentoAporte {

    MSG_CONFIRMACAO_EXCLUSAO ("Quer mesmo excluir a aplicação?");

    private String value;

    MensagemConfirmacaoExclusaoAgedamentoAporte(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
