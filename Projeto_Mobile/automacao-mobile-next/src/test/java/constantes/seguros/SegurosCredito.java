package constantes.seguros;

public enum SegurosCredito {
    //TODOS
    TITULO_TELA_PRODUTO_CREDITO("SEGUROS"),
    TITULO_TELA_PRODUTO_CREDITO_MEUS_SEGUROS("SEGURO CRÉDITO"),
    TITULO_TELA_LISTA_CONDICOES_GERAIS("CONDIÇÕES GERAIS"),
    TITULO_TELA_CONDICOES_GERAIS("CONDIÇÕES GERAIS"),
    TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO("SEGURO CRÉDITO"),
    TEXTO_NUMERO_PROTOCOLO ("Número do protocolo"),
    TITULO_CARD_CONTRATADO ("Seguro Crédito"),
    TITULO_PRODUTO_VIGENTE ("SEGUROS");

    private String value;

    private SegurosCredito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
