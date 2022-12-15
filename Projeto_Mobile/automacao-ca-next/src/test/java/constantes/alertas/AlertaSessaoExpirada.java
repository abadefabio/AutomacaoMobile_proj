package constantes.alertas;

public enum AlertaSessaoExpirada {

    MENSAGEM_SESSAO_EXPIRADA("Sua sess�o expirou. Para continuar usando, � s� logar de novo");

    private String value;

    AlertaSessaoExpirada(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
