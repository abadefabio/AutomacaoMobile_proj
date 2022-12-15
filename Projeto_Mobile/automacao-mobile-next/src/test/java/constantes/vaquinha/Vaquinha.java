package constantes.vaquinha;

public enum Vaquinha {
    VALOR_MAIOR("Ops. Esse valor é maior"),
    QTDE_MAXIMA_VAQUINHAS("Você já criou 5 vaquinhas. Esse é o número máximo."),
    MENSAGEM_SUCESSO_CRIAR_CONTATO("Contato criado com sucesso ;)"),
    MENSAGEM_SUCESSO_ATUALIZAR_CONTATO("Contato atualizado com sucesso ;)"),
    MENSAGEM_SUCESSO_CONFIRMAR_ENVIO("Convites enviados com sucesso."),
    MENSAGEM_RECUSA_VAQUINHA("Você não vai mais saber dessa vaquinha."),
    MENSAGEM_EXCLUSAO_CONTATO("tá deletado ;)"),
    MENSAGEM_SUA_VAQUINHA_TA_PRONTA("Sua vaquinha tá pronta!"),
    MENSAGEM_CANCELAR_VAQUINHA("Você vai ter que devolver a grana"),
    MENSAGEM_VAQUINHA_CANCELADA("Vaquinha cancelada"),
    MENSAGEM_VAQUINHA_EXCLUIDA("Vaquinha Excluída"),
    MENSAGEM_SUCESSO_PAGAMENTO("Tudo certo com seu pagamento"),
    MENSAGEM_SUCESSO_EMAIL("Email enviado com sucesso");

    private String value;

    private Vaquinha(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
