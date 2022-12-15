package constantes.ajuda;

public enum EsqueciMinhaSenha {

    DIGITE_SEU_CPF_IOS("Digite seu CPF para mudar a senha"),
    DIGITE_SEU_CPF_ANDROID("Digite seu CPF para mudar a senha"),
    ENVIO_DE_CODIGO_IOS("Um c�digo"),
    ENVIO_DE_CODIGO_ANDROID("Um e-mail com c�digo"),
    REENVIO_DE_CODIGO("C�digo enviado novamente."),
    TUDO_DEU_CERTO_IOS("Sua senha nova j� t� valendo!"),
    TUDO_DEU_CERTO_ANDROID("Sua senha nova j� est� valendo!");

    private String value;

    EsqueciMinhaSenha(String value){
        this.value = value;

    }

    @Override
    public String toString(){
        return this.value;

    }
}
