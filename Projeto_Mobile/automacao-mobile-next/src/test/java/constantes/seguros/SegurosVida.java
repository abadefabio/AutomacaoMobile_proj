package constantes.seguros;

public enum SegurosVida {
    //TODOS
    TITULO_TELA_PRODUTO_VIDA("SEGUROS"),
    TITULO_TELA_DETALHES_INDENIZACAO("SEGURO DE VIDA"),
    TITULO_TELA_LISTA_TERMOS_CONDICOES ("CONDIÇÕES GERAIS"),
    TITULO_TELA_TERMOS_CONDICOES ("CONDIÇÕES GERAIS"),
    TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO("*******"),
    TITULO_TELA_SELECIONAR_OCUPACAO("*******"),
    TITULO_TELA_RECUSA_OCUPACAO("*******"),
    OCUPACAO_NAO_RISCO("ADVOGADO"),
    OCUPACAO_DE_RISCO("BOMBEIRO"),
    TEXTO_NUMERO_PROTOCOLO ("Número do protocolo");

    private String value;

    private SegurosVida(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
