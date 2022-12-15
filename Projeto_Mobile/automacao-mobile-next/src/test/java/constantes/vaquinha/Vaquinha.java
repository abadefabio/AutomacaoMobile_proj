package constantes.vaquinha;

public enum Vaquinha {
    VALOR_MAIOR("Ops. Esse valor � maior"),
    QTDE_MAXIMA_VAQUINHAS("Voc� j� criou 5 vaquinhas. Esse � o n�mero m�ximo."),
    MENSAGEM_SUCESSO_CRIAR_CONTATO("Contato criado com sucesso ;)"),
    MENSAGEM_SUCESSO_ATUALIZAR_CONTATO("Contato atualizado com sucesso ;)"),
    MENSAGEM_SUCESSO_CONFIRMAR_ENVIO("Convites enviados com sucesso."),
    MENSAGEM_RECUSA_VAQUINHA("Voc� n�o vai mais saber dessa vaquinha."),
    MENSAGEM_EXCLUSAO_CONTATO("t� deletado ;)"),
    MENSAGEM_SUA_VAQUINHA_TA_PRONTA("Sua vaquinha t� pronta!"),
    MENSAGEM_CANCELAR_VAQUINHA("Voc� vai ter que devolver a grana"),
    MENSAGEM_VAQUINHA_CANCELADA("Vaquinha cancelada"),
    MENSAGEM_VAQUINHA_EXCLUIDA("Vaquinha Exclu�da"),
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
