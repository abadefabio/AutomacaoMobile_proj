package constantes.seguros;

public enum SegurosDebito {
    //TODOS
    TITULO_TELA_PRODUTO_DEBITO("SEGUROS"),
    TITULO_TELA_LISTA_CONDICOES_GERAIS("CONDI��ES GERAIS"),
    TITULO_TELA_CONDICOES_GERAIS("CONDI��ES GERAIS"),
    TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO("SEGURO D�BITO"),
    TITULO_TELA_RESUMO_DAS_COBERTURAS("RESUMO DAS COBERTURAS"),
    TITULO_TELA_SEGURO_COLETIVO_DE_PESSOAS("SEGURO COLETIVO"),
    TEXTO_NUMERO_PROTOCOLO ("N�mero do protocolo"),
    TEXTO_ATIVACAO("Agora � s� aguardar a ativa��o"),
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
