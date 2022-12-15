package constantes.seguros;

public enum SegurosDebito {
    //TODOS
    TITULO_TELA_PRODUTO_DEBITO("SEGUROS"),
    TITULO_TELA_LISTA_CONDICOES_GERAIS("CONDIÇÕES GERAIS"),
    TITULO_TELA_CONDICOES_GERAIS("CONDIÇÕES GERAIS"),
    TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO("SEGURO DÉBITO"),
    TITULO_TELA_RESUMO_DAS_COBERTURAS("RESUMO DAS COBERTURAS"),
    TITULO_TELA_SEGURO_COLETIVO_DE_PESSOAS("SEGURO COLETIVO"),
    TEXTO_NUMERO_PROTOCOLO ("Número do protocolo"),
    TEXTO_ATIVACAO("Agora é só aguardar a ativação"),
    TITULO_PRODUTO_VIGENTE ("SEGUROS");

    private String value;

    private SegurosDebito(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
