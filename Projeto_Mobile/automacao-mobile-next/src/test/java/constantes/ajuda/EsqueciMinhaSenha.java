package constantes.ajuda;

public enum EsqueciMinhaSenha {

    DIGITE_SEU_CPF_IOS("Digite seu CPF para mudar a senha"),
    DIGITE_SEU_CPF_ANDROID("Digite seu CPF para mudar a senha"),
    ENVIO_DE_CODIGO_IOS("Um código"),
    ENVIO_DE_CODIGO_ANDROID("Um e-mail com código"),
    REENVIO_DE_CODIGO("Código enviado novamente."),
    TUDO_DEU_CERTO_IOS("Sua senha nova já tá valendo!"),
    TUDO_DEU_CERTO_ANDROID("Sua senha nova já está valendo!");

    private String value;

    EsqueciMinhaSenha(String value){
        this.value = value;

    }

    @Override
    public String toString(){
        return this.value;

    }
}
