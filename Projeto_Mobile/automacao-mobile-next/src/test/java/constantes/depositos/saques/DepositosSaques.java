package constantes.depositos.saques;

public enum DepositosSaques {
    VALOR("5000000"),
    CEP("06472900"),
    AGENCIA("0001"),
    MENSAGEM_FERIADO("Ixi, essa data não vai dar."),
    MENSAGEM_SUCESSO("Agendamento realizado"),
    VALOR_MINIMO("7"),
    VALOR_MAXIMO("999999999"),
    MENSAGEM_SAQUE_VALOR_MINIMO("Ops. O valor m"),
    MENSAGEM_SAQUE_VALOR_MAXIMO("Ops. S"),
    MENSAGEM_EMAIL_ENVIADO("Comprovante enviado por e-mail"),
    MENSAGEM_CANCELAMENTO_SUCESSO("Pronto!  O agendamento  foi cancelado."),
    MENSAGEM_FORA_HORARIO("Só dá pra agendar das 00h ás 17h ;)"),
    MENSAGEM_INFORMACAO("Sempre que precisar movimentar valores mais altos," ),
    DO_BRADESCO_PARA_NEXT("do Bradesco pro next"),
    INFORMATIVO_OUTROS_BANCOS("Você só tem que usar esses dados pra mandar a grana pra sua conta no next."),
    MENSAGEM_CANCELAMENTO("Vai mesmo cancelar esse agendamento de saque?");

    private String value;

    private DepositosSaques(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
