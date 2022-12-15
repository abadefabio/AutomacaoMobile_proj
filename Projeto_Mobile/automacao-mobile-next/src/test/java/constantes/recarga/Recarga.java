package constantes.recarga;

public enum Recarga {
    MENSAGEM_LIMITE_RECARGAS("Você atingiu o valor máximo pra recargas"),
    NOVO_NUMERO("Novo Número"),
    PRONTO("Pronto"),
    CONTINUAR("Continuar"),
    BUSCAR("Buscar"),
    SALVAR("Salvar"),
    CONTA_CORRENTE("Conta Corrente"),
    CONFIRMAR("Confirmar"),
    SALDO_INSUFICIENTE("Infelizmente não deu pra fazer a recarga, porque não tem saldo suficiente na sua conta."),
    GRANA_EMERGENCIA("grana de emergência?"),
    CONTATO_TELEFONE_INVALIDO("Você deve preencher o telefone com DDD"),
    MENSAGEM_NOME_INCOMPLETO("PRECISA SER O NOME COMPLETO"),
    MENSAGEM_CPF_INVALIDO("Você deve preencher o CPF"),
    MENSAGEM_ERRO_OPERADORA("Ei, o celular que você digitou é de outra operadora."),
    MENSAGEM_CONFIRMACAO_EXCLUSAO_NUMERO("Tem certeza que deseja excluir esse número de celular ?"),
    MENSAGEM_GRANA_EMERGENCIA("grana de emergência?"),
    NOME_CONTATO("Automacao Next"); // Next Automação

    private String value;

    private Recarga(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
