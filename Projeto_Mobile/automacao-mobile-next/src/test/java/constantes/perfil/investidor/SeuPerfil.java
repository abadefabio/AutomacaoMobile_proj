package constantes.perfil.investidor;

public enum SeuPerfil {

    PERFIL_ARROJADO("Arrojado"),
    PERFIL_ULTRACONSERVADOR("Ultraconservador");

    private String value;

    SeuPerfil(String value) { this.value=value; }

    @Override
    public String toString() { return value; }

}
