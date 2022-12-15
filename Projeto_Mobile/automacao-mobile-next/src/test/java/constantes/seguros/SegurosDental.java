package constantes.seguros;

public enum SegurosDental {

    TITULO_TELA_SEGUROS("SEGUROS"),
    TITULO_TELA_PRODUTO_DENTAL("PLANO DENTAL"),
    TITULO_TELA_DETALHES_PRODUTO("ATIVAÇÃO E CARÊNCIA"),
    TITULO_TELA_LISTA_CONDICOES_GERAIS("CONDIÇÕES GERAIS"),
    TITULO_TELA_CONDICOES_GERAIS("CONDIÇÕES GERAIS"),
    TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO("PLANO DENTAL"),
    TEXTO_NUMERO_PROTOCOLO ("Número do protocolo"),
    TITULO_TELA_TELEFONES_UTEIS("Telefones úteis"),
    TITULO_TELA_VISAO_GERAL("VISÃO GERAL"),
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
