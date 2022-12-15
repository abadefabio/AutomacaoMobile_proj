package constantes.mimos.web;

public enum LoginSistemaDeGestao {
    LOGIN("I901601"),
    SENHA("mai2022");

    private String value;

    LoginSistemaDeGestao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
