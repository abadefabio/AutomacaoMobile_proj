package constantes.investimentos;

public enum Perfil {

    PERFIL_DESENQUADRADO("Perfil desenquadrado"),
    TEM_PERFIL_INVESTIDOR("Tem perfil de investidor"),
    SEM_PERFIL_INVESTIDOR("Sem perfil de investidor"),
    PERFIL_ULTRACONSERVADOR("ULTRACONSERVADOR");

    private String value;

    Perfil(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
