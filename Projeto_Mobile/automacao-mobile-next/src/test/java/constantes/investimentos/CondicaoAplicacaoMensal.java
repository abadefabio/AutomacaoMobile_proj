package constantes.investimentos;

public enum CondicaoAplicacaoMensal {
    ATIVADO("Ativado"),
    DESATIVADO("Desativado");

    private String value;

    CondicaoAplicacaoMensal(String value) { this.value = value; }

    @Override
    public String toString() { return value; }
}
