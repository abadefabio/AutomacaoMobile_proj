package constantes.perfil;

public enum PerfilCliente {

    QA0286_PERFIL_CLIENTE("237-Next", "3750-8", "6148-4");

    private String bancoNome;
    private String agenciaDigito;
    private String contaDigito;


    PerfilCliente(String bancoNome, String agenciaDigito, String contaDigito) {
        this.agenciaDigito = agenciaDigito;
        this.contaDigito = contaDigito;
        this.bancoNome = bancoNome;

    }
    public String recuperarAgenciaDigito() {
        return this.agenciaDigito;
    }
    public String recuperarContaDigito() {
        return this.contaDigito;
    }
    public String recuperarBancoNome() {
        return this.bancoNome;
    }
}
