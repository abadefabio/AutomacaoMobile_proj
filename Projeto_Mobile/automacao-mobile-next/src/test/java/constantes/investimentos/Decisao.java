package constantes.investimentos;

public enum Decisao {

    PRIMEIRO_ACESSO("Primeiro Acesso"),
    JA_ACESSOU_SEM_INVESTIMENTOS("Ja acessou e não tem investimento"),
    JA_ACESSOU_COM_INVESTIMENTOS("Ja acessou e tem investimento");

    private String value;

    Decisao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
