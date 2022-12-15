package constantes.perfil.investidor;

public enum StatusPerfil {

    PERFIL_VENCIDO("PERFIL VENCIDO");

    private String value;

    StatusPerfil(String value) { this.value=value; }

    @Override
    public String toString() { return value; }

}
