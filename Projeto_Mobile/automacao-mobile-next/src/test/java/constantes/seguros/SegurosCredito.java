package constantes.seguros;

public enum SegurosCredito {
    //TODOS
    TITULO_TELA_PRODUTO_CREDITO("SEGUROS"),
    TITULO_TELA_PRODUTO_CREDITO_MEUS_SEGUROS("SEGURO CR�DITO"),
    TITULO_TELA_LISTA_CONDICOES_GERAIS("CONDI��ES GERAIS"),
    TITULO_TELA_CONDICOES_GERAIS("CONDI��ES GERAIS"),
    TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO("SEGURO CR�DITO"),
    TEXTO_NUMERO_PROTOCOLO ("N�mero do protocolo"),
    TITULO_CARD_CONTRATADO ("Seguro Cr�dito"),
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
