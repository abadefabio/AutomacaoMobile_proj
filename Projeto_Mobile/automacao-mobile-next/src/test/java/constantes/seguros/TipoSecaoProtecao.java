package constantes.seguros;

public enum TipoSecaoProtecao {
    COBERTURA("Cobertura"),
    CARENCIA("Carência"),
    DADOS_DA_SEGURADORA("Dados da Seguradora"),
    //tela: protecao/detalhes
    INFORMACOES_SEGURO_FROM_DETALHES("INFORMAÇÕES DO SEGURO"),
    //tela: protecao/contratar/confirmacao de dados
    INFORMACOES_SEGURO_FROM_CONFIRMACAO_DADOS("INFORMAÇÕES DO SEGURO"),
    //tela: protecao/seção contratados
    CONTRATACAO("contratacao"),
    CANCELAMENTO("cancelamento"),
    INFORMACOES_SEGURO_FROM_CARD_CONTRATADO("Informações do seguro");

    private String value;

    private TipoSecaoProtecao(String value) {
        this.value = value;
    }
}
