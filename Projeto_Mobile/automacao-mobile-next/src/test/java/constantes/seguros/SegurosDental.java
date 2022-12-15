package constantes.seguros;

public enum SegurosDental {

    TITULO_TELA_SEGUROS("SEGUROS"),
    TITULO_TELA_PRODUTO_DENTAL("PLANO DENTAL"),
    TITULO_TELA_DETALHES_PRODUTO("ATIVA��O E CAR�NCIA"),
    TITULO_TELA_LISTA_CONDICOES_GERAIS("CONDI��ES GERAIS"),
    TITULO_TELA_CONDICOES_GERAIS("CONDI��ES GERAIS"),
    TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO("PLANO DENTAL"),
    TEXTO_NUMERO_PROTOCOLO ("N�mero do protocolo"),
    TITULO_TELA_TELEFONES_UTEIS("Telefones �teis"),
    TITULO_TELA_VISAO_GERAL("VIS�O GERAL"),
    TITULO_TELA_MEUS_DOCUMENTOS("Meus Documentos");

    private String value;

    private SegurosDental(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
