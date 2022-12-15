package constantes.recarga;

public enum Recarga {
    MENSAGEM_LIMITE_RECARGAS("Voc� atingiu o valor m�ximo pra recargas"),
    NOVO_NUMERO("Novo N�mero"),
    PRONTO("Pronto"),
    CONTINUAR("Continuar"),
    BUSCAR("Buscar"),
    SALVAR("Salvar"),
    CONTA_CORRENTE("Conta Corrente"),
    CONFIRMAR("Confirmar"),
    SALDO_INSUFICIENTE("Infelizmente n�o deu pra fazer a recarga, porque n�o tem saldo suficiente na sua conta."),
    GRANA_EMERGENCIA("grana de emerg�ncia?"),
    CONTATO_TELEFONE_INVALIDO("Voc� deve preencher o telefone com DDD"),
    MENSAGEM_NOME_INCOMPLETO("PRECISA SER O NOME COMPLETO"),
    MENSAGEM_CPF_INVALIDO("Voc� deve preencher o CPF"),
    MENSAGEM_ERRO_OPERADORA("Ei, o celular que voc� digitou � de outra operadora."),
    MENSAGEM_CONFIRMACAO_EXCLUSAO_NUMERO("Tem certeza que deseja excluir esse n�mero de celular ?"),
    MENSAGEM_GRANA_EMERGENCIA("grana de emerg�ncia?"),
    NOME_CONTATO("Automacao Next"); // Next Automa��o

    private String value;

    private Recarga(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
