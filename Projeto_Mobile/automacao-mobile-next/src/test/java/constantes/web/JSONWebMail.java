package constantes.web;

public enum JSONWebMail {

    DOMINIO_USUARIO_EMAIL("dominioUsuarioEmail"),
    SENHA_EMAIL("senhaEmail");


    private String value;

    private JSONWebMail(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
