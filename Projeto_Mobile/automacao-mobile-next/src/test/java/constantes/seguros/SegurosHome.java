package constantes.seguros;

public enum SegurosHome {
    //TODOS
    SEGUROS("SEGUROS"),
    NOME_PRODUTO_DENTAL("Plano Dental"),
    NOME_PRODUTO_DEBITO("Seguro Débito"),
    NOME_PRODUTO_CREDITO("Seguro Crédito"),
    NOME_PRODUTO_RESIDENCIAL("Seguro Residencial"),
    NOME_PRODUTO_VIDA("Seguro de Vida"),
    TEXTO_CARD_ATIVO("Ativo"),
    TEXTO_ACESSE_SUA_CARTEIRINHA("Acesse sua carteirinha"),
    TITULO_HOME("SEGUROS");

    private String value;

    private SegurosHome(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
