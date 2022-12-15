package constantes.pix;

public enum ChavesPix {

    CPF_CNPJ("CPF/CNPJ"),
    CPF("CPF"),
    EMAIL("E-mail"),
    CELULAR("Celular"),
    CHAVE_EMAIL_CONTA_CORRENTE("Chave e-mail na conta-corrente"),
    CHAVE_ALEATORIA("Chave aleat�ria"),
    CHAVE_ALEATORIA_CONTA_CORRENTE("Chave aleat�ria na conta-corrente"),
    CHAVE_ALEATORIA_CONTA_POUPANCA("Chave aleat�ria na conta-poupan�a"),
    AGENCIA_CONTA("Ag�ncia e Conta");

    private String value;

    ChavesPix(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
