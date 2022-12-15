package constantes.alertas;

public enum AlertaSessaoExpirada {

    MENSAGEM_SESSAO_EXPIRADA("Sua sessão expirou. Para continuar usando, é só logar de novo");

    private String value;

    AlertaSessaoExpirada(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
