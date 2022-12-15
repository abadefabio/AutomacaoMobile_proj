package constantes.saldoextrato;

public enum CategoriaTransacao {

    INVESTIMENTO("Investimento"),
    AGENDAMENTO("Agendamento"),
    OBJETIVOS("Objetivos"),
    OUTROS_GASTOS("Outros Gastos"),
    OUTRAS_RENDAS("Outras Rendas");

    private String value;

    private CategoriaTransacao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
