package constantes.pix;

public enum ChavesPix {

    CPF_CNPJ("CPF/CNPJ"),
    CPF("CPF"),
    EMAIL("E-mail"),
    CELULAR("Celular"),
    CHAVE_EMAIL_CONTA_CORRENTE("Chave e-mail na conta-corrente"),
    CHAVE_ALEATORIA("Chave aleatória"),
    CHAVE_ALEATORIA_CONTA_CORRENTE("Chave aleatória na conta-corrente"),
    CHAVE_ALEATORIA_CONTA_POUPANCA("Chave aleatória na conta-poupança"),
    AGENCIA_CONTA("Agência e Conta");

    private String value;

    ChavesPix(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
